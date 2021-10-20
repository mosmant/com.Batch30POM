package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {

    @Test
    public void test(){

        // Driver.getDriver()=driver oldu. driver. vs yapmayacagiz.

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        Driver.closeDriver();

        // Driver driver = new Driver();
        // Driver Classindan obje uretilemesin istedigimiz icin Driver Classi Singleton yapiyoruz.
        // bunun icin default constructor yerine parametresiz bir constructor olustururuz ve access modifieri private yaparız. Buna Singleton yapi denir.

        // Driver driver = new Driver("ben istedim oldu");
        // Driver classinda parametreli constructor yok o yuzden kullanamayiz.

        // Bu zamana kadar driver. kullanıyorduk Artık bundan sonra Driver.getDriver(). ....-> kullanacagiz.

        // bu zamana kadar olusturdugumuz TestBase deki page ler yalan oldu.
    }
}
