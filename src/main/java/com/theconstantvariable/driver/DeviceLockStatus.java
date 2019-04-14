package com.theconstantvariable.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DeviceLockStatus
{
    /**
     * For cloud services, will require an implementation with the API
     * For local devices, it will check the 'Locked' status. Framework will update this. If locked, skip that device
     * for the time being
     *
     * @return true if the device is locked (in use), return false if the device is free for use
     */
    public boolean isAndroidDeviceLocked(AndroidDriver driver)
    {
        return driver.isDeviceLocked();
    }

    /**
     * Is there a way to use generics or a wrapper with 'forwarding' to create two implementations for IOSDriver
     * and AndroidDriver, without this extraneous method?
     *
     * @param driver
     * @return
     */
    public boolean isIOSDeviceLocked(IOSDriver driver)
    {
        return driver.isDeviceLocked();
    }


}