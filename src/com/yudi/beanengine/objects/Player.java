package com.yudi.beanengine.objects;

import com.yudi.beanengine.framework.GameObject;
import com.yudi.beanengine.framework.ObjectId;

import java.awt.*;

public class Player extends GameObject {
    public Player(int x, int y, ObjectId id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 32, 32); // Desenha o quadrado azul
    }
}
