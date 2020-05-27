package view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.jdesktop.swingx.prompt.PromptSupport;

public class FormPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel indeksLabel;
	private JTextField nameField;
	private JTextField indeksField;
	private JLabel courseLabel;
	private JTextField courseField;
	private JLabel teacherLabel;
	private JTextField teacherField;
	private JButton okBtn; 
	private JButton solveBtn; 
	private FormListener formListener;
	private JList modulList;
	private JComboBox semCombo;
	private JTextField kolIField;
	private JTextField kolIIField;
	private JTextField examField;
	private JLabel allPointsLabel;
	private JTextField allPointsField;
	private JLabel ratingLabel;
	private JTextField ratingField;
	
	private JRadioButton mandatoryRadio;
	private JRadioButton electiveRadio;
	private ButtonGroup courseGroup;
	
	public FormPanel() {
		
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Student: ");
		nameField = new JTextField(10);
		indeksLabel = new JLabel("Broj indeksa: ");
		indeksField = new JTextField(10);
		courseLabel = new JLabel("Ime predmeta: ");
		courseField = new JTextField(10);
		teacherLabel = new JLabel("Profesor: ");
		teacherField = new JTextField(10);
		modulList = new JList();
		semCombo = new JComboBox();
		kolIField = new JTextField(10);
		PromptSupport.setPrompt("Broj poena", kolIField);
		kolIIField = new JTextField(10);
		PromptSupport.setPrompt("Broj poena", kolIIField);
		examField = new JTextField(10);
		PromptSupport.setPrompt("Broj poena", examField);
		allPointsLabel = new JLabel("Ukupno poena: ");
		allPointsField = new JTextField(10);
		ratingLabel = new JLabel("Ocena: ");
		ratingField = new JTextField(10);
		okBtn = new JButton("OK");
		solveBtn = new JButton("Izracunaj");
		nameLabel.setLabelFor(nameField);
		mandatoryRadio = new JRadioButton("obavezni");
		electiveRadio = new JRadioButton("izborni");
		
		mandatoryRadio.setActionCommand("obavezni");
		electiveRadio.setActionCommand("izborni");
		
		courseGroup = new ButtonGroup();
		
		mandatoryRadio.setSelected(true);
		
		courseGroup.add(mandatoryRadio);
		courseGroup.add(electiveRadio);
		
		solveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  float pointsKolI = 0, pointsKolII = 0, pointsExam = 0, solvePointsAll;
			  
			  if(e.getSource() == solveBtn){
				  try { 
					  pointsKolI = Float.parseFloat(kolIField.getText());
				  } catch(NumberFormatException ed) {  
				  }
				  solvePointsAll = pointsKolI;
				  try { 
					  pointsKolII = Float.parseFloat(kolIIField.getText());
				  } catch(NumberFormatException ed) { 	
				  }
				  solvePointsAll = pointsKolI + pointsKolII;
				  try { 
					  pointsExam = Float.parseFloat(examField.getText());
				  } catch(NumberFormatException ed) { 
				  }
				  solvePointsAll = pointsKolI + pointsKolII + pointsExam;
			   
				  if(solvePointsAll <= 55 && solvePointsAll >= 0){
					  ratingField.setText(String.valueOf("nije polozio" + " - (" + solvePointsAll + ")")); 
				  }
				  else if(solvePointsAll > 55 && solvePointsAll <= 65){
					  ratingField.setText(String.valueOf(6 + " (sest)" + " - (" + solvePointsAll + ")")); 
				  }
				  else if(solvePointsAll > 65 && solvePointsAll <= 75){
					  ratingField.setText(String.valueOf(7 + " (sedam)" + " - (" + solvePointsAll + ")")); 
				  }
				  else if(solvePointsAll > 75 && solvePointsAll <= 85){
					  ratingField.setText(String.valueOf(8 + " (osam)" + " - (" + solvePointsAll + ")")); 
				  }
				  else if(solvePointsAll > 85 && solvePointsAll <= 95){
					  ratingField.setText(String.valueOf(+9 + " (devet)" + " - (" + solvePointsAll + ")")); 
				  }
				  else if(solvePointsAll > 95 && solvePointsAll <= 100){
					  ratingField.setText(String.valueOf(10 + " (deset)" + " - (" + solvePointsAll + ")")); 
				  }
				  else{
					  ratingField.setText(String.valueOf("Greska")); 
				  }
			   
				  if(solvePointsAll < 0 || solvePointsAll > 100) {
					  allPointsField.setText(String.valueOf("Greska")); 
				  } 
				  else{
					  allPointsField.setText(String.valueOf(solvePointsAll)); 
				  }
			   }
			  }
			}
		);
		
		//dodavanje liste za smer
		DefaultListModel modulModel = new DefaultListModel();
		modulModel.addElement(new ModulCategory(0, "PM"));
		modulModel.addElement(new ModulCategory(1, "MKM"));
		modulModel.addElement(new ModulCategory(2, "MVM"));
		modulModel.addElement(new ModulCategory(3, "EPT"));
		modulModel.addElement(new ModulCategory(4, "PMAU"));
		modulModel.addElement(new ModulCategory(5, "II"));
		modulModel.addElement(new ModulCategory(6, "InfI"));
		modulModel.addElement(new ModulCategory(7, "DS"));
		modulList.setModel(modulModel);
		
		modulList.setPreferredSize(new Dimension(110,150));
		modulList.setBorder(BorderFactory.createEtchedBorder());
		modulList.setSelectedIndex(0);
		
		//dodavanje liste izbora za semestar
		DefaultComboBoxModel semModel = new DefaultComboBoxModel();
		semModel.addElement("I");
		semModel.addElement("II");
		semModel.addElement("III");
		semModel.addElement("IV");
		semModel.addElement("V");
		semModel.addElement("VI");
		semModel.addElement("VII");
		semModel.addElement("VIII");
		semModel.addElement("IX");
		semModel.addElement("X");
		semCombo.setModel(semModel);
		semCombo.setSelectedIndex(0);
		semCombo.setEditable(true);
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String indeks = indeksField.getText();
				String course = courseField.getText();
				String teacher = teacherField.getText();
				ModulCategory modulCat = (ModulCategory)modulList.getSelectedValue();
				String semCat = (String)semCombo.getSelectedItem(); 
				String brojIkol = kolIField.getText();
				String brojIIkol = kolIIField.getText();
				String exampPoints = examField.getText();
				String allPoints = allPointsField.getText();
				String rating = ratingField.getText();
				String courseChoice = courseGroup.getSelection().getActionCommand();
				
				FormEvent ev = new FormEvent(this, name, indeks, course, teacher, modulCat.getId(), semCat, 
						brojIkol, brojIIkol, exampPoints, courseChoice, allPoints, rating);
				
				if (formListener != null){
					formListener.formEventOccurred(ev);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Dodaj studenta");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents();
	}
	
	public void layoutComponents(){
	
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// polje za ime
		gc.gridy = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gc);
		
		// polje za indeks
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(indeksLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(indeksField, gc);
		
		// polje za predmet
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(courseLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(courseField, gc);
		
		// polje za profesora
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(teacherLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(teacherField, gc);
		
		// polje za tip predmeta
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.05;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Tip predmeta: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(mandatoryRadio, gc);
		
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(electiveRadio, gc);
		
		// polje za listu smerova
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Smer: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(modulList, gc);
		
		// polje za listu semestra
		gc.gridy++;
				
		gc.weightx = 1;
		gc.weighty = 0.2;
				
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Semestar: "), gc);
				
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(semCombo, gc);
				
		// polje za I kolokvijum
		gc.gridy++;
				
		gc.weightx = 1;
		gc.weighty = 0.2;
				
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("I kolokvijum: "), gc);
				
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(kolIField, gc);
				
		// polje za II kolokvijum
		gc.gridy++;
				
		gc.weightx = 1;
		gc.weighty = 0.2;
				
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("II kolokvijum: "), gc);
				
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(kolIIField, gc);
				
		// polje za zavrsni ispit
		gc.gridy++;
				
		gc.weightx = 1;
		gc.weighty = 0.2;
				
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Ispit: "), gc);
			
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(examField, gc);
		
		// polje za ukupan broj poena
		gc.gridy++;
						
		gc.weightx = 1;
		gc.weighty = 0.2;
						
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(allPointsLabel, gc);
					
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(allPointsField, gc);
				
		// polje za ocenu
		gc.gridy++;
						
		gc.weightx = 1;
		gc.weighty = 0.2;
						
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(ratingLabel, gc);
					
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(ratingField, gc);
		
		// dugme za racunanje
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(solveBtn, gc);
		
		// ok dugme
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gc);
		
	}
	
	public void setFormListener(FormListener listener){
		this.formListener = listener;
	}
}

class ModulCategory{
	
	private int id;
	private String text;
	
	public ModulCategory(int id, String text){
		this.id = id;
		this.text = text;
	}
	
	public String toString(){
		return text;
	}
	
	public int getId(){
		return id;
	}
}
