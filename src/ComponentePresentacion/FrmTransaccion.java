/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmTransaccion.java
 *
 * Created on 25/08/2010, 12:06:49 AM
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
public class FrmTransaccion extends javax.swing.JFrame {
    /*
     * Parametros Para los JTABLES
     */

    DefaultTableModel LTransacciones = new DefaultTableModel();
    /*
     * Parametro para mostrar la imagen del Producto
     */
    metodos m = new metodos() {
    };
    Double Importe = 0.0;
    Double SubTotal = 0.0;
    Double TotalIGV = 0.0;

    /** Creates new form FrmTransaccion */
    public FrmTransaccion() {
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
        LTransacciones.setColumnIdentifiers(campos);
        //
        try {
            Connection con = BD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(idcompra) from COMPRA ");
            while (rs.next()) {
                txtNroCompT.setText(String.valueOf(rs.getString(1)));
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
        t.setCantidad(Integer.parseInt(txtCantidadT.getText()));
        try {
            Producto p = BDProducto.buscarProducto(Integer.parseInt(txtIdProdT.getText()));
            Compra comp = BDCompra.buscarCompra(Integer.parseInt(txtNroCompT.getText()));
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
        txtIdProdT.setText("");
        txtNombrePT.setText("");
        txtPrecioUndT.setText("");
        txtStockT.setText("");
        txtUnidadMedT.setText("");
        txtCantidadT.setText("");
        jpImageProd.removeAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTransacProd = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSubTotalT = new javax.swing.JFormattedTextField();
        txtIGVT = new javax.swing.JFormattedTextField();
        txtTotalApagar = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txtImporteT = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        txtVuelto = new javax.swing.JFormattedTextField();
        lblNombreTipoComp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNroCompT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDatoClienteT = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        txtTelefonoT = new javax.swing.JTextField();
        lblRucT = new javax.swing.JLabel();
        txtRucF = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jpImageProd = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtIdProdT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioUndT = new javax.swing.JTextField();
        txtCantidadT = new javax.swing.JTextField();
        txtStockT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtUnidadMedT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNombrePT = new javax.swing.JTextArea();
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

        jPanel4.setBackground(new java.awt.Color(247, 254, 255));

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtTransacProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtTransacProd.setFont(new java.awt.Font("Tahoma", 0, 12));
        jtTransacProd.setModel(LTransacciones);
        jScrollPane2.setViewportView(jtTransacProd);

        jPanel7.setBackground(new java.awt.Color(247, 254, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel6.setText("SUB. TOT:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel11.setText("I.G.V:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel12.setText("TOT. A PAGAR:");

        txtSubTotalT.setEditable(false);

        txtIGVT.setEditable(false);
        txtIGVT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIGVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIGVTActionPerformed(evt);
            }
        });

        txtTotalApagar.setEditable(false);
        txtTotalApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalApagarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel13.setText("IMPORTE:");

        txtImporteT.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel14.setText("VUELTO:");

        txtVuelto.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIGVT)
                            .addComponent(txtSubTotalT, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTotalApagar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtImporteT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(txtVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubTotalT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIGVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTotalApagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImporteT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(16, 16, 16))
        );

        lblNombreTipoComp.setFont(new java.awt.Font("Tahoma", 0, 24));
        lblNombreTipoComp.setText("FACTURA DE VENTA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Nro :");

        txtNroCompT.setEditable(false);
        txtNroCompT.setFont(new java.awt.Font("Tahoma", 0, 13));
        txtNroCompT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setText("FECHA:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        jLabel10.setText("CLIENTE :");

        jLabel15.setText("DIRECC.");

        jLabel16.setText("TEL:");

        txtDatoClienteT.setEditable(false);

        jTextField3.setEditable(false);

        txtTelefonoT.setEditable(false);

        lblRucT.setText("RUC:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNroCompT, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField3)
                                        .addComponent(txtDatoClienteT, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblRucT)
                                .addComponent(jLabel16))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTelefonoT)
                                .addComponent(txtRucF, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(lblNombreTipoComp)
                .addGap(140, 140, 140))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroCompT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreTipoComp)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDatoClienteT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRucT)
                            .addComponent(txtRucF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefonoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel3.setBackground(new java.awt.Color(247, 254, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpImageProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jpImageProdLayout = new javax.swing.GroupLayout(jpImageProd);
        jpImageProd.setLayout(jpImageProdLayout);
        jpImageProdLayout.setHorizontalGroup(
            jpImageProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        jpImageProdLayout.setVerticalGroup(
            jpImageProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel7.setText("Id Producto:");

        txtIdProdT.setEditable(false);
        txtIdProdT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdProdT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProdTActionPerformed(evt);
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

        txtPrecioUndT.setEditable(false);
        txtPrecioUndT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCantidadT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtStockT.setEditable(false);
        txtStockT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Unidad Med :");

        txtUnidadMedT.setEditable(false);
        txtUnidadMedT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtNombrePT.setColumns(20);
        txtNombrePT.setEditable(false);
        txtNombrePT.setRows(5);
        jScrollPane1.setViewportView(txtNombrePT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtIdProdT, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jpImageProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(10, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel1)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidadT)
                            .addComponent(txtStockT)
                            .addComponent(txtUnidadMedT)
                            .addComponent(txtPrecioUndT, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdProdT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpImageProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioUndT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStockT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUnidadMedT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidadT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jToolBar1.setBackground(new java.awt.Color(247, 254, 255));
        jToolBar1.setRollover(true);

        btnAgregar.setBackground(new java.awt.Color(247, 254, 255));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1283147462_plus_48.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregar);

        btnEliminar.setBackground(new java.awt.Color(247, 254, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1283147878_dbmin2.png"))); // NOI18N
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
        btnImporte.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
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

        jButton2.setBackground(new java.awt.Color(247, 254, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1283127166_document-print-preview.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        btnAtrasT.setBackground(new java.awt.Color(247, 254, 255));
        btnAtrasT.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAtrasT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/1283127227_print_printer.png"))); // NOI18N
        btnAtrasT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasTActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAtrasT);
        jToolBar1.add(jSeparator5);

        btnCancelar.setBackground(new java.awt.Color(247, 254, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < jtTransacProd.getRowCount(); i++) {
            float total = Float.parseFloat(String.valueOf(jtTransacProd.getModel().getValueAt(i, 3)));
            SubTotal += total;
            TotalIGV += (total * 0.19);
        }
        txtSubTotalT.setText(String.valueOf(Math.round(SubTotal)));
        txtIGVT.setText(String.valueOf(TotalIGV));
        Double totalapagar = SubTotal + TotalIGV;
        txtTotalApagar.setText(String.valueOf(totalapagar));
        txtVuelto.setText(String.valueOf(Math.round(Importe - totalapagar)));
}//GEN-LAST:event_btnCalcularActionPerformed

    private void btnImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImporteActionPerformed
        // TODO add your handling code here:
        Importe = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Importe S/0.0", "Mensaje..!!"));
        txtImporteT.setText(String.valueOf(Importe));
    }//GEN-LAST:event_btnImporteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarTextos();
        while(LTransacciones.getRowCount()>0)LTransacciones.removeRow(0);
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        int DestStock = 0;
        if (Integer.parseInt(txtStockT.getText()) > Integer.parseInt(txtCantidadT.getText())) {
            AgregarTransaccion(); //Metodo para agregar transacciones realizadas
        /*
             * Por cada producto que agregue se mostrar en JTable
             */
            String Datos[] = {txtCantidadT.getText(), txtNombrePT.getText(), txtPrecioUndT.getText(),
                String.valueOf(Math.round(Integer.parseInt(txtCantidadT.getText()) * Double.parseDouble(txtPrecioUndT.getText())))};
            LTransacciones.addRow(Datos);
            DestStock = Integer.parseInt(txtStockT.getText()) - Integer.parseInt(txtCantidadT.getText());
            try {
                Producto p = BDProducto.buscarProducto(Integer.parseInt(txtIdProdT.getText()));
                p.setStock(DestStock);
                BDProducto.actualizarProducto(p);
            } catch (SQLException ex) {
                Logger.getLogger(FrmTransaccion.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtStockT.setText(String.valueOf(Integer.parseInt(txtStockT.getText()) - Integer.parseInt(txtCantidadT.getText())));
        } else if (Integer.parseInt(txtStockT.getText()) == Integer.parseInt(txtCantidadT.getText())) {
            AgregarTransaccion(); //Metodo para agregar transacciones realizadas
        /*
             * Por cada producto que agregue se mostrar en JTable
             */
            String Datos[] = {txtCantidadT.getText(), txtNombrePT.getText(), txtPrecioUndT.getText(),
                String.valueOf(Math.round(Integer.parseInt(txtCantidadT.getText()) * Double.parseDouble(txtPrecioUndT.getText())))};
            LTransacciones.addRow(Datos);
            DestStock = Integer.parseInt(txtStockT.getText()) - Integer.parseInt(txtCantidadT.getText());
            try {
                Producto p = BDProducto.buscarProducto(Integer.parseInt(txtIdProdT.getText()));
                p.setStock(DestStock);
                BDProducto.actualizarProducto(p);
            } catch (SQLException ex) {
                Logger.getLogger(FrmTransaccion.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtStockT.setText(String.valueOf(Integer.parseInt(txtStockT.getText()) - Integer.parseInt(txtCantidadT.getText())));
        } else {
            JOptionPane.showMessageDialog(null, "[ Cantidad < ó = Stock ]");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int elim_fila = jtTransacProd.getSelectedRow();
        int idcom = Integer.parseInt(txtNroCompT.getText());
        int cant = Integer.parseInt(String.valueOf(jtTransacProd.getModel().getValueAt(elim_fila, 0)));
        try {
            Producto p = BDProducto.buscarProductoNombre(String.valueOf(jtTransacProd.getModel().getValueAt(elim_fila, 1)));
            int idp = p.getIdProducto();
            BDTransaccion.eliminarTransaccion(idcom, idp);
            p.setStock(p.getStock() + cant);
            BDProducto.actualizarProducto(p);
            txtStockT.setText(String.valueOf(p.getStock() + cant));
        } catch (SQLException ex) {
            Logger.getLogger(FrmTransaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        LTransacciones.removeRow(elim_fila);
}//GEN-LAST:event_btnEliminarActionPerformed

    private void txtIdProdTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProdTActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtIdProdTActionPerformed

    private void btnAtrasTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasTActionPerformed
    }//GEN-LAST:event_btnAtrasTActionPerformed

    private void txtIGVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIGVTActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtIGVTActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        // TODO add your handling code here:
        FrmBuscarProducto frmBP = new FrmBuscarProducto(this) {
        };
        frmBP.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void txtTotalApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalApagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalApagarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmTransaccion().setVisible(true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JPanel jpImageProd;
    private javax.swing.JTable jtTransacProd;
    public javax.swing.JLabel lblNombreTipoComp;
    public javax.swing.JLabel lblRucT;
    public javax.swing.JTextField txtCantidadT;
    public javax.swing.JTextField txtDatoClienteT;
    public javax.swing.JFormattedTextField txtIGVT;
    public javax.swing.JTextField txtIdProdT;
    private javax.swing.JFormattedTextField txtImporteT;
    public javax.swing.JTextArea txtNombrePT;
    private javax.swing.JTextField txtNroCompT;
    public javax.swing.JTextField txtPrecioUndT;
    public javax.swing.JTextField txtRucF;
    public javax.swing.JTextField txtStockT;
    public javax.swing.JFormattedTextField txtSubTotalT;
    public javax.swing.JTextField txtTelefonoT;
    private javax.swing.JFormattedTextField txtTotalApagar;
    public javax.swing.JTextField txtUnidadMedT;
    private javax.swing.JFormattedTextField txtVuelto;
    // End of variables declaration//GEN-END:variables
}
