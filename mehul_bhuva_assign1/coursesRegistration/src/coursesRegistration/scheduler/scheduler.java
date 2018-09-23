package coursesRegistration.scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import coursesRegistration.util.Course;
import coursesRegistration.util.Student;

public class scheduler {

	public HashMap<String, Student> courseSchedular(HashMap<String, Student> studentdetails, ArrayList<Course> courselist) {
		
		for (Map.Entry  objstudentdetails : studentdetails.entrySet()) {
			Student objstudent = new Student();
			objstudent = (Student) objstudentdetails.getValue();
			String[] preferences = new String[6];
		    String student_level = null;
		    ArrayList<String> courseallocated = new ArrayList<String>();
			boolean wait = false;
			preferences = objstudent.getPreferences();
			courseallocated = objstudent.getCourseallocated();
			student_level = objstudent.getStudent_level();
			wait = objstudent.isWait();
			if(!preferences[0].equalsIgnoreCase("E") && !preferences[0].equalsIgnoreCase("F"))
			{
				boolean capacity = true;
				for (Course objcourse : courselist) { 		      
			           if(objcourse.getCourseName().equalsIgnoreCase(preferences[0]))
			           {
			        	   if(objcourse.getCourseCapacity() >0)
			        	   {
			        		   capacity = true;
			        	   }
			        	   else
			        	   {
			        		   capacity = false;
			        	   }
			           }
			      }
				if(capacity == true)
				{
					courseallocated.add(preferences[0]);
				}
			}
			else
			{
				objstudent.setWait(true);
			}
			
			
	          //System.out.println("Key: "+objstudentdetails.getKey() + " & Value: " + objstudentdetails.getValue());
	        }
		
		
		
		
		
		return studentdetails;
		
		
	}

	
	
}
