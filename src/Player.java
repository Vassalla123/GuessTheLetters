import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

class Player {
String secretword;
String guessedWord;
HashMap<String,String> anagram;
ArrayList<String> probableWords=new ArrayList<String>();
public Player(String secretword,int level) throws IOException
{
	this.secretword=secretword;

	preprocess(level);
}
public String getSecretword() {
	return secretword;
}
public void setSecretword(String secretword) {
	this.secretword = secretword;
}

public String mappedWord(String a)
{
	return anagram.get(a);
	 
}

public void preprocess(int level) throws IOException
{
	File file = new File("sowpods.txt");
	anagram=new HashMap<String,String>();
	  BufferedReader br = new BufferedReader(new FileReader(file));
	 
	  String st;
	  while ((st = br.readLine()) != null)
	  {
		if(st.length()==level)
		{
			char str[]=st.toCharArray();
		    Arrays.sort(str);
			anagram.put(new String(str),st);
		}
	  }
	  for(String s:anagram.keySet())
	  {
		  probableWords.add(s);
	  }
	
}
public String guessNextWord()
{
	Random random = new Random();
	int randomIndex=random.nextInt(probableWords.size());
	
	this.guessedWord=probableWords.get(randomIndex);
	return this.guessedWord;
}
public void processReply(int count)
{
	ArrayList<String> possibleWords=new ArrayList<String>();
	for(String s:probableWords)
	{
		if(s!=this.guessedWord && commonCount(this.guessedWord, s)==count)
		possibleWords.add(s);
	}
	probableWords=new ArrayList<String>();
	probableWords.addAll(possibleWords);
	
}
public int commonCount(String a,String b)
{
	int commonCount=0;
    a=removeDuplicateCharacters(a);
	for(int i=0;i<a.length();i++)
	{
		if(b.contains(Character.toString(a.charAt(i))))
			commonCount++;
	}
	return commonCount;
}
public String removeDuplicateCharacters(String a)
{
	String distinctChars="";
	HashSet<Character> hs=new HashSet<Character>();
	for(int i=0;i<a.length();i++)
		hs.add(a.charAt(i));
	for(char ch:hs)
	{
		distinctChars=distinctChars+Character.toString(ch);
	}
	return distinctChars;
}
public int respondToGuess(String guess) {
    int commonLetters = 0;
    for(int i = 0; i < guess.length(); i++) 
        if(guess.charAt(i) == secretword.charAt(i))
            commonLetters++;
    return commonLetters;
}

public static void main(String args[]) throws IOException
{
 
 //Player p1=new Player("abcd");
 //p1.preprocess();
//System.out.println(p1.guessNextWord());
 //p1.processReply(3);
// System.out.println(p1.probableWords.size());
}
}
