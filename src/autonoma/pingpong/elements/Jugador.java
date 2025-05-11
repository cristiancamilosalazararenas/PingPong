package autonoma.pingpong.elements;

import autonoma.pingpong.models.SpriteMobile;
import java.awt.Graphics;
import java.awt.Color;

public class Jugador extends SpriteMobile {

    private final int speed = 5;
    private final int containerHeight;

    public Jugador(int x, int y, int width, int height, int containerHeight) {
        super(x, y, width, height, 0, 0);
        this.containerHeight = containerHeight;
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

    public void moveUp() {
        vy = -speed;
    }

    public void moveDown() {
        vy = speed;
    }

    public void stop() {
        vy = 0;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}