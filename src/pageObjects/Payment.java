package pageObjects;



import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payment {

	WebDriver driver;
	
    By total_products = By.id("total_product");
    By total_shipping = By.id("total_shipping");
    By pay_by_bank = By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p");
    By pay_by_check = By.cssSelector("#HOOK_PAYMENT > div:nth-child(2) > div > p");
    By bank_confirm = By.cssSelector("#center_column > form > div > h3");
    By amount = By.id("amount");
    By confirm_button = By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button");
    By order = By.cssSelector("#center_column > div");
    By amount_order = By.cssSelector("#center_column > div > span");  
    
    
    public Payment(WebDriver driver){

    	this.driver = driver;

    }

    //verify total products
    public void verify_total_prod(String prod){
    	
    	assertEquals(prod, driver.findElement(total_products).getText());
    	
    }
    	
    //verify total shipping
    public void verify_total_shipping(String shipping){
    	
    	assertEquals(shipping, driver.findElement(total_shipping).getText());
    	
    }
    
    //verify total
//    public void verify_total(String total){
    	
 //   	assertEquals(total, driver.findElement(total_shipping));
    	
 //   }
    	
    //Click Pay By Bank
    public void clickPayByBank() {
    	
    	driver.findElement(pay_by_bank).click();
    }
    
    //Click Pay By Check
    public void clickPayByCheck() {
    	
    	driver.findElement(pay_by_check).click();
    }
    	
   
    //verify bank confirmation 
    public void bank_confirmation(String bank){
    	
     	assertEquals(bank, driver.findElement(bank_confirm).getText());
    	
    }
    
    //verify amount
    public void amount_confirmation(String amt){
    	
     	assertEquals(amt, driver.findElement(amount));
    	
    }
    	
    
    //Click Confirm Button
    public void clickConfirm() {
    	
    	driver.findElement(confirm_button).click();
    }
    
    //verify amount in order confirmation
    public void amount_order(String amt_order){
    	
     	assertEquals(amt_order, driver.findElement(amount_order));
    	
    }
    	
}
