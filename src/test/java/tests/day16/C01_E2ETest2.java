package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_E2ETest2 {

    //3. https://qa-environment.concorthotel.com/ adresine gidin.
    // 4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
    // a. Username : manager  b. Password  : Manager1!
    // 5. Login butonuna tıklayın.
    // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
    // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    // 8. Save butonuna basin.
    // 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
    //10. OK butonuna tıklayın.
    //11. Hotel rooms linkine tıklayın.
    //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..

    @Test
    public void createHotel() throws InterruptedException {


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

        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        qaConcortPage.hotelManagementElement.click();
        qaConcortPage.hotelRoomLink.click();
        qaConcortPage.addHotelRoom.click();

        // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Select select = new Select(qaConcortPage.addIdDropdown);

        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddRoomIdHotel"));

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).sendKeys(faker.name().name())
                .sendKeys(Keys.TAB).sendKeys(faker.address().country()).perform();
        Thread.sleep(2000);

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAAddRoomDescription")).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAAddRoomPrice")).perform();
        Thread.sleep(2000);

        select = new Select(qaConcortPage.addRoomType); // yukaridaki dropdownda yeni locator ile yapammiz gerekir.

        select.selectByVisibleText(ConfigReader.getProperty("CHQAAddRoomType"));

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(2000);
        actions. sendKeys(String.valueOf(faker.number().numberBetween(1,2)))
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,5)))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).perform();

        actions.click(qaConcortPage.saveButton).perform();

        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.successfulText.isDisplayed());

        qaConcortPage.htmlOkButton.click();

        actions.sendKeys(Keys.HOME).perform();

        qaConcortPage.hotelroomsuplink.click();

        // LIST OF USERS yazisinib testi yapilmadi. internetin kotu olmasindan dolayi.













    }


}
