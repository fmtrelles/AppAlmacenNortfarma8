package AlmacenPresentacion;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import AlmacenClases.ProductoAlmacen;
import AlmacenDatos.*;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FrmProductosAlmacen extends javax.swing.JFrame {

    DefaultTableModel modelo;
    TableRowSorter<TableModel> sorter;
    int fila;

    public FrmProductosAlmacen() {
        initComponents();
        //this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(0);
//        try {
//            UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Error en en Look and Feel", "Error", ERROR);
//        }
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        CagarProductosAlmacen();
    }

    @SuppressWarnings("unchecked")
    private void CagarProductosAlmacen() {
        //Boticas cDescargo;
        modelo = new DefaultTableModel(null, getColumnasContar());
        jListadoProductos.setModel(modelo);
        try {
            List<ProductoAlmacen> ListaProductos = DBProductosAlmacen.mostrarProductos();
            modelo.setNumRows(ListaProductos.size());
            for (int i = 0; i < ListaProductos.size(); i++) { // Recorriendo Los Datos que se Encuentran en el Arraylist
                ProductoAlmacen Prod = ListaProductos.get(i);
                modelo.setValueAt(Prod.getCodpro(), i, 0);
                modelo.setValueAt(Prod.getDespro(), i, 1);
                modelo.setValueAt(Prod.getCodlab(), i, 2);
                modelo.setValueAt(Prod.getStkalm(), i, 3);
                modelo.setValueAt(Prod.getStkalm_m(), i, 4);
                modelo.setValueAt(Prod.getStkmos(), i, 5);
                modelo.setValueAt(Prod.getStkmos_m(), i, 6);
                modelo.setValueAt(Prod.getStktod(), i, 7);
                modelo.setValueAt(Prod.getStktod_m(), i, 8);
                modelo.setValueAt(Prod.getCodbar(), i, 9);
                modelo.setValueAt(Prod.getTempminima(), i, 10);
                modelo.setValueAt(Prod.getTempmaxima(), i, 11);

                //System.out.println(String.valueOf(i)+"--"+guiasx.getTypmov()+"--"+guiasx.getDocnum());
            }
            this.jListadoProductos.setModel(modelo);

            jListadoProductos.getColumnModel().getColumn(0).setPreferredWidth(25);
            jListadoProductos.getColumnModel().getColumn(1).setPreferredWidth(200);
            jListadoProductos.getColumnModel().getColumn(2).setPreferredWidth(25);
            jListadoProductos.getColumnModel().getColumn(3).setPreferredWidth(30);
            jListadoProductos.getColumnModel().getColumn(4).setPreferredWidth(30);
            jListadoProductos.getColumnModel().getColumn(5).setPreferredWidth(30);
            jListadoProductos.getColumnModel().getColumn(6).setPreferredWidth(30);
            jListadoProductos.getColumnModel().getColumn(7).setPreferredWidth(30);
            jListadoProductos.getColumnModel().getColumn(8).setPreferredWidth(30);
            jListadoProductos.getColumnModel().getColumn(9).setPreferredWidth(100);
            jListadoProductos.getColumnModel().getColumn(10).setPreferredWidth(30);
            jListadoProductos.getColumnModel().getColumn(11).setPreferredWidth(30);
            jListadoProductos.setModel(modelo);
            sorter = new TableRowSorter<TableModel>(modelo);
            jListadoProductos.setRowSorter(sorter);
            jListadoProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        } catch (SQLException ex) {
            Logger.getLogger(FrmRevisionGuias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] getColumnasContar() {
        String columna[] = new String[]{"Codigo", "Descripcion", "Labor.", "Stk.Alm(caj)", "Stk.Alm(uni)", "Stk.Mos(caj)", "Stk.Mos(uni)", "Stk.Tot(caj)", "Stk.Tot(uni)", "Codigo Barras", "Temp.Max", "Temp.Min"};
        return columna;
    }

    private void filtrar() {
        RowFilter<TableModel, Object> rf = null;
        int indiceColumnaTabla = 2;
        switch (cboBuscar.getSelectedIndex()) {
            case 0:
                indiceColumnaTabla = 1;
                break;//por nombre
            case 1:
                indiceColumnaTabla = 0;
                break;//por numero celular
            case 2:
                indiceColumnaTabla = 2;
                break;//por numero celular
        }
        try {
            rf = RowFilter.regexFilter(txtBusqueda.getText().toUpperCase(), indiceColumnaTabla);
        } catch (java.util.regex.PatternSyntaxException e) {
        }
        sorter.setRowFilter(rf);
    }

    public void DatosTable_a_Textos(java.awt.Point evt) {
        fila = jListadoProductos.rowAtPoint(evt);
        //fila = jListadoProductos.getSelectedRow();
        //JOptionPane.showMessageDialog(null, "Fila : " + String.valueOf(fila));
        if (fila > -1) {
            txtcodpro.setText(String.valueOf(jListadoProductos.getValueAt(fila, 0)));
            txtdespro.setText(String.valueOf(jListadoProductos.getValueAt(fila, 1)));
            txtcodlab.setText(String.valueOf(jListadoProductos.getValueAt(fila, 2)));
            txtstkalm.setText(String.valueOf(jListadoProductos.getValueAt(fila, 3)));
            txtstkalm_m.setText(String.valueOf(jListadoProductos.getValueAt(fila, 4)));
            txtstkmos.setText(String.valueOf(jListadoProductos.getValueAt(fila, 5)));
            txtstkmos_m.setText(String.valueOf(jListadoProductos.getValueAt(fila, 6)));
            txtstktod.setText(String.valueOf(jListadoProductos.getValueAt(fila, 7)));
            txtstktod_m.setText(String.valueOf(jListadoProductos.getValueAt(fila, 8)));
            txtcodbar.setText(String.valueOf(jListadoProductos.getValueAt(fila, 9)));
            txttempmin.setText(String.valueOf(jListadoProductos.getValueAt(fila, 10)));
            txttempmax.setText(String.valueOf(jListadoProductos.getValueAt(fila, 11)));
        }
    }

    public void ActualizarTable(int filaAct) {
        //fila = jListadoProductos.rowAtPoint(filaAct);
        //JOptionPane.showMessageDialog(null, "Fila : " + String.valueOf(filaAct));
        if (filaAct > -1) {
            //jListadoProductos.get
            int filita = sorter.convertRowIndexToModel(filaAct);
            modelo.setValueAt(txtcodbar.getText(), filita, 9);
            modelo.setValueAt(txttempmin.getText(), filita, 10);
            modelo.setValueAt(txttempmax.getText(), filita, 11);
            jListadoProductos.setModel(modelo);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListadoProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cboBuscar = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtcodpro = new javax.swing.JTextField();
        txtdespro = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtstkalm = new javax.swing.JTextField();
        txtstkalm_m = new javax.swing.JTextField();
        txtstkmos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtstkmos_m = new javax.swing.JTextField();
        txtstktod = new javax.swing.JTextField();
        txtstktod_m = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcodlab = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtcodbar = new javax.swing.JTextField();
        txttempmin = new javax.swing.JTextField();
        txttempmax = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMasterPack = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        jListadoProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Labora.", "Stk.Alm(caj)", "Stk.Alm(uni)", "Stk.Mos(caj)", "Stk.Mos(uni)", "Stk.Tot(caj)", "Stk.Tot(uni)", "Codigo Barras", "Temp.Min", "Temp.Max"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jListadoProductos.setShowHorizontalLines(false);
        jListadoProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListadoProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListadoProductos);

        jLabel1.setText("Campo Buscar");

        cboBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Descripcion", "Codigo", "Laboratorio" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Codigo");

        txtcodpro.setEditable(false);
        txtcodpro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtcodpro.setForeground(new java.awt.Color(0, 0, 204));

        txtdespro.setEditable(false);
        txtdespro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtdespro.setForeground(new java.awt.Color(0, 0, 204));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Stock Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(204, 51, 0))); // NOI18N

        txtstkalm.setEditable(false);
        txtstkalm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtstkalm.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtstkalm_m.setEditable(false);
        txtstkalm_m.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtstkalm_m.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtstkmos.setEditable(false);
        txtstkmos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtstkmos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("Stock Almacen (cajas)");

        jLabel5.setText("Stock Almacen (unidades)");

        jLabel6.setText("Stock Mostrador (Cajas)");

        jLabel7.setText("Stock Mostrador (Unidades)");

        txtstkmos_m.setEditable(false);
        txtstkmos_m.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtstkmos_m.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtstktod.setEditable(false);
        txtstktod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtstktod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtstktod_m.setEditable(false);
        txtstktod_m.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtstktod_m.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setText("Stock Totak (Cajas)");

        jLabel9.setText("Stock Total (Unidades)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtstkalm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtstkalm_m, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(txtstkmos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtstkmos_m, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtstktod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtstktod_m)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstkalm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstkalm_m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstkmos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstkmos_m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstktod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstktod_m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        txtcodlab.setEditable(false);
        txtcodlab.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtcodlab.setForeground(new java.awt.Color(0, 0, 204));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(204, 51, 0))); // NOI18N

        txtcodbar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txttempmin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttempmin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttempmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttempminActionPerformed(evt);
            }
        });
        txttempmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttempminKeyTyped(evt);
            }
        });

        txttempmax.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttempmax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttempmax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttempmaxActionPerformed(evt);
            }
        });
        txttempmax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttempmaxFocusLost(evt);
            }
        });
        txttempmax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttempmaxKeyTyped(evt);
            }
        });

        jLabel10.setText("Codigo de Barras");

        jLabel11.setText("Temperatura Minima");

        jLabel12.setText("Temperatura Maxima");

        txtMasterPack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel13.setText("Master Pack");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcodbar, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txttempmin, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttempmax, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtMasterPack, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttempmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttempmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMasterPack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnGuardar.setText("Guadar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcodpro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdespro, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcodlab, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcodpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdespro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodlab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtBusqueda.getDocument().addDocumentListener(
            new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    filtrar();
                }
                public void insertUpdate(DocumentEvent e) {
                    filtrar();
                }
                public void removeUpdate(DocumentEvent e) {
                    filtrar();
                }
            });

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jListadoProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListadoProductosMouseClicked
        DatosTable_a_Textos(evt.getPoint());

    }//GEN-LAST:event_jListadoProductosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CagarProductosAlmacen();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        int resul = ValidarTemperaturas(Double.parseDouble(txttempmin.getText()), Double.parseDouble(txttempmax.getText()));
        if (resul == 1) {
            JOptionPane.showMessageDialog(null, "La temperatura minima debe ser menor a la temperatura maxima");
        } else {
            ProductoAlmacen Datos = new ProductoAlmacen();

            Datos.setCodpro(txtcodpro.getText().toString());
            Datos.setCodbar(txtcodbar.getText().toString());
            Datos.setTempminima(Double.parseDouble(txttempmin.getText()));
            Datos.setTempmaxima(Double.parseDouble(txttempmax.getText()));
            //Datos.setMasterpack(Integer.parseInt(txtMasterPack.getText()));
            try {
                DBProductosAlmacen.actualizarProducto(Datos);
                ActualizarTable(fila);
            } catch (SQLException ex) {
                Logger.getLogger(FrmProductosAlmacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txttempminKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttempminKeyTyped

        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresa Solo Numeros");
        }
    }//GEN-LAST:event_txttempminKeyTyped

    private void txttempmaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttempmaxKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresa Solo Numeros");
        }
    }//GEN-LAST:event_txttempmaxKeyTyped

    private void txttempminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttempminActionPerformed
        /*int resul=ValidarTemperaturas(Double.parseDouble(txttempmin.getText()),Double.parseDouble(txttempmax.getText()));
         if (resul == 1 )
         {
         JOptionPane.showMessageDialog(null, "La temperatura minima debe ser menor a la temperatura maxima");
         }*/
    }//GEN-LAST:event_txttempminActionPerformed

    private void txttempmaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttempmaxActionPerformed
        /*int resul = ValidarTemperaturas(Double.parseDouble(txttempmin.getText()),Double.parseDouble(txttempmax.getText()));
         if (resul==1)
         {
         JOptionPane.showMessageDialog(null, "La temperatura minima debe ser menor a la temperatura maxima");
         }*/
    }//GEN-LAST:event_txttempmaxActionPerformed

    private void txttempmaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttempmaxFocusLost
        int resul = ValidarTemperaturas(Double.parseDouble(txttempmin.getText()), Double.parseDouble(txttempmax.getText()));
        if (resul == 1) {
            JOptionPane.showMessageDialog(null, "La temperatura minima debe ser menor a la temperatura maxima");
        }

    }//GEN-LAST:event_txttempmaxFocusLost

    private int ValidarTemperaturas(double TemInicial, double TemFinal) {
        int resultado = 0;
        if (TemInicial > TemFinal) {
            resultado = 1;
        }
        return resultado;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTable jListadoProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtMasterPack;
    private javax.swing.JTextField txtcodbar;
    private javax.swing.JTextField txtcodlab;
    private javax.swing.JTextField txtcodpro;
    private javax.swing.JTextField txtdespro;
    private javax.swing.JTextField txtstkalm;
    private javax.swing.JTextField txtstkalm_m;
    private javax.swing.JTextField txtstkmos;
    private javax.swing.JTextField txtstkmos_m;
    private javax.swing.JTextField txtstktod;
    private javax.swing.JTextField txtstktod_m;
    private javax.swing.JTextField txttempmax;
    private javax.swing.JTextField txttempmin;
    // End of variables declaration//GEN-END:variables
}
