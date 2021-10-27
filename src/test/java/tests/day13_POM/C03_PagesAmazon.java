package tests.day13_POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C03_PagesAmazon extends TestBase {

    @Test
    public void testPOM(){

        // amazon.com a git
        // dropdown menuden book kategorisini secelim
        // java icin arama yapalim
        // bulunan sonuc sayisini yazalim
        // ilk urunun isminde java icerip icermediginin test edecegim.

        driver.get("https://www.amazon.com");

        AmazonPage amazonPage = new AmazonPage(driver);

        Select select = new Select(amazonPage.dropDownElement);

        select.selectByVisibleText("Books");


        amazonPage.searchBoxElement.sendKeys("java"+ Keys.ENTER);

        System.out.println(amazonPage.resultTextElement.getText());

        // ilk urun java iceriyor mu testi
        Assert.assertTrue(amazonPage.firstProducutNameElement.getText().contains("Java"),"this text doesnt contains java TEST FAILED ");




    }


}
