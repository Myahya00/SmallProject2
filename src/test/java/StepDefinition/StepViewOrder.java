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

public class StepViewOrder {
    WebDriver driver;
    WebDriverWait wait;
    WebElement lineLogin, order, title;

    @Given("^Open the chrome and launch for website$")
    public void Open_the_chrome_and_launch_for_website() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        wait = new WebDriverWait(driver,10);
    }

    @When("^Login the website$")
    public void Login_the_website() throws Throwable {
        lineLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")));
        assertTrue(lineLogin.isDisplayed());
        lineLogin.click();
        driver.findElement(By.id("email")).sendKeys("yahya@mailinator.com");
        driver.findElement(By.name("passwd")).sendKeys("yahya00");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        order = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_info_acc")));
        assertTrue(order.isDisplayed());
        order.click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/ul/li[2]/a")).click();

    }

    @Then("^In order page$")
    public void In_order_page() throws Throwable {
        title = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("center_column")));
        assertTrue(title.isDisplayed());

        Thread.sleep(3000);
        driver.quit();
    }
}
