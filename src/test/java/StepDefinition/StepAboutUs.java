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

public class StepAboutUs {
    WebDriver driver;
    WebDriverWait wait;
    WebElement boxR, title;

    @Given("^Open the chrome and goto about us website$")
    public void Open_the_chrome_and_goto_about_us_website() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        wait = new WebDriverWait(driver,10);
    }

    @When("^Click box and click about us$")
    public void Click_box_and_click_about_us() throws Throwable {
        boxR = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[2]/button")));
        assertTrue(boxR.isDisplayed());
        boxR.click();
        driver.findElement(By.xpath("//*[@id=\"menu_cont\"]/div/div/div[2]/ul[1]/li[7]/a")).click();


    }

    @Then("^In about us page$")
    public void In_about_us_page() throws Throwable {

        title = wait.until(ExpectedConditions.elementToBeClickable(By.id("center_column")));
        assertEquals("About us", "About us");

        Thread.sleep(3000);
        driver.quit();
    }
}
