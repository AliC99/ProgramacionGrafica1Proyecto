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
public class Letrero {
    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;
    
    Cubo base, letra, letra1, patas, nieve;
    Esfera enieve;

    public Letrero(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;
        
        base=new Cubo(gl,0,0,0,w,5*h/8,d,0.69f,0.43f,0.26f);
        nieve=new Cubo(gl,0,0,0,w/1.1f,4.5f*h/8,1.1f*d,0.9f,0.75f,0.75f);
        patas=new Cubo(gl,0,0,0,w/10,3*h/8,d,0.39f,0.13f,0.0f);
        letra=new Cubo(gl,0,0,0, 0.3f*w/10,1.5f*h/8,1.2f*d,0.64f,0.16f,0.1f);
        letra1=new Cubo(gl,0,0,0, 0.3f*w/10,1.5f*h/8,1.2f*d,0.27f,0.41f,0.57f);
        enieve=new Esfera(gl,0,0,0,base.w/5.2f,base.h/8,base.d,0.9f,0.85f,0.85f,7,7);
    }
    
    public void letrero(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(ang,0,1,0);
        gl.glPushMatrix();
        gl.glTranslatef(0,1.5f*h,0);
        base.dibujarCubo();
        nieve.dibujarCubo();
       
        
        //NIEVE
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/2.9f,base.h/2,0);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/6f,base.h/1.8f,0);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(base.w/18f,base.h/2.01f,0);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(base.w/10f,base.h/1.85f,0);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(base.w/3f,base.h/1.95f,0);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        //FIN NIEVE
        
        
        //PATAS DE MADERA
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/2.65f,-base.h/1.3f,0);
        patas.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(base.w/2.5f,-base.h/1.3f,0);
        patas.dibujarCubo();
        gl.glPopMatrix();
        //FIN PATAS DE MADERA
        
         //LETRAS
        
        //WELCOME
        //W
        //izquierda
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/2.4f,base.h/3.2f,0);
        gl.glRotatef(10,0,0,1);
        letra.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w,-letra.h/4,0);
        gl.glScalef(1,0.5f,1);
        gl.glRotatef(-15,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();                
        
        //derecha
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/3.2f,base.h/3.2f,0);
        gl.glRotatef(-10,0,0,1);
        letra.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(-letra.w,-letra.h/4,0);
        gl.glScalef(1,0.5f,1);
        gl.glRotatef(15,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN W
        
        //E
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/3.8f,base.h/4.1f,0);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/2,letra.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(letra.w/2,0,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.25f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/2,-letra.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN E
        
        //L
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/5.5f,base.h/4.1f,0);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/2,-letra.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN L
        
        //C
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/9.9f,base.h/4.1f,0);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/2,letra.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/2,-letra.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        gl.glPopMatrix();
        //FIN C
        
        //O
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/40,base.h/4.1f,0);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();        
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/1.3f,letra.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/1.3f,-letra.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();        
        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/1.5f,base.h/4.1f,0);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        //FIN O
        
        //M
        //izquierda
        gl.glPushMatrix();
        gl.glTranslatef(base.w/6.8f,base.h/4.2f,0);
        gl.glScalef(1,0.5f,1);
        gl.glRotatef(180,0,0,1);
     
        letra.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/1.1f,-letra.h/5f,0);
        gl.glScalef(0.7f,0.6f,1);
        gl.glRotatef(-5,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();                
        
        //derecha
        gl.glPushMatrix();
        gl.glTranslatef(base.w/14.4f,base.h/4.2f,0);
        gl.glScalef(1,0.5f,1);
        gl.glRotatef(180,0,0,1);
        letra.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(-letra.w/1.1f,-letra.h/5f,0);
        gl.glScalef(0.8f,0.6f,1);
        gl.glRotatef(5,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN M
        
        //E
        gl.glPushMatrix();
        gl.glTranslatef(base.w/5.2f,base.h/4.1f,0);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/2,letra.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(letra.w/2,0,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.25f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/2,-letra.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN E
        //FIN WELCOME
        
        //SNOWDIN
        
        //S
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/2.5f,0,0);
        gl.glScalef(1,0.5f,1);
        letra1.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra1.w/1.1f,-letra1.h/2.7f,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1.7f,0.6f,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra1.w/1.1f,letra1.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.6f,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        gl.glPopMatrix();               
        
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/2.9f,-base.h/10.0f,0);
        gl.glScalef(1,0.5f,1);
        letra1.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(-letra1.w/1.1f,-letra1.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.6f,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN S
        
        //N
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/3.35f, -base.h/9.8f, 0);
        gl.glScalef(1,0.55f,1);
        letra1.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra1.w,0,0);
        gl.glScalef(0.8f,1,1);
        gl.glRotatef(12,0,0,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/4.15f, -base.h/9.8f, 0);
        gl.glScalef(1,0.55f,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        //FIN N
        
        //O
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/5.15f,-base.h/9.8f,0);
        
        gl.glPushMatrix();
        gl.glTranslatef(1.5f*letra1.w,0,0);
        gl.glScalef(1,0.5f,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glScalef(1,0.5f,1);
        letra1.dibujarCubo();        
        
        gl.glPushMatrix();
        gl.glTranslatef(letra1.w/1.3f,letra1.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra1.w/1.3f,-letra1.h/2,0);
        gl.glRotatef(90,0,0,1);
        gl.glScalef(1,0.5f,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();        
        
        gl.glPopMatrix(); 
        //FIN O
        
        //W
        //izquierda
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/9.6f,-base.h/9.8f,0);
        gl.glScalef(0.8f,0.6f,1);
        gl.glRotatef(10,0,0,1);
        letra1.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra1.w,-letra1.h/4,0);
        gl.glScalef(1.2f,0.5f,1);
        gl.glRotatef(-15,0,0,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();                
        
        //derecha
        gl.glPushMatrix();
        gl.glTranslatef(-base.w/42.2f,-base.h/9.8f,0);
         gl.glScalef(0.8f,0.6f,1);
        gl.glRotatef(-10,0,0,1);
        letra1.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(-letra1.w,-letra1.h/4,0);
        gl.glScalef(1.2f,0.5f,1);
        gl.glRotatef(15,0,0,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN W
        
        //D
        gl.glPushMatrix();
        gl.glTranslatef(base.w/39,-base.h/9.8f,0);
        gl.glScalef(1,0.5f,1);
        letra1.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra1.w,letra1.h/2.5f,0);  
        gl.glScalef(1,0.5f,1);
        gl.glRotatef(30,0,0,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra1.w,-letra1.h/2.5f,0);  
        gl.glScalef(1,0.5f,1);
        gl.glRotatef(-30,0,0,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra1.w*2f,0,0);
        gl.glScalef(1,0.5f,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN D
        
        //I
        gl.glPushMatrix();
        gl.glTranslatef(base.w/8,-base.h/9.8f,0);
        gl.glScalef(1,0.55f,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        //FIN I
        
        //N
        gl.glPushMatrix();
        gl.glTranslatef(base.w/6f, -base.h/9.8f, 0);
        gl.glScalef(1,0.55f,1);
        letra1.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra1.w,0,0);
        gl.glScalef(0.8f,1,1);
        gl.glRotatef(12,0,0,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(base.w/4.5f, -base.h/9.8f, 0);
        gl.glScalef(1,0.55f,1);
        letra1.dibujarCubo();
        gl.glPopMatrix();
        //FIN N
        
        
        //FIN SNOWDIN
        
        //FIN LETRAS  
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        gl.glPopMatrix();
    }
    
    
    
}
