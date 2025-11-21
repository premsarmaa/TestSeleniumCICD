import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

    @Test
    public void testGoogleSearch() throws InterruptedException {
//         System.setProperty("webdriver.chrome.driver", 
//     "C:\\Users\\prems\\Downloads\\VM-Java-Health-App_Patient-Automation-PL1-Selenium_Excel-Solution\\VM-Java-Health-App_Patient-Automation-PL1-Selenium_Excel-Solution\\driver\\chromedriver.exe");

// WebDriver driver = new ChromeDriver();

//         try {
//             driver.get("https://www.google.com");

//             // Accept cookies if prompted
//             try {
//                 WebElement acceptButton = driver.findElement(By.xpath("//div[text()='Accept all']"));
//                 acceptButton.click();
//             } catch (Exception ignored) {}

//             WebElement searchBox = driver.findElement(By.name("q"));
//             if(searchBox.isDisplayed()){
//                 System.out.println("Searchbox present");
//             }
//             searchBox.sendKeys("Selenium WebDriver");
//             // searchBox.submit();
//             WebElement submit=driver.findElement(By.xpath("/html/body/div[2]/div[4]/form/div[1]/div[1]/div[3]/center/input[1]"));
//             ((JavascriptExecutor)driver).executeScript("arguments[0].click();",submit);
            
//             Thread.sleep(3000);
//             System.out.println("Page title is: " + driver.getTitle());

//         } finally {
//             driver.quit();
//         }
    }
}