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
public class Piramide {
 
    //coordenadas
    float x,y,z;
    //dimensiones
    float w,h,d; //ancho, alto, profundidad
    //colores
    float c1,c2,c3;
    //GL
    GL gl;
    
   
    public Piramide(GL gl,float x, float y, float z, float w, float h, float d, float c1, float c2, float c3) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.gl=gl;       
    }

   
   
      
      
    public void dibujarPiramide(){
        
        gl.glTranslatef(x,y,z); 

        float w1=w/2; 
        float d1=d/2; 
        float h1=h/2;
        
        //BASE
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glEnd();
        
      
        
        //TRIÁNGULOS
     
        //Frontal
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0, 0+h1, 0);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glEnd();
        
        //Posterior
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glColor3f(c1,c2,c3-0.2f);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glVertex3f(0, 0+h1, 0);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glEnd();
        
        //Lateral izquierda
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glColor3f(c1,c2-0.2f,c3-0.2f);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0, 0+h1, 0);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glEnd();
        
         //Lateral derecha
         gl.glBegin(gl.GL_TRIANGLES);
        gl.glColor3f(c1,c2-0.1f,c3-0.2f);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0, 0+h1, 0);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glEnd();
        
      
     
    }
    
   
    
    
}
