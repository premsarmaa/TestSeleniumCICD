import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testCase extends mainMethods {

    

    @Test(dataProvider="getdata")
    public void sampleTest(String name,String classname,String roll) throws InterruptedException {

    screenshot("Google Title");
    String googleSearch="//textarea[@class='gLFyf']";
    String clickSearch="//input[@name='btnK']";
        // add assertions or interactions here
    
        //WebElement element=driver.findElement(By.xpath("null")); //webElement
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));//WebDriverWait
       // WebElement element2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("null"))); //WebElement from wait
        
        
        // FluentWait<WebDriver> fwait=new FluentWait<WebDriver>(driver)
        // .withTimeout(Duration.ofSeconds(10))
        // .pollingEvery(Duration.ofSeconds(10))
        // .ignoring(NoSuchElementException.class);

        WebElement googleSearchBox=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(googleSearch))); //WebElement from wait
        highlightElementJS(googleSearchBox);
        screenshot("Google box highlighted");
        googleSearchBox.sendKeys(name);
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//implicit wait
        Thread.sleep(5);
        unhighlightElementJS(googleSearchBox);
        org.testng.Assert.fail("Forcing failure to test screenshot listener");
        //alert
        // Alert alert=driver.switchTo().alert();
        // alert.dismiss();
        // alert.accept();
        // String alertText=alert.getText();

        //frame
        // WebElement iframeElement=driver.findElement(By.xpath("frameXpath"));
        // driver.switchTo().frame(iframeElement);
        // driver.switchTo().parentFrame();
        // driver.switchTo().defaultContent();
       
        // //window
        // String parentHandle=driver.getWindowHandle();
        // WebElement link=driver.findElement(By.xpath("linkXpath"));
        // link.click(); //will open new window

    //     //now get all handles
    //     Set<String> handles=driver.getWindowHandles();
    //     for(String handle :handles){
    //         if(!handle.equals(parentHandle))
    //         {
    //             driver.switchTo().window(handle);
    //             break;
    //         }
    //     }
    // //now whatever we write , will be handles in new window

    // System.out.println("New window title: "+ driver.getTitle());
    // //close the window
    // driver.close();

    // //return to parent window
    // driver.switchTo().window(parentHandle);
   
    }
    @AfterClass
    public void close(){
         driver.close();
    }


        @DataProvider
    public Object[][] getdata() {
        return new Object[][] {
            {"name", "classA", "101"},
            {"prem", "classB", "102"},
            {"job", "classC", "103"}
        };
}

    
}
