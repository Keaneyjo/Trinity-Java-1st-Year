
public class Connect4Grid2DArray implements Connect4Grid{
	
	public static final int MAX_ROWS = 6; // 5 + 1 = 6 Rows
	public static final int MAX_COLUMMS = 7; // 6 + 1 = 7 Columns
	char [][] board;
	Connect4Grid2DArray()
	{
		board = new char [MAX_ROWS][MAX_COLUMMS];
	}

	
	public void emptyGrid()
	{
		for (int i = 0; i < MAX_ROWS; i++)
		{
			for (int j = 0; j < MAX_COLUMMS ; j++)
			{
				board[i][j] = '0';
			}
		}
		return;
	}
	
	@Override
	public String toString ()
	{
		String boardOutprint = "  1 2 3 4 5 6 7\n ---------------\n";
		for (int i = 0; i < MAX_ROWS; i++)
		{
			boardOutprint = boardOutprint + i + "";
			for (int j = 0; j < MAX_COLUMMS  ; j++)
			{
				boardOutprint = boardOutprint + "|" +board[i][j];
			}
			boardOutprint += "\n";
		}
		return boardOutprint;
	}

	@Override
	public boolean isValidColumn(int column) {
		if (column <= 8 || column >= 0)
		{	
			if(isColumnFull(column))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isColumnFull(int column) {
		for(int row = 0; row<board.length;row++)
		{
			if(board[row][column] == '0')
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public void dropPiece(ConnectPlayer player, int column) {
		for(int row=0;row<MAX_ROWS;row++)
		{
			if (board[row][column] != '0') 
			{
				board[row-1][column] = player.getPiece();
				return;
			}
		}
		board[5][column] = player.getPiece();
		return;
	}

	@Override
	public boolean didLastPieceConnect4() {
		for (int row = 0; row < MAX_ROWS; row++) 
		{
			for (int col = 0; col < MAX_COLUMMS; col++)
			{
				char connect4SlotToCheck = board[row][col];
				if (connect4SlotToCheck == '0')
				{
					continue;
				}
				if (col + 3 < MAX_COLUMMS &&
						connect4SlotToCheck == board[row][col+1] && 
						connect4SlotToCheck == board[row][col+2] &&
						connect4SlotToCheck == board[row][col+3])
				{
					return true;
				}
				if (row + 3 < MAX_ROWS) 
				{
					if (connect4SlotToCheck == board[row+1][col] &&
							connect4SlotToCheck == board[row+2][col] &&
							connect4SlotToCheck == board[row+3][col])
					{
						return true;
					}
					if (col + 3 < MAX_COLUMMS &&
							connect4SlotToCheck == board[row+1][col+1] &&
							connect4SlotToCheck == board[row+2][col+2] &&
							connect4SlotToCheck == board[row+3][col+3])
					{
						return true;
					}
					if (col - 3 >= 0 &&
							connect4SlotToCheck == board[row+1][col-1] &&
							connect4SlotToCheck == board[row+2][col-2] &&
							connect4SlotToCheck == board[row+3][col-3])
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean isGridFull() {
		for(int col = 0; col<board[0].length;col++)
		{
			if(board[0][col]== '0')
			{
				return false;
			}
		}
		return true;
	}
}
