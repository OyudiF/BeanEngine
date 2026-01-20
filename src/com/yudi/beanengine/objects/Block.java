package com.yudi.beanengine.objects;

import com.yudi.beanengine.framework.GameObject;
import com.yudi.beanengine.framework.ObjectId;

import java.awt.*;

public class Block extends GameObject {

    public Block(int x, int y, ObjectId id) {
        super(x, y, id);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 32, 32);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

}
