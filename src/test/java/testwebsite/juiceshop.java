//This assignment is with Page Factory Model with using TestNG framework. 
package testwebsite;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class juiceshop {
	@FindBy(xpath="//div//button[2][@id='onetrust-accept-btn-handler']") WebElement cookie;
	@FindBy(id="sprd-department-filter__department-D55") WebElement OProducts;
	@FindBy(id="subFilter-D55-P56")WebElement men;
	@FindBy(xpath="//img[@src='https://image.spreadshirtmedia.com/image-server/v1/products/T2077A1PA4341PT17X54Y58D1010828986W20833H25000PA4342PT17X71Y58D1010829110W20833H25000/views/1,width=500,height=500,appearanceId=1,backgroundColor=fff/juice-shop-ctf-logo-mens-tri-blend-organic-t-shirt.jpg']")WebElement WhiteT;
	@FindBy(id="sprd-appearance-list__appearance-231")WebElement graycolor;
    @FindBy(xpath="//button[@class='sprd-button sprd-btn-primary sprd-detail-cta__button sprd-detail-cta--idle']")WebElement addtocart;
	@FindBy(xpath="//button[@id='sprd-detail-sizes__size-3']")WebElement size;
	@FindBy(xpath="//div//a[@class='sprd-button customButton sprd-primary']")WebElement ShopCart;
	@FindBy(xpath="//div[@class='sprd-quantity-control sprd-bg-m3 sprd-lbc-s2']/..//button[2][@class='sprd-quantity-control__button']")WebElement plusButton;
	@FindBy(xpath="//div/button[@class='sprd-basket-checkout__button sprd-button sprd-btn-primary']")WebElement checkout;
	@FindBy(xpath="//div//input[@type='email']")WebElement email;
	@FindBy(xpath="//div//label[2][@name='shipping_salutation']")WebElement MsButton;
	@FindBy(xpath="//div//input[@id='shipping_firstName']")WebElement fname;
    @FindBy(xpath="//div//input[@id='shipping_lastName']")WebElement lname;
    @FindBy(xpath="//div//form//input[@id='field_8']")WebElement streetAddr;
    @FindBy(xpath="//div//form//input[@id='shipping_streetAnnex']")WebElement AdditionalAddr;
    @FindBy(xpath="//div//select[@id='shipping_country']")WebElement drpcountry;
    @FindBy(xpath="//div//input[@id=\"shipping_city2\"]")WebElement City;
    @FindBy(xpath="//div//input[@id=\"shipping_zipCode2\"]")WebElement zipcode;
    @FindBy(xpath="//div//input[@id=\"completeShipping\"]")WebElement contbutton;
    

    @Test
	public void testrun() {
    	ChromeOptions handlingSSL = new ChromeOptions();
    	handlingSSL.setAcceptInsecureCerts(true);
    	WebDriver wd=new ChromeDriver(handlingSSL);
    	String url= "https://juiceshop.myspreadshop.com/";
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\eclipse-workspace\\Hello-Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");	
    
	wd.manage().window().maximize();
	wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	wd.get(url);
	PageFactory.initElements(wd,this);
	cookie.click();
	cookie.click();
    OProducts.click();
    men.click();
    WebElement WhiteTWait=new WebDriverWait(wd,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='https://image.spreadshirtmedia.com/image-server/v1/products/T2077A1PA4341PT17X54Y58D1010828986W20833H25000PA4342PT17X71Y58D1010829110W20833H25000/views/1,width=500,height=500,appearanceId=1,backgroundColor=fff/juice-shop-ctf-logo-mens-tri-blend-organic-t-shirt.jpg']")));
    WhiteTWait.click();
    //WhiteT.click();
    graycolor.click();
    addtocart.click();
    size.click();
    ShopCart.click();
    plusButton.click();
    checkout.click();
    email.sendKeys("aaa@aaa.com");
    MsButton.click();
    fname.sendKeys("abcd");
    lname.sendKeys("jklm");
    streetAddr.sendKeys("1234aaa");
    AdditionalAddr.sendKeys("aaa bbb ccc");
    drpcountry.click();
    
    Select se=new Select(wd.findElement(By.xpath("//div//select[@id='shipping_country']")));
    	   se.selectByVisibleText("United States");
    		City.click();
    		
    City.sendKeys("Newyork");		
    		
    Select se1=new Select(wd.findElement(By.xpath("//div//select[@id=\"shipping_state\"]")));
           se1.selectByValue("DC");
    zipcode.sendKeys("12345");
    contbutton.click();  
    }
}
	
  


