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
public class Coin extends GameObject{
    
    public Coin() {
        super(Math.random() * 550 + 20,Math.random() * 550 + 20,30,30,0);
    }
    public void reset(){
        this.pX =Math.random() * 550 + 20;
        this.pY = Math.random() * 550 + 20;
        
        this.setActive(true);
    }
}
