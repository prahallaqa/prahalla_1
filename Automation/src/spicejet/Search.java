package spicejet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Search {
	public static void main(String[] args) {
 
		WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.manage().window().maximize();
            driver.get("https://www.spicejet.com/");
 
            // -------- 1) FROM = Hyderabad, TO = Goa --------
            // Click FROM box
            WebElement fromBox = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("div[data-testid='to-testID-origin']")));
            fromBox.click();

            // Type Hyderabad and select suggestion
            WebElement fromInput = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("input[placeholder='From']")));
            fromInput.sendKeys("Hyderabad");
            WebElement fromOption = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[contains(@data-testid,'origin-city')]//div[contains(text(),'Hyderabad')]")));
            fromOption.click();
 
            // Click TO box
            WebElement toBox = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("div[data-testid='to-testID-destination']")));
            toBox.click();

            // Type Goa and select suggestion
            WebElement toInput = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("input[placeholder='To']")));
            toInput.sendKeys("Goa");
            WebElement toOption = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[contains(@data-testid,'destination-city')]//div[contains(text(),'Goa')]")));
            toOption.click();

            // -------- 2) Dates: tomorrow & day-after-tomorrow --------
            LocalDate today   = LocalDate.now();
            LocalDate depDate = today.plusDays(1);  // tomorrow
            LocalDate retDate = today.plusDays(2);  // day after tomorrow

            // Open departure calendar (if not already open)
            WebElement depField = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("div[data-testid='departure-date-dropdown-label']")));
            depField.click();

            // Calendar uses day-of-month in data-testid for current month view
            WebElement depDay = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@data-testid='undefined-calendar-day-" + depDate.getDayOfMonth() + "']")));
            depDay.click();

            WebElement retDay = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@data-testid='undefined-calendar-day-" + retDate.getDayOfMonth() + "']")));
            retDay.click();

            // -------- 3) Passengers = 2 Adults --------
            WebElement paxField = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("div[data-testid='home-page-travellers']")));
            paxField.click();

            WebElement adultPlus = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")));
            adultPlus.click();  // default is 1 adult; +1 => 2 adults

            WebElement paxDone = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//div[text()='Done']")));
            paxDone.click();

            // -------- 4) Click Search Flight --------
            WebElement searchBtn = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("div[data-testid='home-page-flight-cta']")));
            searchBtn.click();

            // Optionally wait for results page element to confirm navigation
            // wait.until(ExpectedConditions.visibilityOfElementLocated(
            //        By.xpath("//div[contains(text(),'Flights from')]")));

        } finally {
            // driver.quit(); // enable when you want to close the browser at the end
        }
 
		}
}
	