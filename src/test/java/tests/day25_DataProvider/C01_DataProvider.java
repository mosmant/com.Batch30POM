package tests.day25_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.driver;

public class C01_DataProvider {

    @DataProvider
    public static Object[] aranacakKelimeListesi() {
        // data provider array ile calisir.

        String [] arr = {"Nutella","Java","Apple"};

        return arr;
    }


    @Test(dataProvider = "aranacakKelimeListesi")
    public void test(String arancak){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


        // olusturdugumuz parametreler icin arama yapin
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(arancak + Keys.ENTER);


        // sonbuc sayisini yazdirin ve sonuc yazisimim aradigimiz parametre degerini icerdiginin test edin.
        WebElement resulText = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        System.out.println(resulText.getText());

        Assert.assertTrue(resulText.getText().contains(arancak));
    }


}
