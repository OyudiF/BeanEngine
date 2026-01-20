package com.yudi.beanengine.objects;

import com.yudi.beanengine.framework.GameObject;
import com.yudi.beanengine.framework.ObjectId;
import com.yudi.beanengine.main.Handler;

import java.awt.*;

public class Player extends GameObject {

    private Handler handler;

    public Player(int x, int y, Handler handler, ObjectId id) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        collision();
    }

    private void collision() {

        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ObjectId.Block) {
                if(getBounds().intersects(tempObject.getBounds())) {

                    x += velX * -1;
                    y += velY * -1;
                    velX = 0;
                    velY = 0;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 32, 32); // Desenha o quadrado azul
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
