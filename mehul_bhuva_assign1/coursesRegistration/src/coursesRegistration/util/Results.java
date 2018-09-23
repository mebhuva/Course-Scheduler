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

	@Override
	public void writeconsole(HashMap<String, Student> studentdetails) {
		for (Map.Entry objstudentdetails : studentdetails.entrySet()) {
			Student objstudent = new Student();
			objstudent = (Student) objstudentdetails.getValue();
			ArrayList<Course> courseallocated = new ArrayList<Course>();
			courseallocated = objstudent.getCourseallocated();
			System.out.println("Student_Name : "+ objstudentdetails.getKey()+"  Course 1 : " +courseallocated.get(0).getCourseName()+", Course 2 : "+courseallocated.get(1).getCourseName()+", Course 3 "+courseallocated.get(2).getCourseName());
		}
		
	}

	@Override
	public void writeFile(HashMap<String, Student> studentdetails, String filename) {
		BufferedWriter writer = null;
		File file = new File(filename);
		try {
			writer = new BufferedWriter(new FileWriter(file, true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Map.Entry objstudentdetails : studentdetails.entrySet()) {
			Student objstudent = new Student();
			objstudent = (Student) objstudentdetails.getValue();
			ArrayList<Course> courseallocated = new ArrayList<Course>();
			courseallocated = objstudent.getCourseallocated();
			try {
				writer.append("Student_Name : "+ objstudentdetails.getKey()+"  Course 1 : " +courseallocated.get(0).getCourseName()+", Course 2 : "+courseallocated.get(1).getCourseName()+", Course 3 "+courseallocated.get(2).getCourseName()+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		    try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
