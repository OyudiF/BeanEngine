package com.yudi.beanengine.main;

import com.yudi.beanengine.framework.ObjectId;
import com.yudi.beanengine.inputs.KeyInput;
import com.yudi.beanengine.objects.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -6261436164361361187L;

    private boolean running = false;
    private Thread thread;

    // O Handler é público ou tem getter para ser acessado pelo Input
    public Handler handler;

    public Game(){
        handler = new Handler();

        // O "this" passa a própria classe Game para o KeyInput,
        // para podermos acessar o handler lá dentro
        this.addKeyListener(new KeyInput(handler));

        new Window(800, 600, "Blue Engine V1", this);

        // Criando o Player
        handler.addObject(new Player(100, 100, ObjectId.Player));
    }

    public synchronized void start(){
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tick(){
        handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        // Fundo Preto
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Desenha tudo que o Handler gerencia
        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String args[]){
        new Game();
    }
}
