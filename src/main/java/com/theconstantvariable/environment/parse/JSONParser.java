package com.theconstantvariable.environment.parse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theconstantvariable.environment.capabilities.MobileCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JSONParser
{

    // TODO: Populate jsonEnvironments and platform from DriverFactory DataProvider?
    private String platform;
    private String jsonEnvironments;

    public JSONParser(String jsonEnvironments)
    {
        this.jsonEnvironments = jsonEnvironments;
    }

    public ArrayList<MobileCapabilities> parseEnvironments()
    {
        try
        {
            FileReader fileReader = new FileReader(jsonEnvironments);
            ObjectMapper objectMapper = new ObjectMapper();
            MobileCapabilities[] capabilities = objectMapper.readValue(fileReader, MobileCapabilities[].class);
            platform = capabilities[0].platformName.toLowerCase();
            return filterEnvironments(capabilities, platform);
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private ArrayList<MobileCapabilities> filterEnvironments(MobileCapabilities[] capabilities, String platform)
    {
        ArrayList<MobileCapabilities> filteredCapabilities = new ArrayList<>();
        for (int i = 0; i < capabilities.length; i++)
        {
            if (capabilities[i].platformName.toLowerCase().contains(platform.toLowerCase()))
                filteredCapabilities.add(capabilities[i]);
        }
        return filteredCapabilities;
    }

    public String getJsonEnvironments()
    {
        return jsonEnvironments;
    }

    public String getPlatform()
    {
        return platform;
    }
}