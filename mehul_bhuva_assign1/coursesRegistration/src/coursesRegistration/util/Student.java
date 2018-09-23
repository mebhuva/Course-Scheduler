package coursesRegistration.util;

import java.util.ArrayList;

public class Student {

	private String[] preferences = new String[6];
	private String student_level = null;
	ArrayList<String> courseallocated = new ArrayList<String>();
	public ArrayList<String> getCourseallocated() {
		return courseallocated;
	}
	public void setCourseallocated(ArrayList<String> courseallocated) {
		this.courseallocated = courseallocated;
	}
	public boolean wait = false;
	public boolean isWait() {
		return wait;
	}
	public void setWait(boolean wait) {
		this.wait = wait;
	}
	public String[] getPreferences() {
		return preferences;
	}
	public void setPreferences(String[] preferences) {
		this.preferences = preferences;
	}
	public String getStudent_level() {
		return student_level;
	}
	public void setStudent_level(String student_level) {
		this.student_level = student_level;
	}
}