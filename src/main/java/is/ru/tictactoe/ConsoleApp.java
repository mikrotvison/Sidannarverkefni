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
			int row = sc.nextInt();
			int col = sc.nextInt();		
			t.PlayerTurn(t.currPlayer, row, col);
			t.PrintBoard();
			counter++;

		} while (counter < 3);

        }
	

}
