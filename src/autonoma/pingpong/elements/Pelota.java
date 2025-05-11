// Este es el paquete donde se encuentra la clase Pelota.
package autonoma.pingpong.elements;

import autonoma.pingpong.models.SpriteMobile;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Clase que representa la pelota del juego de Ping Pong. Se mueve en ambas
 * direcciones y rebota contra los límites del campo de juego.
 *
 * @author Cristian Camilo Salazar Arenas
 * @version 1.0
 * @since 2025.05.10
 */
public class Pelota extends SpriteMobile {

    /**
     * Ancho del contenedor donde se mueve la pelota.
     */
    private int containerWidth;

    /**
     * Altura del contenedor donde se mueve la pelota.
     */
    private int containerHeight;

    /**
     * Crea una nueva pelota con su posición, tamaño, velocidad y límites
     * definidos.
     *
     * @param x Posición horizontal inicial
     * @param y Posición vertical inicial
     * @param size Tamaño de la pelota (ancho y alto)
     * @param vx Velocidad horizontal inicial
     * @param vy Velocidad vertical inicial
     * @param cw Ancho del campo de juego
     * @param ch Altura del campo de juego
     * @since 2025.05.10
     */
    public Pelota(int x, int y, int size, int vx, int vy, int cw, int ch) {
        super(x, y, size, size, vx, vy);
        this.containerWidth = cw;
        this.containerHeight = ch;
    }

    /**
     * Actualiza la posición de la pelota y detecta colisiones con los bordes
     * superior e inferior. Rebota automáticamente cuando toca esos límites.
     *
     * @since 2025.05.10
     */
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

    /**
     * Dibuja la pelota como un óvalo blanco en la pantalla.
     *
     * @param g El contexto gráfico donde se dibuja la pelota
     * @since 2025.05.10
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }

    /**
     * Reinicia la posición y velocidad de la pelota, útil al anotar un punto.
     *
     * @param x Nueva posición horizontal
     * @param y Nueva posición vertical
     * @param vx Nueva velocidad horizontal
     * @param vy Nueva velocidad vertical
     * @since 2025.05.10
     */
    public void reset(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }
}