package is.ru.tictactoe;

import java.util.Scanner;
public class Tictactoe
{
        // Constants for slot status in game
        public static final String STATUS_EMPTY = "0";
	public static final String PLAYER_X = "X";			
	public static final String PLAYER_O = "O";

        // Constants for game status
        public static final String XWON = "Xw";				// Use this string in UI (.js file) 
        public static final String OWON = "Ow";				// Use this string in UI (.js file)
        public static final String DRAW = "draw";			// Use this string in UI (.js file)
	

        // Tictactoe game entities
        public static final int SIZE = 3;				// Size of game board rows and columns
        public static String gameBoard[][] = new String[SIZE][SIZE];  	// Represents the board of the game
	public static String currPlayer;     	
 	private static boolean gameOver;				// Don't insert into board if game has ended  
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
	
	// Initializes game bord and sets first player as player X	
	public static String InitializeGame()
	{
		InitializeBoard();
		currPlayer = PLAYER_X;
		gameOver = false;
		return "refresh";					// Return value used to restart game in UI
	}
	
	// Inserts player move into board and returns which player was making the move
	public static String PlayerMove(int slot)
	{
		int[] indicies = To2D(slot);
		int row = indicies[0];
		int col = indicies[1];
		if (ValidateSlot(slot) && !gameOver)			// Insert if slot is valid and game isn't over
		{
			if (gameBoard[row][col] == STATUS_EMPTY)
			{
				gameBoard[row][col] = currPlayer;	// IsDraw checks if board is full so if game is not won it can be a draw
				String player = ChangePlayer();		// Change current player and return what player did this move
				return player;				// Return value of current player to display in UI				
			}		
		}
		return "invalid"; 					// Return "invalid" in UI if move wasn't valid
	}
	
	// Return true if game has ended in a draw
	public static boolean IsDraw()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				if (gameBoard[i][j] == STATUS_EMPTY)
				{
					return false;
				}
			}
		}
		gameOver = true;					// The game is over
		return true; 						// Returns true if all slots are not empty	
	}
	
	// Slots are from 1 to 9, validate slot
	private static boolean ValidateSlot(int slot)
	{
		return ((slot >= 1) && (slot <= 9));
	}

	// Maps slot from 1D to 2D where 1 = (0,0), 2 = (0,1), 3 = (0,2), 4 = (1,0) and so on
	private static int[] To2D(int slot)
	{
		int[] indicies = new int[2];				// 0 is row and 1 is col
		switch (slot)
		{
			case 1:
				indicies[0] = 0;
				indicies[1] = 0;
				break;
                        case 2:
                                indicies[0] = 0;
                                indicies[1] = 1;
                                break;
                        case 3:
                                indicies[0] = 0;
                                indicies[1] = 2;
                                break;
                        case 4:
                                indicies[0] = 1;
                                indicies[1] = 0;
                                break;
                        case 5:
                                indicies[0] = 1;
                                indicies[1] = 1;
                                break;
                        case 6:
                                indicies[0] = 1;
                                indicies[1] = 2;
                                break;
                        case 7:
                                indicies[0] = 2;
                                indicies[1] = 0;
                                break;
                        case 8:
                                indicies[0] = 2;
                                indicies[1] = 1;
                                break;
                        case 9:
                                indicies[0] = 2;
                                indicies[1] = 2;
                                break;
		}
		return indicies;
	}
	
	// Changes current player, returns who was player before function call
	private static String ChangePlayer()
	{
		if (currPlayer == PLAYER_X)
		{
			currPlayer = PLAYER_O;
			return PLAYER_X;
		}
		else
		{
			currPlayer = PLAYER_X;
			return PLAYER_O;
		}
	}

        // Returns true if game has been won by incoming player
        public static boolean GameWon(String player, int slot)
        {
		int[] indicies = To2D(slot);
		int currRow = indicies[0];
		int currCol = indicies[1];
		
                boolean won = false;
                if ((currRow == currCol) && (player == gameBoard[0][0]) && (player == gameBoard[1][1]) && (player == gameBoard[2][2]))
                {
                        won = true;                             	// Game won on the diogonal line
                }
                else if ((currRow + currCol == 2) && (player == gameBoard[2][0]) && (player == gameBoard[1][1]) && (player == gameBoard[0][2]))
                {
                        won = true;                             	// Game won on the reverse diagonal line
                }
                else if ((player == gameBoard[0][currCol]) && (player == gameBoard[1][currCol]) && (player == gameBoard[2][currCol]))
                {
                        won = true;                             	// Game won on current column
                }
                else if ((player == gameBoard[currRow][0]) && (player == gameBoard[currRow][1]) && (player == gameBoard[currRow][2]))
                {
                        won = true;                             	// Game won on current row
                }
		if (won)
		{
			gameOver = true; 				// Game is over, dont insert more into gameBoard
		}
                return won;
        }		
}
