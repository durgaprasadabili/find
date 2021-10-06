package finding;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Page 
{

	public static void main(String[] args) throws InterruptedException 
    {
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pdurg\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,4000)");
        Thread.sleep(5000L);
        int d=driver.findElements(By.cssSelector("button.btn.btn-outline-primary.btn-sm.float-right")).size();

        if(d>0)
        {
            driver.findElement(By.cssSelector("button.btn.btn-outline-primary.btn-sm.float-right")).click();
        }
//Click
        

        for(int i=2;i<=7;i++)
        {
               
              
                    
            
            WebElement tablerow=driver.findElement(By.xpath("//table[@id='dtBasicExample']//following::tbody"));
            List<WebElement> tr =tablerow.findElements(By.xpath("//td[@class='sorting_1']"));
            for(WebElement list:tr)
            {
                System.out.println(list.getText());
               
              
                  
            }
          
            
           
            WebElement next= driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
            JavascriptExecutor e= (JavascriptExecutor)driver;
            e.executeScript("arguments[0].click()", next);
            System.out.println('\n');
           
            
        }


}
}