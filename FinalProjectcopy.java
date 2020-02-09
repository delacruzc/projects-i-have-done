/*****************************************************************************
 * FinalProject
 *****************************************************************************
 * This project takes in a string, and outputs the number of 
 * vowels and consonents.
 *____________________________________________________________________________
 * Caitlin Dela Cruz, Michael Williams, Xavier Lakin, Daniel Cordero
 * March 2nd
 * CMSC 255 Section 004
 *****************************************************************************/

import java.util.Scanner;
// used to take in user input

import java.math.*;


public class FinalProject {
	public static void main(String [] args){

		Scanner input = new Scanner(System.in); 
		// creates scanner called "input"

        System.out.println("Please enter a word/phrase.");
		String user_Input = input.nextLine();
		// asks user to input a string

		user_Input = user_Input.toLowerCase();
		// turns everything lower-case so it doesn't matter if the user puts in upper case letters

		int str_Length = (user_Input.length());
		// creating variable str_Length for the for loop

		int numVowels = 0;
		// variable to store the number of vowels
		int numCons = 0;
		// variable to store the number of consonants
		int numSpaces = 0;
		// variable that stores the number of spaces



		

		for(int j = 0; j < str_Length; j++) {

			if((user_Input.charAt(j) == 'a' ) || (user_Input.charAt(j) == 'e') || (user_Input.charAt(j) == 'i') || (user_Input.charAt(j) == 'o') || (user_Input.charAt(j) == 'u')) {

				numVowels++;

			}
			else if (user_Input.charAt(j) == ' ') {
				
				numSpaces++;
			}
			else if ( (user_Input.charAt(j) >= 'a') && (user_Input.charAt(j) <= 'z') ) {

				numCons++;


			}
		}	
      	
      		System.out.println("There are " + numVowels + " vowels in your string.");
      		System.out.println("There are " + numCons + " consonants in your string.");

  

	}
}

