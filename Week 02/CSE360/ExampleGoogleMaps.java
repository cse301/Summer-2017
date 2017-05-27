/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//package Team4Week2;

package CSE360;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExampleGoogleMaps extends JPanel{
    
        public JPanel createMap(){
            System.out.println("createMap called");
            JPanel mapPanel = new JPanel();
            
            try {
                //String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?" 
                  //      +"center=40.714728,-73.998672&zoom=11&size=612x612&scale=2&maptype=roadmap";
                String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?" 
                        +"center=33.424240,-111.928053&zoom=11&size=612x612&scale=2&maptype=roadmap";

                String destinationFile = "image.jpg";
                String str = destinationFile;
                URL url = new URL(imageUrl);
                OutputStream os;
                try (InputStream is = url.openStream()) {
                    os = new FileOutputStream(destinationFile);
                    byte[] b = new byte[2048];
                    int length;
                    while ((length = is.read(b)) != -1) {
                        os.write(b, 0, length);
                    }
                }
                os.close();
            } catch (IOException e) {
                System.exit(1);
            }

            //test.add(new JLabel(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(630, 600,
            //        java.awt.Image.SCALE_SMOOTH))));
            mapPanel.add(new JLabel(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(630, 600,
                    java.awt.Image.SCALE_SMOOTH))));
            mapPanel.setSize(125,125);
            mapPanel.setVisible(true);
            return mapPanel;
            //panel.setVisible(true);
            //test.setVisible(true);
            //test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //test.add(panel);
            
    }
}
