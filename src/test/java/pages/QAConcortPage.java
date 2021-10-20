package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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










}
