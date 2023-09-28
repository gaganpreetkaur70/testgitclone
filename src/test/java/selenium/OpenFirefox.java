package selenium;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

public class OpenFirefox {
public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\reshm\\eclipse-workspace\\Hello-Selenium\\src\\test\\resources\\drivers\\geckodriver.exe");
	FirefoxDriver wd = new FirefoxDriver();
	wd.get("https://www.google.com");
}
}
