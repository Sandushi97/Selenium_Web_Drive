package Assignment_03_New;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_Test {
	WebDriver driver=new ChromeDriver();
	String url="https://www.amazon.com/";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Amazon_Test amazon= new Amazon_Test();
		amazon.callBrowser();
		amazon.enterProduct("Men's Fashion", "shirts for men");
		amazon.printresult();
		amazon.nthproduct(3);
		
	}
	public void callBrowser() {
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void enterProduct(String category,String product) {
		WebElement c=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		c.sendKeys(category);
		
		WebElement p=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		p.sendKeys(product);
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	}
	public void printresult() {
		WebElement print=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div"));
		String text=print.getText();
		System.out.println(text);
		System.out.println("*****************************************");
	}
	public void nthproduct(int num) {
		num=num+1;
		WebElement nth=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div["+num+"]/div/div/div"));
		String k=nth.getText();
		
		System.out.println(k);
		System.out.println("*****************************************");
	}
	
	}
	


