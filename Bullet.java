import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public GreenfootImage[] BulletImages = new GreenfootImage[8];
    public int currImg = 0;
    public static final int Speed = 10;
    public int delay = 0;
    
    public int bulletVelocity = 0;
    public int distance = 0;
    //Stores the images and decreases the the scale making it look like its getting distance
    public Bullet()
    {
        
       for(int i = 0; i < BulletImages.length; i++)
        {
            distance++;
            BulletImages[i] = new GreenfootImage("bullet"+i+".png");
            BulletImages[i].scale(20/distance,20/distance);
        }
        setImage(BulletImages[0]);
    }
    public void act() 
    {
        rot();
        move();
        remove();
        Animate();
    }
    //rotating the image to move it up
    public void rot()
    {
        
        setRotation(90); 
    }
    //moves and then slows down to make is realistic
    public void move()
     {
        bulletVelocity++;
       move(-20/bulletVelocity);
       
     }
    
    public void remove()
    {
      if(bulletVelocity == 25)
      {
          move(-500);
        }
       if( isAtEdge() )
      {
          World w = getWorld();
          w.removeObject(this);
        } 
    } 
    
    public void Animate()
    {
        delay = delay + 1;
       if(delay == Speed)
       {
           currImg = currImg + 1;
           if(currImg >= BulletImages.length)
            
           {
              currImg = 0; 
           }
           setImage(BulletImages[currImg]);   
           delay = 0;
        }
       
    }
    
}
