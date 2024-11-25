package mobile.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import mobile.pages.BaseClass;
import mobile.pages.HomePage;
import mobile.pages.LoginPage;
import mobile.pages.WelcomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MobileDefinitions {
    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("the user is on welcome page")
    public void theUserIsOnWelcomePageOfRedditApp() {
        welcomePage.validatePageTitle();
    }

    @And("the user clicks on use email or username button")
    public void theUserClicksOnUseEmailOrUsernameButton() {
        welcomePage.clickOnLoginWithEmailButton();
    }

    @And("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("the user is on login page")
    public void theUserIsOnLoginPage() {
        loginPage.validatePageName();
    }

    @And("the user clicks on continue button")
    public void theUserClicksOnContinueButton() {
        loginPage.clickOnContinueButton();
    }

    @And("the user sees notification permission pop up")
    public void theUserSeesNotificationPermissionPopUp() {
        homePage.validateNotificationPopUpIsDisplayed();
    }

    @And("the user denies notification permission")
    public void theUserDeniesNotificationPermission() {
        homePage.clickOnDenySendNotificationPermission();
    }

    @Then("the user sees all page buttons")
    public void theUserSeesAllPageButtons() {
        homePage.validateHomePageButtonIsDisplayed();
        homePage.validateCommunitiesPageButtonIsDisplayed();
        homePage.validateCreatePageButtonIsDisplayed();
        homePage.validateInboxPageButtonIsDisplayed();
        homePage.validateChatPageButtonIsDisplayed();
    }

    @And("the user sees that home page button is selected")
    public void theUserSeesThatHomePageButtonIsSelected() {
        homePage.homePageButtonIsSelected();
    }

    @And("the user clicks on community page button")
    public void theUserClicksOnCommunityPageButton() {
        homePage.clickOnCommunitiesPageButton();
    }

    @And("the user sees that community page button is selected")
    public void theUserSeesThatCommunityPageButtonIsSelected() {
        homePage.communitiesPageButtonIsSelected();
    }

    @And("the user sees community page title")
    public void theUserSeesCommunityPageTitle() {
        homePage.validateCommunitiesPageTitleIsDisplayed();
    }

    @And("the user clicks on chat page button")
    public void theUserClicksOnChatPageButton() {
        homePage.clickOnChatPageButton();
    }

    @And("the user sees that chat page button is selected")
    public void theUserSeesThatChatPageButtonIsSelected() {
        homePage.chatPageButtonIsSelected();
    }

    @And("the user sees chat page title")
    public void theUserSeesChatPageTitle() {
        homePage.validateChatPageTitleIsDisplayed();
    }

    @And("the user clicks on inbox page button")
    public void theUserClicksOnInboxPageButton() {
        homePage.clickOnInboxPageButton();
    }

    @And("the user sees that inbox page button is selected")
    public void theUserSeesThatInboxPageButtonIsSelected() {
        homePage.inboxPageButtonIsSelected();
    }

    @And("the user sees inbox page title")
    public void theUserSeesInboxPageTitle() {
        homePage.validateInboxPageTitleIsDisplayed();
    }
}
