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

	/* sortHashMapByValue function is used to get sorted student data
	 *  based on student level third , second or first year
	 */
	public HashMap<String, Student> sortHashMapByValue(HashMap<String, Student> stdhm) {
		
		List<Map.Entry<String, Student>> list = new LinkedList<Map.Entry<String, Student>>(stdhm.entrySet());
		try {
			Collections.sort(list, new Comparator<Map.Entry<String, Student>>() {
				public int compare(Map.Entry<String, Student> s1, Map.Entry<String, Student> s2) {
					Student objstudent1 = new Student();
					objstudent1 = (Student) s1.getValue();
					Student objstudent2 = new Student();
					objstudent2 = (Student) s2.getValue();
					return objstudent1.getLevelrank().compareTo(objstudent2.getLevelrank());//return sorted data
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
		}
		HashMap<String, Student> temp = new LinkedHashMap<String, Student>();
		
		try {
			for (Map.Entry<String, Student> std : list) {
				temp.put(std.getKey(), std.getValue());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
		}
		return temp;
	}
	/* courseSchedular function is used to get student data with allocated courses*/
	public HashMap<String, Student> courseSchedular(HashMap<String, Student> studentdetails,
			ArrayList<Course> courselist) {
		int i = 0;
		studentdetails = sortHashMapByValue(studentdetails);
		//while loop need to parse 3 times to allocate 3 courses
		while (i < 3) {
			for (Map.Entry objstudentdetails : studentdetails.entrySet()) {
				Student objstudent = new Student();
				objstudent = (Student) objstudentdetails.getValue();
				ArrayList<String> preferences = new ArrayList<String>();
				String student_level = null;
				ArrayList<Course> courseallocated = new ArrayList<Course>();
				boolean wait = false;
				try {
					preferences = objstudent.getPreferences();
					courseallocated = objstudent.getCourseallocated();
					student_level = objstudent.getStudent_level();
					wait = objstudent.isWait();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					
				}
				//below if condition check if courses are not E and F then it will allocate courses to the student
				if (!(preferences.get(0).equalsIgnoreCase("E")) && !(preferences.get(0).equalsIgnoreCase("F"))) {
					try {
						boolean capacity = true;
						int coursecapacity = 0;
						boolean coursetimecheck = true;
						try {
							for (Course objcourse : courselist) {
								if (objcourse.getCourseName().equalsIgnoreCase(preferences.get(0))) {
									for (Course objcoursealoocated : courseallocated) {
										if (objcoursealoocated.getCourseTime() == objcourse.getCourseTime()) {
											coursetimecheck = false;
											preferences.remove(0);
										}
									}
									//below if condition checks if course have capacity or course allocation is not more than 3
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
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						finally
						{
							
						}
						if (capacity == true) {
							try {
								Course objCourse = new Course();
								objCourse.setCourseName(preferences.get(0));
								objCourse.setCourseTime(coursecapacity);
								courseallocated.add(objCourse);
								preferences.remove(0);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							finally
							{
								
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						
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
				
				try {
					preferences = objstudent.getPreferences();
					courseallocated = objstudent.getCourseallocated();
					student_level = objstudent.getStudent_level();
					wait = objstudent.isWait();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					
				}
//below wait variable tell us if student is waiting for the course E or F
				if (wait == true) {
					boolean coursetimecheck = true;
					try {
						for (Course objcourse : courselist) {
							if (objcourse.getCourseName().equalsIgnoreCase(preferences.get(0))) {
								for (Course objcoursealoocated : courseallocated) {
									if (objcoursealoocated.getCourseTime() == objcourse.getCourseTime()) {
										coursetimecheck = false;
										preferences.remove(0);
									}
								}
								//below if condition checks if course have capacity or course allocation is not more than 3
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
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						
					}
					wait = false;
				}
			}

			i++;
		}
		

		return studentdetails;

	}

}
