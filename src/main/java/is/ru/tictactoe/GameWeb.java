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
		get("/api/game", (req, res) -> 
		{
            		QueryParamsMap map = req.queryMap();
            		try 
			{
                		Integer slot = map.get("slot").integerValue();
				char player = game.PlayerMove(slot);
				return player;
	
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
