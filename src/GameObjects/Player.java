/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import GameObjects.powerUps.powerUpType;
import gaberun2.GabeRun2;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabe
 */
public class Player extends GameObject{
    int lives = 3;
    int freezeT,superSizeT;
   // boolean freeze,superSize;
    //Should be getters and setters?
    //public List<powerUpType> powers = new ArrayList();
    
    /**
     * 
     * @param pX
     * @param pY
     * @param width
     * @param height
     * @param speed 
     */
    
    public Player(double pX, double pY, double width, double height, double speed) {
        super(pX, pY, width, height, speed);
    }
   public void gotHit(){
       lives--;
   }
   public int getLives(){
       return lives;
   }
   public void setLives(int amount){
       this.lives=amount;
   }
   public int getFreezeT(){
       return freezeT--;
   }
   
   public int getsuperSizeT(){
       return superSizeT;
   }
   public void dincSuperSizeT(){
       superSizeT--;
   }
   public void incLife(){
       this.lives += 1;
   }
   public void setFreezeT(int T){
       freezeT = T*60;
   }
   public void setSuperSizeT(int T){
       superSizeT = T*60;
       this.setSize(60,60);
      // this.superSize = true;
   }

    public void resetAbilities() {
      //  freeze=false;
        freezeT = 0;
       // superSize = false;
        superSizeT = 0;
    }

    public void tickAbilities() {
       //DECREMENT ABILITIES NOW OR WHEN YOU TRY AND GetAcess 
    }
}
