/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects.GUI;

import GameObjects.GameObject;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author Gabe
 */
public class GUIObject extends GameObject{
        private Color color, backC;
        int size;
        String text;
    public GUIObject(String txt,double pX, double pY, double width, double height,int size, Color txtC, Color backC) {
        super(pX, pY, width, height, 0);
        this.color = txtC;
        this.backC = backC;
        this.text = txt;
        this.size = size;
    }
    public Color getTextColor(){
        return this.color;
    }
    public Color getBackColor(){
        return this.backC;
    }
    public void setTextColor(Color clr){
        this.color = clr;
    }
    public void setBackColor(Color Bclr){
        this.backC = Bclr;
    }
    public int getSize(){
        return this.size;
    }
    public void setSize(int size){
        this.size=size;
    }
   
}
