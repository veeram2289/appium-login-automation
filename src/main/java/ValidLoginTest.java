import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.WebElement;

import java.net.URL;
import java.time.Duration;

public class ValidLoginTest {

    public static void main(String[] args) {

        AndroidDriver driver = null;

        try {

            System.out.println("Starting test");

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

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            System.out.println("App launched");

            Thread.sleep(5000);

            // EMAIL

            WebElement email = driver.findElement(
                    AppiumBy.xpath("//android.widget.EditText[@text='Email ID']"));

            email.click();
            email.sendKeys("test@gmail.com");

            System.out.println("Email entered");

            // PASSWORD

            WebElement password = driver.findElement(
                    AppiumBy.xpath("//android.widget.EditText[@text='Password']"));

            password.click();
            password.sendKeys("123456");

            System.out.println("Password entered");

            // HIDE KEYBOARD

            driver.hideKeyboard();

            Thread.sleep(2000);

            // LOGIN BUTTON

            WebElement loginButton = driver.findElement(
                    AppiumBy.xpath("//android.widget.TextView[@text='LOGIN']"));

            loginButton.click();

            System.out.println("Login button clicked");

            Thread.sleep(5000);

            System.out.println("Valid login test completed");

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