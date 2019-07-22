/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

/**
 *
 * @author Alison
 */
public class Cubo {
    
    //GL
    GL gl;
    //coordenadas
    float x,y,z;
    //dimensiones
    float w,h,d; //ancho, alto, profundidad
    //colores
    float c1,c2,c3;
    
    
    public Cubo(GL gl, float x, float y, float z, float w, float h, float d, float c1, float c2, float c3) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;        
    }

    
    
    
    public void dibujarCubo(){
       
       
     gl.glTranslatef(x,y,z);
        float w1=w/2;
        float h1=h/2;
        float d1=d/2;
        
        //BASE
        
        gl.glBegin(gl.GL_QUADS);
       
        gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glEnd();
        
        //SUPERIOR
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3-0.2f);
        gl.glVertex3f(0-w1, 0+h1, 0+d1);
        gl.glVertex3f(0+w1, 0+h1, 0+d1);
        gl.glVertex3f(0+w1, 0+h1, 0-d1);
        gl.glVertex3f(0-w1, 0+h1, 0-d1);
        gl.glEnd();
        
        //FRONTAL
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0+h1, 0+d1);
        gl.glVertex3f(0-w1, 0+h1, 0+d1);
        gl.glEnd();
        
        //POSTERIOR
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2-0.1f,c3-0.2f);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1, 0+h1, 0-d1);
        gl.glVertex3f(0-w1, 0+h1, 0-d1);
        gl.glEnd();
        
        //LATERAL IZQUIERDA
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2-0.2f,c3-0.2f);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glVertex3f(0-w1, 0+h1, 0-d1);
        gl.glVertex3f(0-w1, 0+h1, 0+d1);
        gl.glEnd();
        
        //LATERAL DERECHA
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2-0.2f,c3-0.2f);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1, 0+h1, 0-d1);
        gl.glVertex3f(0+w1, 0+h1, 0+d1);
        gl.glEnd();
        
    }    
    
    public void wireCubo(){
        GLUT glut=new GLUT();
        gl.glPushMatrix();
        gl.glColor3f(c1, c2, c3);
        gl.glScalef(w,h,d);       
        glut.glutWireCube(1);
        gl.glPopMatrix();
    }
    
    
    public void dibujarTrapecio(float r){
               
     gl.glTranslatef(x,y,z);
        float w1=w/2;
        float h1=h/2;
        float d1=d/2;
        
        //BASE
        
        gl.glBegin(gl.GL_QUADS);
       
        gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glEnd();
        
        //SUPERIOR
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3-0.2f);
        gl.glVertex3f(0-w1+r, 0+h1, 0+d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0+d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0-d1);
        gl.glVertex3f(0-w1+r, 0+h1, 0-d1);
        gl.glEnd();
        
        //FRONTAL
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0+d1);
        gl.glVertex3f(0-w1+r, 0+h1, 0+d1);
        gl.glEnd();
        
        //POSTERIOR
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3-0.2f);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0-d1);
        gl.glVertex3f(0-w1+r, 0+h1, 0-d1);
        gl.glEnd();
        
        //LATERAL IZQUIERDA
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2-0.2f,c3-0.2f);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glVertex3f(0-w1+r, 0+h1, 0-d1);
        gl.glVertex3f(0-w1+r, 0+h1, 0+d1);
        gl.glEnd();
        
        //LATERAL DERECHA
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2-0.1f,c3-0.2f);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0-d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0+d1);
        gl.glEnd();
    }
    
     
    //CUBO CON PATRÓN
        public void paredes(int n, Cubo ca, Cubo cb, float w, float h, float d,float x, float y, float z, float r, float g, float b, float r1, float g1, float b1) {
        
        
        
        ca.w = w / n;
        ca.h = h / n;
        cb.w = w / n;
        cb.h = h / n;

        
        //ASIGNAR COLORES
        ca.c1=r;
        ca.c2=g;
        ca.c3=b;
        
        cb.c1=r1;
        cb.c2=g1;
        cb.c3=b1;
        //FIN ASIGNAR COLORES
        
        
        //PARED FRONTAL 1
        //FILA
        //COLOR1
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        ca.dibujarCubo();
        
        for (int i = 0; i < n / 2; i++) {
            gl.glTranslatef(2 * ca.w, 0, 0);
            ca.dibujarCubo();
        }
        gl.glPopMatrix();
        //FIN COLOR1
        //COLOR2
        gl.glPushMatrix();
        gl.glTranslatef(x + ca.w, y, z);
        cb.dibujarCubo();
        for (int i = 0; i < n / 2; i++) {
            gl.glTranslatef(2 * ca.w, 0, 0);
            cb.dibujarCubo();
        }
        gl.glPopMatrix();
        //FIN COLOR2
        //FIN FILA

        //COLUMNAS
        gl.glPushMatrix();
        for (int j = 0; j < n / 2; j++) {
            gl.glTranslatef(0, 2 * ca.h, 0);
            //COLOR1
            gl.glPushMatrix();
            gl.glTranslatef(x, y, z);
            ca.dibujarCubo();
            for (int i = 0; i < n / 2; i++) {
                gl.glTranslatef(2 * ca.w, 0, 0);
                ca.dibujarCubo();
            }
            gl.glPopMatrix();
            //FIN COLOR1
            //COLOR2
            gl.glPushMatrix();
            gl.glTranslatef(x + ca.w, y, z);
            cb.dibujarCubo();
            for (int i = 0; i < n / 2; i++) {
                gl.glTranslatef(2 * ca.w, 0, 0);
                cb.dibujarCubo();
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
        gl.glTranslatef(x, y + cb.h, z);
        cb.dibujarCubo();

        for (int i = 0; i < n / 2; i++) {
            gl.glTranslatef(2 * cb.w, 0, 0);
            cb.dibujarCubo();
        }
        gl.glPopMatrix();
        //FIN COLOR1
        //COLOR2
        gl.glPushMatrix();
        gl.glTranslatef(x + cb.w, y + cb.h, z);
        ca.dibujarCubo();
        for (int i = 0; i < n / 2; i++) {
            gl.glTranslatef(2 * cb.w, 0, 0);
            ca.dibujarCubo();
        }
        gl.glPopMatrix();
        //FIN COLOR2
        //FIN FILA

        //COLUMNAS
        gl.glPushMatrix();
        for (int j = 0; j < n / 2; j++) {
            gl.glTranslatef(0, 2 * cb.h, 0);
            //COLOR1
            gl.glPushMatrix();
            gl.glTranslatef(x, y + ca.h, z);
            cb.dibujarCubo();
            for (int i = 0; i < n / 2; i++) {
                gl.glTranslatef(2 * cb.w, 0, 0);
                cb.dibujarCubo();
            }
            gl.glPopMatrix();
            //FIN COLOR1
            //COLOR2
            gl.glPushMatrix();
            gl.glTranslatef(x + cb.w, y + ca.h, z);
            ca.dibujarCubo();
            for (int i = 0; i < n / 2; i++) {
                gl.glTranslatef(2 * cb.w, 0, 0);
                ca.dibujarCubo();
            }
            gl.glPopMatrix();
            //FIN COLOR2
        }
        gl.glPopMatrix();
        //FIN COLUMNAS
        //FIN PARED FRONTAL 2
    }
    //FIN CUBO CON PATRÓN
    
        
        
        //CUBO PATRÓN 2
        public void cuboP(int n, Cubo c1,Cubo c2, float w,float h, float d){
            
            //COLOR1
           c1.dibujarCubo();
           
           //LADO DERECHO
           gl.glPushMatrix();
            for (int i = 0; i < n/3; i++) {
                gl.glTranslatef(2*c1.w,0,0);
                c1.dibujarCubo();
            }
           gl.glPopMatrix();
           //FIN LADO DERECHO
           
            //LADO IZQUIERDO
           gl.glPushMatrix();
            for (int i = 0; i < n/3; i++) {
                gl.glTranslatef(-2*c1.w,0,0);
                c1.dibujarCubo();
            }
           gl.glPopMatrix();
           //FIN LADO IZQUIERDO
           //FIN COLOR1
           
           //COLOR2       
           
           //LADO DERECHO
           gl.glPushMatrix();
            for (int i = 0; i < n/2; i++) {
                gl.glTranslatef(c2.w,0,0);
                c2.dibujarCubo();
            }
           gl.glPopMatrix();
           //FIN LADO DERECHO
           
            //LADO IZQUIERDO
           gl.glPushMatrix();
            for (int i = 0; i < n/2; i++) {
                gl.glTranslatef(-c2.w,0,0);
                c2.dibujarCubo();
            }
           gl.glPopMatrix();
           //FIN LADO IZQUIERDO
           //FIN COLOR2
           
           
        }
        //FIN CUBO PATRÓN
    
    
}
