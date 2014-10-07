/*
 * Main class. Do not modify.
 */
package com.csclub;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.*;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

public class ComputerScienceGame
{

    public static Thread render, update, input;
    public static final String WINDOW_TITLE = "";

    public static void main(String[] args)
    {
    }

    public void initGraphics() throws Exception
    {
        Display.setTitle(WINDOW_TITLE);
        Display.setVSyncEnabled(true);
        Display.setFullscreen(true);
        Display.create();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0.0, Display.getDisplayMode().getWidth(), 0.0, Display.getDisplayMode().getHeight(), -1.0, 1.0);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        glViewport(0, 0, Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight());

        /**
         * The "OpenGL Thread," renders graphics
         */
        render = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (!Display.isCloseRequested())
                {
                    Display.update();
                    
                    glClear(GL_COLOR_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
                    glClear(GL_COLOR_BUFFER_BIT);
                    glPushMatrix();
                    glTranslatef(Display.getDisplayMode().getWidth() / 2, Display.getDisplayMode().getHeight() / 2, 0.0f);
                    glBegin(GL_QUADS);
                    glVertex2i(-50, -50);
                    glVertex2i(50, -50);
                    glVertex2i(50, 50);
                    glVertex2i(-50, 50);
                    glEnd();
                    glPopMatrix();
                }
            }
        });
        render.start();
    }
}
