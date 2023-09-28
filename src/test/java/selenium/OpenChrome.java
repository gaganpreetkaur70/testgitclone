package selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChrome {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\eclipse-workspace\\Hello-Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
	WebDriver wd = new ChromeDriver();
	wd.get("https://www.amazon.com");
}
}
