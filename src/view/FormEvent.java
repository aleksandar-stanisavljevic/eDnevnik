package view;
import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String indeks;
	private String course;
	private String teacher;
	private int modulCategory;
	private String semCat;
	private String brojPoenaIkol;
	private String brojPoenaIIkol;
	private String examPoints;
	private String courseChoice;
	private String allPoints;
	private String rating;

	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String indeks, String course, String teacher, int modulCat, String semCat, String brojPoenaIkol,
			 String brojPoenaIIkol, String examPoints, String courseChoice, String allPoints, String rating) {
		super(source);
		
		this.name = name;
		this.indeks = indeks;
		this.course = course;
		this.teacher = teacher;
		this.modulCategory = modulCat;
		this.semCat = semCat;
		this.brojPoenaIkol = brojPoenaIkol;
		this.brojPoenaIIkol = brojPoenaIIkol;
		this.examPoints = examPoints;
		this.courseChoice = courseChoice;
		this.allPoints = allPoints;
		this.rating = rating;		
	}

	public String getCourseChoice() {
		return courseChoice;
	}

	public String getBrojPoenaIkol() {
		return brojPoenaIkol;
	}
	
	public String getBrojPoenaIIkol() {
		return brojPoenaIIkol;
	}
	
	public String getExamPoints() {
		return examPoints;
	}
	
	public String getAllPoints() {
		return allPoints;
	}
	
	public String getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	public int getModulCategory(){
		return modulCategory;
	}
	
	public String getSemesterCategory(){
		return semCat;
	}
}
