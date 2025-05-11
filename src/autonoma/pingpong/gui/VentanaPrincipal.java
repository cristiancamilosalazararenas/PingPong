
package autonoma.pingpong.gui;

import autonoma.pingpong.main.PingPong;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Ventana principal del juego Ping Pong. Gestiona la interfaz gráfica, el doble
 * buffer, el repintado y la entrada del teclado.
 *
 * Esta clase actúa como la capa de presentación del juego.
 *
 * @author Cristian Camilo Salazar Arenas
 * @version 1.0
 * @since 2025.05.10
 */

public class VentanaPrincipal extends JFrame {

    /**
     * Objeto principal que contiene la lógica y los elementos del juego.
     */
    private PingPong pingPong;

    /**
     * Imagen usada como buffer para renderizar el contenido y evitar parpadeo.
     */
    private BufferedImage buffer;

    /**
     * Crea una nueva ventana gráfica e inicia el bucle de renderizado.
     *
     * @param pingPong Instancia principal del juego que contiene el campo de juego
     * @since 2025.05.10
     */
    public VentanaPrincipal(PingPong pingPong) {
        this.pingPong = pingPong;
        initUI();
    }

    /**
     * Inicializa la interfaz gráfica, ajustando el tamaño, título, comportamiento del teclado
     * y creando el timer para el repintado automático.
     */
    private void initUI() {
        setTitle("Ping Pong");
        setSize(pingPong.getCampo().getWidth(), pingPong.getCampo().getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Control del jugador con teclado
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        pingPong.getCampo().getJugador().moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        pingPong.getCampo().getJugador().moveDown();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    pingPong.getCampo().getJugador().stop();
                }
            }
        });

        setVisible(true);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        // Timer que llama al método repaint cada ~16ms (aproximadamente 60 FPS)
        Timer timer = new Timer(16, e -> repaint());
        timer.start();
    }

    /**
     * Dibuja el contenido del juego utilizando doble buffer para evitar parpadeos.
     * Se actualiza el estado del juego y se representa todo en una imagen intermedia.
     *
     * @param g El contexto gráfico sobre el cual se dibuja la imagen buffer
     * @since 2025.05.10
     */
    @Override
    public void paint(Graphics g) {
        if (buffer == null || buffer.getWidth() != getWidth() || buffer.getHeight() != getHeight()) {
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        }

        Graphics2D g2d = buffer.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        pingPong.getCampo().update();
        pingPong.getCampo().draw(g2d);

        g2d.dispose();
        g.drawImage(buffer, 0, 0, null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
