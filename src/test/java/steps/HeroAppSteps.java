package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.HeroAppPage;
import utils.ActionsUtil;
import utils.AlertHandler;
import utils.Driver;

public class HeroAppSteps {

    WebDriver driver;
    HeroAppPage heroAppPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        heroAppPage = new HeroAppPage();
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String linkText) {
        heroAppPage.clickOnLink(linkText);
    }

    @Then("user should see {string} heading")
    public void userShouldSeeHeading(String headingText) {
        switch (headingText){
            case "Add/Remove Elements":
                Assert.assertTrue(heroAppPage.addRemoveHeading3.isDisplayed());
                Assert.assertEquals(headingText, heroAppPage.addRemoveHeading3.getText());
                break;
            case "Context Menu":
                Assert.assertTrue(heroAppPage.contextMenuHeading3.isDisplayed());
                Assert.assertEquals(headingText, heroAppPage.contextMenuHeading3.getText());
                break;
            default:
                throw new NotFoundException("The button name is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} button")
    public void userShouldSeeButton(String buttonText) {
        switch (buttonText){
            case "Add Element":
                Assert.assertTrue(heroAppPage.addElementButton.isDisplayed());
                Assert.assertEquals(buttonText, heroAppPage.addElementButton.getText());
                break;
            case "Delete":
                Assert.assertTrue(heroAppPage.deleteButton.isDisplayed());
                Assert.assertEquals(buttonText, heroAppPage.deleteButton.getText());
                break;
            default:
                throw new NotFoundException("The button name is not defined properly in the feature file!!!");
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonText) {
        switch (buttonText){
            case "Add Element":
                heroAppPage.addElementButton.click();
                break;
            case "Delete":
                heroAppPage.deleteButton.click();
                break;
            case "Login":
                heroAppPage.loginButton.click();
                break;
            default:
                throw new NotFoundException("The button name is not defined properly in the feature file!!!");
        }
    }

    @Then("user should not see {string} button")
    public void userShouldNotSeeButton(String buttonText) {
        switch (buttonText){
            case "Delete":
                try{
                    Assert.assertFalse(heroAppPage.deleteButton.isDisplayed());
                }
                catch (NoSuchElementException e){
                    //e.printStackTrace();
                    Assert.assertTrue(true);
                }
                break;
            default:
                throw new NotFoundException("The button name is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text){
            case "Context menu items are custom additions that appear in the right-click menu.":
                Assert.assertTrue(heroAppPage.contextMenuParagraph1.isDisplayed());
                Assert.assertEquals(text, heroAppPage.contextMenuParagraph1.getText());
                break;
            case "Right-click in the box below to see one called 'the-internet'. When you click it, it will trigger a JavaScript alert.":
                Assert.assertTrue(heroAppPage.contextMenuParagraph2.isDisplayed());
                Assert.assertEquals(text, heroAppPage.contextMenuParagraph2.getText());
                break;
            default:
                throw new NotFoundException("The text is not defined properly in the feature file!!!");
        }
    }

    @And("user should see a rectangle box to right click")
    public void userShouldSeeARectangleBoxToRightClick() {
        Assert.assertTrue(heroAppPage.rectangleBox.isDisplayed());
    }

    @When("user right clicks on rectangle box")
    public void userRightClicksOnRectangleBox() {
        ActionsUtil.rightClick(heroAppPage.rectangleBox);
    }

    @Then("user should see a popup displaying message {string}")
    public void userShouldSeeAPopupDisplayingMessage(String alertText) {
        Assert.assertEquals(alertText, AlertHandler.getAlertsText(driver));
        AlertHandler.dismissAlert(driver);
    }

    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {
        heroAppPage.usernameInputBox.sendKeys(username);
        heroAppPage.passwordInputBox.sendKeys(password);
    }

    @Then("user should see a message starts with {string}")
    public void user_should_see_a_message_starts_with(String errorMessage) {
        Assert.assertTrue(heroAppPage.loginErrorMessage.getText().startsWith(errorMessage));
    }

    @Then("user should see {string} big heading")
    public void userShouldSeeBigHeading(String arg0) {

    }
}
