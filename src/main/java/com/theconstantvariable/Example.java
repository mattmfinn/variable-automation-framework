package com.theconstantvariable;


import com.theconstantvariable.driver.DeviceLockStatus;
import com.theconstantvariable.enums.LocalDeviceCommands;
import com.theconstantvariable.environment.JSONParser;
import com.theconstantvariable.shell.ShellParserLocal;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.ArrayList;

public class Example
{
    public static void main(String[] args) throws IOException
    {
        /*DeviceLockStatus deviceLockStatus = new DeviceLockStatus();

        ShellParserLocal shellParserLocal = new ShellParserLocal();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ArrayList<String> devices = shellParserLocal.findConnectedDevices(LocalDeviceCommands.ANDROID_DEVICE_QUERY);
        capabilities.setCapability
                ("deviceName", devices.get(0));
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("browserName", "Chrome");

        AndroidDriver driver = new AndroidDriver(capabilities);
        if(deviceLockStatus.isAndroidDeviceLocked(driver)) driver.quit(); System.out.println("**The device is locked!**");
        driver.getBatteryInfo();
        driver.quit();*/

        JSONParser jsonParser = new JSONParser();
        jsonParser.parseEnvironments("android");
    }
}
