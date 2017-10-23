package is.ru.tictactoe;

import java.util.Scanner;

// Purpose of this class is to use the Tictactoe game class so it would be easier to implement web app later on
public class ConsoleApp
{
	public static Scanner sc = new Scanner(System.in); 		
	public static void main(String[] args)
        {
                Tictactoe t = new Tictactoe();
                t.InitializeGame();
		do 
		{
			if (t.currPlayer == t.O)
            {
                System.out.println("Player O has next turn, write available row and column values [1-3]:");
            }
            else if (t.currPlayer == t.X)
            {
                System.out.println("Player X has next turn, write available row and column values [1-3]:");
            }
            int row, col;
			do
			{
				row = sc.nextInt();
				col = sc.nextInt();
			} while ((t.ValidateIndicies(row, col) == false));

			t.PlayerTurn(t.currPlayer, row, col);
			t.UpdateGame(t.currPlayer, t.currRow, t.currCol);

			if (t.currStatus == t.DRAW)
			{
				System.out.println("Game has ended in a draw!");
			}
			else if (t.currStatus == t.OWON)
			{
				System.out.println("Player O has won the game!");
			}
			else if (t.currStatus == t.XWON)
			{
				System.out.println("Player X has won the game!");
			}
			// If currStatus stays the same we go another iteration into the game
			t.PrintBoard();
			// Changing current player
			if (t.currPlayer == t.X)
			{
				t.currPlayer = t.O;
			}
			else 
			{
				t.currPlayer = t.X;
			}
		

		} while (t.currStatus == t.INGAME);

        }
	

}
