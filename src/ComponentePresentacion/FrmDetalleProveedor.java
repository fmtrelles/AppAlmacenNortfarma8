/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmDetalleProveedor.java
 *
 * Created on 30/08/2010, 12:45:29 PM
 */

package ComponentePresentacion;

import ComponenteClase.*;
import ComponenteDatos.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public class FrmDetalleProveedor extends javax.swing.JFrame {

    /** Creates new form FrmDetalleProveedor */
    public FrmDetalleProveedor() {
        initComponents();
    }

    public void buscarProveedorRuc(String ruc) {
        Proveedor p = null;
        try {
            p = BDProveedor.buscarProveedor(ruc);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (p != null) {
            txtRuc.setText(p.getRuc());
            txtRazonSocial.setText(p.getRazonSocial());
            txtmDireccion.setText(p.getDireccion());
            txtmTelefono.setText(p.getTelefono());
        } else {
            JOptionPane.showMessageDialog(null, "No exite");
        }
    }
    public void buscarProductoID(int idprod) {
        Producto pd = null;
        try {
            pd = BDProducto.buscarProducto(idprod);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (pd != null) {
            txtmIdprod.setText(String.valueOf(pd.getIdProducto()));
            txtmNomProducto.setText(pd.getNombre());
            txtStockProd.setText(String.valueOf(pd.getStock()));
            txtmPrecioActual.setText(String.valueOf(pd.getPreciounidad()));
        } else {
            JOptionPane.showMessageDialog(null, "No exite");
        }
    }

    public void limpiartextos(){
        txtNroDocumento.setText("");
        txtRuc.setText("");
        txtRazonSocial.setText("");
        txtmDireccion.setText("");
        txtmTelefono.setText("");
        txtmIdprod.setText("");
        txtmNomProducto.setText("");
        txtStockProd.setText("");
        txtmPrecioActual.setText("");
        txtCantidadDP.setText("");
        txtPrecioCompDP.setText("");
        txtPrecioVentaDP.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregarDP = new javax.swing.JButton();
        btnMostrarDP = new javax.swing.JButton();
        btnBuscarProv = new javax.swing.JButton();
        btnBuscarProd = new javax.swing.JButton();
        btnCancelarDP = new javax.swing.JButton();
        btnSalirDP = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        txtmDireccion = new javax.swing.JTextField();
        txtmTelefono = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtmIdprod = new javax.swing.JTextField();
        txtmNomProducto = new javax.swing.JTextField();
        txtStockProd = new javax.swing.JTextField();
        txtmPrecioActual = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCantidadDP = new javax.swing.JFormattedTextField();
        txtPrecioCompDP = new javax.swing.JFormattedTextField();
        txtPrecioVentaDP = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNroDocumento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jToolBar1.setBackground(new java.awt.Color(247, 254, 255));
        jToolBar1.setRollover(true);

        btnAgregarDP.setText("Agregar");
        btnAgregarDP.setFocusable(false);
        btnAgregarDP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarDP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDPActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregarDP);

        btnMostrarDP.setText("Mostrar");
        btnMostrarDP.setFocusable(false);
        btnMostrarDP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMostrarDP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMostrarDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDPActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMostrarDP);

        btnBuscarProv.setText("BUSCAR PROVEEDR");
        btnBuscarProv.setFocusable(false);
        btnBuscarProv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarProv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProvActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscarProv);

        btnBuscarProd.setText("BUSCAR EL PRODUCTO");
        btnBuscarProd.setFocusable(false);
        btnBuscarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscarProd);

        btnCancelarDP.setText("CANCELAR");
        btnCancelarDP.setFocusable(false);
        btnCancelarDP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarDP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDPActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelarDP);

        btnSalirDP.setText("SALIR");
        btnSalirDP.setFocusable(false);
        btnSalirDP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalirDP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalirDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirDPActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalirDP);

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));

        jPanel3.setBackground(new java.awt.Color(247, 254, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROVEEDOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 12));

        jLabel1.setText("RUC :");

        jLabel8.setText("RAZON SOCIAL :");

        jLabel9.setText("DIRECCION :");

        jLabel10.setText("TEL :");

        txtRuc.setEditable(false);

        txtRazonSocial.setEditable(false);

        txtmDireccion.setEditable(false);

        txtmTelefono.setEditable(false);
        txtmTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmTelefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtmDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                            .addComponent(txtRazonSocial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtmDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(247, 254, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRODUCTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel2.setText("ID :");

        jLabel3.setText("NOMBRE :");

        jLabel4.setText("STOCK :");

        jLabel18.setText("PRECIO ACTUAL :");

        txtmIdprod.setEditable(false);

        txtmNomProducto.setEditable(false);

        txtStockProd.setEditable(false);

        txtmPrecioActual.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStockProd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmIdprod, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtmPrecioActual, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtmNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmIdprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStockProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel18)
                    .addComponent(txtmPrecioActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(247, 254, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel5.setText("PRECIO DE VENTA");

        jLabel6.setText("PRECIO DE COMPRA");

        jLabel7.setText("CANTIDAD");

        txtCantidadDP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPrecioCompDP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPrecioVentaDP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7))
                    .addComponent(txtCantidadDP, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPrecioCompDP)
                    .addComponent(jLabel6))
                .addGap(66, 66, 66)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrecioVentaDP)
                    .addComponent(jLabel5))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioVentaDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioCompDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidadDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("Nro Documento:");

        txtNroDocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(405, 405, 405))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
            .addComponent(jPanel2, 0, 602, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProvActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(
                this, "Busqueda por Codigo?",
                "Mensaje..!!",
                JOptionPane.YES_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            String ruc = JOptionPane.showInputDialog("Buscar!!","Ingrese el Ruc ?");
            buscarProveedorRuc(ruc);
        }
    }//GEN-LAST:event_btnBuscarProvActionPerformed

    private void btnBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdActionPerformed
        // TODO add your handling code here:
            String idprod = JOptionPane.showInputDialog("Buscar!!","Ingrese el ID ?");
            buscarProveedorRuc(idprod);
    }//GEN-LAST:event_btnBuscarProdActionPerformed

    private void btnAgregarDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDPActionPerformed
        // TODO add your handling code here:
        if(txtNroDocumento.getText().compareTo("")!=0 && txtRuc.getText().compareTo("")!=0 && txtmIdprod.getText().compareTo("")!=0 &&
           txtCantidadDP.getText().compareTo("")!=0 && txtPrecioCompDP.getText().compareTo("")!=0 && txtPrecioVentaDP.getText().compareTo("")!=0){
            Producto pd = null;
        Proveedor prv= null;
        DetalleProveedor dp=null;
        try {
            pd = BDProducto.buscarProducto(Integer.parseInt(txtmIdprod.getText()));
            prv=BDProveedor.buscarProveedor(txtRuc.getText());
            dp.setProducto(pd);
            dp.setProveedor(prv);
            dp.setCantidad(Integer.parseInt(txtCantidadDP.getText()));
            dp.setPreciocompra(Float.parseFloat(txtPrecioCompDP.getText()));
            dp.setPrecioventa(Float.parseFloat(txtPrecioVentaDP.getText()));
            dp.setNroFactura(txtNroDocumento.getText());
            BDDetalleProveedor.insertarDetalleProveedor(dp);
            pd.setStock(pd.getStock()+dp.getCantidad());
            pd.setPreciounidad(dp.getPreciocompra());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
            JOptionPane.showMessageDialog(null, "[ Datos Agregados ]");
        }else{
            JOptionPane.showMessageDialog(null, "[ Complete los Campos Vacios ]");
        }
    }//GEN-LAST:event_btnAgregarDPActionPerformed

    private void txtmTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmTelefonoActionPerformed

    private void btnCancelarDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDPActionPerformed
        // TODO add your handling code here:
         limpiartextos();
    }//GEN-LAST:event_btnCancelarDPActionPerformed

    private void btnSalirDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirDPActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirDPActionPerformed

    private void btnMostrarDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDPActionPerformed
        // TODO add your handling code here:
        JDListaDetProv JLDP = new JDListaDetProv(this,true);
        JLDP.setVisible(true);
    }//GEN-LAST:event_btnMostrarDPActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDetalleProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDP;
    private javax.swing.JButton btnBuscarProd;
    private javax.swing.JButton btnBuscarProv;
    private javax.swing.JButton btnCancelarDP;
    private javax.swing.JButton btnMostrarDP;
    private javax.swing.JButton btnSalirDP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JFormattedTextField txtCantidadDP;
    private javax.swing.JTextField txtNroDocumento;
    private javax.swing.JFormattedTextField txtPrecioCompDP;
    private javax.swing.JFormattedTextField txtPrecioVentaDP;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtStockProd;
    private javax.swing.JTextField txtmDireccion;
    private javax.swing.JTextField txtmIdprod;
    private javax.swing.JTextField txtmNomProducto;
    private javax.swing.JTextField txtmPrecioActual;
    private javax.swing.JTextField txtmTelefono;
    // End of variables declaration//GEN-END:variables

}
