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

    //N�mero de la c�mara
    public static int ncam = 1;

    //Creaci�n objetos
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
//    Raton rt1;
//    Raton rt2;
//    Raton rt3;
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
        frame.setSize(740, 580);
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
        drawable.addMouseMotionListener(m);
        drawable.addMouseListener(m1);
        ac = new Arbol(gl, 0.0f, -0.78f, -6.8f, 1.2f, 3.5f, 1.2f, 45);
        a1 = new Arbol(gl, 0.0f, -0.48f, -10.5f, 0.95f, 3.0f, 1.0f, 20);
        p1 = new Piso(gl, 0, -0.98f, -1.5f, 6.5f, 0.2f, 42.5f);
        r1 = new Restaurante(gl, 0, -0.2f, -19f, 2.75f, 1.2f, 2.1f);
        b1 = new Buzon(gl, 0, 0, 0, 0.3f, 0.7f, 0.25f, 25);
        ci1 = new Cielo(gl, 0, 0, 0, 20f, 9.5f, 42.5f);
        pr1 = new Persona(gl, 0, 0.5f, -1.5f, 0.6f, 0.6f, 0.6f);
        //f1=new Faro(gl,0,0,1.0f,0.05f,0.35f,0.05f,0);
//        rt1=new Raton(gl,-2.0f,-0.7f,-12f,0.15f,0.2f,0.3f);
//        rt2=new Raton(gl,-2.0f,-0.7f,-22f,0.15f,0.2f,0.3f);
//        rt3=new Raton(gl,-2.0f,-0.7f,-32f,0.15f,0.2f,0.3f);

        //RATONES
        raton = new ArrayList<Raton>();
        for (int i = 0; i < 3; i++) {
            try {
                raton.add(new Raton(gl, -1.5f, -0.7f, -i * 12f, 0.15f, 0.2f, 0.3f,-20));
                raton.add(new Raton(gl, 1.5f, -0.7f, -i * 12f, 0.15f, 0.2f, 0.3f,20));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN RATONES

        //BUZONES 
        buzon = new ArrayList<Buzon>();
        for (int i = 0; i < 5; i++) {
            try {
                buzon.add(new Buzon(gl, -2f, -0.63f, -i * 1.4f - 0.5f, 0.12f, 0.5f, 0.25f, 25));
                buzon.add(new Buzon(gl, 2f, -0.63f, -i * 1.4f - 0.5f, 0.12f, 0.5f, 0.25f, -25));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (int i = 8; i < 13; i++) {
            try {
                buzon.add(new Buzon(gl, -2f, -0.63f, -i * 1.4f - 0.5f, 0.12f, 0.5f, 0.25f, 25));
                buzon.add(new Buzon(gl, 2f, -0.63f, -i * 1.4f - 0.5f, 0.12f, 0.5f, 0.25f, -25));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN BUZONES

        //FAROS
        faro1 = new ArrayList<Faro>();
        for (int i = 0; i < 5; i++) {
            try {
                faro1.add(new Faro(gl, 1.8f, -0.35f, -i * 1.4f, 0.12f, 0.75f, 0.12f, 0));
                faro1.add(new Faro(gl, -1.8f, -0.35f, -i * 1.4f, 0.1f, 0.75f, 0.12f, 0));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (int i = 8; i < 13; i++) {
            try {
                faro1.add(new Faro(gl, 1.8f, -0.35f, -i * 1.4f, 0.12f, 0.75f, 0.12f, 0));
                faro1.add(new Faro(gl, -1.8f, -0.35f, -i * 1.4f, 0.1f, 0.75f, 0.12f, 0));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN FAROS

        //CASAS
        cabania = new ArrayList<Casa>();
        for (int i = 0; i < 5; i++) {
            try {
                cabania.add(new Casa(gl, -2.6f, -0.8f, -i * 1.4f, 0.73f, 0.9f, 0.6f, 90));
                cabania.add(new Casa(gl, 2.6f, -0.8f, -i * 1.4f, 0.73f, 0.9f, 0.6f, -90));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (int i = 8; i < 13; i++) {
            try {
                cabania.add(new Casa(gl, -2.6f, -0.78f, -i * 1.4f, 0.73f, 0.9f, 0.6f, 90));
                cabania.add(new Casa(gl, 2.6f, -0.78f, -i * 1.4f, 0.73f, 0.9f, 0.6f, -90));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN CASAS

        //ARBOLES
        arbol = new ArrayList<Arbol>();
        for (int i = 0; i < 16; i++) {
            try {
                arbol.add(new Arbol(gl, -3.4f, -0.68f, -i * 1.3f, 0.7f, 1.95f, 0.6f, 45));
                arbol.add(new Arbol(gl, 3.4f, -0.68f, -i * 1.3f, 0.7f, 1.95f, 0.6f, -45));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (int i = 0; i < 12; i++) {
            try {
                arbol.add(new Arbol(gl, -4.4f, -0.68f, -i * 1.5f, 0.7f, 2.5f, 0.6f, 45));
                arbol.add(new Arbol(gl, 4.4f, -0.68f, -i * 1.5f, 0.7f, 2.5f, 0.6f, -45));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        
        for (int i = 0; i < 12; i++) {
            try {
                arbol.add(new Arbol(gl, -5.4f, -0.48f, -i * 1.5f, 0.7f, 2.5f, 0.6f, 45));
                arbol.add(new Arbol(gl, 5.4f, -0.48f, -i * 1.5f, 0.7f, 2.5f, 0.6f, -45));
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
            glu.gluLookAt(ac.x, ac.y + 0.1f, ac.z + 1.2f, ac.x, ac.y, ac.z, 0, 1, 0);
            //glu.gluLookAt(p1.x,p1.y+0.2f,p1.z+2.5f,p1.x,p1.y,p1.z,0,1,0);
        }

//       if(ncam==2){
//             glu.gluLookAt(b1.x,b1.y+1.0f,b1.z+2.5f,b1.x,b1.y,b1.z,0,1,0);    }
        if (ncam == 3) {
            glu.gluLookAt(p1.x, p1.y + 12.5f, p1.z + 0.5f, p1.x, p1.y, p1.z, 0, 1, 0);
        }
        if (ncam == 4) {
            glu.gluLookAt(r1.x, r1.y + 1.1f, r1.z + 3, r1.x, r1.y, r1.z, 0, 1, 0);
        }

        //Dibujar objetos  
        gl.glPushMatrix();
        ac.x = Teclado.getTrasladaX();
        ac.y = Teclado.getTrasladaY();
        ac.z = Teclado.getTrasladaZ();

        //MOVIMIENTO MOUSE
//       ac.z=Mouseprueba.trasladaZ;
//      
//       ac.x=Mouse.trasladaX;
//       ac.y=Mouse.trasladaY;
        //FIN MOVIMIENTO MOUSE     

        //ac.dibujarArbol();
        gl.glPopMatrix();

        for (Casa c : cabania) {
            c.dibujarCasa();
        }
        for (Arbol a : arbol) {
            a.dibujarArbol();
        }
        for (Raton r : raton) {
            r.raton();
        }
        for (Buzon b : buzon) {
            b.buzon();
        }
        for (Faro f : faro1) {
            f.faro1();
        }

        a1.arbolCentral();
        p1.dibujarPiso();
        r1.dibujarRestaurante();
        ci1.noche();
        pr1.dibujarPersona();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
