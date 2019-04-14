package com.theconstantvariable.enums;

import net.sf.cglib.core.Local;

public enum LocalDeviceCommands
{
    // iOS - command line tool, options/command
    IOS_DEVICE_QUERY ("ios", "ifusion", " -l"),

    // Android - command line tool, options/command
    ANDROID_DEVICE_QUERY("android","adb", "devices");

    public final String platform;
    public final String tool;
    public final String command;

    LocalDeviceCommands(String platform, String tool, String command)
    {
        this.platform = platform;
        this.tool = tool;
        this.command = command;
    }
}
