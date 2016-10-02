/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

/**
 *
 * @author Gabe
 */
public class Enemy extends GameObject{
    //Weither or not enemy should break off and go to point
    private boolean scatter = false;
    //Scatter position to go to
    private double scatterX, scatterY;
    //Long should it take before entering scatter (Scatter Tollerance)
    private int scatterTol = 20;
    private int currentTol = 0;
    private int scatterTime, scatterTInc=0;
    //Holds miliseconds until checking if obj should enter scatter
   private int miliCount = 0;
   //Corner num: Top left = 1, Top right = 2, Bottom left = 3, Bottom right = 4;
   int cornerNum;
    public Enemy(double pX, double pY, double width, double height, double speed) {
        super(pX, pY, width, height, speed);
        //TODO: Not working
        cornerNum = ((int) Math.random()) * 4 +1;
    }
    /**
     * Resets Enemy to corner based off of random number set at construction
     */
    public void reset(){
        switch (this.cornerNum) {
            case 1:
                this.reset(0, 0);
                break;
            case 2:
                this.reset(600, 0);
                break;
            case 3:
                this.reset(0, 600);
                break;
            case 4:
                this.reset(600, 600);
                break;

        }
    }
    
    public void AI(Player plr){
        //Counts calls as a milisecond time:
           miliCount++;
           
           //Updates second timer about every 60 miliseconds
           if(miliCount>=60){
               //How long should obj persue point before exiting scatter:
               scatterTime+=scatterTInc;
               
               miliCount = 0;
               //Increases randomly every second until it reaches threshold does not inc during scatter:
               if(!scatter && !(plr.getInvT() >= 0))currentTol += (int) (Math.random() * 5) + 1;
               
               if(currentTol >= scatterTol || this.isCollided(scatterX, scatterY)){
                   //Resets count to Tollerance
                  currentTol = 0;
                  //Enters Scatter Mode
                  scatter = true;
                  scatterTInc = 1;
                  //Creates new point to scatter to!
                  scatterX = Math.random() * 580 + 5;
                  scatterY = Math.random() * 580 + 5;
                  
               }
           }
        
        //TODO: Update AI?
        if(scatter || plr.getInvT()>=0){
            if(scatterTime >=5){
                scatter = false;
                scatterTInc = 0;
                scatterTime = 0;
            }
            if(pX < scatterX){
          if(pY < scatterY){
           move(speed,speed);
          }else{
         move(speed,-speed);
          }
        }else{
            if(pY>scatterY){
            move(-speed,speed);
            }else{
                move(-speed,-speed);
            }
        }
        }else{
        if(pX < plr.pX){
          if(pY < plr.pY){
           move(speed,-speed);
          }else{
         move(speed,speed);
          }
        }else{
            if(pY>plr.pY){
            move(-speed,speed);
            }else{
                move(-speed,-speed);
            }
        }
       }
    }
}
