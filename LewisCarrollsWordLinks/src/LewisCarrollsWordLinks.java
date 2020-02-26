import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class LewisCarrollsWordLinks {
// Sample Inputs:
//gimlets, giblets, gibbets, gibbers, libbers, limbers, lumbers, cumbers, cambers, campers, carpers, carters, barters, batters, butters, putters, puttees, putties, patties, parties, parries, carries, carrier, currier, curlier, burlier, bullier, bullies, bellies, jellies, jollies, collies, collins, colling, coaling, coaming, foaming, flaming, flaking, fluking, fluxing, flexing, fleeing, freeing
//gimlets, giblets, gibbets, gibbers, libbers, limbers, lumbers, cumbers, cambers, campers
	public static final int MAX_WORD_COUNT = 658964;
	public static void main(String[] args) {
		String[] wordList = new String[MAX_WORD_COUNT];
		wordList = readDictionary(wordList);
		boolean finished = false;
		boolean isUnique = false;
		Scanner inputScanner = new Scanner (System.in);
		do {
			System.out.print("Enter a comma separated list of words (or an empty list to quit):");
			String inputLine = inputScanner.nextLine();
			if (inputLine.equals(""))
			{
				System.out.print("Thanks for playing!");
				finished = true;
			}
			else
			{
				isWordChain(isUnique, inputLine, wordList);
			}
		} while (!finished);
		inputScanner.close();
	}
	
	public static String[] readDictionary(String[] wordList) {
		try {
			FileReader fileReader = new FileReader("C:\\Users\\John\\eclipse-workspace\\LewisCarrollsWordLinks\\src\\words.txt");// Enter the entire path of the file if needed
			BufferedReader bufferedReader = new BufferedReader(fileReader);
        	String wordLine;
        	int i = 0;
        	while ((wordLine = bufferedReader.readLine()) != null) {
    			wordList[i] = wordLine;
    			i++;
    		}
    		bufferedReader.close();    
	        fileReader.close();
    		return wordList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordList;
	}
	public static String[] readWordList(String inputLine)
	{
		String[] inputList = inputLine.split(", ");
		return inputList;
	}
	public static void isWordChain (boolean isUnique, String inputLine, String[] wordList)
	{
		String[] inputList = readWordList(inputLine);
		isUnique = isUniqueList (inputList);
		if (isUnique == true)
		{
			boolean isEnglish = isEnglishWord(inputList, wordList);
			if (isEnglish == true)
			{
				boolean isDifferent = isDifferentByOne(inputList);
				if(isDifferent == true)
				{
					System.out.println("Congratulations that's a word chain!");
					return;
				}
				else
					System.out.println("Sorry, that's not a word chain.");
					return;
			}
			else
				System.out.println("One of those words does not exist (or was an incorrect input).  Try again with another input.");
		}
		else
			System.out.println("Input contains multiple of the same values. Please re-enter values to try again.");
	}
	public static boolean isUniqueList(String[] inputList)
	{
		for (int i = 0; i < inputList.length; i++)
		{
			for (int j = 0; j < inputList.length; j++)
			{
				if (i != j)
				{
					if (inputList[i].equals(inputList[j]))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	public static boolean isEnglishWord(String[] inputList, String[] wordList)
	{
		for (int i = 0; i < inputList.length; i++ )
		{
			String wordToBeFound = inputList[i];
			int foundWord = Arrays.binarySearch(wordList, wordToBeFound);
			if (foundWord < 0)
			{
				return false;
			}
		}
		return true;
	}
	public static boolean isDifferentByOne (String[] inputList)
	{
		int differentCharacter = 0;
		for(int i = 0; i < inputList.length-1; i++)
		{
			differentCharacter = 0;
			char [] characterWordOne = inputList[i].toCharArray();
			char [] characterWordTwo = inputList[i+1].toCharArray();
			for(int j = 0; j < characterWordOne.length; j++)
			{
				if (characterWordOne.length != characterWordTwo.length)
				{
					return false;
				}
				if (characterWordOne[j] != characterWordTwo[j])
				{
					differentCharacter++;
				}
			}
			if(differentCharacter != 1)
			{
				return false;
			}
		}
		return true;
	}
}
