package is.ru.tictactoe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class SeleniumTestWrapper 
{
  static ChromeDriver driver;
  static String baseUrl;
  static String port;

  @BeforeClass
  public static void openBrowser() 
  {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    port = System.getenv("PORT");
    if (port == null) 
    {
        port = "4567" ; 	// Not used since we test heroku server
    }
    baseUrl = "https://webtictactoe-hugb.herokuapp.com/";
  }

  @AfterClass
  public static void closeBrowser()
  {
    driver.quit();
  }
}
