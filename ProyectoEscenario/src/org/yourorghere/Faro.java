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
public class Faro {

    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;

    Esfera luz;
    Cilindro soporte;
    Cono base;

    public Faro(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;

        soporte = new Cilindro(gl, 0, 0, 0, w, d / 1.3f, 5 * h / 7, 0.22f, 0.11f, 0.05f, 15, 15, 0.2f, 0.2f);
        luz = new Esfera(gl, 0, 0, 0, w, soporte.d / 5, d, 1, 1, 0.96f, 13, 13);
        base = new Cono(gl, 0, 0, 0, w, h / 7, d, 0.22f, 0.11f, 0.05f, 12, 12);
    }

    public void p() {
        float j = 10000;
        float i = j + 650;
        gl.glPushMatrix();
        if (Teclado.rotarY > i) {
            Teclado.rotarY = 0;
        }

        if (Teclado.rotarY >= j && Teclado.rotarY <= i) {
            luz.c1 = 0.3f;
            luz.c2 = 0.28f;
            luz.c3 = 0.11f;
        } else {
            luz.c1 = 1;
            luz.c2 = 1;
            luz.c3 = 0.96f;
        }
        gl.glPopMatrix();
    }

    public void faro1() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);

        gl.glPushMatrix();
        gl.glRotatef(90, 1, 0, 0);
        soporte.dibujarCilindro();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, soporte.d / 3.7f, 0);
        luz.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, soporte.d / 6f, 0);
        gl.glRotatef(90, 1, 0, 0);
        base.cono();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, -soporte.d, 0);
        gl.glRotatef(-90, 1, 0, 0);
        base.cono();
        gl.glPopMatrix();

        gl.glPopMatrix();

    }

    public void faro2() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glPopMatrix();
    }

}
