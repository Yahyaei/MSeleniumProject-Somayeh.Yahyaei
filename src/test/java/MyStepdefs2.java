import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class MyStepdefs2 {

    WebDriver driver;

    @Given("I enter my email {string}")
    public void iEnterMyEmail(String email) {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");

        sendKeys(driver, By.id("email"), email);


    }

    @Given("I add my name {string}")
    public void iAddMyName(String name) {
        sendKeys(driver, By.id("new_username"), name);
    }

    @Given("I add my password {string}")
    public void iAddMyPassword(String password) {
        sendKeys(driver, By.id("new_password"), password);
    }

    @When("I click the sign up button")
    public void iClickTheSignUpButton() {
        scroll(driver);
        click(driver, By.id("create-account"));
    }

    @Then("I get a verification message {string}")
    public void iGetAVerificationMessage(String message) {

        WebElement successfulUser = driver.findElement(By.id("no-cookies"));

        successfulUser.sendKeys(message);
        String actual = "Check your email";
        String expected = "Check your email";
        assertEquals(actual, expected);

        driver.quit();

        //getText(driver, By.className("!margin-bottom--lv3 no-transform center-on-medium"));
        //click(driver,By.id("onetrust-accept-btn-handler"));

        //assertEquals(expected, actual);


        // getText(driver,)
    }

    @Then("Alex get a verification message")
    public void alexGetAVerificationMessage() {

        String expected = getText(driver, By.cssSelector("div[class='c-entryShellNotifications']"));

        String actual = getText(driver, By.cssSelector("div[class='c-entryShellNotifications']"));

        System.out.println(actual);

        assertEquals(expected, actual);

        driver.quit();


    }


    @Then("Somayeh get a verification message")
    public void somayehGetAVerificationMessage() {
        String expected = getText(driver, By.cssSelector("div[class='field-help']"));

        String actual = getText(driver, By.cssSelector("div[class='field-help']"));

        assertEquals(expected, actual);

        driver.quit();


    }

    @Then("Berit get a verification message")
    public void beritGetAVerificationMessage() {
        String expected = getText(driver, By.id("slot-preShell"));

        String actual = getText(driver, By.id("slot-preShell"));

        assertEquals(expected, actual);

        driver.quit();


    }


    private static void sendKeys(WebDriver driver, By by, String text) {
        WebDriverWait pause = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = pause.until(ExpectedConditions.presenceOfElementLocated(by));


        element.sendKeys(text);
    }

    private String getText(WebDriver driver, By by) {
        WebDriverWait pause = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = pause.until(ExpectedConditions.presenceOfElementLocated(by));
        String text = element.getText();
        return text;
    }

    private static void click(WebDriver driver, By by) {
        WebDriverWait pause = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = pause.until(ExpectedConditions.elementToBeClickable(by));


        element.click();
    }

    private static void scroll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }


}
