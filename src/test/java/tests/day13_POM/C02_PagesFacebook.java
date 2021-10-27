package tests.day13_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPages;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    // facebook login sayfasina gidin
    // facebook sayfasinda cookiesleri gec()  methodu olusturalim.
    // kullanici adi :  techproed
    // sifre  : 12345
    // yazdigimizda giris yapamadigimizi test et.


    @Test
    public void testPOM(){

        driver.get("https://www.facebook.com");
        //cookies


        FacebookPages facebookPages = new FacebookPages(driver);

        // BENIM PC DE COOKIES SIKINTISI OLMADIGI ICIN COOKIES METHODUNU CAGIRMADIM.no such element exception verir.
        // facebookPages.passCookies();

        facebookPages.emailBoxElement.sendKeys("techproed");
        facebookPages.passBoxElement.sendKeys("12345");
        facebookPages.loginButtonElement.click();

        Assert.assertTrue(facebookPages.textElement.isDisplayed(),"expected nagative text Test failed");










    }



}
