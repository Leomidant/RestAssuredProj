package mobile.pages;

import org.openqa.selenium.By;

public class LoginPage extends BaseClass{
    By loginPageTitle = By.xpath("//android.widget.TextView[@resource-id=\"login_title\"]");
    By usernameField = By.xpath("//*[@resource-id=\"email_username_text_field\"]//*[@resource-id=\"text_auto_fill\"]");
    By passwordField = By.xpath("//*[@resource-id=\"password_text_field\"]//*[@resource-id=\"text_auto_fill\"]");
    By continueButton = By.xpath("//android.view.View[@resource-id=\"continue_button\"]");

    public void validatePageName(){
        assertElementContainsText(loginPageTitle, "Enter your login information");
    }

    public void enterUsername(String username){
        fillElementWithText(usernameField, username);
    }

    public void enterPassword(String password){
        fillElementWithText(passwordField, password);
    }

    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
}
