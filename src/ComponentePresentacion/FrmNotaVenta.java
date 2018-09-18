/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmNotaVenta.java
 *
 * Created on 27/08/2010, 06:52:19 PM
 */
package ComponentePresentacion;

import ComponenteClase.*;
import ComponenteDatos.*;
import ComponenteOtros.*;
import java.net.*;
import java.sql.*;
import java.util.logging.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

/**
 *
 * @author Richard
 */
public class FrmNotaVenta extends javax.swing.JFrame {
    /*
     * Parametros Para los JTABLES
     */

    DefaultTableModel LTransaccionesNV = new DefaultTableModel();
    /*
     * Parametro para mostrar la imagen del Producto
     */
    metodos m = new metodos() {
    };
    Double Importe = 0.0;
    Double SubTotal = 0.0;

    /** Creates new form FrmNotaVenta */
    public FrmNotaVenta() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        /*
         * Sentencia que permitira Mostrar los elmentos en un JTABLE
         */
        String campos[] = {"CANTIDAD", "PRODUCTO", "PRECIO UND.", "TOTAL"};
        LTransaccionesNV.setColumnIdentifiers(campos);
        //
        try {
        Connection con = BD.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select max(idcompra) from COMPRA ");
        while (rs.next()) {
        txtNroCompNV.setText(String.valueOf(rs.getString(1)));
        }
        rs.close();
        stmt.close();
        con.close();
        } catch (SQLException error) {
        System.out.print(error);
        }


    }
    /*
     * Metodo que me permitira mostrar la imagen en un panel
     */

    public void Mostrar(JPanel p) {
        try {
            //se asigna a "url" el archivo de imagen seleccionado
            URL url = m.getObtener();
            //se lo coloca en memoria
            m.cargar_imagen(url);
            //se aÃ±ade al contenedor
            p.add(new mipanel(m.Obtener_imagen_de_Buffer(), p.getSize()) {
            });
            p.setVisible(true);
            p.repaint();
        } catch (Exception ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
     * Agregar los elemntos a la tabla transaccion
     */

    public void AgregarTransaccion() {
        Transaccion t = new Transaccion() {
        };
        t.setCantidad(Integer.parseInt(txtCantidadNV.getText()));
        try {
            Producto p = BDProducto.buscarProducto(Integer.parseInt(txtIdProdNV.getText()));
            Compra comp = BDCompra.buscarCompra(Integer.parseInt(txtNroCompNV.getText()));
            t.setProducto(p);
            t.setCompra(comp);
            BDTransaccion.insertarTransaccion(t);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
        }
    }
    /*
     * Metodo para limpiar las cajas de Texto
     */

    public void limpiarTextos() {
        txtIdProdNV.setText("");
        txtPrecioUndNV.setText("");
        txtStockNV.setText("");
        txtUnidadMedNV.setText("");
        txtCantidadNV.setText("");
        jpImageProdNV.removeAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTransacProdNV = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtTotalApagarNV = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        txtImporteNV = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        txtVueltoNV = new javax.swing.JFormattedTextField();
        lblNombreTipoComp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNroCompNV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtDatoClienteNV = new javax.swing.JTextField();
        txtDireccionNV = new javax.swing.JTextField();
        txtTelefonoNV = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jpImageProdNV = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtIdProdNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioUndNV = new javax.swing.JTextField();
        txtCantidadNV = new javax.swing.JTextField();
        txtStockNV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtUnidadMedNV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNombrePNV = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnImporte = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnBuscarProducto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        btnAtrasT = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jPanel5.setBackground(new java.awt.Color(247, 254, 255));

        jPanel6.setBackground(new java.awt.Color(247, 254, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtTransacProdNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtTransacProdNV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtTransacProdNV.setModel(LTransaccionesNV);
        jScrollPane3.setViewportView(jtTransacProdNV);

        jPanel8.setBackground(new java.awt.Color(247, 254, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel16.setText("TOT. A PAGAR:");

        txtTotalApagarNV.setEditable(false);
        txtTotalApagarNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalApagarNVActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel17.setText("MONTO ENTREGADO:");

        txtImporteNV.setEditable(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel18.setText("VUELTO:");

        txtVueltoNV.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVueltoNV)
                    .addComponent(txtTotalApagarNV)
                    .addComponent(txtImporteNV, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalApagarNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImporteNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVueltoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(68, 68, 68))
        );

        lblNombreTipoComp.setFont(new java.awt.Font("Tahoma", 0, 24));
        lblNombreTipoComp.setText("NOTA DE VENTA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Nro :");

        txtNroCompNV.setEditable(false);
        txtNroCompNV.setFont(new java.awt.Font("Tahoma", 0, 13));
        txtNroCompNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setText("FECHA:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        jLabel10.setText("CLIENTE :");

        jLabel19.setText("DIRECC.");

        jLabel20.setText("TEL:");

        txtDatoClienteNV.setEditable(false);

        txtDireccionNV.setEditable(false);

        txtTelefonoNV.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNroCompNV, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombreTipoComp)
                                .addGap(145, 145, 145))
                            .addComponent(jLabel10)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDireccionNV)
                                    .addComponent(txtDatoClienteNV, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefonoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroCompNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(lblNombreTipoComp)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDatoClienteNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtDireccionNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefonoNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel9.setBackground(new java.awt.Color(247, 254, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpImageProdNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jpImageProdNVLayout = new javax.swing.GroupLayout(jpImageProdNV);
        jpImageProdNV.setLayout(jpImageProdNVLayout);
        jpImageProdNVLayout.setHorizontalGroup(
            jpImageProdNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        jpImageProdNVLayout.setVerticalGroup(
            jpImageProdNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel21.setText("Id Producto:");

        txtIdProdNV.setEditable(false);
        txtIdProdNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdProdNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProdNVActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Stock :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio Und :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cantidad :");

        txtPrecioUndNV.setEditable(false);
        txtPrecioUndNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCantidadNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtStockNV.setEditable(false);
        txtStockNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Unidad Med :");

        txtUnidadMedNV.setEditable(false);
        txtUnidadMedNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtNombrePNV.setColumns(20);
        txtNombrePNV.setEditable(false);
        txtNombrePNV.setRows(5);
        jScrollPane1.setViewportView(txtNombrePNV);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtIdProdNV, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jpImageProdNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(10, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel1)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidadNV)
                            .addComponent(txtStockNV)
                            .addComponent(txtUnidadMedNV)
                            .addComponent(txtPrecioUndNV, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtIdProdNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpImageProdNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioUndNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStockNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUnidadMedNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidadNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jToolBar1.setBackground(new java.awt.Color(247, 254, 255));
        jToolBar1.setRollover(true);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregar);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);
        jToolBar1.add(jSeparator2);

        btnImporte.setBackground(new java.awt.Color(247, 254, 255));
        btnImporte.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnImporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1283148262_taxes.png"))); // NOI18N
        btnImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImporteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImporte);

        btnCalcular.setBackground(new java.awt.Color(247, 254, 255));
        btnCalcular.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1283149480_kcalc.png"))); // NOI18N
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCalcular);
        jToolBar1.add(jSeparator3);

        btnBuscarProducto.setText("BUSCARPROD");
        btnBuscarProducto.setFocusable(false);
        btnBuscarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscarProducto);

        jButton1.setText("buscarprodID");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator4);

        jButton2.setText("VISTA PREVIA");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        btnAtrasT.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAtrasT.setText("IMPRIMIR");
        btnAtrasT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasTActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAtrasT);
        jToolBar1.add(jSeparator5);

        btnCancelar.setBackground(new java.awt.Color(247, 254, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1283150452_Cancel__Red.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelar);

        btnSalir.setBackground(new java.awt.Color(247, 254, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1283149900_Log Out.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txtTotalApagarNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalApagarNVActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtTotalApagarNVActionPerformed

    private void txtIdProdNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProdNVActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtIdProdNVActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        int DestStock = 0;
        if (Integer.parseInt(txtStockNV.getText()) > Integer.parseInt(txtCantidadNV.getText())) {
            AgregarTransaccion(); //Metodo para agregar transacciones realizadas
        /*
             * Por cada producto que agregue se mostrar en JTable
             */
            String Datos[] = {txtCantidadNV.getText(), txtNombrePNV.getText(), txtPrecioUndNV.getText(),
                String.valueOf(Math.round(Integer.parseInt(txtCantidadNV.getText()) * Double.parseDouble(txtPrecioUndNV.getText())))};
            LTransaccionesNV.addRow(Datos);
            DestStock = Integer.parseInt(txtStockNV.getText()) - Integer.parseInt(txtCantidadNV.getText());
            try {
                Producto p = BDProducto.buscarProducto(Integer.parseInt(txtIdProdNV.getText()));
                p.setStock(DestStock);
                BDProducto.actualizarProducto(p);
            } catch (SQLException ex) {
                Logger.getLogger(FrmTransaccion.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtStockNV.setText(String.valueOf(Integer.parseInt(txtStockNV.getText()) - Integer.parseInt(txtCantidadNV.getText())));
        } else if (Integer.parseInt(txtStockNV.getText()) == Integer.parseInt(txtCantidadNV.getText())) {
            AgregarTransaccion(); //Metodo para agregar transacciones realizadas
        /*
             * Por cada producto que agregue se mostrar en JTable
             */
            String Datos[] = {txtCantidadNV.getText(), txtNombrePNV.getText(), txtPrecioUndNV.getText(),
                String.valueOf(Math.round(Integer.parseInt(txtCantidadNV.getText()) * Double.parseDouble(txtPrecioUndNV.getText())))};
            LTransaccionesNV.addRow(Datos);
            DestStock = Integer.parseInt(txtStockNV.getText()) - Integer.parseInt(txtCantidadNV.getText());
            try {
                Producto p = BDProducto.buscarProducto(Integer.parseInt(txtIdProdNV.getText()));
                p.setStock(DestStock);
                BDProducto.actualizarProducto(p);
            } catch (SQLException ex) {
                Logger.getLogger(FrmTransaccion.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtStockNV.setText(String.valueOf(Integer.parseInt(txtStockNV.getText()) - Integer.parseInt(txtCantidadNV.getText())));
        } else {
            JOptionPane.showMessageDialog(null, "[ Cantidad < ó = Stock ]");
        }
}//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int elim_fila = jtTransacProdNV.getSelectedRow();
        int idcom = Integer.parseInt(txtNroCompNV.getText());
        int cant = Integer.parseInt(String.valueOf(jtTransacProdNV.getModel().getValueAt(elim_fila, 0)));
        try {
            Producto p = BDProducto.buscarProductoNombre(String.valueOf(jtTransacProdNV.getModel().getValueAt(elim_fila, 1)));
            int idp = p.getIdProducto();
            BDTransaccion.eliminarTransaccion(idcom, idp);
            txtStockNV.setText(String.valueOf(p.getStock() + cant));
            p.setStock(p.getStock() + cant);
            BDProducto.actualizarProducto(p);
        } catch (SQLException ex) {
            Logger.getLogger(FrmTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        LTransaccionesNV.removeRow(elim_fila);
}//GEN-LAST:event_btnEliminarActionPerformed

    private void btnImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImporteActionPerformed
        // TODO add your handling code here:
        Importe = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Importe S/0.0", "Mensaje..!!"));
        txtImporteNV.setText(String.valueOf(Importe));
}//GEN-LAST:event_btnImporteActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < jtTransacProdNV.getRowCount(); i++) {
            float total = Float.parseFloat(String.valueOf(jtTransacProdNV.getModel().getValueAt(i, 3)));
            SubTotal += total;
        }
        txtTotalApagarNV.setText(String.valueOf(SubTotal));
        txtVueltoNV.setText(String.valueOf(Importe - SubTotal));
}//GEN-LAST:event_btnCalcularActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        // TODO add your handling code here:
        FrmBuscarProductoVN frmBP = new FrmBuscarProductoVN(this){};
        frmBP.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnAtrasTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasTActionPerformed
}//GEN-LAST:event_btnAtrasTActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarTextos();
        //LimpiarJtable
        while(LTransaccionesNV.getRowCount()>0)LTransaccionesNV.removeRow(0);
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmNotaVenta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtrasT;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JPanel jpImageProdNV;
    private javax.swing.JTable jtTransacProdNV;
    public javax.swing.JLabel lblNombreTipoComp;
    public javax.swing.JTextField txtCantidadNV;
    public javax.swing.JTextField txtDatoClienteNV;
    private javax.swing.JTextField txtDireccionNV;
    public javax.swing.JTextField txtIdProdNV;
    private javax.swing.JFormattedTextField txtImporteNV;
    public javax.swing.JTextArea txtNombrePNV;
    private javax.swing.JTextField txtNroCompNV;
    public javax.swing.JTextField txtPrecioUndNV;
    public javax.swing.JTextField txtStockNV;
    public javax.swing.JTextField txtTelefonoNV;
    private javax.swing.JFormattedTextField txtTotalApagarNV;
    public javax.swing.JTextField txtUnidadMedNV;
    private javax.swing.JFormattedTextField txtVueltoNV;
    // End of variables declaration//GEN-END:variables

}
