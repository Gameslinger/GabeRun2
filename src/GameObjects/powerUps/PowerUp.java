/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects.powerUps;

import GameObjects.GameObject;
import gaberun2.GabeRun2;
import javafx.scene.paint.Color;

/**
 *
 * @author Gabe
 */
//Should have class for each powerUp or single?
public class PowerUp extends GameObject {
    private Color color;
    powerUpType type;
    
    
    public PowerUp() {
        super(Math.random() * 550 + 20, Math.random() * 550 + 20, 20, 20, 0);
        this.setType();
    }
    public Color getColor(){
        return color;
    }
    public void reset(){
        this.pX =Math.random() * 550 + 50;
        this.pY = Math.random() * 550 + 50;
        this.setType();
        this.setActive(true);
    }
    /**
     * Sets type of power up:
     */
    public void setType(){
        type = powerUpType.getRandType();
        color = powerUpType.getColor(this.type);
        
    }
    /**
     * sets active to false if picked up
     * and applies abilities
     */
    public void pickUp(){
        switch(this.type){
            case Freeze:
                GabeRun2.plr.setFreezeT(5);
                break;
            case superSize:
                GabeRun2.plr.setSuperSizeT(5);
                break;
            case lifeUp:
                GabeRun2.plr.incLife();
                break;
            case inv:
                GabeRun2.plr.setInvT(3);
        }
        this.setActive(false);
    }
    
   
}
