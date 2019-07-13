/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GL;

/**
 *
 * @author Alison
 */
public class Teclado implements KeyListener {

    static GL gl;

    public Teclado() {
        
    }
    
    public static boolean validarFaro=false;

    private static float trasladaX = -6.5f*Proyecto.ancho/16;
    private static float trasladaY = 0;
    private static float trasladaZ =Proyecto.largo/2.2f;

    private static float escalaX = 1;
    private static float escalaY = 1;

    private static float rotarX = 0;
    private static float rotarY = 0;
    private static float rotarZ = 0;

    private static float trasladar=0;

    public static float getTrasladar(){
        return trasladar;
    }
    
    public static float getTrasladaX() {
        return trasladaX;
    }

     public static void setTrasladaX(float t) {
       trasladar=t;
    }
     
    public static float getTrasladaY() {
        return trasladaY;
    }

    public static float getTrasladaZ() {
        return trasladaZ;
    }

    public static float getRotarX() {
        return rotarX;
    }

    public static void trasladarZ(GL gl){
        trasladar+=0.05f;
        gl.glTranslatef(0,0,trasladar);
      
        
        //System.out.println(trasladar);
    }
    
    public static void rotarY(GL gl) {
        rotarY += 5.0f;
        gl.glRotatef(rotarY, 0, 1, 0);
    }
    
     public static void rotarY(GL gl,float ang) {
        rotarY += ang;
        gl.glRotatef(rotarY, 0, 1, 0);
    }
     
    public static void rotarZ(GL gl) {
        rotarZ += 5.0f;
        gl.glRotatef(rotarZ, 0, 0, 1);
    }
    
        public static void rotarZ(GL gl,float ang) {
        rotarZ += ang;
        gl.glRotatef(rotarZ, 0, 0, 1);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
             if (e.getKeyChar() == '1') {
                 System.out.println("Cámara 1");
            Proyecto.ncam = 1;
            
        }

        if (e.getKeyChar() == '2') {
            System.out.println("Cámara 2");
            Proyecto.ncam = 2;
        }
        
        if (e.getKeyChar() == '3') {
            System.out.println("Cámara 3");
            Proyecto.ncam = 3;
        }
        
        if (e.getKeyChar() == '4') {
            System.out.println("Cámara 4");
            Proyecto.ncam = 4;
        }
        
         if (e.getKeyChar() == '5') {
            System.out.println("Cámara 5");
            Proyecto.ncam = 5;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_W) {
                if (trasladaZ<0.76f &&trasladaZ>-2.78f && trasladaX<6f) {
                    trasladaZ=trasladaZ;
                }else if (trasladaZ<-7.23f && trasladaZ>-7.5f && trasladaX>0.65f) {
                     trasladaZ=trasladaZ;
                }else if (trasladaZ<-7.23f && trasladaZ>-7.5f && trasladaX<0.41f) {
                     trasladaZ=trasladaZ;
                }else{
                    trasladaZ-=0.05f;
                }
                
                System.out.println(""+trasladaZ);
            }
            if (e.getKeyCode()==KeyEvent.VK_S) {
                if (trasladaZ>=6.86f ) {
                    trasladaZ=trasladaZ;
                }else if (trasladaZ>3.45f && trasladaX>-6.11f ) {
                    trasladaZ=trasladaZ;
                }else{
                    trasladaZ+=0.05f;
                }
                
                System.out.println(""+trasladaZ);
            }
            if (e.getKeyCode()==KeyEvent.VK_A) {
                
                if (trasladaX<-9.26f) {
                    trasladaX=trasladaX;
                }else if (trasladaX<6.18f && trasladaZ<0.76f &&trasladaZ>-2.78f) {
                    trasladaX=trasladaX;
                }else{
                    trasladaX-=0.05f;
                }
                
                System.out.println(""+trasladaX);
            }
            if (e.getKeyCode()==KeyEvent.VK_D) {
                
                if (trasladaX>9.08f) {
                    trasladaX=trasladaX;
                }else if (trasladaX>-6.11f && trasladaZ>3.5f) {
                    trasladaX=trasladaX;
                }else{
                trasladaX+=0.05f;    
                }
                
                System.out.println(""+trasladaX);
            }
            
            
            if (e.getKeyCode()==KeyEvent.VK_UP) {
                trasladaY+=0.05f;
            }
            
            if (e.getKeyCode()==KeyEvent.VK_DOWN) {
                trasladaY-=0.05f;
            }
            
       
        salir(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    public void salir(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

}
