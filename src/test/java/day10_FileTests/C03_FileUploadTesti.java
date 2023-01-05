package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;

public class C03_FileUploadTesti extends TestBase {
    @Test
    public void test01(){
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        /*
             Bu gorevi yapabilmek icin chooseFile butonuna basildiginda
             acilan bilgisayarimizdaki file dosyalarini click yapabilmeemiz gerekir
             ancak Selenium bilgisayarimizdaki dosyalari click yapamaz
             Bunun yerine soyle bir cozum uretilmistir
             1- chooseFile butonunu locate edin
             2- upload edilecek dosyanin dosya yolunu olusturun
             3- chooseFile butonuna sendKeys ile dosya yolunu gonderin
         */

        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\MerhabaJava.txt";
        chooseFileButton.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadElementi= driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploadElementi.isDisplayed());
        ReusableMethods.bekle(3);
    }



}

