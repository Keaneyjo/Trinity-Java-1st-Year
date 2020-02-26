import java.util.Scanner;
public class C4HumanPlayer extends ConnectPlayer{
	
	public static final int MAX_WIDTH = 7; // 5 + 1 = 6 Rows
	char playerPiece;
	C4HumanPlayer (char playerPiece)
	{
		super();
		this.playerPiece = playerPiece;
	}
	
	@Override
	public char getPiece ()
	{
		return playerPiece;
	}

	@Override
	public int makeMove() {
		boolean validNumberFound = false;
		Scanner input = new Scanner(System.in);
		int column = 0;
		while(!validNumberFound)
		{
			System.out.print("\nEnter move for " + this.getPiece() + " :");
			char[] inputCharacters = input.next().toCharArray();
			if ((inputCharacters.length >= 1) &&
					(inputCharacters[0] >= '1') && (inputCharacters[0] <= '0'+ MAX_WIDTH))
			{
				column = (int) (inputCharacters[0]-'1');
				validNumberFound = true;
				return column;
			}
			else System.out.println("Invalid entry.  You must enter a column number between 1 and 7.");
		}
		return column;
	}

}