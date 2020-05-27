package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;

public class MainFrame extends JFrame {
	
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel tablePanel;
	
	public MainFrame() {
		super("eDnevnik"); //prikaz imena aplikacija na statusnoj liniji
		
		setLayout(new BorderLayout());
		
		formPanel = new FormPanel();
		tablePanel = new TablePanel();
		controller = new Controller();
		fileChooser = new JFileChooser();
		
		tablePanel.setData(controller.getPeople()); //stavljanje podataka u tabelu
		
		// brisanje bilo kod reda u tabeli
		tablePanel.setPersonTableListener(new PersonTableListener(){
			public void rowDeleted(int row){
				controller.removePerson(row);
			}
		});
		
		//biranje fajla sa odgovarajucom ekstenzijom
		fileChooser.addChoosableFileFilter(new PersonFileFilter()); 
		
		setJMenuBar(createMenuBar()); //postavljanje padajucceg menija File
		
		// azuriranje tabele svaki put kada se doda novi red
		formPanel.setFormListener(new FormListener(){
			public void formEventOccurred(FormEvent e){
				controller.addPerson(e);	
				tablePanel.refresh();
			}
		});
		
		// postavljanje UI na levoj strani glavnog prozora
		add(formPanel, BorderLayout.WEST);
		
		// postavljanje tabele na sredini glavnog prozora
		add(tablePanel, BorderLayout.CENTER);
		
		
		setMinimumSize(new Dimension(500, 400)); ///minimalna dimenzija prozora
		setSize(900, 700); //inicijalna dimenzija prozora
		
		//standardno zatvaranje prozora klikom na x
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setVisible(true); //prikaz prozora na ekranu
	}

	// metoda za kreiranje padajuceg menija
	private JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem saveDataItem = new JMenuItem("Save");
		JMenuItem openDataItem = new JMenuItem("Open");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		fileMenu.add(saveDataItem);
		fileMenu.add(openDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		
		// precica za izlaz (ctrl+x)
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		// precica za open (ctrl+o)
		openDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		// precica za save (ctrl+s)
		saveDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		// ucitavanje tabele
		openDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					try {
						controller.loadFromFile(fileChooser.getSelectedFile());
						tablePanel.refresh();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, 
								"Cloud not load data from file.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		// snimanje tabele
		saveDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					try {
						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, 
								"Cloud not save data to file.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		// izlaz iz aplikacije
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Da li zaista zelite da zatvorite aplikaciju?", "Potvrdi", JOptionPane.OK_CANCEL_OPTION);
				
				if(action == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});	
		return menuBar;
	}
}
