package coursesRegistration.driver;

import java.io.File;
import java.util.HashMap;

import coursesRegistration.util.FileProcessor;
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
		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			System.exit(0);
		}
		else
		{
			//System.out.println(args[0] + "   " +args[1]);
			
			try {
				FileProcessor fp = new FileProcessor(args);
				fp.fileExists();
				HashMap<String, Student> studentdetails = fp.readStudentData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}
}
