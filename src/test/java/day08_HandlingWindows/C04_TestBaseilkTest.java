package day08_HandlingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TestBaseilkTest extends TestBase {
    WebDriver driver;
    @Test
    public void test01(){

        // amazon'a gidin
        driver.get("https://www.amazon.com");

        // amazon'a gittiginizi test edin

        String expectedKelime= "amazon";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedKelime));

        ReusableMethods.bekle(3);
    }
}
