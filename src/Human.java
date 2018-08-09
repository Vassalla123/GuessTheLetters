import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Human {
	String secretword;
	String guessedWord;
	ArrayList<String> probableWords=new ArrayList<String>();
	public Human(String secretword,int level)
	{
		this.secretword=secretword;
       
	}
	public String getGuessedWord() {
		return guessedWord;
	}
	public void setGuessedWord(String guessedWord) {
		this.guessedWord = guessedWord;
	}
	public int commonCount(String a,String b)
	{
		int commonCount=0;
		for(int i=0;i<a.length();i++)
		{
			if(b.contains(Character.toString(a.charAt(i))))
				commonCount++;
		}
		return commonCount;
	}
   
}
