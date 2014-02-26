import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GumballWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballWorld extends World
{

    /**
     * Constructor for objects of class GumballWorld.
     * 
     */
    public GumballWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(950, 600, 1); 
        setup();
    }

    public void setup()
    {
        GumballMachine gumballmachine = new GumballMachine();
        addObject(gumballmachine, 390, 200);
        gumballmachine.setLocation(390, 200);
        addObject(new Quarter(), 90, 80);
        addObject(new FakeQuarter(), 90, 220);
        addObject(new Penny(), 90, 350);
        RandomPicker randomPicker = new RandomPicker();
        addObject(randomPicker, 850, 90);
        randomPicker.setLocation(850, 90);
        GreenPicker greenPicker = new GreenPicker();
        addObject(greenPicker, 850, 400);
        greenPicker.setLocation(850, 400);
        Inspector inspector = new Inspector(gumballmachine, randomPicker, greenPicker);
        addObject(inspector, 586, 260);
        Button button = new Button(inspector);
        addObject(button, 390, 300);
        addObject(new Message(), 370,520);
    }

}
