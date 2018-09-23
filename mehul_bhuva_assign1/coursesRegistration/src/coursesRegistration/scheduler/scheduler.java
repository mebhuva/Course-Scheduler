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
	public HashMap<String, Student> sortHashMapByValue(HashMap<String, Student> stdhm) 
    { 
        List<Map.Entry<String, Student> > list = 
               new LinkedList<Map.Entry<String, Student> >(stdhm.entrySet()); 
        Collections.sort(list, new Comparator<Map.Entry<String, Student> >() { 
            public int compare(Map.Entry<String, Student> s1,  
                               Map.Entry<String, Student> s2) 
            { 
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
  
	public HashMap<String, Student> courseSchedular(HashMap<String, Student> studentdetails, ArrayList<Course> courselist) {
		int i = 0;
		studentdetails = sortHashMapByValue(studentdetails);
		while(i < 3) {
		for (Map.Entry  objstudentdetails : studentdetails.entrySet()) {
			Student objstudent = new Student();
			objstudent = (Student) objstudentdetails.getValue();
			ArrayList<String> preferences = new ArrayList<String>();
		    String student_level = null;
		    ArrayList<String> courseallocated = new ArrayList<String>();
			boolean wait = false;
			preferences = objstudent.getPreferences();
			courseallocated = objstudent.getCourseallocated();
			student_level = objstudent.getStudent_level();
			wait = objstudent.isWait();
			if(!(preferences.get(0).equalsIgnoreCase("E")) && !(preferences.get(0).equalsIgnoreCase("F")))
			{
				boolean capacity = true;
				for (Course objcourse : courselist) { 		      
			           if(objcourse.getCourseName().equalsIgnoreCase(preferences.get(0)))
			           {
			        	   if(objcourse.getCourseCapacity() >0 && courseallocated.size() < 3)
			        	   {
			        		   capacity = true;
			        		   objcourse.setCourseCapacity(objcourse.getCourseCapacity() - 1);
			        	   }
			        	   else
			        	   {
			        		   capacity = false;
			        	   }
			        	   if(objcourse.getCourseCapacity() == 0)
			        	   {
			        		   preferences.remove(0);
			        	   }
			           }
			      }
				if(capacity == true)
				{
					courseallocated.add(preferences.get(0));
					preferences.remove(0);
				}
			}
			else
			{
				objstudent.setWait(true);
			}
	        }
		for (Map.Entry  objstudentdetails : studentdetails.entrySet()) {
			Student objstudent = new Student();
			objstudent = (Student) objstudentdetails.getValue();
			ArrayList<String> preferences = new ArrayList<String>();
		    String student_level = null;
		    ArrayList<String> courseallocated = new ArrayList<String>();
			boolean wait = false;
			preferences = objstudent.getPreferences();
			courseallocated = objstudent.getCourseallocated();
			student_level = objstudent.getStudent_level();
			wait = objstudent.isWait();
			
			if(wait == true)
			{
				for (Course objcourse : courselist) { 		      
			           if(objcourse.getCourseName().equalsIgnoreCase(preferences.get(0)))
			           {
			        	   if(objcourse.getCourseCapacity() >0 && objstudent.getCourseallocated().size() < 3)
			        	   {
			        		   objcourse.setCourseCapacity(objcourse.getCourseCapacity() - 1);
			        		   courseallocated.add(preferences.get(0));
			        		   preferences.remove(0);
			        	   }
			        	   if(objcourse.getCourseCapacity() == 0)
			        	   {
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
