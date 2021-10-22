package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01_ReadExcel {

    @Test
    public void test() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim

        String dosyaYolu ="src/test/java/resources/ulkeler.xlsx";

        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        //** exceptions throws firlattik

        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //** ya create edemezsem throws cikti ve en sonunda IOExceptions firlatti

        //10. WorkbookFactory.create(fileInputStream)
        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");

        //12. Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(2);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);
        //** kutuphaneyi apache library den import etmeliyiz.

        // ** 2 satir 3 sutun u getirelim...

        //** indexler 0 dan basliyor basliklar da alinir.

        System.out.println(cell); //  output : Tiran

        //** burada Driver kullanmadik. Local de calisiyoruz.


        //** siralama workbook>worksheet>row>cell


    }

    //** daha kolay bir yolu daha var.... test 2'de

    @Test
    public void test2() throws IOException {

        // 7. Dosya yolunu bir String degiskene atayalim

        String dosyaYolu ="src/test/java/resources/ulkeler.xlsx";

        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //10. WorkbookFactory.create(fileInputStream)
        //11. Worksheet objesi olusturun workbook.getSheetAt(index)


        //12. Row objesi olusturun sheet.getRow(index)

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell = workbook.getSheet("Sayfa1").getRow(5).getCell(3);

        System.out.println(cell); //  output : Luanda

        // secilen hucredeki yazinin Luanda oldugunu test edin.
        //** Assert.assertEquals(cell,"Luanda"); test fail olur. burada cell in datatype i Cell dir Luanda ise String dir.
        //** Datatype lari farkli oldugu icin esit olmayacaktır.

        Assert.assertEquals(cell.toString(),"Luanda");

        Assert.assertEquals(cell.getStringCellValue(),"Luanda");

        //** Cell datatype yazdirilabilir ancak String methodlari ile kullanilamaz.
        //** String manipulation yapmak icin cell datatypini Stringe cast yapmaliyiz.

        // satir 3 indexi ve  sutun 2 indexili celli  buyuk harflerle yazdiriniz.

        Cell cell1 = workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase());  // output : CEZAYİR


        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()); // output : 190 -> index 0 ile basladigi icin normalde 191 satir var.
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows()); // output : 191 bu fiziksel olarak var olan ici dolu olan satir sayisini verir.
        System.out.println(workbook.getSheet("Sayfa1").getFirstRowNum()); // output : 0 ilk satir dolu


        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum()); // output : 19
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());  // output : 12
        System.out.println(workbook.getSheet("Sayfa2").getFirstRowNum()); // output : 2 sayfa2 de 0ve 1. index bostu, ilk 2 satir bostu


        // getLastRowNum() son satirin indexini verir.
        // getPhysicalNumberOfRows() fiili olarak kullanilan satir sayisini verir.
        // getFirstRowNum() fiziksel olarak dolu olan ilk satiri getirdi.

    }

    @Test
    public void test3 () throws IOException {
        // tablodaki 2. sutunu bir liste olarak yazdirin.

        List<String> ikinciSutun= new ArrayList<>();

        // tum satirlara ulasmak istiyorum.
        String dosyaYolu ="src/test/java/resources/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum(); i++) { //  = koyduk cunku son tair indexine de ihtiyacim var

            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());

        }
        System.out.println(ikinciSutun);



        // A ile baslayan sehirleri liste yapip yazdirin

        List<String> aIleBaslayanSehirler=new ArrayList<>();
        /*
        for (String each: ikinciSutun
        ) {
            if (each.startsWith("A")){
                aIleBaslayanSehirler.add(each);
            }
        }
        System.out.println(aIleBaslayanSehirler);
        */

        ikinciSutun.stream().filter(t->t.startsWith("A")).forEach(t->aIleBaslayanSehirler.add(t));
        System.out.println(aIleBaslayanSehirler);







        // eger tum datayi javada kullanilabilir bir collectiona cevirmek istersek en uygun yapi maptir.
        // map icin unique degerleri sahip bir sutunu key geriye kalani ise virgulle ayrilan stringler olarak value yapmaliyiz.
        // key=Turkey Value=Ankara, Turkiye, Ankara

        Map<String ,String > ulkelerMap = new HashMap<>();

        String key="";
        String value = "";
        for (int i = 0; i <=workbook.getSheet("Sayfa1").getLastRowNum() ; i++) {
            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);

        // biz java methodlarini collectionsi kullanarak exceldeki datalari manipule edecegimiz bir ortama aldik.


    }
}
