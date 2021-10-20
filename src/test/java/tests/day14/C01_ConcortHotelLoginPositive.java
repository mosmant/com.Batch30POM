package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPositive extends TestBase {

    @Test
    public void positiveLoginTest(){
        // 1 ) Bir Class olustur : PositiveTest
        // 2 ) Bir test method olustur positiveLoginTest()
        // https://www.concorthotel.com/ adresine git

        driver.get("https://www.concorthotel.com/");
        // login butonuna bas
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.ilkLoginLinki.click();
        // test data username: manager ,
        concortHotelPage.usernameKutusu.sendKeys("manager");
        // test data password : Manager1!
        concortHotelPage.passwordKutusu.sendKeys("Manager1!");
        concortHotelPage.loginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.basariliGirisYaziElementi.isDisplayed(),"yazi gorunmuyor TEST FAILED");


    }

}
