import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosWindow {
WebDriver driver;
    @Before
    public void before(){
        driver  = new ChromeDriver();
        driver.get("file:///Users/mac/Documents/windows.html");


    }

    @Test
    public void testeJanelaSelenium(){

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
