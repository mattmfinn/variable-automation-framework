package com.theconstantvariable.shell;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Abstract class for Unix shells/commands. This will be purely to execute shell commands. The initial intended purpose
 * is to build a child class for querying connected devices with Appium.
 */

abstract class AbstractShellParser
{

    protected final static String androidTerminalTool= "adb";
    protected final static String iOSTerminalTool = "ideviceinfo";
    protected final static String iOSOptionListAllUDID = "-l";

    // All implementations will need to run a basic command with a string
    public void runShellCommand(String command) throws IOException
    {

    }

    public static String getAndroidTerminalTool()
    {
        return androidTerminalTool;
    }

    public static String getiOSTerminalTool()
    {
        return iOSTerminalTool;
    }

    public static String getiOSOptionListAllUDID()
    {
        return iOSOptionListAllUDID;
    }


}
