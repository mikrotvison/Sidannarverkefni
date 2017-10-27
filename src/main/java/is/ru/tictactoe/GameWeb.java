package is.ru.tictactoe;

import static spark.Spark.*;
import spark.QueryParamsMap;
public class GameWeb
{
	
	public static void main(String[] args) 
	{
		port(getHerokuPort());
		staticFiles.location("/public");
		Tictactoe game = new Tictactoe();
                game.InitializeGame();
		// Get request when player makes move on game board
		get("/api/game", (req, res) -> 
		{
            		QueryParamsMap map = req.queryMap();
            		try 
			{
                		Integer slot = map.get("slot").integerValue();
				String player = game.PlayerMove(slot);
				if (game.GameWon(player, slot))				// Return if game has been won by player
				{
					if (player == game.PLAYER_X)
					{
						return game.XWON;
					}	
					else
					{
						return game.OWON;
					}
				}
				if (game.IsDraw())					// Return if game has ended in a draw
				{
					return game.DRAW;
				}
				return player;						// Otherwise return player who did the move and update game
	
           		}
            		catch (Exception e)
			{
                		return "Error: " + e.getMessage();
            		}
        	});

                // Get request when players want to start new game
                get("/api/refresh", (req, res) ->
                {
                        try
                        {
				String ret = game.InitializeGame();
                                return ret;

                        }
                        catch (Exception e)
                        {
                                return "Error: " + e.getMessage();
                        }
                });		
    	}

	static int getHerokuPort() 
	{
		ProcessBuilder psb = new ProcessBuilder();
		if (psb.environment().get("PORT") != null) 
		{
	    		return Integer.parseInt(psb.environment().get("PORT"));
		}
		return 4567;
    	}
}
