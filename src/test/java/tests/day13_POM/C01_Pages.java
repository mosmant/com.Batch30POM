package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C01_Pages extends TestBase {

    // amazon sayfasina gidip
    // nutella icin arama yapin
    // sonuc sayisini yazdirin ve sonuc yazisinin nutella icerdigini test edin

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultText.getText());

        Assert.assertTrue(resultText.getText().contains("Nutella"),"result text doesn't contains nutella TEST FAILED");

    }
    @Test
    public void testPOM(){
        driver.get("https://www.amazon.com");
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.searchBoxElement.sendKeys("Nutella"+Keys.ENTER);
        System.out.println( amazonPage.resultTextElement.getText());
        Assert.assertTrue(amazonPage.resultTextElement.getText().contains("Nutella"),"result text doesn't contains nutella TEST FAILED");
    }


}
