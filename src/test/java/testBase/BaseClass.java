package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;

    public Logger logger;

    @BeforeClass
    public void setUp(){

        logger = LogManager.getLogger(this.getClass());

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost/opencart/upload/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
