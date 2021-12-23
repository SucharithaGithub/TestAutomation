
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestPartialText {

	@Test
	public void LinkText() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\ECLIPSE\\Browser Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		driver.findElement(By.linkText("Gmail")).click();

		mousetoclick(driver);
	}

	public void mousetoclick(WebDriver d) {

		Actions action = new Actions(d);
		WebElement elementtoClick = d.findElement(By.linkText("Sign in"));
		action.click(elementtoClick).build().perform();
		
		WebElement emailElement = d.findElement(By.id("identifierId"));
		Scanner email = new Scanner(System.in);
		System.out.println("Enter email: ");
		String emailId = email.nextLine();
		action.sendKeys(emailId).build().perform();
				
		WebElement nextElement = d.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")); 
		nextElement.sendKeys(Keys.ENTER);
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement pwdElement = d.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));//*[@id="password"]/div[1]/div/div[1]/input
		Scanner pwd = new Scanner(System.in);
		System.out.println("Enter password: ");
		String pwdId = pwd.nextLine();
		action.sendKeys(pwdId).build().perform();
		pwd.close();
		
		
		
		WebElement nextElementPwd = d.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button1")); //*[@id="passwordNext"]/div/button
		nextElementPwd.sendKeys(Keys.ENTER);
		
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	
}