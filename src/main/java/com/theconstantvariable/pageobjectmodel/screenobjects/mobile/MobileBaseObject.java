package com.theconstantvariable.pageobjectmodel.screenobjects.mobile;

import com.theconstantvariable.enums.SwipeDirection;
import com.theconstantvariable.pageobjectmodel.screenobjects.BaseObject;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class MobileBaseObject<T extends MobileDriver> extends BaseObject

{

    T driver;

    public MobileBaseObject(T driver)
    {
        this.driver = driver;
    }

    /**
     * A helper method to make swiping more reliable and faster to set up. It swipes by a percentage, using an Enum
     * to specify UP & DOWN.
     */
    public void swipeByPercent(int percent, SwipeDirection direction)
    {
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("Size of device: " + dimension.getWidth() + " by " + dimension.getHeight());
        int xCenter = (dimension.getWidth() / 2);
        int yCenter = (dimension.getHeight() / 2);
        int swipeEndPoint;

        // For Appium, down means higher pixel location, up means lower pixel location (0 is screen bottom)
        if (direction == SwipeDirection.DOWN) swipeEndPoint = ((dimension.getHeight() / 100) * percent);
        else if (direction == SwipeDirection.UP) swipeEndPoint = ((dimension.getHeight() / 100) * percent);
        else
            throw new IllegalArgumentException("No valid swipe direction specified. Options: SwipeDirection.UP, SwipeDirection.DOWN");

        if ((swipeEndPoint > (yCenter * 2)) || swipeEndPoint < 0)
        {
            throw new IllegalArgumentException("You are attempting to swipe an area larger than half the size " +
                    "of the screen! This cannot be done as swiping begins from the center (Y Axis). swipeEndPoint value: " + swipeEndPoint);
        } else
        {
            System.out.println("Attempting to swipe to location: " + swipeEndPoint +
                    " - from location X: " + xCenter + " from location Y: " + yCenter);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(new PointOption().withCoordinates(xCenter, yCenter))
                    .moveTo(new PointOption().withCoordinates(0, -swipeEndPoint)).release().perform();
        }
    }
}
