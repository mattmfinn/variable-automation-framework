package examples;

import com.theconstantvariable.pageobjectmodel.testobjects.BaseMobileTestObject;
import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Should test that you can navigate properly, and that waits between page loads work as expected. A sort of
 * 'Sanity Check' for running local tests. Can be a long test, used as part of testing adding a feature to the
 * framework to check if a device is free.
 * android:id/statusBarBackground
 * /hierarchy/android.widget.FrameLayout/android.view.View
 *
 */

public class MultipleNavigationsTest extends BaseMobileTestObject
{
    @Test(dataProvider = "local")
    public void multipleNavigationsTest(Object[] capabilities) throws InterruptedException
    {
        Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(By.id("com.theconstantvariable:id/statusBarBackground")).isDisplayed());
    }

}
