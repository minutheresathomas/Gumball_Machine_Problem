import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomPicker extends Picker
{
    private int choice;
    
    /**
     * Act - do whatever the RandomPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        // get random gumballs
        //pickRandomGumball();
    }    
    
    public void pickRandomGumball()
    {
        choice = Greenfoot.getRandomNumber(2);
        switch(choice)
        {
            case 0 : BlueGumball blue = new BlueGumball();
                     getWorld().addObject(blue, 370, 460);
                     break;
            case 1 : RedGumball red = new RedGumball();
                     getWorld().addObject(red, 370, 460);
                     break;
            case 2 : GreenGumball green = new GreenGumball();
                     getWorld().addObject(green, 370, 460);
                     break;
        }
    }
}
