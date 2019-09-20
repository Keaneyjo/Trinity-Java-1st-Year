/* Question: Twelve Days of Christmas
Write a program to produce the lyrics (all 12 verses) of the Twelve Days of Christmas. This is a cumulative song as each 
verse is build on top of the previous verses.  You must

have a loop for the verses,
build up each of the verses within a loop (or switch statement),
use at least one switch statement in your solution,
only write the lines of text (or constants representing them) from the song once in your program 
(e.g. you cannot have more than one statement in the entire program which prints out "my true love sent to me")... 
Sample output.

On the first day of Christmas
my true love sent to me:
a Partridge in a Pear Tree. 
On the second day of Christmas
my true love sent to me:
2 Turtle Doves
and a Partridge in a Pear Tree. 
On the third day of Christmas
my true love sent to me:
3 French Hens,
2 Turtle Doves
and a Partridge in a Pear Tree
 ...
 */
/* Solution: 
 * Song lyrics: https://www.41051.com/xmaslyrics/twelvedays.html
 * verse counter
 * Loop the whole song
 * verse counter++
 * String day and line
 * switch case 12{
 * if verseCounter == 12
 * day string =12
 * verseLine = line
 * verseString = verseString + new line}
 * case 11{ etc. decreasing order}
 * system.out.print (dayString +verseLine)
 * do-while (counter < 13)
 */
/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5
       Appropriate CONSTANTS are used throughout the code to replace numbers.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       All CONSTANT names are simple and formatted correctly in UPPERCASE.
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)? 
       Mark out of 10: 10
       Yes, the variables are all formatted correctly with local variables used in lowerCamelCase. 
       All variables are given meaningful names that are easy-to-understand and self explanatory. 
   4. Did I indent the code appropriately? 
       Mark out of 10: 10
       All code has been formatted correctly with reference to examples and the coding standard given.
   5. Did I use an appropriate loop (or loops) to produce the different verses? 
       Mark out of 20:20
       An appropriate loop is used to create the different verses correctly.
   6. Did I use a switch to build up the verses? 
       Mark out of 25: 25
       A switch is used in a manner which add a new line to each verse just like the song.
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))? 
       Mark out of 10: 10
       Duplicates are avoided and every line of the song is only used once in the code.
   8. Does the program produce the correct output? 
       Mark out of 10: 10
       The program produces the correct output, a copy of the lyrics of the song.
   9. How well did I complete this self-assessment? 
       Mark out of 5: 5
       I believe I completed this self-assessment accurately and logically, and from my point of view there is nothing wrong with this code.
       That being said there may be something wrong here that I do not see.
   Total Mark out of 100 (Add all the previous marks): 100
*/

public class TwelveDaysOfChristmas{
	
	public static final int VERSE_1 = 1;
	public static final int VERSE_2 = 2;
	public static final int VERSE_3 = 3;
	public static final int VERSE_4 = 4;
	public static final int VERSE_5 = 5;
	public static final int VERSE_6 = 6;
	public static final int VERSE_7 = 7;
	public static final int VERSE_8 = 8;
	public static final int VERSE_9 = 9;
	public static final int VERSE_10 = 10;
	public static final int VERSE_11 = 11;
	public static final int VERSE_12 = 12;
	public static void main(String[] args) {
		
		int verseCounter = 0;
		do
		{
			verseCounter ++;
			String verseString = "";
			String dayString = "";
			switch (verseCounter)
			{
			case 12:
				if (verseCounter == VERSE_12)
				{	
					dayString = "twelfth";
				}
				verseString = verseString + "12 Drummers Drumming, ";
			case 11:
				if (verseCounter == VERSE_11)
				{	
					dayString = "eleventh";
				}
				verseString = verseString + "11 Pipers Piping, ";
			case 10:
				if (verseCounter == VERSE_10)
				{	
					dayString = "tenth";
				}
				verseString = verseString + "10 Lords a Leaping, ";
			case 9:
				if (verseCounter == VERSE_9)
				{	
					dayString = "ninth";
				}
				verseString = verseString + "9 Ladies Dancing, ";
			case 8:
				if (verseCounter == VERSE_8)
				{	
					dayString = "eighth";
				}
				verseString = verseString + "8 Maids a Milking, ";
			case 7:
				if (verseCounter == VERSE_7)
				{
					dayString = "seventh";
				}
				verseString = verseString + "7 Swans a Swimming, ";
			case 6:
				if (verseCounter == VERSE_6)
				{
					dayString = "sixth";
				}
				verseString = verseString + "6 Geese a Laying, ";
			case 5:
				if (verseCounter == VERSE_5)
				{
					dayString = "fifth ";
				}
				verseString = verseString + "5 Golden Rings, ";
			case 4:
				if (verseCounter == VERSE_4)
				{
					dayString = "fourth";
				}
				verseString = verseString + "4 Calling Birds, ";
			case 3:
				if (verseCounter == VERSE_3)
				{
					dayString = "third";
				}
				verseString = verseString + "3 French Hens, ";
			case 2:
				if (verseCounter == VERSE_2)
				{
					dayString = "second";
				}
				verseString = verseString + "2 Turtle Doves ";
			case 1:
				if (verseCounter == VERSE_1)
				{
				dayString = "first";
				}
				if (verseCounter > VERSE_1)
				{
					verseString = verseString + "And a Partridge in a Pear Tree.";
				}
				else
				{
					verseString = verseString + "A Partridge in a Pear Tree.";
				}
				break;
			}
			System.out.println("On the " + dayString + " day of Christmas,");
			System.out.println("My true love sent to me,");
			System.out.println(verseString);
		}while (verseCounter < 12);
	}
}

