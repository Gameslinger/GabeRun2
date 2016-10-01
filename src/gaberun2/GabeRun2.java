/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaberun2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import GameObjects.*;
import GameObjects.powerUps.*;
import GameUtils.Draw;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

/**
 * @author Gabe
 */
public class GabeRun2 extends Application {
    //Canvas and Graphics Context to render on
    Canvas canvas;
    //Graphics context to draw to:
    public static GraphicsContext gs;
    
    //List of enemies, coins, FIX->barriers, and PowerUp:
    public static List<Enemy> enemies;
    public static  List<Coin> Coins;
    public static List<barrier> barriers;
    public static List<PowerUp> powers;
     //list of all game Objects:
    
    //Player Object
    public static Player plr;
    //Which directions to move in:
     boolean up,down,left,right = false;
     //Is game Paused
     boolean paused = false;
     //Did player run out of lives and game is over:
     boolean gameOver = false;
     //Current level
     int lvl = 0;
     //Remaining coins
     int coinCount = 0;
     
     long sTime,mTime = 0;
     
     @Override
     public void init(){
         //Initialize all lists:
         enemies = new ArrayList();
         Coins = new ArrayList();
         barriers = new ArrayList();
         powers = new ArrayList();
         
         
     }
    @Override
    public void start(Stage stage) {
        
         canvas = new Canvas(600,600);
        gs = canvas.getGraphicsContext2D();
        
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        
        //Set background color:
        Scene scene = new Scene(root, 600, 600,Color.GRAY);
        
        stage.setTitle("Gabe Run 2 - Go for as long as you want! If you Can!");
        stage.getIcons().add(new Image("/Images/icon32x32.png"));
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        //Set Key Binds:
       //Key Pressed
         scene.setOnKeyPressed((event)->{
       //  if(plr.getPlay()){
        if(event.getCode()==KeyCode.W){
            up = true;
          //  start = true;
        }
        
        if(event.getCode()==KeyCode.S)down=true;
        if(event.getCode()==KeyCode.A)left=true;
        if(event.getCode()==KeyCode.D)right=true;
         
        if(event.getCode()==KeyCode.ESCAPE){
          
          if(gameOver){
             gameOver=false; 
             resetLvl();
          }else{
          paused=!paused;
          }
      }
        
        // }
         });
         //Sets any mouse clicks to see if they are on button:
//         scene.setOnMouseDragReleased((event)->{
//             Button.onclick(event.getX(), event.getY());
//         });
         
         //Key Released
         scene.setOnKeyReleased((event)->{
        
        if(event.getCode()==KeyCode.W)up=false;
        if(event.getCode()==KeyCode.S)down=false;
        if(event.getCode()==KeyCode.A)left=false;
        if(event.getCode()==KeyCode.D)right=false;
         
         }); 
         //Player Object:
        plr = new Player(300,300,30,30,1);
         //Not Complete fix collision error!!
         //barriers.add(new barrier(350, 350, 50, 50));
        new AnimationTimer(){
        @Override
      public void handle(long miliT) {
         // Draw.buttons();
          mTime++;
          if(mTime>=60){
              mTime = 0;
              sTime++;
          }
          if(coinCount<=0)levelUp();
          //If game is going
          if(!paused && !gameOver){
              
            Draw.clear();
            
            upDatePowerUps();
            upDateCoins();
            upDateEnemies();
            upDatePlayer();
            upDateBarriers();
            
            Draw.headsUp(plr,sTime,coinCount,lvl);
            
            if(plr.getLives()<=0)gameOver=true;
            
          }else if(gameOver){
              Draw.write( "Game Over", Color.RED, 150, 200);
              Draw.write("Press ESC to restart", Color.WHITE, 160, 240,35);

          }else{
              //Game is paused
              
              //TODO: autoCenter string instead of hard coded numbers
              Draw.write("Paused", Color.WHITE, 200, 250);
          }
        }}.start();
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void upDatePlayer(){
        //TODO: Check isAlive?
        if(plr.getsuperSizeT()>=0){
            plr.setSize(60, 60);
            plr.dincSuperSizeT();
        }else{
            plr.setSize(30,30);
        }
        //Moves player:
        if(up)plr.move(0,plr.getSpeed());
        if(down)plr.move(0, -plr.getSpeed());
        if(left)plr.move(-plr.getSpeed(),0);
        if(right)plr.move(plr.getSpeed(),0);
        
         Draw.player(plr);
        //Checks if player should pick up item:
        //plr.tickAbilities();
    }
    
    public void upDateEnemies(){
        
        for(Enemy enm : enemies){
            //If object is not active skip:
            if(!enm.isAlive())continue;
            //Does not move enemies while frozen
            if(!(plr.getFreezeT()>=0)){
            enm.AI(plr);
            }
            if(enm.isCollided(plr,5,5)){
                if(!(plr.getsuperSizeT() >=0)){
                    plr.gotHit();
                }
                enm.reset();
            }else{
                
            }
            Draw.enemy(enm);
        }
    }
    public void upDatePowerUps(){
        for (PowerUp pwr : powers) {
            if (!pwr.isAlive()) {
                continue;
            }
            
            Draw.powerUp(pwr);

            if (pwr.isCollided(plr)) {
                pwr.pickUp();
            }
            
        }
    }
    public void upDateCoins(){
        for(Coin coin : Coins){
             if(!coin.isAlive())continue;
            Draw.coin(coin);
            
            if(coin.isCollided(plr)){
                coin.setActive(false);
                coinCount--;        
            }
        }
    }
    public void upDateBarriers(){
        for(barrier brr : barriers){
            Draw.barrir(brr);
        }
    }
    public void levelUp(){
        lvl++;
        //Reset Player and speeds up 0.5 X lvl + 1
        //plr = new Player(300,300,30,30,1+(0.5*lvl));
        plr.setPos(300, 300);
        plr.setSpeed(plr.getSpeed()+0.2);
        //Adds one enemy every 3 levels:
        //TODO: re-adjust enemy speed 
        if(lvl%2==0 || lvl == 1){
            plr.setLives(plr.getLives()+1);
            enemies.add(new Enemy(0,0,30,30,0.4));
            
        }
        
        //Adds 5 coins every level:
        
        for(int e = 0; e < 5; e++){
                Coins.add(new Coin());
            }
        //Adds power ups:
        powers.clear();
        for(int t = 0; t < 4; t++){
            //TODO: FIX ALL POWER UPS BEING THE SAME TYPE!!
                powers.add(new PowerUp());
        }
        
        //Resets coins and enemies:
        for(Enemy enm : enemies){
            enm.reset(0,0);
            enm.setSpeed(enm.getSpeed()+0.2);
        }
        for(Coin coin : Coins){
            coin.reset();
        }
        //Sets count to amount of coins
        coinCount = lvl*5;
        
    }
    
    /**
     * restart game after game over
     */
    public void resetLvl(){
        enemies = new ArrayList();
        Coins = new ArrayList();
        lvl = 0;
        plr = new Player(300,300,30,30,1);
        plr.resetAbilities();
        levelUp();
    }
    
}
