import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class ScreenShotSelenium {
    ChromeDriver driver;


    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("file:///Users/mac/Documents/windows.html");
    }

    @Test
    public void testeScreenShot() throws IOException {

        TakesScreenshot screenshot = ((TakesScreenshot) driver); //Criando Objeto Takescreenshot e convertendo o driver para um screenShot
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE); //tirar o print e saida vai ser do pasta
        FileUtils.copyFile(arquivo, new File("output"+File.separator+"screenshot"+ LocalDateTime.now()+".png"));//Grava o arquivo

    }

    @After
    public void finaliza() {
        driver.quit();
    }
}
