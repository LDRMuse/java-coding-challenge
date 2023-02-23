package com.myapp.creditcardcalculator.services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesService {

    String discoverInterest;
    String mastercardInterest;
    String visaInterest;
    public PropertiesService() {

        Properties prop = new Properties();
        try {
            // Load the properties file
            prop.load(Files.newInputStream(Paths.get("src/card.properties")));

            // Get the property value and set it to the field
           discoverInterest = prop.getProperty("foo.discoverInterest");
           mastercardInterest = prop.getProperty("foo.mastercardInterest");
           visaInterest = prop.getProperty("foo.visaInterest");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getDiscoverInterest(){
        return discoverInterest;
    }

    public String getMastercardInterest(){
        return mastercardInterest;
    }

    public String getVisaInterest(){
        return visaInterest;
    }



}








