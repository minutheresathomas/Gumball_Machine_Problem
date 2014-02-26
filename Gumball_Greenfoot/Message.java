import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
    private GreenfootImage bgBaseImage;  
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Message()
    {
        updateMessage("Welcome to Gumball World!");
    }
    
    public Message(String text)
    {
        updateMessage(text);
    }
    
    private void updateMessage(String text)
    {
        int fontSize = 24; // whatever size  
Color textColor = new Color(0, 255, 128); // whatever color  
//String text = "Text to display"; // whatever text  
GreenfootImage textImage = new GreenfootImage(text, fontSize, textColor, new Color(0, 0, 0, 0));  
GreenfootImage image = new GreenfootImage(textImage.getWidth()+fontSize/2, textImage.getHeight()+fontSize/2);  
Color outerColor = new Color(196, 196, 0); // whatever color  
image.setColor(outerColor);  
image.fill();  
Color innerColor = new Color(0, 0, 196); // whatever color  
image.setColor(innerColor);  
image.fillRect(fontSize/8, fontSize/8, image.getWidth()-fontSize/4, image.getHeight()-fontSize/4);  
image.drawImage(textImage, (image.getWidth()-textImage.getWidth())/2, (image.getHeight()-textImage.getHeight())/2); 
        
        setImage(new GreenfootImage(text, 30, Color.blue, Color.yellow));        
    } 
    
    public void act() 
    {
        // Add your action code here.
    }    
}
