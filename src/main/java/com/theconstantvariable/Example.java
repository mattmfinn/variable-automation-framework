package com.theconstantvariable;

import com.theconstantvariable.shell.ShellParserBase;

import java.io.IOException;

public class Example
{
    public static void main(String[] args) throws IOException
    {
        ShellParserBase shellParserBase = new ShellParserBase();
        shellParserBase.runShellCommand(shellParserBase.getAndroidTerminalTool(), "devices");
    }
}
