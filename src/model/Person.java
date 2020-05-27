package model;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = -8219218627533074108L;

	private static int count = 0;
	
	private int id;
	private String name;
	private String indeks;
	private String course;
	private String teacher;
	private ModulCategory modulCategory;
	private SemesterCategory semCat;
	private String brojPoenaIkol;
	private String brojPoenaIIkol;
	private String examPoints;
	private CourseChoice courseChoice;
	private String allPoints;
	private String rating;
	
	public Person(String name, String indeks, String course, String teacher, ModulCategory modulCategory, SemesterCategory semCat, 
			String brojPoenaIkol, String brojPoenaIIkol, String examPoints, CourseChoice courseChoice, String allPoints, String rating){
		
		this.name = name;
		this.indeks = indeks;
		this.course = course;
		this.teacher = teacher;
		this.modulCategory = modulCategory;
		this.semCat = semCat;
		this.brojPoenaIkol = brojPoenaIkol;
		this.brojPoenaIIkol = brojPoenaIIkol;
		this.examPoints = examPoints;
		this.courseChoice = courseChoice;
		this.allPoints = allPoints;
		this.rating = rating;
		
		this.id = count;
		count++;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public ModulCategory getModulCategory() {
		return modulCategory;
	}
	public void setModulCategory(ModulCategory modulCategory) {
		this.modulCategory = modulCategory;
	}
	public SemesterCategory getSemCat() {
		return semCat;
	}
	public void setSemCat(SemesterCategory semCat) {
		this.semCat = semCat;
	}
	public String getBrojPoenaIkol() {
		return brojPoenaIkol;
	}
	public void setBrojPoenaIkol(String brojPoenaIkol) {
		this.brojPoenaIkol = brojPoenaIkol;
	}
	public String getBrojPoenaIIkol() {
		return brojPoenaIIkol;
	}
	public void setBrojPoenaIIkol(String brojPoenaIIkol) {
		this.brojPoenaIIkol = brojPoenaIIkol;
	}
	public String getExamPoints() {
		return examPoints;
	}
	public void setExamPoints(String examPoints) {
		this.examPoints = examPoints;
	}
	public CourseChoice getCourseChoice() {
		return courseChoice;
	}
	public void setCourseChoice(CourseChoice courseChoice) {
		this.courseChoice = courseChoice;
	}
	public String getAllPoints() {
		return allPoints;
	}
	public void setAllPoints(String allPoints) {
		this.allPoints = allPoints;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
}
