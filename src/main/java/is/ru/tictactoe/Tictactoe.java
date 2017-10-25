package is.ru.tictactoe;

import java.util.Scanner;
public class Tictactoe
{
        // Constants for slot status in game
        public static final int STATUS_EMPTY = 0;
        public static final int STATUS_X = 1;
        public static final int STATUS_O = 2;
	
	// Constants for players
	public static final char PLAYER_X = 'X';
	public static final char PLAYER_O = 'O';

        // Constants for game status
        public static final int XWON = 0;
        public static final int OWON = 1;
        public static final int DRAW = 2;
        public static final int INGAME = 3;

        // Tictactoe game entities
        public static final int SIZE = 3;
        public static int gameBoard[][] = new int[SIZE][SIZE];  	// Represents the board of the game
	public static char currPlayer;     	
   
	public static void InitializeBoard()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				gameBoard[i][j] = STATUS_EMPTY;
			}
		}
	}
	
	public static void InitializeGame()
	{
		InitializeBoard();
		currPlayer = PLAYER_X;
	}

	public static char test()
	{
		return 'X';
	}	
}
