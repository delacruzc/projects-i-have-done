/****************************************************************************
* WeeklyPayroll.java
****************************************************************************
* 
*_____________________________________________________
* Caitlin Dela Cruz
* 4-4-2019
* CMSC-255 Section 002
****************************************************************************/

/**
 * Algorithm:
 * 		- user enters input file, output file name, and number of rows in command prompt
 * 		- parseData reads the input file, and puts the number of hours in a 2D array called hoursWorked, and the employee names in a string array called employee 
 * 		- calcGrossPay calculates gross pay for each employee and puts it in a double array called grossPay
 * 		- calcDayTally calculates the total number of hours worked for each employee using the hoursWorked array and puts it in an int array called dayTally
 * 		- displayData prints the employee name with their gross pay rounded to 2 decimal places &
 */




import java.util.Scanner; 				// this helps me receive and read input
import java.io.File; 					// gives me the ability to create an input/output file
import java.io.PrintWriter; 			// gives me the ability to print my outputs into the output file
import java.io.FileNotFoundException;   // i can do try-catch for filenotfoundexceptions
import java.math.*; 					// helps me do calculations
import java.util.ArrayList; 			// gives me the ability to make an arraylist
import java.util.Arrays; 				// helps me make arrays



// notes to self:
// 		~ comment while you're coding to make life easier 
//  	~ compile and run constantly
// 		~ ask someone(?) about this error:
// 				Exception in thread "main" java.util.NoSuchElementException
//					at java.base/java.util.Scanner.throwFor(Scanner.java:937)
//					at java.base/java.util.Scanner.next(Scanner.java:1478)
//					at WeeklyPayroll.parseData(WeeklyPayroll.java:86)
//					at WeeklyPayroll.main(WeeklyPayroll.java:43)



// this is the main class where all the code

public class WeeklyPayroll_CAITLIN_DELA_CRUZ {
	
	/** 
	 *  the main method is where the input and output files will be created, and where
	 *  i will call the other methods 
	 */

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println();     		// these empty println()s are just to make the program 
										// output more spaced out and organized
		
		// this method prints out the heading and info about the project 
		printHeading(); 	
		
		
		System.out.println();
		System.out.println();
		
		String inputFileName; 			// this will be where the name of the input file will be stored
	    String outputFileName;			// this will be where the name of the output file will be stored 
	    int numRows;					// this will where the number of rows will be stored
	 									// this is the number of columns
	         
	    
	    /**
	     * if statement that says:
	     * 	if the length of the argument entered in the command prompt is > 0
	     * 		- then the first argument will be stored in inputFileName
	     *  	- the second argument will be stored in outputFileName
	     *  	- the third argument will be stored in numRows
	     *  	- an input file will be created
	     *  	- an output file will be created
	     *  	- a scanner created to read the inputFile
	     *  	- printwriter to write output in the output file
	     *  	- calls parseData method, sending inputFile/outputFile/numRows
	     */
	      if(args.length != 0) {
	         inputFileName = args[0];
	         outputFileName = args[1];
	         numRows = Integer.parseInt(args[2]);
	         
	         File inputFile = new File(inputFileName);
	         File outputFile = new File(outputFileName);
	         Scanner in = new Scanner(inputFile);
	         PrintWriter out = new PrintWriter(outputFileName);
	         
	         parseData(inputFile, outputFile, numRows);
	         
	         
	
	         
	         in.close(); 		// closes in scanner
	         out.close();		// closes out scanner
	         
	      } // closes if
	      
	      /**
	       * else statement:
	       * 	- if there is no arguments then it will ask the user to enter an input/output file name
	       * 	- a try-catch for the filenotfound exception if the user inputs the wrong file name
	       */
	      
	      
	      else {
	    	  	try {
				     Scanner input = new Scanner(System.in);
						 
				     	 System.out.print("Enter an input file: ");			// asking the user for the name of the input file
						 	inputFileName = input.next();			
						 System.out.print("Enter an output file: ");		// asking the user for the output file name
						 	outputFileName = input.next();
						 System.out.print("Enter the number of rows: ");	// asking the user for the number of rows
						 	numRows = input.nextInt();
					 
					 File inputFile = new File(inputFileName);
					 File outputFile = new File(outputFileName);
				     
					 Scanner in = new Scanner(inputFile);
				     PrintWriter out = new PrintWriter(outputFileName);
				     
				     parseData(inputFile, outputFile, numRows);
				    
			        } // closes try
	    	  	
	    	  	
		    	 catch(FileNotFoundException e) {
		    		 System.out.println("Sorry, wrong input file name! :(");
	    		 
	    	        } // closes catch
	      } // closes else
	     

	} // closes main method 
	
	/***
	 * this method takes in inputFile/outputFile/numRows, reads in the input text file 
	 * and puts it in arrays
	 */
	
	public static void parseData(File inputFile, File outputFile,  int numRows) throws FileNotFoundException {
		
		String[] employee = new String[numRows];		// creates the array to store employee names
		int[][] hoursWorked = new int[numRows][7];		// creates an array to store numbers in input text file
		
		Scanner read = new Scanner(inputFile);			// this will create a scanner called read and it scans the contents inside inputFile
		
		String firstName;								// this will contain the first name of the employee
		String lastName;								// this will contain the last name of the employee
				
		
		/**
		 * this while loop scans through the input file and stores the data in the specified arrays
		 */
		
		while(read.hasNextLine()) {				
			
			// this for loop iterates by the number in numRows
			for(int i = 0; i < numRows; i++) {
				
				// this is storing the next first and last name
				firstName = read.next(); 			 
				lastName = read.next();
				
				// this adds the name into the array at position i
				employee[i] = firstName + " " + lastName;
				
					// this for loop iterates by the number of columns
					for(int j = 0; j < 7; j++) {
						
						// this is storing the next number and storing it in the hoursWorked array
						hoursWorked[i][j] = read.nextInt(); 
						
					}// closes inner for loop
			
				
			} // closes for
		} // closes while
			
		
		// this calls the calcGrossPay method and passes the int array hoursWorked
		calcGrossPay(hoursWorked);
		// this calls the calcDayTally method and passes the int array hoursWorked to it
		calcDayTally(hoursWorked);
		
		// creating a PrintWriter for the displayData method
		PrintWriter outputWriter = new PrintWriter(outputFile);
		 
		// calls the displayData method and passes the string array employee, the double array grossPay, int array dayTally, and printwriter outputWriter to it
		displayData(employee, calcGrossPay(hoursWorked), calcDayTally(hoursWorked), outputWriter);
		
		
		read.close();			// closes read scanner
		outputWriter.close();   // closes outputWriter scanner
		
		} // closes parseData
	
	
	// this method will calculate the gross pay for each employee
	public static double[] calcGrossPay(int[][] hoursWorked) {
		
		// created a final double variable because the hourly rate is a constant number
		final double hourlyRate = 9.50;
		
		// creates the array to store the gross payment of the employees
		double[] grossPay = new double[12];
		// this is where the calculated gross pay will be stored
		double theGross;
		
		// this iterates by the number of rows
		for(int r = 0; r < 12; r++) {
			
			// this iterates by the number of columns
			for(int c = 0; c < 7; c++) {
				
				// this multiplies the hoursWorked by the hourlyRate and stores it in theGross
				theGross = hoursWorked[r][c] * hourlyRate;
				// this adds theGross in the grossPay array
				grossPay[r] = grossPay[r] + theGross;
			
			} // closes inner for loop
			
		} // closes outer for loop
		
		// this returns grossPay back to the main method
		return grossPay;
		
	} // closes calcGrossPay
	
	// this method will calculate the total amount of hours worked each day
	public static int[] calcDayTally(int[][] hoursWorked) {
		
		// creates an array called dayTally that will contain the total hours each day
		int[] dayTally = new int[7];
		// this is where the total hours worked in a day will be stored
		int dayTotal;
		
		// this for loop iterates the number of rows in the array
		for(int r = 0; r < 12; r++) {
			
			// this for loop iterates the number of columns in the array
			for(int c = 0; c < 7; c++) {
				
				// this stores the hours worked into the dayTotal
				dayTotal = hoursWorked[r][c];
				
				// this adds up the number of hours in 1 column
				dayTally[c] = dayTally[c] + dayTotal;
				
			} // closes inner for loop
			
		} // closes outer for loop
		
		// this sends back dayTally back to the main method
		return dayTally;
		
	} // closes calcDayTally
	
	
	// this method prints out the employee name, their gross pay, and and the days of the week
	// and the total number of hours worked on that day
	public static void displayData(String[] employee, double[] grossPay, int[] dayTally, PrintWriter out) {
	 
		// this for loop iterates the numnber of employees in the array
		for(int i = 0; i < employee.length; i++) {
			
			// this prints the employee name, with their gross pay separated with a tab
			// it is also formatted so that the gross pay has 2 decimal points
			//out.printf("%s\t\t  %.2f\n",employee[i], grossPay[i]);
			out.printf( "%-9s %10.2f\n", employee[i], grossPay[i]);
			
		
		} // closes for loop
		
		out.println();		// this is to separate the gross pay and total number of hours & makes it look more neat
		out.println();
		
		
		// made a string array for the days of the week
		String[] weekDays = { "Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		
		// for loop that iterates the number of days in the week
		for(int j = 0; j < weekDays.length; j++) {
			
			// this prints the day of the week and the total hours worked on that day
			// separated by a tab
			 //out.printf("%s\t\t  %d\n",weekDays[j],dayTally[j]);
			 out.printf( "%-13s %d\n", weekDays[j], dayTally[j]);
				
			
		} // closes for loop
		 	
		
			
		 out.close(); //closes out scanner
	} // closes displayData
	
	// this method prints the information about the project
	public static void printHeading() {
		 
		System.out.println("Project Name: WeeklyPayroll.java");
		System.out.println("Project Description: This project takes in an input file with the names and hours worked");
		System.out.println("and calculates the gross pay of each employee. It also calculates the total number of hours worked");
		System.out.println("for each day of the week.");
		System.out.println("Name: Caitlin Dela Cruz");
		System.out.println("Version Date: 4-4-2019");
		System.out.println("CMSC 255 Section 002");
		
	} // closes printHeading method

} // closes class
