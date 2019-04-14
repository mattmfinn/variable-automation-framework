package com.theconstantvariable.environment.parse;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;

public interface ParseEnvironments
{

    public List<DesiredCapabilities> environments = new ArrayList<>();

    /** Populate the list from the EnvironmentParser to create DesiredCapabilities
     * (which is equivalent to specifying a specific environment in which to execute the test).
     * @return List<DesiredCapabilities> object specifying the test environments (browser or device)
     */
    public List<DesiredCapabilities> createEnvironments();

}
