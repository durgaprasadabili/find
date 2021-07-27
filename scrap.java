import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findnemo 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.daraz.com.bd/consumer-electronics/?spm=a2a0e.pdp.breadcrumb.1.4d20110bzkC0bn");
		WebElement link=driver.findElement(By.xpath("//div[@class='c1_t2i']"));
		WebElement log=link.findElement(By.tagName("a"));
		List<WebElement> logtm=link.findElements(By.tagName("a"));
		ArrayList<String> url =new ArrayList<String>();
		for(WebElement sd:logtm)
		{
			url.add(sd.getAttribute("href"));
		}
		for(int i=0;i<10;i++)
		{
			driver.get(url.get(i));
			String name=driver.findElement(By.cssSelector("span.pdp-mod-product-badge-title")).getText();
			System.out.print(name);
			String price=driver.findElement(By.cssSelector("span.pdp-price.pdp-price_type_normal.pdp-price_color_orange.pdp-price_size_xl")).getText();
			System.out.print(price);
			System.out.println();
			
		}
	
		  
		
		
		
	}
}
