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
public class Casa {

   
    Cubo base1, base2, base3, base4, base5, base6,base7, base8,
         techo1,techo2,techo3,techo4,techo5,techo6,techo7,techo8,techo9,techo10,
         nieved,nievei,
         puerta,
         ventana, marco, marcosi;
    Esfera bolnieve,bolnieve1,bolnieve2,bolnieve3,bolnieve4;
    
    
    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;

    public Casa(GL gl, float x, float y, float z, float w, float h, float d,float a) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang=a;

        //objetos
        
        //bases
        base1 = new Cubo(gl, 0, 0, 0, w, h / 8, d, 0.5f, 0.3f, 0.0f);
        base2 = new Cubo(gl, 0,0+base1.h,0, w, h / 8, d, 0.4f, 0.2f, 0.1f);
        base3 = new Cubo(gl, 0, 0+base2.h, 0, w, h / 8, d, 0.5f, 0.3f, 0.0f);
        base4 = new Cubo(gl, 0, 0+base3.h, 0, w, h / 8, d, 0.4f, 0.2f, 0.1f);
        base5 = new Cubo(gl, 0,0+base4.h,0, w, h / 8, d, 0.5f, 0.3f, 0.0f);
        base6 = new Cubo(gl, 0,0+base5.h,0, w, h / 8, d, 0.4f, 0.2f, 0.1f);
        base7 = new Cubo(gl, 0,0+base6.h,0, w-w/3, h / 8, d, 0.5f, 0.3f, 0.0f);
        base8 = new Cubo(gl, 0,0+base7.h,0, w-w/1.5f, h / 8, d, 0.4f, 0.2f, 0.1f);
        
        //techos
        //derecha
        techo1 = new Cubo(gl, 0+w/11,0-h/2f,0, w/35, h / 8, d+0.1f, 0.5f, 0.3f, 0.0f);
        techo2 = new Cubo(gl, 0+w/17,0-3*techo1.h,0, w/35, h / 8, d+0.1f, 0.4f, 0.2f, 0.1f);
        techo3 = new Cubo(gl, 0+w/21,0-2*techo2.h,0, w/35, h / 8, d+0.1f, 0.5f, 0.3f, 0.0f);
        techo4 = new Cubo(gl, 0+w/25,0-techo3.h,0, w/35, h / 8, d+0.1f, 0.4f, 0.2f, 0.1f);
        techo5 = new Cubo(gl, 0+w/24,0-h/55,0, w/35, h / 8, d+0.1f, 0.5f, 0.3f, 0.0f);
        //izquierda
        techo6 = new Cubo(gl, 0-w/11,0-h/2f,0, w/35, h / 8, d+0.1f, 0.5f, 0.3f, 0.0f);
        techo7 = new Cubo(gl, 0-w/17,0-3*techo1.h,0, w/35, h / 8, d+0.1f, 0.4f, 0.2f, 0.1f);
        techo8 = new Cubo(gl, 0-w/21,0-2*techo2.h,0, w/35, h / 8, d+0.1f, 0.5f, 0.3f, 0.0f);
        techo9 = new Cubo(gl, 0-w/25,0-techo3.h,0, w/35, h / 8, d+0.1f, 0.4f, 0.2f, 0.1f);
        techo10 = new Cubo(gl, 0-w/24,0-h/55,0, w/35, h / 8, d+0.1f, 0.5f, 0.3f, 0.0f);
        
        //nieve
        nieved = new Cubo(gl, 0+w/12,0-h/3.4f,0, w/35, h/1.5f, d+0.1f, 0.9f, 0.9f, 1.0f);
        nievei = new Cubo(gl, 0-w/12,0-h/3.4f,0, w/35, h/1.5f, d+0.1f, 0.9f, 0.9f, 1.0f);
        bolnieve= new Esfera(gl, 0, 0, 0, w/12.5f, h/40f, d/10f, 0.9f, 0.9f, 1.0f, 5, 5);

        
        puerta = new Cubo(gl, 0, 0, 0, w / 3, h / 3, d / 10, 0.6f, 0.4f, 0.2f);
        ventana = new Cubo(gl, 0, 0, 0, w / 5, h / 6, d / 10, 0.8f, 0.9f, 1f);
        marco = new Cubo(gl, 0, 0, 0, w / 20, h / 6, d / 10, 0.6f, 0.4f, 0.2f);
        marcosi = new Cubo(gl, 0, 0, 0, w / 3.2f, h / 37, d / 4.5f, 0.6f, 0.4f, 0.2f);
//        ventana = new Cuadrado(gl, 0, 0, 0, w / 2, h / 8, d, 0.8f, 0.9f, 1f);
    }

    public void dibujarCasa() {

        gl.glPushMatrix();
          
        //BASE
        gl.glTranslatef(x,y,z);
        gl.glRotatef(ang,0,1,0);
//        Teclado.rotarY(gl);
        base1.dibujarCubo();       
        base2.dibujarCubo();
        base3.dibujarCubo();
        base4.dibujarCubo();
        base5.dibujarCubo();
        base6.dibujarTrapecio(w/6);
        base7.dibujarTrapecio(w/6);
        base8.dibujarTrapecio(w/6);
        
        //Techos
        //Derecha
        gl.glPushMatrix();
        gl.glRotatef(45,0,0,1);
        techo1.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(48,0,0,1);
        techo2.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(50,0,0,1);
        techo3.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(52,0,0,1);
        techo4.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(54,0,0,1);
        techo5.dibujarCubo();        
        gl.glPopMatrix();
        //Izquierda
        gl.glPushMatrix();
        gl.glRotatef(-45,0,0,1);
        techo6.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(-48,0,0,1);
        techo7.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(-50,0,0,1);
        techo8.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(-52,0,0,1);
        techo9.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(-54,0,0,1);
        techo10.dibujarCubo();        
        gl.glPopMatrix();
        
        //Nieve
        gl.glPushMatrix();
        gl.glRotatef(48,0,0,1);
        nieved.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(-48,0,0,1);
        nievei.dibujarCubo();
        gl.glPopMatrix();
        

        
        gl.glPushMatrix();
        gl.glTranslatef(w/4,-h/2.5f,d/2);
        ventana.dibujarCubo();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(-w/4,-h/2.5f,d/2);
        ventana.dibujarCubo();
        
        gl.glPopMatrix();
        
        
        //Marco ventanas
        //Izquierda
        gl.glPushMatrix();
        gl.glTranslatef(-w/2.64f,-h/2.5f,d/2);
        marco.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-w/8.4f,-h/2.5f,d/2);
        marco.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();       
        gl.glTranslatef(-w/3.965f,-h/3.40f,d/2);
        marcosi.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();       
        gl.glTranslatef(-w/3.95f,-h/1.98f,d/2);    
        marcosi.dibujarCubo();
        gl.glPopMatrix();
        
        //nieve marco
        gl.glPushMatrix();
        gl.glTranslatef(-w/2.95f,-h/2.05f,d/1.8f);
        bolnieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-w/3.95f,-h/2.08f,d/1.9f);
        bolnieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-w/5.8f,-h/2.03f,d/1.85f);
        bolnieve.dibujarEsfera();
        gl.glPopMatrix();
        
        
        //Derecha
       gl.glPushMatrix();
        gl.glTranslatef(w/2.64f,-h/2.5f,d/2);
        marco.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(w/8.4f,-h/2.5f,d/2);
        marco.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();       
        gl.glTranslatef(w/3.965f,-h/3.40f,d/2);
        marcosi.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();       
        gl.glTranslatef(w/3.95f,-h/1.98f,d/2);    
        marcosi.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,-h/1.3f,d/2);
        puerta.dibujarCubo();
        gl.glPopMatrix();
        
        //nieve marco
        gl.glPushMatrix();
        gl.glTranslatef(w/2.95f,-h/2.05f,d/1.8f);
        bolnieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(w/3.95f,-h/2.08f,d/1.9f);
        bolnieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(w/5.8f,-h/2.03f,d/1.85f);
        bolnieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
    }

        public void dibujarCasaV() {

        gl.glPushMatrix();
          
        //BASE
        gl.glTranslatef(x,y,z);
        gl.glRotatef(ang,0,1,0);
//        Teclado.rotarY(gl);
        base1.dibujarCubo();       
        base2.dibujarCubo();
        base3.dibujarCubo();
        base4.dibujarCubo();
        base5.dibujarCubo();
        base6.dibujarTrapecio(w/6);
        base7.dibujarTrapecio(w/6);
        base8.dibujarTrapecio(w/6);
        
        //Techos
        //Derecha
        gl.glPushMatrix();
        gl.glRotatef(45,0,0,1);
        techo1.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(48,0,0,1);
        techo2.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(50,0,0,1);
        techo3.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(52,0,0,1);
        techo4.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(54,0,0,1);
        techo5.dibujarCubo();        
        gl.glPopMatrix();
        //Izquierda
        gl.glPushMatrix();
        gl.glRotatef(-45,0,0,1);
        techo6.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(-48,0,0,1);
        techo7.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(-50,0,0,1);
        techo8.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(-52,0,0,1);
        techo9.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(-54,0,0,1);
        techo10.dibujarCubo();        
        gl.glPopMatrix();
        
        //Nieve
        gl.glPushMatrix();
        gl.glRotatef(48,0,0,1);
        nieved.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(-48,0,0,1);
        nievei.dibujarCubo();
        gl.glPopMatrix();                
        
        gl.glPopMatrix();
        }
    
        public void puerta(float x,float y,float z){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        puerta.dibujarCubo();
        gl.glPopMatrix();
        }
 

}
