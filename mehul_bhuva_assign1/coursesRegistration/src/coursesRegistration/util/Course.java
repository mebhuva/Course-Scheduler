package coursesRegistration.util;

public class Course {

	private String CourseName = null;
	private int CourseCapacity = 0;
	private int CourseTime = 0;
	public Course() {
	}
	public void setCourse(String courseName, int courseCapacity, int courseTime) {
		CourseName = courseName;
		CourseCapacity = courseCapacity;
		CourseTime = courseTime;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getCourseCapacity() {
		return CourseCapacity;
	}
	public void setCourseCapacity(int courseCapacity) {
		CourseCapacity = courseCapacity;
	}
	public int getCourseTime() {
		return CourseTime;
	}
	public void setCourseTime(int courseTime) {
		this.CourseTime = courseTime;
	}
}
