/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Alison
 */
public class Mouseprueba implements MouseListener,MouseMotionListener {
      static float trasladaZ=0;
      static float trasladaX=0;
    static float trasladaY=0;
    
     int xInicial=0;
     int yInicial=0;
    @Override
    public void mouseClicked(MouseEvent e) {
         System.out.println(""+e.getX());
         if (e.isMetaDown()) {
            trasladaZ+=0.3f;
        System.out.println(""+trasladaZ);        
        }else{
              trasladaZ-=0.3f;
        System.out.println(""+trasladaZ);
         }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
               //Movimiento en X
        if(xInicial > e.getX())
        {
            trasladaX-=0.2f;          
        }

        if(xInicial < e.getX())
        {
            trasladaX+=0.2f;           
        }
        xInicial = e.getX();
        
        //Movimiento en Y
        
        if(yInicial > e.getY())
        {
            trasladaY-=0.2f;          
        }

        if(yInicial < e.getY())
        {
            trasladaY+=0.2f;           
        }
        yInicial = e.getY();
        
        System.out.println(""+trasladaZ);
    }
    
}
