package examples;

import com.theconstantvariable.pageobjectmodel.testobjects.BaseMobileTestObject;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 * Should test that you can navigate properly, and that waits between page loads work as expected. A sort of
 * 'Sanity Check' for running local tests. Can be a long test, used as part of testing adding a feature to the
 * framework to check if a device is free.
 */

public class MultipleNavigationsTest extends BaseMobileTestObject
{

    AndroidDriver driver;

    @Test(dataProvider = "local")
    public void multipleNavigationsTest(DesiredCapabilities desiredCapabilities) throws Exception
    {
        driver = setUp(desiredCapabilities);
        driver.navigate().to("www.theconstantvariable.com");
        Thread.sleep(100000);
        driver.quit();
    }

}
