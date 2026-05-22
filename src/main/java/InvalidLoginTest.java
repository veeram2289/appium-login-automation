import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;

import java.net.URL;
import java.time.Duration;

public class InvalidLoginTest {

    public static void main(String[] args) {

        AndroidDriver driver = null;

        try {

            System.out.println("Invalid login test started");

            UiAutomator2Options options = new UiAutomator2Options();

            options.setDeviceName("Android");
            options.setUdid("R8DY8PKZQKKRIBU8");

            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");

            options.setAppPackage("com.mealmanage");
            options.setAppActivity("com.mealmanage.MainActivity");

            options.setNoReset(true);

            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Thread.sleep(5000);

            // Email field

            WebElement emailField = driver.findElement(
                    AppiumBy.xpath("//android.widget.EditText[@text='Email ID']"));

            emailField.click();
            emailField.sendKeys("wrong@gmail.com");

            // Password field

            WebElement passwordField = driver.findElement(
                    AppiumBy.xpath("//android.widget.EditText[@text='Password']"));

            passwordField.click();
            passwordField.sendKeys("wrongpassword");

            // Hide keyboard

            driver.hideKeyboard();

            Thread.sleep(2000);

            // Login button

            WebElement loginButton = driver.findElement(
                    AppiumBy.xpath("//android.widget.TextView[@text='LOGIN']"));

            loginButton.click();

            System.out.println("Login button clicked");

            Thread.sleep(3000);

            // Validation

            boolean stillOnLoginPage = driver.getPageSource().contains("LOGIN");

            if (stillOnLoginPage) {

                System.out.println("INVALID LOGIN TEST PASSED");

            } else {

                System.out.println("INVALID LOGIN TEST FAILED");
            }

        } catch (Exception e) {

            System.out.println("Test failed");
            System.out.println(e.getMessage());

        } finally {

            if (driver != null) {
                driver.quit();
            }
        }
    }
}