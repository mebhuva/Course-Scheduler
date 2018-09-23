package coursesRegistration.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import coursesRegistration.util.Course;
import coursesRegistration.util.Student;

public class scheduler {
	@Override
	public String toString() {
		return "scheduler [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public HashMap<String, Student> sortHashMapByValue(HashMap<String, Student> stdhm) {
		List<Map.Entry<String, Student>> list = new LinkedList<Map.Entry<String, Student>>(stdhm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Student>>() {
			public int compare(Map.Entry<String, Student> s1, Map.Entry<String, Student> s2) {
				Student objstudent1 = new Student();
				objstudent1 = (Student) s1.getValue();
				Student objstudent2 = new Student();
				objstudent2 = (Student) s2.getValue();
				return objstudent1.getLevelrank().compareTo(objstudent2.getLevelrank());
			}
		});
		HashMap<String, Student> temp = new LinkedHashMap<String, Student>();
		for (Map.Entry<String, Student> std : list) {
			temp.put(std.getKey(), std.getValue());
		}
		return temp;
	}

	public HashMap<String, Student> courseSchedular(HashMap<String, Student> studentdetails,
			ArrayList<Course> courselist) {
		int i = 0;
		studentdetails = sortHashMapByValue(studentdetails);
		while (i < 3) {
			for (Map.Entry objstudentdetails : studentdetails.entrySet()) {
				Student objstudent = new Student();
				objstudent = (Student) objstudentdetails.getValue();
				ArrayList<String> preferences = new ArrayList<String>();
				String student_level = null;
				ArrayList<Course> courseallocated = new ArrayList<Course>();
				boolean wait = false;
				preferences = objstudent.getPreferences();
				courseallocated = objstudent.getCourseallocated();
				student_level = objstudent.getStudent_level();
				wait = objstudent.isWait();
				if (!(preferences.get(0).equalsIgnoreCase("E")) && !(preferences.get(0).equalsIgnoreCase("F"))) {
					boolean capacity = true;
					int coursecapacity = 0;
					boolean coursetimecheck = true;
					for (Course objcourse : courselist) {
						if (objcourse.getCourseName().equalsIgnoreCase(preferences.get(0))) {
							for (Course objcoursealoocated : courseallocated) {
								if (objcoursealoocated.getCourseTime() == objcourse.getCourseTime()) {
									coursetimecheck = false;
									preferences.remove(0);
								}
							}
							if (objcourse.getCourseCapacity() > 0 && courseallocated.size() < 3
									&& coursetimecheck == true) {
								capacity = true;
								objcourse.setCourseCapacity(objcourse.getCourseCapacity() - 1);
								coursecapacity = objcourse.getCourseTime();
							} else {
								capacity = false;
							}
							if (objcourse.getCourseCapacity() == 0) {
								preferences.remove(0);
							}
						}
					}
					if (capacity == true) {
						Course objCourse = new Course();
						objCourse.setCourseName(preferences.get(0));
						objCourse.setCourseTime(coursecapacity);
						courseallocated.add(objCourse);
						preferences.remove(0);
					}
				} else {
					objstudent.setWait(true);
				}
			}
			for (Map.Entry objstudentdetails : studentdetails.entrySet()) {
				Student objstudent = new Student();
				objstudent = (Student) objstudentdetails.getValue();
				ArrayList<String> preferences = new ArrayList<String>();
				String student_level = null;
				ArrayList<Course> courseallocated = new ArrayList<Course>();
				boolean wait = false;
				preferences = objstudent.getPreferences();
				courseallocated = objstudent.getCourseallocated();
				student_level = objstudent.getStudent_level();
				wait = objstudent.isWait();

				if (wait == true) {
					boolean coursetimecheck = true;
					for (Course objcourse : courselist) {
						if (objcourse.getCourseName().equalsIgnoreCase(preferences.get(0))) {
							for (Course objcoursealoocated : courseallocated) {
								if (objcoursealoocated.getCourseTime() == objcourse.getCourseTime()) {
									coursetimecheck = false;
									preferences.remove(0);
								}
							}
							if (objcourse.getCourseCapacity() > 0 && objstudent.getCourseallocated().size() < 3
									&& coursetimecheck == true) {
								objcourse.setCourseCapacity(objcourse.getCourseCapacity() - 1);
								Course objCourse = new Course();
								objCourse.setCourseName(preferences.get(0));
								objCourse.setCourseTime(objcourse.getCourseTime());
								courseallocated.add(objCourse);
								preferences.remove(0);
							}
							if (objcourse.getCourseCapacity() == 0) {
								preferences.remove(0);
							}
						}
					}
					wait = false;
				}
			}

			i++;
		}

		return studentdetails;

	}

}
