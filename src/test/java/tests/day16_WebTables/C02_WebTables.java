package tests.day16_WebTables;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebTables {

    //Bir class oluşturun : C02_WebTables
    //  ● login() metodun oluşturun ve oturum açın.
    //  ● https://qa-environment.concorthotel.com//admin/HotelRoomAdmin adresine gidin
    //      ○ Username : manager
    //      ○ Password : Manager1!
    //  ● table() metodu oluşturun
    //      ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //      ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //  ● printRows() metodu oluşturun //tr
    //      ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    //      ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //      ○ 4.satirdaki(row) sutundaki elementleri konsolda yazdırın.

    @Test
    public void login(){

        //   https://qa-environment.concorthotel.com/ adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        //   Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
        //      a. Username : manager
        //      b. Password  : Manager1!

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));

        //  Login butonuna tıklayın.

        qaConcortPage.loginButonu.click();
        qaConcortPage.hotelManagementElement.click();
        qaConcortPage.hotelRoomLink.click();

        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        qaConcortPage.basliklarListesi.stream().forEach(t-> System.out.println(t.getText()));

        System.out.println("Tablodaki sutun sayisi : "+qaConcortPage.basliklarListesi.size());

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        System.out.println(qaConcortPage.tBodyTumu.getText());

        // Eger tum tablo bodysini hucrelere ayirmadan tek bir String olarak gormek istersek tum bodyi tek bir WEBELEMENT olarak locate edebiliriz.

        // yukaridaki yaklasım ile happy hotel var mı bu text in icinde diye sorarsak alttaki gibi bir cozum elde ederiz.

        Assert.assertTrue(qaConcortPage.tBodyTumu.getText().contains("HAPPY HOTEL"),"HAPPY HOTEL not contains TEST FAILED");
        //  ● printRows() metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.


        System.out.println("tablodaki satir sayisi : "+qaConcortPage.satirListesi.size());

        //      ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        System.out.println(qaConcortPage.birinciSatir.getText());

        for (int i = 0; i < qaConcortPage.satirListesi.size(); i++) {

            System.out.println(i+1+". satir"+qaConcortPage.satirListesi.get(i).getText());

        }

        //      ○ 4.satirdaki(row) sutundaki elementleri konsolda yazdırın.

        qaConcortPage.dorduncuSutunListesi.stream().forEach(t-> System.out.println(t.getText()));


        Driver.closeDriver();


    }
}
