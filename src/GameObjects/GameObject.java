/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import gaberun2.GabeRun2;

/**
 *
 * @author Gabe
 */
public abstract class GameObject {
    //Position in 3D space:
    protected double pX,pY;
    //Width and Height of object
    protected double width, height;
    //Speed of object
    protected double speed;
    //Should object be rendered or considered:
    protected boolean isActive = true;
    //Used to tell if object is frozen:
    
    /**
     * @param pX
     * @param pY
     * @param width
     * @param height
     * @param speed 
     */
    public GameObject(double pX, double pY,double width, double height, double speed){
        this.pX = pX;
        this.pY = pY;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }
    public boolean isCollided(GameObject other){
      if(Math.abs(this.pX-other.pX)<=(this.width/2)+(other.width/2) && Math.abs(this.pY-other.pY)<=(this.height/2)+(other.height/2)){
          return true;
      }
      return false;
    }
    /**
     * Adds tollerance for collision
     * @param other
     * @param tolX
     * @param tolY
     * @return 
     */
    public boolean isCollided(GameObject other, double tolX,double tolY){
      if(Math.abs(this.pX-other.pX-tolX)<=(this.width/2)+(other.width/2) && Math.abs(this.pY-other.pY-tolY)<=(this.height/2)+(other.height/2)){
          return true;
      }
      return false;
    }
    
    
    /**
     * THIS IS BROCKEN!!!
     * @deprecated 
     * @param x
     * @param y
     * @return 
     */
    public boolean isCollided(double x, double y){
      if(Math.abs(this.pX-x)<= this.width && Math.abs(this.pY-y)<=this.height){
          return true;
      }
      return false;
    }
      
    /**
     * Set X position of Object
     * @param pX 
     */
    public void setpX(double pX){
        this.pX = pX;
    }
    /**
     * Get X position of Object
     * @param pX 
     */
    public double getpX(){
        return pX;
    }
    /**
     * Set Y position of Object
     * @param pY 
     */
    public void setpY(double pY){
        this.pY = pY;
    }
    /**
     * Get Y position of Object
     * @param pY 
     */
    public double getpY(){
        return pY;
    }
    /**
     * Returns Height of Object
     * @return 
     */
    public double getHeight(){
        return height;
    }
    /**
     * Returns Width of Object
     * @return 
     */
    public double getWitdh(){
        return width;
    }
    public void setSize(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double getSpeed(){
        return speed;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    //Seperate into setter and getter or override?
    public boolean isAlive(){
        return this.isActive;
    }
    public void setActive(boolean alive){
        this.isActive = alive;
    }
    /**
     * Sets position of Object to position
     * @param posX
     * @param posY 
     */
    public void setPos(double posX, double posY){
        this.pX = posX;
        this.pY = posY;
    }
    /**
     * Relatively moves object by amount (Adjusted for y-down)
     * @param x
     * @param y 
     */
    public void move(double x,double y){
        if(pX+x < 570 && pY-y  < 570 && pX+x > 0 && pY-y > 0){
            for(barrier barr : GabeRun2.barriers){
                //If player would collide with barrier dow
               if(this.isCollided(barr,-x,-y))return;
            }
           
        this.pX+=x;
        this.pY -=y;
        
       }
    }
    public void reset(double x,double y){
        this.setPos(x, y);
        this.setActive(true);
    }
}
