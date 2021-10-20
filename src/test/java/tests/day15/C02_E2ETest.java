package tests.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_E2ETest {

    @Test
    public void createHotel() throws InterruptedException {

        //  1. Tests packagenin altına class olusturun: D17_CreateHotel
        //  2. Bir metod olusturun: createHotel
        //  3. https://qa-environment.concorthotel.com/ adresine git.
        //  4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
        //      a. Username : manager
        //      b. Password  : Manager1!
        //  5. Login butonuna tıklayın.
        //  6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        //  7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //  8. Save butonuna tıklayın.
        //  9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        //  10. OK butonuna tıklayın.


        //  3. https://qa-environment.concorthotel.com/ adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        //  4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
        //      a. Username : manager
        //      b. Password  : Manager1!

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));

        // 5. Login butonuna tıklayın.

        qaConcortPage.loginButonu.click();

        //  6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        qaConcortPage.hotelManagementElement.click();
        qaConcortPage.hotelListLink.click();
        qaConcortPage.addHotelElement.click();

        //  7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        actions.click(qaConcortPage.addHotelCodeBox)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(faker.name().name())
                .sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Select select = new Select(qaConcortPage.selectGroup);
        select.selectByVisibleText("Hotel Type1");

        //  8. Save butonuna tıklayın.
        qaConcortPage.createHotelSave.click();
        Thread.sleep(5000);


        //  9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(qaConcortPage.htmlAlertText.isDisplayed(),"text not visible  TEST FAILED");

        //  10. OK butonuna tıklayın.
        qaConcortPage.htmlOkButtonElement.click();

        // 11. hotel rooms linkine tiklayiniz
        qaConcortPage.hotelRoomsButonu.click();

        // 12. "LIST OF HOTELROOMS" textinin gorundugunu dogrulayınız.

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(qaConcortPage.listOfHotelRoomsYazisi.isDisplayed(),"text not visible  TEST FAILED");

        softAssert.assertAll();

        Driver.closeDriver();

    }

}
