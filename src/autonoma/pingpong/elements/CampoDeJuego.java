// Este es el paquete donde se encuentra la clase CampoDeJuego.
package autonoma.pingpong.elements;

// Importamos las clases necesarias
import autonoma.pingpong.models.SpriteContainer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Clase que representa el campo de juego donde se desarrolla el partido de Ping
 * Pong. Contiene a los jugadores, la pelota y gestiona la lógica de colisiones
 * y puntajes.
 *
 * @author Cristian Camilo Salazar Arenas
 * @version 1.0
 * @since 2025.05.10
 */
public class CampoDeJuego extends SpriteContainer {

    /**
     * Representa el jugador controlado por el usuario.
     */
    private Jugador jugador;

    /**
     * Representa la máquina que juega automáticamente.
     */
    private Maquina maquina;

    /**
     * Pelota que se mueve en el campo y colisiona con jugadores.
     */
    private Pelota pelota;

    /**
     * Puntaje del jugador humano.
     */
    private int scorePlayer;

    /**
     * Puntaje de la máquina.
     */
    private int scoreMachine;

    /**
     * Crea un nuevo campo de juego con los elementos iniciales en sus
     * posiciones predeterminadas.
     *
     * @param width Ancho del campo de juego
     * @param height Altura del campo de juego
     * @since 2025.05.10
     */
    public CampoDeJuego(int width, int height) {
        super(0, 0, width, height);
        int paddleW = 20, paddleH = 100;
        int centerY = height / 2 - paddleH / 2;

        jugador = new Jugador(0, centerY, paddleW, paddleH, height);
        pelota = new Pelota(width / 2, height / 2, 10, 3, 3, width, height);
        maquina = new Maquina(width - paddleW, centerY, paddleW, paddleH, pelota, height);

        add(jugador);
        add(pelota);
        add(maquina);

        new Thread(maquina).start();
    }

    /**
     * Actualiza la lógica del juego en cada frame. Maneja las colisiones entre
     * la pelota y los jugadores, y actualiza los puntajes cuando alguien anota.
     *
     * @since 2025.05.10
     */
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

    /**
     * Dibuja el campo de juego y los elementos visibles, como los puntajes y la
     * línea central.
     *
     * @param g El contexto gráfico donde se dibujan los elementos
     * @since 2025.05.10
     */
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

    /**
     * Retorna la instancia del jugador humano, útil para detectar entrada del
     * teclado.
     *
     * @return El objeto Jugador que representa al jugador humano
     * @since 2025.05.10
     */
    public Jugador getJugador() {
        return jugador;
    }
}