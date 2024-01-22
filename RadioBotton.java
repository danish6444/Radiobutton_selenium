package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RadioBotton {

public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\Training Materials\\workspace\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.get("http://www.facebook.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@id,'u_0')]")).click();
        Thread.sleep(2000);
        //1stway
        Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@value='1']")).click();
	    Thread.sleep(2000); 
	    driver.findElement(By.xpath("//input[@value='2']")).click();
	    Thread.sleep(2000); 
	    driver.findElement(By.xpath("//input[@value='-1']")).click();
	    Thread.sleep(2000); 
	    
	    //2nd way
	    List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
	    System.out.println("total radio buttons : " + radios.size());
	    System.out.println(radios.get(0).isSelected());//false
	    System.out.println(radios.get(1).isEnabled());//true
	    System.out.println(radios.get(2).isDisplayed());//true
	    Thread.sleep(2000);
	    radios.get(1).click();
	    Thread.sleep(2000);
	    System.out.println(radios.get(2).isSelected());//false 
	    
	    //3rd way
	    List<WebElement> radios1 = driver.findElements(By.xpath("//label[@class='_58mt']"));
	    System.out.println("total Radio Button Text : " + radios.size());
	    String expResult = "Female";
	    for (int i = 0; i < radios1.size(); i++) {
	    	if (radios1.get(i).getText().equalsIgnoreCase(expResult)) {
	    		radios.get(i).click();
	    		System.out.println(expResult +" clicked");
	    		break;
	    	}
	    }
}}

