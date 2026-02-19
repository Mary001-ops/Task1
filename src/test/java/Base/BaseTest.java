package Base;

import Utils.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected Data data;

    @BeforeMethod
    public void setUpChromeBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        data=new Data("src/main/resources/TestDataFiles/saucedemo.json");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
