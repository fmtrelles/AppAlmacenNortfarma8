/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenPresentacion;

import AlmacenClases.Cargos;
import AlmacenClases.Grupos;
import AlmacenClases.Personal;
import AlmacenClases.Personal_Grupo;
import AlmacenDatos.DBCargos;
import AlmacenDatos.DBGrupos;
import AlmacenDatos.DBGrupos_Personal;
import ComponenteClase.Empleado;
import ComponenteDatos.BDEmpleado;
import ComponentePresentacion.FrmPanelFondoPrincipal;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jsarango
 */
public class FrmGrupos_Personal extends javax.swing.JFrame {

    List<Personal> milista;
    List<Grupos> ListaGrupos;
    List<Cargos> ListaCargos;
    List<Personal_Grupo> LitaPersonalGrupo;
    DefaultTableModel modelo;
    Grupos datogrupo;
    Empleado datoEmpleado;
    Cargos datoCargo;
    DateFormat ValorFecha = DateFormat.getDateInstance(DateFormat.MEDIUM);
    Date fecha = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public FrmGrupos_Personal() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        initComponents();
        //txtDNI.setText("02866195");
        //txtGrupo.setText("1");
        FrmPanelFondoPrincipal fondoprinc = new FrmPanelFondoPrincipal();
        this.setSize(500, 300);
        this.add(fondoprinc, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.pack();
        CargarGrupos();
        CargarCargos();
        CargarPersonalGrupos();
        txtFecha.setDate(fecha);
        

        //autocomplete(txtNombreApellidos, milista);
    }

    private void CargarGrupos() {
        try {
            ListaGrupos = DBGrupos.mostrarGrupos();
            for (Iterator<Grupos> it = ListaGrupos.iterator(); it.hasNext();) {
                Grupos grupos = it.next();
                cboGrupos.addItem(grupos.getDescripcion());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmPedirBoticaGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void CargarCargos() {
        try {
            ListaCargos = DBCargos.mostrarCargos();
            for (Iterator<Cargos> it = ListaCargos.iterator(); it.hasNext();) {
                Cargos cargos = it.next();
                cboCargos.addItem(cargos.getDescripcion());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmPedirBoticaGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void CargarPersonalGrupos()
    {
        modelo = new DefaultTableModel();
        jtListaPersonalGrupos.setModel(modelo);
        modelo = new DefaultTableModel(null, getColumnasPersonalGrupos()) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        try {

            LitaPersonalGrupo = DBGrupos_Personal.mostrarGrupos_Personal(0);
            // Guias guiasx = new Guias();
            modelo.setNumRows(LitaPersonalGrupo.size());
            for (int i = 0; i < LitaPersonalGrupo.size(); i++) { // Recorriendo Los Datos que se Encuentran en el Arraylist
                Personal_Grupo pergrupo = LitaPersonalGrupo.get(i);
                modelo.setValueAt(pergrupo.getId_Grupo(), i, 0);
                modelo.setValueAt(pergrupo.getId_Personal(), i, 1);
                modelo.setValueAt(pergrupo.getApellidosNombres(),i,2);
                modelo.setValueAt(pergrupo.getFecha(),i,3);
                modelo.setValueAt(pergrupo.getNomCargo(),i,4);
                modelo.setValueAt(pergrupo.getActivo(),i,5);
                
            }
            this.jtListaPersonalGrupos.setModel(modelo);
            jtListaPersonalGrupos.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtListaPersonalGrupos.getColumnModel().getColumn(1).setPreferredWidth(30);
            jtListaPersonalGrupos.getColumnModel().getColumn(2).setPreferredWidth(200);
            jtListaPersonalGrupos.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtListaPersonalGrupos.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtListaPersonalGrupos.getColumnModel().getColumn(5).setPreferredWidth(10);

        } catch (SQLException ex) {
            Logger.getLogger(FrmRevisionGuias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String[] getColumnasPersonalGrupos() {
        String columna[] = new String[]{"Grupo",
            "Dni",
            "Apellidos y Nombres",
            "Fecha",
            "Cargo",
            "Grupo Act."
            };
        return columna;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        chkGrupoActivo = new javax.swing.JCheckBox();
        cboGrupos = new javax.swing.JComboBox();
        txtNombreApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBuscarPersonal = new javax.swing.JButton();
        txtFecha = new com.toedter.calendar.JDateChooser();
        cboCargos = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaPersonalGrupos = new javax.swing.JTable();
        txtApellidos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro por Grupo");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar en Registrados");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registro de Personal en Grupo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Grupo");

        jLabel2.setText("DNI");

        jLabel3.setText("Fecha");

        txtDNI.setText(" ");
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDNIKeyPressed(evt);
            }
        });

        chkGrupoActivo.setSelected(true);
        chkGrupoActivo.setText("Grupo Actual");
        chkGrupoActivo.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        chkGrupoActivo.setOpaque(false);

        jLabel4.setText("Nombres y Apellidos");

        btnBuscarPersonal.setText("Buscar DNI");
        btnBuscarPersonal.setEnabled(false);
        btnBuscarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPersonalActionPerformed(evt);
            }
        });

        txtFecha.setDateFormatString("dd-MM-yyyy");

        jLabel5.setText("Cargo");

        jtListaPersonalGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtListaPersonalGrupos);

        jLabel7.setText("Apellidos");

        jLabel8.setText("Nombres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtDNI)
                    .addComponent(cboGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnBuscarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(283, 283, 283))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel7))
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cboCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkGrupoActivo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMostrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPersonal)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(chkGrupoActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnMostrar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalir))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarTextos();
        //txtGrupo.setEditable(true);
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnBuscar.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        try {
            Personal_Grupo gp = new Personal_Grupo();
            datogrupo = DBGrupos.buscarGruposDescripcion(cboGrupos.getSelectedItem().toString());
            datoCargo = DBCargos.buscarCargoDescripcion(cboCargos.getSelectedItem().toString());
            System.out.println(DBGrupos.buscarGruposDescripcion(cboGrupos.getSelectedItem().toString()).getId_Grupos());
            gp.setId_Grupo(datogrupo.getId_Grupos());
            gp.setId_Personal(txtDNI.getText());
            String ValorFecha1 = sdf.format(txtFecha.getDate());
            gp.setFecha(ValorFecha1);
            System.out.println(ValorFecha1);
            
            gp.setActivo(ValorCheck(chkGrupoActivo.isSelected()));
            gp.setCargo(datoCargo.getId_Cargo());
            DBGrupos_Personal.actualizarGrupos_Personal(gp);
            JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
        }
        limpiarTextos();
        CargarPersonalGrupos();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            datogrupo = DBGrupos.buscarGruposDescripcion(cboGrupos.getSelectedItem().toString());
            Personal_Grupo d = DBGrupos_Personal.buscarGrupos_Personal(datogrupo.getId_Grupos(), txtDNI.getText());
            if (d == null) {
                JOptionPane.showMessageDialog(null, "No existe");
            } else {
                DBGrupos_Personal.eliminarGrupos_Personal(datogrupo.getId_Grupos(), txtDNI.getText());
                JOptionPane.showMessageDialog(null, "Se elimino Exitosamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
        limpiarTextos();
        CargarPersonalGrupos();
        //txtGrupo.setEditable(true);
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        JDDatosGrupo_Personal frmGrupoPersonal = new JDDatosGrupo_Personal(this,true);
        frmGrupoPersonal.setVisible(true);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtDNI.getText().compareTo("") != 0) {
            Personal_Grupo c = new Personal_Grupo() {};
            Empleado emp = new Empleado() {};
            try {
                datogrupo = DBGrupos.buscarGruposDescripcion(cboGrupos.getSelectedItem().toString());
                datoCargo = DBCargos.buscarCargoDescripcion(cboCargos.getSelectedItem().toString());
                c.setId_Grupo(datogrupo.getId_Grupos());
                //datoEmpleado = BDEmpleado.buscarEmpleadoDNI(txtDNI.getText());
                c.setId_Personal(txtDNI.getText());
                String ValorFecha1 = sdf.format(txtFecha.getDate());
                c.setFecha(ValorFecha1);
                System.out.println(ValorFecha1);
               c.setCargo(datoCargo.getId_Cargo());
                //c.setFecha(txtFecha.getDate().toString());
                //System.out.println(txtFecha.getDate());
                c.setActivo(ValorCheck(chkGrupoActivo.isSelected()));
                DBGrupos_Personal.insertarGrupos_Personal(c);
                //Ingresar a Empleados
                emp.setApellido(txtApellidos.getText());
                emp.setNombre(txtNombres.getText());
                emp.setDni(txtDNI.getText());
                BDEmpleado.insertarEmpleado(emp);
                
            } 
            catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Datos Agregados Correctamente");
            limpiarTextos();
        } else {
            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos..OKz");
        }
        CargarPersonalGrupos();
        //txtGrupo.setEditable(true);
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTextos();
        //txtGrupo.setEditable(true);
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
            int result = JOptionPane.showConfirmDialog(
                    this, "Deseas Buscar al Grupo Personal para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                buscarBotica();
                //txtGrupo.setEditable(false);
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnBuscar.setEnabled(false);
            }
            if (result == JOptionPane.NO_OPTION) {
                //txtGrupo.setEditable(false);
                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnBuscar.setEnabled(false);
            }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyPressed
        /*Personal c = null;
         * try {
         * c = DBPersonal.buscarPersonalDNI(txtDNI.getText());
         * 
         * } catch (SQLException e) {
         * JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
         * }
         * if (c != null) {
         * txtNombreApellidos.setText(c.getNombres() + " " + c.getApellidos());
         * 
         * } else {
         * JOptionPane.showMessageDialog(null, "No exite");
         * }*/
    }//GEN-LAST:event_txtDNIKeyPressed

    private void btnBuscarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPersonalActionPerformed
        Empleado c = null;
        try {
            //c = DBPersonal.buscarPersonalDNI(txtDNI.getText());
            c = BDEmpleado.buscarEmpleadoDNI(txtDNI.getText().trim());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (c != null) {
            txtNombreApellidos.setText(c.getNombre() + " " + c.getApellido());

        } else {
            JOptionPane.showMessageDialog(null, "No exite");
        }
    }//GEN-LAST:event_btnBuscarPersonalActionPerformed
    public void limpiarTextos() {

        //txtGrupo.setText("");
        txtDNI.setText("");
        txtNombreApellidos.setText("");
        txtFecha.setDate(fecha);
        txtApellidos.setText("");
        txtNombres.setText("");
        //txtIdZona.setText("");
        //txtFecha.setDate("");
        //chkGrupoActivo.s
    }

    public void buscarBotica() {
        Personal_Grupo c = null;
        try {
            datogrupo = DBGrupos.buscarGruposDescripcion(cboGrupos.getSelectedItem().toString());
            c = DBGrupos_Personal.buscarGrupos_Personal(datogrupo.getId_Grupos(), txtDNI.getText().trim());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (c != null) {
            //cboGrupos.setSelectedItem(c.getId_Grupo());
            //txtDNI.setText(c.getId_Personal());
             // ValorFecha = sdf.format(c.getFecha());
            Date fecha1 = null;
            try {
                fecha1 = sdf.parse(c.getFecha());
            } catch (ParseException ex) {
                Logger.getLogger(FrmGrupos_Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtFecha.setDate(fecha1);
            txtNombreApellidos.setText(c.getApellidosNombres()); 
            txtNombres.setText(c.getNombres());
            txtApellidos.setText(c.getApellidos());
           cboCargos.setSelectedItem(c.getNomCargo());
           boolean ValorChk = c.getActivo()==1?true:false;
            chkGrupoActivo.setSelected(ValorChk);


        } else {

            JOptionPane.showMessageDialog(null, "No exite");
        }

    }

    public int ValorCheck(boolean valor) {
        int valActivo = 0;
        if (valor) {
            valActivo = 1;
        } else {
            valActivo = 0;
        }

        return valActivo;
    }

    public void autocomplete() {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarPersonal;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboCargos;
    private javax.swing.JComboBox cboGrupos;
    private javax.swing.JCheckBox chkGrupoActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtListaPersonalGrupos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDNI;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNombreApellidos;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
