package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * Proyecto.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Proyecto implements GLEventListener {

    //Número de la cámara
    public static int ncam = 1;

    static float ancho=19.0f;
    static float largo=15.0f;
    static float alto=0.05f;
    
    //Creación objetos
    Piso p1;
    Arbol ac;
    Arbol a1;
    Teclado t;
    Mouse m;
    Mouseprueba m1;
    Restaurante r1;
    Buzon b1;
    Cielo ci1;
    Persona pr1;
    Faro f1;
    Casa1 c1; 
    Letrero l1;
    ArrayList<Buzon> buzon;
    ArrayList<Casa> cabania;
    ArrayList<Arbol> arbol;
    ArrayList<Raton> raton;
    ArrayList<Faro> faro1;

    
    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Proyecto());
        frame.add(canvas);
        frame.setSize(840, 680);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.

        gl.glEnable(GL.GL_DEPTH_TEST);

        t = new Teclado();
        drawable.addKeyListener(t);
        m = new Mouse();
        m1=new Mouseprueba();
//        drawable.addMouseMotionListener(m);
//        drawable.addMouseListener(m1);

        
        ac = new Arbol(gl, 0.0f, 0, -19.8f, 1.2f, 3.5f, 1.2f, 45);        
        p1 = new Piso(gl, 0,-alto,0, ancho, alto, largo);
        a1 = new Arbol(gl, 0.0f, 2.35f*p1.h, -3.5f, 0.95f, 3.0f, 1.0f, 20);
        r1 = new Restaurante(gl, 0, 11.775f*alto,-largo/2f, 2.7f, 1.15f, 2.2f,0);
        b1 = new Buzon(gl, 0, 0, 0, 0.3f, 0.7f, 0.25f, 25);
        ci1 = new Cielo(gl, 0, 0, 0, ancho, 9.5f, 42.5f);
        pr1 = new Persona(gl, 0, 4*p1.h, 0, 0.2f, 0.2f, 0.2f,0);
        c1=new Casa1(gl,ancho/35,1.5f*p1.h,-largo/35,1.7f,0.85f,0.85f,0);
        l1=new Letrero(gl,-7.3f*ancho/16,-11*alto,largo/2.8f,0.8f,0.65f,0.1f,20);
        

        //RATONES
        raton = new ArrayList<Raton>();
        for (float i =0 ; i < 5; i++) {
            try {
                raton.add(new Raton(gl, -ancho/2, p1.h, -i * 12f, 0.07f, 0.12f, 0.18f,20));
                raton.add(new Raton(gl, -ancho/4, p1.h, -i * 12f, 0.07f, 0.12f, 0.18f,20));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN RATONES

        //BUZONES 
        buzon = new ArrayList<Buzon>();
        for (float i = -(p1.w/5f); i < 0; i++) {
            try {
                buzon.add(new Buzon(gl, i * 1.4f-0.5f, 5f*p1.h, p1.d/30, 0.12f, 0.5f, 0.25f, -20));
                buzon.add(new Buzon(gl, i * 1.4f-0.5f, 5f*p1.h, p1.d/4.2f, 0.12f, 0.5f, 0.25f, 20));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (float i = p1.w/8f; i < p1.w/5f; i++) {
            try {
                buzon.add(new Buzon(gl, i * 1.5f-0.5f, 5f*p1.h, p1.d/30, 0.12f, 0.5f, 0.25f, -20));
                buzon.add(new Buzon(gl, i * 1.5f-0.5f, 5f*p1.h, p1.d/4.2f, 0.12f, 0.5f, 0.25f, 20));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN BUZONES

        //FAROS
        faro1 = new ArrayList<Faro>();
        for (float i = -(p1.w/5f); i < 0; i++) {
            try {
                faro1.add(new Faro(gl, i * 1.32f, 11f*p1.h, p1.d/30, 0.12f, 0.75f, 0.12f, 0));
                faro1.add(new Faro(gl, i * 1.32f, 11f*p1.h, p1.d/4.2f, 0.1f, 0.75f, 0.12f, 0));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (float i = p1.w/8f; i < p1.w/5f; i++) {
            try {
                faro1.add(new Faro(gl, i * 1.5f, 11f*p1.h, p1.d/30, 0.12f, 0.75f, 0.12f, 0));
                faro1.add(new Faro(gl, i * 1.5f, 11f*p1.h, p1.d/4.2f, 0.1f, 0.75f, 0.12f, 0));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN FAROS

        //CASAS
        cabania = new ArrayList<Casa>();
        for (float i = -(p1.w/5f); i < 0; i++) {
            try {
                cabania.add(new Casa(gl, i * 1.4f, 1.6f*p1.h, 0, 0.73f, 0.9f, 0.6f, 0));
                cabania.add(new Casa(gl, i * 1.4f, 1.6f*p1.h, p1.d/3.6f, 0.73f, 0.9f, 0.6f, 180));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (float i = p1.w/8f; i < p1.w/5f; i++) {
            try {
                cabania.add(new Casa(gl, i * 1.4f, 1.6f*p1.h, 0, 0.73f, 0.9f, 0.6f, 0));
                cabania.add(new Casa(gl, i * 1.4f, 1.6f*p1.h, p1.d/3.6f, 0.73f, 0.9f, 0.6f, 180));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN CASAS

        //ARBOLES
        arbol = new ArrayList<Arbol>();
        for (int i = 0; i < 16; i++) {
            try {
                arbol.add(new Arbol(gl, -3.4f, p1.h, -i * 1.3f, 0.7f, 1.95f, 0.6f, 45));
                arbol.add(new Arbol(gl, 3.4f,p1.h, -i * 1.3f, 0.7f, 1.95f, 0.6f, -45));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (int i = 0; i < 12; i++) {
            try {
                arbol.add(new Arbol(gl, -4.4f, p1.h*1.1f, -i * 1.5f, 0.7f, 2.5f, 0.6f, 45));
                arbol.add(new Arbol(gl, 4.4f, p1.h*1.1f, -i * 1.5f, 0.7f, 2.5f, 0.6f, -45));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        
        for (int i = 0; i < 12; i++) {
            try {
                arbol.add(new Arbol(gl, -5.4f, p1.h*1.2f, -i * 1.5f, 0.7f, 2.5f, 0.6f, 45));
                arbol.add(new Arbol(gl, 5.4f, p1.h*1.2f, -i * 1.5f, 0.7f, 2.5f, 0.6f, -45));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN ARBOLES
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        GLU glu = new GLU();

        //Fondo
        if (ncam == 1) {
            glu.gluLookAt(pr1.x, pr1.y +2.5f*pr1.h, pr1.z + 1.1f, pr1.x, pr1.y, pr1.z, 0, 1, 0);
            pr1.x = Teclado.getTrasladaX();
            pr1.z = Teclado.getTrasladaZ();
        }

       if(ncam==2){
             glu.gluLookAt(pr1.x, pr1.y , pr1.z+0.5f , pr1.x, pr1.y+pr1.h, pr1.z+Teclado.getTrasladaZ(), 0, 1, 0);   
            
             pr1.x = Teclado.getTrasladaX();
             pr1.z = Teclado.getTrasladaZ();
       }
        if (ncam == 3) {
            glu.gluLookAt(c1.puerta.x, c1.puerta.y , c1.puerta.z + 1.5f, c1.puerta.x, c1.puerta.y , c1.puerta.z, 0, 1, 0);
        }
        if (ncam == 4) {
            glu.gluLookAt(r1.x, r1.y + 1f, r1.z + 4, r1.x, r1.y, r1.z, 0, 1, 0);
        }
         if (ncam == 5) {
            glu.gluLookAt(p1.x, p1.y+19.1f , p1.z+0.01f , p1.x, p1.y , p1.z, 0, 1, 0);
        }

        
        gl.glPushMatrix();
        gl.glTranslatef(p1.x,p1.y,p1.z);
        for (Casa c : cabania) {
            c.dibujarCasa();
        }
//        for (Arbol a : arbol) {
//            a.dibujarArbol();
//        }
        for (Raton r : raton) {
            r.raton();
        }
        for (Buzon b : buzon) {
            b.buzon();
        }
        for (Faro f : faro1) {
            f.faro1();
        }
//        
//        a1.arbolCentral();
        p1.dibujarPiso();
        r1.dibujarRestaurante();
        //ci1.noche();
        pr1.dibujarPersona();
        c1.casa1();
        l1.letrero();
        
        gl.glPopMatrix();

        

        
        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
