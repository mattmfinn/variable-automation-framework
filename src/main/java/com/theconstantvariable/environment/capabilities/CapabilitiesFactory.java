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

    public DesiredCapabilities[] makeCapabilities()
    {
        try
        {
            ArrayList<MobileCapabilities> rawCapabilities = jsonParser.parseEnvironments();
            DesiredCapabilities finalCapabilities[] = new DesiredCapabilities[rawCapabilities.size()];

            int index = 0;
            for (MobileCapabilities m : rawCapabilities)
            {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                for (Method method : m.getClass().getMethods())
                {
                    capabilities.setCapability(method.getName(), method.getDefaultValue());
                }
                finalCapabilities[index] = capabilities;
                index++;
            }
            return finalCapabilities;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
