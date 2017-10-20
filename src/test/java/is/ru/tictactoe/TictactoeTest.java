package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TictactoeTest {
	@Test
	public void TestInitializationBoard()
	{
		Tictactoe t = new Tictactoe();
		t.InitializeBoard();
		
		for (int i = 0; i < t.SIZE; i++)
                {
                        for (int j = 0; j < t.SIZE; j++)
                        {
                                assertEquals(0, t.gameBoard[i][j]);
                        }
                }
	}

}
