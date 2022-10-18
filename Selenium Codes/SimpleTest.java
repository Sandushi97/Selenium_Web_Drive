import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("file:///D:/3rd%20year/2nd%20Semester/practical%20SQA/registration.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("fn1")).sendKeys("Ravi");
		driver.findElement(By.id("fn2")).sendKeys("Kanth");
		driver.findElement(By.name("pass1")).sendKeys("admin1234");
		driver.findElement(By.name("pass2")).sendKeys("admin1234");
		
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.name("mobile")).sendKeys("0774145512");
		driver.findElement(By.id("description")).sendKeys("Welcome To Selenium testing!");
		
		driver.findElement(By.id("male")).click();
		
		driver.findElement(By.className("automation1")).click();
		driver.findElement(By.className("automation3")).click();
		
		driver.findElement(By.name("country")).sendKeys("Sri Lanka");
		

	}

}
