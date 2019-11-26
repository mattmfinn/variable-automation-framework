package com.theconstantvariable.pageobjectmodel.testobjects;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.theconstantvariable.enums.LocalDeviceCommands;
import com.theconstantvariable.environment.capabilities.CapabilitiesFactory;
import com.theconstantvariable.environment.parse.JSONParser;
import com.theconstantvariable.pageobjectmodel.screenobjects.BaseObject;
import com.theconstantvariable.shell.ProcessBuilderBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;

public class BaseMobileTestObject extends BaseObject
{
    public AndroidDriver driver;
    private static ProcessBuilderBase processBuilderBase = new ProcessBuilderBase();
    private final static String jsonEnvironments = "/Users/matthome/IdeaProjects/variable-automation-framework/src/test/resources/localMobileEnvironments.json";

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
            // TODO read JSON here and create drivers, have data provider return JSON
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
        System.out.println(object.getClass());
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //MobileCapabilities mobileCapabilities = new ObjectMapper().readValue(object, MobileCapabilities.class);
        for(Field field : object.getClass().getDeclaredFields())
        {
            try
            {
                desiredCapabilities.setCapability(field.getName(), field.get(field.getName()));
                System.out.println("Field name: " + field.getName());
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
        return processBuilderBase.findConnectedDevices(LocalDeviceCommands.ANDROID_DEVICE_QUERY).get(0);
    }
}
