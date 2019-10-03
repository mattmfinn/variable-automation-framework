package com.theconstantvariable.pageobjectmodel.screenobjects.base;

import com.theconstantvariable.enums.SwipeDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

/**
 * For all work-arounds and specific helper methods to mobile tests and mobile Screen Objects that are not needed by
 * web testing.
 * TODO: Add support for LEFT & RIGHT
 */
public class BaseScreenObject
{

    private AndroidDriver driver;

    public BaseScreenObject(AndroidDriver driver)
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
        int swipeEndPosition;

        // For Appium, down means higher pixel location, up means lower pixel location (0 is screen bottom)
        if (direction == SwipeDirection.DOWN) swipeEndPosition = ((dimension.getHeight() / 100) * percent);
        else if (direction == SwipeDirection.UP) swipeEndPosition = ((dimension.getHeight() / 100) * percent);
        else
            throw new IllegalArgumentException("No valid swipe direction specified. Options: SwipeDirection.UP, SwipeDirection.DOWN");

        if ((swipeEndPosition > (yCenter * 2)) || swipeEndPosition < 0)
        {
            throw new IllegalArgumentException("You are attempting to swipe an area larger than half the size " +
                    "of the screen! This cannot be done as swiping begins from the center (Y Axis). swipeEndPosition value: " + swipeEndPosition);
        } else
        {
            System.out.println("Attempting to swipe to location: " + swipeEndPosition +
                    " - from location X: " + xCenter + " from location Y: " + yCenter);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(new PointOption().withCoordinates(xCenter, yCenter))
                    .moveTo(new PointOption().withCoordinates(0, -swipeEndPosition)).release().perform();
        }
    }
}
