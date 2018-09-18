/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenPresentacion;

import AlmacenClases.RevisionGuia;
import AlmacenClases.RevisionGuia_detalle;
import AlmacenDatos.DBRevisionGuias;
import AlmacenDatos.DBRevisionGuias_Detalle;
import ComponentePresentacion.FrmPanelFondoPrincipal;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jsarango
 */
public class JDDatosCierreGuia extends javax.swing.JDialog {

    public static int UltimoId = 0;
    DefaultTableModel ModeloTrabajadores;
    DateFormat ValorFecha = DateFormat.getDateInstance(DateFormat.MEDIUM);
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    Date FechaFinal = new Date();

    
    /**
     * Creates new form JDDatosCierreGuia
     */
    public JDDatosCierreGuia(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        FrmPanelFondoPrincipal fondoprinc = new FrmPanelFondoPrincipal();
        this.setSize(500, 300);
        this.add(fondoprinc, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.pack();
        
        String ValorFecha2 = sdf2.format(FechaFinal);
        //c.setFecha(ValorFecha1);

        txtHora_Final.setText(Integer.toString(FechaFinal.getHours()) + ":" + Integer.toString(FechaFinal.getMinutes()) + ":" + Integer.toString(FechaFinal.getSeconds()));
        txtFecha.setText(ValorFecha2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBotica = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcionGrupo = new javax.swing.JTextField();
        txtDescripcionBotica = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        txtHora_Final = new javax.swing.JTextField();
        txtHora_Inicio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTiempoAbastecedor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtBotica.setEditable(false);
        txtBotica.setBackground(new java.awt.Color(255, 255, 204));
        txtBotica.setForeground(new java.awt.Color(204, 0, 0));

        jLabel6.setText("Tiempo Demora Abastecedor");

        jLabel5.setText("Hora Final");

        jLabel4.setText("Hora Inicio");

        txtDescripcionGrupo.setBackground(new java.awt.Color(255, 255, 204));
        txtDescripcionGrupo.setForeground(new java.awt.Color(204, 0, 0));

        txtDescripcionBotica.setBackground(new java.awt.Color(255, 255, 204));
        txtDescripcionBotica.setForeground(new java.awt.Color(204, 0, 0));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 204));
        txtFecha.setForeground(new java.awt.Color(204, 0, 0));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtHora_Final.setEditable(false);
        txtHora_Final.setBackground(new java.awt.Color(255, 255, 204));
        txtHora_Final.setForeground(new java.awt.Color(204, 0, 0));

        txtHora_Inicio.setEditable(false);
        txtHora_Inicio.setBackground(new java.awt.Color(255, 255, 204));
        txtHora_Inicio.setForeground(new java.awt.Color(204, 0, 0));

        jLabel1.setText("Botica");

        txtGrupo.setBackground(new java.awt.Color(255, 255, 204));
        txtGrupo.setForeground(new java.awt.Color(204, 0, 0));

        jLabel3.setText("Fecha");

        jLabel2.setText("Grupo");

        jLabel8.setText("Minutos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBotica, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcionBotica, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(149, 149, 149)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcionGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtHora_Inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(txtFecha)
                                .addComponent(txtHora_Final))
                            .addComponent(txtTiempoAbastecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBotica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionBotica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora_Final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTiempoAbastecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        UltimoId = 0;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txtTiempoAbastecedor.getText().compareTo("") != 0) {
            RevisionGuia r = new RevisionGuia() {
            };

            r.setId_grupo(Integer.parseInt(txtGrupo.getText()));
            r.setId_Botica(txtBotica.getText());
            String ValorFecha1 = sdf1.format(FechaFinal);
            r.setFecha(ValorFecha1);
            r.setHora_Inicio(txtHora_Inicio.getText());
            r.setHora_Final(txtHora_Final.getText());
            r.setTiempoAbastecedor(txtTiempoAbastecedor.getText());
            
            try {
                UltimoId=DBRevisionGuias.insertarRevisionGuias(r);
            } catch (SQLException ex) {
                Logger.getLogger(JDDatosCierreGuia.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Datos Agregados Correctamente");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos..OKz");
            UltimoId = 0;
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

   

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JTextField txtBotica;
    public javax.swing.JTextField txtDescripcionBotica;
    public javax.swing.JTextField txtDescripcionGrupo;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtGrupo;
    public javax.swing.JTextField txtHora_Final;
    public javax.swing.JTextField txtHora_Inicio;
    private javax.swing.JTextField txtTiempoAbastecedor;
    // End of variables declaration//GEN-END:variables
}
