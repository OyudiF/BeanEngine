package com.yudi.beanengine.main;

import com.yudi.beanengine.framework.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    // Lista de todos os objetos do jogo
    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        // Percorre todos os objetos e atualiza eles
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        // Percorre todos os objetos e desenha eles
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}
