import java.util.Scanner;

/* SELF ASSESSMENT  
1.  clearBoard:
Did I use the correct method definition?
Mark out of 5:5
Comment: The correct method header and a method body are given making the correct definition. 
Did I use loops to set each position to the BLANK character?
Mark out of 5:5
Comment:All position are left blank after using the method
2.  printBoard
Did I use the correct method definition?
Mark out of 5:5
Comment:The correct method header and a method body are given making the correct definition. 
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5:5
Comment:I use a co-ordinate system to print a the board in a easy to understand way that looks like a board
3.  canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:The correct definition is used and it returns the correct boolean
Did I check if a specified location was BLANK?
Mark out of 5:5 
Comment:Yes it checks if the location is blank to determine the boolean
4.  makeMove
Did I have the correct function definition?
Mark out of 5:5
Comment:The correct function definition is used.
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5:5
Comment:The player piece is placed correctly as demonstrated by the printed board.
5.  isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:The correct definition is used and returns the correct items.
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5:5
Comment:The whole board is looped through to check for blank characters.
6.  winner
Did I have the correct function definition and returned the winning character
Mark out of 5:5
Comment:The definition is correct and the winning player is returned
Did I identify all possible horizontal, vertical and diagonal winners  
Mark out of 15:15
Comment:In the game all potential winning sets are checked for.
7.main

Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3:3
Comments:Yes all a 3x3 board is created and clearBoards sets all to BLANK.
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5:5
Comments:Yes the game repeats until that requirement is meet.
Did I call all of the methods above?
Mark out of 5:5
Comments:All methods listed are called for in the main.
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3:3
Comments:An OutOfArrayLimits Exception as well as a NoSuchElement is called if this occurs and repeats the move.
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3:3
Comments:Yes the player piece switches depending on the turn.
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3:3
Comments:Yes the winner is displayed at the end unless the game is a draw.

8.  Overall
Is my code indented correctly?
Mark out of 3:3
Comments:The code is indented correctly with reference to the given coding standard.
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3:3
Comments:Yes all variable names and constants make sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2:2
Comments:Yes all of the above follow the standard.
   Total Mark out of 100 (Add all the previous marks): 100  
*/

public class NoughtsandCrosses {

	public static void main(String[] args) {
		try
		{
			Scanner inputScanner = new Scanner(System.in);
			boolean finishGame = false;
			do{
				char [][] board = new char [3][3];
				clearBoard (board);
				printBoard(board);
				boolean isBoardFull = false;
				int userCount = 1;
				boolean gameOver = false;
				do{ 
					System.out.println("Enter the row and column you'd like to place your character, seperated by spaces. (Row then Column)");
					int rowNumber = inputScanner.nextInt();
					int columnNumber = inputScanner.nextInt();
					
					boolean canMakeMove = canMakeMove(board, rowNumber, columnNumber);
					if (canMakeMove == true)
					{
						char characterEntered = 'X';
						if (userCount%2 == 0)
						{
							characterEntered = 'O';
						}
						makeMove (board, rowNumber, columnNumber, characterEntered);
						userCount++;
						
					}
					printBoard(board);
					char winner = winner (board);
					if (winner == 'X' ||winner == 'O')
					{
						System.out.println("The winner is player " + winner +  "!");
						gameOver = true;
					}
					if (gameOver != true)
					{
						isBoardFull = isBoardFull (board);
					}
				} while (isBoardFull == false && gameOver == false);				
				boolean askToEnd;
				do{ 
					System.out.println("Would you like to play again? (Yes/No)");
					if (inputScanner.hasNext("Yes"))
					{
						finishGame = false;
						askToEnd = true;
					}
					else if (inputScanner.hasNext("No"))
					{
						finishGame = true;
						askToEnd = true;
						System.out.println("Goodbye!");
					}
					else
					{
						System.out.println("Sorry, that was an incorrect respond. Please enter either (Yes/No)");
						inputScanner.next();
						askToEnd = true;
					}
				} while (askToEnd == false);
				if (inputScanner.hasNext())
				{
					String safetyNet = inputScanner.next();
					safetyNet = "";
					System.out.println(safetyNet);
				}
			} while (finishGame == false);
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

	public static void clearBoard (char[][] board)
	{
		for (int index = 0; index <= 2; index ++)
		{
			for (int index2 = 0; index2 <= 2; index2 ++)
			{
				board [index] [index2] = ' ';
			}
		}
	}
	
	public static void printBoard (char[][] board)
	{
		System.out.println ("   |     0     |      1     |      2    ");
		System.out.println ("---|---------- | ---------- | ----------");
		System.out.println (" 0 |     " +board [0][0]+ "     |      "+board[0][1]+"     |      "+board[0][2]+"     ");
		System.out.println ("   |---------- | ---------- | ----------");
		System.out.println (" 1 |     " +board [1][0]+ "     |      "+board[1][1]+"     |      "+board[1][2]+"     ");
		System.out.println ("   |---------- | ---------- | ----------");
		System.out.println (" 2 |     " +board [2][0]+ "     |      "+board[2][1]+"     |      "+board[2][2]+"     ");
		System.out.println ("   |           |            |           ");
	}
	
	public static boolean canMakeMove (char [][] board, int rowNumber, int columnNumber)
	{
		try 
		{
			if (board [rowNumber][columnNumber] == ' ')
			{
				return true;
			}
			else 
			{
				System.out.println("That area is full. Please select another.");
				return false;
			}
		}
		catch (ArrayIndexOutOfBoundsException exception)
		{
			System.out.println("That goes outside the parameters. Try another number.");
			return false;
		}
	}
	
	public static void makeMove ( char[][] board, int rowNumber, int columnNumber, char characterEntered)
	{
		board [rowNumber][columnNumber] = characterEntered;
	}
	
	public static boolean isBoardFull (char [][] board)
	{
		for (int index = 0; index <= 2; index ++)
		{
			for (int index2 = 0; index2 <= 2; index2 ++)
			{
				if (board [index] [index2] == ' ')
				{
					return false;
				}
			}
		}
		System.out.println("The result is a draw! Neither player wins.");
		return true;
	}

	public static char winner (char [][] board)
	{
		char winner = 'A';
		for (int index = 0; index <= 2; index ++)
		{
			if (board [index] [0] == board [index] [1] && board [index] [1] == board [index] [2])
			{
				return board [index] [0];
			}
			else if (board [0] [index] == board [1] [index] && board [1] [index] == board [2] [index])
			{
				return board [0] [index];
			}
			else if (board [0][0] == board [1][1] && board [1][1] == board [2][2])
			{
				return board [0] [0];
			}
			else if (board [2][0] == board [1][1] && board [1][1] == board [0][2])
			{
				return board [1] [1];
			}	
		}
		return winner;
	}
	
}


