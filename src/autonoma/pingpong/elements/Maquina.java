package autonoma.pingpong.elements;

import autonoma.pingpong.models.SpriteMobile;
import java.awt.Graphics;
import java.awt.Color;

public class Maquina extends SpriteMobile implements Runnable {

    private final Pelota pelota;
    private final int speed = 4;
    private final int containerHeight;
    private boolean running = true;

    public Maquina(int x, int y, int width, int height, Pelota pelota, int containerHeight) {
        super(x, y, width, height, 0, 0);
        this.pelota = pelota;
        this.containerHeight = containerHeight;
    }

    @Override
    public void run() {
        while (running) {
            if (pelota.getX() > x - 100) {
                if (pelota.getY() + pelota.getHeight() / 2 < y + height / 2) {
                    vy = -speed;
                } else if (pelota.getY() + pelota.getHeight() / 2 > y + height / 2) {
                    vy = speed;
                } else {
                    vy = 0;
                }
                update();
            }
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    @Override
    public void update() {
        super.update();
        if (y < 0) {
            y = 0;
        }
        if (y + height > containerHeight) {
            y = containerHeight - height;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}