package home;

import base.BaseTests;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;


public class HomeTests extends BaseTests {

    WebDriver driver;
//  public void testSuccessfulLogin() throws InterruptedException, FileNotFoundException {
    @Test
    public void testSuccessfulLogin() throws InterruptedException, IOException {

        File file=new File("C:\\Users\\NISH\\OneDrive\\Desktop\\Test.xlsx");
        FileInputStream fis=new FileInputStream(file);
        XSSFWorkbook workbook=new  XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheetAt(0);//   String cellValue= sheet.getRow(0).getCell(0).getStringCellValue();
     //   System.out.println(cellValue);

        int rowCount=sheet.getPhysicalNumberOfRows();

        for (int i=0;i<rowCount;i++){
            XSSFRow row =sheet.getRow(i);
            String value= String.valueOf(row.getCell(0));

            //GİRİŞ İŞLEMLERİ

            //LoginPage loginPage = homePage.clickLoginUp();
            //Thread.sleep(2000);

            //loginPage.setEmail("password@gmail.com");
            //loginPage.setPassword("******");
            //Thread.sleep(2000);

            //loginPage.clickLoginDown();
            //Thread.sleep(2000);



            //ÜRÜN ARAMA
            SearchProductPage searchProductPage = homePage.clickSearch();
            Thread.sleep(2000);
            searchProductPage.setSearch(value);
            Thread.sleep(2000);
            searchProductPage.clickIcon();
            Thread.sleep(2000);

            //KARGO BEDAVA
            searchProductPage.freeCargo();
            Thread.sleep(2000);

            //EN ÇOK DEĞERLENDİRİLEN ÜRÜN
            searchProductPage.Dropdown();
            Thread.sleep(3000);

            //ilk penceremizi ilk olarak kaydedelim
            //String firstWin=driver.getWindowHandle();
            //String firsWinURL=driver.getCurrentUrl();
            //System.out.println("Başlangıç pencerem: "+ firsWinURL);

            //ÜRÜNE TIKLA
            searchProductPage.selectProduct(1);
            Thread.sleep(3000);

            //SEKMEMİZİ DEĞİŞTİRMEMİZ GEREKİYOR
            Set<String> windowAllWindows=driver.getWindowHandles();
            for(String window:windowAllWindows){
                driver.switchTo().window(window);
            }
            Thread.sleep(3000);

            //SEPETE EKLE
            searchProductPage.addProduct();
            Thread.sleep(2000);
        }
        workbook.close();
        fis.close();

    }
}

