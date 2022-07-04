package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class StepSignUp {
    WebDriver driver;
    WebDriverWait wait;
    WebElement lineSignIn, title, account;

    @Given("^Open the chrome and goto application$")
    public void Open_the_chrome_and_goto_application() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        wait = new WebDriverWait(driver,10);
    }

    @When("^Entering personal information")
    public void Entering_personal_information() throws Throwable {
        lineSignIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")));
        assertTrue(lineSignIn.isDisplayed());
        lineSignIn.click();
        driver.findElement(By.id("email_create")).sendKeys("kanasih@mailinator.com");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();

        title = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
        assertTrue(title.isDisplayed());
        title.click();
        driver.findElement(By.id("customer_firstname")).sendKeys("kana");
        driver.findElement(By.id("customer_lastname")).sendKeys("sih");
        driver.findElement(By.id("email")).getAttribute("kanasih@mailinator.com");
        driver.findElement(By.id("passwd")).sendKeys("kana21");
        Select selectDay = new Select(driver.findElement(By.id("days")));
        selectDay.selectByIndex(20);
        Select selectMonth = new Select(driver.findElement(By.id("months")));
        selectMonth.selectByIndex(8);
        Select selectYear = new Select(driver.findElement(By.id("years")));
        selectYear.selectByValue("2000");
        driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[7]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();



    }

    @Then("^Go to the Website$")
    public void Go_to_the_Website() throws Throwable {

        account = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='user_info_acc']/span")));
        assertTrue(account.isDisplayed());

        Thread.sleep(3000);
        driver.quit();
    }
}
