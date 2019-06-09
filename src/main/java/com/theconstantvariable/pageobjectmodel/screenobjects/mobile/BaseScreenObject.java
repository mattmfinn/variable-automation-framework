package com.theconstantvariable.pageobjectmodel.screenobjects.mobile;

import io.appium.java_client.MobileDriver;

/**
 * For all work arounds and specific helper methods to mobile tests and mobile Screen Objects that are not needed by
 * web testing.
 * TODO: Wrap swipe method to work based on percentage of screen space rather than hard corded pixels
 */
public class BaseScreenObject extends MobileBaseObject
{
    public BaseScreenObject(MobileDriver driver)
    {
        super(driver);
    }
}
