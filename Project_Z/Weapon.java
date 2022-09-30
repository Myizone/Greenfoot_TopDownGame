import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Counter counter;
    int weaponUpgrade = 1;
    public Weapon(Counter counter)
    {
        this.counter = counter;
        setImage(new GreenfootImage("Weapon \n Upgrade ", 25, Color.BLACK, new Color (0,0,0,0)));
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this) && counter.point > 149)
        {
            counter.point -= 150;
            weaponUpgrade++;
        }
    }
}
