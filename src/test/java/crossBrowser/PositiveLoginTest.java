package crossBrowser;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.DriverCross;
import utilities.TestBaseCross;

public class PositiveLoginTest extends TestBaseCross {

    // Bir test method olustur positiveLoginTest()
    // https://qa-environment.concorthotel.com/ adresine git
    // login butonuna bas
    // test data username: manager ,
    // test data password : Manager1!
    // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void positiveLoginTest(){
        //EVET SON GUNLERDE OLAYLAR KARISTI. CROSS BROWSER HERSEYI BIRBIRINE GIRDIRDI.

        // ACIKLAMA :  CROSS BROWSER TESTTE TESTBASE CLASSINA GERI DONUYORUZ. BUNUN SEBEBI PARAMETERS ANOTATION I DIR.
        // DOLAYISI ILE Driver.getDriver() ve pages sayfalarindaki locatorlari kullanamayiz.

        // https://qa-environment.concorthotel.com/ adresine git

        driver.get(ConfigReader.getProperty("CHQAUrl"));

        // login butonuna bas


        driver.findElement(By.linkText("Log in")).click();

        // test data username: manager ,

        driver.findElement(By.id("UserName")).sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        // test data password : Manager1!


        driver.findElement(By.id("Password")).sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        driver.findElement(By.id("btnSubmit")).click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='ListOfUsers']")).isDisplayed());











    }



}
