package testwebsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JuiceShop2 {
	static WebDriver wd=new ChromeDriver();
	static String url="https://juice-shop.herokuapp.com/#/login";
	@FindBy(xpath="//button[@class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']")WebElement Dismiss;
    @FindBy(partialLinkText ="want") WebElement wantit;
   @FindBy(name ="email")WebElement Login_email;
   @FindBy(name="password")WebElement Login_password;
   @FindBy(id = "loginButton")WebElement login;
   @FindBy(linkText = "Not yet a customer?")WebElement newcust;
   @FindBy(id="emailControl")WebElement createuser_email;
   @FindBy(id="passwordControl")WebElement createuser_passwd;
   @FindBy(id="repeatPasswordControl")WebElement createuser_confirmpasswd;
   @FindBy(id="mat-select-0")WebElement createuser_secquest;
  @FindBy(id ="mat-option-4")WebElement createuser_secquest1;
   @FindBy(id="securityAnswerControl")WebElement createuser_secquestans;
   @FindBy(id="registerButton")WebElement createuser_Registerbutton;
   @FindBy(xpath="//div[contains(text(),' Eggfruit Juice (500ml) ')]//../../..//div[2]//button//span[contains(text(),'Add to Basket')]")WebElement Eggfruitjuice;
    @FindBy(xpath="//mat-paginator//div//div//div[2]//button[2][@type='button']")WebElement NextPageButton;
    @FindBy(xpath="//*[contains(text(),'OWASP Juice Shop CTF Girlie-Shirt ')]//../../..//div[2]//button//span/span[contains(text(),'Add to Basket')]")WebElement girltshirt;
   @FindBy(xpath="//mat-sidenav-content//app-navbar//mat-toolbar-row//button[4]//span//span[contains(text(),' Your Basket')]")WebElement YourBasket_Button; 
    
	@Test(priority = 1)
public void Loginpage() throws InterruptedException  {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\eclipse-workspace\\Hello-Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
	
	wd.manage().window().maximize();
	wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	PageFactory.initElements(wd,this);
	wd.get(url);
	Dismiss.click();
	wantit.click();
	Thread.sleep(4000);
	JavascriptExecutor js=(JavascriptExecutor)wd;
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	newcust.click();	
}

@Test(priority = 2)
	public void login() throws InterruptedException {
		PageFactory.initElements(wd,this);
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		createuser_email.sendKeys("aa24@aaa.com");;
		createuser_passwd.sendKeys("Aaa!123");
		createuser_confirmpasswd.sendKeys("Aaa!123");
		createuser_secquest.click();
		createuser_secquest1.click();
		createuser_secquestans.sendKeys("aaaa");
		JavascriptExecutor js=(JavascriptExecutor)wd;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		createuser_Registerbutton.click();
		Thread.sleep(6000);
	}
	
	@Test(priority=3)
	public void Login() {
		PageFactory.initElements(wd,this);
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Login_email.sendKeys("aa24@aaa.com");
		Login_password.sendKeys("Aaa!123");
		login.click();	
		
	}
	@Test(priority=4)
	public void addtobasket() {
		String url="https://juice-shop.herokuapp.com/#/search";
		
		PageFactory.initElements(wd,this);
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Login();
		wd.get(url);
		wd.navigate().refresh();
		//WebElement applejuice=new WebDriverWait(wd, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),' Apple Juice (1000ml) ')]/../../../..//mat-card//div[2]//button//span//span[contains(text(),'Add to Basket')]")));
		Eggfruitjuice.click();
		JavascriptExecutor js=(JavascriptExecutor)wd;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		NextPageButton.click();
		JavascriptExecutor js1=(JavascriptExecutor)wd;
		js1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		girltshirt.click();
		YourBasket_Button.click();	
	}
	@Test(priority=5)
	public void increasethequantity() {
		PageFactory.initElements(wd,this);
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		
		
		
	}
}