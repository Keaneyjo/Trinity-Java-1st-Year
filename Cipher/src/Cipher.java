import java.util.Random;
import java.util.Scanner;

/* Question:    
Write a Java program which repeatedly converts (user entered) plain text to cipher text using a 
 * substitution cipher (in which plain text letters are randomly assigned to cipher text letters), and then 
 * converts it back again (just to be sure that we can decrypt it).  Note that a Substitution Cipher replaces plaintext 
 * with cipher-text. The most common substitution ciphers replace single characters of plaintext with predefined single characters 
 * of cipher-text (e.g. the plain-text character `a' might be replaced by cipher text character 'q', 'b' might be replaced 
 * by 'x', 'c' by 'k' and so on).  Each plain-text character should be replaced by a different cipher-text character.

As part of your solution you must write and use at least the following functions/methods:
(i)    createCipher() which determines and returns the mapping from plain text to cipher text.  
Each plain text character ('a' .. 'z', ' ') must be randomly assigned a cipher-text character;
(ii)   an encrypt() method which takes a plain text phrase (as an array of characters) & the cipher 
and returns an encrypted version of the phrase according to the substitution cipher;
(iii)  a decrypt() which takes an encrypted phrase (as an array of characters) & the cipher mapping and 
returns a plain text version of the phrase according to the substitution cipher

Hints:
A 27 element 1-D array (26 letters and the space character) can be used for the mapping where 
each element is the cipher-text character corresponding to a particular letter.
Given a String called myString you can create an array of characters as follows:
o   char[] characterArray = myString.toCharArray();
To convert back to a String:
o  String anotherString = new String( characterArray );
To convert a String to lowercase:
o   String lowercaseString = myString.toLowerCase();
*/

/* My Solution:
 * ===========================================
1. Substitute
2. Encrypt
3. Decrypt
-------------------------------------------
1. Substitute
-+-+- End goal; Create a substitute cipher with all numbers and letters filled in the array
e.g. int array [a] = b 
- ask you word
- convert string to char array
- wordArray = convert to lower case
+
- create numberCipher (1-27)
- create a copy of numberCipher for later
- temp = generate random number from numberCipher
- remove said number from numberCipher
- allocate letter to number from alphabetArray i.e. alphabetArray [1] = "h"
						    alphabetArray [4] = "z"
- move to next letter of alphabet, no need to pick random letter if number is already random
- this should be in a for loop until numberCipher is empty


2. Encrypt
- convert wordArray to its number equivalent (that for loop I saw on stack overflow?)
- pass this through alphabetArray (not sure how to do this either)
- encryptedWordArray = convert wordArray to string
- Output "The word " + wordArray + "encrypted is " + encryptedWordArray

3. Decrypt
- convert encrptedWordArray back to characters
- consider first letter (and then next letter, put this in for loop for each letter)
- if firstLetter = alphabetArray [index], 
	then firstLetter = index
- add firstLetter = to unecryptedWord
- all the numbers then correspond to the letters of the alphabet so ....
	function create sequentialAlphabetArray e.g. sequentialAlphabetArray [0] = "a"
						     sequentialAlphabetArray [1] = "b"   ......
					........     sequentialAlphabetArray [26] = " "
- pass unecryptedWord (is this an array) through sequentialAlphabetArray
- ??? convert to String ???
- output

 */

/* SELF ASSESSMENT
1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 5:5
       Comment:  Yes, the variables are all formatted correctly with local variables used in lowerCamelCase and are simple. 
2. Did I indent the code appropriately?
       Mark out of 5: 5
       Comment: The code is indented correctly with references to the coding standard and samples given
3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?
      Mark out of 20: 20
       Comment:The createCipher function is given correct parameters, a correct return type and a correct function body.
4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?
      Mark out of 20: 20  
       Comment:The encrypt function is given correct parameters, a correct return type and a correct function body.
5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?
      Mark out of 20: 20  
       Comment:The decrypt function is given correct parameters, a correct return type and a correct function body.
6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?
      Mark out of 25: 25   
       Comment:Yes the main function body works correctly and we can see this as the input and decrypted word are identical.
7. How well did I complete this self-assessment?
       Mark out of 5:5
       Comment:I believe I completed this self-assessment accurately and logically, and from my point of view there is nothing wrong with this code.
 		That being said there may be something wrong here that I do not see.
Total Mark out of 100 (Add all the previous marks):100
*/ 

public class Cipher {
	public static final int LOWEST_RANDOM_VALUE = 0;
	public static final int HIGHEST_RANDOM_VALUE = 27;
	public static final int ALPHABET_LENGTH_PLUS_SPACE = 27;
	public static void main(String[] args) {
		boolean finished = false;
		Scanner input = new Scanner(System.in);
		do  {
			System.out.print("Enter the word you wish to cipher separated by spaces (or enter quit):");
			if (input.hasNext("quit"))
			{
		        finished = true;
			}
			else
		    {		         
		        String myStringUppercase = input.nextLine();
		        String myString = myStringUppercase.toLowerCase();
		        char[] wordArray = myString.toCharArray();
				System.out.println("The word, when covered to lowercase, is " + myString + ".");
				
				
				char [] substituteCipher = createCipher();
				
				System.out.print("Your cipher is ");
				for (int index = 0; index <= 26; index++)
				{
					System.out.print(substituteCipher [index]);
				}
				System.out.println(". ");
				System.out.println("The letters are ordered sequentially, ");
				System.out.println(" e.g. a = " + substituteCipher[0] );
				System.out.println(" e.g. b = " + substituteCipher[1] + " ,etc." );
				
				char [] encryptedWord = Encrypt (wordArray, substituteCipher);
				String encryptedWordString = new String( encryptedWord );
				System.out.println("Therefore your encrypted word is " + encryptedWordString + "." );
				
				char [] decryptedWord = Decrypt (encryptedWord, substituteCipher);
				String decryptedWordString = new String( decryptedWord );
				System.out.println("And the decrypted version of the word is " + decryptedWordString + "." );
		    }
		} while (!finished);
		input.close();
	}
	public static char [] createCipher ()
	{
		int counter = 0;
		char [] substituteCipher = new char [27];
		boolean emptyValue = true;
		char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
		int index = 0;
		int [] listOfCipherNumbers = new int [ALPHABET_LENGTH_PLUS_SPACE];
		for (int numberCounter = 1; numberCounter <= ALPHABET_LENGTH_PLUS_SPACE; numberCounter++)
		{
			listOfCipherNumbers [numberCounter - 1 ] = numberCounter;
		}
		do
		{
			Random generator = new Random();
			do 
			{
				int randomNumber = generator.nextInt(HIGHEST_RANDOM_VALUE-LOWEST_RANDOM_VALUE) + LOWEST_RANDOM_VALUE;
				if (listOfCipherNumbers [randomNumber] != 0)
				{
					emptyValue = false;
					listOfCipherNumbers [randomNumber] = 0;
					char letter = alphabetArray [ index ];
					substituteCipher [randomNumber] = letter;
					index++;
					counter++;
				}
			} while (emptyValue == true );
		} while (counter < ALPHABET_LENGTH_PLUS_SPACE);
		return substituteCipher;
	}
	
	public static char [] Encrypt (char [] wordArray, char [] substituteCipher)
	{
		char [] encryptedWord = new char [wordArray.length];
		char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
		for (int index = 0; index < wordArray.length; index++)
		{
			boolean characterSearch = true;
			char arrayLetter = wordArray [index];
			int index2 = 0;
			do   
			{
				if (arrayLetter == alphabetArray[index2])
				{
					characterSearch = false;
					encryptedWord [index] = substituteCipher[index2];
				} 
				index2++;
			} while (characterSearch == true);
		}
		return encryptedWord;
	}
	
	public static char [] Decrypt (char [] encryptedWord, char [] substituteCipher)
	{
		char [] DecryptedWord = new char [encryptedWord.length];
		char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
		for (int index = 0; index < encryptedWord.length; index++)
		{
			boolean characterSearch = true;
			char arrayLetter = encryptedWord [index];
			int index2 = 0;
			do   
			{
				if (arrayLetter == substituteCipher[index2])
				{
					characterSearch = false;
					DecryptedWord [index] = alphabetArray[index2];
				} 
				index2++;
			} while (characterSearch == true);
		}	
		return DecryptedWord;
	}
}



