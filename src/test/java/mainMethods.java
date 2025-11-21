import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mainMethods extends openURL {   

    private String googleSearch="//textarea[@class='gLFyf']";
    private String clickSearch="//input[@name='btnK']";
    JavascriptExecutor js=(JavascriptExecutor)driver;
    public mainMethods() {
        super();
    }

    public void clickElementJS(WebElement e) {
        js.executeScript("arguments[0].click();",e);
    }
    public void highlightElementJS(WebElement e) {
        js.executeScript("arguments[0].setAttribute('style','border: solid 5px green');",e);
    }
     public void unhighlightElementJS(WebElement e) {
        js.executeScript("arguments[0].setAttribute('style','');", e);    
    }

   public void screenshot(String fileName){

        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src, new File("./screenshot/"+fileName+System.currentTimeMillis()+".png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    
   }
    
}
