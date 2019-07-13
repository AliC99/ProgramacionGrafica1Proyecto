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
public class Restaurante {

    Cubo pfp, pfp1,
            techo, nieve, suelo, suelo1,
            mesa, pata,
            barra, barra2, cuerpo1, cuerpo2,
            estante, cuerpoepf, cuerpoeid,            
            sofa1, sofap1,
            botellacb,
            botellacb1,
            botellacb2,
            maquina, maquina1, lineamq, maqsp, lnc, lnc1,
            puerta, pBorde, letrero, letra,puertaS1,puertaS2;
    Esfera tablero, tablerop,
            eredonda,
            ebredonda,
            ebredonda2,
            eeredonda,
            empredonda,
            esredonda1, espredonda1,
            botella,
            botella1,
            botella2,
            emqredonda, emqredonda1, cuerpomq, espredonda, emlidredonda;
    Cilindro patas, borde,
            botellac, botellat, botellacn,
            botellac1, botellat1, botellacn1,
            botellac2, botellat2, botellacn2,
            maqlid;
    Torus maqc;
    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;

    public Restaurante(GL gl, float x, float y, float z, float w, float h, float d,float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang=ang;

        //PAREDES
        pfp = new Cubo(gl, 0, 0, 0, w, h, d / 28, 0.51f, 0.15f, 0.03f);
        pfp1 = new Cubo(gl, 0, 0, 0, w, h, d / 28, 0.25f, 0.05f, 0.02f);
        techo = new Cubo(gl, 0, 0, 0, 1.2f * w, h / 15, 1.2f * d, 0.16f, 0.02f, 0.02f);
        nieve = new Cubo(gl, 0, 0, 0, 1.2f * w, h / 18, 1.2f * d, 0.9f, 0.9f, 1.0f);
        suelo = new Cubo(gl, 0, 0, 0, w , h / 30, d/2 , 0.78f, 0.33f, 0.004f);
        suelo1 = new Cubo(gl, 0, 0, 0, w , h / 30, d/2 , 0.61f, 0.14f, 0.0f);
        //FIN PAREDES
        
        //PUERTA
        puerta = new Cubo(gl, 0, 0, 0, w/7.5f , h / 2.2f, d/25 , 0.47f, 0.25f, 0.09f);
        puertaS1 = new Cubo(gl, 0, 0, 0, puerta.w , puerta.h/3, puerta.d , 0.79f,0.05f,0.06f);
        puertaS2 = new Cubo(gl, 0, 0, 0, puerta.w , puerta.h/3, puerta.d , 1,0.93f,0.89f);
        pBorde = new Cubo(gl, 0, 0, 0, puerta.w/5 , puerta.h, 1.3f*puerta.d , 0.37f, 0.15f, 0.0f);        
        //FIN PUERTA
        
        //LETRERO
        letrero = new Cubo(gl, 0, 0, 0, w , h / 4, d/10 , 0.29f, 0.07f, 0.06f);
        letra = new Cubo(gl, 0, 0, 0, letrero.w/48 , letrero.h/1.1f, letrero.d/3 , 0.87f, 0.8f, 0.45f);
        //FIN LETRERO
        
        //FIN PAREDES

        //MESAS
        //MESA REDONDA
        tablero = new Esfera(gl, 0, 0, 0, 3.5f * w / 35, h / 20, d / 9, 1.0f, 0.44f, 0.0f, 10, 10);
        tablerop = new Esfera(gl, 0, 0, 0, 3.5f * w / 35, h / 20, d / 9, 0.29f, 0.07f, 0.06f, 5, 5);
        patas = new Cilindro(gl, 0, 0, 0, 0.15f, 0.15f, 0.35f, 0.29f, 0.07f, 0.06f, 40, 40, 0.2f, 0.2f);
        borde = new Cilindro(gl, 0, 0, 0, 3.5f * w / 35, d / 9, h / 20, 0.29f, 0.07f, 0.06f, 40, 40, 1f, 1f);
        //FIN MESA REDONDA

        //MESA CUADRADA
        mesa = new Cubo(gl, 0, 0, 0, 7 * w / 35, h / 20, 3.5f * d / 18, 1.0f, 0.44f, 0.0f);
        eredonda = new Esfera(gl, 0, 0, 0, w / 45, h / 30, mesa.d / 1.95f, 1.0f, 0.44f, 0.0f, 10, 10);
        //FIN MESA CUADRADA 

        //PATA
        pata = new Cubo(gl, 0, 0, 0, mesa.w, mesa.h*5.5f, mesa.d/5, 0.29f, 0.07f, 0.06f);
        //FIN PATA 
        
        ///FIN MESAS
        
        
        //BARRA
        barra = new Cubo(gl, 0, 0, 0, 12.5f * w / 35, h / 20, d / 9, 1.0f, 0.44f, 0.0f);
        ebredonda = new Esfera(gl, 0, 0, 0, w / 45, h / 30, barra.d / 1.8f, 1.0f, 0.44f, 0.0f, 5, 5);
        barra2 = new Cubo(gl, 0, 0, 0, 1.5f * w / 35, h / 20, 1.5f * d / 18, 1.0f, 0.44f, 0.0f);
        ebredonda2 = new Esfera(gl, 0, 0, 0, barra2.w / 1.8f, h / 30, d / 45, 1.0f, 0.44f, 0.0f, 5, 5);
        cuerpo1 = new Cubo(gl, 0, 0, 0, 12.5f * w / 35, 29 * h / 100, d / 9, 0.29f, 0.07f, 0.06f);
        cuerpo2 = new Cubo(gl, 0, 0, 0, 1.5f * w / 35, 29 * h / 100, 1.5f * d / 18, 0.29f, 0.07f, 0.06f);
        //FIN BARRA

        //ESTANTE
        estante = new Cubo(gl, 0, 0, 0, 12f * w / 35, h / 20, d / 9, 0.67f, 0.23f, 0.05f);
        eeredonda = new Esfera(gl, 0, 0, 0, w / 45, h / 30, estante.d / 1.8f, 0.67f, 0.23f, 0.05f, 5, 5);
        cuerpoepf = new Cubo(gl, 0, 0, 0, 12f * w / 35, 0.55f, estante.d / 6, 0.3f, 0.07f, 0.07f);
        cuerpoeid = new Cubo(gl, 0, 0, 0, estante.d / 6, 0.55f, d / 9, 1.0f, 0.43f, 0.004f);
        //FIN ESTANTE

        //SOFA
        sofa1 = new Cubo(gl, 0, 0, 0, 3f * w / 35, h / 2, 0.75f * d / 18, 0.66f, 0.23f, 0.04f);
        sofap1 = new Cubo(gl, 0, 0, 0, 10f * w / 35, h / 4, d / 9, 0.66f, 0.23f, 0.04f);
        esredonda1 = new Esfera(gl, 0, 0, 0, sofa1.w / 2f, h / 50, sofa1.d / 1.8f, 0.9f, 0.32f, 0.15f, 5, 5);
        espredonda1 = new Esfera(gl, 0, 0, 0, sofap1.w / 2, h / 50, sofap1.d / 2f, 0.9f, 0.32f, 0.15f, 5, 5);
        //FIN SOFA

        //BOTELLAS
        botella = new Esfera(gl, 0, 0, 0, estante.w / 15, 1.6f * estante.h, estante.d / 3.5f, 0.3f, 0.2f, 0.0f, 5, 5);
        botellacb = new Cubo(gl, 0, 0, 0, estante.w / 7.8f, 1.3f * estante.h, 1.3f * botella.d, 0.3f, 0.2f, 0.0f);
        botellac = new Cilindro(gl, 0, 0, 0, botellacb.w / 1.2f, botellacb.d, botellacb.h, 0.3f, 0.2f, 0.02f, 30, 30, 0.2f, 0.2f);
        botellat = new Cilindro(gl, 0, 0, 0, botellacb.w / 1.2f, botellacb.d, botellacb.h / 2, 1, 0.62f, 0.008f, 30, 30, 0.2f, 0.2f);
        botellacn = new Cilindro(gl, 0, 0, 0, botellacb.w * 2.9f, botellacb.d * 4.8f, botella.h / 1.7f, 0.7f, 0.7f, 0.7f, 30, 30, 0.2f, 0.2f);

        botella1 = new Esfera(gl, 0, 0, 0, estante.w / 15, 1.6f * estante.h, estante.d / 3.5f, 0.5f, 0.0f, 0.1f, 5, 5);
        botellacb1 = new Cubo(gl, 0, 0, 0, estante.w / 7.8f, 1.3f * estante.h, 1.3f * botella.d, 0.5f, 0.0f, 0.1f);
        botellac1 = new Cilindro(gl, 0, 0, 0, botellacb.w / 1.2f, botellacb.d, botellacb.h, 0.5f, 0.0f, 0.1f, 30, 30, 0.2f, 0.2f);
        botellat1 = new Cilindro(gl, 0, 0, 0, botellacb.w / 1.2f, botellacb.d, botellacb.h / 2, 1, 0.62f, 0.008f, 30, 30, 0.2f, 0.2f);
        botellacn1 = new Cilindro(gl, 0, 0, 0, botellacb.w * 2.9f, botellacb.d * 4.8f, botella.h / 1.7f, 0.7f, 0.7f, 0.7f, 30, 30, 0.2f, 0.2f);

        botella2 = new Esfera(gl, 0, 0, 0, estante.w / 15, 1.6f * estante.h, estante.d / 3.5f, 0.7f, 0.3f, 0.0f, 5, 5);
        botellacb2 = new Cubo(gl, 0, 0, 0, estante.w / 7.8f, 1.3f * estante.h, 1.3f * botella.d, 0.7f, 0.3f, 0.0f);
        botellac2 = new Cilindro(gl, 0, 0, 0, botellacb.w / 1.2f, botellacb.d, botellacb.h, 0.7f, 0.3f, 0.0f, 30, 30, 0.2f, 0.2f);
        botellat2 = new Cilindro(gl, 0, 0, 0, botellacb.w / 1.2f, botellacb.d, botellacb.h / 2, 1, 0.62f, 0.008f, 30, 30, 0.2f, 0.2f);
        botellacn2 = new Cilindro(gl, 0, 0, 0, botellacb.w * 2.9f, botellacb.d * 4.8f, botella.h / 1.7f, 0.7f, 0.7f, 0.7f, 30, 30, 0.2f, 0.2f);
        //FIN BOTELLAS

        //MAQUINA
        maquina = new Cubo(gl, 0, 0, 0, 5.5f * w / 35, h / 2.5f, d / 18, 0.96f, 0.5f, 0.12f);
        emqredonda = new Esfera(gl, 0, 0, 0, maquina.w / 2f, h / 10, maquina.d / 2, 0.5f, 0.0f, 0.1f, 10, 10);
        emqredonda1 = new Esfera(gl, 0, 0, 0, maquina.w / 2f, h / 10, maquina.d / 2f, 0.96f, 0.5f, 0.12f, 10, 10);
        cuerpomq = new Esfera(gl, 0, 0, 0, maquina.w / 2.5f, h / 9f, maquina.d / 2f, 0.5f, 0.0f, 0.1f, 10, 10);
        maquina1 = new Cubo(gl, 0, 0, 0, maquina.w / 1.25f, maquina.h / 1.3f, 1.2f * maquina.d, 0.5f, 0.0f, 0.1f);
        lineamq = new Cubo(gl, 0, 0, 0, maquina1.w, h / 16f, d / 16, 0.9f, 1.0f, 0.0f);
        maqc = new Torus(gl, 0, 0, 0, maquina1.w / 2, maquina1.h / 1.5f, 1.2f * maquina1.d, 1.0f, 1.0f, 0.4f, 0.1f, 0.5f, 15, 15);
        maqsp = new Cubo(gl, 0, 0, 0, maquina.w / 2.5f, maquina.h / 7, maquina.d, 1f, 0.38f, 0.01f);
        espredonda = new Esfera(gl, 0, 0, 0, maqsp.w / 2f, maqsp.h / 1.8f, maqsp.d / 3, 1f, 0.38f, 0.01f, 5, 5);
        maqlid = new Cilindro(gl, 0, 0, 0, maquina.w / 3, 1.2f * maquina.d, maquina.h, 1f, 0.38f, 0.01f, 30, 30, 0.2f, 0.2f);
        emlidredonda = new Esfera(gl, 0, 0, 0, maqlid.w / 4.8f, maqlid.d / 18f, maqlid.h / 3.5f, 1f, 0.38f, 0.01f, 5, 5);
        lnc = new Cubo(gl, 0, 0, 0, maquina1.w / 5, maquina1.h / 8.5f, maquina1.d, 0.98f, 0.58f, 0.04f);
        lnc1 = new Cubo(gl, 0, 0, 0, maquina1.w / 6.5f, maquina1.h / 5.5f, maquina1.d, 0.55f, 0.2f, 0.08f);
        //FIN MAQUINA
    }

    public void dibujarRestaurante() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        //Teclado.rotarY(gl);
        gl.glRotatef(ang,0,1,0);
        dibujarExterior();

        dibujarInterior();
        gl.glPopMatrix();
    }

    public void dibujarExterior() {
        //Pared frontal        
        
        pfp.paredes(15, pfp, pfp1,w, h, d / 28, -w / 2, -h / 2.25f, 0, 0.51f, 0.15f, 0.03f,0.25f, 0.05f, 0.02f);

        gl.glPushMatrix();
        gl.glTranslatef(-w / 2, -h / 2.25f, 0);
        gl.glPushMatrix();
        gl.glTranslatef(9.9f*w/20,h/1.2f,d/10);
        letrero.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(-letrero.w/2.8f,0,letrero.d/2.3f);       
        //G
        letra.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/1.2f,letra.h/2.5f,0);
        gl.glScalef(0.68f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/1.2f,-letra.h/2.5f,0);
        gl.glScalef(0.68f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(2*letra.w,-letra.h/4.5f,0);
        gl.glScalef(1,0.5f,1);        
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        
         gl.glPushMatrix();
        gl.glTranslatef(1.5f*letra.w,-letra.h/18,0);
        gl.glScalef(0.2f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        //FIN G
        
        //R
        gl.glPushMatrix();
        gl.glTranslatef(4.7f*letra.w,0,0);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(letra.w/1.2f,letra.h/2.5f,0);
        gl.glScalef(0.68f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(6*letra.w,letra.h/2.5f,0);
        gl.glScalef(0.5f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(6*letra.w,letra.h/12f,0);
        gl.glScalef(0.5f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(6*letra.w,-letra.h/8f,0);
        gl.glScalef(0.5f,1,1);
        gl.glRotatef(-120,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(6.8f*letra.w,letra.h/5f,0);
        gl.glScalef(1f,0.4f,1);        
        letra.dibujarCubo();
        gl.glPopMatrix();
        //FIN R
        
        //I
        
        gl.glPushMatrix();
        gl.glTranslatef(9.3f*letra.w,0,0);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(9.3f*letra.w,letra.h/2.4f,0);
        gl.glScalef(0.4f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(9.3f*letra.w,-letra.h/2.4f,0);
        gl.glScalef(0.4f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        //FIN I
        
        //L1
        gl.glPushMatrix();
        gl.glTranslatef(12.3f*letra.w,0,0);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(13.6f*letra.w,-letra.h/2.6f,0);
        gl.glScalef(0.5f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        //FIN L1
        
        //L2
        gl.glPushMatrix();
        gl.glTranslatef(16.3f*letra.w,0,0);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(17.6f*letra.w,-letra.h/2.6f,0);
        gl.glScalef(0.5f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        //FIN L2
        
        //B
        gl.glPushMatrix();
        gl.glTranslatef(20.3f*letra.w,0,0);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(22.3f*letra.w,0,0);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(21.6f*letra.w,0,0);
        gl.glScalef(0.4f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(21.6f*letra.w,-letra.h/2.6f,0);
        gl.glScalef(0.5f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(21.6f*letra.w,letra.h/2.6f,0);
        gl.glScalef(0.5f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        //FIN B
        
        //Y
        gl.glPushMatrix();
        gl.glTranslatef(25.3f*letra.w,letra.h/8,0);
        gl.glScalef(0.5f,0.8f,1);
        gl.glRotatef(-135,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(26.3f*letra.w,-letra.h/3,0);
        gl.glScalef(1,0.5f,1);        
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(27.3f*letra.w,letra.h/8,0);
        gl.glScalef(0.5f,0.8f,1);
        gl.glRotatef(135,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        //FIN Y
        
        //APOSTROFE
        gl.glPushMatrix();
        gl.glTranslatef(29.5f*letra.w,letra.h/3,0);
        gl.glScalef(1,0.3f,1);        
        letra.dibujarCubo();
        gl.glPopMatrix();
        //FIN APOSTROFE
        
        //S
        gl.glPushMatrix();
        gl.glTranslatef(31.5f*letra.w,letra.h/3.5f,0);
        gl.glScalef(1,0.4f,1);        
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(33.5f*letra.w,-letra.h/3.5f,0);
        gl.glScalef(1,0.4f,1);        
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(32.5f*letra.w,0,0);
        gl.glScalef(0.6f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(32.5f*letra.w,-letra.h/2.6f,0);
        gl.glScalef(0.6f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(32.5f*letra.w,letra.h/2.6f,0);
        gl.glScalef(0.6f,1,1);
        gl.glRotatef(90,0,0,1);
        letra.dibujarCubo();
        gl.glPopMatrix();
        //FIN S
        
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        gl.glPopMatrix();
        
        //FIN LETRAS
        
        gl.glPushMatrix();
        gl.glTranslatef(7f*w/35,-h/4,0);
        puerta.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(-puerta.w/2,0,puerta.d/2);
        pBorde.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(puerta.w/2,0,puerta.d/2);
        pBorde.dibujarCubo();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(0,puerta.h/2,puerta.d/2);
        gl.glScalef(6,0.13f,1);
        pBorde.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,-puerta.h/2,puerta.d/2);
        gl.glScalef(6f,0.3f,0.6f);
        gl.glRotatef(90,1,0,0);        
        pBorde.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,0,puerta.d/2);
        gl.glScalef(6f,0.3f,0.1f);
        gl.glRotatef(90,1,0,0);        
        pBorde.dibujarCubo();
        gl.glPopMatrix();
        
        //PUERTA S
        gl.glPushMatrix();
        gl.glScalef(0.1f,0.1f,0.15f);
        suelo(3,-4f*puerta.w,6f*puerta.h,puerta.d/2,puertaS1,puertaS2,20,1,0,0);
        gl.glPopMatrix();
        //FIN PUERTA S
        
        gl.glPopMatrix();
        
        
        
//        Pared posterior
          pfp.paredes(15, pfp, pfp1,w, h, d / 28, -w / 2, -h / 2.25f, -d, 0.51f, 0.15f, 0.03f,0.25f, 0.05f, 0.02f);

//        Pared lateral izquierda
        gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(d / w, 1, 1);        
        pfp.paredes(15, pfp, pfp1,w, h, d / 28, d / 305, -h / 2.25f, -w / 1.85f, 0.51f, 0.15f, 0.03f,0.25f, 0.05f, 0.02f);
        gl.glPopMatrix();

//        Pared lateral izquierda
        gl.glPushMatrix();
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(d / w, 1, 1);
        pfp.paredes(15, pfp, pfp1,w, h, d / 28, d / 305, -h / 2.25f, w / 1.85f, 0.51f, 0.15f, 0.03f,0.25f, 0.05f, 0.02f);
        gl.glPopMatrix();

        //TECHO
        gl.glPushMatrix();
        gl.glTranslatef(0, h / 1.6f, -d / 2);
        techo.dibujarCubo();
        
        //Nieve
        gl.glPushMatrix();
        gl.glTranslatef(0,techo.h/2,0);
        nieve.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN TECHO

        gl.glPushMatrix();
        gl.glScalef(0.95f,0.6f,0.85f);
        suelo(5,-w/2,-h/1.2f,-1.1f*d,suelo,suelo1,0,0,0,0);
        gl.glPopMatrix();
    }

    public void dibujarInterior() {

        ////MESAS
        //MESA CIRCULAR
        gl.glPushMatrix();
        gl.glScalef(0.7f, 1, 0.7f);
        mesaCircular(-22.5f * w / 35, -h / 5, -15.5f * d / 18);
        gl.glPopMatrix();
        //FIN MESA CIRCULAR

        //MESA CUADRADA
        gl.glPushMatrix();
        gl.glScalef(1, 1, 0.85f);
        mesaCuadrada(-7.5f * w / 35f, -h / 5, -8.45f * d / 18);
        gl.glPopMatrix();
        //FIN MESA CUADRADA

        //MESA PEQUEÑA
        gl.glPushMatrix();
        gl.glScalef(0.57f, 1, 0.57f);
        mesaCuadrada(-18.5f * w / 35, -h / 5, -4f * d / 18);
        gl.glPopMatrix();
        //FIN MESA PEQUEÑA

        ////FIN MESAS
        //BARRA
        gl.glPushMatrix();
        gl.glScalef(1, 0.85f, 1);
        barra(0, -h / 4, -13.25f * d / 18);
        gl.glPopMatrix();
        //FIN BARRA

        //TABURETES
        gl.glPushMatrix();
        gl.glScalef(0.4f, 0.75f, 0.4f);
        mesaCircular(-12.5f * w / 35, -h / 2.5f, -1.55f * d);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glScalef(0.4f, 0.75f, 0.4f);
        mesaCircular(-4.5f * w / 35, -h / 2.5f, -1.55f * d);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glScalef(0.4f, 0.75f, 0.4f);
        mesaCircular(3.5f * w / 35, -h / 2.5f, -1.55f * d);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glScalef(0.4f, 0.75f, 0.4f);
        mesaCircular(11.5f * w / 35, -h / 2.5f, -1.55f * d);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glScalef(0.35f, 0.72f, 0.35f);
        mesaCircular(-34f * w / 35, -h / 2.6f, -1.68f * d);
        gl.glPopMatrix();
        //FIN TABURETES

        //ESTANTE
        estante(0, -h / 21, -17 * d / 18);
        //FIN ESTANTE                

        //SOFAS
        //SOFA1
        gl.glPushMatrix();
        gl.glScalef(0.75f, 0.8f, 0.8f);
        sofa(16 * w / 35, -h / 3, -1.25f * d / 18, 0);
        //SOFA2       
        sofa(16 * w / 35, -h / 3, -6.8f * d / 18, 0.15f);
        //SOFA3
        sofa(16 * w / 35, -h / 3, -8.15f * d / 18, 0);
        //SOFA 4
        sofa(16 * w / 35, -h / 3, -13.3f * d / 18, 0.15f);
        gl.glPopMatrix();
        //FIN SOFAS

        //MESAS SOFA
        gl.glPushMatrix();
        gl.glScalef(0.8f,1,0.55f);
        monoMesa(18 * w / 35, -h / 5, -6f * d / 18);  
        gl.glPopMatrix();
        
        
        gl.glPushMatrix();
        gl.glScalef(0.8f,1,0.55f);
        monoMesa(18 * w / 35, -h / 5, -16.2f * d / 18);        
        gl.glPopMatrix();
        
       
        //FIN MESAS SOFA
        
        //MAQUINA
        maquina(13.5f * w / 35, -h / 3.2f, -17 * d / 18);
        //FIN MAQUINA

    }

    public void suelo(int n, float x, float y, float z,Cubo c1, Cubo c2,float ang, float x1,float y1,float z1){
        c1.w = w / n;
        c1.d = d / n;
        c2.w = w / n;
        c2.d = d / n;
        
        gl.glPushMatrix();
        gl.glRotatef(ang,x1,y1,z1);
        //PARED FRONTAL 1
        //FILA
        //COLOR1
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);        
        c1.dibujarCubo();

        for (int i = 0; i < n / 2; i++) {
            gl.glTranslatef(2 * c1.w, 0, 0);
            c1.dibujarCubo();
        }
        gl.glPopMatrix();
        //FIN COLOR1
        //COLOR2
        gl.glPushMatrix();
        gl.glTranslatef(x + c1.w, y, z);
        c2.dibujarCubo();
        for (int i = 0; i < n / 2; i++) {
            gl.glTranslatef(2 * c1.w, 0, 0);
            c2.dibujarCubo();
        }
        gl.glPopMatrix();
        //FIN COLOR2
        //FIN FILA

        //COLUMNAS
        gl.glPushMatrix();
        for (int j = 0; j < n / 2; j++) {
            gl.glTranslatef(0, 0, 2 * c1.d);
            //COLOR1
            gl.glPushMatrix();
            gl.glTranslatef(x, y, z);
            c1.dibujarCubo();
            for (int i = 0; i < n / 2; i++) {
                gl.glTranslatef(2 * c1.w, 0, 0);
                c1.dibujarCubo();
            }
            gl.glPopMatrix();
            //FIN COLOR1
            //COLOR2
            gl.glPushMatrix();
            gl.glTranslatef(x + c1.w, y, z);
            c2.dibujarCubo();
            for (int i = 0; i < n / 2; i++) {
                gl.glTranslatef(2 * c1.w, 0, 0);
                c2.dibujarCubo();
            }
            gl.glPopMatrix();
            //FIN COLOR2
        }
        gl.glPopMatrix();
        //FIN COLUMNAS
        //FIN PARED FRONTAL 1

        //PARED FRONTAL 2
        //FILA
        //COLOR1
        gl.glPushMatrix();
        gl.glTranslatef(x, y , z+ c2.d);
        c2.dibujarCubo();

        for (int i = 0; i < n / 2; i++) {
            gl.glTranslatef(2 * c2.w, 0, 0);
            c2.dibujarCubo();
        }
        gl.glPopMatrix();
        //FIN COLOR1
        //COLOR2
        gl.glPushMatrix();
        gl.glTranslatef(x + c2.w, y , z+ c2.d);
        c1.dibujarCubo();
        for (int i = 0; i < n / 2; i++) {
            gl.glTranslatef(2 * c2.w, 0, 0);
            c1.dibujarCubo();
        }
        gl.glPopMatrix();
        //FIN COLOR2
        //FIN FILA

        //COLUMNAS
        gl.glPushMatrix();
        for (int j = 0; j < n / 2; j++) {
            gl.glTranslatef(0, 0, 2 * c2.d);
            //COLOR1
            gl.glPushMatrix();
            gl.glTranslatef(x, y , z+ c1.d);
            c2.dibujarCubo();
            for (int i = 0; i < n / 2; i++) {
                gl.glTranslatef(2 * c2.w, 0, 0);
                c2.dibujarCubo();
            }
            gl.glPopMatrix();
            //FIN COLOR1
            //COLOR2
            gl.glPushMatrix();
            gl.glTranslatef(x + c2.w, y , z+ c1.d);
            c1.dibujarCubo();
            for (int i = 0; i < n / 2; i++) {
                gl.glTranslatef(2 * c2.w, 0, 0);
                c1.dibujarCubo();
            }
            gl.glPopMatrix();
            //FIN COLOR2
        }
        gl.glPopMatrix();
        //FIN COLUMNAS
        //FIN PARED FRONTAL 2
        gl.glPopMatrix();
    }

    public void maquina(float x, float y, float z) {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
//        Teclado.rotarY(gl);
        maquina.dibujarCubo();
        maquina1.dibujarCubo();

        gl.glPushMatrix();
        gl.glTranslatef(0, maquina1.h / 2.5f, maquina1.d / 1.3f);
        lnc.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-maquina1.w / 5.4f, maquina1.h / 2.5f, maquina1.d / 1.8f);
        lnc.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(maquina1.w / 5.4f, maquina1.h / 2.5f, maquina1.d / 1.8f);
        lnc.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-maquina1.w / 2.8f, maquina1.h / 2.5f, maquina1.d / 2.5f);
        lnc1.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(maquina1.w / 2.8f, maquina1.h / 2.5f, maquina1.d / 2.5f);
        lnc1.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, -maquina1.h / 4f, maquina1.d / 1.5f);
        lnc1.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glRotatef(90, 1, 0, 0);
        gl.glTranslatef(-maquina.w / 2.4f, maquina.d / 1.6f, -maquina.h / 2);
        maqlid.dibujarCilindro();

        gl.glPushMatrix();
        gl.glTranslatef(0, maqlid.d / 38, 0);
        emlidredonda.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glRotatef(90, 1, 0, 0);
        gl.glTranslatef(maquina.w / 2.4f, maquina.d / 1.6f, -maquina.h / 2);
        maqlid.dibujarCilindro();

        gl.glPushMatrix();
        gl.glTranslatef(0, maqlid.d / 38, 0);
        emlidredonda.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, maquina1.h / 7, maquina1.d / 1.1f);
        maqc.dibujarTorus();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, -maquina1.h / 1.8f, 0);
        lineamq.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, maquina.h / 2, -maquina.d / 3f);
        emqredonda.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, maquina.h / 2, maquina.d / 3f);
        emqredonda1.dibujarEsfera();

        gl.glPushMatrix();
        gl.glTranslatef(0, emqredonda1.h / 1.5f, maquina.d / 7f);
        maqsp.dibujarCubo();

        gl.glPushMatrix();
        gl.glTranslatef(0, maqsp.h / 3f, maqsp.d / 3f);
        espredonda.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, maqsp.h / 3f, -maqsp.d / 3f);
        espredonda.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPopMatrix();

        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, maquina.h / 2.6f, maquina.d / 2f);
        cuerpomq.dibujarEsfera();
        gl.glPopMatrix();

        gl.glPopMatrix();
    }

    public void barra(float x, float y, float z) {
        //Barra principal
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);//**    
        //Teclado.rotarY(gl);
        barra.dibujarCubo();

        gl.glPushMatrix();
        gl.glTranslatef(0, y + this.h / 12, 0);//*
        cuerpo1.dibujarCubo();
        gl.glPopMatrix();

        //Esquina izq
        gl.glPushMatrix();
        gl.glTranslatef(-barra.w / 2f, 0, 0);
        ebredonda.dibujarEsfera();
        gl.glPopMatrix();
        //Esquina der
        gl.glPushMatrix();
        gl.glTranslatef(barra.w / 2f, 0, 0);
        ebredonda.dibujarEsfera();
        gl.glPopMatrix();
        gl.glPopMatrix();
        //FIN BARRA PRINCIPAL

        //Barra2
        gl.glPushMatrix();
        gl.glTranslatef(barra.w / 2.05f, y, z - 1.4f * this.d / 18);//*_
        //Teclado.rotarY(gl);
        barra2.dibujarCubo();

        //cuerpo
        gl.glPushMatrix();
        gl.glTranslatef(0, y + this.h / 30, 0);//*
        cuerpo2.dibujarCubo();
        gl.glPopMatrix();

        //Esquina izq
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, -barra2.d / 2);
        ebredonda2.dibujarEsfera();
        gl.glPopMatrix();
        //Esquina der
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, barra2.d / 2);
        ebredonda2.dibujarEsfera();
        gl.glPopMatrix();
        gl.glPopMatrix();
        //FIN BARRA2
    }

    public void mesaCircular(float x, float y, float z) {
        //TABLERO CIRCULAR
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);//**
        tablero.dibujarEsfera();
        gl.glPushMatrix();
        gl.glRotatef(90, 1, 0, 0);
        borde.dibujarCilindro();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(0, -2 * patas.h, 0);//*
        gl.glScalef(0.7f, 1, 0.7f);
        tablerop.dibujarEsfera();
        gl.glPopMatrix();
        //pata
        gl.glPushMatrix();
        gl.glRotatef(91, 1, 0, 0);
        patas.dibujarCilindro();
        gl.glPopMatrix();
        gl.glPopMatrix();
        //FIN TABLERO CIRCULAR 
    }

    public void mesaCuadrada(float x, float y, float z) {
        //Tablero cuadrado
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);//**
        //Teclado.rotarY(gl);
        mesa.dibujarCubo();
        //Esquina izq
        gl.glPushMatrix();
        gl.glTranslatef(-mesa.w / 2f, 0, 0);
        eredonda.dibujarEsfera();
        gl.glPopMatrix();
        //Esquina der
        gl.glPushMatrix();
        gl.glTranslatef(mesa.w / 2f, 0, 0);
        eredonda.dibujarEsfera();
        gl.glPopMatrix();

        //pata 1
        gl.glPushMatrix();
        gl.glRotatef(91, 1, 0, 0);
        gl.glTranslatef(-mesa.w / 2.1f, mesa.d / 3.2f, 0);
        patas.dibujarCilindro();
        gl.glPopMatrix();

        //pata 2
        gl.glPushMatrix();
        gl.glRotatef(91, 1, 0, 0);
        gl.glTranslatef(mesa.w / 2.1f, mesa.d / 3.2f, 0);
        patas.dibujarCilindro();
        gl.glPopMatrix();

        //pata 3
        gl.glPushMatrix();
        gl.glRotatef(91, 1, 0, 0);
        gl.glTranslatef(-mesa.w / 2.1f, -mesa.d / 3.2f, 0);
        patas.dibujarCilindro();
        gl.glPopMatrix();

        //pata 4
        gl.glPushMatrix();
        gl.glRotatef(91, 1, 0, 0);
        gl.glTranslatef(mesa.w / 2.1f, -mesa.d / 3.2f, 0);
        patas.dibujarCilindro();
        gl.glPopMatrix();

        gl.glPopMatrix();
        //FIN TABLERO CUADRADO   
    }
    
    public void monoMesa(float x, float y, float z){
        //Tablero cuadrado
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);//**
        //Teclado.rotarY(gl);
        mesa.dibujarCubo();
        //Esquina izq
        gl.glPushMatrix();
        gl.glTranslatef(-mesa.w / 2f, 0, 0);
        eredonda.dibujarEsfera();
        gl.glPopMatrix();
        //Esquina der
        gl.glPushMatrix();
        gl.glTranslatef(mesa.w / 2f, 0, 0);
        eredonda.dibujarEsfera();
        gl.glPopMatrix();
        
        //botellas
        gl.glPushMatrix();       
        gl.glScalef(0.6f, 0.75f, 0.65f);
        botella(0, 2.3f*mesa.h, -mesa.d/3, botella2, botellacn2, botellac2, botellat2, botellacb2);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glScalef(0.7f, 0.65f, 0.65f);
        botella(mesa.w/3, 2.3f*mesa.h, -mesa.d/5, botella1, botellacn1, botellac1, botellat1, botellacb1);
        gl.glPopMatrix();
        //fin botellas
        
        gl.glPushMatrix();
        gl.glTranslatef(0,-3f*mesa.h,0);
        pata.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
    }

    public void sofa(float w, float h, float d, float z) {
        //SOFA1

        gl.glPushMatrix();
        gl.glTranslatef(w, h, d);//*
        sofa1.dibujarCubo();
        //Esquina izq
        gl.glPushMatrix();
        gl.glTranslatef(0, sofa1.h / 2, 0);
        esredonda1.dibujarEsfera();
        gl.glPopMatrix();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(w + 3.3f * this.w / 35, h, d);//*
        sofa1.dibujarCubo();
        //Esquina izq
        gl.glPushMatrix();
        gl.glTranslatef(0, sofa1.h / 2, 0);
        esredonda1.dibujarEsfera();
        gl.glPopMatrix();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(w + 6.6f * this.w / 35, h, d);//*
        sofa1.dibujarCubo();
        //Esquina izq
        gl.glPushMatrix();
        gl.glTranslatef(0, sofa1.h / 2, 0);
        esredonda1.dibujarEsfera();
        gl.glPopMatrix();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(w + 3.5f * this.w / 35, h - 0.13f * this.h, d - 0.55f * this.d / 18);//*
        gl.glTranslatef(0, 0, z);
        sofap1.dibujarCubo();
        //parte redonda
        gl.glPushMatrix();
        gl.glTranslatef(0, sofap1.h / 2, 0);
        espredonda1.dibujarEsfera();
        gl.glPopMatrix();
        gl.glPopMatrix();
        //FIN SOFA

    }

    public void estante(float x, float y, float z) {
        //ESTANTE
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);//**
        //Teclado.rotarY(gl);
        estante.dibujarCubo();

        //Esquina izq
        gl.glPushMatrix();
        gl.glTranslatef(-estante.w / 2, 0, 0);
        eeredonda.dibujarEsfera();
        gl.glPopMatrix();
        //Esquina der
        gl.glPushMatrix();
        gl.glTranslatef(estante.w / 2, 0, 0);
        eeredonda.dibujarEsfera();
        gl.glPopMatrix();

        //cuerpo estante
        //posterior
        gl.glPushMatrix();
        gl.glTranslatef(0, -5.1f * estante.h, -estante.d / 2.5f);
        cuerpoepf.dibujarCubo();
        gl.glPopMatrix();
        //lateral d
        gl.glPushMatrix();
        gl.glTranslatef(-estante.w / 2, -5.1f * estante.h, 0);
        cuerpoeid.dibujarCubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(estante.w / 2, -5.1f * estante.h, 0);
        cuerpoeid.dibujarCubo();
        gl.glPopMatrix();

        //parte media
        gl.glPushMatrix();
        gl.glTranslatef(0, -cuerpoepf.h / 2, 0);
        estante.dibujarCubo();
        gl.glPopMatrix();

        //parte baja
        gl.glPushMatrix();
        gl.glTranslatef(0, -cuerpoepf.h, 0);
        estante.dibujarCubo();
        gl.glPopMatrix();

        //BOTELLAS
        //BOTELLA1
        gl.glPushMatrix();
        gl.glScalef(0.75f, 0.75f, 0.75f);
        botella(-estante.w / 2.1f, -cuerpoepf.h / 2.45f, -estante.d / 3f, botella, botellacn, botellac, botellat, botellacb);
        gl.glPopMatrix();
        //FIN BOTELLA1
        //BOTELLA2
        gl.glPushMatrix();
        gl.glScalef(0.75f, 0.75f, 0.75f);
        botella(estante.w / 2.1f, -cuerpoepf.h / 2.45f, -estante.d / 3f, botella, botellacn, botellac, botellat, botellacb);
        gl.glPopMatrix();
        //FIN BOTELLA2
        //BOTELLA3
        gl.glPushMatrix();
        gl.glScalef(0.75f, 0.75f, 0.75f);
        botella(estante.w / 2.1f, -1.08f * cuerpoepf.h, -estante.d / 3f, botella, botellacn, botellac, botellat, botellacb);
        gl.glPopMatrix();
        //FIN BOTELLA3
        //BOTELLA4
        gl.glPushMatrix();
        gl.glScalef(0.75f, 0.75f, 0.75f);
        botella(-estante.w / 2.1f, -1.08f * cuerpoepf.h, -estante.d / 3f, botella, botellacn, botellac, botellat, botellacb);
        gl.glPopMatrix();
        //FIN BOTELLA4
        //BOTELLA5
        gl.glPushMatrix();
        gl.glScalef(0.7f, 0.65f, 0.65f);
        botella(-estante.w / 3f, -cuerpoepf.h / 2f, -estante.d / 3f, botella1, botellacn1, botellac1, botellat1, botellacb1);
        gl.glPopMatrix();
        //FIN BOTELLA5
        //BOTELLA6
        gl.glPushMatrix();
        gl.glScalef(0.7f, 0.65f, 0.65f);
        botella(estante.w / 3f, -cuerpoepf.h / 2f, -estante.d / 3f, botella1, botellacn1, botellac1, botellat1, botellacb1);
        gl.glPopMatrix();
        //FIN BOTELLA6
        //BOTELLA7
        gl.glPushMatrix();
        gl.glScalef(0.7f, 0.65f, 0.65f);
        botella(estante.w / 3f, -1.27f * cuerpoepf.h, -estante.d / 3f, botella1, botellacn1, botellac1, botellat1, botellacb1);
        gl.glPopMatrix();
        //FIN BOTELLA7
        //BOTELLA8
        gl.glPushMatrix();
        gl.glScalef(0.7f, 0.65f, 0.65f);
        botella(-estante.w / 3, -1.27f * cuerpoepf.h, -estante.d / 3f, botella1, botellacn1, botellac1, botellat1, botellacb1);
        gl.glPopMatrix();
        //FIN BOTELLA8
        //BOTELLA9
        gl.glPushMatrix();
        gl.glScalef(0.6f, 0.75f, 0.65f);
        botella(-estante.w / 4.9f, -cuerpoepf.h / 2.5f, -estante.d / 3f, botella2, botellacn2, botellac2, botellat2, botellacb2);
        gl.glPopMatrix();
        //FIN BOTELLA9
        //BOTELLA10
        gl.glPushMatrix();
        gl.glScalef(0.6f, 0.75f, 0.65f);
        botella(estante.w / 4.9f, -cuerpoepf.h / 2.5f, -estante.d / 3f, botella2, botellacn2, botellac2, botellat2, botellacb2);
        gl.glPopMatrix();
        //FIN BOTELLA10
        //BOTELLA11
        gl.glPushMatrix();
        gl.glScalef(0.6f, 0.75f, 0.65f);
        botella(estante.w / 4.9f, -1.075f * cuerpoepf.h, -estante.d / 3f, botella2, botellacn2, botellac2, botellat2, botellacb2);
        gl.glPopMatrix();
        //FIN BOTELLA11
        //BOTELLA12
        gl.glPushMatrix();
        gl.glScalef(0.6f, 0.75f, 0.65f);
        botella(-estante.w / 4.9f, -1.075f * cuerpoepf.h, -estante.d / 3f, botella2, botellacn2, botellac2, botellat2, botellacb2);
        gl.glPopMatrix();
        //FIN BOTELLA12
        //BOTELLA13
        gl.glPushMatrix();
        gl.glScalef(0.75f, 0.55f, 0.75f);
        botella(0, -cuerpoepf.h / 1.62f, -estante.d / 3f, botella, botellacn, botellac, botellat, botellacb);
        gl.glPopMatrix();
        //FIN BOTELLA13
        //BOTELLA14
        gl.glPushMatrix();
        gl.glScalef(0.75f, 0.55f, 0.75f);
        botella(0, -1.54f * cuerpoepf.h, -estante.d / 3f, botella, botellacn, botellac, botellat, botellacb);
        gl.glPopMatrix();
        //FIN BOTELLA14
        //FIN BOTELLAS

        gl.glPopMatrix();
        //FIN ESTANTE
    }

    public void botella(float x, float y, float z, Esfera b, Cilindro bcn, Cilindro bc, Cilindro bt, Cubo bcb) {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        //Teclado.rotarY(gl);
        b.dibujarEsfera();

        gl.glPushMatrix();
        gl.glRotatef(90, 1, 0, 0);
        bcn.dibujarCilindro();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 1.5f * botella.h, 0);
        gl.glRotatef(90, 1, 0, 0);
        bc.dibujarCilindro();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 2f * botellac.h, 0);
        gl.glRotatef(90, 1, 0, 0);
        bt.dibujarCilindro();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, -botella.h / 1.5f, 0);
        bcb.dibujarCubo();
        gl.glPopMatrix();

        gl.glPopMatrix();
    }
}
