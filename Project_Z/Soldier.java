import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldier extends Actor
{
    /**
     * Act - do whatever the Soldier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 3;
    int time = 0;
    Weapon weapon;
    int superTimer;
    public Soldier()
    {
        
    }
    public Soldier(Weapon weapon)
    {
        this.weapon = weapon;
    }
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        hitByZombie();
    }
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() !=null)
            turnTowards(Greenfoot.getMouseInfo().getX() ,Greenfoot.getMouseInfo().getY());
    }
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("w"))
            setLocation(getX(), getY() - speed);
        if(Greenfoot.isKeyDown("a"))
            setLocation(getX() - speed, getY());
        if(Greenfoot.isKeyDown("s"))
            setLocation(getX(), getY() + speed);
        if(Greenfoot.isKeyDown("d"))
            setLocation(getX() + speed, getY());
    }
    public void fireProjectile()
    {
        if(Greenfoot.mousePressed(null) && weapon.weaponUpgrade == 1)
        {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            projectile.move(25);
            Greenfoot.playSound("Shooti.wav");
        }
        if(Greenfoot.mousePressed(null) && weapon.weaponUpgrade == 2)
        {
            Projectile projectile= new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 10);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(20);
            Greenfoot.playSound("Shooti.wav");
        }
        if(Greenfoot.mousePressed(null) && weapon.weaponUpgrade == 3)
        {
            Projectile projectile= new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 10);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(20);
             Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            Greenfoot.playSound("Shooti.wav");
        }
    }
    public boolean hitByZombie()
    {
        Actor zombie = getOneObjectAtOffset(0,0, Zombie.class);
        if(zombie!=null)
        {
            return true;
        }
        else
        return false;
    }
    }