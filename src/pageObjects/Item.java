package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Item{
	
	WebDriver driver;

    By price = By.id("our_price_display");
    By addtocart_button = By.cssSelector("#add_to_cart > button");

  
    public Item(WebDriver driver){

    	this.driver = driver;

    }

    //Get price
    public String getPrice(){
    	
        return driver.findElement(price).getText();
    }


    //Click on add to cart
    public void clickAddToCart(){
    	
          driver.findElement(addtocart_button).click();
     }
    
    public static Item acessa (WebDriver driver) {
    	
    	return new Item(driver);
    }
}
