package coursesRegistration.util;

import java.util.ArrayList;

public class Student {

	private ArrayList<String> preferences = new ArrayList<String>();
	private String student_level = null;
	private ArrayList<Course> courseallocated = new ArrayList<Course>();
	private boolean wait = false;
	private Integer levelrank = 0; 
	public Student() {
	}
	public void setStudent(ArrayList<String> preferences, String student_level, ArrayList<Course> courseallocated, boolean wait,
			Integer levelrank) {
		this.preferences = preferences;
		this.student_level = student_level;
		this.courseallocated = courseallocated;
		this.wait = wait;
		this.levelrank = levelrank;
	}
	public Integer getLevelrank() {
		return levelrank;
	}
	@Override
	public String toString() {
		return "Student [preferences=" + preferences + ", student_level=" + student_level + ", courseallocated="
				+ courseallocated + ", wait=" + wait + ", levelrank=" + levelrank + "]";
	}
	public void setLevelrank(Integer levelrank) {
		this.levelrank = levelrank;
	}
	public ArrayList<String> getPreferences() {
		return preferences;
	}
	public void setPreferences(ArrayList<String> preferences) {
		this.preferences = preferences;
	}
	public ArrayList<Course> getCourseallocated() {
		return courseallocated;
	}
	public void setCourseallocated(ArrayList<Course> courseallocated) {
		this.courseallocated = courseallocated;
	}
	public boolean isWait() {
		return wait;
	}
	public void setWait(boolean wait) {
		this.wait = wait;
	}

	public String getStudent_level() {
		return student_level;
	}
	public void setStudent_level(String student_level) {
		this.student_level = student_level;
	}
}