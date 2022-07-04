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

import static org.junit.Assert.assertTrue;

public class StepViewCredit {
    WebDriver driver;
    WebDriverWait wait;
    WebElement lineLogin, credit, title;

    @Given("^Open the chrome and launch website$")
    public void Open_the_chrome_and_launch_website() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        wait = new WebDriverWait(driver,10);
    }

    @When("^Login the website and click credit slip$")
    public void Login_the_website_and_click_credit_slip() throws Throwable {
        lineLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")));
        assertTrue(lineLogin.isDisplayed());
        lineLogin.click();
        driver.findElement(By.id("email")).sendKeys("yahya@mailinator.com");
        driver.findElement(By.name("passwd")).sendKeys("yahya00");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        credit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[3]/a")));
        assertTrue(credit.isDisplayed());
        credit.click();

    }

    @Then("^In credit slip page$")
    public void In_credit_slip_page() throws Throwable {
        title = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("info-title")));
        assertTrue(title.isDisplayed());

        Thread.sleep(3000);
        driver.quit();
    }
}
