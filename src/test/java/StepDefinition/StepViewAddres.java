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

public class StepViewAddres {
    WebDriver driver;
    WebDriverWait wait;
    WebElement lineLogin, addres, title;

    @Given("^Open the chrome and launch to website$")
    public void Open_the_chrome_and_launch_to_website() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        wait = new WebDriverWait(driver,10);
    }

    @When("^Login to website and click MyAddres$")
    public void Login_to_website_and_click_MyAddres() throws Throwable {
        lineLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")));
        assertTrue(lineLogin.isDisplayed());
        lineLogin.click();
        driver.findElement(By.id("email")).sendKeys("yahya@mailinator.com");
        driver.findElement(By.name("passwd")).sendKeys("yahya00");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        addres = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[4]/a")));
        assertTrue(addres.isDisplayed());
        addres.click();


    }

    @Then("^In the MyAddres page$")
    public void In_the_MyAddres_page() throws Throwable {
        title = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("center_column")));
        assertEquals("My addresses", "My addresses");

        Thread.sleep(3000);
        driver.quit();
    }
}
