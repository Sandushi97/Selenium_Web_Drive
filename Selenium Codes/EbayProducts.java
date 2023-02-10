package Ebay_Products_New;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay {
	
	WebDriver driver=new ChromeDriver();
	String url="https://www.ebay.com/";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Ebay ebay=new Ebay();
		ebay.openBrowser();
		ebay.enterProduct("Apple Watches", "All Categories");
		ebay.search();
		ebay.printResultOfProduct();
		ebay.printnthproduct(3);
		ebay.printallfromfirstpage();
		ebay.scroll();
		
	}
	public void openBrowser() {
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void enterProduct(String product,String Category) {
		WebElement pro=driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
		pro.sendKeys(product);
		
		WebElement cate=driver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));
		cate.sendKeys(Category);
		
		
		
	}
	public void search() {
		WebElement save=driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
		save.click();
	}
	public void printResultOfProduct() {
		WebElement result=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1"));
		String kk=result.getText();
		System.out.println(kk);
		System.out.println("########################################################################");
		
	}
	public void printnthproduct(int number) {
		number=number+1;
		WebElement element=driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li["+number+"]"));
		String nthproduct=element.getText();
		System.out.println(nthproduct);
		System.out.println("########################################################################");
	}
	public void printallfromfirstpage() {
		//WebElement element=driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
		///String allp=element.getText();
		//System.out.println(allp);
		List <WebElement> li=driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
		for(WebElement x:li) {
			System.out.println(x.getText());
			System.out.println("*********************************************************");
			
		}
	}
	
	public void scroll() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//this is working 
		//WebElement uptoscroll=driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[61]"));
		//js.executeScript("arguments[0].scrollIntoView(true)", uptoscroll);
		List <WebElement> li=driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
		int count=1;
		for(WebElement x:li) {
			//System.out.println(x.getText());
			//System.out.println("*********************************************************");
			WebElement uptoscroll=driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li["+count+"]"));
			js.executeScript("arguments[0].scrollIntoView(true)", uptoscroll);
			//System.out.println("########################################################################");
			//System.out.println(x.getText());
			//System.out.println("*********************************************************");
			count++;
		}
	}
	

}
