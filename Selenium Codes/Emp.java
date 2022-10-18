import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Emp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost/employee/admin/index.php");
		driver.manage().window().maximize();
		
		
		//driver.findElement(By.xpath("//*[@id=\"login-frm\"]/div[1]/input")).sendKeys("admin");
		//driver.findElement(By.xpath("//*[@id=\"login-frm\"]/div[2]/input")).sendKeys("admin123");
		
		WebElement inputUsername=driver.findElement(By.name("username"));
		inputUsername.sendKeys("admin");
		
		WebElement inputPassword=driver.findElement(By.name("password"));
		inputPassword.sendKeys("admin123");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.findElement(By.xpath("//button[text()='Login ']")).click();
		//driver.findElement(By.xpath("//button[text()='Login ']")).submit();
		
		if(inputUsername.getAttribute("value").isEmpty()) {
			System.out.println("Username is Empty");
			
		}
		else if(inputPassword.getAttribute("value").isEmpty()){
			System.out.println("Password is Empty");
		}
		else {
			driver.findElement(By.xpath("//button[text()='Login ']")).click();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.findElement(By.xpath("//button[text()='Reset ']")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"Employee\"]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"table_filter\"]/label/input")).sendKeys("Mario");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("new_emp_btn")).click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"employee_frm\"]/div[1]/div[1]/input[2]")).sendKeys("Ravi");
		driver.findElement(By.name("middlename")).sendKeys("Kumar");
		driver.findElement(By.name("lastname")).sendKeys("Ramesh");
		driver.findElement(By.name("department")).sendKeys("HR");
		driver.findElement(By.name("position")).sendKeys("Staff");
		
		//Save the form
		driver.findElement(By.xpath("//*[@id=\"employee_frm\"]/div[2]/button")).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//*[@id=\"sidebar-field\"]/a")).click();
		
		
		//driver.findElement(By.xpath("//*[@id=\"manage_user\"]")).click();
		

	}

}
