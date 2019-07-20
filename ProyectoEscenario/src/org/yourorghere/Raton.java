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
public class Raton {
     GL gl;
    float x,y,z;
    float w,h,d;
    
    float ang;
    
    Esfera cuerpo,orejas,patas, cara,nariz,ojos;
    Cono cola;
    

    public Raton(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang=ang;
        
        cuerpo = new Esfera(gl, 0, 0, 0, w, 2*h/3, 4*d/5, 0.6f, 0.6f, 0.6f, 18, 18);
        orejas = new Esfera(gl, 0, 0, 0, w/3, h/5, 0.5f*d/5, 0.5f, 0.5f, 0.5f, 10, 10);
        patas = new Esfera(gl, 0, 0, 0, w/3, h/5, 0.7f*d/5, 0.5f, 0.5f, 0.5f, 10, 10);
        cara = new Esfera(gl, 0, 0, 0, w/2.4f, h/4, 1.2f*d/5, 0.6f, 0.6f, 0.6f, 15, 15);
        nariz = new Esfera(gl, 0, 0, 0,cara.w/3, cara.h/3, cara.d/3, 0.5f, 0.5f, 0.5f, 10, 10);
        ojos = new Esfera(gl, 0, 0, 0,cara.w/4.5f, cara.h/4.5f, cara.d/4.5f, 0.2f, 0.2f, 0.2f, 7, 7);
        cola=new Cono(gl,0,0,0,w/4,h/6,d/1.3f,0.7f, 0.7f, 0.7f,10,10);
    }
    
    public void raton(){
    gl.glPushMatrix();
    gl.glTranslatef(x,y,z);
//    Teclado.rotarY(gl);
   
    Teclado.trasladarZ(gl);
    gl.glRotatef(ang,0,1,0);    
    if (Teclado.getTrasladar()>7) {
            Teclado.setTrasladar(z);
        }
    cuerpo.dibujarEsfera();
    
    //COLA
    gl.glPushMatrix();    
    gl.glTranslatef(0,-cuerpo.h/2.8f,-cuerpo.d/1.2f);
    gl.glRotatef(180,1,0,0);
    cola.cono();    
    gl.glPopMatrix();
    //FIN COLA
    
    //CARA
    gl.glPushMatrix();
    gl.glTranslatef(0,0,cuerpo.d/1.2f);
    cara.dibujarEsfera();
    
    gl.glPushMatrix();
    gl.glTranslatef(0,cara.h/1.7f,cara.d);
    nariz.dibujarEsfera();
    gl.glPopMatrix();
         
    gl.glPopMatrix();
    
    gl.glPushMatrix();
    gl.glTranslatef(cuerpo.w/2.5f,cuerpo.h/1.8f,cuerpo.d/1.2f);
    ojos.dibujarEsfera();
    gl.glPopMatrix();
    
    gl.glPushMatrix();
    gl.glTranslatef(-cuerpo.w/2.5f,cuerpo.h/1.8f,cuerpo.d/1.2f);
    ojos.dibujarEsfera();
    gl.glPopMatrix();
    //FIN CARA
    
    //OREJAS
    gl.glPushMatrix();
    gl.glTranslatef(cuerpo.w/1.8f,cuerpo.h,cuerpo.d/2);
    orejas.dibujarEsfera();
    gl.glPopMatrix();
    
    gl.glPushMatrix();
    gl.glTranslatef(-cuerpo.w/1.8f,cuerpo.h,cuerpo.d/2);
    orejas.dibujarEsfera();
    gl.glPopMatrix();
    //FIN OREJAS
    
    //PATAS
    gl.glPushMatrix();
    gl.glTranslatef(cuerpo.w/1.4f,-cuerpo.h/1.5f,cuerpo.d/2);
    patas.dibujarEsfera();
    gl.glPopMatrix();
    
    gl.glPushMatrix();
    gl.glTranslatef(-cuerpo.w/1.4f,-cuerpo.h/1.5f,cuerpo.d/2);
    patas.dibujarEsfera();
    gl.glPopMatrix();
    
     gl.glPushMatrix();
    gl.glTranslatef(cuerpo.w/1.4f,-cuerpo.h/1.5f,-cuerpo.d/2);
    patas.dibujarEsfera();
    gl.glPopMatrix();
    
    gl.glPushMatrix();
    gl.glTranslatef(-cuerpo.w/1.4f,-cuerpo.h/1.5f,-cuerpo.d/2);
    patas.dibujarEsfera();
    gl.glPopMatrix();    
    //FIN PATAS
    gl.glPopMatrix();    
    }
    
    
    
    
}
