package is.ru.tictactoe;

public class Tictactoe 
{
	// Constants for slot status in game
	public static final int NONE = 0;
	public static final int X = 1;
	public static final int O = 2;
	
	// The game board is a 3x3 integer array
	public static final int SIZE = 3;
	public static int gameBoard[][] = new int[SIZE][SIZE];

	// Initialize game board
	public static void InitializeBoard()
	{
        	for (int i = 0; i < SIZE; i++)
        	{
                	for (int j = 0; j < SIZE; j++)
                	{
                        	gameBoard[i][j] = NONE;
                	}
        	}
	}
	
}

