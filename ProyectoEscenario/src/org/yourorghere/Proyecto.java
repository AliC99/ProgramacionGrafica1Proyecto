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

    Restaurante r1;

    Cielo ci1;

    Persona pr1;
    Persona2 pr21;

    Letrero l1;

    Casa1 c1;
    Casa2 c2, c21, c22, c23;
    Casa3 c3;

    Iglu i1;
    Iglu i2;

    Faro2 f21;
    Faro2 f22;

    ArrayList<Buzon> buzon;
    ArrayList<Casa> cabania;
    ArrayList<Arbol> arbol;
    ArrayList<Raton> raton;
    ArrayList<Raton> raton1;
    ArrayList<Faro> faro1;

    boolean prueba = false;

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
        //drawable.addMouseMotionListener(m);
        //drawable.addMouseListener(m);

        p1 = new Piso(gl, 0, -alto, 0, ancho, alto, largo);

        ac = new Arbol(gl, 0.0f, 0, -19.8f, 1.2f, 3.5f, 1.2f, 45);
        a1 = new Arbol(gl, ancho / 20, 4f * p1.h, largo / 7.2f, 0.6f, 1.3f, 0.78f, 20);

        r1 = new Restaurante(gl, 0, 11.775f * alto, -largo / 2f, 2.7f, 1.15f, 2.2f, 0);

        ci1 = new Cielo(gl, 0, 100 * alto, -largo / 1.1f, ancho, 30, 42.5f);

        pr1 = new Persona(gl, 0, 3 * p1.h, 0, 0.2f, 0.2f, 0.2f, 180);
        pr21 = new Persona2(gl, 0, 9 * p1.h, -largo / 1.6f, 0.15f, 0.4f, 0.2f, 180);

        l1 = new Letrero(gl, 0, -11 * alto, largo / 2.8f, 0.8f, 0.65f, 0.1f, 20);

        c1 = new Casa1(gl, ancho / 35, 1.5f * p1.h, -largo / 35, 1.7f, 0.85f, 0.85f, 0);
        c2 = new Casa2(gl, -ancho / 2.4f, 4.5f * p1.h, largo / 18, 0.5f, 0.8f, 0.55f, 0);
        c21 = new Casa2(gl, ancho / 2.2f, 4.5f * p1.h, largo / 10, 0.5f, 0.8f, 0.55f, -90);
        c22 = new Casa2(gl, ancho / 2.4f, 4.5f * p1.h, -largo / 2.25f, 0.5f, 0.8f, 0.55f, 0);
        c23 = new Casa2(gl, -ancho / 2.4f, 4.5f * p1.h, -largo / 2.25f, 0.5f, 0.8f, 0.55f, 0);
        c3 = new Casa3(gl, ancho / 30, 4.5f * p1.h, largo / 65, 0.65f, 1f, 0.65f, 0);

        i1 = new Iglu(gl, ancho / 8f, 3 * alto, -largo / 2f, 0.6f, 0.6f, 0.6f, 0);
        i2 = new Iglu(gl, -ancho / 8f, 3 * alto, -largo / 2f, 0.6f, 0.6f, 0.6f, 0);

        f21 = new Faro2(gl, ancho / 8.8f, 4 * alto, largo / 25, 0.15f, 0.68f, 0.25f, 25);
        f22 = new Faro2(gl, -ancho / 80.8f, 4 * alto, largo / 25, 0.15f, 0.68f, 0.25f, -25);

        //RATONES
        raton = new ArrayList<Raton>();
        for (float i = -4 * largo / 21f; i < -largo / 7; i += 0.2f) {
            try {
                raton.add(new Raton(gl, ancho / 8f, p1.h, i * 3.5f, 0.07f, 0.12f, 0.18f, 20));
                raton.add(new Raton(gl, -ancho / 8f, p1.h, i * 3.5f, 0.07f, 0.12f, 0.18f, 20));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        raton1 = new ArrayList<Raton>();
        for (float i = -2*ancho / 49f; i < 2 * ancho / 21; i += 0.2f) {
            try {
                raton1.add(new Raton(gl, i * 3.5f, p1.h, -largo / 3.6f, 0.07f, 0.12f, 0.18f, 20));
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
        for (float i = -(p1.w / 3f); i < p1.w / 6; i += 0.8f) {
            try {
                arbol.add(new Arbol(gl, i * 1.35f, 3f * p1.h, -p1.d / 22, 0.7f, 1.98f, 0.6f, 45));
                arbol.add(new Arbol(gl, i * 1.6f, 3f * p1.h, -p1.d / 10f, 0.7f, 1.98f, 0.6f, -45));
                arbol.add(new Arbol(gl, i * 1.75f, 3f * p1.h, -p1.d / 6.5f, 0.7f, 1.98f, 0.6f, -45));
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

        for (float i = -(p1.w / 2f); i < -(p1.w / 15f); i += 0.8f) {
            try {
                arbol.add(new Arbol(gl, i * 1.3f, p1.h, -p1.d / 1.9f, 0.7f, 2.5f, 0.6f, 45));
                arbol.add(new Arbol(gl, i * 1.3f, p1.h, -p1.d / 1.7f, 0.7f, 2.5f, 0.6f, -45));
                arbol.add(new Arbol(gl, i * 1.3f, p1.h, -p1.d / 1.55f, 0.7f, 2.5f, 0.6f, -45));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (float i = (p1.w / 10f); i < (p1.w / 2f); i += 0.8f) {
            try {
                arbol.add(new Arbol(gl, i * 1.3f, p1.h, -p1.d / 1.9f, 0.7f, 2.2f, 0.6f, 45));
                arbol.add(new Arbol(gl, i * 1.1f, p1.h, -p1.d / 1.7f, 0.7f, 2.2f, 0.6f, -45));
                arbol.add(new Arbol(gl, i * 1.3f, p1.h, -p1.d / 1.55f, 0.7f, 2.2f, 0.6f, -45));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (float i = -(p1.d / 2f); i < p1.d / 2.8f; i += 0.85f) {
            try {
                arbol.add(new Arbol(gl, -p1.w / 2f, p1.h, i * 1.3f, 0.7f, 2.2f, 0.6f, -45));
                arbol.add(new Arbol(gl, -p1.w / 1.5f, p1.h, i * 1.3f, 0.7f, 2.2f, 0.6f, 45));
                arbol.add(new Arbol(gl, -p1.w / 1.2f, p1.h, i * 1.3f, 0.7f, 2.2f, 0.6f, 45));
            } catch (Exception e) {
                System.exit(0);
            }
        }

        for (float i = -(p1.d / 2f); i < p1.d / 2.8f; i++) {
            try {
                arbol.add(new Arbol(gl, p1.w / 2f, p1.h, i * 1.3f, 0.7f, 2.5f, 0.6f, -45));
                arbol.add(new Arbol(gl, p1.w / 1.8f, p1.h, i * 1.1f, 0.7f, 2.5f, 0.6f, 45));
                arbol.add(new Arbol(gl, p1.w / 1.55f, p1.h, i * 1.3f, 0.7f, 2.5f, 0.6f, 45));
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
        if (Teclado.rotarY >= 10000 ) {
            gl.glClearColor(0, ci1.cielo.c2, ci1.cielo.c3, 0.0f);

        } else {
            gl.glClearColor(0, ci1.cielo.c2, ci1.cielo.c3, 0.0f);

        }
        
         //gl.glClearColor(0, ci1.cielo.c2, ci1.cielo.c3, 0.0f);

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        GLU glu = new GLU();

        //Fondo
        if (ncam == 1) {
            glu.gluLookAt(pr1.x, pr1.y + 2.3f * pr1.h, pr1.z + 1.3f, pr1.x, pr1.y, pr1.z, 0, 1, 0);
            pr1.x = Teclado.getTrasladaX();
            pr1.z = Teclado.getTrasladaZ();


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
            glu.gluLookAt(a1.x, a1.e.y+0.7f, a1.z + 2f, a1.e.x, a1.e.y, a1.e.z , 0, 1, 0);
          
            
        }
        if (ncam == 3) {
            glu.gluLookAt(c1.puerta.x, c1.puerta.y, c1.puerta.z + 1.5f, c1.puerta.x, c1.puerta.y, c1.puerta.z, 0, 1, 0);
        }
        if (ncam == 4) {
            glu.gluLookAt(r1.x, r1.y,r1.z + 0.2f, r1.x, r1.y, r1.z, 0, 1, 0);
            ac.x = Teclado.getTrasladaX();
            ac.z = Teclado.getTrasladaZ();
            ac.y = Teclado.getTrasladaY();
        }
        if (ncam == 5) {
            glu.gluLookAt(p1.x, p1.y + 19.1f, p1.z + 0.01f, p1.x, p1.y, p1.z, 0, 1, 0);
        }

        gl.glPushMatrix();
        gl.glTranslatef(p1.x, p1.y, p1.z);

        //PERSONAJES
        pr1.dibujarPersona();
        pr21.persona2();
        //FIN PERSONAJES    

        //CASAS
        for (Casa c : cabania) {
            c.dibujarCasa();
        }
        c2.casa2(c2.cflecha.w / 2, -90);
        c21.casa2(-c2.cflecha.w / 2, 90);
        c22.casa2(-c2.cflecha.w / 2, 90);
        c23.casa2(c2.cflecha.w / 2, -90);
        c3.casa3();
        //c1.casa1();
        //FIN CASAS

        //ARBOLES
        for (Arbol a : arbol) {
            a.dibujarArbol();
        }

        a1.arbolCentral();
        //FIN ARBOLES

        for (Raton r : raton) {
            gl.glPushMatrix();
            Teclado.trasladarZ(gl);
            if (Teclado.getTrasladar() >= 3.8f) {
                Teclado.setTrasladar(2.5f);
                prueba = true;
            }
            r.raton();
            gl.glPopMatrix();
        }

        if (prueba == true) {
            for (Raton r2 : raton1) {
                gl.glPushMatrix();
                Teclado.trasladarX(gl);
                if (Teclado.trasladar1 >= 2f) {
                    Teclado.trasladar1=0f;                   
                }
                r2.ang = 90;
                r2.raton();
                gl.glPopMatrix();
            }
        }

        for (Buzon b : buzon) {
            b.buzon();
        }

        //FAROS
        for (Faro f : faro1) {
            f.p();
            f.faro1();
        }
        f21.faro2();
        f22.faro2();
        //FIN FAROS

        //IGLU
        i1.iglu();
        i2.iglu();
        //FIN IGLU

        p1.dibujarPiso();
        r1.dibujarRestaurante();

        l1.letrero();

        //CIELO
        ci1.cielo();
        gl.glPopMatrix();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
