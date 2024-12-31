package UI;

import Controllers.ControladorMenuJugador;
import Dominio.Juego.Mesa;
import Dominio.Usuarios.Jugador;
import Utilidades.InformacionMenu;
import Utilidades.MostrarError;
import javax.swing.table.DefaultTableModel;

public class MenuJugador extends javax.swing.JDialog implements IMenuJugador<InformacionMenu> { 
    ControladorMenuJugador controladorMenuJugador;
    int indiceMesa;

    public MenuJugador(java.awt.Frame parent, boolean modal, Jugador jugador) {
        super(parent, modal);
        initComponents();
        this.controladorMenuJugador = new ControladorMenuJugador(this, jugador);
        this.setTitle(jugador.getNombreCompleto());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMesas = new javax.swing.JTable();
        btnIngresarMesa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtError = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtNombre.setText("Bienvenido");

        txtSaldo.setText("Tu saldo actual es de: $ ");

        tablaMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Jugadores minimos", "Apuesta base", "Jugadores actuales", "Comision de la mesa"
            }
        ));
        jScrollPane1.setViewportView(tablaMesas);

        btnIngresarMesa.setText("Ingresar a la mesa");
        btnIngresarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarMesaActionPerformed(evt);
            }
        });

        txtError.setEditable(false);
        txtError.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtError.setEnabled(false);
        jScrollPane2.setViewportView(txtError);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSaldo)
                    .addComponent(txtNombre)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIngresarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSaldo)
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresarMesa))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controladorMenuJugador.desloguear();
        controladorMenuJugador.SalirDeMesa();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnIngresarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarMesaActionPerformed
        int index = tablaMesas.getSelectedRow();
        txtError.setVisible(false);
        txtError.setText("");
        controladorMenuJugador.IngresarAMesa(index);
        indiceMesa = index;
    }//GEN-LAST:event_btnIngresarMesaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarMesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaMesas;
    private javax.swing.JTextPane txtError;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtSaldo;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void mostrarError(String mensaje) {
        MostrarError.MostrarError(txtError, mensaje);
    }

    @Override
    public void cargarDatos(InformacionMenu informacion) {
        txtNombre.setText("Bienvenido " + informacion.getNombreJugador());
        txtSaldo.setText("Tu saldo actual es de : $ " + informacion.getSaldoJugador());
        
        DefaultTableModel model = (DefaultTableModel) tablaMesas.getModel();
        model.setRowCount(0);
        for (Mesa mesa : informacion.getMesas()) {
             Object[] row = { mesa.getNumero(), mesa.getMinimoDeJugadores(), mesa.getApuestaBase(), 
             mesa.getJugadores().size(), mesa.getPorcentajeComision()};

            model.addRow(row);
        }
    }

    @Override
    public void proximaVista(int indiceMesa) {
        Jugador jugador = controladorMenuJugador.obtenerJugadorLogueado();
        PanelJugador panel = new PanelJugador(this, false, indiceMesa, jugador);
        panel.setVisible(true);
    }

    @Override
    public void cargarInformacionAdicional(InformacionMenu dato) {
    }
}


