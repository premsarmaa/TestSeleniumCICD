import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase2 extends mainMethods {
    @Test(priority=1,groups={"Smoke","Regression"},dataProvider="getdata")
    public void TC02(String name, String grade){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); 
        WebElement search=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("grade")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        FluentWait<WebDriver> fwait=new FluentWait<WebDriver>(driver).
        withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10)).
        ignoring(NoSuchElementException.class);

        WebElement iframeElement=driver.findElement(By.xpath(grade));
        driver.switchTo().frame(iframeElement);
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        String parentHandle= driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();
        for(String h:handles){
            if(!h.equals(parentHandle)){
                driver.switchTo().window(h);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(parentHandle);
    }

    public Object[][] getData(){
        return new Object[][]{
        {"sharam","prem"},
        {"11th","12th"}
    };
}

}
