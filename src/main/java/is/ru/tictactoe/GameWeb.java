package is.ru.tictactoe;

import static spark.Spark.*;
import spark.QueryParamsMap;
public class GameWeb
{
	
	public static void main(String[] args) 
	{
		port(getHerokuPort());
		staticFiles.location("/public");
		get("/api/game", (req, res) -> 
		{
            		QueryParamsMap map = req.queryMap();
			Tictactoe game = new Tictactoe();
            		try 
			{
                		//Integer a = map.get("a").integerValue();
                		//Integer b = map.get("b").integerValue();
				char a = game.test();
				return a;
                		//return a + b;
	
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
