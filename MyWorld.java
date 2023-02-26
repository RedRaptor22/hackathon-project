import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int iter = 0;
    public int rounds = 1;
    public int sec = 0;
    public int delay = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 700, 1); 
        //gun being added to the world
        Gun gun = new Gun();
        addObject(gun,300,600);
        //the fallen tree being added to the world, its there as a defensive barrier
        Tree tree = new Tree();
        addObject(tree,300,470);
        
    }
    public void act()
    {
      spawnZombie();  
      timer();
      delay();
    }
    // this timer is for rounds to increase as it hits 900 for the sec
    public void timer()
    {
      sec++;
      if(sec == 900)
      {
         rounds = rounds + 1; 
         sec = 0;
      }
      
    }
    // delays the spawning of the perks
    public void delay()
    {
        delay++;
        if(delay == 600)
        {
            spawnPerks();
            delay = 0;
        }
        
    }
    //randomly spawns either ammoBox
    public void spawnPerks()
    {
        //80%
        if(Greenfoot.getRandomNumber(100) < 80)
        {
          addObject( new munationBox(),Greenfoot.getRandomNumber(600), 500);
          
        } 
    }
    //spawns zombies per 75 iteration and the required iter decreases when the round increases 
    //making more zombies to spawn in later rounds
    public void spawnZombie()
    {
        timer();
        iter++;
        if( iter == 75 - rounds)
        {
          addObject( new Zombie(),Greenfoot.getRandomNumber(600), 400);
          iter = 0;
        } 
        showText("Round: " + rounds, 100, 100);
    }
}
