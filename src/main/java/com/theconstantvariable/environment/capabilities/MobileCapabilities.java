package com.theconstantvariable.environment.capabilities;

public class MobileCapabilities extends CapabilitiesInterface
{
    private String platformName;
    private String deviceName;
    private String browserName;
    private String platformVersion;

    public String getPlatformName()
    {
        return platformName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public String getBrowserName()
    {
        return browserName;
    }

    public String getPlatformVersion()
    {
        return platformVersion;
    }
}
