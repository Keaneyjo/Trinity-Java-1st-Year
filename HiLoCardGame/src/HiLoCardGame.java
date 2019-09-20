import java.util.Scanner;
import java.util.Random;

/* Question: USING A WHILE OR A DO-WHILE LOOP write a program which allows the user to play the Hi-Lo Card game:
 * 
 * The Hi-Lo card game is one where the user is presented with an initial card (2 – 10, Jack, Queen, King, or Ace) and has to guess that the next card 
 * will be Higher (Hi), Lower (Lo) or Equal to the current card.
 * They must guess successfully 4 times in a row in order to win.
 * Sample input/output (input is highlighted in red).
 * The card is a 3 
 * Do you think the next card will be higher, lower or equal? higher 
 * The card is a Ace 
 * Do you think the next card will be higher, lower or equal? lower 
 * The card is a 9 
 * Do you think the next card will be higher, lower or equal? lower 
 * The card is a 7 
 * Do you think the next card will be higher, lower or equal? higher 
 * The card is a King 
 * Congratulations.  You got them all correct.
 */
/* Solution:
 *  Part 1: Loop
 *  generate oldCard
 *  if statement print jack/queen/king/ace
 *  else Say this is oldCard
 *  boolean = false
 *  counter = 0
 *  endCount = 0
 *  do/while counter < 3
 *  	counter++
 *  	generate number, ask for high/low/equal
 *  	if high and  new>old print Correct, endCount++, old = new
 *  	else print Wrong, old = new
 *  	repeat for if statement for low/even
 *		else invalid option, start again
 *  Part 2: Result
 *  if/else statement
 *  if (endCount < 3)
 *  - you got endCount count correct.
 *  else
 *  - you got all correct. 
 */
/* SELF ASSESSMENT 
1. Did I use appropriate CONSTANTS instead of numbers within the code? 
    Mark out of 5: 5
    Comment: Appropriate CONSTANTS are used throughout the code to replace numbers.
2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
    Mark out of 5:5
    Comment: All CONSTANT names are simple and formatted correctly in UPPERCASE.
3. Did I use easy-to-understand meaningful variable names? 
    Mark out of 10: 10
    Comment: All variables are given meaningful names that are easy-to-understand and self explanatory. 
4. Did I format the variable names properly (in lowerCamelCase)? 
    Mark out of 5: 5
    Comment: Yes, the variables are all formatted correctly with local variables used in lowerCamelCase.
5. Did I indent the code appropriately? 
    Mark out of 10: 10
    Comment: All code has been formatted correctly with reference to examples and the coding standard given.
6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
    Mark out of 20: 20
    Comment: Yes a do-while loop is used so that the user has 4 guesses. If the user gets less than all 4 right they are just told they lost and
    how many answers they got right.
    If the user gets all 4 right they are told they won the game.
7. Did I check the input to ensure that invalid input was handled appropriately? 
    Mark out of 10: 10 
    Comment: Yes, if an invalid input is given an appropriate response is given and the user is told to restart the game.
8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
    Mark out of 10: 10
    Comment: Yes, the cards are generated randomly using a generator. All cards are equally likely to appear and are limited up to 13 cards.
9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
    Mark out of 10: 10
    Comment: Yes, the cards output correctly as they should, using their given names.
10. Did I report whether the user won or lost the game before the program finished? 
    Mark out of 10: 10
    Comment: The output at the end of the program tells the user how many they got correct and whether they won or lost using an if statement.
11. How well did I complete this self-assessment? 
    Mark out of 5:5
    Comment: I believe I completed this self-assessment accurately and logically, and from my point of view there is nothing wrong with this code.
    That being said there may be something wrong here that I do not see.
Total Mark out of 100 (Add all the previous marks): 100
*/

public class HiLoCardGame {
	
	// OFFSET_VALUE is used to adjust the fact that ACE is given a higher value.
	public static final int MAX_NUMBER = 13;
	public static final int OFFSET_VALUE = 2;
	public static Scanner inputScanner;
	public static void main(String[] args) {
		Random generator = new Random();
		boolean quit = false;
		int guessesCounter = 0;
		int totalCorrect = 0;
		int oldCard = generator.nextInt(MAX_NUMBER) + OFFSET_VALUE;
		do {
			guessesCounter ++;
			Random secondGenerator = new Random();
			if (oldCard == 11)
			{
				System.out.println("The card is a Jack. ");
			}
			else if (oldCard == 12)
			{
				System.out.println("The card is a Queen. ");
			}
			else if (oldCard == 13)
			{
				System.out.println("The card is a King. ");
			}
			// ACE is given a higher value according to Mr. Dawson-Howe's rules for the HI-LO Game.
			else if (oldCard == 14)
			{
				System.out.println("The card is an Ace. ");
			}
			else
			{
			System.out.println("The card is a " + oldCard + ". ");
			}
			int newCard = secondGenerator.nextInt(MAX_NUMBER) + OFFSET_VALUE;
			System.out.print("Do you think the next card will be higher, lower or equal (higher/lower/equal)? ");
			inputScanner = new Scanner(System.in);
			if (inputScanner.hasNext("higher"))
			{
				if(newCard > oldCard)
				{
					System.out.print("Correct! ");
					totalCorrect++;
					oldCard = newCard;
				}
				else
				{
					System.out.print("Sorry, That's the wrong card. ");
					quit = true;
				}
			}
			else if(inputScanner.hasNext("lower"))
			{
				if(oldCard > newCard)
				{
					System.out.print("Correct! ");
					totalCorrect++;
					oldCard = newCard;
				}
				else
				{
					System.out.print("Sorry, That's the wrong card.");
					quit = true;
				}
			}
			else if (inputScanner.hasNext("equal"))
			{
				if(oldCard == newCard)
				{
					System.out.print("Correct! ");
					totalCorrect++;
					oldCard = newCard;
				}
				else
				{
					System.out.print("Sorry, That's the wrong card.");
					quit = true;
				}
			}
			else
			{
				System.out.println("Sorry, that was an invalid input. You'll have to start again.");
				quit = true;
			}
		} while (guessesCounter <= 3 && quit == false);
		if (totalCorrect < 4 )
		{
			System.out.println(" You got " + totalCorrect + " correct. You lost.");
		}
		else
		{
			System.out.println("Congratulations. You got them all correct. You win!");
		}
	}
}
