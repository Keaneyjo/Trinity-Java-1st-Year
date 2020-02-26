import java.util.Scanner;

/* SELF ASSESSMENT

Connect4Game class (35 marks) :35
My class creates references to the Connect 4 Grid and two Connect 4 Players. 
It asks the user whether he/she would like to play/quit inside a loop. 
If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised 
- must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. 
I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: All of the above is true, creating the grid and players then asking what play style in a loop, and then ask where to drop the piece. These are
performed in my interface. Then a check for a winner.

Connect4Grid interface (10 marks) :10
I define all 7 methods within this interface.
Comment: All of the methods are defined.

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column 
to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. 
It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: A grid is created and using various methods checks if a move is valid. All of the methods specified above are used.

ConnectPlayer abstract class (10 marks)
My class provides at least one non-abstract method and at least one abstract method. 
Comment: I use the getPiece and makeMove methods.

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: This is true and the methods are overrid providing the human functionality.

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: This is true and the methods are overrid providing the AI functionality.

Total Marks out of 100:100

*/

public class Connect4Game {
	
	public static char pieceRed = 'R';
	public static char pieceYellow = 'Y';
	public static int [][] board;
	
	public static void main(String[] args) {
		try
		{
			Connect4Grid2DArray board = new Connect4Grid2DArray();
			ConnectPlayer player1 = new C4HumanPlayer(pieceRed); // User Player 1
			ConnectPlayer player2 = null;
			boolean finished = false;
			boolean gameOver = false;
			Scanner inputScanner = new Scanner(System.in);
			while (!gameOver) {
				
				int playerChoiceHuman = 0;
				do {
					System.out.println("Would you like to play \n 1) 2 Player \n 2) An AI player \n 3) or Quit? (enter the respective 1, 2 or 3)");
					int choice = inputScanner.nextInt();
					board.emptyGrid();
					if (choice == 1)
					{
						playerChoiceHuman = 1;
						finished = false;
					}
					else if (choice == 2)
					{
						playerChoiceHuman = 2;
						finished = false;
					}
					else if (choice == 3)
					{
						playerChoiceHuman = 3;
						finished = true;
						gameOver = true;
					}
					else
					{
						System.out.print("Sorry that was an incorrect input. Please try again. ");
					}
				} while (playerChoiceHuman == 0);
				if (playerChoiceHuman == 1)
				{
					player2 = new C4HumanPlayer(pieceYellow); // User Player 2
				}
				else if (playerChoiceHuman == 2)
				{
					player2 = new C4RandomAIPlayer(pieceYellow); // AI Player
				}
				boolean player1Win = false;
				boolean player2Win = false;
				while (!finished) {
					if (board.isGridFull())
					{
						System.out.println("It seems the board is full. Tie!");
						finished = true;
					}
					System.out.print(board.toString());
					boolean validMovePlayer1 = false;
					do {
						int playerOneMove = player1.makeMove();
						if(!board.isValidColumn(playerOneMove))
						{
							validMovePlayer1 = true;
							board.dropPiece(player1, playerOneMove);
							player1Win = board.didLastPieceConnect4();
						}
						else
						{
							System.out.println("Sorry, invalid move. Try again.");
						}
					} while (!validMovePlayer1);
					
					System.out.print(board.toString());
					boolean validMovePlayer2 = false;
					do {
						int playerTwoMove = player2.makeMove();
						if(!board.isValidColumn(playerTwoMove))
						{
							validMovePlayer2 = true;
							board.dropPiece(player2, playerTwoMove);
							player2Win = board.didLastPieceConnect4();
						}
						else
						{
							System.out.println("Sorry, invalid move. Try again.");
						}
					} while (!validMovePlayer2);
					if (player1Win == true)
					{
						System.out.println("Player One has Won!!!");
						board.emptyGrid();
						finished = true;
					}
					else if (player2Win == true)
					{
						System.out.println("Player Two has Won!!!");
						board.emptyGrid();
						finished = true;
					}
				}
				
			}
			inputScanner.close();
			System.out.print("Thanks for playing. Goodbye!");				
		}
		catch (Exception e)
		{
			System.out.print("Sorry, that was an incorrect input. Please re-run the program to try again.");
		}
	}
	
}


