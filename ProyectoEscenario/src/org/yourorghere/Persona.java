/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Alison
 */
public class Persona  {
    
    GL gl;
    float x,y,z;
    float w,h,d;
    Esfera cabeza;
    Cilindro cuello, torso;
    Cubo piernai, piernad, piei, pied, pantalon, brazod, brazoi;
    //Torus torus;
    Piramide piramide;

    public Persona(GL gl, float x, float y, float z, float w, float h, float d) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        cabeza = new Esfera(gl, 0, 0, 0, 0.3f, 0.3f, 0.3f, 0.9f, 1f, 0.7f, 100, 100);
        cuello = new Cilindro(gl, 0, 0, 0, 0.4f, 0.4f, 0.2f, 0.2f, 0.3f, 0.4f, 40, 40, 0.25f, 0.25f);
        torso = new Cilindro(gl, 0, 0, 0, 1.0f, 1.0f, 0.8f, 0.2f, 0.3f, 0.4f, 40, 40, 0.25f, 0.25f);
//        piernad = new Cubo(gl, 0, 0, 0, 0.15f, 0.7f, 0.2f, 0.5f, 0.3f, 0.4f, 0, 0, 0);
//        piernai = new Cubo(gl, 0, 0, 0, 0.15f, 0.7f, 0.2f, 0.5f, 0.3f, 0.4f, 0, 0, 0);
//        pantalon = new Cubo(gl, 0, 0, 0, 0.4f, 0.1f, 0.2f, 0.5f, 0.3f, 0.4f, 0, 0, 0);
//        piei = new Cubo(gl, 0, 0, 0, 0.15f, 0.1f, 0.3f, 0.6f, 0.2f, 0.1f, 0, 0, 0);
//        pied = new Cubo(gl, 0, 0, 0, 0.15f, 0.1f, 0.3f, 0.6f, 0.2f, 0.1f, 0, 0, 0);
//        brazod = new Cubo(gl, 0, 0, 0, 0.7f, 0.1f, 0.2f, 0.0f, 0.1f, 0.2f, 0, 0, 0);
//        brazoi = new Cubo(gl, 0, 0, 0, 0.7f, 0.1f, 0.2f, 0.0f, 0.1f, 0.2f, 0, 0, 0);
//        torus=new Torus(gl, 0, 0, 0, 0.5f, 0.46f, 0.3f, 1.0f, 1.0f, 0.4f, 0.1f, 0.5f, 32, 32);
        piramide= new Piramide (gl,0, 0, 0, 0.3f, 0.3f, 0.3f, 0.1f, 0.3f, 0.1f);
    }
    
    public void dibujarPersona(){
        gl.glPushMatrix();
        
        gl.glScalef(w,h,d);
        
        //Piramide
        gl.glPushMatrix();
        gl.glTranslatef(-0.47f,1.5f,-2.8f);
        Teclado.rotarY(gl);  
        piramide.dibujarPiramide();
        gl.glPopMatrix();
        
        
        //TORUS
        gl.glPushMatrix();
        gl.glTranslatef(-0.47f,1.1f,-2.8f);
        Teclado.rotarY(gl);
        gl.glRotatef(90,1,0,0);   
        //torus.dibujarTorus();
        gl.glPopMatrix();
        
         //CABEZA
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, 0.8f, -3f); 
        gl.glRotatef(Teclado.getRotarX(),0,1,0);
        cabeza.dibujarEsfera();
        gl.glPopMatrix();
        
        //CUELLO
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, 0.5f, -3.0f);
        gl.glRotatef(Teclado.getRotarX(),0,1,0);
        gl.glRotatef(91, 1, 0, 0);
        cuello.dibujarCilindro();
        gl.glPopMatrix();

        //TORSO
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, 0.35f, -3.0f);
        gl.glRotatef(91, 1, 0, 0);      
        torso.dibujarCilindro();
        gl.glPopMatrix();

        //PIERNA DERECHA
        gl.glPushMatrix();
        gl.glTranslatef(-0.62f, -0.8f, -3.0f);       
        piernad.dibujarCubo();
        gl.glPopMatrix();

        //PIERNA IZQUIERDA
        gl.glPushMatrix();
        gl.glTranslatef(-0.35f, -0.8f, -3.0f);        
        piernai.dibujarCubo();
        gl.glPopMatrix();

        //CUBO
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, -0.5f, -3.0f);       
        pantalon.dibujarCubo();
        gl.glPopMatrix();

        //PIE IZQUIERDO
        gl.glPushMatrix();
        gl.glTranslatef(-0.35f, -1.2f, -2.95f);        
        piei.dibujarCubo();
        gl.glPopMatrix();

        //PIE DERECHO
        gl.glPushMatrix();
        gl.glTranslatef(-0.62f, -1.2f, -2.95f);       
        pied.dibujarCubo();
        gl.glPopMatrix();

        //BRAZO DERECHO
        gl.glPushMatrix();
        gl.glTranslatef(-0.8f, -0.05f, -3.0f);
        gl.glRotatef(70, 0, 0, 1);       
        brazod.dibujarCubo();
        gl.glPopMatrix();

        //BRAZO IZQUIERDO
        gl.glPushMatrix();
        gl.glTranslatef(-0.2f, -0.05f, -3.0f);
        gl.glRotatef(-70, 0, 0, 1);
        gl.glRotatef(-20, 1, 0, 0);       
        brazoi.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();

    }
    
    
    
    
}
