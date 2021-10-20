package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {

    //  1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    //  3 Farkli test Methodunda 3 senaryoyu test et
    //      - yanlisSifre
    //      - yanlisKulllanici
    //      - yanlisSifreKullanici
    //  test data yanlis username: manager1 , yanlis password : manager1
    //  2) https://qa-environment.concorthotel.com/ adresine git
    //  3) Login butonuna bas
    //  4) Verilen senaryolar ile giris yapilamadigini test et

    QAConcortPage qaConcortPage;

    @Test (priority = -1)
    public void yanlisSifre(){
        //  2) https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        qaConcortPage.loginButonu.click();
        Assert.assertTrue(qaConcortPage.loginFailedYazisi.isDisplayed());

        // burada driveri kapatmali miyim

        // burada driveri kapatirsam yeniden siteye gitmem gerekir.
        // driveri kapatmazsam login username ve passwordu temizlemeliyim.






    }

    @Test (dependsOnMethods = "yanlisSifre" )
    public void yanlisKulllanici(){
        qaConcortPage = new QAConcortPage();
        // 1 siteye gitmeyecegim
        // 2 login linkine click yapmayacagim
        // 3 girisleri once temizle ardından yeni giris yap
        qaConcortPage.usernameKutusu.clear();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        qaConcortPage.passwordKutusu.clear();
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();
        Assert.assertTrue(qaConcortPage.loginFailedYazisi.isDisplayed());





    }

    @Test (dependsOnMethods = "yanlisSifre" )
    public void yanlisSifreKullanici(){
        qaConcortPage = new QAConcortPage();
        // 1 siteye gitmeyecegim
        // 2 login linkine click yapmayacagim
        // 3 girisleri once temizle ardından yeni giris yap

        qaConcortPage.usernameKutusu.clear();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        qaConcortPage.passwordKutusu.clear();
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        qaConcortPage.loginButonu.click();
        Assert.assertTrue(qaConcortPage.loginFailedYazisi.isDisplayed());

        Driver.closeDriver();




    }



}
