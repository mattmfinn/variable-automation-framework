package com.theconstantvariable.pageobjectmodel.testobjects;

import com.theconstantvariable.enums.LocalDeviceCommands;
import com.theconstantvariable.environment.capabilities.CapabilitiesFactory;
import com.theconstantvariable.environment.parse.JSONParser;
import com.theconstantvariable.pageobjectmodel.screenobjects.BaseObject;
import com.theconstantvariable.shell.LocalShellParser;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;

public class BaseMobileTestObject extends BaseObject
{
    public AndroidDriver driver;
    private static LocalShellParser localShellParser = new LocalShellParser();
    private final static String jsonEnvironments = "/home/matt/IdeaProjects/variable-automation-framework/src/test/resources/localMobileEnvironments.json";

    @DataProvider(name = "local")
    public static Object[] environments()
    {
        JSONParser jsonParser = new JSONParser(jsonEnvironments);
        CapabilitiesFactory capabilitiesFactory = new CapabilitiesFactory(jsonParser);
        // TODO method to check every required value and make sure it's there
        return capabilitiesFactory.makeCapabilities();
    }

    @BeforeMethod
    public void setUp(Object[] capabilities)
    {
        Arrays.stream(capabilities).forEach(this::createDriver);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    private void createDriver(Object object)
    {
        try
        {
            DesiredCapabilities capabilities = transformObject(object);
            capabilities.setCapability("deviceName", setDeviceName());
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private DesiredCapabilities transformObject(Object object)
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        for(Field field : object.getClass().getFields())
        {
            try
            {
                desiredCapabilities.setCapability(field.getName(), field.get(field.getName()));
            }
            catch (IllegalAccessException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return desiredCapabilities;
    }

    private static String setDeviceName() throws IOException
    {
        return localShellParser.findConnectedDevices(LocalDeviceCommands.ANDROID_DEVICE_QUERY).get(0);
    }
}
