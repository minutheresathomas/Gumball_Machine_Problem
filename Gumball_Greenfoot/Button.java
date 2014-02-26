import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends GumballMachine
{
    
    private Inspector inspector;
    
    public Button(Inspector inspect)
    {
        inspector = inspect;
        
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       mouseClickAction();// Add your action code here.
    }   
    
    public void mouseClickAction()
    {
        String msg;
        if(Greenfoot.mouseClicked(this))
        {
            msg = "Crank Turned!";
            // Remove the existing mesage and Add a new message
            removeAddMessage(msg);
            inspector.checkCoinValidity();
        }
        
    }
    
}
