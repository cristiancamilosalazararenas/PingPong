package autonoma.pingpong.elements;

import autonoma.pingpong.models.SpriteContainer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class CampoDeJuego extends SpriteContainer {

    private Jugador jugador;
    private Maquina maquina;
    private Pelota pelota;
    private int scorePlayer, scoreMachine;

    public CampoDeJuego(int width, int height) {
        super(0, 0, width, height);
        int paddleW = 20, paddleH = 100;
        int centerY = height / 2 - paddleH / 2;

        jugador = new Jugador(0, centerY, paddleW, paddleH, height);
        pelota = new Pelota(width / 2, height / 2, 10, 3, 3, width, height);
        // Aquí pasamos también 'height' al constructor de Maquina
        maquina = new Maquina(width - paddleW, centerY, paddleW, paddleH, pelota, height);

        add(jugador);
        add(pelota);
        add(maquina);

        new Thread(maquina).start();
    }

    @Override
    public void update() {
        super.update();
        if (pelota.getBounds().intersects(jugador.getBounds())) {
            pelota.reverseX();
        }
        if (pelota.getBounds().intersects(maquina.getBounds())) {
            pelota.reverseX();
        }
        if (pelota.getX() <= 0) {
            scoreMachine++;
            pelota.reset(getWidth() / 2, getHeight() / 2, -3, 3);
        }
        if (pelota.getX() + pelota.getWidth() >= getWidth()) {
            scorePlayer++;
            pelota.reset(getWidth() / 2, getHeight() / 2, 3, -3);
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        int cx = getWidth() / 2;
        g.drawLine(cx, 0, cx, getHeight());
        g.drawString(String.valueOf(scorePlayer), cx + 30, getHeight() / 2 + 10);
        g.drawString(String.valueOf(scoreMachine), cx - 50, getHeight() / 2 + 10);
    }

    public Jugador getJugador() {
        return jugador;
    }
}