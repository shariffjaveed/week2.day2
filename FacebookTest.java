package week2.day2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTest 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Javeed");
		driver.findElement(By.name("lastname")).sendKeys("Shariff");
		driver.findElement(By.name("reg_email__")).sendKeys("9123587469");
		driver.findElement(By.id("password_step_input")).sendKeys("javeed@2911");
		
		WebElement dob1 = driver.findElement(By.id("day"));
		Select day = new Select(dob1);
		day.selectByValue("29");
		
		WebElement dob2 = driver.findElement(By.id("month"));
		Select month = new Select(dob2);
		month.selectByValue("11");
		
		WebElement dob3 = driver.findElement(By.id("year"));
		Select year = new Select(dob3);
		year.selectByValue("1999");
		

		driver.findElement(By.xpath("//label[text()='Male']/following::input")).click();
		
		

}
}
