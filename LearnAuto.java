package finding;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LearnAuto {

	public static void main(String[] args) throws InterruptedException  
	{
		
		LearnAuto dpi = new LearnAuto();
		//dpi.textbox();
		//dpi.button();
		//dpi.dropdown();
		//dpi.alert();
		//dpi.windows();
		//dpi.frame();
		//dpi.upload();
		//dpi.scroll();
		//dpi.checkbox();
		dpi.pagination();
	}
	public void textbox()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.findElement(By.id("email")).sendKeys("pdurgaprasad34@outlook.com");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("added shit");
		String text=driver.findElement(By.name("username")).getText();
		System.out.print(text);
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
		boolean d=driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		if(d)
		{
			System.out.print("is enabled");
		}
		else
		{
			System.out.print("is disabled");
		}
	}
	public void button()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Button.html");
		Point xypoint=driver.findElement(By.id("position")).getLocation();
		System.out.println("\tX:"+xypoint.getX());
		System.out.println("\tY:"+xypoint.getY());
		String s=driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println(s);
		WebElement decoy=driver.findElement(By.id("size"));
		System.out.println("Height :"+decoy.getSize().getHeight());
		System.out.println("Height :"+decoy.getSize().getWidth());
		driver.findElement(By.id("home")).click();
		
		
	}
	
	public void dropdown()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		WebElement firstdropdown = driver.findElement(By.id("dropdown1"));
		Select select=new Select(firstdropdown);
		select.selectByIndex(2);
		WebElement seconddropdown = driver.findElement(By.name("dropdown2"));
		Select select1=new Select(seconddropdown);
		select1.selectByVisibleText("Selenium");
		WebElement thirddropdown = driver.findElement(By.name("dropdown3"));
		Select select2=new Select(thirddropdown);
		select2.selectByValue("3");
		WebElement decoy =driver.findElement(By.className("dropdown"));
		int option=decoy.findElements(By.tagName("option")).size();
		System.out.println(option);
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[5]/select")).sendKeys(Keys.ENTER,Keys.ARROW_DOWN,Keys.ENTER);
		WebElement dpoint=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[6]/select"));
		Select select3=new Select(dpoint);
		select3.selectByIndex(2);
		select3.selectByIndex(3);
		
	}
	
	
	public void alert()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.findElement(By.tagName("button")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/button")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div/div/button")).click();
		driver.switchTo().alert().sendKeys("fuck you");
		driver.switchTo().alert().accept();
		
		
	}
	
	public void windows()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		WebElement firstbutton = driver.findElement(By.id("home"));
		firstbutton.click();
		String oldwindow = driver.getWindowHandle();
		Set<String> f=driver.getWindowHandles();
		Iterator<String> iter = f.iterator();
		if(iter.hasNext())
		{
			iter.next();
			driver.switchTo().window(iter.next());
		}
		driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight']")).click();
		driver.close();
		driver.switchTo().window(oldwindow);
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/button")).click();
		Set<String> dump =driver.getWindowHandles();
		System.out.println(dump.size());
		Iterator iter1= dump.iterator();
		while(iter1.hasNext())
		{
			String str= (String) iter1.next();
			if(oldwindow.equalsIgnoreCase(str))
			{
				System.out.print(str);
			}
			else
			{
				driver.switchTo().window(str);
				driver.close();
			}
		}
		driver.switchTo().window(oldwindow);
		driver.findElement(By.xpath("//button[@style='background-color:lightblue']")).click();
	}
	
	public void frame()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int temp=0;
		driver.get("http://www.leafground.com/pages/frame.html");
		int d=driver.findElements(By.tagName("iframe")).size();
		for(int i=0;i<d;i++)
		{
			driver.switchTo().frame(i);
			int fd = driver.findElements(By.xpath("//button[@id='Click']")).size();
			if(fd > 0)
			{
				System.out.println(i);
				driver.findElement(By.xpath("//button[@id='Click']")).click();
				break;
			}
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		int temp1=driver.findElements(By.tagName("iframe")).size();
		for(int i=0;i<temp1;i++)
		{
			driver.switchTo().frame(i);
			int rd =driver.findElements(By.xpath("//button[@id='Click1']")).size();
			if(rd > 0)
			{
				System.out.println(i);
				driver.findElement(By.xpath("//button[@id='Click1']")).click();
				break;
				
			}
		}
		System.out.println(d);
		
		
		
		
		
	}
	
	public void upload () throws AWTException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/upload/");
		WebElement d=driver.findElement(By.id("uploadfile_0"));
		d.click();
		String file="C:\\Users\\pdurg\\Downloads\\Selenium.txt";
		StringSelection selection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		Robot robot =new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
		public void scroll()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.theverge.com/");
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)");
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			driver.quit();
		}
		
		public void checkbox()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://www.leafground.com/pages/checkbox.html");
			ArrayList<WebElement> code = new ArrayList<WebElement>();
			code=(ArrayList<WebElement>) driver.findElements(By.xpath("//input[@type='checkbox']"));
			for(WebElement list:code)
			{
				if(list.isSelected())
				{
					
				}
				else
				{
					list.click();
				}
			}
		}
		
		
		public void pagination() throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,3000)");
			Thread.sleep(5000L);
			WebDriverWait wait=new WebDriverWait(driver,5);
			int d=driver.findElements(By.cssSelector("button.btn.btn-outline-primary.btn-sm.float-right")).size();
			
			if(d>0)
			{
				driver.findElement(By.cssSelector("button.btn.btn-outline-primary.btn-sm.float-right")).click();
			}
			
			List<WebElement> sd=driver.findElements(By.cssSelector("li.paginate_button.page-item"));
			for(int i=2;i<=6;i++)
			{
				WebElement tablerow=driver.findElement(By.xpath("//table[@id='dtBasicExample']//following::tbody"));
				List<WebElement> tr =tablerow.findElements(By.xpath("//td[@class='sorting_1']"));
				for(WebElement list:tr)
				{
					System.out.println(list.getText());
				}
				int ds=driver.findElements(By.xpath("//li[@class='paginate_button page-item next']")).size();
				System.out.println(ds);
				if(ds>0)
				{
					
					Thread.sleep(5000L);
					driver.findElement(By.xpath("//li[@class='paginate_button page-item next']")).click();
				}
			}
	

	
	}
}

	
