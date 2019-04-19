package com.theconstantvariable.pageobjectmodel.testobjects;

import com.theconstantvariable.driver.DriverFactory;
import com.theconstantvariable.environment.capabilities.CapabilitiesFactory;
import com.theconstantvariable.environment.parse.JSONParser;
import com.theconstantvariable.pageobjectmodel.screenobjects.BaseObject;
import org.testng.annotations.DataProvider;

public class BaseMobileTestObject extends BaseObject
{

    // TODO how to populate these values at runtime into this class directly? CLI?
    // Dependency injection?
    protected String platform;
    protected String jsonEnvironment;

    @DataProvider(name = "local")
    public static Object[][] drivers()
    {
        JSONParser jsonParser = new JSONParser();
        CapabilitiesFactory capabilitiesFactory = new CapabilitiesFactory(jsonParser);
        return new DriverFactory(capabilitiesFactory.makeCapabilities(), platform).createDrivers();
    }
}
