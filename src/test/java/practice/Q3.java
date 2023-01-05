package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q3 extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
     */
    @Test
    public void test01(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement autoExerciseBasligi=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        boolean baslikGorunurMu=autoExerciseBasligi.isDisplayed();
        assertTrue(baslikGorunurMu);


     //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
     WebElement expContactUsPageBaslik=driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
     assertTrue(expContactUsPageBaslik.isDisplayed());
        //6. Enter name, email, subject and message
        WebElement firstNameTextBox=driver.findElement(By.xpath("//*[@name='name']"));
        Actions actions=new Actions(driver);
        actions.click(firstNameTextBox)
                .sendKeys("ilker")
                .sendKeys(Keys.TAB)
                .sendKeys("BLABLABLA@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("falan  filan fişmekan")
                .sendKeys(Keys.TAB)
                .sendKeys("hellllooooooooooooooooo")
                .sendKeys(Keys.TAB).perform();

        //7. Upload file
        WebElement dosyaSecButtonu= driver.findElement(By.name("upload_file"));
        String dosyayolu=System.getProperty("user.home","\\Desktop\\MerhabaJava.txt");
        dosyaSecButtonu.sendKeys(dosyayolu);
        //8. Click 'Submit' button
        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement succesyazisi= driver.findElement(By.xpath("(//*[text()='Success! Your details have been submitted successfully.'])[1]"));
        assertTrue(succesyazisi.isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//span[text()=' Home']")).click();
        assertTrue(baslikGorunurMu);

    }
}
