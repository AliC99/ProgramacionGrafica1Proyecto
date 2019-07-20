/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.util.ArrayList;
import javax.media.opengl.GL;

/**
 *
 * @author Alison
 */
public class Cielo {
    
    //Cubo cielo;
    Cuadrado cielo;
    Cuadrado cielo1;
    //Estrella e1;
    ArrayList<Estrella> e;
    ArrayList<Estrella> e1;
    
    ArrayList<CoposNieve> c;
    
    
    CoposNieve c2;
     GL gl;
    
    float x, y, z;
    float w, h, d; 

    public Cielo(GL gl, float x, float y, float z, float w, float h, float d) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        
     
        cielo=new Cuadrado(gl,0,0,0,w,h,d,0.0f,0.0f,0.1f);
        c2=new CoposNieve(gl,0,0,0,0.6f,0.6f,0.6f,0);
        
        c=new ArrayList<CoposNieve>();
        for (float i = -(cielo.d/2); i < (cielo.d/7f); i++) {
            for (float j =-(cielo.h/2) ; j < (cielo.h/7); j++) {
                for (float k = -(cielo.w/2); k < -(cielo.w/5); k++) {
                        try {
                c.add(new CoposNieve(gl,1.5f*(float)Math.random()+k*1,1.5f*(float)Math.random()+j*1,(float)Math.random()+i*1,0.014f,0.014f,0.014f,0));
                
            } catch (Exception ex) {
                System.exit(0);
            }
                }
             
            }
        }
//        
        

         e1=new ArrayList<Estrella>();
        for (float i = -(cielo.d/2); i < (cielo.d/2f); i++) {
            for (float j = -3f; j < 5; j++) {
                 try {
                e1.add(new Estrella(gl,-cielo.w/2.3f,2f*(float)Math.random()+j*1,(float)Math.random()+i*1,0.4f,0.5f,0.2f,0));
                
            } catch (Exception ex) {
                System.exit(0);
            }
            }
        }
        
      
   
    }
    
    
    
    
    public void noche(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);   
        cielo.dibujarCuadradoxy();
       
        
        cielo.dibujarLateralDe();
        cielo.dibujarLateralIz();                  
        gl.glPopMatrix();
        
        gl.glPushMatrix();                
        for (CoposNieve c1 : c) {
        Teclado.rotarY(gl,0.3f);            
        //Teclado.trasladaY(gl,0.1f);
        c1.copoNieve();
        }
        gl.glPopMatrix(); 
        //gl.glPushMatrix();        
//        for (Estrella e2 : e1) {
//            Teclado.rotarZ(gl,0.0005f);
//            e2.estrella();
//        }
//        gl.glPopMatrix();   
    }
    
    public void dia(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);   
        cielo.dibujarCuadradoxy();
        cielo.dibujarLateralDe();
        cielo.dibujarLateralIz(); 
        gl.glPopMatrix();
    }
}
