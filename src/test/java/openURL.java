import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openURL {
    
    protected WebDriver driver;

    public openURL() { //add methods to set Chromdriver and Open the url in the constructor
        System.setProperty("webdriver.chrome.driver", 
            "C:\\Users\\prems\\Downloads\\VM-Java-Health-App_Patient-Automation-PL1-Selenium_Excel-Solution\\VM-Java-Health-App_Patient-Automation-PL1-Selenium_Excel-Solution\\driver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

   

}
