import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class Game {
	int level;
	Player computer;
	Player human;
	public Game(int level) throws IOException
	{
		this.level = level;
		computer = new Player("FRIG",level);
		human = new Player("FOUR",level);
	}
	
	public void startGame() {
		Scanner s=new Scanner(System.in);
		int noOfCommonLetters = -1;
		int turns=0;
		while(true) {
			turns++;
			String computerGuess=computer.guessNextWord();
			System.out.println(computer.mappedWord(computerGuess));
			noOfCommonLetters = human.commonCount(computerGuess,human.secretword);
				if(noOfCommonLetters == level) {
				System.out.println("computer wins!");
				break;
			}
				System.out.println("common letters of computer guess with player's secret word "+noOfCommonLetters);
			computer.processReply(noOfCommonLetters);
			
			//noOfCommonLetters = A.commonCount(B.guessNextWord(),A.secretword);
			String guess=s.nextLine();
			noOfCommonLetters = computer.commonCount(guess,computer.secretword);
			System.out.println("common letters of player's guess with computer's secret word "+noOfCommonLetters);
			if(noOfCommonLetters == level){
				System.out.println("human wins!");
				break;
			}
			//B.processReply(noOfCommonLetters);
		}
		System.out.println(turns);


	}

	public static void main(String args[]) throws IOException {
		Game g = new Game(4);
		g.startGame();
		
		
	}


}
