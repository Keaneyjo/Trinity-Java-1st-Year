import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Write a program which turns:
 * 1 old penny = 67 new pennies
 * 1 old shilling = 12 old pennies
 * 1 old pound = 20 old shillings
 * 1 new pound = 100 new pennies
 */
/*  SELF ASSESSMENT
1. Did I use appropriate CONSTANTS instead of numbers within the code?
    Mark out of 10: 10
    Yes all numbers within the code are given CONSTANTS.
2. Did I use easy-to-understand, meaningful CONSTANT names?
    Mark out of 5: 5
    Yes, all CONSTANT names are meaningful and simple to understand. It's easy to tell what a CONSTANT represents based on it's name.
 3. Did I format the CONSTANT names properly (in UPPERCASE)?
    Mark out of 5: 5
    Yes, all CONSTANTS are written in UPPERCASE  and final declarations are used.
4. Did I use easy-to-understand meaningful variable names?
    Mark out of 10: 10
    All variables are given meaningful names that are easy-to-understand and self explanatory.
5. Did I format the variable names properly (in lowerCamelCase)?
    Mark out of 10: 10
    Yes, the variables are all formatted correctly with local variables used in lowerCamelCase.
6. Did I indent the code appropriately?
    Mark out of 10: 10
    All code has been indented correctly with reference to the coding standard given.
7. Did I read the input correctly from the user using (an) appropriate question(s)?
    Mark out of 10: 10
    An appropriate question with simple format is used for the input. 
8. Did I compute the answer correctly for all cases?
    Mark out of 20: 20
    I believe that for all possible inputs the answer should be given correctly.
9. Did I output the correct answer in the correct format (as shown in the examples)?
    Mark out of 10: 10
    The output is given the correct format, replicating the format of the examples given.
10. How well did I complete this self-assessment?
    Mark out of 10: 10
    I believe I completed this self-assessment accurately and logically, and from my point of view there is nothing wrong with this code.
    That being said there may be something wrong here that I do not see.
Total Mark out of 100 (Add all the previous marks): 100  
*/

public class NewMoney {
			
	public static final int OLD_PENNY_TO_NEW_PENNY = 67;
	public static final int OLD_SHILLING_TO_OLD_PENNY = 12*OLD_PENNY_TO_NEW_PENNY;
	public static final int OLD_POUND_TO_OLD_SHILLING = 20*OLD_SHILLING_TO_OLD_PENNY;
	public static final int NEW_PENNY_TO_NEW_POUND = 100;

	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("Enter your total amount of old currency as (old pound:old shilling:old penny)");
		Scanner inputScanner = new Scanner( input );
		inputScanner.useDelimiter(":");
		double oldPound = inputScanner.nextDouble();
		double oldShillings = inputScanner.nextDouble();
		double oldPennies = inputScanner.nextDouble(); 
		inputScanner.close();
				
		double totalNewMoney = ((oldPound*OLD_POUND_TO_OLD_SHILLING) + (oldShillings*OLD_SHILLING_TO_OLD_PENNY) + (oldPennies*OLD_PENNY_TO_NEW_PENNY)) 	
																																/ NEW_PENNY_TO_NEW_POUND;
		System.out.printf (oldPound+ " old pound" + ", " + oldShillings + " old shilling" + ", " + oldPennies + " old pence = £" + String.format
																																("%.2f", totalNewMoney ));
		}
		
}