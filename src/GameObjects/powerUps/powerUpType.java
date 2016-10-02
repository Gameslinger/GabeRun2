/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects.powerUps;

import java.util.List;
import javafx.scene.paint.Color;


/**
 *
 * @author Gabe
 */
public enum powerUpType {
    //superSpeed, DuoPlr
     Freeze,lifeUp,superSize,inv,superSpeed;
    int time = -1;
    /**
     * Constructs power ups without time ex: lifeUp
     */
    powerUpType(){
        
    }
    /**
     * constructs power up with set time
     * @param time 
     */
    powerUpType(int time){
        this.time = time * 60;
    }
    
  /**
   * Number of constants in class
   */
 public static int length = powerUpType.values().length;
 /**
  * static list of all values
  */
 public static powerUpType[] vals = powerUpType.values();
 
 public static powerUpType getRandType(){
     int typeNum = (int)( Math.random() * (powerUpType.length));
     
     //Length is not 0 based:
     return vals[typeNum];
 }
 public boolean isTimeOut(){
     //Skip if it has no time limit
     if(this.time != -1){
         //If time is out remove else decrement time:
         if(this.time <= 0){
             return true;
         }else{
             this.time--;
             
         }
     }
    
     return false;
 }
    public static Color getColor(powerUpType type) {
        switch (type) {
            case Freeze:
                return Color.LIGHTBLUE;
            case superSize:
                return Color.LIGHTCORAL;
            case lifeUp:
                return Color.LIGHTGREEN;
            case inv:
                return Color.BLUEVIOLET;
            case superSpeed:
                return Color.AQUAMARINE;
            default:
                return Color.PURPLE;
        }
        
    }
    public void setTime(int time){
        this.time = time;
    }
}
