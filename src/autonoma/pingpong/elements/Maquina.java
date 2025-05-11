// Este es el paquete donde se encuentra la clase Maquina.
package autonoma.pingpong.elements;

import autonoma.pingpong.models.SpriteMobile;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Clase que representa a la máquina o jugador automático en el juego de Ping
 * Pong. Implementa la interfaz Runnable para poder moverse de forma autónoma
 * siguiendo la pelota.
 *
 * @author Cristian Camilo Salazar Arenas
 * @version 1.0
 * @since 2025.05.10
 */
public class Maquina extends SpriteMobile implements Runnable {

    /**
     * Referencia a la pelota para seguir su movimiento.
     */
    private final Pelota pelota;

    /**
     * Velocidad de movimiento de la máquina.
     */
    private final int speed = 4;

    /**
     * Altura del contenedor que limita el movimiento vertical de la máquina.
     */
    private final int containerHeight;

    /**
     * Bandera que controla si el hilo debe seguir ejecutándose.
     */
    private boolean running = true;

    /**
     * Crea una nueva instancia de la máquina en la posición especificada.
     *
     * @param x Posición horizontal inicial
     * @param y Posición vertical inicial
     * @param width Ancho de la máquina
     * @param height Altura de la máquina
     * @param pelota Referencia a la pelota del juego
     * @param containerHeight Altura del campo de juego para restringir el
     * movimiento
     * @since 2025.05.10
     */
    public Maquina(int x, int y, int width, int height, Pelota pelota, int containerHeight) {
        super(x, y, width, height, 0, 0);
        this.pelota = pelota;
        this.containerHeight = containerHeight;
    }

    /**
     * Lógica de movimiento automático de la máquina. Sigue verticalmente la
     * posición de la pelota cuando esta se aproxima, y limita su velocidad para
     * simular dificultad.
     *
     * @since 2025.05.10
     */
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
                Thread.sleep(16); // Aproximadamente 60 FPS
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    /**
     * Actualiza la posición de la máquina asegurando que no se salga de los
     * límites verticales.
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
     * Dibuja la paleta de la máquina como un rectángulo blanco en pantalla.
     *
     * @param g El contexto gráfico donde se dibujará la máquina
     * @since 2025.05.10
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}