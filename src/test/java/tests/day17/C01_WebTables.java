package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;

public class C01_WebTables {


    @Test
    public void test(){
        QAConcortPage qaConcortPage = new QAConcortPage();

        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementElement.click();
        qaConcortPage.hotelRoomsButonu.click();

        //1. pages sayfasinda Bir metod oluşturun : printData(int row, int column);
        //    a. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu    hücredeki(cell) veriyi yazdırmalıdır.


        //2. Ve bu metodu printData() methodunu cagirmak icin kullanin.
        //    b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
        String actualData = qaConcortPage.printData(3, 5);
        // bu method bize USA yani deger donecek. bunun icin bir stringe assign etmeliyiz.

        //3. yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

        // assert u bu classta yapmak istiyorsak istenen datanin bu class a gelmeşni saglamalıyız.
        // bunu da printData methodunu return methodu olarak dizayn etmeliyiz.

        Assert.assertEquals(actualData,"USA","missmatch data text TEST FAILED");


    }
}
