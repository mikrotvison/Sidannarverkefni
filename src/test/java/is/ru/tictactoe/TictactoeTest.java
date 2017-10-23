package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TictactoeTest {
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
}
