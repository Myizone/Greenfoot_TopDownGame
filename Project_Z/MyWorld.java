import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int count = 0;
    int spawnSpeed = 10;
    int randomSpawn;
    public  Soldier mainSoldier = new Soldier();
    Counter counter = new Counter();
    Health health = new Health();
    Weapon weapon = new Weapon(counter);
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
      super(1000, 800, 1); 
      mainSoldier = new Soldier(weapon);
      addObject(mainSoldier, getWidth()/2, getHeight()/2);
      addObject(counter, 130,100);
      addObject(health, mainSoldier.getX() - 5, mainSoldier.getY() - 50);
      addObject(weapon, 900,100);
    }
    
    public Soldier getSoldier()
    {
        return mainSoldier;
    }
    public void act()
    {
        count++;
        spawnZombies();
    }
    public void spawnZombies()
    {
        if (count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber (8);
            switch(randomSpawn){
                case 0 : addObject(new Zombie(mainSoldier, counter), 0, 0);
                case 1 : addObject(new Zombie(mainSoldier, counter), getWidth()/2, 0); break;
                case 2 : addObject(new Zombie(mainSoldier, counter), getWidth(), 0); break;
                case 3 : addObject(new Zombie(mainSoldier, counter), 0, getHeight()/2); break;
                case 4 : addObject(new Zombie(mainSoldier, counter), getWidth(), getHeight()/2); break;
                case 5 : addObject(new Zombie(mainSoldier, counter), 0, getHeight()); break;
                case 6 : addObject(new Zombie(mainSoldier, counter), getWidth()/2, getHeight()); break;
                case 7 : addObject(new Zombie(mainSoldier, counter), getWidth(), getHeight()); break;
            }
        }
    }
}
