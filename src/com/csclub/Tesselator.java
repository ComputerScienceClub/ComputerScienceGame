package com.csclub;

import static org.lwjgl.opengl.GL11.*;

/**
 * Object.  Used primarily for rendering basic shapes and graphics.
 */
public class Tesselator
{
    /**
     * P(x, y) should be on the top left hand corner of whatever you're rendering
     * x1 is the right side
     * y1 is the bottom
     */
    private int x, y, x1, y1, width, height;

    public Tesselator()
    {/** Implementation not needed **/}

    public Tesselator(int x, int y, int x1, int y1)
    {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }

    public Tesselator drawQuadWithCords()
    {
        glBegin(GL_QUADS);
        {
            glVertex2i(x, y);
            glVertex2i(x, y1);
            glVertex2i(x1, y);
            glVertex2i(x1, y1);
        }
        glEnd();

        return this;
    }

    public Tesselator drawQuadWithSize()
    {
        glPushMatrix();
        glTranslated(x, y, 0);
        glBegin(GL_QUADS);
        {
            glVertex2i(0, 0);
            glVertex2i(0, height);
            glVertex2i(width, 0);
            glVertex2i(width, height);
        }
        glEnd();
        glPopMatrix();

        return this;
    }

    public int getX()
    {
        return x;
    }

    public Tesselator setX(int x)
    {
        this.x = x;

        return this;
    }

    public int getY()
    {
        return y;
    }

    public Tesselator setY(int y)
    {
        this.y = y;

        return this;
    }

    public int getX1()
    {
        return x1;
    }

    public void setX1(int x1)
    {
        this.x1 = x1;
    }

    public int getY1()
    {
        return y1;
    }

    public Tesselator setY1(int y1)
    {
        this.y1 = y1;

        return this;
    }

    public int getWidth()
    {
        return width;
    }

    public Tesselator setWidth(int width)
    {
        this.width = width;

        return this;
    }

    public int getHeight()
    {
        return height;
    }

    public Tesselator setHeight(int height)
    {
        this.height = height;

        return this;
    }

    public Tesselator setSize(int width, int height)
    {
        this.width = width;
        this.height = height;

        return this;
    }

    public Tesselator setCords(int x, int y, int x1, int y1)
    {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;

        return this;
    }
}
