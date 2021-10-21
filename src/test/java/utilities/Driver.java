package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){}
    // public ve static -> heryerden ulasabilirim. Class ismiyle static veriye ulasabilirim...
    // ama baska classlardan bu driveri yanlislikla kullanmasinlar diye erisimi private yaptik.(sadece bu classin kullanimina acik)


    public static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver == null) {
            // buraya yazilan ifin nedeni bu method her calistiginda yeni bir driver olusturmamasi icin kullaniyoruz.
            // if driveri kontrol edecek eger bir deger atamasi yapildiysa yeni bir driver olusturmayacak.


        switch (ConfigReader.getProperty("browser")) {
            // case i driveri istedgimimz browserda calistirmak icin kullanmaliyiz.
            // configuration.properties dosyasinda browser olarak ne yazdiysak tum testlerimiz o browserda calisacak

            case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;

            case "firedox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;

            case "opera":
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            break;

            case "edge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;

            default:
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();


        }




        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return driver;
        }


    public static void closeDriver(){

        if (driver != null) {
            driver.close();
        }
        driver = null;

        // burada yeniden null degeri atamamizin sebebi bir sonraki getDriver methodu cagirisimizda yeni bir deger atayabilmek istememizidir.

    }
}
