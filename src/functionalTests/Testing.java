package functionalTests;

import java.lang.Exception;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


import pageObjects.*;



class Testing {

	WebDriver driver;
	
    Item itemPage;
    PopupSummary popupPage;
    Summary summaryPage;
    SignUp signupPage;
    Address addressPage;
    Shipping shippingPage;
    Payment paymentPage;

	String strEmail = "leticia13@teste.com";
    String firstName = "leticia";
    String lastName = "walber";
    String address = "Street 1 n 1";
    String post = "88888";
    String city= "curitiba";
    String state = "Arizona";
    String country = "United States";
    String pwd = "123456";
    String mobile = "5541888888888";
    String bank = "BANK-WIRE PAYMENT.";
    
    
    
	@Test
	public void successful_purchase() throws Exception {


	//Initiate Browser	
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("http://www.automationpractice.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
    // CHOSE A PRODUCT
		js.executeScript("window.scrollBy(0,500)");
		WebElement product = driver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > h5 > a"));
		product.click();
		Thread.sleep(3000);
		
		// ADD TO CART    // ITEM PAGE
		itemPage = new Item(driver);
		String p = itemPage.getPrice();
		itemPage.clickAddToCart();
		Thread.sleep(3000);

	// PROCEED TO CHECKOUT 	// POPUP SUMMARY PAGE
		popupPage = new PopupSummary(driver);
		Thread.sleep(3000);
		String s = popupPage.getShippingPrice();
        popupPage.verifyTotalProducts(p);
        popupPage.clickCheckout();
		
	// VALIDATE IF PRODUCT WAS ADDED TO CART
		Thread.sleep(3000);
		summaryPage = new Summary(driver);
		summaryPage.verifyProductAdded(1);
		js.executeScript("window.scrollBy(0,500)");
		summaryPage.clickProceed();
		Thread.sleep(3000);
		summaryPage.setEmail(strEmail);
		summaryPage.clickCreateAccount();
		Thread.sleep(3000);
		
	// CREATE AN ACCOUNT - VALIDATE REQUIRED FIELDS - SIGNUP PAGE
		signupPage = new SignUp(driver);
		signupPage.setTitleMrs();
        signupPage.setFirstName(firstName);
        signupPage.setLastName(lastName);
        signupPage.setPassword(pwd);
        signupPage.setAddress(address);
        signupPage.setPost(post);
        signupPage.setCity(city);
        signupPage.setState(state);
        signupPage.setCountry(country);
        signupPage.setMobile(mobile);
        signupPage.clickSave();
		Thread.sleep(3000);
		
    // VERIFY ADDRESS
		addressPage = new Address(driver);
		Thread.sleep(3000);
        addressPage.verify_address_line1(address);
        addressPage.verify_address_line2(city, state, post);
        addressPage.verify_address_line3(country);
        addressPage.verify_address_line4(mobile);
        js.executeScript("window.scrollBy(0,500)");
        addressPage.clickProceed();
		Thread.sleep(3000);
        
	// ACCEPT TERMS
		shippingPage = new Shipping(driver);
		Thread.sleep(3000);
		shippingPage.checkAgree();
		Thread.sleep(3000);
		shippingPage.clickProceed();
		Thread.sleep(3000);
        
        
	// VALIDATE PURCHASE VALUE 
		paymentPage = new Payment(driver);
		Thread.sleep(3000);
		paymentPage.verify_total_prod(p);
		paymentPage.verify_total_shipping(s);
	    js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);		
		
	// SELECT PAYMENT TYPE AND CONFIRM
		paymentPage.clickPayByBank();
		Thread.sleep(3000);
		paymentPage.bank_confirmation(bank);
		paymentPage.clickConfirm();
		Thread.sleep(3000);
		
	// VALIDATE SUCCESSFUL  PURCHASE 
		Thread.sleep(3000);
		
		
		driver.close();
		
	}
	}
