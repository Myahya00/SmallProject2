package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepSearch {
    WebDriver driver;
    WebDriverWait wait;
    WebElement searchLoc, title, value1, value2, value3, value4;

    @Given("^Open the chrome and launch the Website$")
    public void Open_the_chrome_and_launch_the_Website() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        wait = new WebDriverWait(driver,10);

    }

    @When("^Enter location select hotel entering check in date check out date")
    public void Enter_location_select_hotel_entering_check_in_date_check_out_date() throws Throwable {
        searchLoc = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hotel_location")));
        assertTrue(searchLoc.isDisplayed());
        searchLoc.sendKeys("Indonesia");
        value1 = wait.until(ExpectedConditions.elementToBeClickable(By.className("location_search_results_ul")));
        assertTrue(value1.isDisplayed());
        value1.click();

        driver.findElement(By.id("id_hotel_button")).click();
        value2 = wait.until(ExpectedConditions.elementToBeClickable(By.className("search_result_li")));
        assertTrue(value2.isDisplayed());
        value2.click();

        driver.findElement(By.id("check_in_time")).click();
        value3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]")));
        assertTrue(value3.isDisplayed());
        value3.click();

        driver.findElement(By.id("check_out_time")).click();
        value4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[3]/a")));
        assertTrue(value4.isDisplayed());
        value4.click();

        driver.findElement(By.id("search_room_submit")).click();

    }

    @Then("^View searching$")
    public void View_searching() throws Throwable {

        title = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("filter_results")));
        assertTrue(title.isDisplayed());

        Thread.sleep(3000);
        driver.quit();
    }
}
