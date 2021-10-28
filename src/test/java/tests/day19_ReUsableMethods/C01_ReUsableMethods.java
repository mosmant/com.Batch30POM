package tests.day19_ReUsableMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReUsableMethods {



    // https://the-internet.herokuapp.com/windows
    // click here butonuna basalim
    // yeni acilan sayfada new window yazisinin gorundugunu test edin.
    @Test
    public void test(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        // 2. sayfa acilamdan evvel bilk sayfanın windowhandle degerini almaliyiz.
        String ilkSayfaWindowHandleDegeri = Driver.getDriver().getWindowHandle();

        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        // window handles degerlerini set olarak dondurur.
        Set<String > windowHandleKumesi = Driver.getDriver().getWindowHandles();
        String ikinciSayfaHandleDegeri = "";

        for (String aech: windowHandleKumesi) {
            if (!aech.equals(ikinciSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=aech;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandleDegeri);
        System.out.println(Driver.getDriver().getTitle());

        //yeni sayfada new window yazisinin gorundugunu test edelim

        WebElement newWindowTextElement = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(newWindowTextElement.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void testReUsableMethod(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        ReusableMethods.switchToWindow("New Window");

        WebElement newWindowTextElement = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(newWindowTextElement.isDisplayed());

        ReusableMethods.waitFor(5);

        Driver.closeDriver();






    }
}
