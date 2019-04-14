package com.theconstantvariable.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;

public class DriverFactory
{

    private final ArrayList<DesiredCapabilities> capabilities;
    private final String platform;

    public DriverFactory(ArrayList<DesiredCapabilities> capabilities, String platform)
    {
        this.capabilities = capabilities;
        this.platform = platform.toLowerCase();
    }

    public ArrayList<?> createDrivers()
    {
        // TODO How do we wait for devices to be available?
        if (platform.equals("android"))
        {
            ArrayList<AndroidDriver> drivers = new ArrayList<>();
            for (DesiredCapabilities d : capabilities)
            {
                drivers.add(new AndroidDriver(d));
            }
            return drivers;
        } else if (platform.equals("ios"))
        {
            ArrayList<IOSDriver> drivers = new ArrayList<>();
            for (DesiredCapabilities d : capabilities)
            {
                drivers.add(new IOSDriver(d));
            }
            return drivers;
        }
        return null;
    }
}
