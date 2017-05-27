/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Team4Week2;
package CSE360;


import java.awt.*;
import java.io.*;
import javax.swing.*;
import org.json.JSONException;


/**
 *
 * @author rsatchel
 */
public class Team4 extends JPanel{
    GridLayout myGrid= new GridLayout (1,2); 
    
    
    
    
    public Team4() {
        try{
        
        //System.out.println("Team 4 class called");
        this.setLayout(myGrid);
        this.setVisible(true);
        this.setSize(250,125);
        this.add(new ExampleWeather());
        this.add(new ExampleGoogleMaps().createMap());
        }
        catch(IOException e){
            System.out.println("IO Exception !!");
        }
        catch (JSONException e){
            System.out.println("JSON Exception !!");
        }
    }
    
}
