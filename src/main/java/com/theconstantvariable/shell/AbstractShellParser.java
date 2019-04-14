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
    private final static String androidQueryCommand = "adb";
    private final Terminal terminal;

    protected AbstractShellParser() throws java.io.IOException
    {
        terminal= createTerminal();
    }

    private static Terminal createTerminal() throws IOException
    {
        TerminalBuilder builder = new TerminalBuilder.builder();
        return builder.build();
    }

    public List<String> runShellCommand(String command)
    {
        return new ArrayList<String>();
    }
}
