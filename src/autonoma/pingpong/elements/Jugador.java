// Este es el paquete donde se encuentra la clase Jugador.
package autonoma.pingpong.elements;

import autonoma.pingpong.models.SpriteMobile;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Clase que representa al jugador controlado por el usuario en el juego de Ping
 * Pong. Se encarga de manejar el movimiento vertical del jugador dentro de los
 * límites del campo.
 *
 * @author Cristian Camilo Salazar Arenas
 * @version 1.0
 * @since 2025.05.10
 */
public class Jugador extends SpriteMobile {

    /**
     * Velocidad de movimiento del jugador en píxeles por actualización.
     */
    private final int speed = 5;

    /**
     * Altura del contenedor (campo de juego) que limita el movimiento del
     * jugador.
     */
    private final int containerHeight;

    /**
     * Crea un nuevo jugador en la posición especificada.
     *
     * @param x Posición horizontal inicial
     * @param y Posición vertical inicial
     * @param width Ancho del jugador
     * @param height Altura del jugador
     * @param containerHeight Altura máxima del campo de juego (para evitar que
     * se salga)
     * @since 2025.05.10
     */
    public Jugador(int x, int y, int width, int height, int containerHeight) {
        super(x, y, width, height, 0, 0);
        this.containerHeight = containerHeight;
    }

    /**
     * Actualiza la posición del jugador en cada ciclo del juego, asegurando que
     * no se salga de los límites verticales del campo.
     *
     * @since 2025.05.10
     */
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

    /**
     * Mueve al jugador hacia arriba cambiando su velocidad vertical.
     *
     * @since 2025.05.10
     */
    public void moveUp() {
        vy = -speed;
    }

    /**
     * Mueve al jugador hacia abajo cambiando su velocidad vertical.
     *
     * @since 2025.05.10
     */
    public void moveDown() {
        vy = speed;
    }

    /**
     * Detiene el movimiento del jugador (velocidad vertical igual a cero).
     *
     * @since 2025.05.10
     */
    public void stop() {
        vy = 0;
    }

    /**
     * Dibuja el jugador como un rectángulo blanco en el contexto gráfico
     * especificado.
     *
     * @param g El objeto Graphics donde se dibujará el jugador
     * @since 2025.05.10
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}