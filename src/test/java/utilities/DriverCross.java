package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverCross {
    private DriverCross(){}
    // public ve static -> heryerden ulasabilirim. Class ismiyle static veriye ulasabilirim...
    // ama baska classlardan bu driveri yanlislikla kullanmasinlar diye erisimi private yaptik.(sadece bu classin kullanimina acik)


    public static WebDriver driver;

    public static WebDriver getDriver(String browser){

        if (driver == null) {
            // buraya yazilan ifin nedeni bu method her calistiginda yeni bir driver olusturmamasi icin kullaniyoruz.
            // if driveri kontrol edecek eger bir deger atamasi yapildiysa yeni bir driver olusturmayacak.

            browser = browser==null ? ConfigReader.getProperty("browser") : browser;

            // EMNIYET SUBABI : YUKARIDAKI ISLEM BROWSER A DEGER ATAMAZSAM BIZE CONFIG READER DAN DEGER AL DEMEKTIR.

            switch (browser) {
                // case i driveri istedgimimz browserda calistirmak icin kullanmaliyiz.
                // configuration.properties dosyasinda browser olarak ne yazdiysak tum testlerimiz o browserda calisacak

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
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
