package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // ConfigReader nasil calisir.ConfigReader bir koprudur. test datalari ile
    // test classlarimizi tuttugumuz configuration properties arasinda bir kopru gorevi yapar.

    // 1 - Properties objesi oluşturacagiz
    static Properties properties;

    // 2 - Bu class in amaci configuration.preperties dosyasini okumak ve key value entrylerini kullanarak key e ait value yi bize getirtmek
    // ========= ONEMLI ========== > main methoddan once ne calisir -> static block

    static {
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            //burada properties objesini static block icinde olusturduk. fakat yukaridaki propertiesi s.block icinde kullanmak icin static yaptik.
            properties = new Properties();
            // burada properties obje methodu olan loadu kullandik file input stream ile okuyacagimiz objeyi koyduk.

            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 3 - Test classlarindan configReader classina ulasip yukaridaki islemleri yapmamizi saglayacak bir method olusturacagiz.
    // datalarimizi cekebilmek icin asagidaki methodu olusturyoruz. yukaridaki ifadelerden de istifade edebilsin diye static yapiyoruz.
    // bu method bize value dondurecegi icin void method olmayacak.
    public static String getProperty(String key){
        String value = properties.getProperty(key);
        return value;
    }


}
