package coursesRegistration.util;

import java.util.ArrayList;

public class Student {

	private ArrayList<String> preferences = new ArrayList<String>();
	private String student_level = null;
	private ArrayList<String> courseallocated = new ArrayList<String>();
	private boolean wait = false;
	private Integer levelrank = 0; 
	public Student() {
	}
	public void setStudent(ArrayList<String> preferences, String student_level, ArrayList<String> courseallocated, boolean wait,
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
	public void setLevelrank(Integer levelrank) {
		this.levelrank = levelrank;
	}
	public ArrayList<String> getPreferences() {
		return preferences;
	}
	public void setPreferences(ArrayList<String> preferences) {
		this.preferences = preferences;
	}
	public ArrayList<String> getCourseallocated() {
		return courseallocated;
	}
	public void setCourseallocated(ArrayList<String> courseallocated) {
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