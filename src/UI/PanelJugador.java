package UI;

import Controllers.ControladorPanelJugador;
import Dominio.Juego.Carta;
import Dominio.Juego.EstadoMano;
import Dominio.Juego.EstadoMesa;
import Dominio.Usuarios.Jugador;
import Utilidades.InformacionPanel;
import Utilidades.MostrarError;
import java.util.ArrayList;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasListener;
import panelCartasPoker.PanelCartasPokerException;

public class PanelJugador extends javax.swing.JDialog implements PanelCartasListener, IVista<InformacionPanel> {

    ControladorPanelJugador controladorPanelJugador;
    int indiceMesa;

    public PanelJugador(java.awt.Dialog parent, boolean modal, int indiceMesa, Jugador jugador) {
        super(parent, modal);
        initComponents();
        this.indiceMesa = indiceMesa;
        controladorPanelJugador = new ControladorPanelJugador(this, jugador, indiceMesa);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NumeroMesa = new javax.swing.JLabel();
        NombreJugador = new javax.swing.JLabel();
        SaldoJugador = new javax.swing.JLabel();
        ManoActual = new javax.swing.JLabel();
        txtEstadoMano = new javax.swing.JLabel();
        PozoTotal = new javax.swing.JLabel();
        Apuesta = new javax.swing.JLabel();
        FiguraMasAlta = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFiguras = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listJugadores = new javax.swing.JList();
        panelCartasPoker2 = new panelCartasPoker.PanelCartasPoker();
        btnApostar = new javax.swing.JButton();
        txtApuestaJugador = new javax.swing.JTextField();
        btnIgualarApuesta = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        btnContinuarJugando = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtError = new javax.swing.JTextPane();
        btnPedirCartas = new javax.swing.JButton();
        txtCantidadCartasCambiadas = new javax.swing.JLabel();
        txtGanador = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        NumeroMesa.setText("Numero Mesa:");

        NombreJugador.setText("Jugador:");

        SaldoJugador.setText("Saldo:");

        ManoActual.setText("Mano actual:");

        txtEstadoMano.setText("Estado de la mano:");

        PozoTotal.setText("Pozo total:");

        Apuesta.setText("Apuesta:");

        FiguraMasAlta.setText("Figura mas alta:");

        jLabel9.setText("Figuras definidas:");

        jScrollPane1.setViewportView(listFiguras);

        jLabel10.setText("Jugadores:");

        jScrollPane2.setViewportView(listJugadores);

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });

        txtApuestaJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApuestaJugadorActionPerformed(evt);
            }
        });

        btnIgualarApuesta.setText("Igualar apuesta");
        btnIgualarApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgualarApuestaActionPerformed(evt);
            }
        });

        btnPasar.setText("Pasar");
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });

        btnContinuarJugando.setText("Continuar Jugando");
        btnContinuarJugando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarJugandoActionPerformed(evt);
            }
        });

        txtError.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jScrollPane3.setViewportView(txtError);

        btnPedirCartas.setText("Pedir cartas");
        btnPedirCartas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedirCartasActionPerformed(evt);
            }
        });

        txtGanador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FiguraMasAlta)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelCartasPoker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtApuestaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnApostar)
                                        .addGap(78, 78, 78)
                                        .addComponent(btnIgualarApuesta)))
                                .addGap(71, 71, 71)
                                .addComponent(btnPasar)
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantidadCartasCambiadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPedirCartas, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnContinuarJugando)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir)
                                .addGap(114, 114, 114))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NumeroMesa))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SaldoJugador)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ManoActual)
                                        .addGap(65, 65, 65)
                                        .addComponent(txtEstadoMano)
                                        .addGap(72, 72, 72)
                                        .addComponent(PozoTotal)
                                        .addGap(81, 81, 81)
                                        .addComponent(Apuesta)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreJugador)
                    .addComponent(SaldoJugador)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumeroMesa)
                            .addComponent(ManoActual)
                            .addComponent(txtEstadoMano)
                            .addComponent(PozoTotal)
                            .addComponent(Apuesta))
                        .addGap(18, 18, 18)
                        .addComponent(FiguraMasAlta)
                        .addGap(19, 19, 19)
                        .addComponent(txtGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(panelCartasPoker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnApostar)
                        .addComponent(txtApuestaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIgualarApuesta)
                        .addComponent(btnPasar)
                        .addComponent(btnPedirCartas))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnContinuarJugando)
                        .addComponent(btnSalir)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadCartasCambiadas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controladorPanelJugador.SalirDeMesa();
    }//GEN-LAST:event_formWindowClosing

    private void txtApuestaJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApuestaJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApuestaJugadorActionPerformed

    private void btnIgualarApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualarApuestaActionPerformed
        controladorPanelJugador.igualarApuesta();
    }//GEN-LAST:event_btnIgualarApuestaActionPerformed

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        String apuesta = txtApuestaJugador.getText();
        controladorPanelJugador.RealizarApuesta(apuesta);
        txtApuestaJugador.setText("");
    }//GEN-LAST:event_btnApostarActionPerformed

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        controladorPanelJugador.pasarMano();
    }//GEN-LAST:event_btnPasarActionPerformed

    private void btnPedirCartasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedirCartasActionPerformed
        controladorPanelJugador.pedirCartas();
    }//GEN-LAST:event_btnPedirCartasActionPerformed

    private void btnContinuarJugandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarJugandoActionPerformed
        controladorPanelJugador.continuarJugando();
    }//GEN-LAST:event_btnContinuarJugandoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        controladorPanelJugador.SalirDeMesa();
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Apuesta;
    private javax.swing.JLabel FiguraMasAlta;
    private javax.swing.JLabel ManoActual;
    private javax.swing.JLabel NombreJugador;
    private javax.swing.JLabel NumeroMesa;
    private javax.swing.JLabel PozoTotal;
    private javax.swing.JLabel SaldoJugador;
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnContinuarJugando;
    private javax.swing.JButton btnIgualarApuesta;
    private javax.swing.JButton btnPasar;
    private javax.swing.JButton btnPedirCartas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listFiguras;
    private javax.swing.JList listJugadores;
    private panelCartasPoker.PanelCartasPoker panelCartasPoker2;
    private javax.swing.JTextField txtApuestaJugador;
    private javax.swing.JLabel txtCantidadCartasCambiadas;
    private javax.swing.JTextPane txtError;
    private javax.swing.JLabel txtEstadoMano;
    private javax.swing.JLabel txtGanador;
    // End of variables declaration//GEN-END:variables

    @Override
    public void clickEnCarta(CartaPoker carta) {
    }

    @Override
    public void mostrarError(String mensaje) {
        MostrarError.MostrarError(txtError, mensaje);
    }

    @Override
    public void cargarDatos(InformacionPanel informacion) {
        NombreJugador.setText("Jugador: " + informacion.getNombreJugador());
        SaldoJugador.setText("Saldo: " + informacion.getSaldoJugador());
        NumeroMesa.setText("Mesa: " + informacion.getNumeroMesa());
        PozoTotal.setText("Pozo: " + informacion.getPozo());
        ManoActual.setText("Mano: " + informacion.getNumeroManoActual());
        txtEstadoMano.setText("Estado: " + informacion.getEstadoString());
        Apuesta.setText("Apuesta: " + informacion.getApuesta());
        listFiguras.setListData(informacion.getFiguras().toArray());
        listJugadores.setListData(informacion.getJugadores().toArray());

        if (informacion.getEstadoManoActual().equals(EstadoMano.Terminada)) {
            if (informacion.getJugadorGanador() != null) {
                txtGanador.setText("Ganador: " + informacion.getJugadorGanador().getNombreCompleto() + " (" + informacion.getFiguraGanadoraMano() + ")");
            } else {
                txtGanador.setText("");
            }
        }else {
                txtGanador.setText("");
            }

        if (informacion.getCantidadCartasCambiadas() > 0) {
            txtCantidadCartasCambiadas.setText("Has cambiado " + informacion.getCantidadCartasCambiadas() + " carta/s");
        } else {
            txtCantidadCartasCambiadas.setText("");
        }

        if (informacion.getEstadoMesa().equals(EstadoMesa.Iniciada)) {
            if (informacion.getEstadoManoJugador().equals(EstadoMano.Terminada) && informacion.getEstadoMesa().equals(EstadoMano.PidiendoCartas)) {
                panelCartasPoker2.setEnabled(false);
            } else {
                panelCartasPoker2.setEnabled(true);
            }

            FiguraMasAlta.setText("Figura mas alta: " + informacion.getFiguraMasAltaJugador());
        } else {
            panelCartasPoker2.setEnabled(false);
        }

        try {
            if (informacion.getCartasJugador() != null && informacion.getCartasJugador().size() == 5) {
                ArrayList<CartaPoker> cartasPoker = new ArrayList<CartaPoker>();
                for (Carta c : informacion.getCartasJugador()) {
                    cartasPoker.add((CartaPoker) c);
                }
                panelCartasPoker2.cargarCartas(cartasPoker);
            }
        } catch (PanelCartasPokerException ex) {
        }
    }

    @Override
    public void cargarInformacionAdicional(InformacionPanel dato) {
    }
}
