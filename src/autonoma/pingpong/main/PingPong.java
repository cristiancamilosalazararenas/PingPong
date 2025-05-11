package autonoma.pingpong.main;

import autonoma.pingpong.elements.CampoDeJuego;
import autonoma.pingpong.gui.VentanaPrincipal;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase principal que inicializa y ejecuta el juego de Ping Pong. Se encarga de
 * crear el campo de juego y controlar el ciclo de actualización.
 *
 * @author Cristian Camilo Salazar Arenas
 * @version 1.0
 * @since 2025.05.10
 */
public class PingPong {

    /**
     * Campo de juego donde se desarrollan los elementos y la lógica del juego.
     */
    private CampoDeJuego campo;

    /**
     * Crea una instancia del juego, inicializa el campo de juego y lanza el
     * bucle de actualización.
     *
     * @since 2025.05.10
     */
    public PingPong() {
        campo = new CampoDeJuego(800, 600);
        Timer t = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campo.update();
            }
        });
        t.start();
    }

    /**
     * Retorna el campo de juego actual, útil para integrarlo con la interfaz
     * gráfica.
     *
     * @return El campo de juego del juego de Ping Pong
     * @since 2025.05.10
     */
    public CampoDeJuego getCampo() {
        return campo;
    }

    /**
     * Método principal que lanza la aplicación y crea la ventana del juego.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     * @since 2025.05.10
     */
    public static void main(String[] args) {
        new VentanaPrincipal(new PingPong());
    }
}