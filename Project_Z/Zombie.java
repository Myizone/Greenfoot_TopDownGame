import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int animateImage = 0;
    int animateSpeed = 5;
    int count;
    int health = 1;
    Soldier soldier;
    Counter counter;
    public Zombie(Soldier mainSoldier,Counter counter)
    {
        this.counter = counter;
        soldier = mainSoldier;
        setImage("skeleton-idle_16.png");
        getImage().scale(45,45);
    }
    public void act()
    {
        count++;
        animate();
        moveAround();
        hitByProjectile();
    }
    public void animate()
    {
        if(count % animateSpeed == 0)
        {
            if(animateImage > 16){
            animateImage = 0;
            }
            setImage("skeleton-move_" + animateImage + ".png");
            animateImage++;
            getImage().scale(50,50);
        }
    }
    public void moveAround()
    {
        move(1);
        turnTowards(soldier.getX(), soldier.getY());
    }
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        if(health == 0)
        {
            counter.score++;
            counter.point+=5;
            getWorld().removeObject(this);
        }
    }
}
