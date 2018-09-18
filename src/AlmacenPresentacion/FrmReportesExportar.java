/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenPresentacion;

import ComponenteOtros.Leer_Escribir_Excel;
import ComponentePresentacion.FrmMenu;
import ComponentePresentacion.FrmPanelFondoPrincipal;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import jxl.write.WriteException;
import jxl.write.biff.JxlWriteException;

/**
 *
 * @author jsarango
 */
public class FrmReportesExportar extends javax.swing.JFrame {

    /**
     * Creates new form FrmReportesExportar
     */
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public FrmReportesExportar() {
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

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        txtPeriodo = new javax.swing.JFormattedTextField();
        btnExportarMedicina = new javax.swing.JButton();
        btnExportarLacteos = new javax.swing.JButton();
        btnRevisionGuias = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnReporteDiario = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnReporteDiarioGuias = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes parametrizados");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte Mensual"));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        try {
            txtPeriodo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPeriodo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPeriodo.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        btnExportarMedicina.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExportarMedicina.setText("Exportar Revision Medicina");
        btnExportarMedicina.setActionCommand("Exportar \nRevision Medicina");
        btnExportarMedicina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExportarMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarMedicinaActionPerformed(evt);
            }
        });

        btnExportarLacteos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExportarLacteos.setText("Exportar Revision Lacteos");
        btnExportarLacteos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarLacteosActionPerformed(evt);
            }
        });

        btnRevisionGuias.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnRevisionGuias.setText("Exportar Revision Guias");
        btnRevisionGuias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevisionGuiasActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(txtPeriodo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 42, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(btnRevisionGuias, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .add(btnExportarMedicina, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .add(btnExportarLacteos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(btnExportarMedicina, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnExportarLacteos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtPeriodo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(btnRevisionGuias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnExportarMedicina.getAccessibleContext().setAccessibleName("Exportar \nRevision \nMedicina"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte Diario"));

        btnReporteDiario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnReporteDiario.setText("Reporte Diario de Revision");
        btnReporteDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteDiarioActionPerformed(evt);
            }
        });

        btnReporteDiarioGuias.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnReporteDiarioGuias.setText("Reporte Diario de Revision Guias");
        btnReporteDiarioGuias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteDiarioGuiasActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(jDateChooser1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnReporteDiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 192, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnReporteDiarioGuias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 192, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(btnReporteDiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnReporteDiarioGuias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(jDateChooser1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarMedicinaActionPerformed
        String Periodo = txtPeriodo.getText().substring(0, 2) + txtPeriodo.getText().substring(3, 7);
        try {
            Leer_Escribir_Excel.ExportarConteoMedicina(Periodo);
        } catch (JxlWriteException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarMedicinaActionPerformed

    private void btnExportarLacteosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarLacteosActionPerformed
        String Periodo = txtPeriodo.getText().substring(0, 2) + txtPeriodo.getText().substring(3, 7);
        try {
            Leer_Escribir_Excel.ExportarConteoLacteos(Periodo);
        } catch (JxlWriteException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarLacteosActionPerformed

    private void btnRevisionGuiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevisionGuiasActionPerformed
        int xmes = Integer.parseInt(txtPeriodo.getText().substring(0, 2));
        try {
            Leer_Escribir_Excel.ExportarRevisionxGrupos(xmes);
        } catch (JxlWriteException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRevisionGuiasActionPerformed

    private void btnReporteDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteDiarioActionPerformed

        String ValorFecha1 = sdf.format(jDateChooser1.getDate());
        System.out.println(ValorFecha1);


        try {
            Leer_Escribir_Excel.ExportarReporteDiario(ValorFecha1);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteDiarioActionPerformed

    private void btnReporteDiarioGuiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteDiarioGuiasActionPerformed
       String ValorFecha1 = sdf.format(jDateChooser1.getDate());
        System.out.println(ValorFecha1);


        try {
            Leer_Escribir_Excel.ExportarReporteDiario_Guias(ValorFecha1);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmReportesExportar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnReporteDiarioGuiasActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarLacteos;
    private javax.swing.JButton btnExportarMedicina;
    private javax.swing.JButton btnReporteDiario;
    private javax.swing.JButton btnReporteDiarioGuias;
    private javax.swing.JButton btnRevisionGuias;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
