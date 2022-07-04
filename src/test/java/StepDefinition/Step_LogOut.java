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

public class Step_LogOut {
    WebDriver driver;
    WebDriverWait wait;
    WebElement lineLogin, logOut, title;

    @Given("^Open the chrome and launch the webapp$")
    public void Open_the_chrome_and_launch_the_webapp() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        wait = new WebDriverWait(driver,10);
    }

    @When("^Login for a website click logout$")
    public void Login_for_a_website_click_logout() throws Throwable {
        lineLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")));
        assertTrue(lineLogin.isDisplayed());
        lineLogin.click();
        driver.findElement(By.id("email")).sendKeys("yahya@mailinator.com");
        driver.findElement(By.name("passwd")).sendKeys("yahya00");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        logOut = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_info_acc")));
        assertTrue(logOut.isDisplayed());
        logOut.click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/ul/li[3]/a")).click();

    }

    @Then("^Logout this account$")
    public void Logout_this_account() throws Throwable {
        title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")));
        assertTrue(title.isDisplayed());

        Thread.sleep(3000);
        driver.quit();
    }
}
