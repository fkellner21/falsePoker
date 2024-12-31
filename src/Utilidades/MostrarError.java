package Utilidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import javax.swing.Timer;

public class MostrarError {
    public static void MostrarError(JTextPane txtError, String mensaje){
        txtError.setText(mensaje);
        txtError.setVisible(true);
        
        Timer timer = new Timer(5000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                txtError.setText("");
                txtError.setVisible(false);
            }
        });
        
        timer.setRepeats(false);
        timer.start();
    }
}
