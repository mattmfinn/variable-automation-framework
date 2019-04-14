package com.theconstantvariable.environment.capabilities;

import com.theconstantvariable.environment.parse.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class CapabilitiesFactory
{

    private JSONParser jsonParser;

    public CapabilitiesFactory(JSONParser jsonParser)
    {
        this.jsonParser = jsonParser;
    }

    public ArrayList<DesiredCapabilities> makeCapabilities()
    {
        try
        {
            ArrayList<DesiredCapabilities> finalCapabilities = new ArrayList<>();
            ArrayList<MobileCapabilities> rawCapabilities = jsonParser.parseEnvironments();

            for (MobileCapabilities m : rawCapabilities)
            {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                for (Method method : m.getClass().getMethods())
                {
                    capabilities.setCapability(method.getName(), method.getDefaultValue());
                }
                finalCapabilities.add(capabilities);
            }
            return finalCapabilities;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
