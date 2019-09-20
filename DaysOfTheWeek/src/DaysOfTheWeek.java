import java.util.Scanner;
import javax.swing.JOptionPane;
/* Question:
 * Write a program which takes a date in day/month/year format (e.g. 25/11/2015) from the user and, if the date is valid, 
 * then it presents the date in, for example, “Wednesday, 25th November 2015” format.
You must write and make use of at least the following functions:

- numberEnding() which takes a day number returns “th”, “st”, “nd” or “rd”.
- monthName() which takes a month number (1-12) and return “January”, or “February”, …
- dayOfTheWeek() which takes a day, month and year and returns “Monday”, or “Tuesday”, …
The day of the week function should use the Gaussian algorithm…

w = (day + floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + y + floor(y/4) + floor(c/4) - 2c) mod 7
where
 Y: year-1 for January or February,
  year for the rest of the year
 y: last 2 digits of Y
 c: first 2 digits of Y
 w: day of week (0=Sunday,..6=Saturday)
  mod 7 needs to return a positive number (even if the
  passed value is negative.
NOTE:  You may incorporate functions from code provided to you within this course but must give appropriate credit.
 */
/* SELF ASSESSMENT
1. Did I use appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5
       Comment: Appropriate CONSTANTS are used throughout the code to replace numbers.
2. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 5:5 
       Comment:  Yes, the variables are all formatted correctly with local variables used in lowerCamelCase.
3. Did I indent the code appropriately?
       Mark out of 5: 5
       Comment: All code has been formatted correctly with reference to examples and the coding standard given.
4. Did I define the required functions correctly (names, parameters & return type) and invoke them correctly?
      Mark out of 20:20
       Comment: All functions have been given the correct names, parameters and return types to invoke correctly.
5. Did I implement the dayOfTheWeek function correctly and in a manner that can be understood?
      Mark out of 20: 20
       Comment: The dayOfTheWeek functions operates correctly and in a manner that can be understood.
6. Did I implement the other functions correctly, giving credit for any code that you take from elsewhere?
      Mark out of 20: 20
       Comment: The credit for the code written for the validDate function, daysInMonth function and the 
       isLeapYear function goes to Mr. Kenneth Dawson-Howe. I have given credit in the code where credit is deserved.
7. Did I obtain (and process) the input from the user in the correct format (dd/mm/yyyy), and deal with any invalid input properly?       
     Mark out of 10: 10
       Comment: The input is formatted correctly and is processed correctly. Any invalid dates are told they are invalid and that the user must try again.
8. Does the program produce the output in the correct format (e.g. Monday, 25th December 2017)?
      Mark out of 10: 10
       Comment:  The program produces an output in the same format as the format requested in the question.
9. How well did I complete this self-assessment?
       Mark out of 5:5
       Comment:I believe I completed this self-assessment accurately and logically, and from my point of view there is nothing wrong with this code.
    	That being said there may be something wrong here that I do not see.
Total Mark out of 100 (Add all the previous marks): 100
*/ 
public class DaysOfTheWeek {
	
	// Note: There is no such thing as year 0, History notes that the years went 1BC to 1AD, there was no 0AD/0BC.
	// As such a year input of 0 is corrected to 1AD.
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;
	
	public static void main(String[] args) {
		
		
		String input = JOptionPane.showInputDialog("Enter the date in day/month/year format (i.e. DD/MM/YYYY). ");
		Scanner inputScanner = new Scanner ( input );
		inputScanner.useDelimiter("/");
		int day = inputScanner.nextInt();
		int month = inputScanner.nextInt();
		int year = inputScanner.nextInt();
		if (year == 0)
		{
			year = year + 1;
		}
		inputScanner.close(); 
		
		// The credit for the code written for the validDate function, daysInMonth function and the isLeapYear function goes to Mr. Kenneth Dawson-Howe.
		if (validDate( day, month, year))
		{	
			
			String dayNumber = null;
			String monthName = null;
			String dayName = null;
			dayNumber = numberEnding (day);
			monthName = getMonthName (month);
			dayName = dayOfTheWeek (day, month, year);
			JOptionPane.showMessageDialog(null, dayName + ", " + dayNumber + " " + monthName + " " + year + ". " );
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Sorry, that is not a valid date. Try again. ");
		}
	}	
	
	// The credit for the code written for the validDate function, daysInMonth function and the isLeapYear function goes to Mr. Kenneth Dawson-Howe.
	public static boolean validDate( int day, int month, int year)
	{
		return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) &&
				(day >= 1) && (day <= daysInMonth( month, year )));
	}
	
	// The credit for the code written for the validDate function, daysInMonth function and the isLeapYear function goes to Mr. Kenneth Dawson-Howe.
	public static int daysInMonth( int month, int year )
	{
		int numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
		switch (month)
		{
		case 2:
			numberOfDaysInMonth = isLeapYear( year ) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR :
				                                       DAYS_IN_FEBRUARY_NORMALLY;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
			break;
		default:
			numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
			break;
		}
		return numberOfDaysInMonth;
	}
	
	// The credit for the code written for the validDate function, daysInMonth function and the isLeapYear function goes to Mr. Kenneth Dawson-Howe.
	public static boolean isLeapYear( int year )
	{
		return (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
	}
	
	public static String numberEnding (int day)  {
		String dayNumber = "";
		int dayCalculation = day%10;
		if (11 <= day && day <= 13)
		{
			dayCalculation = dayCalculation + 10;
		}
		switch (dayCalculation)
			{
			case 1:
				dayNumber = day + "st";
				break;
			case 2:
				dayNumber = day + "nd";
				break;
			case 3:
				dayNumber = day + "rd";
				break;
			case 11:
			case 12:
			case 13:
			default:
				dayNumber = day + "th";
				break;
			}
		return dayNumber;
	}

	public static String getMonthName (int month) {
		String monthName = "";
		switch (month)
		{
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName ="December";
			break;
		}
	return monthName;
	}	
	
	public static String dayOfTheWeek ( int day, int month, int year) {
		
		double dayOfWeekNumber = 0; 
		if (month == 1)
		{
			year = year - 1;
		}
		else if (month == 2)
		{
			year = year - 1;
		}
		int lastTwoDigitsOfYear = year % 100;
		int firstTwoDigitsOfYear = 0;
		firstTwoDigitsOfYear = getFirstTwoDigitsOfYear( year);
		//formula
		//w = (day + floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + y + floor(y/4) + floor(c/4) - 2c) mod 7
		//y=last, c=first2
		dayOfWeekNumber = (day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + lastTwoDigitsOfYear + Math.floor(lastTwoDigitsOfYear/4) +
				Math.floor(firstTwoDigitsOfYear/4) - (2 * firstTwoDigitsOfYear)) % 7;
		String dayName = null;
		if (dayOfWeekNumber < 0)
		{
			dayOfWeekNumber = dayOfWeekNumber + 7;
		}
		
		int intDayOfWeekNumber = (int) Math.round(dayOfWeekNumber);
		switch (intDayOfWeekNumber)
		//test samples
		//11/11/2018/sun
		//1/2/2000/tues
		//1/2/1931/sun
		//1/1/1600/sat
		//3/3/1920/wed
		{
		case 0:
			dayName = "Sunday";
			break;
		case 1:
			dayName = "Monday";
			break;
		case 2:
			dayName = "Tuesday";
			break;
		case 3:
			dayName = "Wednesday";
			break;
		case 4:
			dayName = "Thursday";
			break;
		case 5:
			dayName = "Friday";
			break;
		case 6:
			dayName = "Saturday";
			break;
		}
		return dayName;
	}
	
	public static int getFirstTwoDigitsOfYear (int year)
	{
		int firstTwoDigitsOfYear = year;
		while (firstTwoDigitsOfYear >= 100)
		{
			firstTwoDigitsOfYear = firstTwoDigitsOfYear/10;
		}
	return firstTwoDigitsOfYear;
	}
}

