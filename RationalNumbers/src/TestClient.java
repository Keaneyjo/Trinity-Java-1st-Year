import java.util.Scanner;

/* SELF ASSESSMENT 

Class Retional 
I declared two member variables: numerator and denominator (marks out of 4:4 ).
Comment:Numerator and Denominator are declared
Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . 
If the denominator is equal to 0 I throw an exception (marks out of 5: 5).
Comment: I switched taking two integers for two doubles instead of integers as it gave my program more options. 
An exception is thrown if the demoninator is 0.

Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value . 
I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3:3 ).
Comment: One integers as parameter is taken and this is the numerator.

Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator 
which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8: 8).
Comment: The above is true. 

Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8:8).
Comment: The above is true.

Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8:8).
Comment: The above is true.

Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8:8).
Comment: The above is true.

Equals Method 
My program takes a rational number as a parameter and compares it to the reference object. 
I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. 
I return a boolean value ((marks out of 8:8).
Comment: Multiplication is used to determine whether the values are equal.

isLessThan 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division
 will lead to incorrect results. I return a boolean value (marks out of 8:8).
Comment: Multiplication is used to determine whether the first value is less than the second value.

Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. 
It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) 
between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8:8).
Comment: My program first finds the GCD and then uses this to find a simplified value.

gcd function 
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6:6).
Comment: My program uses an algorithm to determine the GCD.

toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4:4).
Comment: My program creates a a/b representation of the rational numbers.

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the constructor and 
passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints 
out the results (marks out of 22:22).
Comment: My program does all of the above.
*/

public class TestClient {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		boolean divideCheck = false;
		do{
			try
			{
				System.out.print("Enter your value(s/ numerator then denominator), seperated by spaces. ");
				String value = inputScanner.nextLine();
				String[] valuesArray = value.split(" ");
				if(valuesArray.length > 2)
				{
					System.out.println("Sorry, that's too many inputs. Try again");
				}
				else
				{
					double numeratorValue = Double.parseDouble(valuesArray[0]);
					RationalNumbers rational = new RationalNumbers(numeratorValue);
					if (1 < valuesArray.length)
					{
						double denominatorValue = Integer.parseInt(valuesArray[1]);
						rational = new RationalNumbers(numeratorValue, denominatorValue);
						divideCheck = rational.check(denominatorValue);
						
					}
					
					System.out.print("Enter your second value(s/ numerator then denominator), seperated by spaces. ");
					String valueTwo = inputScanner.nextLine();
					String[] valuesArrayTwo = valueTwo.split(" ");
					if(valuesArrayTwo.length > 2)
					{
						System.out.println("Sorry, that's too many inputs. Try again");
					}
					else
					{
						double numeratorValueTwo = Double.parseDouble(valuesArrayTwo[0]);
						RationalNumbers rationalTwo = new RationalNumbers(numeratorValueTwo);
						if (1 < valuesArrayTwo.length)
						{
							double denominatorValueTwo = Integer.parseInt(valuesArrayTwo[1]);
							rationalTwo = new RationalNumbers(numeratorValueTwo, denominatorValueTwo);
							divideCheck = rationalTwo.check(denominatorValueTwo);
							
						}
						
						RationalNumbers rationalAdd = rational.add(rationalTwo);
						System.out.println("Addition = " + rational + " + " + rationalTwo + "= " + rationalAdd);
						RationalNumbers rationalSub = rational.sub(rationalTwo);
						System.out.println("Substitution = " + rational + " - " + rationalTwo + "= " + rationalSub);
						RationalNumbers rationalMul = rational.multiply(rationalTwo);
						System.out.println("Multiplication = " + rational + " x " + rationalTwo + "= " + rationalMul);
						RationalNumbers rationalDiv = rational.divide(rationalTwo);
						System.out.println("Division = " + rational + " '/. " + rationalTwo + "= " + rationalDiv);
						boolean rationalEqual = rational.equal(rationalTwo);
						if (rationalEqual == true)
							System.out.println("Equal = " + rational + " == " + rationalTwo);
						else 
							System.out.println("Not Equal = " + rational + " != " + rationalTwo);
						boolean rationalLess = rational.isLessThan(rationalTwo);
						if (rationalLess == true)
							System.out.println("Less Than = " + rational + " <= " + rationalTwo);
						else 
							System.out.println("Not Less Than = " + rational + " !(<=) " + rationalTwo);
						RationalNumbers rationalSimplify = rational.simplify(rationalTwo);
						RationalNumbers rationalSimplifyTwo = rationalTwo.simplify(rationalTwo);
						System.out.println("First Value Simplified = " + rationalSimplify);
						System.out.println("Second Value Simplified = " + rationalSimplifyTwo);
					}
				}

			}
			catch(java.lang.NumberFormatException exception)
			{
				System.out.println("Incorrect input. Starting program again.");
			}
			catch(java.util.InputMismatchException exception)
			{
				System.out.println("Incorrect input. Starting program again.");
			}
			catch (NullPointerException exception)
			{
				System.out.println("Incorrect input. Starting program again.");
			}
			catch (java.util.NoSuchElementException exception)
			{
				System.out.print("Incorrect input. Starting program again.");
			}
		} while (divideCheck == false);
		inputScanner.close();
	}
}

