import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    public GreenfootImage[] MovingImages = new GreenfootImage[81];
    public int currImg= 0;
    public static final int Speed = 6;
    public int delay = 0;
    
    
    public int distance = 0;
    
    public int removeTimer = 25;
    //storing the pics for zombie
    public Zombie()
    {
        
        for(int i = 0; i < MovingImages.length; i++)
        {
            distance++;
            MovingImages[i] = new GreenfootImage("frame_"+i+"_delay-0.03s.png");
            MovingImages[i].scale(25+distance,25+distance);
            }
        setImage(MovingImages[0]);
        
    }
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        remove();
        Animate();
        
    } 
    
    public void remove()
    {
      //if touching bullet then it activates the timer which lowers the zombies health gitting
      //it a poison bullet affect
         if(isTouching(Bullet.class) )
      {
         
         removeTimer--;
      }  
      //if removetimer hits 0 it makes the zombie die
        if(removeTimer == 0)
      {
          World w = getWorld();
          w.removeObject(this);
          removeTimer = 100;
        }
       
    }
    //playing the pics of zombies which were stored, to animate it.
    public void Animate()
    {
       delay = delay + 1;
        if(delay == Speed)
       {
           currImg = currImg + 1;
           if(currImg >= MovingImages.length)
            
           {
              currImg = 0; 
           }
           setImage(MovingImages[currImg]);   
           delay = 0;
        }
       
    }
    
}
