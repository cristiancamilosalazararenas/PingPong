package autonoma.pingpong.models;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Clase abstracta que representa un objeto gráfico en el juego. Define
 * propiedades comunes como posición y tamaño, además de métodos para actualizar
 * y dibujar.
 *
 * Esta clase sirve como base para todos los elementos visuales del juego, como
 * jugadores, pelota, etc.
 *
 * @author Cristian Camilo Salazar Arenas
 * @version 1.0
 * @since 2025.05.10
 */
public abstract class Sprite {

    /**
     * Coordenada X del sprite en el campo de juego.
     */
    protected int x;

    /**
     * Coordenada Y del sprite en el campo de juego.
     */
    protected int y;

    /**
     * Ancho del sprite.
     */
    protected int width;

    /**
     * Alto del sprite.
     */
    protected int height;

    /**
     * Crea un nuevo sprite con la posición y tamaño especificados.
     *
     * @param x Coordenada X inicial
     * @param y Coordenada Y inicial
     * @param width Ancho del sprite
     * @param height Alto del sprite
     * @since 2025.05.10
     */
    public Sprite(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Obtiene la coordenada X del sprite.
     *
     * @return La posición horizontal
     */
    public int getX() {
        return x;
    }

    /**
     * Obtiene la coordenada Y del sprite.
     *
     * @return La posición vertical
     */
    public int getY() {
        return y;
    }

    /**
     * Retorna el ancho del sprite.
     *
     * @return El ancho del sprite
     */
    public int getWidth() {
        return width;
    }

    /**
     * Retorna el alto del sprite.
     *
     * @return El alto del sprite
     */
    public int getHeight() {
        return height;
    }

    /**
     * Método abstracto que actualiza la lógica del sprite. Debe ser
     * implementado por las clases hijas.
     */
    public abstract void update();

    /**
     * Método abstracto que dibuja el sprite en el contexto gráfico recibido.
     * Debe ser implementado por las clases hijas.
     *
     * @param g El contexto gráfico donde se debe dibujar el sprite
     */
    public abstract void draw(Graphics g);

    /**
     * Retorna un rectángulo que representa los límites del sprite. Útil para
     * detectar colisiones.
     *
     * @return Un objeto Rectangle con la posición y dimensiones del sprite
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}