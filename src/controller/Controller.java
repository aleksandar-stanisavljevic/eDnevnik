package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import model.ModulCategory;
import model.Database;
import model.SemesterCategory;
import view.FormEvent;
import model.CourseChoice;
import model.Person;

public class Controller {
	
	Database db = new Database();
	
	public List<Person> getPeople(){
		return db.getPeople();
	}
	
	public void removePerson(int index){
		db.removePerson(index);
	}

	public void addPerson(FormEvent ev){
	
		String name = ev.getName();
		String indeks = ev.getIndeks();
		String course = ev.getCourse();
		String teacher = ev.getTeacher();
		int modulCatId = ev.getModulCategory();
		String semCat = ev.getSemesterCategory();
		String brojPoenaIkol = ev.getBrojPoenaIkol();
		String brojPoenaIIkol = ev.getBrojPoenaIIkol();
		String examPoints = ev.getExamPoints();
		String courseChoice = ev.getCourseChoice();
		String allPoints = ev.getAllPoints();
		String rating = ev.getRating();
		
		ModulCategory modulCategory = null;
		
		switch(modulCatId){
		case 0:
			modulCategory = ModulCategory.PM;
			break;
		case 1:
			modulCategory = ModulCategory.MKM;
			break;
		case 2:
			modulCategory = ModulCategory.MVM;
			break;
		case 3:
			modulCategory = ModulCategory.EPT;
			break;
		case 4:
			modulCategory = ModulCategory.PMAU;
			break;
		case 5:
			modulCategory = ModulCategory.II;
			break;
		case 6:
			modulCategory = ModulCategory.InfI;
			break;
		case 7:
			modulCategory = ModulCategory.DS;
			break;
		}
		
		SemesterCategory semCategory = null;
		
		if(semCat.equals("I")){
			semCategory = SemesterCategory.I;
		}
		else if(semCat.equals("II")){
			semCategory = SemesterCategory.II;
		}
		else if(semCat.equals("III")){
			semCategory = SemesterCategory.III;
		}
		else if(semCat.equals("IV")){
			semCategory = SemesterCategory.IV;
		}
		else if(semCat.equals("V")){
			semCategory = SemesterCategory.V;
		}
		else if(semCat.equals("VI")){
			semCategory = SemesterCategory.VI;
		}
		else if(semCat.equals("VII")){
			semCategory = SemesterCategory.VII;
		}
		else if(semCat.equals("VIII")){
			semCategory = SemesterCategory.VIII;
		}
		else if(semCat.equals("IX")){
			semCategory = SemesterCategory.IX;
		}
		else if(semCat.equals("X")){
			semCategory = SemesterCategory.X;
		}	
		
		CourseChoice courseChoiceCat;
		
		if(courseChoice.equals("obavezni")){
			courseChoiceCat = CourseChoice.obavezni;
		}
		else {
			courseChoiceCat = CourseChoice.izborni;
		}
		
		Person person = new Person(name, indeks, course, teacher, modulCategory, semCategory, brojPoenaIkol, 
				brojPoenaIIkol, examPoints, courseChoiceCat, allPoints, rating);
		
		db.addPerson(person);
	}
	
	public void saveToFile(File file) throws IOException{
		db.saveToFile(file);
	}
	
	public void loadFromFile(File file) throws IOException{
		db.loadFromFile(file);
	}
}
