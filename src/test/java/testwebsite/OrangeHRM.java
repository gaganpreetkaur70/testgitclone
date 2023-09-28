package testwebsite;

import java.time.Duration;

import org.apache.logging.log4j.plugins.di.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OrangeHRM {
	static WebDriver wd =new ChromeDriver();
	static String url=" https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ";
	@FindBy(name = "username")WebElement LoginPage_username;
	@FindBy(name="password")WebElement LoginPage_Passwd;
	@FindBy(xpath="//div//button[@type='submit']")WebElement LoginPage_Login;
	@FindBy(linkText = "Contact Details")WebElement ContactDetailslink;
	@FindBy(xpath="*//label[contains(text(),'Street 1')]/../..//div[2]//input[@class='oxd-input oxd-input--active']")WebElement ContactDetails_Street1;
	@FindBy(xpath="//*[contains(text(),'Street 2')]/../../div[2]//input[@class='oxd-input oxd-input--active']")WebElement ContactDetails_street2;
	@FindBy(xpath="//*[@class='oxd-select-text oxd-select-text--active']") WebElement ContactDetails_CountryDRP;
	@FindBy(xpath="//*[contains(text(),'Australia')]")WebElement CountryDRP_Australia;
	@FindBy(xpath="//*[contains(text(),'Home')]/../..//div[2]//input[@class='oxd-input oxd-input--active']")WebElement Telephone_Home;
	@FindBy(xpath="//*[contains(text(),'Mobile')]/../..//div[2]//input[@class='oxd-input oxd-input--active']")WebElement Telephone_Mobile;
	@FindBy(xpath="//label[text()='Work']/../..//div[2]//input[@class='oxd-input oxd-input--active']")WebElement Telephone_Work;
	@FindBy(xpath="//label[text()='Work Email']/../..//div[2]//input[@class='oxd-input oxd-input--active']")WebElement WorkEmail;
	@FindBy(xpath="//label[text()='Other Email']/../../div[2]//input[@class='oxd-input oxd-input--active']")WebElement OtherEmail;
	@FindBy(xpath="//form//div[4]//button[@type='submit']")WebElement SaveButton;
	
	@Test(priority=1)
	public void LoginPage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\eclipse-workspace\\Hello-Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PageFactory.initElements(wd,this);
		wd.get(url);
		LoginPage_username.sendKeys("Admin");
		LoginPage_Passwd.sendKeys("admin123");
		LoginPage_Login.click();
		
	
	}
	@Test(priority=2)
	public void DashBoard()  {
		String url="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		wd.get(url);
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PageFactory.initElements(wd, this);
		WebElement Dashboard_MyInfo=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Info")));
		//wd.switchTo(); Why to use? even if not using then also script worked. 
		Dashboard_MyInfo.click();
	}
	@Test(priority=3)
	public void contactdetails() throws InterruptedException {
		String url="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7";
		wd.get(url);
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PageFactory.initElements(wd, this);
		
		WebElement contD=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Contact")));
		contD.click();
		
		wd.findElements(By.tagName("input")).forEach(WebElement::clear);
		
		WebElement street1=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("*//label[contains(text(),'Street 1')]/../..//div[2]//input[@class='oxd-input oxd-input--active']")));
		Thread.sleep(3000);
		street1.click();
		street1.clear();
		Thread.sleep(2000);
		street1.sendKeys("1250Street");
		
		Thread.sleep(3000);
		WebElement street2=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Street 2')]/../../div[2]//input[@class='oxd-input oxd-input--active']")));
		street2.click();
		street2.clear();
		Thread.sleep(2000);
		street2.sendKeys("1234 street");
		
		Thread.sleep(3000);
		WebElement city=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'City')]/../..//div[2]//input[@Class='oxd-input oxd-input--active']")));
		city.click();
		//city.clear();
		city.sendKeys("New York");
		
		Thread.sleep(3000);
		WebElement state=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'State/Province')]/../..//div[2]//input[@class='oxd-input oxd-input--active']")));
		state.click();
		state.clear();
		state.sendKeys("New York");
		
		Thread.sleep(3000);
		WebElement zipcode=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Zip/Postal Code')]/../..//div[2]//input[@class='oxd-input oxd-input--active']")));
		zipcode.click();
		zipcode.clear();
		zipcode.sendKeys("123456");
		
		ContactDetails_CountryDRP.click();
		CountryDRP_Australia.click();
		
		Telephone_Home.clear();
		Telephone_Home.sendKeys("1234567890");
		
		Telephone_Mobile.clear();
		Telephone_Mobile.sendKeys("1234567890");
		
		Thread.sleep(2000);
		
		Telephone_Work.sendKeys("0123456789");
		
		WorkEmail.clear();
		Actions action = new Actions(wd);
		action.click().doubleClick(WorkEmail).sendKeys(org.openqa.selenium.Keys.DELETE).build().perform();
		//action.sendKeys(Keys.DELETE).build().perform();
		//new Actions(wd).keyDown(Keys.SHIFT).keyDown(Keys.ARROW_LEFT).keyDown(Keys.DELETE).perform();
		WorkEmail.sendKeys("aaa@aaa.com");
		
		action.doubleClick(OtherEmail).sendKeys(org.openqa.selenium.Keys.DELETE).build().perform();
		OtherEmail.sendKeys("bbb@bbb.com");
		SaveButton.click();
	}
	

}
