package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.GoogleSearchPage;
import utils.Driver;

public class GoogleSteps {

    WebDriver driver;
    GoogleSearchPage googleSearchPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        googleSearchPage = new GoogleSearchPage();
    }

    //We will be writing out actual script steps here
    @When("user searches for {string} on Google")
    public void user_searches_for_on_google(String key) {
        //driver.findElement(By.name("q")).sendKeys(key + Keys.ENTER);
        googleSearchPage.searchInputBox.sendKeys(key + Keys.ENTER);
    }

    @Then("user should see results are more than {long}")
    public void userShouldSeeResultsAreMoreThan(long result) {
        String resultsText = googleSearchPage.resultBar.getText();
        Assert.assertTrue(Long.parseLong(resultsText.substring(0, resultsText.indexOf("results")).replaceAll("[\\D]", "")) > 0);
    }
}
