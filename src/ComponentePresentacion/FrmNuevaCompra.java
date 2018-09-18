/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmNuevaCompra.java
 *
 * Created on 22/08/2010, 10:14:19 AM
 */
package ComponentePresentacion;

import ComponenteClase.*;
import ComponenteDatos.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Richard
 */
public class FrmNuevaCompra extends javax.swing.JFrame {

    /** Creates new form FrmNuevaCompra */
    public FrmNuevaCompra() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
         try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(idcompra) from COMPRA ");
            while (rs.next()) {
                int lastID = rs.getInt(1);
                txtnroCompra.setText(String.valueOf(lastID + 1));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.print(error);
        }
    }

    public void activarbotones(boolean b) {
        btnNuevoComp.setEnabled(b);
        btnAgregarProdComp.setEnabled(!b);
        btnAgregarUsComp.setEnabled(!b);
        btnBuscarCliente.setEnabled(!b);
        btnCancelarComp.setEnabled(!b);
    }

    public void limpiartextos() {
        txtCodCliente.setText("");
        txtDatoClienteComp.setText("");
    }

    public void activartextos(boolean b) {
        txtCodCliente.setEditable(b);
        txtDatoClienteComp.setEditable(b);
    }

    public void AgregarCompra() {
        Compra c = new Compra() {
        };
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {

            fecha = formatoDelTexto.parse(txtFechaActual.getText());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        c.setIdCompra(Integer.parseInt(txtnroCompra.getText()));
        c.setFechaCompra((Date) fecha);
        c.setTipoComprobante((String) cboTipoComprobante.getSelectedItem());
        try {
            Empleado emp = BDEmpleado.buscarEmpleadoApe(lbldatosEmp.getText());
            c.setempleado(emp);
            Cliente cl = BDCliente.buscarCliente(txtCodCliente.getText());
            c.setCliente(cl);
            BDCompra.insertarCompra(c);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
        }
    }

    public void buscarClienteCod(String Cod) {
        Cliente c = null;
        try {
            c = BDCliente.buscarCliente(Cod);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (c != null) {
            txtCodCliente.setText(String.valueOf(c.getCodCliente()));
            txtDatoClienteComp.setText(c.getNombre());
            txtDocumentoC.setText(c.getNumDocumento());
            txtTelefComp.setText(c.getTelefono());
        } else {
            JOptionPane.showMessageDialog(null, "No exite");
        }
    }

    public void buscarClienteNumDoc(String numdoc) {
        Cliente c = null;
        try {
            c = BDCliente.buscarClienteNumDoc(numdoc);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (c != null) {
            txtCodCliente.setText(String.valueOf(c.getCodCliente()));
            txtDatoClienteComp.setText(c.getNombre());
            txtDocumentoC.setText(c.getNumDocumento());
            txtTelefComp.setText(c.getTelefono());
        } else {
            JOptionPane.showMessageDialog(null, "No exite");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFechaActual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboTipoComprobante = new javax.swing.JComboBox();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        txtDatoClienteComp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        lbldatosEmp = new javax.swing.JLabel();
        txtDocumentoC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelefComp = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevoComp = new javax.swing.JButton();
        btnAgregarProdComp = new javax.swing.JButton();
        btnAgregarUsComp = new javax.swing.JButton();
        btnReporteComp = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        btnCancelarComp = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnroCompra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));

        jLabel2.setText("FECHA:");

        txtFechaActual.setEditable(false);
        txtFechaActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaActual.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        jLabel7.setText("TIPO COMPROBANTE A EMITIR :");

        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "BOLETA", "FACTURA", "NOTA DE VENTA" }));
        cboTipoComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoComprobanteActionPerformed(evt);
            }
        });

        jLabel3.setText("EMPLEADO:");

        txtCodCliente.setEditable(false);
        txtCodCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDatoClienteComp.setEditable(false);

        jLabel5.setText("CLIENTE :");

        lbldatosEmp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbldatosEmp.setText("ORUNA RODRIGUEZ");

        txtDocumentoC.setEditable(false);
        txtDocumentoC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("DOC.:");

        jLabel6.setText("TEL.:");

        txtTelefComp.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldatosEmp)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDatoClienteComp, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDocumentoC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefComp, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbldatosEmp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDatoClienteComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDocumentoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jToolBar1.setBackground(new java.awt.Color(247, 254, 255));
        jToolBar1.setRollover(true);

        btnNuevoComp.setBackground(new java.awt.Color(247, 254, 255));
        btnNuevoComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/new.jpg"))); // NOI18N
        btnNuevoComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCompActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevoComp);

        btnAgregarProdComp.setBackground(new java.awt.Color(247, 254, 255));
        btnAgregarProdComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/shopping_cart_add_1.jpg"))); // NOI18N
        btnAgregarProdComp.setEnabled(false);
        btnAgregarProdComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdCompActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregarProdComp);

        btnAgregarUsComp.setBackground(new java.awt.Color(247, 254, 255));
        btnAgregarUsComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/addcliente.jpg"))); // NOI18N
        btnAgregarUsComp.setEnabled(false);
        btnAgregarUsComp.setFocusable(false);
        btnAgregarUsComp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarUsComp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarUsComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsCompActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregarUsComp);

        btnReporteComp.setBackground(new java.awt.Color(247, 254, 255));
        btnReporteComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/sales-report.jpg"))); // NOI18N
        btnReporteComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteCompActionPerformed(evt);
            }
        });
        jToolBar1.add(btnReporteComp);

        btnBuscarCliente.setBackground(new java.awt.Color(247, 254, 255));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Search-Male-User.jpg"))); // NOI18N
        btnBuscarCliente.setEnabled(false);
        btnBuscarCliente.setFocusable(false);
        btnBuscarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscarCliente);

        btnCancelarComp.setBackground(new java.awt.Color(247, 254, 255));
        btnCancelarComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Cancel__Red.jpg"))); // NOI18N
        btnCancelarComp.setEnabled(false);
        btnCancelarComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCompActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelarComp);

        btnSalir.setBackground(new java.awt.Color(247, 254, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/Close-64.jpg"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nro-COMPRA:");

        txtnroCompra.setEditable(false);
        txtnroCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtnroCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(368, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProdCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProdCompActionPerformed
        // TODO add your handling code here:
        AgregarCompra();
        if (cboTipoComprobante.getSelectedItem().toString().equalsIgnoreCase("BOLETA")) {
            FrmTransaccion FrmTC = new FrmTransaccion();
            if (txtDocumentoC.getText().length() == 8) {
                FrmTC.lblRucT.setText("DNI");
                FrmTC.txtRucF.setText(txtDocumentoC.getText());
            } else {
                FrmTC.lblRucT.setText("DNI");
                FrmTC.txtRucF.setText(txtDocumentoC.getText());
            }
            FrmTC.txtDatoClienteT.setText(txtDatoClienteComp.getText());
            FrmTC.txtTelefonoT.setText(txtTelefComp.getText());
            FrmTC.lblNombreTipoComp.setText("BOLETA DE VENTA");
            FrmTC.setVisible(true);
        } else if (cboTipoComprobante.getSelectedItem().toString().equalsIgnoreCase("FACTURA")) {
            FrmTransaccion FrmTC = new FrmTransaccion();
            if (txtDocumentoC.getText().length() == 11) {
                FrmTC.lblRucT.setText("RUC");
                FrmTC.txtRucF.setText(txtDocumentoC.getText());
            } else {
                FrmTC.lblRucT.setText("RUC");
                FrmTC.txtRucF.setText("");
            }
            FrmTC.lblNombreTipoComp.setText("FACTURA DE VENTA");
            FrmTC.txtDatoClienteT.setText(txtDatoClienteComp.getText());
            FrmTC.setVisible(true);
        } else {
            FrmNotaVenta FrmNV = new FrmNotaVenta();
            FrmNV.txtDatoClienteNV.setText(txtDatoClienteComp.getText());
            FrmNV.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregarProdCompActionPerformed

    private void btnAgregarUsCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsCompActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(
                this, "Deseas Registrar al Cliente..?",
                "Mensaje..!!",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            FrmCliente Frmcl = new FrmCliente();
            Frmcl.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregarUsCompActionPerformed

    private void btnNuevoCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCompActionPerformed
        // TODO add your handling code here:
        activarbotones(false);
        activartextos(true);
        limpiartextos();
    }//GEN-LAST:event_btnNuevoCompActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCompActionPerformed
        // TODO add your handling code here:
        activarbotones(true);
    }//GEN-LAST:event_btnCancelarCompActionPerformed

    private void btnReporteCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteCompActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnReporteCompActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here
        int result = JOptionPane.showConfirmDialog(
                this, "Desea Buscar x Codigo?",
                "Mensaje..!!",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            String codclient = JOptionPane.showInputDialog("Buscar!!","Ingrese el Codigo ?");
            buscarClienteCod(codclient);
        }
        if (result == JOptionPane.NO_OPTION) {
            String numdocto = JOptionPane.showInputDialog("Buscar!!","Ingrese el Numero de Documento ?");
            buscarClienteNumDoc(numdocto);
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void cboTipoComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoComprobanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoComprobanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrmNuevaCompra().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProdComp;
    private javax.swing.JButton btnAgregarUsComp;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCancelarComp;
    private javax.swing.JButton btnNuevoComp;
    private javax.swing.JButton btnReporteComp;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox cboTipoComprobante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbldatosEmp;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtDatoClienteComp;
    private javax.swing.JTextField txtDocumentoC;
    private javax.swing.JTextField txtFechaActual;
    private javax.swing.JTextField txtTelefComp;
    private javax.swing.JTextField txtnroCompra;
    // End of variables declaration//GEN-END:variables
}
