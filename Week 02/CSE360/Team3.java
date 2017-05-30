package CSE360;

import java.awt.*;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

import java.net.URL;

import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;

// Not using atm, focus on this weeks deliverable, but it's great that we've laid down with our future deliverable in mind
//import java.awt.event.*;


// Unsure what these two are for, I believe Jonathon added them
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Team3 extends JPanel {
    private JPanel mainPanel, mapPanel, weatherPanel;
    private JLabel weatherStatus, visibility, temperature;
//    private JTextField coordinates1, coordinates2;

    private String c1, c2;
    
    // Team3 constructor
    public Team3() {
        //Layout needs to be fixed, scaling issues with mapPanel
        mapPanel = new JPanel();
        mainPanel = new JPanel();
        weatherPanel = new JPanel();
        weatherStatus = new JLabel();
        visibility = new JLabel();
        temperature = new JLabel();
        //weatherPanel needs to be designed, possibly with Graphics class?
//        coordinates1 = new JTextField(15); //North & South
//        coordinates2 = new JTextField(15); //East & West
        //Initializing to test values
        c1 = "50.0000";
        c2 = "100.0000";

        try {
            JSONObject json = readJsonFromUrl("https://api.darksky.net/forecast/"
                    +"0297297911820662b2dfd6c18b18a183/" + "37.8267" + "," + "-122.4233");
            //Prints image to debugging console. Need to create a graphical representation.
            System.out.println(json.toString());
            System.out.println(json.getJSONObject("currently").getString("summary"));
//            String summary = json.getJSONObject("currently").getString("summary");
//            String visibility = Double.toString(json.getJSONObject("currently").getDouble("visibility"));
//            String temperature = Double.toString(json.getJSONObject("currently").getDouble("apparentTemperature"));

            weatherStatus.setText("Summary: " + json.getJSONObject("currently").getString("summary"));
            visibility.setText("Visibility: " + Double.toString(json.getJSONObject("currently").getDouble("visibility")));
            temperature.setText("Temperature: " + Double.toString(json.getJSONObject("currently").getDouble("apparentTemperature")));
        } catch(IOException e) {
            System.exit(1);
        }
        weatherPanel.add(weatherStatus);
        weatherPanel.add(visibility);
        weatherPanel.add(temperature);
        renderMap(c1, c2);
        //renderWeather();

        mapPanel.setPreferredSize(new Dimension(250, 400));
        weatherPanel.setPreferredSize(new Dimension(250,400));

        mapPanel.add(new JLabel(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(640, 640,
                java.awt.Image.SCALE_SMOOTH))));
        mainPanel.setLayout(new GridLayout(1, 2));
        mainPanel.add(mapPanel);
        mainPanel.add(weatherPanel);
//        mainPanel.add(coordinates1);
//        mainPanel.add(coordinates2);
        this.add(mainPanel);

        //NOTE: I believe creating a panel for the coordinates and placing
        //that next to the mapPanel can help with some of our formatting errors
//        mapPanel.add(coordinates1);
//        mapPanel.add(coordinates2);

        //Taken from the ExampleGoogleMaps class
        //Play around with size... Scaling based on size of JFrame??

        this.setVisible(true);

        //Ignore for now, future implementation
//        coordinates1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                c1 = coordinates1.getText();
//                renderImage();
//            }
//        });

        //Ignore for now, future implementation
//        coordinates2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                c2 = coordinates2.getText();
//                renderImage();
//            }
//        });
        
    }

    //Adapted from the main method of the ExampleGoogleMaps class
    private void  renderMap(String c1, String c2){
        try {
            // c1 and c2 are used in URL to pull a specific map from Google
            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?"
                    +"center=" + c1 + "," + c2 + "&zoom=5&size=912x912&scale=2&maptype=roadmap";

            //Image is saved as image.jpg in local folder
            String destinationFile = "image.jpg";
            String str = destinationFile;
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            System.exit(1);
        }
    }
    //Adapted from the main method of the ExampleWeather class
    private String getWeather(String c1, String c2) {
//        try {
//            JSONObject json = readJsonFromUrl("https://api.darksky.net/forecast/"
//                    +"0297297911820662b2dfd6c18b18a183/" + "37.8267" + "," + "-122.4233");
//            //Prints image to debugging console. Need to create a graphical representation.
//            System.out.println(json.toString());
//            System.out.println(json.getJSONObject("currently").getString("summary"));
//            String weather = "Summary: " + json.getJSONObject("currently").getString("summary") + "\nVisibility: " + json.getJSONObject("currently").get("visibility") + "\nTemperature: " + json.getJSONObject("currently").getDouble("apparentTemperature");
//            return weather;
//        } catch(IOException e) {
//            System.exit(1);
//        }
        return "";
    }

    //Taken from the ExampleWeather.java file
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    //Taken from the ExampleWeather.java file
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