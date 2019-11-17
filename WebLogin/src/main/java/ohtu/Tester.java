package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Math;

public class Tester {

    public static void main(final String[] args) {
        final WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        

/*
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        sleep(3);
*/
/*
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();
        sleep(3);

*/


        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+((int) (Math.random()*10000000)));
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("pekka");
        element.submit();
        sleep(2);
        
        driver.findElement(By.linkText("continue to application mainpage")).click();
        sleep(3);
        driver.findElement(By.linkText("logout")).click();
        sleep(3);
   
        driver.quit();
    }
    
    private static void sleep(final int n){
        try{
            Thread.sleep(n*1000);
        } catch(final Exception e){}
    }
}
