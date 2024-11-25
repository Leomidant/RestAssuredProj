package mobile.pages;

import org.openqa.selenium.By;

public class WelcomePage extends BaseClass{
    By welcomePageTitle = By.xpath("//android.widget.TextView[@resource-id=\"onboarding_title\"]");
    By logInWithEmailButton = By.xpath("//android.view.View[@resource-id=\"continue_with_email\"]");
    By logInWithGoogleButton = By.xpath("//android.widget.Button[@content-desc=\"Continue with Google\"]");

    public void validatePageTitle(){
        assertElementContainsText(welcomePageTitle, "Log in to Reddit");
    }

    public void clickOnLoginWithEmailButton(){
        clickOnElement(logInWithEmailButton);
    }

    public void clickOnWithGoogleButton(){
        clickOnElement(logInWithGoogleButton);
    }
}
