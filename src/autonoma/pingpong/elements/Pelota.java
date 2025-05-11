package autonoma.pingpong.elements;

import autonoma.pingpong.models.SpriteMobile;
import java.awt.Graphics;
import java.awt.Color;

public class Pelota extends SpriteMobile {

    private int containerWidth, containerHeight;

    public Pelota(int x, int y, int size, int vx, int vy, int cw, int ch) {
        super(x, y, size, size, vx, vy);
        this.containerWidth = cw;
        this.containerHeight = ch;
    }

    @Override
    public void update() {
        super.update();
        if (x <= 0 || x + width >= containerWidth) {
            reverseX();
        }
        if (y <= 0 || y + height >= containerHeight) {
            reverseY();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }

    public void reset(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }
}
