package tests.day19_ReUsableMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_Raporlama extends TestBaseRapor {


    @Test
    public void test1(){
        extentTest = extentReports.createTest("nutella test report", "nutella arama sonucu testi");

        // amazon sayfasina gidip
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Istenilen sayfaya gidildi.");
        // nutella icin arama yapalim
        WebElement searchboxElement = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchboxElement.sendKeys(ConfigReader.getProperty("amazonArananKelime")+Keys.ENTER);
        extentTest.info("siteye aranmak istenen kelime gonderildi");



        // sonuc sayisinin 1000'den az oldugunu test edelim
        WebElement resultElement = Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        extentTest.info("istenilen sonuc elementine ulasildi.");

        String resultText = resultElement.getText();
        String resultArr [] = resultText.split(" ");
        extentTest.info("istenilen sonuc elementi texte cevrildi ve ayrildi.");

        int resultNum = Integer.parseInt(resultArr[2]);
        extentTest.info("istenilen degere ulasildi");


        Assert.assertTrue(resultNum<1000);
        extentTest.pass("Sonuc sayisini Test Pass");

        Driver.closeDriver();




    }
    @Test
    public void test2(){

        extentTest = extentReports.createTest("samsung test report", "samsung arama sonucu testi");

        // amazon sayfasina gidip
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Istenilen sayfaya gidildi.");
        // samsung icin arama yapalim
        WebElement searchboxElement = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchboxElement.sendKeys("samsung"+Keys.ENTER);
        extentTest.info("siteye aranmak istenen kelime gonderildi");



        // sonuc sayisinin 1000'den az oldugunu test edelim
        WebElement resultElement = Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        extentTest.info("istenilen sonuc elementine ulasildi.");

        String resultText = resultElement.getText();
        String resultArr [] = resultText.split(" ");
        extentTest.info("istenilen sonuc elementi texte cevrildi ve ayrildi.");

        String  resultStr = resultArr[3];
        resultStr = resultStr.replace(",","");

        int resultNum = Integer.parseInt(resultStr);
        extentTest.info("istenilen degere ulasildi");

        Assert.assertTrue(resultNum<1000);
        extentTest.pass("Sonuc sayisini Test Pass");

        Driver.closeDriver();



    }

    @Test
    public void test3(){

        extentTest = extentReports.createTest("java dropdown test report", "java dropdown arama sonucu testi");

        // amazon sayfasina gidip
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Istenilen sayfaya gidildi.");
        // electronic kategoroinden java icin arama yapalim
        Select select = new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Electronics");
        extentTest.info("Dropdown Electronics secildi.");

        WebElement searchboxElement = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchboxElement.sendKeys("Java"+Keys.ENTER);
        extentTest.info("Java aratildi");

       String firstElementText = Driver.getDriver().findElement(By.xpath("(//span[@class='a-size-base a-color-base a-text-normal'])[1]")).getText();

        Assert.assertTrue(firstElementText.contains("Java"));
        extentTest.info("Ilk urun text iceriginde java olmali");







        // cikan sonuclarin ilkinin isminde java oldugunu test edelim.

    }
}
