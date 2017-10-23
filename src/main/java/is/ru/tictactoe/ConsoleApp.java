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
	
		int counter = 0; 
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
			int row = sc.nextInt();
			int col = sc.nextInt();		
			t.PlayerTurn(t.currPlayer, row, col);
			t.PrintBoard();
			counter++;

		} while (counter < 3);

        }
	

}
