package is.ru.tictactoe;
import static spark.Spark.*;
import java.util.*;
public class GameWeb {

    public static void main(String[] args) {
        
        port(getHerokuAssignedPort());
        get("/hello", (req, res) -> "Hello Heroku World");
    }

    private static int getHerokuAssignedPort() {
        final ProcessBuilder processBuilder = new ProcessBuilder();

        if (processBuilder.environment().get("PORT") != null) {
          return Integer.parseInt(processBuilder.environment().get("PORT"));
    }

        return 4567; // default Spark port
    }

}
