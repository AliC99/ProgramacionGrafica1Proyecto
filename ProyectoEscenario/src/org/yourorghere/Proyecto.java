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

    static float ancho = 19.0f;
    static float largo = 15.0f;
    static float alto = 0.05f;

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
    Casa2 c2;
    Casa3 c3;
    
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
       
       
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.

        gl.glEnable(GL.GL_DEPTH_TEST);

        t = new Teclado();
        drawable.addKeyListener(t);
        m = new Mouse();
//        m1 = new Mouseprueba();
        //drawable.addMouseMotionListener(m);
        //drawable.addMouseListener(m);

        ac = new Arbol(gl, 0.0f, 0, -19.8f, 1.2f, 3.5f, 1.2f, 45);
        p1 = new Piso(gl, 0, -alto, 0, ancho, alto, largo);
        a1 = new Arbol(gl, ancho / 20, 6.2f * p1.h, largo / 7.2f, 0.93f, 2.5f, 1.0f, 20);
        r1 = new Restaurante(gl, 0, 11.775f * alto, -largo / 2f, 2.7f, 1.15f, 2.2f, 0);
        b1 = new Buzon(gl, 0, 0, 0, 0.3f, 0.7f, 0.25f, 25);
        ci1 = new Cielo(gl, 0, 100*alto, -largo/1.1f, ancho, 30, 42.5f);
        pr1 = new Persona(gl, 0, 10* p1.h, 0, 0.2f, 0.2f, 0.2f, 180);
        c1 = new Casa1(gl, ancho / 35, 1.5f * p1.h, -largo / 35, 1.7f, 0.85f, 0.85f, 0);
        l1 = new Letrero(gl, -7.3f * ancho / 16, -11 * alto, largo / 2.8f, 0.8f, 0.65f, 0.1f, 20);
        c2 = new Casa2(gl, -ancho / 2.4f, 4.5f * p1.h, largo / 10, 0.5f, 0.8f, 0.55f, 0);
        c3 = new Casa3(gl, -ancho/3, 4.5f * p1.h, largo / 6, 0.5f, 0.8f, 0.55f, 0);
        

        //RATONES
        raton = new ArrayList<Raton>();
        for (float i = 0; i < 6; i++) {
            try {
                raton.add(new Raton(gl, -ancho / 2.2f, p1.h, i * 3.5f, 0.07f, 0.12f, 0.18f, -20));
                raton.add(new Raton(gl, -ancho / 2.8f, p1.h, i * 3.5f, 0.07f, 0.12f, 0.18f, 20));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN RATONES

        //BUZONES 
        buzon = new ArrayList<Buzon>();
        for (float i = -(p1.w / 5f); i < 0; i++) {
            try {
                buzon.add(new Buzon(gl, i * 1.4f - 0.5f, 5f * p1.h, p1.d / 30, 0.12f, 0.5f, 0.25f, -20));
                buzon.add(new Buzon(gl, i * 1.4f - 0.5f, 5f * p1.h, p1.d / 4.2f, 0.12f, 0.5f, 0.25f, 20));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (float i = p1.w / 8f; i < p1.w / 5f; i++) {
            try {
                buzon.add(new Buzon(gl, i * 1.5f - 0.5f, 5f * p1.h, p1.d / 30, 0.12f, 0.5f, 0.25f, -20));
                buzon.add(new Buzon(gl, i * 1.5f - 0.5f, 5f * p1.h, p1.d / 4.2f, 0.12f, 0.5f, 0.25f, 20));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN BUZONES

        //FAROS
        faro1 = new ArrayList<Faro>();
        for (float i = -(p1.w / 5f); i < 0; i++) {
            try {
                faro1.add(new Faro(gl, i * 1.32f, 11f * p1.h, p1.d / 30, 0.12f, 0.75f, 0.12f, 0));
                faro1.add(new Faro(gl, i * 1.32f, 11f * p1.h, p1.d / 4.2f, 0.1f, 0.75f, 0.12f, 0));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (float i = p1.w / 8f; i < p1.w / 5f; i++) {
            try {
                faro1.add(new Faro(gl, i * 1.5f, 11f * p1.h, p1.d / 30, 0.12f, 0.75f, 0.12f, 0));
                faro1.add(new Faro(gl, i * 1.5f, 11f * p1.h, p1.d / 4.2f, 0.1f, 0.75f, 0.12f, 0));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN FAROS

        //CASAS
        cabania = new ArrayList<Casa>();
        for (float i = -(p1.w / 5f); i < 0; i++) {
            try {
                cabania.add(new Casa(gl, i * 1.4f, 1.6f * p1.h, 0, 0.73f, 0.9f, 0.6f, 0));
                cabania.add(new Casa(gl, i * 1.4f, 1.6f * p1.h, p1.d / 3.6f, 0.73f, 0.9f, 0.6f, 180));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (float i = p1.w / 8f; i < p1.w / 5f; i++) {
            try {
                cabania.add(new Casa(gl, i * 1.4f, 1.6f * p1.h, 0, 0.73f, 0.9f, 0.6f, 0));
                cabania.add(new Casa(gl, i * 1.4f, 1.6f * p1.h, p1.d / 3.6f, 0.73f, 0.9f, 0.6f, 180));
            } catch (Exception e) {
                System.exit(0);
            }
        }
        //FIN CASAS

        //ARBOLES
        arbol = new ArrayList<Arbol>();
        for (float i = -(p1.w); i < p1.w / 6; i++) {
            try {
                arbol.add(new Arbol(gl, i * 1.35f, p1.h, -p1.d / 22, 0.7f, 1.95f, 0.6f, 45));
                arbol.add(new Arbol(gl, i * 1.6f, p1.h, -p1.d / 10f, 0.7f, 1.95f, 0.6f, -45));
                arbol.add(new Arbol(gl, i * 1.75f, p1.h, -p1.d / 6.5f, 0.7f, 1.95f, 0.6f, -45));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (float i = -(p1.w / 4.5f); i < p1.w / 2.5f; i++) {
            try {
                arbol.add(new Arbol(gl, i * 1.3f, p1.h, p1.d / 3f, 0.7f, 2.5f, 0.6f, 45));
                arbol.add(new Arbol(gl, i * 1.3f, p1.h, p1.d / 2.5f, 0.7f, 2.5f, 0.6f, -45));
                arbol.add(new Arbol(gl, i * 1.3f, p1.h, p1.d / 2.15f, 0.7f, 2.5f, 0.6f, -45));
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

    static float cp = 0;

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        if (Teclado.rotarY>=10000) {
            gl.glClearColor(0,ci1.cielo.c2,ci1.cielo.c3, 0.0f);
            
        }else{
            gl.glClearColor(0, ci1.cielo.c2, ci1.cielo.c3, 0.0f);
            
        }
         
         
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        GLU glu = new GLU();

        //Fondo
        if (ncam == 1) {
            glu.gluLookAt(pr1.x, pr1.y + 2f * pr1.h, pr1.z + 1.3f, pr1.x, pr1.y, pr1.z, 0, 1, 0);
            pr1.x = Teclado.getTrasladaX();
            pr1.z = Teclado.getTrasladaZ();

            pr1.moverW(0.91f);
            pr1.moverS(6.86f);

//            if (Teclado.trasladaZ < 0.76f && Teclado.trasladaZ > -2.78f && Teclado.trasladaX < 6f) {
//            Teclado.trasladaZ = 0.75f;
//        } else if (Teclado.trasladaZ < -7.23f && Teclado.trasladaZ > -7.5f && Teclado.trasladaX > 0.65f) {
//            Teclado.trasladaZ = Teclado.trasladaZ;
//        } else if (Teclado.trasladaZ < -7.23f && Teclado.trasladaZ > -7.5f && Teclado.trasladaX < 0.41f) {
//            Teclado.trasladaZ = Teclado.trasladaZ;
//        } 
            //VALIDAR GIROS DEL PERSONAJE    
            if (Teclado.getTrasladaZ() > 2.71f && Teclado.getTrasladaX() < -7.06f) {
                if (Teclado.validarGiro == true) {
                    pr1.ang = 0;
                } else {
                    pr1.ang = 180;
                }
            }

            if (Teclado.getTrasladaX() > 6.63f && Teclado.getTrasladaZ() < 1.66f) {
                if (Teclado.validarGiro == true) {
                    pr1.ang = 0;
                } else {
                    pr1.ang = 180;
                }
            }

            if (Teclado.getTrasladaX() < 0.58f && Teclado.getTrasladaX() > 0.48f && Teclado.getTrasladaZ() < -4.18f) {
                if (Teclado.validarGiro == true) {
                    pr1.ang = 0;
                } else {
                    pr1.ang = 180;
                }
            }

            if (Teclado.getTrasladaZ() < 2.71f && Teclado.getTrasladaX() > -7.06f && Teclado.getTrasladaX() < 7.63f) {
                if (Teclado.validarGiroid == true) {
                    pr1.ang = 90;
                } else {
                    pr1.ang = -90;
                }
            }

            //pr1.dibujarPersona();

            //FIN GIROS DEL PERSONAJE
         
        }

        if (ncam == 2) {
            glu.gluLookAt(pr1.x, pr1.y, pr1.z + 0.5f, pr1.x, pr1.y + pr1.h, pr1.z + Teclado.getTrasladaZ(), 0, 1, 0);

            pr1.x = Teclado.getTrasladaX();
            pr1.z = Teclado.getTrasladaZ();
        }
        if (ncam == 3) {
            glu.gluLookAt(c1.puerta.x, c1.puerta.y, c1.puerta.z + 1.5f, c1.puerta.x, c1.puerta.y, c1.puerta.z, 0, 1, 0);
        }
        if (ncam == 4) {
            glu.gluLookAt(ac.x, ac.y, ac.z + 0.2f, ac.x, ac.y, ac.z, 0, 1, 0);
            ac.x = Teclado.getTrasladaX();
            ac.z = Teclado.getTrasladaZ();
            ac.y = Teclado.getTrasladaY();
        }
        if (ncam == 5) {
            glu.gluLookAt(p1.x, p1.y + 19.1f, p1.z + 0.01f, p1.x, p1.y, p1.z, 0, 1, 0);
        }

        gl.glPushMatrix();
        gl.glTranslatef(p1.x, p1.y, p1.z);
        
        pr1.dibujarPersona();
            
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
        c2.casa2();
        c3.casa3();

        //c1.casa1();
        l1.letrero();

       
       
        ci1.cielo();
        
        
        gl.glPopMatrix();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
