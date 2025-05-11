package autonoma.pingpong.main;

import autonoma.pingpong.elements.CampoDeJuego;
import autonoma.pingpong.gui.VentanaPrincipal;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PingPong {

    private CampoDeJuego campo;

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

    public CampoDeJuego getCampo() {
        return campo;
    }

    public static void main(String[] args) {
        new VentanaPrincipal(new PingPong());
    }
}
