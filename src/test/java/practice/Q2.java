package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q2 extends TestBase {

    //              ..Exercise2...
//  http://www.bestbuy.com 'a gidin,
//  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
//  Ayrica Relative Locator kullanarak;
//      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
//  Ayrica Relative Locator kullanarak;
//      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
        @Before
        public void beforeTest(){
            driver.get("http://www.bestbuy.com");
        }
    @Test
    public void titleTest(){
    String expectedTitle = "Best";
    String actualTitle= driver.getTitle();
        //System.out.println(actualTitle); yazdırmak testi zorlar
    assertTrue(actualTitle.contains(expectedTitle));

    }
    @Test
    public void logoTest(){
       WebElement logoyaziElementi=driver.findElement(By.xpath("//*[text()='Hello!']"));
       WebElement bestBuyLogoElementi=driver.findElement(RelativeLocator.with(By.tagName("img")).above(logoyaziElementi));
       assertTrue(bestBuyLogoElementi.isDisplayed());
    }
    @Test
    public void mexicolinkTest(){
        WebElement usaElementi=driver.findElement(By.xpath("(//*[@class='us-link'])[1]"));
        WebElement mexicoFlag=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usaElementi));
        boolean goruntuleniyormu=mexicoFlag.isDisplayed();
        assertTrue(goruntuleniyormu);
    }


}
