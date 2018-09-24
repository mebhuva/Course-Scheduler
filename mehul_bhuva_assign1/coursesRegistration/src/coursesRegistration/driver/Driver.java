package coursesRegistration.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import coursesRegistration.scheduler.scheduler;
import coursesRegistration.util.Course;
import coursesRegistration.util.FileDisplayInterface;
import coursesRegistration.util.FileProcessor;
import coursesRegistration.util.Results;
import coursesRegistration.util.StdoutDisplayInterface;
import coursesRegistration.util.Student;

/**
 * @author John Doe
 *
 */
public class Driver {
	
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			System.exit(0);
		}
		else
		{
			try {
				FileProcessor fp = new FileProcessor(args);
				int check = fp.fileExists();//checking if file exists or not in the directory
				if(check == 0)
				{
					System.out.println("File not found");
					System.exit(0);
				}
				HashMap<String, Student> studentdetails = fp.readStudentData();//reading student fill data
				ArrayList<Course> Courselist =fp.readCourseData();//reading course fill data
				scheduler objscheduler = new scheduler();//object to call courseSchedular method to allocate courses to the student
				studentdetails = objscheduler.courseSchedular(studentdetails,Courselist);//courseScheduler method to get allocated courses
				StdoutDisplayInterface sdi=new Results();
				sdi.writeconsole(studentdetails);//writing output on console
				FileDisplayInterface fdi=new Results();
				fdi.writeFile(studentdetails, args[2]);//writing output in registration_results file
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				
			}
			
			
		}

	}
}
