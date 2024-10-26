/*
package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Enuygun {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.enuygun.com/");
		
		// To close DRIVER
		driver.quit();  // closes all windows
		driver.close();  //closes only specified URL window
		
	    WebElement girisyap = driver.findElement(By.className("sc-bdOgaJ etwZRe"));
		girisyap.click();
		
		
		// Giris Yapma
		/*
		WebElement mail = driver.findElement(By.id("_0.eez613rwqqn"));
		mail.sendKeys("marcelineozd@gmail.com");
		
		WebElement sifre = driver.findElement(By.className("_0.2d3awnflt21"));
		sifre.sendKeys("xxx");
		
		WebElement buton = driver.findElement(By.className("sc-dcJsrY bszgPd"));
		buton.click();
		
		driver.close();
		*/
	
		/*
		WebElement gorseller = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[2]/a"));
		String actualResult = gorseller.getText(); // GET TEXT 

		System.out.print(actualResult);
		String expectedResult = "Görseller";

		//Assert.assertEquals(expectedResult, actualResult);
		Thread.sleep(2000);
		
		WebElement search = driver.findElement(By.id("APjFqb"));
	  search.sendKeys("ARAMA");
	  
	  WebElement buton = driver.findElement(By.className("gNO89b"));
	  buton.click();
	  
	  Thread.sleep(2000);
	  driver.close();
		
	}
	
}
*/
