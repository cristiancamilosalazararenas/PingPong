package autonoma.pingpong.models;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class SpriteContainer extends Sprite {

    protected List<Sprite> children = new ArrayList<>();

    public SpriteContainer(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void add(Sprite s) {
        children.add(s);
    }

    public void remove(Sprite s) {
        children.remove(s);
    }

    @Override
    public void update() {
        for (Sprite s : children) {
            s.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        for (Sprite s : children) {
            s.draw(g);
        }
    }
}
