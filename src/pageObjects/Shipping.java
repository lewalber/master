package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Shipping{
	
	WebDriver driver;

    By termsAgree = By.id("cgv");
    By proceedButton = By.cssSelector("#form > p > button");

  
    public Shipping(WebDriver driver){

    	this.driver = driver;

    }

    //Check Agree
    public void checkAgree(){
        driver.findElement(termsAgree).click();
    }


    //Click on proceed button
    public void clickProceed(){
            driver.findElement(proceedButton).click();
     }

}
