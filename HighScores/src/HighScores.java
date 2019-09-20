/* SELF ASSESSMENT:
 * 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
 * Mark out of 5:5
 * Comment: All variables have been formatted correctly with simple names in lowerCamelCase.
 * 2. Did I indent the code appropriately?
 * Mark out of 5:5
 * Comment: All code has been formatted correctly with reference to examples and the coding standard given.
 * 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?
 * Mark out of 15:15
 * Comment: The initialiseHighScores function is given correct parameters, a correct return type and a correct function body.
 * 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?
 * Mark out of 15:15
 * Comment: The printHighScores function is given correct parameters, a correct return type and a correct function body.
 * 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?
 * Mark out of 15:15
 * Comment: The higherThan function is given correct parameters, a correct return type and a correct function body.
 * 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?
 * Mark out of 20:20
 * The insertScore function is given correct parameters, a correct return type and a correct function body.
 * 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?
 * Mark out of 20:20
 * Comment: Yes, the function body is written correctly asking first for the number of scores and then asking for the scores
 * 8. How well did I complete this self-assessment?
 * Mark out of 5:5
 * Comment: I believe I completed this self-assessment accurately and logically, and from my point of view there is nothing wrong with this code.
 * That being said there may be something wrong here that I do not see.
 * Total Mark out of 100 (Add all the previous marks):100
 */
import java.util.Scanner;

public class HighScores {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("How many scores are there?:");
        int numberOfScores = input.nextInt();
        int[] INTIALISEDSCORES = {};
        int[] HIGHSCORES = initialiseHighScores(numberOfScores, INTIALISEDSCORES);
        System.out.println("Now enter the scores:");
        int[] FINALHIGHSCORES = insertScores(HIGHSCORES, numberOfScores);
        printHighScores(numberOfScores, FINALHIGHSCORES);
        input.close();
    }
    public static int[] initialiseHighScores(int numberOfScores, int[] INTIALISEDSCORES){
        INTIALISEDSCORES = new int [numberOfScores];
        for (int index = 0; index <= (numberOfScores-1); index++)
        {
            INTIALISEDSCORES[index] = 0;
        }

        return INTIALISEDSCORES;
    }
    public static int[] insertScores(int[] HIGHSCORES, int numberOfScores) {
        Scanner inputScanner = new Scanner(System.in);
        int[] SCORES = {};
        for (int index = 0; index <= (numberOfScores-1); index++)
        {
            int scores = inputScanner.nextInt();
            if(scores < 0){
                System.out.println("Sorry, that's not a correct answer. Please try again and enter another.");
                scores = inputScanner.nextInt();
                HIGHSCORES[index] = scores;
            }
            else {
                HIGHSCORES[index] = scores;
            }
        }
        for (int index = 0; index >= (numberOfScores-1); index++){
            for (int scoreSaverCounter = 0; scoreSaverCounter <= (numberOfScores-1); scoreSaverCounter++){
                if (SCORES[index] < SCORES[scoreSaverCounter]){
                    int saveNo = 0;
                    for (int scoreSaverCounterTwo = (numberOfScores-1); scoreSaverCounterTwo >= 0; scoreSaverCounterTwo--){
                        SCORES[index] = saveNo;
                        SCORES[scoreSaverCounterTwo] = SCORES[scoreSaverCounterTwo+1];
                    }
                    SCORES[numberOfScores-1] = saveNo;
                }
            }
            inputScanner.close();
        }
        HIGHSCORES = higherThan (HIGHSCORES);
        return HIGHSCORES;
    }
    public static int[] higherThan(int[] HIGHSCORES){
    	int temp;
    	for(int index = 0; index < HIGHSCORES.length - 1 / 2; index++){
    		for(int index2 = 1; index2 < HIGHSCORES.length - index / 2; index2++){
    			if (HIGHSCORES [index2 -1] < HIGHSCORES [index2])
    			{
    				temp = HIGHSCORES [index2 - 1];
    				HIGHSCORES [index2 - 1] = HIGHSCORES [index2];
    				HIGHSCORES [index2] = temp;
    			}
    		}
    	}
    	return HIGHSCORES;
    }
    public static void printHighScores (int numberOfScores, int []FINALHIGHSCORES)
    {
    	System.out.print("The high scores are ");
        for (int index = 0; index <= (numberOfScores-1); index++){
        	if( index == numberOfScores -1)
        	{
        		System.out.print(FINALHIGHSCORES[index] + ".");
        	}
        	else
        	{
        		System.out.print(FINALHIGHSCORES[index] + ", ");
        	}
        }
        return;
    }
}