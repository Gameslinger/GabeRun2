/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects.portalPair;

import GameObjects.GameObject;
import javafx.scene.paint.Color;

/**
 *
 * @author Gabe
 */
public class Portal extends GameObject {

    //TODO: Portal to teleport objects
    //Colors Blue orange
    double xLink, yLink;
    Color clr;
    
    //Time miliseconds until portal can be reused
    int coolDown = 60;
    int timeLeft=0;

    public Portal(Color clr) {
        super(Math.random() * 550 + 20, Math.random() * 550 + 20, 30, 45, 0);
        this.clr = clr;
    }

    public void setLink(double pX, double pY) {
        this.xLink = pX;
        this.yLink = pY;
    }

    public void teleport(GameObject obj) {
            obj.setPos(this.xLink, this.yLink);
    }

    public int getTime() {
        return this.timeLeft;
    }

    public Color getColor() {
        return this.clr;
    }

    public void decTime() {
        this.timeLeft--;
    }

    public void resetTime() {
        this.timeLeft = coolDown;
    }
}
