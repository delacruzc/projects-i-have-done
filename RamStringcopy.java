 package cmsc256;

import java.io.*;

/***
 * @author Caitlin Dela Cruz
 * 
 * Date: 09/12/2019
 * Course: CMSC-256
 * Section: 001
 * 
 * This program correctly implements the WackyStringInterface, and gives the user
 * the ability to manipulate strings and return them.
 */

 

public class RamString implements WackyStringInterface {
	
	public static void main(String[] args) {
		
		
//		
//		RamString what = new RamString();
//		RamString is = new RamString();
//		
//		is.setWackyString(null);
//		
//		
//		System.out.println(is.toString());
//		System.out.println(what.toString());
	}
	
	private String wackyString;
	
	// Sets the value of the current string to the default value.
	public RamString() {
		wackyString = "Rodney the Ram";
	}
	
	// Sets the value of the current string to the given value. 
	public RamString(String name) {
		
		try {
			wackyString = name;
		}
		catch(Exception e){
			
		}
	}
	// Sets the value of the current string to the given value.
	public void setWackyString(String string) {
		if(string == null) {
			throw new IllegalArgumentException();
		}
		else {
		wackyString = string;
		}
	}

	@Override
	// returns the values of wackyString
	public String getWackyString() {
		return wackyString;
	}

	@Override
	/* this obtains the character that is in the first index,last index, and the middle
	 * index and returns it in a string value
	 */

	public String getFirstMiddleLast() {
		
		String fmlLetter = "";
		
		try {
		char first = wackyString.charAt(0);
		String firstLetter = Character.toString(first);
		
		char last = wackyString.charAt(wackyString.length() - 1);
		String lastLetter = Character.toString(last);
		
		char mid;
		
		String midLetter = "";
		
		wackyString.replaceAll(" ","");
		
		if(wackyString.length() % 2 == 0) {
			mid = wackyString.charAt((wackyString.length()/2)-1);
			midLetter = Character.toString(mid);
		}
		else {
			mid = wackyString.charAt((wackyString.length() / 2));
			midLetter = Character.toString(mid);
		}
		
		
		fmlLetter = firstLetter + midLetter + lastLetter;
		
		return fmlLetter;
		
		}
		catch(NullPointerException e) {
			
		}
		catch(StringIndexOutOfBoundsException d) {
			
		}
 
		return fmlLetter;
	
		
	}

	@Override
	/*
	 * this obtains every third character in a String and returns those characters in a string
	 */
	public String getEveryThirdCharacter() {
		
		String thirdLetters = "";
		
		for (int i = 0; i < wackyString.length()+1; i++)
		{
		    if(i % 3 == 0 && i != 0) {

		    	// System.out.println(third.charAt(i-1));
		    	try {
		    	char thirdLetter = wackyString.charAt(i-1);
		    	String letter = Character.toString(thirdLetter);
		    	thirdLetters += letter;
		    	}
		    	catch(Exception e){
		    		throw new NullPointerException();
		    	}
		    	
		    }

		 }
		
		return thirdLetters;
	}

	@Override
	/*
	 * This method counts the number of even digits in a string, and returns the 
	 * number of even digits in the string.
	 */
	public int countEvenDigits() {
		
		int evenCount = 0;
		
		for(int r = 0; r < wackyString.length(); r++) {
			
			char part = wackyString.charAt(r);
			String number = Character.toString(part);
		
			try {
				int first = Integer.parseInt(number);
				
				if(first % 2 == 0) {
					evenCount = evenCount + 1;
				}
			}
			catch(Exception e) {
				
			}
		}
		
		return evenCount;
	}

	@Override
	/*
	 * This method checks if the string given is a 
	 * valid EID. It checks if there is a V in the 
	 * first index, two 0's after, and 6 digits after.
	 * If it has all these requirements, it will
	 * return true. Otherwise, it will return false.
	 */
	public boolean isValidEID() {
		
		char firstZ = wackyString.charAt(1);		
		char secondZ = wackyString.charAt(2);
		char first = wackyString.charAt(0);

		
		
		int validCount = 0;
		
		if(first == 'V') {
			validCount = validCount + 1;
		}
		
		if(wackyString.length() == 9) {
			validCount = validCount + 1;
		}

		if(firstZ == '0' && secondZ == '0') {
			validCount = validCount + 1;
		}

		if(validCount == 3) {
			return true;
		}
		else {
			return false;
		}
		
		
	
	}

	@Override
	/*
	 * This method converts the numbers 1-9 in a string
	 * to what it is as a word (ex. 2 = two). Otherwise, any
	 * characters that aren't 1-9 stay the same.
	 * 
	 * This method only converts digits that are within the
	 * range given by the user.
	 * 
	 * A new string value is created to replace the digits and
	 * turn them into words.
	 * 
	 */
	public void convertDigitsToWordsInSubstring(int startPosition, int endPosition)
			throws MyIndexOutOfBoundsException, IllegalArgumentException {
		
		if(startPosition > wackyString.length() || startPosition < 1) {
			throw new MyIndexOutOfBoundsException();
		}
		
		if(endPosition > wackyString.length() || endPosition < 1) {
			throw new MyIndexOutOfBoundsException();
		}
		
		
		 
		String numberToWord = "";
		 
	
		for(int p = 0; p < wackyString.length() ; p++) {
  		   
  		   if(p >= startPosition-1 && p <= endPosition-1){
  			   
  			   if(Character.isDigit(wackyString.charAt(p)) && wackyString.charAt(p) != '0'){
  				   
  				   if(wackyString.charAt(p) == '1') {
  					 numberToWord += "one";
  				   }
  				   if(wackyString.charAt(p) == '2') {
   					 numberToWord += "two";
   				   }
  				   if(wackyString.charAt(p) == '3') {
   					 numberToWord += "three";
   				   } 
  				   if(wackyString.charAt(p) == '4') {
   					 numberToWord += "four";
   				   }
  				   if(wackyString.charAt(p) == '5') {
   					 numberToWord += "five";
   				   }
  				   if(wackyString.charAt(p) == '6') {
   					 numberToWord += "six";
   				   }
  				   if(wackyString.charAt(p) == '7') {
   					 numberToWord += "seven";
   				   }
  				   if(wackyString.charAt(p) == '8') {
   					 numberToWord += "eight";
   				   }
  				   if(wackyString.charAt(p) == '9') {
   					 numberToWord += "nine";
   				   }
  			   	}
  			   else {
  				   numberToWord += wackyString.charAt(p);
  			   	}
  		   }
  		   else {
  			   numberToWord += wackyString.charAt(p);
  		   }
  		   
  		  
     	}
     wackyString = numberToWord;	 
	}


	
	public String toString() {
		return wackyString;
	}	
}
	
	
	

