package autonoma.pingpong.models;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un contenedor de sprites. Permite agrupar múltiples
 * objetos gráficos y delegar en ellos las operaciones de actualización y
 * dibujo.
 *
 * Es utilizada como clase base para escenarios o estructuras compuestas en el
 * juego, como el campo de juego.
 *
 * @author Cristian Camilo Salazar Arenas
 * @version 1.0
 * @since 2025.05.10
 */
public class SpriteContainer extends Sprite {

    /**
     * Lista de sprites hijos contenidos dentro de este contenedor.
     */
    protected List<Sprite> children = new ArrayList<>();

    /**
     * Crea un nuevo contenedor de sprites con la posición y dimensiones
     * especificadas.
     *
     * @param x Coordenada X del contenedor
     * @param y Coordenada Y del contenedor
     * @param width Ancho del contenedor
     * @param height Alto del contenedor
     * @since 2025.05.10
     */
    public SpriteContainer(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * Agrega un nuevo sprite al contenedor.
     *
     * @param s El sprite que se desea agregar
     */
    public void add(Sprite s) {
        children.add(s);
    }

    /**
     * Elimina un sprite del contenedor.
     *
     * @param s El sprite que se desea eliminar
     */
    public void remove(Sprite s) {
        children.remove(s);
    }

    /**
     * Actualiza todos los sprites hijos del contenedor.
     */
    @Override
    public void update() {
        for (Sprite s : children) {
            s.update();
        }
    }

    /**
     * Dibuja todos los sprites hijos del contenedor en el contexto gráfico.
     *
     * @param g El contexto gráfico donde se dibujarán los sprites
     */
    @Override
    public void draw(Graphics g) {
        for (Sprite s : children) {
            s.draw(g);
        }
    }
}