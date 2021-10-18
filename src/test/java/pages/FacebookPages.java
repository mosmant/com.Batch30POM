package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Watchable;

public class FacebookPages {

    WebDriver driver;

    public FacebookPages (WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }


    @FindBy(id = "email")
    public WebElement emailBoxElement;

    @FindBy(id = "pass")
    public WebElement passBoxElement;

    @FindBy(name = "login")
    public WebElement loginButtonElement;

    // cookies icin method olusturacagiz. driver calisacak. drivera deger atadik.
    public void passCookies(){
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
    }

    @FindBy(className = "_9ay7")
    public WebElement textElement;


}
