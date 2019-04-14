package com.theconstantvariable;


import com.theconstantvariable.environment.capabilities.CapabilitiesFactory;
import com.theconstantvariable.environment.capabilities.MobileCapabilities;
import com.theconstantvariable.environment.parse.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;

public class Example
{
    public static void main(String[] args)
    {
        JSONParser jsonParser = new JSONParser();
        ArrayList<MobileCapabilities> capabilities = jsonParser.parseEnvironments();
        System.out.println(capabilities.size());
        System.out.println(capabilities.get(0).getPlatformName() + "*******************");
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        CapabilitiesFactory capabilitiesFactory = new CapabilitiesFactory(jsonParser);
        ArrayList<DesiredCapabilities> capabilities1 = capabilitiesFactory.makeCapabilities();
    }
}
