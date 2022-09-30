import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 50;
    public Health()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0, 0, 52, 12);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
    }
    public void act()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0, 0, 52, 12);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getSoldier().getX() - 5, myWorld.getSoldier().getY()-50);
        loseHealth();
    }
    public void loseHealth()
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if(myWorld.getSoldier().hitByZombie())
        {
            health--;
        }
        if(health<=0)
        {
            
            getWorld().showText(" Game Over \n You Survived for " + (myWorld.getSoldier().time/60) + " seconds ", getWorld().getWidth()/2 , getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
