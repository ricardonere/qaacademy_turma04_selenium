import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsSelenium {

    WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.get("file:///Users/mac/Documents/Alerts.html");
    }

    @Test
    public void testAlertaSimples() throws InterruptedException {

        driver.findElement(By.xpath(" //button[@class='btn btn-danger']")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        Assert.assertEquals("I am an alert box!", alert.getText());
//        alert.dismiss(); // Caso seja com Cancela e OK
        alert.accept();
    }

    @Test
    public void alertaComCaixaDeTexto() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Alert alert = driver.switchTo().alert();

        alert.sendKeys("QA ninja quer roubar a marca QA Academy");
        Thread.sleep(5000);
        alert.accept();
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}
