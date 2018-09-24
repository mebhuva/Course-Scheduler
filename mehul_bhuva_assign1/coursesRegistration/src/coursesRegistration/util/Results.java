package coursesRegistration.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	@Override
	public String toString() {
		return "Results [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
//writing student name and allocated courses output on console
	@Override
	public void writeconsole(HashMap<String, Student> studentdetails) {
		
		try {
			//iterating through student detail hashmap 
			for (Map.Entry objstudentdetails : studentdetails.entrySet()) {
				Student objstudent = new Student();
				objstudent = (Student) objstudentdetails.getValue();
				ArrayList<Course> courseallocated = new ArrayList<Course>();
				courseallocated = objstudent.getCourseallocated();
				System.out.println("Student_Name : "+ objstudentdetails.getKey()+"  Course 1 : " +courseallocated.get(0).getCourseName()+", Course 2 : "+courseallocated.get(1).getCourseName()+", Course 3 : "+courseallocated.get(2).getCourseName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			
		}
		
	}
	//writing student name and allocated courses output in registration_results file
	@Override
	public void writeFile(HashMap<String, Student> studentdetails, String filename) {
		BufferedWriter writer = null;
		try {
			File file = new File(filename);
			writer = new BufferedWriter(new FileWriter(file, true));//using buffered writer to write into the file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
		}
		try {
			//iterating through student detail hashmap 
			for (Map.Entry objstudentdetails : studentdetails.entrySet()) {
				Student objstudent = new Student();
				objstudent = (Student) objstudentdetails.getValue();
				ArrayList<Course> courseallocated = new ArrayList<Course>();
				courseallocated = objstudent.getCourseallocated();
				try {
					writer.append("Student_Name : "+ objstudentdetails.getKey()+"  Course 1 : " +courseallocated.get(0).getCourseName()+", Course 2 : "+courseallocated.get(1).getCourseName()+", Course 3 : "+courseallocated.get(2).getCourseName()+"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally
				{
					
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		finally
		{
			
		}
		    try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    finally
			{
				
			}
	}
	
}
