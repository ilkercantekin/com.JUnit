package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class C01_MouseActions extends TestBase {
    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions= new Actions(driver);
        WebElement cizilialanElementi=driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizilialanElementi).perform();
        ReusableMethods.bekle(2);
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi="You selected a context menu";
        String actualAlertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilksayfaWHD=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> tumWHDler=driver.getWindowHandles();
        String ikincisayfaWHD="";
        for (String eachWHD:tumWHDler
             ) {
            if (!ilksayfaWHD.equals(eachWHD)){
                ikincisayfaWHD=eachWHD;
            }
        }

        driver.switchTo().window(ikincisayfaWHD);
        String expectedYeniSayfaYazisi="Elemental Selenium";
        String actualYeniSayfaYazisi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedYeniSayfaYazisi,actualYeniSayfaYazisi);

        ReusableMethods.bekle(3);

    }



}
