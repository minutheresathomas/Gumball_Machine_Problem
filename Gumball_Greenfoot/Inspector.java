import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{
    private boolean isClicked;
    private boolean isQuarter;
    private boolean isFakeQuarter;
    private boolean isPenny;
    private int chooseAlien;
    private String validMessage;
    private String msgScreen;
    private GumballMachine gmCoinType;
    private RandomPicker randomPicker;
    private GreenPicker greenPicker;
    
    public Inspector(GumballMachine insertedCoin, RandomPicker randomAlien, GreenPicker greenAlien)
    {
        gmCoinType = insertedCoin;
        randomPicker = randomAlien;
        greenPicker = greenAlien;
        GreenfootImage image = getImage() ;
        image.scale( 160, 160 ) ;
    }
    
    public Inspector()
    {
         
    }
    /**
     * Act - do whatever the Inspector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      
    }
    
    public void checkCoinValidity()
    {
        
        isQuarter = gmCoinType.checkCoinQuarter();
        isFakeQuarter = gmCoinType.checkCoinFakeQuarter();
        isPenny = gmCoinType.checkCoinPenny();
        msgScreen = "Invalid coin.Try again !";
            // check if it is a quarter
            if(isQuarter)
            {
                Greenfoot.delay(65);
                validMessage = "Valid Coin";
                addMsg(validMessage);
                // select the pickers randomly
                pickAlien();
            }
            if(isFakeQuarter)
            {
                Greenfoot.delay(65);
                validMessage = "Invalid quarter";
                addMsg(validMessage);
                // Return coin
                returnFakeCoin();
                remAddMessageScreen(msgScreen);
            }
            if(isPenny)
            {
                Greenfoot.delay(65);
                validMessage = "It's a Penny.";
                addMsg(validMessage);
                // Return coin
                returnPenny();
                remAddMessageScreen(msgScreen);
            }
    }
    
    private void addMsg(String txt)
    {
       World world = getWorld();
       // Add a new message
       Message message = new Message(txt);
       world.addObject(message, 628, 164);
       Greenfoot.delay(60);
       
       // remove message after some some time
       getWorld().removeObject(message);
       Greenfoot.delay(10);
    }
    
    private void returnFakeCoin()
    {
        FakeQuarter fQuarter = new FakeQuarter();
        getWorld().addObject(fQuarter, 370, 460);
        Greenfoot.delay(80);
        Greenfoot.setWorld(new GumballWorld());
    }
    
    private void returnPenny()
    {
        Penny fPenny = new Penny();
        getWorld().addObject(fPenny, 370, 460);
        Greenfoot.delay(60);
        Greenfoot.setWorld(new GumballWorld());
    }
    
    private void pickAlien()
    {
        chooseAlien = Greenfoot.getRandomNumber(1);
        msgScreen = "Enjoy your Gumball! \n Thank you.";
        switch(chooseAlien)
        {
            case 0 : randomPicker.pickRandomGumball();
                     // Add message and Wooha
                     remAddMessageScreen(msgScreen);
                     Message message = new Message("Wooha!");
                     getWorld().addObject(message, 905, 60);
                     Greenfoot.delay(60);
                     Greenfoot.setWorld(new GumballWorld());
                     break;
            case 1 : greenPicker.pickGreen();
                     remAddMessageScreen(msgScreen);
                     Message message1 = new Message("Wooha!");
                     getWorld().addObject(message1, 905, 360);
                     Greenfoot.delay(60);
                     Greenfoot.setWorld(new GumballWorld());
                     break;
        }
    }
    
   private void remAddMessageScreen(String msg)
   {
       if(getWorld().getObjects(Message.class).isEmpty())
            return;
        Actor existingMessage= (Actor)getWorld().getObjects(Message.class).get(0);
        World world = getWorld();
        world.removeObject(existingMessage);
        // Add a new message
        Message message = new Message(msg);
        world.addObject(message, 370, 540);
   }
}
