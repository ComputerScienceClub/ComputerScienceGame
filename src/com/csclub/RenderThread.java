/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author ayates
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

        while (!Display.isCloseRequested())
        {
            /**
             * Draw graphics past this comment
             */
            glClear(GL_COLOR_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
            glClear(GL_COLOR_BUFFER_BIT);
            glPushMatrix();
            glTranslatef(Display.getDisplayMode().getWidth() / 2 + 250, Display.getDisplayMode().getHeight() / 2, 0.0f);
            glBegin(GL_QUADS);
            glVertex2i(-50, -50);
            glVertex2i(50, -50);
            glVertex2i(50, 50);
            glVertex2i(-50, 50);
            glEnd();
            glPopMatrix();

            Display.update();
        }

        Display.destroy();
        System.exit(0);
    }
}
