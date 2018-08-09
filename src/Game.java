import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Game {
	String level;
	Player computer;
	Human human;
	HashMap<String,Integer> valueOfLevel=new HashMap<String,Integer>();
	public Game(String level) throws IOException
	{
		valueOfLevel.put("EASY", 4);
		valueOfLevel.put("MEDIUM", 5);
		valueOfLevel.put("DIFFICULT",6);
		this.level = level;
		computer = new Player("FRIG",valueOfLevel.get(level));
		human = new Human("FOUR",valueOfLevel.get(level));
	}
	
	public void startGame() {
		Scanner s=new Scanner(System.in);
		int noOfCommonLetters = -1;
		int turns=0;
		while(true) {
			turns++;
			String computerGuess=computer.guessNextWord();
			System.out.println(computer.mappedWord(computerGuess));
			noOfCommonLetters = human.commonCount(human.secretword,computerGuess);
				if(noOfCommonLetters == valueOfLevel.get(level)) {
				System.out.println("computer wins!");
				break;
			}
				System.out.println("common letters of computer guess with player's secret word "+noOfCommonLetters);
			computer.processReply(noOfCommonLetters);
			
			//noOfCommonLetters = A.commonCount(B.guessNextWord(),A.secretword);
			String guess=s.nextLine();
			human.setGuessedWord(guess);
			noOfCommonLetters = computer.commonCount(computer.secretword,guess);
			System.out.println("common letters of player's guess with computer's secret word "+noOfCommonLetters);
			if(noOfCommonLetters == valueOfLevel.get(level)){
				System.out.println("human wins!");
				break;
			}
			//B.processReply(noOfCommonLetters);
		}
		System.out.println(turns);


	}

	public static void main(String args[]) throws IOException {
		Game g = new Game("EASY");
		g.startGame();
		
		
	}


}
