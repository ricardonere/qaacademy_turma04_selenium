import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosFrame {
    WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.get("file:///Users/mac/Documents/Frames.html");

    }

    @Test
    public void testIFrame() {
        WebElement iframe =  driver.findElement(By.cssSelector("#singleframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.tagName("input")).sendKeys("TESTE IFRAME");

        //https://www.selenium.dev/documentation/webdriver/browser/frames/
    }

    @After
    public void after() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }
}
