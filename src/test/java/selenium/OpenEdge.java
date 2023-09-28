package selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenEdge {
public static void main(String[] args) {
	System.setProperty("webdriver.edge.driver", "C:\\Users\\reshm\\eclipse-workspace\\Hello-Selenium\\src\\test\\resources\\drivers\\msedgedriver.exe");
	WebDriver wd = new EdgeDriver();
	wd.get("https://www.google.com");
}
}
