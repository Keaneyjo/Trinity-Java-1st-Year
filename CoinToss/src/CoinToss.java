import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

public class CoinToss {

/*
 * Write a program to simulate the toss of a coin.
 * For 10,000 tosses determine how many heads and how many tails are tossed.
 * Also indicate what the last toss was.
 * 	To simulate a coin toss we just need to obtain a random number with os either 0 (tails)
 * 	or 1 (heads)
 */

	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog("Enter the limit of coin tosses)");
		Scanner inputScanner = new Scanner ( input );
		int limitOfTosses = inputScanner.nextInt ();
		inputScanner.close();
		int headsCount = 0;
		int tailsCount = 0;
		String finalTossWord = null;
		for (int count = 1; (count <= limitOfTosses); count ++)
		{
			Random generator = new Random();
			boolean headOrTail = generator.nextBoolean();
			if (headOrTail == true)
			{
				headsCount+=1;
			}
			else
			{
				tailsCount+=1;
			}
			if(count == limitOfTosses)
			{
				boolean finalToss = headOrTail;
				if (finalToss == true)
				{
					finalTossWord = "heads";
				}
				else
				{
					finalTossWord = "tails";
				}
			}
		}
		System.out.print("After a toss of " + limitOfTosses + " coins, " + headsCount + " were heads, " + 
		tailsCount + " were tails and the final coin toss was " + finalTossWord + ".");
	}

}
