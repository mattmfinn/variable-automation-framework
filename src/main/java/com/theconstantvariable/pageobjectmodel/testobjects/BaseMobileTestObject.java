package com.theconstantvariable.pageobjectmodel.testobjects;

import com.theconstantvariable.enums.LocalDeviceCommands;
import com.theconstantvariable.environment.capabilities.CapabilitiesFactory;
import com.theconstantvariable.environment.parse.JSONParser;
import com.theconstantvariable.pageobjectmodel.screenobjects.BaseObject;
import com.theconstantvariable.shell.LocalShellParser;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class BaseMobileTestObject extends BaseObject
{
    private LocalShellParser localShellParser;
    private static String jsonEnvironments = "/home/matt/IdeaProjects/variable-automation-framework/src/test/resources/localMobileEnvironments.json";

    @DataProvider(name = "local")
    public static Object[] environments()
    {
        JSONParser jsonParser = new JSONParser(jsonEnvironments);
        CapabilitiesFactory capabilitiesFactory = new CapabilitiesFactory(jsonParser);
        return capabilitiesFactory.makeCapabilities();
    }

    // We need this to run in the method, not before, so no annotation
    // TODO better exception handling?
    public <D> D setUp(DesiredCapabilities desiredCapabilities) throws Exception
    {
        desiredCapabilities.setCapability("deviceName", setDeviceName());
        if (desiredCapabilities.getCapability("platformName").toString().toLowerCase().contains("ios"))
        {
            return (D) new IOSDriver(desiredCapabilities);
        } else if (desiredCapabilities.getCapability("platformName")
                .toString().toLowerCase().contains("android"))
        {
            return (D) new AndroidDriver(desiredCapabilities);
        } else
        {
            // TODO: Logging the error if the two statements above are false
        }
        return null;
    }

    private String setDeviceName() throws IOException
    {
        localShellParser = new LocalShellParser();
        return localShellParser.findConnectedDevices(LocalDeviceCommands.IOS_DEVICE_QUERY).get(0);
    }
}
