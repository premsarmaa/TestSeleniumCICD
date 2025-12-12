import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DownloadFile {

    private WebDriver driver;
    private File downloadDir;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Create a directory for downloads
        downloadDir = new File(System.getProperty("user.dir") + File.separator + "downloads");
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }

        // Setup Chrome options to auto-download files
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDir.getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("plugins.always_open_pdf_externally", true);
        options.setExperimentalOption("prefs", prefs);

        // Setup WebDriver
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait up to 30 seconds for elements and download
    }

    @Test
    public void testFileDownload() {
        // Navigate to a page with sample PDF files
        driver.get("https://filesamples.com/formats/pdf");

        // Find the download link for the first sample file on the page
        WebElement downloadLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt])[1]")));
        
        // Get the expected file name from the same row as the download link
        WebElement fileNameElement = downloadLink.findElement(By.xpath("./ancestor::tr/td[1]"));
        String fileName = fileNameElement.getText();

        // Click the download link to start the download
        downloadLink.click();

        // Define the expected downloaded file path
        File downloadedFile = new File(downloadDir, fileName);
        
        // Wait until the file exists in the directory and is not empty
        wait.until(d -> downloadedFile.exists() && downloadedFile.length() > 0);

        // Assert that the file was downloaded successfully
        assertTrue(downloadedFile.exists() && downloadedFile.length() > 0, "File '" + fileName + "' was not downloaded or is empty.");
    }
   
    @AfterClass(alwaysRun = true) // Ensure teardown runs even if the test fails
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        // Clean up the downloaded files and directory
        if (downloadDir.exists()) {
            File[] files = downloadDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (!file.delete()) {
                        System.err.println("Failed to delete " + file.getAbsolutePath());
                    }
                }
            }
            if (!downloadDir.delete()) {
                System.err.println("Failed to delete " + downloadDir.getAbsolutePath());
            }
        }
    }
}
