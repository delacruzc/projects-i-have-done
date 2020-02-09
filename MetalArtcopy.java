/*****************************************************************************
 * MetalArt
 *****************************************************************************
 * This project displays the area and costs of building a model sculpture based on user input for the size of the pyramids and rectangular prism.
 *____________________________________________________________________________
 * Caitlin Dela Cruz
 * January 25th
 * CMSC 255 Section -004
 *****************************************************************************/

import java.util.Scanner;
// this imports the scanner function i need for the input
import java.math.*; 
// this gives me ability to do the calculations for the surface area
import java.util.Formatter;
// this helps me round my answers


 public class MetalArt {
	public static void main (String [] args) {


		System.out.println();
 		System.out.println("Caitlin Dela Cruz");
 		System.out.println("Project 2 -- MetalArt");
 		System.out.println("This project displays the area and costs of building a model sculpture based on user input for the size of the pyramids and rectangular prism.");
 		System.out.println("January 29th, 2019");
 		System.out.println("CMSC-255 Section 002");
 		System.out.println();
 		System.out.println();




		    	Scanner input = new Scanner(System.in); 
    	
    	System.out.print("Enter the name of the pentagon: "); // user puts in name of object & measurements
    	String name_of_pentagon  = input.nextLine();

    	System.out.print("Enter the length of the base of the first pyramid (inches):");
    	double length_base1stPyr = input.nextDouble();

    	System.out.print("Enter the height of the first pyramid (inches):");
    	double height_1stPyr = input.nextDouble();

    	System.out.print("Enter the length of the base of the second pyramid (inches):");
    	double length_base2ndPyr = input.nextDouble();

    	System.out.print("Enter the height of the second pyramid (inches):");
    	double height_2ndPyr = input.nextDouble();

    	System.out.print("Enter the height of the rectangular prism (inches):");
    	double height_rectPrism = input.nextDouble();

    	System.out.print("Enter the length of the rectangular prism (inches):");
    	double length_rectPrism = input.nextDouble();

    	System.out.print("Enter the width of the rectangular prism (inches):"); 
    	double width_rectPrism = input.nextDouble();

    	
    	double area_base1stPyr =  ((1.0/2.0) * length_base1stPyr * Math.sqrt(Math.pow(length_base1stPyr, 2.0) - Math.pow((1.0/2.0 * length_base1stPyr), 2.0))); 
    	// getting the area of the 1st pyramid base for the surface area

    	double slant_length1stPyr = (Math.sqrt( Math.pow((1.0/2.0 * length_base1stPyr), 2.0) + Math.pow(height_1stPyr, 2.0))); 
    	// getting the slant length 

    	double surface_area1stPyr = (area_base1stPyr + ((1.0/2.0) * 3.0 * length_base1stPyr * slant_length1stPyr)); 
    	// calculates the surface area of the 1st pyramid
    	
    	

    	double area_base2ndPyr = ( (1.0/2.0) * length_base2ndPyr * Math.sqrt(Math.pow(length_base2ndPyr, 2.0) - Math.pow((1.0/2.0 * length_base2ndPyr), 2.0))); 
    	// getting the area of the 2nd pyramid base for the surface area

    	double slant_length2ndPyr = Math.sqrt( Math.pow((1.0/2.0 * length_base2ndPyr), 2.0) + Math.pow(height_2ndPyr, 2.0)); 
    	// getting the 2nd pyramid slant length

    	double surface_area2ndPyr = area_base2ndPyr + ((1.0/2.0) * 3.0 * length_base2ndPyr * slant_length2ndPyr); 
    	// calculates the surface area of the 2nd pyramid

    	

    	double surface_areaRect = ((2.0 * length_rectPrism * width_rectPrism ) + (2.0 * length_rectPrism * height_rectPrism) + (2.0 * width_rectPrism * height_rectPrism)); 
    	// calculates the surface area of the rectangular prism




        double total_surfaceAreaEverything = Math.round((surface_area1stPyr + surface_area2ndPyr + surface_areaRect) * 100.0) / 100.0;
        // this rounds the total surface area
        

        double total_costProject =  Math.round((total_surfaceAreaEverything * 1.67) * 100.0) / 100.0;
        // this rounds the total cost for the project


        System.out.println("The surface area calculations of " + name_of_pentagon +" are:");
        // this prints the name of the project
        
        System.out.println("    Surface area of the first pyramid: " + String.format("%,.2f",surface_area1stPyr) + " square inches.");
        // this prints the surface area of the first pyramid and shortens the double to 2 decimal places
        
        System.out.println("    Surface area of the second pyramid: " + String.format("%,.2f", surface_area2ndPyr) + " square inches.");
        // this prints the surface area of the second pyramid and shortens the double to 2 decimal places
        
        System.out.println("    Surface area of the rectangular prism: " + String.format("%,.2f", surface_areaRect) + " square inches.");
        // this prints the surface area of the rectangular prism and shortens the double to 2 decimal places
        
        System.out.println("    Total Surface Area: " + String.format("%,.2f", total_surfaceAreaEverything));
        // this prints the total surfaces all added together and shortens the double to 2 decimal places
        
        System.out.println("The total cost of the material to build " + name_of_pentagon + " is: $" + String.format("%,.2f", total_costProject));
        // this prints the name of the project and the cost to build the project and shortens it to 2 decimal places


    

	}
 } 