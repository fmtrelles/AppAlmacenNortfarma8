/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenPresentacion;

import AlmacenClases.ContarCajas;
import AlmacenDatos.DBContarMedicina;
import ComponentePresentacion.FrmPanelFondoPrincipal;
import java.awt.BorderLayout;
import java.sql.SQLException;
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
public class FrmContarMedicina extends javax.swing.JFrame {

    DefaultTableModel modelo;

    public FrmContarMedicina() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jConteoMedicina = new javax.swing.JTable();
        txtDia = new javax.swing.JTextField();
        btnRegistrarInformacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtPeriodo = new javax.swing.JFormattedTextField();
        btnGuardar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contar Medicina");

        jConteoMedicina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Periodo", "Apellidos y Nombres", "Dni", "Conteo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jConteoMedicina);

        btnRegistrarInformacion.setText("Registrar Informacion en el Perido");
        btnRegistrarInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarInformacionActionPerformed(evt);
            }
        });

        jLabel1.setText("Periodo");

        jLabel2.setText("Dia:");

        lblTitulo.setBackground(new java.awt.Color(0, 51, 153));
        lblTitulo.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));

        try {
            txtPeriodo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeriodoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrarInformacion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(41, 130, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarInformacion)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarInformacionActionPerformed
        String PeriodoAbrir = txtPeriodo.getText().substring(0, 2) + txtPeriodo.getText().substring(3, 7);
        lblTitulo.setText("Periodo: " + PeriodoAbrir + "Dia: " + txtDia.getText());
        CagarConteoMedicina(Integer.parseInt(txtDia.getText()), PeriodoAbrir);
    }//GEN-LAST:event_btnRegistrarInformacionActionPerformed

    private void txtPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPeriodoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int seleccion = JOptionPane.showOptionDialog(null,
                "¿Guardar la informacion registrada?",
                "Selector de opciones",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Si", "No"}, "Si");
        if (seleccion == 0) {
            String PeriodoActual = txtPeriodo.getText().substring(0, 2) + txtPeriodo.getText().substring(3, 7);
            for (int fil = 0; fil < jConteoMedicina.getRowCount(); fil++) {
                //Selecciona celda si el texto es encontrado   
                ContarCajas contar = new ContarCajas();
                contar.setD1(Integer.parseInt(jConteoMedicina.getValueAt(fil, 4).toString()));
                contar.setDni(jConteoMedicina.getValueAt(fil, 3).toString());
                contar.setPeriodo(jConteoMedicina.getValueAt(fil, 0).toString());
                try {
                    DBContarMedicina.ActualizarDiaConteo(Integer.parseInt(txtDia.getText()), PeriodoActual, jConteoMedicina.getValueAt(fil, 2).toString(), contar);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmContarMedicina.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            JOptionPane.showMessageDialog(this, "Se grabo Satisfactoriamente la informacion");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void CagarConteoMedicina(int dia, String periodo) {
        //Boticas cDescargo;
        modelo = new DefaultTableModel(null, getColumnasContar());
        jConteoMedicina.setModel(modelo);

        /*modelo = new DefaultTableModel(null, getColumnasContar()) {
         * @Override
         * public boolean isCellEditable(int fila, int columna) {
         * return false;
         * }
         * };*/

        try {
            List<ContarCajas> ListaGrupos = DBContarMedicina.mostrarConteoMedicinaDia(dia, periodo);
            modelo.setNumRows(ListaGrupos.size());
            for (int i = 0; i < ListaGrupos.size(); i++) { // Recorriendo Los Datos que se Encuentran en el Arraylist
                ContarCajas cajas = ListaGrupos.get(i);
                modelo.setValueAt(cajas.getPeriodo(), i, 0);
                modelo.setValueAt(cajas.getGrupo(), i, 1);
                modelo.setValueAt(cajas.getApellidosNombres(), i, 2);
                modelo.setValueAt(cajas.getDni(), i, 3);
                modelo.setValueAt(cajas.getD1(), i, 4);
                //System.out.println(String.valueOf(i)+"--"+guiasx.getTypmov()+"--"+guiasx.getDocnum());
            }
            this.jConteoMedicina.setModel(modelo);

            jConteoMedicina.getColumnModel().getColumn(0).setPreferredWidth(25);
            jConteoMedicina.getColumnModel().getColumn(1).setPreferredWidth(25);
            jConteoMedicina.getColumnModel().getColumn(2).setPreferredWidth(200);
            jConteoMedicina.getColumnModel().getColumn(3).setPreferredWidth(80);
            jConteoMedicina.getColumnModel().getColumn(4).setPreferredWidth(50);

        } catch (SQLException ex) {
            Logger.getLogger(FrmRevisionGuias.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    private String[] getColumnasContar() {
        String columna[] = new String[]{"Periodo", "Grupo","Apellidos y Nombres", "Dni", "Cantidad"};
        return columna;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegistrarInformacion;
    private javax.swing.JTable jConteoMedicina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtDia;
    private javax.swing.JFormattedTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
