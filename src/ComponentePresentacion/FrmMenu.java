/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * FrmMenu.java
 *
 * Created on 13/08/2010, 03:00:55 PM
 */
package ComponentePresentacion;

//import ComponenteDatos.BDReporteProductos;
//import ComponenteReportes.ReporteEmpleado;
import AlmacenPresentacion.FrmAbrirPeridoConteoLacteos;
import AlmacenPresentacion.FrmAbrirPeridoConteoMedicina;
import AlmacenPresentacion.FrmBoticas;
import AlmacenPresentacion.FrmCargos;
import AlmacenPresentacion.FrmContarLacteos;
import AlmacenPresentacion.FrmContarMedicina;
import AlmacenPresentacion.FrmGrupos;
import AlmacenPresentacion.FrmGrupos_Personal;
import AlmacenPresentacion.FrmPedirBoticaGrupo;
import AlmacenPresentacion.FrmProductosAlmacen;
import AlmacenPresentacion.FrmReportesExportar;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.UIManager;
import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Richard
 */
public abstract class FrmMenu extends javax.swing.JFrame {
    // private BDReporteProductos jasper;
    //private ReporteEmpleado jasper;

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        //this.setUndecorated(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int sr = Toolkit.getDefaultToolkit().getScreenResolution();
        System.out.println("Tamaño de pantalla: " + d.width + "x" + d.height + ", definición: " + sr + " ppp");

        this.setExtendedState(FrmMenu.MAXIMIZED_BOTH);
        this.setSize(d.width, d.height);

        this.setLocationRelativeTo(null);
        //jasper = new ReporteEmpleado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblNomUserlogeado = new javax.swing.JLabel();
        lblApUsuariologeado = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRevisionGuias = new javax.swing.JButton();
        btnContarMedicina = new javax.swing.JButton();
        btnContarLacteos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMInicio = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuCalculadora = new javax.swing.JMenuItem();
        JMISalir = new javax.swing.JMenuItem();
        JMVenta = new javax.swing.JMenu();
        menuRevisionGuias = new javax.swing.JMenuItem();
        menuContarMedicina = new javax.swing.JMenuItem();
        menuContarLacteos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuAperturaConteoMedicina = new javax.swing.JMenuItem();
        menuAperturaConteoLacteos = new javax.swing.JMenuItem();
        JMMantenimiento = new javax.swing.JMenu();
        menuBoticas = new javax.swing.JMenuItem();
        JMIEmpleado = new javax.swing.JMenuItem();
        menuGrupo = new javax.swing.JMenuItem();
        menuGrupoPersonal = new javax.swing.JMenuItem();
        JMIUsuario = new javax.swing.JMenuItem();
        menuCargos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        JMReportes = new javax.swing.JMenu();
        menuReportes = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jmActualizarProducto = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Revision Guias ALMACEN-MEDICINA");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("BIENVENIDOS AL SISTEMA");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/p031_1_00.jpg"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("ALMACEN NORTFARMA");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Fecha :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Hora :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("00h:00m:00s");

        lblNomUserlogeado.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        lblNomUserlogeado.setForeground(new java.awt.Color(0, 102, 102));
        lblNomUserlogeado.setText("Nombrel Usuario");

        lblApUsuariologeado.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        lblApUsuariologeado.setForeground(new java.awt.Color(0, 102, 102));
        lblApUsuariologeado.setText("datos compltos del usuario que se logeo");

        jLabel11.setFont(new java.awt.Font("Californian FB", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(":");

        jPanel2.setBackground(new java.awt.Color(236, 235, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        btnRevisionGuias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/scheduledtasks.png"))); // NOI18N
        btnRevisionGuias.setText("Revision Guias");
        btnRevisionGuias.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnRevisionGuias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRevisionGuias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRevisionGuias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevisionGuiasActionPerformed(evt);
            }
        });

        btnContarMedicina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/128.png"))); // NOI18N
        btnContarMedicina.setText("Revisar Medicina");
        btnContarMedicina.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnContarMedicina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnContarMedicina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnContarMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContarMedicinaActionPerformed(evt);
            }
        });

        btnContarLacteos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponenteImagenes/7Zip Box_2.png"))); // NOI18N
        btnContarLacteos.setText("Revisar Lacteos");
        btnContarLacteos.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, null));
        btnContarLacteos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnContarLacteos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnContarLacteos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContarLacteosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnRevisionGuias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContarMedicina, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContarLacteos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(749, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRevisionGuias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnContarMedicina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnContarLacteos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(299, 299, 299))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel11)
                .addGap(90, 90, 90)
                .addComponent(jLabel5)
                .addGap(68, 68, 68)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNomUserlogeado)
                        .addGap(15, 15, 15)
                        .addComponent(lblApUsuariologeado, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2))
                        .addGap(75, 75, 75)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomUserlogeado)
                    .addComponent(lblApUsuariologeado))
                .addContainerGap())
        );

        JMInicio.setText("Inicio");

        jMenuItem5.setText("Ayuda");
        JMInicio.add(jMenuItem5);

        menuCalculadora.setText("Calculadora");
        menuCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCalculadoraActionPerformed(evt);
            }
        });
        JMInicio.add(menuCalculadora);

        JMISalir.setText("Salir");
        JMISalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMISalirActionPerformed(evt);
            }
        });
        JMInicio.add(JMISalir);

        jMenuBar1.add(JMInicio);

        JMVenta.setText("Revisión");

        menuRevisionGuias.setText("Revisión guías");
        menuRevisionGuias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRevisionGuiasActionPerformed(evt);
            }
        });
        JMVenta.add(menuRevisionGuias);

        menuContarMedicina.setText("Revisión Medicina");
        menuContarMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuContarMedicinaActionPerformed(evt);
            }
        });
        JMVenta.add(menuContarMedicina);

        menuContarLacteos.setText("Revisión lácteos");
        menuContarLacteos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuContarLacteosActionPerformed(evt);
            }
        });
        JMVenta.add(menuContarLacteos);
        JMVenta.add(jSeparator2);

        menuAperturaConteoMedicina.setText("Apertura conteo medicina");
        menuAperturaConteoMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAperturaConteoMedicinaActionPerformed(evt);
            }
        });
        JMVenta.add(menuAperturaConteoMedicina);

        menuAperturaConteoLacteos.setText("Apertura conteo lácteos");
        menuAperturaConteoLacteos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAperturaConteoLacteosActionPerformed(evt);
            }
        });
        JMVenta.add(menuAperturaConteoLacteos);

        jMenuBar1.add(JMVenta);

        JMMantenimiento.setText("Mantenimiento");

        menuBoticas.setText("Boticas");
        menuBoticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBoticasActionPerformed(evt);
            }
        });
        JMMantenimiento.add(menuBoticas);

        JMIEmpleado.setText("Empleado");
        JMIEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIEmpleadoActionPerformed(evt);
            }
        });
        JMMantenimiento.add(JMIEmpleado);

        menuGrupo.setText("Grupos");
        menuGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGrupoActionPerformed(evt);
            }
        });
        JMMantenimiento.add(menuGrupo);

        menuGrupoPersonal.setText("Personal grupo");
        menuGrupoPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGrupoPersonalActionPerformed(evt);
            }
        });
        JMMantenimiento.add(menuGrupoPersonal);

        JMIUsuario.setText("Usuario");
        JMIUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIUsuarioActionPerformed(evt);
            }
        });
        JMMantenimiento.add(JMIUsuario);

        menuCargos.setText("Cargos");
        menuCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCargosActionPerformed(evt);
            }
        });
        JMMantenimiento.add(menuCargos);

        jMenuItem2.setText("Zonas");
        JMMantenimiento.add(jMenuItem2);

        jMenuBar1.add(JMMantenimiento);

        JMReportes.setText("Reportes");

        menuReportes.setText("Reportes");
        menuReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportesActionPerformed(evt);
            }
        });
        JMReportes.add(menuReportes);

        jMenuBar1.add(JMReportes);

        jMenu1.setText("Actualizar");

        jMenuItem1.setText("Actualizar todo");
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem6.setText("Actualizar productos");
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Actualizar guías");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jmActualizarProducto.setText("Almacen");

        jMenuItem3.setText("Revisar Stock");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmActualizarProducto.add(jMenuItem3);

        jMenuItem4.setText("Actualizar datos del producto");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmActualizarProducto.add(jMenuItem4);
        jmActualizarProducto.add(jSeparator3);

        jMenuItem8.setText("Resumen");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jmActualizarProducto.add(jMenuItem8);

        jMenuItem9.setText("Consultar resumen");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jmActualizarProducto.add(jMenuItem9);

        jMenuBar1.add(jmActualizarProducto);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMIEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIEmpleadoActionPerformed
        // TODO add your handling code here:
        FrmEmpleado Frme = new FrmEmpleado();
        //Cambio
        Frme.setLocationRelativeTo(null);
        Frme.setVisible(true);
    }//GEN-LAST:event_JMIEmpleadoActionPerformed

    private void menuGrupoPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGrupoPersonalActionPerformed
        // TODO add your handling code here:
        FrmGrupos_Personal Frmp = new FrmGrupos_Personal();
        //Cambio
        Frmp.setLocationRelativeTo(null);
        Frmp.setVisible(true);

    }//GEN-LAST:event_menuGrupoPersonalActionPerformed

    private void JMIUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIUsuarioActionPerformed
        // TODO add your handling code here:
        FrmUsuario FrmUs = new FrmUsuario();
        //CAmbio
        FrmUs.setLocationRelativeTo(null);
        FrmUs.setVisible(true);
    }//GEN-LAST:event_JMIUsuarioActionPerformed

    private void menuRevisionGuiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRevisionGuiasActionPerformed
        FrmPedirBoticaGrupo FrmComp = new FrmPedirBoticaGrupo();
        //Cambio
        FrmComp.setLocationRelativeTo(null);
        FrmComp.setVisible(true);
    }//GEN-LAST:event_menuRevisionGuiasActionPerformed

    private void JMISalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMISalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_JMISalirActionPerformed

    private void menuReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportesActionPerformed
        // TODO add your handling code here:
        //jasper.runReporteEmpleado();
        FrmReportesExportar frmrep = new FrmReportesExportar();
        //Cambio
        frmrep.setLocationRelativeTo(null);
        frmrep.setVisible(true);
    }//GEN-LAST:event_menuReportesActionPerformed

    private void menuBoticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBoticasActionPerformed

        FrmBoticas frmBot = new FrmBoticas();
        //Cambio
        frmBot.setLocationRelativeTo(null);
        frmBot.setVisible(true);

    }//GEN-LAST:event_menuBoticasActionPerformed

    private void menuCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCargosActionPerformed
        FrmCargos frmCargo = new FrmCargos();
        //Cambio
        frmCargo.setLocationRelativeTo(null);
        frmCargo.setVisible(true);
    }//GEN-LAST:event_menuCargosActionPerformed

    private void menuGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGrupoActionPerformed
        FrmGrupos frmGrupo = new FrmGrupos();
        //Cambio
        frmGrupo.setLocationRelativeTo(null);
        frmGrupo.setVisible(true);

    }//GEN-LAST:event_menuGrupoActionPerformed

    private void menuCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCalculadoraActionPerformed
        ejecutar("Calc");
    }//GEN-LAST:event_menuCalculadoraActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void menuAperturaConteoMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAperturaConteoMedicinaActionPerformed
        FrmAbrirPeridoConteoMedicina frmMedicina = new FrmAbrirPeridoConteoMedicina();
        //Cambio
        frmMedicina.setLocationRelativeTo(null);
        frmMedicina.setVisible(true);
    }//GEN-LAST:event_menuAperturaConteoMedicinaActionPerformed

    private void menuContarMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuContarMedicinaActionPerformed
        FrmContarMedicina frmContar = new FrmContarMedicina();
        //Cambio
        frmContar.setLocationRelativeTo(null);
        frmContar.setVisible(true);
    }//GEN-LAST:event_menuContarMedicinaActionPerformed

    private void menuContarLacteosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuContarLacteosActionPerformed
        FrmContarLacteos frmlacteos = new FrmContarLacteos();
        //Cambio
        frmlacteos.setLocationRelativeTo(null);
        frmlacteos.setVisible(true);
    }//GEN-LAST:event_menuContarLacteosActionPerformed

    private void menuAperturaConteoLacteosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAperturaConteoLacteosActionPerformed
        FrmAbrirPeridoConteoLacteos frmLacteos = new FrmAbrirPeridoConteoLacteos();
        //Cambio
        frmLacteos.setLocationRelativeTo(null);
        frmLacteos.setVisible(true);
    }//GEN-LAST:event_menuAperturaConteoLacteosActionPerformed

    private void btnRevisionGuiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevisionGuiasActionPerformed
        FrmPedirBoticaGrupo FrmComp = new FrmPedirBoticaGrupo();
        //Cambio
        FrmComp.setLocationRelativeTo(null);
        FrmComp.setVisible(true);
    }//GEN-LAST:event_btnRevisionGuiasActionPerformed

    private void btnContarMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContarMedicinaActionPerformed
        FrmContarMedicina frmContar = new FrmContarMedicina();
        //Cambio
        frmContar.setLocationRelativeTo(null);
        frmContar.setVisible(true);
    }//GEN-LAST:event_btnContarMedicinaActionPerformed

    private void btnContarLacteosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContarLacteosActionPerformed
        FrmContarLacteos frmlacteos = new FrmContarLacteos();
        //cambio
        frmlacteos.setLocationRelativeTo(null);
        frmlacteos.setVisible(true);
    }//GEN-LAST:event_btnContarLacteosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        FrmProductosAlmacen frmpalma = new FrmProductosAlmacen();
        //Cambio
        frmpalma.setLocationRelativeTo(null);
        frmpalma.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        FrmResumen frmResumen = new FrmResumen();
        frmResumen.setLocationRelativeTo(null);
        frmResumen.setVisible(true);

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        FrmConsultarResumen frm = new FrmConsultarResumen();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void ejecutar(String comando) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(comando);
            p.waitFor();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en en Look and Feel", "Error", ERROR);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMenu() {
                }.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMIEmpleado;
    private javax.swing.JMenuItem JMISalir;
    private javax.swing.JMenuItem JMIUsuario;
    private javax.swing.JMenu JMInicio;
    private javax.swing.JMenu JMMantenimiento;
    private javax.swing.JMenu JMReportes;
    private javax.swing.JMenu JMVenta;
    private javax.swing.JButton btnContarLacteos;
    private javax.swing.JButton btnContarMedicina;
    private javax.swing.JButton btnRevisionGuias;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenu jmActualizarProducto;
    public javax.swing.JLabel lblApUsuariologeado;
    public javax.swing.JLabel lblNomUserlogeado;
    private javax.swing.JMenuItem menuAperturaConteoLacteos;
    private javax.swing.JMenuItem menuAperturaConteoMedicina;
    private javax.swing.JMenuItem menuBoticas;
    private javax.swing.JMenuItem menuCalculadora;
    private javax.swing.JMenuItem menuCargos;
    private javax.swing.JMenuItem menuContarLacteos;
    private javax.swing.JMenuItem menuContarMedicina;
    private javax.swing.JMenuItem menuGrupo;
    private javax.swing.JMenuItem menuGrupoPersonal;
    private javax.swing.JMenuItem menuReportes;
    private javax.swing.JMenuItem menuRevisionGuias;
    // End of variables declaration//GEN-END:variables
}
