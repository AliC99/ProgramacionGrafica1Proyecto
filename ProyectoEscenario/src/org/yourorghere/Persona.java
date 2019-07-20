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
public class Persona {

    GL gl;
    float x, y, z;
    float w, h, d;
    float ang;

    Esfera cabeza,
            etorso,
            ecabello, cabello1;
    Cilindro cuello, torso, rayas,
            pantalon, pierna;
    Cubo pie, cabello;

    public Persona(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;

        cabeza = new Esfera(gl, 0, 0, 0, w / 4, 3 * h / 13, d / 4, 1.0f, 0.79f, 0.05f, 15, 15);
        cuello = new Cilindro(gl, 0, 0, 0, w / 3, cabeza.h / 1.5f, d / 3, 1.0f, 0.79f, 0.05f, 20, 20, 0.25f, 0.25f);
        torso = new Cilindro(gl, 0, 0, 0, w, 3.5f * h / 13, 3f * h / 13, 0.45f, 0.65f, 0.89f, 20, 20, 0.25f, 0.25f);
        rayas = new Cilindro(gl, 0, 0, 0, torso.w, 1.1f * torso.h, torso.d / 4, 0.72f, 0.28f, 0.76f, 20, 20, 0.25f, 0.25f);
        etorso = new Esfera(gl, 0, 0, 0, torso.w / 4, torso.h / 4, torso.h, 0.45f, 0.65f, 0.89f, 15, 15);
        pantalon = new Cilindro(gl, 0, 0, 0, w / 2.4f, 1.1f * torso.h, d / 3, 0.45f, 0.65f, 0.89f, 20, 20, 0.25f, 0.25f);
        pierna = new Cilindro(gl, 0, 0, 0, w / 4, 1.1f * torso.h, d / 5, 1.0f, 0.79f, 0.05f, 20, 20, 0.25f, 0.25f);
        pie = new Cubo(gl, 0, 0, 0, w / 7, h / 7, d / 7, 0.24f, 0.07f, 0.05f);
        cabello = new Cubo(gl, 0, 0, 0, 1.9f * cabeza.w, cabeza.h, cabeza.d / 6, 0.24f, 0.07f, 0.05f);
        ecabello = new Esfera(gl, 0, 0, 0, cabeza.w, cabeza.h / 1.5f, cabeza.d / 6, 0.24f, 0.0f, 0.0f, 15, 15);
        cabello1 = new Esfera(gl, 0, 0, 0, 1.1f * cabeza.w, cabeza.h, cabeza.d, 0.24f, 0.0f, 0.0f, 15, 15);
    }

    public void dibujarPersona() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glRotatef(ang, 0, 1, 0);
        //Teclado.rotarY(gl);
        torso();
        cabeza();
        pantalon();
        brazo();
        gl.glPopMatrix();

    }

    public void torso() {
        gl.glPushMatrix();

        gl.glRotatef(90, 1, 0, 0);
        torso.dibujarCilindro();
        etorso.dibujarEsfera();
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, torso.d);
        etorso.dibujarEsfera();
        gl.glPopMatrix();

        rayas.dibujarCilindro();

        gl.glPushMatrix();
        gl.glTranslatef(0, 0, torso.d / 2);
        rayas.dibujarCilindro();
        gl.glPopMatrix();

        gl.glPopMatrix();
    }

    public void cabeza() {
        gl.glPushMatrix();
        gl.glTranslatef(0, h / 2, 0);
        //CABEZA
        cabeza.dibujarEsfera();

        //CABELLO
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, 1.3f * cabeza.d);
        gl.glScalef(1.08f, 1, 2f);
        cabello();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(2 * cabeza.w, 0, 0);
        gl.glScalef(1, 1, 0.6f);
        gl.glRotatef(90, 0, 1, 0);
        cabello();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-cabeza.w / 20, 0, 0);
        gl.glScalef(1, 1, 0.6f);
        gl.glRotatef(90, 0, 1, 0);
        cabello();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, cabeza.h / 2f, 0);
        cabello1.dibujarEsfera();
        gl.glPopMatrix();

        //FIN CABELLO
        //OJOS
        gl.glPushMatrix();
        gl.glTranslatef(-cabeza.w / 2.7f, 0, cabeza.d);
        gl.glScalef(0.5f, 0.15f, 0.4f);
        pie.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(cabeza.w / 2.7f, 0, cabeza.d);
        gl.glScalef(0.5f, 0.15f, 0.4f);
        pie.dibujarCubo();
        gl.glPopMatrix();
        //FIN OJOS

        //CUELLO
        gl.glPushMatrix();
        gl.glRotatef(90, 1, 0, 0);
        cuello.dibujarCilindro();
        gl.glPopMatrix();

        gl.glPopMatrix();
    }

    public void cabello() {
        gl.glPushMatrix();
        gl.glTranslatef(0, -cabeza.h / 2, -cabeza.d);
        cabello.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 0, -cabeza.d);
        ecabello.dibujarEsfera();
        gl.glPopMatrix();

    }

    public void pantalon() {

        //IZQUIERDA
        gl.glPushMatrix();
        gl.glTranslatef(-torso.w / 6.7f, -torso.d, 0);
        gl.glRotatef(90, 1, 0, 0);
        pantalon.dibujarCilindro();

        //PIERNA
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, pantalon.d);
        pierna.dibujarCilindro();

        //ZAPATO
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, pierna.h);
        pie.dibujarCubo();
        gl.glPopMatrix();
        //FIN ZAPATO

        gl.glPopMatrix();
        //FIN PIERNA

        gl.glPopMatrix();
        //FIN IZQUIERDA

        //DERECHA
        gl.glPushMatrix();
        gl.glTranslatef(torso.w / 6.7f, -torso.d, 0);
        gl.glRotatef(90, 1, 0, 0);
        pantalon.dibujarCilindro();
        //PIERNA
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, pantalon.d);
        pierna.dibujarCilindro();

        //ZAPATO
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, pierna.h);
        pie.dibujarCubo();
        gl.glPopMatrix();
        //FIN ZAPATO
        gl.glPopMatrix();
        //FIN PIERNA
        gl.glPopMatrix();
        //FIN DERECHA
    }

    public void brazo() {
        gl.glPushMatrix();
        gl.glTranslatef(-torso.w / 4.5f, -torso.h / 5f, 0);
        gl.glRotatef(90, 1, 0, 0);
        gl.glRotatef(-17, 0, 1, 0);
        gl.glScalef(0.5f, 0.6f, 1);
        torso.dibujarCilindro();
        etorso.dibujarEsfera();

        //MANOS
        gl.glPushMatrix();
        gl.glTranslatef(-torso.w / 12, torso.d / 2, torso.h);
        gl.glScalef(0.6f, 0.3f, 0.3f);
        cabeza.dibujarEsfera();
        gl.glPopMatrix();

        //FIN MANOS
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(torso.w / 4.5f, -torso.h / 5f, 0);
        gl.glRotatef(90, 1, 0, 0);
        gl.glRotatef(17, 0, 1, 0);
        gl.glScalef(0.5f, 0.6f, 1);
        torso.dibujarCilindro();
        etorso.dibujarEsfera();

        //MANOS
        gl.glPushMatrix();
        gl.glTranslatef(torso.w / 12, torso.d / 2, torso.h);
        gl.glScalef(0.6f, 0.3f, 0.3f);
        cabeza.dibujarEsfera();
        gl.glPopMatrix();
        //FIN MANOS
        gl.glPopMatrix();
    }

    public void moverW(float z) {
        if (Teclado.trasladaZ <= z && Teclado.trasladaZ > z-3.69f && Teclado.trasladaX < 6f) {
            Teclado.trasladaZ = z;
        } else if (Teclado.trasladaZ < -7.23f && Teclado.trasladaZ > -7.5f && Teclado.trasladaX > 0.65f) {
            Teclado.trasladaZ = Teclado.trasladaZ;
        } else if (Teclado.trasladaZ < -7.23f && Teclado.trasladaZ > -7.5f && Teclado.trasladaX < 0.41f) {
            Teclado.trasladaZ = Teclado.trasladaZ;
        } 
    }
    
    public void moverS(float z){
         if (Teclado.trasladaZ>=z ) {
                    Teclado.trasladaZ =z;
                }else if (Teclado.trasladaZ>3.45f && Teclado.trasladaX>-6.11f ) {
                    Teclado.trasladaZ=Teclado.trasladaZ;
                }else if ( Teclado.trasladaZ<0.4f && Teclado.trasladaZ>-3 && Teclado.trasladaX<6 ) {
                    Teclado.trasladaZ=Teclado.trasladaZ;
                }
    }

    public void persona1() {
        Persona p1 = new Persona(gl, x, y, z, w, h, d, ang);
        p1.cabeza.c1 = 0.5f;
        p1.cabeza.dibujarEsfera();

    }

}
