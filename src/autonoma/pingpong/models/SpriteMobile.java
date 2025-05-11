package autonoma.pingpong.models;

public abstract class SpriteMobile extends Sprite {

    protected int vx, vy;

    public SpriteMobile(int x, int y, int width, int height, int vx, int vy) {
        super(x, y, width, height);
        this.vx = vx;
        this.vy = vy;
    }

    @Override
    public void update() {
        x += vx;
        y += vy;
    }

    public void reverseX() {
        vx = -vx;
    }

    public void reverseY() {
        vy = -vy;
    }

    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }
}
