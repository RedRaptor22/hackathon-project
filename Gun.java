import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Actor
{
    
    public int ammo = 8;
    public int reloadTime = 0;
    public int reservedAmmo = 48;
    public int fireCheck = 0;
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       Right(); 
       Left();
       shoot();
       reload();
       fired();
       munationBox();
    } 
    //fires the gun
    public void shoot()
    {
        
        if(ammo >= 1 && reservedAmmo >= 0 &&"f".equals(Greenfoot.getKey()))
        {
            ammo = ammo - 1;
            fire ();
            fireCheck = fireCheck + 1;
            
        }
        getWorld().showText("Ammo: " + ammo+"/" + reservedAmmo, 500, 600);
    }
    //if fired then the muzzel flash shows
    public void fired()
    {
        if(fireCheck == 1)
        {
           setImage("Gun0Fired.png"); 
           fireCheck = 0;
           Greenfoot.playSound("shot.mp3");
        }
        else
        {
            setImage("Gun0.png"); 
        }
        
    }
    //reloads the gun if the ammo is 0
    public void reload()
    {
        if(ammo == 0)
        {
            reloadTime++;
            getWorld().showText("Reloading... ", 300, 400);
        }
    
        if(reservedAmmo == 0)
        {
            reservedAmmo = 0;
            
        }
        if(reloadTime == 90 && reservedAmmo >= 0)
        {
            ammo = 8;
            reloadTime = 0;
            reservedAmmo = reservedAmmo - ammo;
            
        }
        
    }
    //moves right
     public void Right()
    {
        if(Greenfoot.isKeyDown("d"))
        {
           move(5);
        }
    }
    //moves left
    public void Left()
    {
        if(Greenfoot.isKeyDown("a"))
        {
           move(-5);
        }
    }
    // adds bullet to the world
    private void fire()
     {
         Bullet bullet = new Bullet();
         getWorld().addObject(bullet, getX(), getY()-150);
      }
    
    //Increases the reserved ammo by 16 more bullets
    public void munationBox()
    {
        if(isTouching(munationBox.class))
        {
         reservedAmmo = reservedAmmo + 16; 
         removeTouching(munationBox.class);
        }
    }
    
    
    }

