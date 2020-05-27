package model;

public enum SemesterCategory {

	I("I"),
	II("II"),
	III("III"),
	IV("IV"),
	V("V"),
	VI("VI"),
	VII("VII"),
	VIII("VIII"),
	IX("IX"),
	X("X");
	
	private String text;
	
	private SemesterCategory(String text){
		this.text = text;
	}

	public String toString() {
		return text;
	}
}
