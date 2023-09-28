package testwebsite;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class tutorialsninja {
	static WebDriver wd=new ChromeDriver();
	static String url="http://tutorialsninja.com/demo/index.php";
	
	
	@FindBy(xpath="//i[@class='fa fa-caret-down']")WebElement Currencydrp;
	@FindBy(xpath="//li//button[@name='EUR']")WebElement Euro;
	@FindBy(xpath="//a//img[@title='Canon EOS 5D']")WebElement cannon;
	@FindBy(xpath="//select[@id='input-option226']")WebElement selectdrp;
	@FindBy(xpath="//a//i[@class='fa fa-home']")WebElement homeclick;
	@FindBy(xpath="//a//img[@title='iPhone']")WebElement iphoneclick;
	@FindBy(xpath="//div//input[@name='quantity']")WebElement qty;
	@FindBy(xpath="//div//button[@id='button-cart']")WebElement addtocart;
	@FindBy(xpath="//button//span[@id='cart-total']")WebElement items;
	@FindBy(xpath="//div//span//button[@type='submit']")WebElement updatebtn;
	@FindBy(xpath="//li//a[@title='Checkout']")WebElement checkout;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement errormsg;
	@FindBy(xpath="//div//a//img[@title='MacBook']")WebElement macbook;
	@FindBy(xpath="//div//input[@name='quantity' and contains(@value,'1')]")WebElement chkqnty;
	@FindBy(xpath="//a[2]//strong//i[@class='fa fa-share']")WebElement checkout1;
	//@FindBy(xpath="//li[4]//a[@title='Shopping Cart']")WebElement shoppinglink;
	@FindBy(id="button-coupon")WebElement applycoupenbtn;
	@FindBy(partialLinkText  = "Certificate")WebElement giftcert;
	@FindBy(linkText="Checkout")WebElement chkoutlink;
	@FindBy(xpath="//*[contains(text(),'Register')]")WebElement registerlink;
	@FindBy(xpath="//*[contains(@name,'firstname')]")WebElement fname;
	@FindBy(xpath="//*[contains(@name,'lastname')]")WebElement lname;
	@FindBy(xpath="//*[contains(@name,'email')]")WebElement email;
	@FindBy(xpath="//*[contains(@name,'telephone')]")WebElement telephone;
	@FindBy(xpath="//*[contains(@name,'password')]")WebElement password;
	@FindBy(xpath="//*[contains(@name,'confirm')]")WebElement confirm;
	@FindBy(xpath="//div//div//label[1][@class='radio-inline']")WebElement subscribe;
	@FindBy(xpath="//div//div//input[@name='agree']")WebElement chkbox;
	@FindBy(xpath="//*[contains(@class,'btn btn-primary')]")WebElement submitlink;
	@FindBy(xpath="//div//div//a[@class='btn btn-primary']")WebElement actcreatedcont;
	//@FindBy(linkText = "View Cart")WebElement view;

	
	
	@Test
	public void allrun() {
		wd.manage().window().maximize();
		wd.get(url);
		PageFactory.initElements(wd, this);
	}
	@Test
	public void iphone() {
		wd.manage().window().maximize();
		wd.get(url);
		PageFactory.initElements(wd, this);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Currencydrp.click();
		Euro.click();
		cannon.click();
		selectdrp.click();
		try {
			WebElement element = wd.findElement(By.id("element-id"));
			element.click();
			} 
		catch (NoSuchElementException e) {
			System.out.println("Element not found! to click dropdown box");
			}	
		homeclick.click();
		iphoneclick.click();
		qty.clear();
		qty.sendKeys("2");
		addtocart.click();
		System.out.println("you have successfully added the phone");
		items.click();
		WebElement readecotax=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//li//div//table//tbody//tr[2]//td[2][@class='text-right']")));
		String abc=readecotax.getText();
		System.out.println("The Eco Tax amount is:"+abc);
		WebElement vat=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//li//div//table//tbody//tr[3]//td[2][@class='text-right']")));
		String xyz=vat.getText();
		System.out.println("The Vat Tax amount is:"+xyz);
		WebElement viewcart=new WebDriverWait(wd,Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//p//a[2][contains(@href,'https://tutorialsninja.com/demo/index.php?route=checkout/checkout')]")));
		viewcart.click();
		WebElement updateqty=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//input[@value='2']")));
		updateqty.click();
		updateqty.clear();
		updateqty.sendKeys("3");
		updatebtn.click();
		checkout.click();
		String error=errormsg.getText();
		System.out.println(error);
	}
	@Test
	public void macbook() throws InterruptedException {
		PageFactory.initElements(wd, this);
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		homeclick.click();
		macbook.click();
		JavascriptExecutor js=(JavascriptExecutor)wd;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		String abcd=chkqnty.getText();
	
			System.out.println(abcd);
		addtocart.click();
		WebElement successmsg=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div[@class='alert alert-success alert-dismissible']")));
		String msg=successmsg.getText();
		System.out.println(msg);
		
		WebElement shoppinglink=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button//span[@id='cart-total']")));
		JavascriptExecutor js1=(JavascriptExecutor)wd;
		js1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(4000);
		shoppinglink.click();
		Thread.sleep(4000);
		WebElement view=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart")));
		view.click();
		WebElement waitcoupen=new WebDriverWait(wd,Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]//div//div[1]//h4//a[@href='#collapse-coupon']")));
		waitcoupen.click();
		WebElement waitentrcoupen=new WebDriverWait(wd,Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.name("coupon")));
		//waitentrcoupen.click();
		waitentrcoupen.sendKeys("ABCD123");
		applycoupenbtn.click();
		waitcoupen.click();
		WebElement waitwarn=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div//i[@class='fa fa-exclamation-circle']")));
		String warn=waitwarn.getText();
		System.out.println(warn);
		
		JavascriptExecutor js2=(JavascriptExecutor)wd;
		js2.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		giftcert.click();
		WebElement entrgiftcert=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.name("voucher")));
		//entrgiftcert.click();
		entrgiftcert.sendKeys("AXDFGH123");
		WebElement waitcertbutton=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]//div//div//span//input[@type='submit' and contains(@value,'Apply Gift Certificate')]")));
		waitcertbutton.click();
		
		WebElement waitcertwarn=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),' Warning: Gift Certificate is either invalid or the balance has been used up!')]")));
		waitcertwarn.getText();
		String certwarn=waitcertwarn.getText();
		System.out.println(certwarn);
		//waitentrcoupen.click();
		//waitentrcoupen.clear();
		//entrgiftcert.click();
		//entrgiftcert.clear();
		JavascriptExecutor js3=(JavascriptExecutor)wd;
		js3.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		chkoutlink.click();
		WebElement myacctlink=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div[2]//ul//li[2]//a[@title='My Account']")));
		myacctlink.isEnabled();
		myacctlink.click();
		registerlink.click();
		fname.sendKeys("abcd");
		lname.sendKeys("xyz");
		email.sendKeys("aa12@aaa.com");
		telephone.sendKeys("1111111");
		password.sendKeys("Abc#12345");
		confirm.sendKeys("Abc#12345");
		subscribe.click();
		chkbox.click();
		submitlink.click();
		actcreatedcont.click();
		
	}
	
		
       
		
		
		
		
		
		
}
