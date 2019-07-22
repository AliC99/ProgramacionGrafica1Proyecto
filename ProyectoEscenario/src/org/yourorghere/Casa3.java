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
public class Casa3 {

    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;

    Casa c;
    Cubo ventana, linea,marco,
            base;
    Esfera ven1,emarco;
    Torus mven1;
    Dodecaedro dc;

    public Casa3(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;

        c = (new Casa(gl, 0, 0, 0, 1, 1, 1, 0));
        ventana = new Cubo(gl, 0, 0, 0, w / 6f, h / 12, d / 3, 1.0f, 0.78f, 0.4f);
        linea = new Cubo(gl, 0, 0, 0, ventana.w / 8, ventana.h, ventana.d / 5, 0.23f, 0.13f, 0.04f);
        base = new Cubo(gl, 0, 0, 0, 2.3f * w, h / 14, 1.1f * d, 0.55f, 0.35f, 0.25f);
        ven1 = new Esfera(gl, 0, 0, 0, w / 5.5f, h / 11, d / 3, 1.0f, 0.78f, 0.4f, 10, 10);
        mven1 = new Torus(gl, 0, 0, 0, w / 4.5f, h / 9, d / 2, 0.23f, 0.13f, 0.04f, 0.1f, 0.8f, 10, 10);
        dc = new Dodecaedro(gl, 0, 0, 0, base.w / 20, base.h / 2.8f, base.d / 10, 0.35f, 0.15f, 0.05f);
        
        marco = new Cubo(gl, 0, 0, 0, w / 4.5f, h / 10, d / 3, 0.23f, 0.13f, 0.04f);
        emarco = new Esfera(gl, 0, 0, 0, w / 4.0f, h / 8.5f, d / 3, 0.23f, 0.13f, 0.04f, 10, 10);
        
    }

    public void casa3() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);

        gl.glPushMatrix();
        gl.glTranslatef(w / 2.5f, -h / 16, d / 19);
        base.dibujarCubo();

        //PATRÓN
        for (float i = -base.w / 2.3f; i < base.w / 2; i += 0.1f) {
            gl.glPushMatrix();
            gl.glTranslatef(i, 0, base.d / 2.5f);
            dc.wire();
            gl.glPopMatrix();
        }
        for (float i = -base.w / 2.3f; i < base.w / 2; i += 0.1f) {
            gl.glPushMatrix();
            gl.glTranslatef(i, 0, -base.d / 2.5f);
            dc.wire();
            gl.glPopMatrix();
        }

        for (float i = -base.d / 2.3f; i < base.d / 2; i += 0.1f) {
            gl.glPushMatrix();
            gl.glTranslatef(-base.w / 2.3f, 0, i);
            dc.wire();
            gl.glPopMatrix();
        }

        for (float i = -base.d / 2.3f; i < base.d / 2; i += 0.1f) {
            gl.glPushMatrix();
            gl.glTranslatef(base.w / 2.3f, 0, i);
            dc.wire();
            gl.glPopMatrix();
        }
        //FIN PATRÓN
        gl.glPopMatrix();

        //PUERTA
        gl.glPushMatrix();
        gl.glScalef(0.55f, 0.9f, 1);
        c.puerta(1.3f * w, c.puerta.h / 3, d / 2.4f);

        gl.glPopMatrix();
        //FIN PUERTA

        //VENTANA
        gl.glPushMatrix();
        gl.glTranslatef(w / 1.4f, h / 5, 2.1f * c.puerta.d);
        ventana.dibujarCubo();

        //central
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, ventana.d / 2.2f);
        linea.dibujarCubo();

        //marcos
        gl.glPushMatrix();
        gl.glTranslatef(-ventana.w / 2, 0, 0);
        linea.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(ventana.w / 2, 0, 0);
        linea.dibujarCubo();
        gl.glPopMatrix();
        //fin marcos

        //
        gl.glPushMatrix();
        gl.glScalef(1, 1.1f, 1);
        gl.glRotatef(90, 0, 0, 1);
        linea.dibujarCubo();

        gl.glPushMatrix();

        gl.glTranslatef(-ventana.h / 2, 0, 0);
        linea.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(ventana.h / 2, 0, 0);
        linea.dibujarCubo();
        gl.glPopMatrix();

        gl.glPopMatrix();

        gl.glPopMatrix();
        //fin central

        gl.glPopMatrix();
        //FIN VENTANA

        //VENTANA CIRCULAR
        gl.glPushMatrix();
        gl.glTranslatef(w / 2f, h / 1.3f, 1.4f * c.puerta.d);
        ven1.dibujarEsfera();

        gl.glPushMatrix();
        gl.glTranslatef(0, 0, ven1.d / 2);
        mven1.dibujarTorus();
        gl.glPopMatrix();
        
        //CENTRAL
        gl.glPushMatrix();
        gl.glTranslatef(0,0,ven1.d);
        gl.glScalef(1.25f,2f,1);
        linea.dibujarCubo();                        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,0,ven1.d);
        gl.glScalef(2.45f,1.25f,1);
        gl.glRotatef(90,0,0,1);
        linea.dibujarCubo();
        gl.glPopMatrix();
        //FIN CENTRAL
        

        gl.glPopMatrix();
        //FIN VENTANA CIRCULAR

        //VENTANA 2
        gl.glPushMatrix();
        gl.glTranslatef(-w / 8, h / 4, d / 2.6f);

        gl.glScalef(1.8f, 1.4f, 1);
        ventana.dibujarCubo();

        gl.glPushMatrix();
        gl.glTranslatef(0, ventana.h / 1.5f, -ventana.d / 4);
        gl.glScalef(0.65f, 1f, 1);
        ven1.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPopMatrix();
        
        //MARCO
        gl.glPushMatrix();
        gl.glTranslatef(-w / 8, h / 4.3f, d / 2.9f);

        gl.glScalef(1.8f, 1.4f, 1);
        marco.dibujarCubo();

        gl.glPushMatrix();
        gl.glTranslatef(0, marco.h / 1.5f, -marco.d / 3.8f);
        gl.glScalef(0.65f, 1f, 1);
        emarco.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPopMatrix();
        //FIN MARCO
        
        //PUERTA
        gl.glPushMatrix();
        gl.glTranslatef(w / 20, h / 4.3f, d / 1.4f);
        gl.glScalef(0.25f,1f,1f);
        gl.glRotatef(65,0,1,0);
        marco.dibujarCubo();

        gl.glPushMatrix();
        gl.glTranslatef(0, marco.h / 1.5f, -marco.d / 3.8f);
        gl.glScalef(0.65f, 1f, 1);
        emarco.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPopMatrix();
        //FIN PUERTA
        
        //FIN VENTANA 2

        
        gl.glScalef(w, h, d);

        gl.glPushMatrix();
        gl.glTranslatef(-1.75f * w / 7, -h / 40, 0);
        gl.glScalef(1.2f, 0.75f, 1);
        c.dibujarCasaV();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(w, 0, -d / 9);
        gl.glScalef(2f, 1.2f, 1f);
        c.dibujarCasaV();
        gl.glPopMatrix();

        gl.glPopMatrix();
    }
}
