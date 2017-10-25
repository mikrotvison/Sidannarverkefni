package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TictactoeTest
{
        // Test game board init
        @Test
        public void TestBoardInit()
        {
                Tictactoe t = new Tictactoe();
                t.InitializeBoard();

                for (int i = 0; i < t.SIZE; i++)
                {
                        for (int j = 0; j < t.SIZE; j++)
                        {
                                assertEquals(t.STATUS_EMPTY, t.gameBoard[i][j]);
                        }
                }
        }
}
