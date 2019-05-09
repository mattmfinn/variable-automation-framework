package com.theconstantvariable.pageobjectmodel.testobjects;

import com.theconstantvariable.environment.capabilities.CapabilitiesFactory;
import com.theconstantvariable.environment.parse.JSONParser;
import com.theconstantvariable.pageobjectmodel.screenobjects.BaseObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseMobileTestObject extends BaseObject
{
    private static String platform = System.getProperty("platform");
    private static String jsonEnvironments = System.getProperty("jsonEnvironments");

    @DataProvider(name = "local")
    public static Object[] environments()
    {
        JSONParser jsonParser = new JSONParser(platform, jsonEnvironments);
        CapabilitiesFactory capabilitiesFactory = new CapabilitiesFactory(jsonParser);
        return capabilitiesFactory.makeCapabilities();
    }

    @BeforeMethod
    public void setUp()
    {
        if (platform.toLowerCase().contains("ios"))
        {

        } else if (platform.toLowerCase().contains("android"))
        {

        }
    }
}
