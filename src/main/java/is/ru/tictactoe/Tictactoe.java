package is.ru.tictactoe;

import java.util.Scanner;
public class Tictactoe 
{
	public static Scanner reader = new Scanner(System.in); 		// To read input streams from user
	// Constants for slot status in game
	public static final int NONE = 0;
	public static final int X = 1;
	public static final int O = 2;

	// Constants for game status
	public static final int XWON = 0;
	public static final int OWON = 1;
	public static final int DRAW = 2;
	public static final int INGAME = 3;
	
	// Tictactoe game entities
	public static final int SIZE = 3;
	public static int gameBoard[][] = new int[SIZE][SIZE]; 	// Represents the board of the game
	public static int currStatus; 				// Represents the status of the game
	public static int currRow;				// Current row of board
	public static int currCol;				// Current column of board
	public static int currPlayer;				// Current player

	// Initialize game board
	private static void InitializeBoard()
	{
        	for (int i = 0; i < SIZE; i++)
        	{
                	for (int j = 0; j < SIZE; j++)
                	{
                        	gameBoard[i][j] = NONE;
                	}
        	}
	}
	// Initialize game
	public static void InitializeGame()
	{
		InitializeBoard();				// Initialize playing board
		currStatus = INGAME;				// Set the game status to INGAME
		currPlayer = X;					// Player X starts the game 		
	}  

	// Player's X or O turn, make him play
	public static void PlayerTurn(int player, int row, int col)
	{
		boolean inputTest = false; 
		do
		{
			if (ValidateIndex(row) && ValidateIndex(col) && gameBoard[row][col] == NONE)
			{
				inputTest = true; 		// Input is valid
				currRow = row;
				currCol = col;
				gameBoard[currRow][currCol] = player;					
			}
		} while (!inputTest);				// Ask for slot until input is valid
	}
		
	// Returns true if index is in gameBoard range
	private static boolean ValidateIndex(int index)
	{
		return ((index >= 0) && (index < 3));	
	}
	
	// Prints current gameBoard
	public static void PrintBoard()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				PrintSlot(gameBoard[i][j]);
				System.out.print("|");
				
							
			}
			System.out.println();
			System.out.println("------");
		}
	}
	
	// Prints slot value
	private static void PrintSlot(int slot)
	{
		if (slot == NONE)
		{
			System.out.print(" ");
		}
		else if (slot == O)
		{
			System.out.print("O");
		}
		else if (slot == X)
		{
			System.out.print("X");
		}
	}
	
	// Returns true if game has been won by incoming player
	public static boolean GameWon(int player, int row, int col)
	{
		boolean won = false;
		if ((currRow == currCol) && (player == gameBoard[0][0]) && (player == gameBoard[1][1]) && (player == gameBoard[2][2]))
		{
			won = true;				// Game won on the diogonal line					
		}
		else if ((currRow + currCol == 2) && (player == gameBoard[2][0]) && (player == gameBoard[1][1]) && (player == gameBoard[0][2]))
		{
			won = true;				// Game won on the reverse diagonal line
		}
		else if ((player == gameBoard[0][currCol]) && (player == gameBoard[1][currCol]) && (player == gameBoard[2][currCol]))
                {
                        won = true;                             // Game won on current column
                }
		else if ((player == gameBoard[currRow][0]) && (player == gameBoard[currRow][1]) && (player == gameBoard[currRow][2]))
                {
                        won = true;                             // Game won on current row
                }
		return won;
	}

	// Test if game is Draw
	public static boolean Draw()
	{
		boolean draw = true;
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				if(gameBoard[i][j]==NONE)
				{
					draw = false;
				}				
			}
		}
		return draw;
	}


	
}

