/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects.portalPair;

import javafx.scene.paint.Color;

/**
 *
 * @author Gabriel.Maxfield
 */
public class PortalPair {

    //Creates two portals with link to both
    Portal portal1, portal2;

    public PortalPair() {
        portal1 = new Portal(Color.BLUE);
        portal2 = new Portal(Color.ORANGE);
        link(portal1, portal2);
    }

    private void link(Portal portal1, Portal portal2) {
        portal1.setLink(portal2.getpX(), portal2.getpY());
        portal2.setLink(portal1.getpX(), portal1.getpY());
    }

    public Portal getPortal1() {
        return portal1;
    }

    public Portal getPortal2() {
        return portal2;
    }
}
//Add portal update to game loop!!!
//Test?
