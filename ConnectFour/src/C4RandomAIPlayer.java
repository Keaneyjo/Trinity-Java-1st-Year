import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer {
	
	char playerPiece;
	C4RandomAIPlayer (char playerPiece)
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
		Random generator = new Random();
		int place = generator.nextInt(6);
		return place;
	}


}
