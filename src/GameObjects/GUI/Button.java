/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects.GUI;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

/**
 *
 * @author Gabe
 */
public class Button extends GUIObject{
    //Holds all instanciated buttons:
    public static List<Button> buttons = new ArrayList();
    //TODO: when mouse clicks within button call this function
    public static void onclick(double x, double y){
        for(Button btn : buttons){
            if(btn.isCollided(x, y)){
                btn.onPush();
            }
        }
    }

    public Button( String text,double pX, double pY,int size,Color txtC, Color backC) {
        super(text,pX, pY, size*12, size/12*text.length(),size,txtC,backC);
        buttons.add(this);
        
    }
    
    public void onPush(){
        
    }
    
}
