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
public class Arbol {

    Cubo tronco;
    Piramide hojas;
    Esfera luces, luces1, luces2, luces3,
           nieve;
    Estrella e;
    Cubo regalo, regalo1, cinta,
         alfombra, anieve;

    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;

    public Arbol(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;

        tronco = new Cubo(gl, 0, 0, 0, w / 4, h / 4, d / 4, 0.3f, 0.1f, 0.1f);
        hojas = new Piramide(gl, 0, 0, 0, w, tronco.h, d, 0.2f, 0.5f, 0.3f);

        //LUCES
        luces = new Esfera(gl, 0, 0, 0, hojas.w / 12, hojas.h / 9, hojas.d / 20, 0.4f, 0, 0.1f, 3, 3);
        luces1 = new Esfera(gl, 0, 0, 0, hojas.w / 12, hojas.h / 9, hojas.d / 20, 0.7f, 0.7f, 0.3f, 3, 3);
        luces2 = new Esfera(gl, 0, 0, 0, hojas.w / 12, hojas.h / 9, hojas.d / 20, 0.3f, 0.3f, 0.5f, 3, 3);
        luces3 = new Esfera(gl, 0, 0, 0, hojas.w / 12, hojas.h / 9, hojas.d / 20, 0.3f, 0.7f, 0.5f, 3, 3);
        //FIN LUCES

        //ARBOL CENTRAL
        e = new Estrella(gl, 0, 0, 0, 0.3f, 0.6f, 0.2f, 0);
        regalo = new Cubo(gl, 0, 0, 0, w / 3, h / 11, d / 6, 0.3f, 0.1f, 0.1f);
        regalo1 = new Cubo(gl, 0, 0, 0, regalo.w, regalo.h, regalo.d, 0.19f, 0.84f, 0.46f);
        cinta = new Cubo(gl, 0, 0, 0, w / 4, h / 4, d / 4, 1, 0.98f, 0.52f);
        alfombra = new Cubo(gl, 0, 0, 0, tronco.w * 5, tronco.h / 21, tronco.d * 5, 0.6f,0.21f,0.22f);
        anieve = new Cubo(gl, 0, 0, 0, alfombra.w, alfombra.h, alfombra.d/10, 0.92f,0.93f,1.0f);
        nieve = new Esfera(gl, 0, 0, 0, anieve.w/7 , 1.3f*anieve.h, 1.5f*anieve.d, 0.92f,0.93f,1.0f, 4, 4);
        //FIN ARBOL CENTRAL
    }

    public void dibujarArbol() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glRotatef(ang, 0, 1, 0);
        //Teclado.rotarY(gl);
        tronco.dibujarCubo();

        gl.glPushMatrix();
        gl.glTranslatef(tronco.x, tronco.y + tronco.h, tronco.z);
        hojas.dibujarPiramide();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(tronco.x, tronco.y + 1.5f * tronco.h, tronco.z);
        hojas.dibujarPiramide();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(tronco.x, tronco.y + 2f * tronco.h, tronco.z);
        hojas.dibujarPiramide();
        gl.glPopMatrix();

        luces(hojas.w, hojas.h, hojas.d);
        luces(hojas.w, hojas.h, -hojas.d);
        gl.glPushMatrix();
        gl.glRotatef(-90, 0, 1, 0);
        luces(hojas.w, hojas.h, hojas.d);
        luces(hojas.w, hojas.h, -hojas.d);
        gl.glPopMatrix();

        gl.glPopMatrix();

    }

    public void arbolCentral() {
        dibujarArbol();

        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);

        //ESTRELLA
        gl.glPushMatrix();
        gl.glTranslatef(0, 2.7f * hojas.h, 0);
        e.estrella();
        gl.glPopMatrix();
        //FIN ESTRELLA

        //ALFOMBRA
        gl.glPushMatrix();
        gl.glTranslatef(0, -tronco.h / 2, 0);
        alfombra.dibujarCubo();
        
        //NIEVE ALFOMBRA
        
        //FRONTAL
        gl.glPushMatrix();
        gl.glTranslatef(0,0,alfombra.d/2);
        anieve.dibujarCubo();
        nieve.dibujarEsfera();
        
        gl.glPushMatrix();
        gl.glTranslatef(-anieve.w/2,0,0);
        nieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(anieve.w/2,0,0);
        nieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN FRONTAL
        
        
        //POSTERIOR
        gl.glPushMatrix();
        gl.glTranslatef(0,0,-alfombra.d/2);
        anieve.dibujarCubo();
        
        nieve.dibujarEsfera();
        
        gl.glPushMatrix();
        gl.glTranslatef(-anieve.w/2,0,0);
        nieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(anieve.w/2,0,0);
        nieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN POSTERIOR
        
        //IZQUIERDA
        gl.glPushMatrix();
        gl.glTranslatef(-alfombra.w/2,0,0);
        gl.glRotatef(90,0,1,0);
        anieve.dibujarCubo();
        nieve.dibujarEsfera();
        
        gl.glPopMatrix();
        //FIN IZQUIERDA
        
        //DERECHA
        gl.glPushMatrix();
        gl.glTranslatef(alfombra.w/2,0,0);
        gl.glRotatef(90,0,1,0);
        anieve.dibujarCubo();
        nieve.dibujarEsfera();
        gl.glPopMatrix();
        //FIN DERECHA
        
        //FIN NIEVE ALFOMBRA
        
        gl.glPopMatrix();
        //FIN ALFOMBRA

        //REGALOS
        gl.glPushMatrix();
        gl.glTranslatef(0, -tronco.h / 3.5f, tronco.d);
        regalo(w / 3, h / 11, d / 6, 0.62f,0.15f,0.12f);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(2 * tronco.w, -tronco.h / 3.5f, tronco.d);
        regalo(w / 3.5f, h / 11, d / 6, 0.34f,0.62f,0.4f);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-2 * tronco.w, -tronco.h / 3.3f, -tronco.d);
        regalo(w / 4f, h / 14, d / 6, 0.55f, 1.0f,0.98f);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef( tronco.w, -tronco.h / 3.9f, -tronco.d);
        regalo(w / 4f, h / 9, d / 6, 0.6f,0.28f,0.8f);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef( -tronco.w, -tronco.h / 3.9f, 0);
        regalo(w / 2f, h / 10, d / 5, 0.97f,0.48f,0.87f);
        gl.glPopMatrix();
        //FIN REGALOS

        gl.glPopMatrix();
    }

    public void regalo(float w, float h, float d, float r, float g, float b) {       
        regalo.c1 = r;
        regalo.c2 = g;
        regalo.c3 = b;

        regalo.w = w;
        regalo.h = h;
        regalo.h = h;
        regalo.dibujarCubo();

        regalo1.c1 = r + 0.3f;
        regalo1.c2 = g + 0.3f;
        regalo1.c3 = b + 0.3f;

        regalo1.w = w;
        regalo1.h = h;
        regalo1.h = h;
        regalo1.wireCubo();

        //CINTA
        //superior
        cinta.w = w;
        cinta.h = h / 15;
        cinta.d = d / 2.8f;
        gl.glPushMatrix();
        gl.glTranslatef(0,regalo.h/2,0);
        cinta.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,regalo.h/2,0);
        gl.glRotatef(90,0,1,0);
        gl.glScalef(0.5f,1,1);
        cinta.dibujarCubo();
        gl.glPopMatrix();
        //fin superior
                
        //frontal
        gl.glPushMatrix();
        gl.glTranslatef(0,0,regalo.d/2);
        gl.glScalef(0.25f,15f,0.06f);
        cinta.dibujarCubo();   
        gl.glPopMatrix();
        //fin frontal
                
        //posterior
        gl.glPushMatrix();
        gl.glTranslatef(0,0,-regalo.d/2);
        gl.glScalef(0.25f,15f,0.06f);
        cinta.dibujarCubo();
        cinta.dibujarCubo();
        gl.glPopMatrix();
        //fin posterior
        
        //lateralderecho
        gl.glPushMatrix();
        gl.glTranslatef(regalo.w/2,0,0);
        gl.glRotatef(90,0,1,0);
        gl.glScalef(0.25f,15f,0.06f);
        cinta.dibujarCubo();
        cinta.dibujarCubo();
        gl.glPopMatrix();
        //fin lateralderecho
        
        //lateralizquierdo
        gl.glPushMatrix();
        gl.glTranslatef(-regalo.w/2,0,0);
        gl.glRotatef(90,0,1,0);
        gl.glScalef(0.25f,15f,0.06f);
        cinta.dibujarCubo();
        cinta.dibujarCubo();
        gl.glPopMatrix();
        //fin lateralizquierdo
        
        //FIN CINTA
    }

    public void luces(float x, float y, float z) {
        //LUCES
        gl.glPushMatrix();
        gl.glTranslatef(0, y / 1.5f, z / 2);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 2f * y, z / 4);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-x / 3, 1.2f * y, z / 2.3f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(x / 3, 1.2f * y, z / 2.3f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 1.4f * y, z / 2.3f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces1.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(x / 3.5f, 1.7f * y, z / 2.4f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces1.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 2.3f * y, z / 6.5f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces1.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-x / 3.5f, y / 1.5f, z / 2f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces1.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(x / 3.5f, y / 1.5f, z / 2f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces2.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 1.7f * y, z / 2.5f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces2.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 1.1f * y, z / 2.2f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces2.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(x / 4f, 1.1f * y, z / 2.2f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-x / 4f, 1.6f * y, z / 2.2f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(x / 4.3f, 1.95f * y, z / 3.7f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-x / 4.4f, 1.95f * y, z / 3.7f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-x / 6f, y / 1.2f, z / 3f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(x / 6f, y / 1.2f, z / 3f);
        gl.glScalef(0.4f, 0.7f, 0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();
        //FIN LUCES
    }
}
