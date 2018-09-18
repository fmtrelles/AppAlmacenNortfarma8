/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenPresentacion;

import AlmacenClases.ContarCajas;
import AlmacenDatos.DBContarMedicina;
import ComponenteClase.Empleado;
import ComponenteDatos.BDEmpleado;
import ComponentePresentacion.FrmPanelFondoPrincipal;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jsarango
 */
public class FrmAbrirPeridoConteoMedicina extends javax.swing.JFrame {

    DefaultTableModel modelo;

    public FrmAbrirPeridoConteoMedicina() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        FrmPanelFondoPrincipal fondoprinc = new FrmPanelFondoPrincipal();
        this.setSize(500, 300);
        this.add(fondoprinc, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPeriodo = new javax.swing.JFormattedTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListadoTrabajadoresPeridodo = new javax.swing.JTable();
        btnAgregarTrabajador = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aperturar Conteo Medicina");

        try {
            txtPeriodo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPeriodo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPeriodo.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jListadoTrabajadoresPeridodo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jListadoTrabajadoresPeridodo);

        btnAgregarTrabajador.setText("Buscar y Agregar");
        btnAgregarTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTrabajadorActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarTrabajador)
                    .addComponent(jButton2)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        //JOptionPane.showMessageDialog(null, "Seguro de Agregar empleados al perido:"+txtPeriodo.getText().substring(0,2)+txtPeriodo.getText().substring(3,7));
        //JOptionPane.showOptionDialog(rootPane, evt, null, WIDTH, WIDTH, null, options, rootPane);
        List<ContarCajas> ListaInicio;
        List<ContarCajas> ListaCajas;
        String PeriodoAbrir = txtPeriodo.getText().substring(0, 2) + txtPeriodo.getText().substring(3, 7);
        try {
            ListaCajas = DBContarMedicina.mostrarConteoMedicinaPeriodo(PeriodoAbrir);
            if (ListaCajas.size() == 0) {
                int Respuesta = JOptionPane.showConfirmDialog(this, "Desea seguir ejecutando la aplicación?", "Seleccione una opción", JOptionPane.YES_NO_OPTION);
                if (Respuesta == 0) {
                    try {

                        ListaInicio = DBContarMedicina.AbrirPeriodoConteo(PeriodoAbrir);
                        if (ListaInicio == null) {
                            JOptionPane.showMessageDialog(null, "No se ha podido inicializar periodo: " + txtPeriodo.getText().substring(0, 2) + txtPeriodo.getText().substring(3, 7));
                        } else {


                            for (ContarCajas contar : ListaInicio) {
                                ContarCajas ccajas = new ContarCajas();
                                ccajas.setApellidosNombres(contar.getApellidosNombres());
                                ccajas.setPeriodo(contar.getPeriodo());
                                ccajas.setDni(contar.getDni());
                                DBContarMedicina.AgregarDiaConteo(ccajas);
                                CagarConteoMedicina(PeriodoAbrir);
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FrmAbrirPeridoConteoMedicina.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                CagarConteoMedicina(PeriodoAbrir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmAbrirPeridoConteoMedicina.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAceptarActionPerformed
    private void CagarConteoMedicina(String periodo) {
        //Boticas cDescargo;
        modelo = new DefaultTableModel(null, getColumnasContar());
        jListadoTrabajadoresPeridodo.setModel(modelo);

        /*modelo = new DefaultTableModel(null, getColumnasContar()) {
         * @Override
         * public boolean isCellEditable(int fila, int columna) {
         * return false;
         * }
         * };*/

        try {
            List<ContarCajas> ListaGrupos = DBContarMedicina.mostrarConteoMedicinaPeriodo(periodo);
            modelo.setNumRows(ListaGrupos.size());
            for (int i = 0; i < ListaGrupos.size(); i++) { // Recorriendo Los Datos que se Encuentran en el Arraylist
                ContarCajas cajas = ListaGrupos.get(i);
                modelo.setValueAt(cajas.getPeriodo(), i, 0);
                modelo.setValueAt(cajas.getApellidosNombres(), i, 1);
                modelo.setValueAt(cajas.getDni(), i, 2);

                //System.out.println(String.valueOf(i)+"--"+guiasx.getTypmov()+"--"+guiasx.getDocnum());
            }
            this.jListadoTrabajadoresPeridodo.setModel(modelo);

            jListadoTrabajadoresPeridodo.getColumnModel().getColumn(0).setPreferredWidth(25);
            jListadoTrabajadoresPeridodo.getColumnModel().getColumn(1).setPreferredWidth(200);
            jListadoTrabajadoresPeridodo.getColumnModel().getColumn(2).setPreferredWidth(80);


        } catch (SQLException ex) {
            Logger.getLogger(FrmRevisionGuias.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    private String[] getColumnasContar() {
        String columna[] = new String[]{"Periodo", "Apellidos y Nombres", "Dni"};
        return columna;
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTrabajadorActionPerformed
    
        String PeriodoAbrir = txtPeriodo.getText().substring(0, 2) + txtPeriodo.getText().substring(3, 7);
        try {
            Empleado DatosEmpleado = BDEmpleado.buscarEmpleadoDNI(txtDni.getText());
            
            ContarCajas newTrabajador = new ContarCajas();
            newTrabajador.setPeriodo(PeriodoAbrir);
            newTrabajador.setApellidosNombres(DatosEmpleado.getApellido().toUpperCase()+", "+DatosEmpleado.getNombre());
            newTrabajador.setDni(DatosEmpleado.getDni());
            DBContarMedicina.AgregarDiaConteo(newTrabajador);
            CagarConteoMedicina(PeriodoAbrir);
        } catch (SQLException ex) {
            Logger.getLogger(FrmAbrirPeridoConteoMedicina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarTrabajadorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarTrabajador;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton jButton2;
    private javax.swing.JTable jListadoTrabajadoresPeridodo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDni;
    private javax.swing.JFormattedTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
