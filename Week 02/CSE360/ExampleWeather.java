/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package Team4Week2;

package CSE360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.awt.*;
import javax.swing.*;

import org.json.JSONException;
import org.json.JSONObject;

public class ExampleWeather extends JPanel{
    
    private JTextArea ta1, ta2, ta3, ta4, ta5, ta6, ta7, ta8, ta9;
    private GridLayout grid;
    
    
    public ExampleWeather() throws IOException, JSONException{
        
        createWeather();    
    }
    
    public void createWeather() throws IOException, JSONException{
        //System.out.println("create Weather called");
        
        String yourKey = "cab82799b5b1e817dbccab51d6d7ec40"; 
        JSONObject json = readJsonFromUrl("https://api.darksky.net/forecast/"
                + yourKey +"/33.421968,-111.936642");
        //System.out.println(json.get("timezone"));

        ta1 = new JTextArea(1,20);
        ta2 = new JTextArea(1,20);
        ta3 = new JTextArea(1,20);
        ta4 = new JTextArea(1,20);
        ta5 = new JTextArea(1,20);
        ta6 = new JTextArea(1,20);
        ta7 = new JTextArea(1,20);
        ta8 = new JTextArea(1,20);
        ta9 = new JTextArea(1,20);
        
        ta1.setEditable(false);
        ta2.setEditable(false);
        ta3.setEditable(false);
        ta4.setEditable(false);
        ta5.setEditable(false);
        ta6.setEditable(false);
        ta7.setEditable(false);
        ta8.setEditable(false);
        ta9.setEditable(false);
        
        Double time = 0.0;
        Double temp = 0.0;
        Double nearestStorm = 0.0;
        Double probPrecip = 0.0;      
        Double windVelocity = 0.0;
        Double windDirection = 0.0;
        Double atmosPressure = 0.0;
        Double vis = 0.0;
        Object timeZone = json.get("timezone");

        temp = json.getJSONObject("currently").getDouble("temperature");
        nearestStorm = json.getJSONObject("currently").getDouble("nearestStormDistance");
        time = json.getJSONObject("currently").getDouble("time");
        probPrecip = json.getJSONObject("currently").getDouble("precipProbability");
        windVelocity = json.getJSONObject("currently").getDouble("windSpeed");
        windDirection = json.getJSONObject("currently").getDouble("windBearing");
        atmosPressure = json.getJSONObject("currently").getDouble("pressure");
        vis = json.getJSONObject("currently").getDouble("visibility");

        /*
        System.out.println("Nearest Storm: " + nearestStorm + " miles");
        System.out.println("Probability of Precipitation :" + probPrecip + "%");
        System.out.println(json.getJSONObject("currently").getString("summary"));        
        System.out.println(json.getJSONObject("currently").getDouble("pressure"));
        */
        Font myFont = new Font("Serif", Font.PLAIN, 8);
        
        ta1.setFont(myFont);
        ta2.setFont(myFont);
        ta3.setFont(myFont);
        ta4.setFont(myFont);
        ta5.setFont(myFont);
        ta6.setFont(myFont);
        ta7.setFont(myFont);
        ta8.setFont(myFont);
        ta9.setFont(myFont);
        
        this.ta1.setText((String) timeZone);
        this.ta2.setText("Currently: " + json.getJSONObject("currently").getString("summary"));
        this.ta3.setText("Temp: " + String.valueOf(temp) + "°F");
        this.ta4.setText("Nearest Storm: " + String.valueOf(nearestStorm) + " miles");
        this.ta5.setText("Prob of Precip: " + String.valueOf(probPrecip) + "%");
        this.ta6.setText("Wind Speed: " + String.valueOf(windVelocity) + " mph");
        this.ta7.setText("Wind Direction: " + String.valueOf(windDirection) + "°");
        this.ta8.setText("Pressure: " + String.valueOf(atmosPressure) + " hPa");
        this.ta9.setText("Visibility: " + String.valueOf(vis) + " miles");
        
                
        this.setLayout(new GridLayout(10,1));
        this.add(ta1);
        this.add(ta2);
        this.add(ta3);
        this.add(ta4);
        this.add(ta5);
        this.add(ta6);
        this.add(ta7);
        this.add(ta8);
        this.add(ta9);
        
    }
    


  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
        
      is.close();
    }
  }
    
}
