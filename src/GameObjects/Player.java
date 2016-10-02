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
public class Player extends GameObject {
    int lives = 3;
    private int freezeT, superSizeT, invT;
   // boolean freeze,superSize;
    //Should be getters and setters?
    //public List<powerUpType> powers = new ArrayList();
    private int superSpeedT;
//    //Only boost once:
//    boolean boost = false;
//    //Normal speed before boost:
//    double nSpeed = 0;

    /**
     * Constructs player Object
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

    /**
     * Decreases players life
     */
    public void gotHit() {
        lives--;
    }

    /**
     * returns amount of lives
     *
     * @return
     */
    public int getLives() {
        return lives;
    }

    /**
     * Sets amount of lives
     *
     * @param amount
     */
    public void setLives(int amount) {
        this.lives = amount;
    }

    /**
     * Returns time left on freeze ability
     *
     * @return
     */
    public int getFreezeT() {
        return freezeT;
    }

    /**
     * Decreases freeze count by one
     */
    public void decFreezeT() {
        this.freezeT--;
    }
    /**
     * Gets time left for invisible ability
     * @return 
     */
    public int getInvT(){
        return this.invT;
    }
    /**
     * De-increments time left on inv ability
     */
    public void decrementInvT(){
        this.invT--;
    }
    /**
     * Sets time of inv ability
     * @param invT 
     */
    public void setInvT(int invT){
        this.invT = invT*60;
    }
    /**
     * Sets time left on super speed ability
     * @param superSpeedT 
     */
    public void setSuperSpeedT(int superSpeedT){
        this.superSpeedT = superSpeedT*60;
        this.boost = 2;
    }
    /**
     * Returns super speed time
     * @return 
     */
    public int getSuperSpeedT(){
        return this.superSpeedT;
    }
    /**
     * De-increments time of speed ability
     */
    public void decSuperSpeedT(){
        this.superSpeedT--;
    }
    /**
     * Gets time left on super size ability
     *
     * @return
     */
    public int getsuperSizeT() {
        return this.superSizeT;
    }

    /**
     * De-increments time left on super size
     */
    public void dincSuperSizeT() {
        this.superSizeT--;
    }

    /**
     * Decreases player life by one
     */
    public void incLife() {
        this.lives += 1;
    }

    /**
     * Sets time on freeze ability
     *
     * @param T
     */
    public void setFreezeT(int T) {
        freezeT = T * 60;
    }

    /**
     * Sets super size ability time
     *
     * @param T
     */
    public void setSuperSizeT(int T) {
        superSizeT = T * 60;
        this.setSize(60, 60);
        // this.superSize = true;
    }
    
    /**
     * Resets ability times
     */
    public void resetAbilities() {
        //  freeze=false;
        freezeT = 0;
        // superSize = false;
        superSizeT = 0;
        
        superSpeedT = 0;
      
    }

//    public void superSpeed() {
//        if(!this.boost){
//            this.boost=true;
//            this.setSpeed(this.getSpeed()*2);
//            nSpeed = this.getSpeed();
//        }
//    }
//    public void setBoost(boolean toggle){
//        this.boost = toggle;
//    }//TODO: fix boost speed and timer
//
//    public double getNSpeed() {
//        return this.nSpeed;
//    }

}
