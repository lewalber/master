package pageObjects;



import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Address {

	WebDriver driver;
	
    By line_1 = By.cssSelector("#address_delivery > li.address_address1.address_address2");
    By line_2 = By.cssSelector("#address_delivery > li.address_city.address_state_name.address_postcode");
    By line_3 = By.cssSelector("#address_delivery > li.address_country_name");
    By line_4 = By.cssSelector("#address_delivery > li.address_phone_mobile");
    By proceed = By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button");
	
    public Address(WebDriver driver){

    	this.driver = driver;

    }

    //verify address line 1
    public void verify_address_line1(String line1){
    	
    	assertEquals(line1, driver.findElement(line_1).getText());
    	
    }

    //verify address line 2
    public void verify_address_line2(String city, String state, String post){
    	String line = city + "," + " " + state + " " + post;
    	assertEquals(line, driver.findElement(line_2).getText());
    	
    }
    
    //verify address line 3
    public void verify_address_line3(String line3){
    	
    	assertEquals(line3, driver.findElement(line_3).getText());
    	
    }
 	
    //verify address line 4
    public void verify_address_line4(String line4){
    	
    	assertEquals(line4, driver.findElement(line_4).getText());
    	
    }

    //Click on Proceed Button
    public void clickProceed() {
    	
    	driver.findElement(proceed).click();
    }
    	
    	
    	
    	
    	
    	
}
