package coursesRegistration.util;

public class Student {

	private String[] preferences = new String[6];
	private String student_level = null;
	public String[] courseallocated = new String[3];
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
	public String[] getCourseallocated() {
		return courseallocated;
	}
	public void setCourseallocated(String[] courseallocated) {
		this.courseallocated = courseallocated;
	}
	
}