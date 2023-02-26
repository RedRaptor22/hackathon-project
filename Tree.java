import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fence here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Actor
{
    public int Damage = 0;
    /**
     * Act - do whatever the fence wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Damage();
        Health();
        EndGame();
    }
    //increases the damage and removes the zombie
    public void Damage()
    {
       if(isTouching(Zombie.class))
        {
            Damage = Damage + 1;
            removeTouching(Zombie.class);
        } 
    }
    //changes the image to show how healthy is your defence
    public void Health()
    {
        if(Damage == 1)
        {
            setImage("TreeTrunk1.png");
        }
        if(Damage == 2)
        {
            setImage("TreeTrunk2.png");
        }
        if(Damage == 3)
        {
            setImage("TreeTrunk3.png");
        }
        if(Damage == 4)
        {
            setImage("TreeTrunk4.png");
        }
    }
    //ends the game on the fifth damage
    public void EndGame()
    {
        if(Damage == 5)
        {
            Greenfoot.setWorld(new DiedScreen());
            Greenfoot.stop();
        }
    }
}
