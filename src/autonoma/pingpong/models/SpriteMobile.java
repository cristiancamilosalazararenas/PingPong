package autonoma.pingpong.models;

/**
 * Clase abstracta que representa un sprite móvil, es decir, un objeto que se
 * desplaza dentro del escenario. Hereda de {@link Sprite} y añade componentes
 * de velocidad en los ejes X y Y.
 *
 * Es utilizada como base para objetos móviles del juego como la pelota y los
 * jugadores.
 *
 * @author Cristian Camilo Salazar Arenas
 * @version 1.0
 * @since 2025.05.10
 */
public abstract class SpriteMobile extends Sprite {

    /**
     * Velocidad del sprite en el eje X.
     */
    protected int vx;

    /**
     * Velocidad del sprite en el eje Y.
     */
    protected int vy;

    /**
     * Crea un nuevo sprite móvil con su posición, dimensiones y velocidad
     * inicial.
     *
     * @param x Coordenada X del sprite
     * @param y Coordenada Y del sprite
     * @param width Ancho del sprite
     * @param height Alto del sprite
     * @param vx Velocidad en el eje X
     * @param vy Velocidad en el eje Y
     * @since 2025.05.10
     */
    public SpriteMobile(int x, int y, int width, int height, int vx, int vy) {
        super(x, y, width, height);
        this.vx = vx;
        this.vy = vy;
    }

    /**
     * Actualiza la posición del sprite sumando su velocidad actual a sus
     * coordenadas.
     */
    @Override
    public void update() {
        x += vx;
        y += vy;
    }

    /**
     * Invierte la dirección de movimiento en el eje X.
     */
    public void reverseX() {
        vx = -vx;
    }

    /**
     * Invierte la dirección de movimiento en el eje Y.
     */
    public void reverseY() {
        vy = -vy;
    }

    /**
     * Establece una nueva velocidad para el sprite.
     *
     * @param vx Nueva velocidad en el eje X
     * @param vy Nueva velocidad en el eje Y
     */
    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }
}