package com.theconstantvariable.pageobjectmodel.screenobjects.mobile;

import com.theconstantvariable.enums.SwipeDirection;
import com.theconstantvariable.pageobjectmodel.screenobjects.BaseObject;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class MobileBaseObject<T extends MobileDriver> extends BaseObject

{

    AndroidDriver driver;

    public MobileBaseObject(AndroidDriver driver)
    {
        this.driver = driver;
    }


}
