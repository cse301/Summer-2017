package cse360;

/**
 *
 * @author pdreiter
 * filename: Team7.java
 * description: file containing Team7 class for CSE360 Summer C Project 1
 * Team members:
 * Michael Xhu (wilson.xhy@outlook.com)
 * Chen Yang (cyang112@asu.edu)
 * Sarah Goddard (slgoddar@asu.edu)
 * Pemma Reiter (pdreiter@asu.edu)
 * Notes from pdreiter: This file was originally created via NetBeans Java Form, but during 
 * testing, class diverged from Form, autorelationships via embedded form macros
 * have been severed
 * 
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Date;


/**
 *
 * @author pdreiter
 * 
 */
public class WeatherPanel extends JPanel {

    private WeatherInfo geoLocation;


    /**
     * Creates new form WeatherPanel
     */
    public WeatherPanel(double latitude, double longitude) {
        geoLocation = new WeatherInfo(latitude,longitude);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        IconImage = new javax.swing.JPanel();
        TextHumidity = new javax.swing.JTextField();
        TextTemperature = new javax.swing.JTextField();
        TextPrecipitationProbability = new javax.swing.JTextField();
        TextCloudCover = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        IconImage.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout IconImageLayout = new javax.swing.GroupLayout(IconImage);
        IconImage.setLayout(IconImageLayout);
        IconImageLayout.setHorizontalGroup(
            IconImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );
        IconImageLayout.setVerticalGroup(
            IconImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        add(IconImage, java.awt.BorderLayout.CENTER);
//        jTextFieldTemperature.setText(geoLocation.getWeatherFieldString("currently", "temperature"));
        TextHumidity.setText(geoLocation.getWeatherFieldString("currently", "humidity")+" [Humidity]");
        add(TextHumidity, java.awt.BorderLayout.PAGE_START);

        TextTemperature.setText(geoLocation.getWeatherFieldString("currently", "temperature")+"\u00b0"+" F [Temperature]");
        add(TextTemperature, java.awt.BorderLayout.PAGE_END);

        TextPrecipitationProbability.setText(geoLocation.getWeatherFieldString("currently", "precipProbability")+" [Probability of Precipitation]");
        add(TextPrecipitationProbability, java.awt.BorderLayout.LINE_END);

        TextCloudCover.setText(geoLocation.getWeatherFieldString("currently", "cloudCover")+" [CloudCover]");
        add(TextCloudCover, java.awt.BorderLayout.LINE_START);
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify                     
    private javax.swing.JPanel IconImage;
    private javax.swing.JTextField TextCloudCover;
    private javax.swing.JTextField TextPrecipitationProbability;
    private javax.swing.JTextField TextTemperature;
    private javax.swing.JTextField TextHumidity;
    // End of variables declaration                   
    
}
