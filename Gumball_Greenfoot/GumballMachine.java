import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.util.List;

/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{
    
    private boolean isQuarter;
    private boolean isFakeQuarter;
    private boolean isPenny;
    private String msg;
    private long lastAdded;
    private int timer;
    private int timer2;
    private long curTime3;
    private Actor coin;
    private Actor quarter;
    private Actor fakeQuarter;
    private Actor penny;
     
    public GumballMachine()
    {
        isQuarter = false;
        isFakeQuarter = false;
        isPenny = false;
        timer = 0;
        timer2 = 0;
        //lastAdded = System.currentTimeMillis();
    }
    /**
     * Act - do whatever the GumballMachine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        removeCoin();// Add your action code here.
    }   
    
    private void removeCoin()
    {
        coin = getOneObjectAtOffset(30, 0, Coin.class);
        if(getWorld().getObjects(Quarter.class).isEmpty())
            return;
        quarter = (Actor)getWorld().getObjects(Quarter.class).get(0);
        if(getWorld().getObjects(FakeQuarter.class).isEmpty())
            return;
        fakeQuarter = (Actor)getWorld().getObjects(FakeQuarter.class).get(0);
        if(getWorld().getObjects(Penny.class).isEmpty())
            return;
        penny = (Actor)getWorld().getObjects(Penny.class).get(0);
        
        if(coin != null)
        {
            if(Greenfoot.mouseDragEnded(coin))
            {
                checkCoinType(coin, quarter, fakeQuarter, penny);//check the coin type
                
                // Remove the Coin
                World world = getWorld();
                world.removeObject(coin);
                
                // Remove the existing mesage and Add a new message
                msg = "Have Coin. \n Please click the button";
                removeAddMessage(msg);
                
            }
        }
    }
    
    private void checkCoinType(Actor coin, Actor quarter, Actor fakeQuarter, Actor penny)
    {
        if(coin == quarter)
        {
            isQuarter = true;
            checkCoinQuarter(); 
        }
        if(coin == fakeQuarter)
        {
            isFakeQuarter = true;
            checkCoinFakeQuarter();
        }
        if(coin == penny)
        {
            isPenny = true;
            checkCoinPenny();
        }
    }
    
    public boolean checkCoinQuarter()
    {   
        return isQuarter;
    }
    
    public boolean checkCoinFakeQuarter()
    {   
        return isFakeQuarter;
    }
    
    public boolean checkCoinPenny()
    {   
        return isPenny;
    }
    
    protected void removeAddMessage(String msg)
    {
        if(getWorld().getObjects(Message.class).isEmpty())
            return;
        Actor existingMessage= (Actor)getWorld().getObjects(Message.class).get(0);
        World world = getWorld();
        world.removeObject(existingMessage);
        // Add a new message
        Message message = new Message(msg);
        world.addObject(message, 370, 520);
    }
    
}
