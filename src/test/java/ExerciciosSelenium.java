import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosSelenium {

    WebDriver driver = new ChromeDriver();


    @Test
    public void testeExercicosSelenium() {

        //Exercicio 01
        driver.get("file:///Users/mac/Documents/automation.html");
        driver.findElement(By.xpath("//body[@class='ng-scope']/section[@id='section']/div[@class='container center']/div[contains(@class,'row')]/div[@class='col-sm-6 col-md-6 col-xs-12']/form[@id='basicBootstrapForm']/div[1]/div[1]/input[1]"))
                .sendKeys("Flavio");
        driver.findElement(By.xpath("//body[@class='ng-scope']/section[@id='section']/div[@class='container center']/div[contains(@class,'row')]/div[@class='col-sm-6 col-md-6 col-xs-12']/form[@id='basicBootstrapForm']/div[@class='form-group']/div[2]/input[1]"))
                .sendKeys("Dias");
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("AV Paulista, 509");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("teste@teste.com.br");
        driver.findElement(By.xpath(" //input[@type='tel']")).sendKeys("119773512");
        //Exercicio 02
        driver.findElement(By.xpath("//*[@value='Male']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Male']")).isSelected());

        //Exercicio03
        driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
        Assert.assertTrue("Checkbox não selecionado",driver.findElement(By.xpath("//input[@id='checkbox1']")).isSelected());
        Assert.assertTrue("Checkbox selecionado", driver.findElement(By.xpath("//label[contains(text(),'Movies')]")).isSelected());

    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
