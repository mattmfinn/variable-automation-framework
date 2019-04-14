package com.theconstantvariable.shell;

import com.theconstantvariable.enums.LocalDeviceCommands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShellParserLocal extends AbstractShellParser
{

    ProcessBuilder builder;
    ArrayList<String> androidTextToStrip = new ArrayList<>();
    ArrayList<String> iOSTextToStrip = new ArrayList<>();

    public ShellParserLocal()
    {
        createProcessBuilder();
        androidTextToStrip.add("List of devices attached");
        androidTextToStrip.add("\tdevice");
    }

    private void createProcessBuilder()
    {
        builder = new ProcessBuilder();
        // See https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html#redirectErrorStream()
        builder.redirectErrorStream(true);
    }

    private ArrayList<String> executeAndReturnOutput(ProcessBuilder builder) throws IOException
    {
        ArrayList<String> connectedDevices = new ArrayList<>();

        Process process = builder.start();
        InputStream is = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = reader.readLine()) != null)
        {
            connectedDevices.add(line);
        }
        return connectedDevices;
    }

    private ArrayList<String> stripSpamResults(ArrayList<String> list, LocalDeviceCommands commands)
    {

        if(commands.platform == "android")
        {

            for(int i = 0; i < list.size(); i++)
            {
                for(String s : androidTextToStrip)
                {
                    // Remove all perfect matches
                    Collections.replaceAll(list, s, "");

                    // Remove all partial matches
                    list.set(i, list.get(i).replaceFirst(s, ""));
                }
            }
        }

        if(commands.platform == "ios")
        {
            for(String s : iOSTextToStrip)
            {
                for(int i = 0; i < list.size(); i++)
                {
                    list.get(i).replaceAll(s, "");
                }
            }
        }

        for(int i =0; i < list.size(); i++) if(list.get(i).isEmpty()) list.remove(i);
        return list;
    }

    public ArrayList<String> findConnectedDevices(LocalDeviceCommands commands) throws IOException
    {
        this.builder.command(commands.tool, commands.command);
        ArrayList results = executeAndReturnOutput(this.builder);

        return stripSpamResults(results, commands);
    }

}
