package com.theconstantvariable.enums;

public enum LocalDeviceCommands
{
    // Android - command line tool, options/command
    ANDROID_DEVICE_QUERY("adb", "devices");

    public final String tool;
    public final String command;

    LocalDeviceCommands(String tool, String command)
    {
        this.tool = tool;
        this.command = command;
    }
}
