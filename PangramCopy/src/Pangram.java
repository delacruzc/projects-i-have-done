import java.util.Scanner;

public class Pangram {

	public static void main(String[] args) {
		
		System.out.println("Please enter a string of letters: ");
		
		Scanner userIn = new Scanner(System.in);
		
		String s = userIn.nextLine();
		
		System.out.println();
		
		boolean[] mark = new boolean[26];
		boolean pangram = true; 
		int index = 0;
	
		
		
		for(int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			
			
			if(c >= 'A' && c <= 'Z') {
				index = c - 'A';
			}
			else if(c >= 'a' && c <= 'z') {
				index = c - 'a';
			}
			
			mark[index] = true;
			
		}

		for(int i = 0; i < mark.length; i++) {
			if(mark[i] == false) {
				pangram = false;
			}
		}
		
		if(pangram) {
			System.out.println("Yay! This string is a pangram.");
		} else {
			System.out.println("This string is not a pangram. :(");
		}
		
	}

}
