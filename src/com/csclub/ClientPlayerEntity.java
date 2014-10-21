package com.csclub;

/**
 * This is the player controlled by THIS CLIENT.
 */
public class ClientPlayerEntity
{
    private double x;
    private double y;

    public ClientPlayerEntity()
    {
        this.x = 0;
        this.y = 0;
    }

    public ClientPlayerEntity(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getX()
    {
        return x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getY()
    {
        return y;
    }
    
}
