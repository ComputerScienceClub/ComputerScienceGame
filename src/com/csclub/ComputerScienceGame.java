/*
 * Main class. Do not modify.
 */
package com.csclub;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class ComputerScienceGame
{

    public static Thread render, update, input;
    public static final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = 500;
    public static boolean displayClosed = false; //Sets true when display has been exited and/or quit; stop all renders and checks when this is true
    public static int FPS = 60;

    public static void main(String[] args)
    {
        render = new RenderThread();
        render.start();
        update = new UpdateThread();
        update.start();
    }
}
