package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;
import model.SemesterCategory;

public class PersonTableModel extends AbstractTableModel {
	
	private List<Person> db;
	
	private String[] colNames = {"ID", "Ime i prezime", "Broj indeksa", "Predmet", "Profesor", "Smer", "Semestar", 
			"Tip predmeta", "Bodova - I kol", "Bodova - II kol", "Bodova - Ispit", "Ocena"};
	
	public String getColumnName(int column) {
		return colNames[column];
	}

	public boolean isCellEditable(int row, int col) {
		
		switch(col){
		case 0:
			return true;
		case 1:
			return true;
		case 2:
			return true;
		case 3:
			return true;
		case 4:
			return true;
		case 6:
			return true;
		default:
			return false;
		}
	}

	public void setValueAt(Object value, int row, int col) {
		
		if(db == null) return;
		
		Person person = db.get(row);
		
		switch(col) {
		case 0:
			person.setId((Integer)value);
			break;
		case 1:
			person.setName((String)value);
			break;
		case 2:
			person.setIndeks((String)value);
			break;
		case 3:
			person.setCourse((String)value);
			break;
		case 4:
			person.setTeacher((String)value);
			break;
		case 6:
			person.setSemCat((SemesterCategory)value);
			break;
		default:
			return;
		}
	}
	
	public Class<?> getColumnClass(int col) {
		
		switch(col){
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return SemesterCategory.class;
		case 7:
			return String.class;
		case 8:
			return String.class;
		case 9:
			return String.class;
		case 10:
			return String.class;
		case 11:
			return String.class;
		default:
			return null;
		}
	}

	public void setData(List<Person> db) {
		this.db = db;
	}

	public int getRowCount() {
		
		return db.size();
	}

	public int getColumnCount() {
		
		return 12;
	}

	public Object getValueAt(int row, int col) {
		
		Person person = db.get(row);
		
		switch(col){
		case 0:
			return person.getId();
		case 1:
			return person.getName();
		case 2:
			return person.getIndeks();
		case 3:
			return person.getCourse();
		case 4:
			return person.getTeacher();
		case 5:
			return person.getModulCategory();
		case 6:
			return person.getSemCat();
		case 7:
			return person.getCourseChoice();
		case 8:
			return person.getBrojPoenaIkol();
		case 9:
			return person.getBrojPoenaIIkol();
		case 10:
			return person.getExamPoints();
		case 11:
			return person.getRating();
		}
		
		return null;
	}
}