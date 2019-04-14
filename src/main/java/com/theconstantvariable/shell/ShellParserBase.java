package com.theconstantvariable.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShellParserBase extends AbstractShellParser
{

    ProcessBuilder builder;

    public ShellParserBase()
    {
        createProcessBuilder();
    }

    private void createProcessBuilder()
    {
        builder = new ProcessBuilder();
        // See https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html#redirectErrorStream()
        builder.redirectErrorStream(true);
    }

    private void executeAndReadOutput(ProcessBuilder builder) throws IOException
    {
        Process process = builder.start();
        InputStream is = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = reader.readLine()) != null)
        {
            System.out.println(line);
        }
    }

    public void runShellCommand(String tool, String command) throws IOException
    {
        // 'adb' would be a tool, 'devices' would be a command
        this.builder.command(tool, command);
        executeAndReadOutput(this.builder);
    }

}
