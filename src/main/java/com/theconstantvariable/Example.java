package com.theconstantvariable;


import java.io.IOException;

public class Example
{
    public static void main(String[] args) throws IOException
    {
        ShellParserBase shellParserBase = new ShellParserBase();
        shellParserBase.runShellCommand(shellParserBase.getAndroidTerminalTool(), "devices");
    }
}
