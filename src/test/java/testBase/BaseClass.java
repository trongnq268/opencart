package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;

    public Logger logger;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String br){

        logger = LogManager.getLogger(this.getClass());

        //xoa dong trinh duyet duoc dieu khien boi auto
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver(options);

        if(br.equals("chrome")){
            driver = new ChromeDriver();
        }else {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost/opencart/upload/index.php");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }


    public String randomeString(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String randomeNumber(){
        String generatedString2 = RandomStringUtils.randomNumeric(10);
        return generatedString2;
    }

    public String randomAlphaNumeric(){
        String st = RandomStringUtils.randomAlphabetic(4);
        String num = RandomStringUtils.randomNumeric(3);

        return (st+"@"+num);
    }
}
