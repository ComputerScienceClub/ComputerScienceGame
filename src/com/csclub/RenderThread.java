package com.csclub;

import static com.csclub.ComputerScienceGame.SCREEN_HEIGHT;
import static com.csclub.ComputerScienceGame.SCREEN_WIDTH;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_COLOR_MATERIAL;
import static org.lwjgl.opengl.GL11.GL_DITHER;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_NICEST;
import static org.lwjgl.opengl.GL11.GL_NORMALIZE;
import static org.lwjgl.opengl.GL11.GL_PERSPECTIVE_CORRECTION_HINT;
import static org.lwjgl.opengl.GL11.GL_POLYGON_SMOOTH_HINT;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_STENCIL_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glHint;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glViewport;

/**
 * This thread renders all graphics
 */
public class RenderThread extends Thread
{
    @Override
    public void run()
    {
        try
        {
            Display.setFullscreen(true);
            Display.setResizable(false);
            Display.create();
            Keyboard.create();
            Mouse.create();
            glEnable(GL_COLOR_MATERIAL);
            glDisable(GL_DITHER);
            glEnable(GL_NORMALIZE);
            glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
            glHint(GL_POLYGON_SMOOTH_HINT, GL_NICEST);
            glViewport(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glOrtho(0, SCREEN_WIDTH, 0, SCREEN_HEIGHT, 0, 25);
            glMatrixMode(GL_MODELVIEW);
        }
        catch (LWJGLException e)
        {
            System.out.println("/***************************************************\\");
            System.out.println("/***************************************************\\");
            System.out.println("/***************************************************\\");
            System.out.println("ERROR WITH DISPLAY LOADING COMMANDS. PLEASE LOOK AT \"RenderThread\" FOR POSSIBLE ERROR.");
            System.out.println("/***************************************************\\");
            System.out.println("/***************************************************\\");
            System.out.println("/***************************************************\\");
            
            e.printStackTrace();            
        }

        while (!ComputerScienceGame.displayClosed)
        {
            glClear(GL_COLOR_BUFFER_BIT | GL_STENCIL_BUFFER_BIT); //Clears screen of all graphics
            glClear(GL_COLOR_BUFFER_BIT); //Clears screen of all graphics
            /**
             * Draw graphics past this comment
             */

            Tesselator tesselator = new Tesselator();
            tesselator.setX(500).setY(500).setWidth(100).setHeight(500).drawQuadWithSize();

            /////////////
            //End drawing
            Display.update();

            Display.sync(ComputerScienceGame.FPS); //"Sleep method", syncs rendering to a specified FPS

            ComputerScienceGame.displayClosed = Display.isCloseRequested(); //Update state of displayClosed (set to closeRequest status)
        }

        Display.destroy();
        System.exit(0);
    }
}
