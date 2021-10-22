package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

import java.util.List;

public class C99_Practise {

    //● Bir class oluşturun : D18_WebTables
    //● login() metodun oluşturun ve oturum açın.
    //● ● https://qa-environment.concorthotel.com/ /admin/HotelRoomAdmin adresine gidin		○ Username : manager  	○ Password : Manager2!
    //● table() metodu oluşturun
    //	○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //	○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //● printRows() metodu oluşturun //tr
    //	○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    //	○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //	○ 4.satirdaki(row) elementleri konsolda yazdırın.
    //● printCells() metodu oluşturun //td
    //	○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    //	○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
    //● printColumns() metodu oluşturun
    //	○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
    //	○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
    //	○ 5.column daki elementleri konsolda yazdırın.
    QAConcortPage qaConcortPage;

    @Test (priority = -1)
    public void login(){

        qaConcortPage = new QAConcortPage();

        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementElement.click();
        qaConcortPage.hotelRoomsButonu.click();
   }

   @Test (dependsOnMethods = "login")
   public void table(){
        qaConcortPage=new QAConcortPage();
       //	○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
       System.out.println("baslik adedi : "+qaConcortPage.basliklarListesi.size());
       //	○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
       qaConcortPage.basliklarListesi.stream().forEach(t-> System.out.println(t.getText()));

       Driver.closeDriver();
  }
  @Test (dependsOnMethods = "login")
    public void printRows(){
      qaConcortPage = new QAConcortPage();
        //	○ table body’sinde bulunan toplam satir(row) sayısını bulun.
      System.out.println("satir adedi"+qaConcortPage.satirListesi.size());


      //	○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
      qaConcortPage.satirListesi.stream().forEach(t-> System.out.println(t.getText()));
      //	○ 4.satirdaki(row) elementleri konsolda yazdırın.

      qaConcortPage.dorduncuSutunListesi.stream().forEach(t-> System.out.println(t.getText()));
 }
 @Test (dependsOnMethods = "login")
    public void printCells(){
     qaConcortPage = new QAConcortPage();
     //	○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
     System.out.println(qaConcortPage.tumHucrelerListesi.size());

     //	○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
     qaConcortPage.tumHucrelerListesi.stream().forEach(t-> System.out.println(t.getText()));

 }
 @Test (dependsOnMethods = "login")
    public void printColumns(){
    qaConcortPage = new QAConcortPage();
     //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
     int columnNumberInTableBody = Driver.getDriver().findElements(By.xpath("//tbody//tr[1]//td")).size();
     System.out.println("Column number in table body is: " + columnNumberInTableBody);
     System.out.println("-------------------------------------------------------------------------");
     //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.

     for (int i = 1; i < columnNumberInTableBody + 1; i++) {

         List<WebElement> eachColumnElements = Driver.getDriver().findElements(By.xpath("//tbody//td[" + i + "]"));
         System.out.println(i + ". Column's Elemnts are: ");
         System.out.println("---------------------------");
         eachColumnElements.stream().forEach(t -> System.out.println(t.getText()));
         System.out.println();


     //	○ 5.column daki elementleri konsolda yazdırın.
     qaConcortPage.besincisutunListesi.stream().forEach(t-> System.out.println(t.getText()));



 }

}}
