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
    public static final String WINDOW_TITLE = "";
    public static final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = 500;

    public static void main(String[] args)
    {
        render = new RenderThread();
        render.start();
        update = new UpdateThread();
        update.start();
    }
}
