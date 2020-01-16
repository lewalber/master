package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Summary{
	
	WebDriver driver;

    By email = By.id("email_create");
    By createAccount = By.id("SubmitCreate");
    By qty_cart = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity");
    By proceed_button = By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]");
    		
  
    public Summary(WebDriver driver){

    	this.driver = driver;

    }

    //Set email
    public void setEmail(String strEmail){
        driver.findElement(email).sendKeys(strEmail);
    }

    //verify product added to cart
    public void verifyProductAdded(int qty) {

    int added = Integer.parseInt(driver.findElement(qty_cart).getText());	
    assertEquals(qty, added);
    
    }
    
    //Click on create account
    public void clickCreateAccount(){
            driver.findElement(createAccount).click();
     }
    
    //Click on Proceed
    public void clickProceed(){
            driver.findElement(proceed_button).click();
     }
    

}
