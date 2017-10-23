package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TictactoeTest 
{
	// Test game initialation
	@Test
	public void TestInitialization()
	{
		Tictactoe t = new Tictactoe();
		t.InitializeGame();
		
		for (int i = 0; i < t.SIZE; i++)
                {
                        for (int j = 0; j < t.SIZE; j++)
                        {
                                assertEquals(0, t.gameBoard[i][j]);
                        }
                }
	}
	
	// Test player move
	@Test
	public void TestXPlayerTurn()
	{
		Tictactoe t = new Tictactoe();
		t.InitializeGame();			// Initialize the game
		t.PlayerTurn(t.X, 2, 2);		// Set slot (2,2) as X
		assertEquals(t.X, t.gameBoard[2][2]);	
							
	}

	// Test another player move
        @Test
        public void TestOPlayerTurn()
        {
                Tictactoe t = new Tictactoe();
                t.InitializeGame();                     // Initialize the game
		t.PlayerTurn(t.O, 1, 2);
                assertEquals(t.O, t.gameBoard[1][2]);
        }
	
	// Testing when game is won on diagonal line
	@Test
        public void TestWinDiagonalLine()
        {
                Tictactoe t = new Tictactoe();
                t.InitializeGame();                     // Initialize the game
                t.PlayerTurn(t.O, 0, 0);
		t.PlayerTurn(t.O, 1, 1);
		t.PlayerTurn(t.O, 2, 2);		// Now the game has been won by player O
                assertEquals(true, t.GameWon(t.O, 2, 2));
        }

	// Testing when game is won on reverse diagonal line
        @Test
        public void TestWinReverseDiagonalLine()
        {
                Tictactoe t = new Tictactoe();
                t.InitializeGame();                     // Initialize the game
                t.PlayerTurn(t.X, 0, 2);
                t.PlayerTurn(t.X, 2, 0);
                t.PlayerTurn(t.X, 1, 1);                // Now the game has been won by player X
                assertEquals(true, t.GameWon(t.X, 1, 1));
        }		

        // Testing when game is won on column
        @Test
        public void TestWinOnColumn()
        {
                Tictactoe t = new Tictactoe();
                t.InitializeGame();                     // Initialize the game
                t.PlayerTurn(t.X, 0, 0);
                t.PlayerTurn(t.X, 0, 1);
                t.PlayerTurn(t.X, 0, 2);                // Now the game has been won by player X
                assertEquals(true, t.GameWon(t.X, 0, 2));
        }
	
		// Testing when game is won on line
        @Test
        public void TestWinOnLine()
        {
                Tictactoe t = new Tictactoe();
                t.InitializeGame();                     // Initialize the game
                t.PlayerTurn(t.O, 1, 0);
                t.PlayerTurn(t.O, 1, 2);
                t.PlayerTurn(t.O, 1, 1);                // Now the game has been won by player O
                assertEquals(true, t.GameWon(t.O, 1, 1));
        }

        // Testing when game has not been won
        @Test
        public void TestGameNotWon()
        {
                Tictactoe t = new Tictactoe();
                t.InitializeGame();                     // Initialize the game
                t.PlayerTurn(t.O, 1, 0);
                t.PlayerTurn(t.X, 1, 2);
                t.PlayerTurn(t.O, 0, 0);                // Game has not been won
                assertEquals(false, t.GameWon(t.O, 0, 0));
        }

        // Testing when game has ended in draw
        @Test
        public void TestGameIsDraw()
        {
                Tictactoe t = new Tictactoe();
                t.InitializeGame();                     // Initialize the game
                t.PlayerTurn(t.O, 0, 0);
                t.PlayerTurn(t.X, 0, 1);
                t.PlayerTurn(t.O, 0, 2);
                t.PlayerTurn(t.O, 1, 0);
                t.PlayerTurn(t.X, 1, 1);
                t.PlayerTurn(t.O, 1, 2);                 
                t.PlayerTurn(t.X, 2, 0);
                t.PlayerTurn(t.O, 2, 1);  
                t.PlayerTurn(t.X, 2, 2);   				// Game has ended in draw  
                assertEquals(true, t.Draw());
        }

        // Testing when game has not ended in draw
        @Test
        public void TestGameIsNotDraw()
        {
                Tictactoe t = new Tictactoe();
                t.InitializeGame();                     // Initialize the game
                t.PlayerTurn(t.O, 0, 0);
                t.PlayerTurn(t.X, 0, 1);
                t.PlayerTurn(t.O, 0, 2);
                t.PlayerTurn(t.O, 1, 0);
                t.PlayerTurn(t.X, 1, 1);
                t.PlayerTurn(t.O, 1, 2);                 // Game has not ended in draw  
                assertEquals(false, t.Draw());
        }

        // Testing UpdateGame function
        @Test
        public void TestUpdateGame()
        {
                Tictactoe t = new Tictactoe();
                t.InitializeGame();                     // Initialize the game
                t.PlayerTurn(t.O, 0, 0);
                t.PlayerTurn(t.O, 0, 1);
                t.PlayerTurn(t.O, 0, 2);
                t.UpdateGame(t.O, 0, 2);				// O has won the game

                assertEquals(t.OWON, t.currStatus);
        }


}
