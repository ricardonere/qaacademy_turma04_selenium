import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ChromeOptionsWindow {
WebDriver driver;
    @Before
    public void before(){

        ChromeOptions chromeOptions = new ChromeOptions();
//        driver.manage().window().maximize();//Inicionaliza maxizado forma 1
        chromeOptions.addArguments("start-maximized"); //Inicionaliza maxizado forma 2
//        chromeOptions.setHeadless(true);//Roda o teste sem abrir o browser - forma 1
       chromeOptions.addArguments("headless");

        driver  = new ChromeDriver(chromeOptions);
        driver.get("file:///Users/mac/Documents/windows.html");
    }

    @Test
    public void testeJanelaSeleniumComOptions(){

        driver.findElement(By.xpath("//a[@href='http://www.selenium.dev/']//button[@class='btn btn-info'][contains(text(),'click')]")).click();
        Object[] janelas = driver.getWindowHandles().toArray();
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(janelas[1].toString());
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue("URL Diferente", driver.getCurrentUrl().equals("https://www.selenium.dev/"));
    }

    @After
    public void after() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();

    }
}
