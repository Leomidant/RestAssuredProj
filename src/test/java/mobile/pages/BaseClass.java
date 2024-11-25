package mobile.pages;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.options.UiAutomator2Options;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    private static AndroidDriver driver;
    private static String apkPath = "D:\\QA\\SingularTask\\untitled\\src\\test\\resources\\apk\\reddit_install.apk";

    public static void setAppiumDriver() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setDeviceName("Pixel 9 Pro XL API 35");
        options.setAutomationName("uiautomator2");

        // App-specific capabilities
        options.setApp(apkPath);
        options.setAppPackage("com.reddit.frontpage");
        options.setAppActivity("com.reddit.launch.main.MainActivity");

        // Optional capabilities
        options.noReset();
        options.autoGrantPermissions();

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
            System.out.println("Appium Driver initialized successfully!");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Failed to initialize Appium Driver. Invalid URL.");
        }
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void resetApp() {
        if(driver != null){
            driver.removeApp("com.reddit.frontpage");
            driver.installApp(apkPath);
        }
    }

    public static void quitDriver() {
        if(driver != null){
            driver.quit();
        }
    }

    // Find a single element
    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // Find multiple elements
    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public static void clickOnElement(By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public static void assertElementContainsText(By locator, String expectedText){
        WebElement element = driver.findElement(locator);
        Assert.assertEquals(element.getText(),expectedText);
    }

    public static void fillElementWithText(By locator, String fillText){
        WebElement element = driver.findElement(locator);
        element.sendKeys(fillText);
    }

    public static void elementIsDisplayed(By locator){
        WebElement element = driver.findElement(locator);
        element.isDisplayed();
    }

    public static void elementIsSelected(By locator){
        WebElement element = driver.findElement(locator);
        element.isSelected();
    }

    // Swipe between two elements
    public static void swipeBetweenElements(WebElement firstElement, WebElement secondElement) {
        TouchAction<?> touchAction = new TouchAction<>(driver);

        // Define start and end points for the swipe
        Rectangle rectStart = firstElement.getRect();
        PointOption<?> pointOptionStart = PointOption.point(
                rectStart.x + rectStart.width / 2,
                rectStart.y + rectStart.height / 2
        );
        Rectangle rectEnd = secondElement.getRect();
        PointOption<?> pointOptionEnd = PointOption.point(
                rectEnd.x + rectEnd.width / 2,
                rectEnd.y + rectEnd.height / 2
        );
        // Perform the swipe gesture
        touchAction.press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
                .moveTo(pointOptionEnd)
                .release()
                .perform();
    }

    public static void clickInMiddle() {
        // Get the screen size
        Dimension screenSize = driver.manage().window().getSize();

        // Calculate the center of the screen
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;

        // Create a TouchAction and click on the center
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(centerX, centerY)).perform();
    }
}
