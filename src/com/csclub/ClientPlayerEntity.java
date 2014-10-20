package com.csclub;

/**
 * This is the player controlled by THIS CLIENT.
 */
public class ClientPlayerEntity implements Entity
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

    @Override
    public void setX(double x)
    {
        this.x = x;
    }

    @Override
    public double getX()
    {
        return x;
    }

    @Override
    public void setY(double y)
    {
        this.y = y;
    }

    @Override
    public double getY()
    {
        return y;
    }
    
}
