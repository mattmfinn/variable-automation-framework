package com.theconstantvariable.pageobjectmodel.screenobjects.mobile;

import io.appium.java_client.MobileDriver;

/**
 * For all work arounds and specific helper methods to Android tests and Android Screen Objects that are not needed by
 * iOS testing.
 */
public class BaseAndroidScreenObject extends BaseScreenObject
{
    public BaseAndroidScreenObject(MobileDriver driver)
    {
        super(driver);
    }
}
