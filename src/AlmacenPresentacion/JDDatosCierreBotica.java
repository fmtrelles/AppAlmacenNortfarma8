/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenPresentacion;

import AlmacenClases.Cargos;
import AlmacenClases.Personal_Grupo;
import AlmacenClases.Revision;
import AlmacenClases.Revision_detalle;
import AlmacenDatos.DBGrupos_Personal;
import AlmacenDatos.DBRevision;
import AlmacenDatos.DBRevision_Detalle;
import ComponentePresentacion.FrmPanelFondoPrincipal;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JDDatosCierreBotica extends javax.swing.JDialog {

    public static int Finalizar = 0;
    DefaultTableModel ModeloTrabajadores;
    DateFormat ValorFecha = DateFormat.getDateInstance(DateFormat.MEDIUM);
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    Date FechaFinal = new Date();

    Cargos datoCargo;
    
    public JDDatosCierreBotica(javax.swing.JDialog parent, boolean modal, int g) {
        super(parent, modal);
        initComponents();
        FrmPanelFondoPrincipal fondoprinc = new FrmPanelFondoPrincipal();
        this.setSize(500, 300);
        this.add(fondoprinc, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.pack();
        CargarTrabajadores(g);
        
        txtCantCajas.setFocusable(true);

        String ValorFecha2 = sdf2.format(FechaFinal);
        //c.setFecha(ValorFecha1);

        txtHora_Final.setText(Integer.toString(FechaFinal.getHours()) + ":" + Integer.toString(FechaFinal.getMinutes()) + ":" + Integer.toString(FechaFinal.getSeconds()));
        txtFecha.setText(ValorFecha2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFecha = new javax.swing.JTextField();
        txtDescripcionGrupo = new javax.swing.JTextField();
        txtDescripcionBotica = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCantCajas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtHora_Inicio = new javax.swing.JTextField();
        txtHora_Final = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTrabajadoresGrupo = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBotica = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCantGuias = new javax.swing.JTextField();
        txtGrupo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 204));
        txtFecha.setForeground(new java.awt.Color(204, 0, 0));

        txtDescripcionGrupo.setBackground(new java.awt.Color(255, 255, 204));
        txtDescripcionGrupo.setForeground(new java.awt.Color(204, 0, 0));

        txtDescripcionBotica.setBackground(new java.awt.Color(255, 255, 204));
        txtDescripcionBotica.setForeground(new java.awt.Color(204, 0, 0));

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

        jLabel7.setText("Cantidad Guias");

        jLabel1.setText("Botica");

        txtHora_Inicio.setEditable(false);
        txtHora_Inicio.setBackground(new java.awt.Color(255, 255, 204));
        txtHora_Inicio.setForeground(new java.awt.Color(204, 0, 0));

        txtHora_Final.setEditable(false);
        txtHora_Final.setBackground(new java.awt.Color(255, 255, 204));
        txtHora_Final.setForeground(new java.awt.Color(204, 0, 0));

        jTrabajadoresGrupo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTrabajadoresGrupo);

        jLabel4.setText("Hora Inicio");

        jLabel5.setText("Hora Final");

        jLabel6.setText("Cancidad Cajas");

        txtBotica.setEditable(false);
        txtBotica.setBackground(new java.awt.Color(255, 255, 204));
        txtBotica.setForeground(new java.awt.Color(204, 0, 0));

        jLabel2.setText("Grupo");

        txtGrupo.setBackground(new java.awt.Color(255, 255, 204));
        txtGrupo.setForeground(new java.awt.Color(204, 0, 0));

        jLabel3.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantGuias, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(txtFecha)
                            .addComponent(txtHora_Inicio)
                            .addComponent(txtHora_Final)
                            .addComponent(txtCantCajas))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBotica, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcionBotica)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btnAceptar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantCajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantGuias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Finalizar = 0;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txtCantCajas.getText().compareTo("") != 0 || txtCantGuias.getText().compareTo("") != 0) {
            Revision r = new Revision() {
            };
            r.setId_grupo(Integer.parseInt(txtGrupo.getText()));
            r.setId_Botica(txtBotica.getText());
            String ValorFecha1 = sdf1.format(FechaFinal);
            r.setFecha(ValorFecha1);
            r.setHora_Inicio(txtHora_Inicio.getText());
            r.setHora_Final(txtHora_Final.getText());
            r.setCantidad_Cajas(Integer.parseInt(txtCantCajas.getText()));
            r.setCantidad_Guias(Integer.parseInt(txtCantGuias.getText()));
            try {
                int rev = DBRevision.insertarRevision(r);
                if (rev!=0)
                {
                    Revision_detalle revdet = new Revision_detalle();
                    for (int fil = 0; fil < jTrabajadoresGrupo.getRowCount(); fil++) {
                        try {
                            revdet.setId_Revsion(rev);
                            revdet.setGrupo(Integer.parseInt(txtGrupo.getText()));
                            revdet.setId_Personal(jTrabajadoresGrupo.getValueAt(fil, 0).toString());
                            DBRevision_Detalle.insertarRevision(revdet);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error BD: " + ex.getMessage());
                        }
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Datos Agregados Correctamente");
            Finalizar = 1;
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos..OKz");
            Finalizar = 0;
            this.setVisible(false);
        }



    }//GEN-LAST:event_btnAceptarActionPerformed

    private String[] getColumnasGuias() {
        String columna[] = new String[]{"DNI", "Apellidos y Nombres", "Cargo"};
        return columna;
    }

    private void CargarTrabajadores(int g) {
        //Boticas cDescargo;
        ModeloTrabajadores = new DefaultTableModel();
        jTrabajadoresGrupo.setModel(ModeloTrabajadores);
        ModeloTrabajadores = new DefaultTableModel(null, getColumnasGuias()) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        try {
            List<Personal_Grupo> ListaTrabajadores = DBGrupos_Personal.mostrarGrupos_Personal(g);
            // Guias guiasx = new Guias();
            
            ModeloTrabajadores.setNumRows(ListaTrabajadores.size());
            for (int i = 0; i < ListaTrabajadores.size(); i++) { // Recorriendo Los Datos que se Encuentran en el Arraylist
                Personal_Grupo Traba = ListaTrabajadores.get(i);
                ModeloTrabajadores.setValueAt(Traba.getId_Personal(), i, 0);
                //Personal bPer = DBPersonal.buscarPersonalDNI(Traba.getId_Personal().getDni().toString());
                //Empleado bPer = BDEmpleado.buscarEmpleadoDNI(Traba.getId_Personal().getDni().toString());
                //System.out.println(bPer.getApellidos());
                ModeloTrabajadores.setValueAt(Traba.getApellidosNombres(), i, 1);
                ModeloTrabajadores.setValueAt(Traba.getNomCargo(), i, 2);
                //System.out.println(String.valueOf(i)+"--"+guiasx.getTypmov()+"--"+guiasx.getDocnum());
            }
            this.jTrabajadoresGrupo.setModel(ModeloTrabajadores);
            jTrabajadoresGrupo.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTrabajadoresGrupo.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTrabajadoresGrupo.getColumnModel().getColumn(2).setPreferredWidth(100);

        } catch (SQLException ex) {
            Logger.getLogger(FrmRevisionGuias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTrabajadoresGrupo;
    public javax.swing.JTextField txtBotica;
    private javax.swing.JTextField txtCantCajas;
    private javax.swing.JTextField txtCantGuias;
    public javax.swing.JTextField txtDescripcionBotica;
    public javax.swing.JTextField txtDescripcionGrupo;
    private javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtGrupo;
    private javax.swing.JTextField txtHora_Final;
    public javax.swing.JTextField txtHora_Inicio;
    // End of variables declaration//GEN-END:variables
}
