package com.theconstantvariable.pageobjectmodel.screenobjects.mobile;

import io.appium.java_client.MobileDriver;

/**
 * For all work arounds and specific helper methods to iOS tests and iOS Screen Objects that are not needed by
 * Android testing.
 */
public class BaseIOSScreenObject extends BaseScreenObject
{
    public BaseIOSScreenObject(MobileDriver driver)
    {
        super(driver);
    }
}
