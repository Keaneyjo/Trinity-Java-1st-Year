import java.util.Scanner;

/* SELF ASSESSMENT  
1.  createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: The correct method header and a method body are given making the correct definition. 
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment:Yes an array of size n is created and initialised using the createSequence method.
Did I return the correct item?
Mark out of 5:5
Comment:Yes an initialised array is returned
2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment:As with the createSequence method, the crossOutMultiples has the correct definition.
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:2
Comment:None of the parameters are null and one of them is a valid index into the array
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment:The array uses an increments to find every multiple and it loops until the multiple reaches above the square root of the number.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:3
Comment:All non-primes are "crossed out".
3.  sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:As with the above two methods, this function uses the correct definition.
Did I make calls to other methods?
Mark out of 5:5
Comment:Yes I call the crossOutHigherMultiples and Sequence to String Methods      
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:2
Comment:The returned array of consists of primes and non-primes crossed out.
4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5:5
Comment:Like the other methods, the correct function definition is used.
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: Yes the parameter used is not null.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment:Yes, crossed out numbers are given brackets and not crossed are primes.
5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment:The correct function definition is used. 
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:The parameter used is not null.
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5:5
Comment:Yes, only non-crossed out numbers (primes) are used.
6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:5
Comments:Yes the user is asked for an integer above 2. Any value other than this will be handled as an exception.
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment: Yes all other methods are called from main.
Did I print the output as shown in the question?  
Mark out of 5:5
Comment: The output is printed the same as the sample question.
7.  Overall
Is my code indented correctly?
Mark out of 4:4
Comments: The code is indented correctly with reference to sample answers and the coding standard given.
Do my variable names make sense?
Mark out of 4:4
Comments:Yes all variable names make sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4:4
Comments:Yes, the code follows the java coding standard laid out to us in class.
   Total Mark out of 100 (Add all the previous marks): 100
*/


public class SieveOfEratosthenes {

	public static void main(String[] args) {
		try
		{
			boolean continueProgram = true;
			Scanner inputScanner = new Scanner(System.in);
			do 
			{
				System.out.print("Enter the an integer value greater than 2: ");
				int number = inputScanner.nextInt();
				if (number <= 2)
				{
					System.out.println("Sorry that value is less than or equal to two. Try again.");
				}
				else if (number > 2)
				{
					int [] substituteSequence = createSequence (number);
					int [] substituteSequenceClone = substituteSequence.clone();
					int [] sieve = sieve(substituteSequenceClone, substituteSequence, number );
					String justPrimes = nonCrossedOutSubseqToString(substituteSequence, sieve, number );
					System.out.print(justPrimes);
					continueProgram = false;
				
				}
			}while (continueProgram == true);
			inputScanner.close();
		}
		catch (NullPointerException exception)
		{
		}
		catch (java.util.NoSuchElementException exception)
		{
			System.out.print("Incorrect input. Re-run program to try again.");
		}
	}
	
	public static int [] createSequence  (int number)
	{
		int [] substituteSequence = new int [number+1];
		for (int index = 0; index <= number; index++)
		{
			substituteSequence [index] = index;
		}
		return substituteSequence;
	}
	
	public static int [] sieve (int [] substituteSequenceClone, int [] substituteSequence, int number)
	{
		int [] crossOutHigherMultiples = null;
		int [] sieve =  substituteSequence;
		double sqrtNumber = Math.sqrt(number);
		if (number != 3)
		{
			for (int index = 2; index <= sqrtNumber; index++)
			{
				crossOutHigherMultiples = crossOutHigherMultiples(substituteSequenceClone, substituteSequence, sieve, index, number);
			}
		sieve = crossOutHigherMultiples;
		}	
		return sieve;
	}
	
	public static int [] crossOutHigherMultiples(int [] substituteSequenceClone, int [] substituteSequence, int [] sieve, int index, int number)
	{
		int [] crossOutHigherMultiples = sieve;
		int increment = index;
		index = index + increment;
		do {
			crossOutHigherMultiples [index] = 0;
			index = index + increment;
		} while (index <= number);
		String stringSieve = sequenceToString(substituteSequenceClone, substituteSequence, sieve, number);
		System.out.println(stringSieve);
		return crossOutHigherMultiples;
	}
	
	public static String sequenceToString (int [] substituteSequenceClone, int [] substituteSequence, int [] sieve, int number)
	{
		String stringSieve = "";
		for (int index = 2; index< substituteSequence.length; index++)
			if (sieve [index] == 0)
			{
				stringSieve = stringSieve + "[" + substituteSequenceClone [index] + "]";
				if (substituteSequenceClone [index] != number)
				{
					stringSieve = stringSieve + ", ";
				}
			}
			else if (sieve [index] != 0)
			{
				stringSieve = stringSieve + sieve [index];
				if (substituteSequenceClone [index] != number)
				{
					stringSieve = stringSieve + ", ";
				}
			}
		return stringSieve;
	}
	
	public static String nonCrossedOutSubseqToString(int [] substituteSequenceClone, int [] sieve, int number )
	{
		int highestValue = 0;
		String stringSieve = "";
		for (int index = 2; index < substituteSequenceClone.length; index++)
		{
			if (sieve[index] > highestValue)
			{
			highestValue = index;
			}
		}
		for (int index = 2; index < substituteSequenceClone.length; index++)
		{
			if (sieve [index] != 0)
			{
				stringSieve = stringSieve + sieve [index];
				if (index != highestValue)
				{
					stringSieve = stringSieve + ", ";
				}
			}
		}
		return stringSieve;
	}
}

