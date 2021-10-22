package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {

    public WebDriver driver;
    public QAConcortPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id="UserName")
    public WebElement usernameKutusu;

    @FindBy(id="Password")
    public WebElement passwordKutusu;

    @FindBy(id="btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath="//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement loginFailedYazisi;
    
    @FindBy (xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementElement;

    @FindBy (partialLinkText = "Hotel List")
    public WebElement hotelListLink;

    @FindBy (xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotelElement;

    @FindBy (id = "Code")
    public WebElement addHotelCodeBox;

    @FindBy (id = "IDGroup")
    public WebElement selectGroup;

    @FindBy(id = "btnSubmit")
    public WebElement createHotelSave;

    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement htmlAlertText;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement htmlOkButtonElement;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsButonu;

    @FindBy(xpath = "(//span[@class='caption-subject font-green-sharp bold uppercase'])")
    public WebElement listOfHotelRoomsYazisi;

    @FindBy (partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomLink;

    @FindBy (xpath = "//*[text()='Add Hotelroom ']")
    public WebElement addHotelRoom;

    @FindBy (id = "IDHotel")
    public WebElement addIdDropdown;

    @FindBy (id = "IDGroupRoomType")
    public WebElement addRoomType;

    @FindBy (id = "btnSubmit")
    public WebElement saveButton;

    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement successfulText;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement htmlOkButton;

    @FindBy (linkText = "Hotelrooms")
    public WebElement hotelroomsuplink;

    @FindBy (xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirListesi;

    @FindBy (xpath = "//tbody//tr[1]")
    public WebElement birinciSatir;

    @FindBy (xpath = "//tbody//tr//td[4]")
    public List<WebElement> dorduncuSutunListesi;

    @FindBy (xpath = "//tbody//tr//td")
    public List<WebElement> tumHucrelerListesi;

    @FindBy (xpath = "//tbody//tr[1]//td")
    public List<WebElement> columnListesi;

    @FindBy (xpath = "//tbody//tr//td[5]")
    public List<WebElement> besincisutunListesi;











    public void ConcortHotelLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();
    }


    public String printData(int row, int column) {
        // ornekteki haliyle 3 satir 5 sutun haliyle yazdiralim.
        // String xpath = //tbody//tr[3]//td[5]
        // degismeyecek kisimalri string , degisecek kisimlari ise parametre ismi olarak yazdik.

        String xpath ="//tbody//tr["+row+"]//td["+column+"]"; // concat


        // @FindBy annotation i parametre alamadigi icin eski findElement methoduna By.xpath methodunu kullandik.
        String istenenData = Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("row no: "+ row + " , column no : "+ column +" data : "+istenenData);


        return istenenData;

    }
}
