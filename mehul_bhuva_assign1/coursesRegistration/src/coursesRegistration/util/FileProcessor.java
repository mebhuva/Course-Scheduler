package coursesRegistration.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileProcessor {
	private File student_coursePref;
	private File courseInfo;
	private HashMap<String, Student> CourseRegistration = new HashMap<>();
	private ArrayList<Course> Courselist=new ArrayList<Course>();
	
	public FileProcessor(String[] args) {
		this.student_coursePref = new File(args[0]);
		this.courseInfo = new File(args[1]);
	}
	

	@Override
	public String toString() {
		return "FileProcessor [student_coursePref=" + student_coursePref + ", courseInfo=" + courseInfo
				+ ", CourseRegistration=" + CourseRegistration + ", Courselist=" + Courselist + "]";
	}

//method check the file exists or not 
	public int fileExists()
	{
			if(!student_coursePref.exists() || !courseInfo.exists())
			{
				return 0;
			}
			else
			{
				return 1;
			}
	}
	
	//readStudentData function returns student data
	public HashMap<String, Student> readStudentData() throws FileNotFoundException
	{
		
		 try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(student_coursePref);
			 while(sc.hasNextLine()){
		            String[] split = sc.nextLine().split(" ");
		            Student sd = new Student();
		            ArrayList<String> preferences = new ArrayList<String>();
		            preferences.add(split[1].replaceAll(",", ""));
		            preferences.add(split[2].replaceAll(",", ""));
		            preferences.add(split[3].replaceAll(",", ""));
		            preferences.add(split[4].replaceAll(",", ""));
		            preferences.add(split[5].replaceAll(",", ""));
		            preferences.add(split[6].replaceAll(";", ""));
		            sd.setPreferences(preferences);
		            String studentlevel = split[8];//student level added to sort student object based on priority
		            if(studentlevel.equalsIgnoreCase("FIRST_YEAR"))
		            	{
		            	sd.setLevelrank(3);
		            	}
		            else if(studentlevel.equalsIgnoreCase("SECOND_YEAR"))
		            {
		            	sd.setLevelrank(2);	
		            }
		            else if(studentlevel.equalsIgnoreCase("THIRD_YEAR"))
		            {
		            	sd.setLevelrank(1);
		            }
		            sd.setStudent_level(studentlevel);
		            CourseRegistration.put(split[0], sd); 
		        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally
			{
				
			}
		
		return CourseRegistration;
		
	}
	//readCourseData function returns Course data
	public ArrayList<Course> readCourseData() throws FileNotFoundException
	{
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(courseInfo);
			 while(sc.hasNextLine()){
				 String[] split = sc.nextLine().split("\\W");
				 Course objCourse = new Course();
				 objCourse.setCourseTime(Integer.parseInt(split[6]));
				 objCourse.setCourseCapacity(Integer.parseInt(split[2]));
				 objCourse.setCourseName(split[0]);
				 Courselist.add(objCourse);
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
		}
		return Courselist;
		
	}
	
}
