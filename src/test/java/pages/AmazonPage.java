package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    WebDriver driver;
    // bir page sayfasi olusturuldagunda mutlaka yapamami gereken bir constructor olusturup drivera ilk degeri atamaktir.
    // bunada instantiate denir.
    public AmazonPage(WebDriver driver){
        // cosntructora heryerden ulasabilmek icin public yaptik.
        // constuctora yardimci pagefactory getirdik.
        PageFactory .initElements(driver,this);
        this.driver = driver;
    }


    // WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBoxElement;

    // WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement resultTextElement;

    @FindBy (id = "searchDropdownBox")
    public WebElement dropDownElement;


    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public WebElement firstProducutNameElement;

}
