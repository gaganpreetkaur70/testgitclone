//This assignment is with Page object model without using TestNG framework

package testwebsite;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class saucedemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\eclipse-workspace\\Hello-Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		String url ="https://www.saucedemo.com";
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		wd.get(url);
		
		WebElement w1= wd.findElement(By.id("user-name"));
		w1.sendKeys("standard_user");
		//wd.findElement(By.id("user-name")).sendKeys("standard_user");
		
		WebElement w2= wd.findElement(By.id("password"));
		w2.sendKeys("secret_sauce");
		//wd.findElement(By.id("password")).sendKeys("secret_sauce");
		
		
		WebElement w3= wd.findElement(By.xpath("//div//input[@id=\"login-button\"]"));
		w3.click();
		
		WebElement w4= wd.findElement(By.xpath("//div//a[@id=\"item_4_title_link\"]"));
		w4.click();
		
        WebElement w5= wd.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        w5.click();
        
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
       //WebElement w6= wd.findElement(By.xpath("//div//button[@id="back-to-products"]"));
       //w6.click();
        
        
        //WebElement w7= wd.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        //w7.click();// 
        
        //WebElement w8= wd.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        //w8.click();
        
        WebElement w9= wd.findElement(By.id("shopping_cart_container"));
        w9.click(); // add to cart button
        
        WebElement w10 = wd.findElement(By.id("checkout"));
        w10.click();
        
        WebElement checkInfo_name= wd.findElement(By.id("first-name"));
        checkInfo_name.sendKeys("abcd");
        
        WebElement Lastname= wd.findElement(By.id("last-name"));
        Lastname.sendKeys("abcd");
        
        WebElement zip= wd.findElement(By.id("postal-code"));
        zip.sendKeys("1234");
        
        WebElement cont = wd.findElement(By.id("continue"));
        cont.click();
        
        WebElement finish= wd.findElement(By.id("finish"));
        finish.click();
        
	}

}
