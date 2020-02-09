/* Algorithm for MetalChoice.java
 * prompt user for num_Projects
 * initialize variable project_Count
 * enter while(project_Count < num_Projects)
 * ask user for name of project and measurements
 * calculate surface area
 * ask user what kind of material they would like to make their project out of and store in project_Material
   - surface area will be multiplied by the cost of the material 
 * ask user if they want a name plate
   - if no, display cost of project, increment project_Count, and go back to beginning of loop
   - if yes, ask user what they would like their name plate to be made out of 
     and how many letters they would like on their name plate
     - it will then print how much the project and the name plate will cost
     - it will increment project_Count and go back to the top of the loop
 * if project_Count > num_Project, program will end
 * 

 *****************************************************************************
 * MetalChoice
 *****************************************************************************
 * This project displays the area and costs of building a model sculpture based on user input for the size of the pyramids and rectangular prism.
 * This program also lets the user chose which type of material, the type of name plate and how many letters they want.
 *____________________________________________________________________________
 * Caitlin Dela Cruz
 * February 13th
 * CMSC 255 Section -004
 *****************************************************************************/

import java.util.Scanner;
// This imports the scanner function I need for the input
import java.math.*; 
// This gives me ability to do the calculations for the surface area
import java.util.Formatter;
// This helps me round my answers




 public class MetalChoice {
    public static void main (String [] args) {


        System.out.println();
        System.out.println("Caitlin Dela Cruz");
        System.out.println("Project 3 -- MetalChoice");
        System.out.println("This project displays the area and costs of building a model sculpture based on user input for the size of the pyramids and rectangular prism.");
        System.out.println("This program also lets the user chose which type of material, the type of name plate and how many letters they want.");
        System.out.println("February 13th, 2019");
        System.out.println("CMSC-255 Section 002");
        System.out.println();
        System.out.println();


        double total_costAllProjects = 0.0;
        // this variable contain the sum of the cost to make all the projects

        int project_Count = 0;
        // this variable contains the number of iterations



        Scanner input = new Scanner(System.in); 
        // this imports the scanner i need to receive the user's input

        System.out.print("How many projects would you like to make? "); 
        // asking the user how many projects they would like to make
        int number_ofProjects =  input.nextInt(); 
        input.nextLine();        
        // this will receive the user input
        // i put nextLine() here because nextInt() only gets the integer 
        // and stops collecting after it receives the int, and nextLine() just gets all the whitespace

       
        /** i used a for loop here. i initialized the variable project_count (represents the number of iterations it needs to go through). 
            the loop will increment project_count every time it iterates. when project_count is greater than number_ofProjects, the program 
            will exit the loop. */

        while (project_Count < number_ofProjects) {

            System.out.println("Enter the name of the project: "); // user puts in name of object & measurements
            String name_of_pentagon  = input.next();

            System.out.println("Enter the length of the base of the first pyramid (inches):");
            double length_base1stPyr = input.nextDouble();

            System.out.println("Enter the height of the first pyramid (inches):");
            double height_1stPyr = input.nextDouble();

            System.out.println("Enter the length of the base of the second pyramid (inches):");
            double length_base2ndPyr = input.nextDouble();

            System.out.println("Enter the height of the second pyramid (inches):");
            double height_2ndPyr = input.nextDouble();

            System.out.println("Enter the height of the rectangular prism (inches):");
            double height_rectPrism = input.nextDouble();

            System.out.println("Enter the length of the rectangular prism (inches):");
            double length_rectPrism = input.nextDouble();

            System.out.println("Enter the width of the rectangular prism (inches):"); 
            double width_rectPrism = input.nextDouble();


                    // these statements use the measurements collected by the input statements to calculate the surface area of the project

        
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
        

            double total_costProject = total_surfaceAreaEverything;
            // i initialized and stored the surface area calculations in this variable so i can calculate the cost of the project


            System.out.println(); // these println() statements are used to add space between input statements and not make the program very cluttered
            System.out.println(); 

            System.out.println("What kind of material are you using? (Aluminum, Steel, Titanium)? "); // asks the user what kind of material the user would like to use
            String project_Material = input.next();

                    project_Material = project_Material.toLowerCase(); 
                    // this makes everything in project_material lowercase, so it doesn't matter if project_Material is lower/uppercase


                    /** this if statement distinguishes the types of metals used. whatever material they choose, it multiplies the surface area by the price per/in and stores it 
                        back in total_costProject. the Math.round parses it to 2 decimal points */

                    if (project_Material.equals("aluminum") == true) {

                        total_costProject =  Math.round((total_surfaceAreaEverything * 1.50) * 100.0) / 100.0;
                        
                    } 
                    else if (project_Material.equals("steel") == true) {

                        total_costProject =  Math.round((total_surfaceAreaEverything * 2.85) * 100.0) / 100.0;
                        
                    }
                    else if (project_Material.equals("titanium") == true) {

                        total_costProject =  Math.round((total_surfaceAreaEverything * 4.50) * 100.0) / 100.0;
                        
                    }

            System.out.println(); // these println() statements are used to add space between input statements and not make the program very cluttered

            System.out.println("Would you like to put a name plate on your project? "); // asks user if they would like to put a name plate on their project
            String want_namePlate = input.next();

                    want_namePlate = want_namePlate.toLowerCase();
                    // this makes everything in want_namePlate lowercase, so it doesn't matter if want_namePlate is lower/uppercase
        
                    

                    /* this if statement asks if they want a name plate. if they say no, the program will just display the cost to build the project. if they 
                       say yes, it will ask if the user the type of material the name plate will be made out of and the number of letters they would like on the name plate.
                       at the end,it will then display the cost of the name plate, the project, and the combined cost.  */

                    if (want_namePlate.equals("yes") == true) {

                        double namePlate_Cost = 0.0;
                        // initializing the variable namePlate_Cost as a place to store name plate costs

                        System.out.println();

                        System.out.print("What type of name plate would you like? (Bronze, Silver, Gold)? "); // asks what type of material they would like to make the name plate out of 
                        String namePlate_Material = input.next();

                            namePlate_Material = namePlate_Material.toLowerCase();
                            // this makes everything in namePlate_Material lowercase, so it doesn't matter if namePlate_Material is lower/uppercase


                            /* this if statement calculates the cost of the name plate material depending on which material they choose. it 
                               stores the result in namePlate_Cost */

                            if (namePlate_Material.equals("bronze") == true) {

                                namePlate_Cost = namePlate_Cost + 8.0;

                            }
                            else if (namePlate_Material.equals("silver") == true) {

                                namePlate_Cost = namePlate_Cost + 12.50;

                            }
                            else if (namePlate_Material.equals("gold") == true) {

                                namePlate_Cost = namePlate_Cost + 19.99;

                            }

                        
                        System.out.println();

                        System.out.println("How many letters would you like on your name plate? "); // asks the user how many letters they would like on their name plate
                        int number_ofLetters = input.nextInt();

                            /* this if statement calculates the cost of the letters. but it all depends on how many letters they choose. i made the ranges from
                               0-5, 6-10, and 10+. i subtracted 5 from the 2 else if statements because i didn't want to overlap costs from the first 5 letters.
                               it will store the result in namePlate_Cost */

                            if ((number_ofLetters >= 1) && (number_ofLetters <= 5)) {

                                namePlate_Cost = namePlate_Cost + 19.99;
                            }
                            else if ((number_ofLetters >= 6) && (number_ofLetters <= 10)) {

                                namePlate_Cost = namePlate_Cost + 19.99 + ((number_ofLetters - 5) * 2.50);
                            }
                            else if (number_ofLetters > 10) {

                                namePlate_Cost = namePlate_Cost + 19.99 + ((number_ofLetters - 5) * 1.85);
                            }

            
                    System.out.println();        

            
                    System.out.println("The cost of the material to build " + name_of_pentagon + " is: $" + String.format("%,.2f", total_costProject));
                    // this prints the name of the project and the cost to build the project and shortens it to 2 decimal places

                    System.out.println("The cost of the name plate is: $" + String.format("%,.2f", namePlate_Cost));
                    // this prints the cost to make the name plate and shortens it to 2 decimal places

                    total_costProject = total_costProject + namePlate_Cost;
                    // this adds the cost to make the project and name plate

                    System.out.println("The cost of " + name_of_pentagon + ": $" + String.format("%,.2f", total_costProject));
                    // this outputs the total cost to make the entire project and shortens it to 2 decimal places

                    System.out.println();
                    
                    total_costAllProjects = Math.round((total_costAllProjects + total_costProject) * 100.0) / 100.0;
                    // this adds the cost of this project to the sum cost of ALL the projects and shortens it to 2 decimal places 

                    project_Count++;   

                    }

                    else if (want_namePlate.equals("no") == true)  {


                        System.out.println();

                        System.out.println("The cost of the material to build " + name_of_pentagon + " is: $" + String.format("%,.2f", total_costProject));
                        // this prints the name of the project and the cost to build the project and shortens it to 2 decimal places    

                        System.out.println();

                    total_costAllProjects = Math.round((total_costAllProjects + total_costProject) * 100.0) / 100.0;
                    // this adds the cost of this project to the sum cost of ALL the projects and shortens it to 2 decimal places  

                    project_Count++;

                    }




        }


                System.out.println("The total cost to make all " + number_ofProjects + " projects is: $" + total_costAllProjects);
                // this displays the cost to make ALL the projects the user asked for.

                System.out.println();
                
        }
}        