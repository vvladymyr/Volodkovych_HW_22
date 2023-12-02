package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EmailTestSteps {
    private WebDriver driver = WebDriverManager.getDriver();

    @Given("the user is on the authentication page")
    public void givenTheUserIsOnTheAuthenticationPage() {
        driver.navigate().to("http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account#account-creation");
    }

    @When("the user enters the email {string} for account creation")
    public void whenTheUserEntersTheEmailForAccountCreation(String email) throws InterruptedException {
        WebElement emailCreate = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        emailCreate.sendKeys(email);
        WebElement buttonSubmitCreate = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        buttonSubmitCreate.click();
        Thread.sleep(3000);
    }

    @Then("the user sees the text {string}")
    public void thenTheUserSeesTheText(String expectedText) {
        WebElement createAccountText = driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1"));
        Assert.assertEquals(createAccountText.getText(), "CREATE AN ACCOUNT");
    }
}