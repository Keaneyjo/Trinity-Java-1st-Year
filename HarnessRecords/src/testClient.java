/* SELF ASSESSMENT

Harness Class: Member variables (8 marks) 8
All my data members are declared, private and the ones 
that don't change are marked as private. 
I also have a constant for the maximum number of uses of a harness.
Comment: Yes all members are declared and private and a constant is used for the max number of uses.

Harness Class: Harness constructor 1 & constructor 2 (6 marks) 6
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment: Yes, the above is true

Harness Class: checkHarness method (5 marks) 5
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable
 to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment: Yes it uses the instructor name and sets it as the instructor member if not on loan. It also sets the uses to 0.

Harness Class: isHarnessOnLoan method (2 marks) 2
My method has no parameters and returns the value of the loan status variable.
Comment:Yes the above is true.

Harness Class: canHarnessBeLoaned method (4 marks) 4
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment:Yes te=he above is true.

Harness Class: loanHarness method (6 marks) 6
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the 
club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment: String clubMemberName is used as the parameter and if true follows the above procedure listed in the question.
 
Harness Class: returnHarness method (5 marks) 5
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment:Yes the above is true.

Harness Class: toString method (3 marks) 3
My method returns a String representation of all the member variables.
Comment:Yes the above is true.





HarnessRecords Class: member variables (3 marks) 3
I declare the member variable as a private collection of Harnesses 
Comment: Yes and an ArrayList of type Harness is used.

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks) 9
In the first constructor, I set the member variable to null [1 mark]. 
In the second constructor, I use the set of characteristics in the list to create Harness objects and add them to the collection. 
Comment:Yes all member variables are set to null in the first constructor and then are given characteristics in the second

HarnessRecords Class: isEmpty method (1 marks) 1
I return true if the collection is null/empty and, false otherwise.
Comment: Yes the above is true

HarnessRecords Class: addHarness method (5 marks) 5
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment: Yes the above is true.

HarnessRecords Class: findHarness method (6 marks) 6
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment: A make, model is used to check if the harness exists already and returns the harness in question otherwise returns null.

HarnessRecords Class: checkHarness method (6 marks) 6
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number 
exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name 
as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment: My method checks if the harness exists. If the harness doesnt it returns null. Otherwise updates the harness.

HarnessRecords Class: loanHarness method (7 marks) 7
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. 
If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. 
If there's no available harness null is returned.
Comment: My method loans an available harness calling the canHarnessBeLoaned. It no harness can be returned null is used.

HarnessRecords Class: returnHarness method (7 marks) 7
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. 
If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment: Using the make and model of the harness I check if a harness is available with those properties. Null is returned if no harness like that exists.
Otherwise the harness in question is returned.

HarnessRecords Class: removeHarness method (8 marks) 8
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. 
It returns the harness object if it is found, otherwise returns null.
Comment: Using the make and model my method finds a harness and removes it. Else null is returned.




GUI (Java main line) (5 marks) 5
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: All of the five commands requested are implemented.

*/



import java.util.Scanner;

public class testClient {

	public static void main(String[] args)
	{
		HarnessRecords harnessRecordsOnFile = new HarnessRecords();
		boolean finished = false;
		System.out.print("This program is used to  to keep track of each climbing club harness.\n");
		Scanner scanner = new Scanner(System.in);
		while(!finished)	
		{
			System.out.println("\nPlease enter would you like to:"
					+ "\n-'Add' a record for a newly purchased harness."
					+ "\n-'Remove' a climbing harness from the club"
					+"\n-'Checked', record a harness being checked by an instructor to ensure it is safe."
					+"\n-'Loan' a harness to a club member if there is any available harnesses"
					+"\n-'Return' a harness is no longer in use by a club member"
					+"\n-'Quit' the program");
				if((scanner.hasNext("add"))||(scanner.hasNext("Add")))
				{
					add(harnessRecordsOnFile,scanner);
				}
				else if((scanner.hasNext("remove"))||(scanner.hasNext("Remove")))
				{
					remove(harnessRecordsOnFile,scanner);
				}
				else if((scanner.hasNext("checked"))||(scanner.hasNext("Checked")))
				{
					checked(harnessRecordsOnFile,scanner);
				}
				else if((scanner.hasNext("loan"))||(scanner.hasNext("Loan")))
				{
					loan(harnessRecordsOnFile,scanner);
				}
				else if((scanner.hasNext("return"))||(scanner.hasNext("Return")))
				{
					returned(harnessRecordsOnFile,scanner);
				}
				else if((scanner.hasNext("quit"))||(scanner.hasNext("Quit")))
				{
					System.out.println("Goodbye.");
					finished = true;
				}
				else
				{
					System.out.print("Invalid input, please retry entering the correct instruction.\n");
					System.out.print("Please enter either 'Add','Remove','Checked','Loan','Return' or 'Quit'.");
					scanner.nextLine();
				}
		}
		scanner.close();
	}

	private static void returned(HarnessRecords harnessRecordsOnFile, Scanner scanner) {
		String instruction = "Please enter the harness make:";
		scanner.nextLine();
		String harnessMake = getName(scanner, instruction);
		instruction = "Please enter the harness model number:";
		int modelNumber = getNumber(scanner,instruction);
		if(harnessRecordsOnFile.returnHarness(harnessMake,modelNumber)!=(null))
		{
			System.out.print("\nSuccessful returned the harness with make "+ harnessMake+ " and model number "+modelNumber+".");
		}
		else
		{
			System.out.print("Unable to return the harness with make "+ harnessMake+ " and model number "+modelNumber+". Harness must not exist in our records.");
		}
	}

	private static void loan(HarnessRecords harnessRecordsOnFile, Scanner scanner) {
		String instruction = "Please enter the club member's name:";
		scanner.nextLine();
		String clubMembersName = getName(scanner, instruction);
		if(harnessRecordsOnFile.loanHarness(clubMembersName)!=(null))
		{
			System.out.print("\nSuccessful loaned a harness to "+ clubMembersName+".");
		}
		else
		{
			System.out.print("\nUnable to loan a harness to "+ clubMembersName+". All harnesses must be in use.");
		}
	}
	private static void checked(HarnessRecords harnessRecordsOnFile, Scanner scanner) {
		String instruction = "Please enter the instructors name:";
		scanner.nextLine();
		String instructorsName = getName(scanner, instruction);
		instruction = "Please enter the harness make:";
		String harnessMake = getName(scanner, instruction);
		instruction = "Please enter the model number:";
		int modelNumber = getNumber(scanner,instruction);
		if(harnessRecordsOnFile.checkHarness(instructorsName,harnessMake,modelNumber)!=(null))
		{
			System.out.print("\nSuccessful checked a harness with make "+harnessMake+" and model number "+modelNumber+" for safety by "+ instructorsName+".");
		}
		else
		{
			System.out.print("\nUnable to check a harness with make "+harnessMake+" and model number "+modelNumber+" for safety by "+ instructorsName+"."
					+ "\nThis harness must not exist or is currently on loan.\n");
		}
	}
	private static void remove(HarnessRecords harnessRecordsOnFile, Scanner scanner) {
		String instruction = "Please enter the harness make:";
		scanner.nextLine();
		String harnessMake = getName(scanner, instruction);
		instruction = "Please enter the model number:";
		int modelNumber = getNumber(scanner,instruction);
		if(harnessRecordsOnFile.removeHarness(harnessMake,modelNumber)!=(null))
		{
			System.out.print("\nSuccessfully removed a harness with make "+harnessMake+" and model number "+modelNumber+".");
		}
		else
		{
			System.out.print("\nUnable to remove a harness with make "+harnessMake+" and model number "+modelNumber+".\nThis harness must not exist or is on loan.");
		}
	}

	static void add(HarnessRecords harnessRecordsOnFile, Scanner scanner) {
		String instruction = "Please enter the harness make:";
		scanner.nextLine();
		String harnessMake = getName(scanner, instruction);
		instruction = "Please enter the model number:";
		int modelNumber = getNumber(scanner,instruction);
		instruction = "Please enter the instructors name:";
		String instructorsName = getName(scanner, instruction);
		Harness newHarness = new Harness(harnessMake,modelNumber,instructorsName);
		if(harnessRecordsOnFile.addHarness(newHarness)!=null)
		{
			System.out.print("\nSuccessfully added a harness with make "+harnessMake+", model number "+modelNumber+" bought by instructor "+ instructorsName+".");
		}
		else
		{
			System.out.print("\nUnable to add harness with make "+harnessMake+", model number "+modelNumber+" bought by instructor "+ instructorsName+"."
					+ " One must already exist with these details.");
		}
	}
	private static String getName(Scanner scanner,String instruction) {
		boolean finishedGettingName = false;
		while(!finishedGettingName)
		{
			System.out.println(""+instruction);
			if(scanner.hasNextLine())
			{
				String inputtedPlainText = scanner.nextLine();
				boolean validName = inputtedPlainText.matches("[a-zA-Z ]+");
				if (validName&&inputtedPlainText!="")
				{
					return inputtedPlainText;
				}
				else if (!validName)
				{
					System.out.println("Invalid input.");
				}
			}
			}
		return null;	
	}
	private static int getNumber(Scanner scanner,String instruction) {
		boolean finishedGettingNumber = false;
		while(!finishedGettingNumber)
		{
			System.out.println(""+instruction);
			String number = scanner.nextLine();
				boolean validNumber = number.matches("[0-9]+");
				if (validNumber)
				{
					return Integer.parseInt(number);
				}
				else if (!validNumber)
				{
					System.out.println("Invalid input.");
				}
			}
		return -1;
	}
}