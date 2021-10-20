package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {

    // Bir test method olustur positiveLoginTest()
    // https://qa-environment.concorthotel.com/ adresine git
    // login butonuna bas
    // test data username: manager ,
    // test data password : Manager1!
    // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void positiveLoginTest(){
        // https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        // login butonuna bas
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();

        // test data username: manager ,
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        // test data password : Manager1!
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(qaConcortPage.basariliGirisYaziElementi.isDisplayed());

        Driver.closeDriver();









    }



}
