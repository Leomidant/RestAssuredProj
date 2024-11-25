package mobile.pages;

import org.openqa.selenium.By;

public class HomePage extends BaseClass{
    By notificationPopUp = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.android.permissioncontroller:id/grant_singleton\"]");
    By notificationDenyButton = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]");
    By homePageButton = By.xpath("//android.widget.TextView[@text=\"Home\"]");
    By communitiesPageButton = By.xpath("//android.widget.TextView[@text=\"Communities\"]");
    By communitiesPageTitle = By.xpath("//android.view.ViewGroup[@resource-id=\"com.reddit.frontpage:id/toolbar_feed_control\"]//android.widget.TextView[@text=\"Communities\"]");
    By chatPageButton = By.xpath("//android.widget.TextView[@text=\"Chat\"]");
    By chatPageTitle = By.xpath("//android.widget.TextView[@resource-id=\"com.reddit.frontpage:id/toolbar_title\"]");
    By inboxPageButton = By.xpath("//android.widget.TextView[@text=\"Inbox\"]");
    By inboxPageTitle = By.xpath("//android.widget.TextView[@resource-id=\"com.reddit.frontpage:id/toolbar_title\"]");
    By createPageButton = By.xpath("//android.widget.TextView[@text=\"Create\"]");

    public void validateNotificationPopUpIsDisplayed(){
        elementIsDisplayed(notificationPopUp);
    }

    public void clickOnDenySendNotificationPermission(){
        clickOnElement(notificationDenyButton);
    }

    public void homePageButtonIsSelected(){
        elementIsSelected(homePageButton);
    }

    public void communitiesPageButtonIsSelected(){
        elementIsSelected(communitiesPageButton);
    }

    public void inboxPageButtonIsSelected(){
        elementIsSelected(inboxPageButton);
    }

    public void chatPageButtonIsSelected(){
        elementIsSelected(chatPageButton);
    }

    public void validateCommunitiesPageTitleIsDisplayed(){
        elementIsDisplayed(communitiesPageTitle);
    }

    public void validateChatPageTitleIsDisplayed(){
        elementIsDisplayed(chatPageTitle);
        assertElementContainsText(chatPageTitle, "Chats");
    }

    public void validateInboxPageTitleIsDisplayed(){
        elementIsDisplayed(inboxPageTitle);
        assertElementContainsText(inboxPageTitle, "Inbox");
    }

    public void clickOnCommunitiesPageButton(){
        clickOnElement(communitiesPageButton);
    }

    public void clickOnChatPageButton(){
        clickOnElement(chatPageButton);
    }

    public void clickOnInboxPageButton(){
        clickOnElement(inboxPageButton);
    }

    public void validateHomePageButtonIsDisplayed(){
        elementIsDisplayed(homePageButton);
    }
    public void validateCommunitiesPageButtonIsDisplayed(){
        elementIsDisplayed(communitiesPageButton);
    }

    public void validateChatPageButtonIsDisplayed(){
        elementIsDisplayed(chatPageButton);
    }

    public void validateInboxPageButtonIsDisplayed(){
        clickInMiddle();
        elementIsDisplayed(inboxPageButton);
    }

    public void validateCreatePageButtonIsDisplayed(){

        elementIsDisplayed(createPageButton);
    }

}
