/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameUtils;

import GameObjects.*;
import GameObjects.GUI.Button;
import GameObjects.powerUps.PowerUp;
import GameObjects.powerUps.powerUpType;
import gaberun2.GabeRun2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
/**
 *
 * @author Gabe
 */
public class Draw {
    //Have Images for Objects?
    //TODO make colors independent of draw:
    static Color Background = Color.GRAY;
    static Color PlrColor = Color.BLUE;
    static Color EnemyColor = Color.RED;
    static Color CoinColor = Color.YELLOW;
    static GraphicsContext gs = GabeRun2.gs;
    static Color BarrierColor = Color.BLACK;
    static Color GUIColor = Color.WHITE;
    
    public static void write(String write, Color clr, double x, double y ){
        Color before = (Color) gs.getFill();
        gs.setFill(clr);
        gs.setFont(Font.font("Cursive", FontWeight.BOLD, 72));
        gs.fillText(write, x, y);
        gs.setFill(Color.BLACK);
        gs.strokeText(write, x, y );
        gs.setFill(before);
    }
    public static void write(String write, Color clr, double x, double y, int size){
        Color before = (Color) gs.getFill();
        gs.setFill(clr);
        gs.setFont(Font.font("Cursive", FontWeight.BOLD, size));
        gs.fillText(write, x, y);
        gs.setFill(Color.BLACK);
        gs.strokeText(write, x, y);
        gs.setFill(before);
    }
    
    public static void enemy(Enemy enm){
        gs.setFill(EnemyColor);
        gs.fillOval(enm.getpX(), enm.getpY(),enm.getWitdh(), enm.getHeight());
        gs.setFill(Background);
    }
    public static void barrier(barrier brr){
        gs.setFill(BarrierColor);
        gs.fillRect(brr.getpX(), brr.getpY(),brr.getWitdh(), brr.getHeight());
        gs.setFill(Background);
    }
    public static void coin(Coin coin){
        gs.setFill(CoinColor);
        gs.fillOval(coin.getpX(), coin.getpY(),coin.getWitdh(), coin.getHeight());
        gs.setFill(Background);
    }
    public static void player(Player plr){
     
        gs.setFill(PlrColor);
        //If player is invisable draw outline
        if(plr.getInvT()>=0){
        gs.strokeOval(plr.getpX(), plr.getpY(),plr.getWitdh(), plr.getHeight());
        }else{
        gs.fillOval(plr.getpX(), plr.getpY(),plr.getWitdh(), plr.getHeight());
        }
        gs.setFill(Background);
    }
    public static void clear(){
        gs.setFill(Background);
        //TODO: make dynamic for screen size:
        gs.fillRect(0, 0, 600, 600);
    }
    public static void powerUp(PowerUp pwr){
        gs.setFill(pwr.getColor());
        gs.fillOval(pwr.getpX(), pwr.getpY(),pwr.getWitdh(), pwr.getHeight());
        gs.setFill(Background);
    }
    /**
     * Draws Heads up:
     * @param lives
     * @param time
     * @param coins
     * @param level 
     */
    public static void headsUp(Player plr, long time, int coins,int level){
        Draw.write("Lives: "+plr.getLives(), Color.GREEN, 20, 20,30);
        Draw.write("Coins: "+coins,Color.GREEN,20,45,30);
        Draw.write("Level: "+level, Color.GREEN, 20, 70, 30);
        //TODO Draw powers of player!?!?!
       
    }
    public static void buttons(){
        for(Button btn : Button.buttons){
            gs.setFill(btn.getBackColor());
            gs.fillRoundRect(btn.getpX(), btn.getpY()-btn.getHeight(), btn.getWitdh(), btn.getHeight(), 40, 40);
            gs.setFill(btn.getTextColor());
            Draw.write("Game Over", btn.getBackColor(), btn.getpX(), btn.getpY(),btn.getSize());
        }//FINISH BUTTON RENDERING AND PUSHING!!!!
    }
    public static void menu(){
        Draw.clear();
        gs.drawImage(GabeRun2.gabe, 200, 120);
        Draw.write("Gabe Run 2", GUIColor, 150, 100,50);
        Draw.write("Press W or Up to start",GUIColor,150,300,25);
        //TODO: Draw High scores?
    }
    
}
