package fortuneCookie;

import java.util.Random;

public class fortuneGenerator {
	
	
	static String[] possibleFortunes = {
	"The fortune you seek is in another cookie.",
	"A closed mouth gathers no feet.",
	"A conclusion is simply the place where you got tired of thinking.",
	"A cynic is only a frustrated optimist.",
	"A foolish man listens to his heart. A wise man listens to cookies.",
	"You will die alone and poorly dressed.",
	"A fanatic is one who can't change his mind, and won't change the subject.",
	"If you look back, you'll soon be going that way.",
	"You will live long enough to open many fortune cookies.",
	"An alien of some sort will be appearing to you shortly.",
	"Do not mistake temptation for opportunity.",
	"Flattery will go far tonight.",
	"He who laughs at himself never runs out of things to laugh at.",
	"He who laughs last is laughing at you.",
	"He who throws dirt is losing ground.",
	"Some men dream of fortunes, others dream of cookies.",
	"The greatest danger could be your stupidity.",
	"We don't know the future, but here's a cookie.",
	"The world may be your oyster, but it doesn't mean you'll get its pearl.",
	"You will be hungry again in one hour."
	};
 
	public static void main(String[] args) {
		
		Random stuff = new Random();
		int r = stuff.nextInt(possibleFortunes.length);
		System.out.println(possibleFortunes[r]);
		
	}

}
