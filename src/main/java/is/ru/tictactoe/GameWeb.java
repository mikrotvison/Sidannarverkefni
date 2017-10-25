package is.ru.tictactoe;

import static spark.Spark.*;
import spark.QueryParamsMap;
public class GameWeb {
	
	public static void main(String[] args) {
		port(getHerokuPort());
		staticFiles.location("/public");
		get("/api/sum", (req, res) -> {
            QueryParamsMap map = req.queryMap();
            try {
                Integer a = map.get("a").integerValue();
                Integer b = map.get("b").integerValue();
                return a + b;
            }
            catch (Exception e){
                return "Error: " + e.getMessage();
            }
        });

        /*get("/", (req, res) -> {
            return "No route specified. Try /add/1,2";
        });
        get(
            "/add/:input",
            (req, res) -> add(req.params(":input"))
        );*/
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

    	/*private static int add(String input) 
	{
        	StringCalculator Calculator = new StringCalculator();
        	return Calculator.add(input);
    	}*/
}
