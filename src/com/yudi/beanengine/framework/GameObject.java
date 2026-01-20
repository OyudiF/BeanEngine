package com.yudi.beanengine.framework;

import java.awt.*;

public abstract class GameObject {
    protected int x, y;
    protected int velX, velY;
    protected ObjectId id;

    public GameObject(int x, int y, ObjectId id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    // Getters e Setters
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public int getVelX() { return velX; }
    public int getVelY() { return velY; }
    public void setVelX(int velX) { this.velX = velX; }
    public void setVelY(int velY) { this.velY = velY; }

    public ObjectId getId() { return id; }
}
