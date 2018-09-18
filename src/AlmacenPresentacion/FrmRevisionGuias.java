package AlmacenPresentacion;

import AlmacenClases.Boticas;
import AlmacenClases.Grupos;
import AlmacenClases.Guias;
import AlmacenClases.Guias_Detalles;
import AlmacenDatos.DBGuias;
import AlmacenDatos.DBGuias_Detalle;
import AlmacenDatos.DBGuias_Detalle_His;
import ComponenteOtros.FormatoTabla;
import ComponentePresentacion.FrmPanelFondoPrincipal;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class FrmRevisionGuias extends javax.swing.JFrame {

    List<Guias> ListaGuias;
    DefaultTableModel modelo;
    DefaultTableModel modelo2;
    DefaultTableModel ModeloValidar;
    AudioClip sonidoBuscarGuia = Applet.newAudioClip(getClass().getResource("/AlmacenSonidos/buscarguia.wav"));
    AudioClip sonidoProductoCompleto = Applet.newAudioClip(getClass().getResource("/AlmacenSonidos/prodcompleto.wav"));
    AudioClip sonidoProductoIncorrecto = Applet.newAudioClip(getClass().getResource("/AlmacenSonidos/aviso1.wav"));
    AudioClip sonidoErrorCantidad = Applet.newAudioClip(getClass().getResource("/AlmacenSonidos/ErrorCantidad.wav"));

    public FrmRevisionGuias(Boticas b, Grupos g) {
        initComponents();
        try
        {
            UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error en en Look and Feel","Error",ERROR);
        }
        this.setLocationRelativeTo(null);
        FrmPanelFondoPrincipal fondoprinc = new FrmPanelFondoPrincipal();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int sr = Toolkit.getDefaultToolkit().getScreenResolution();
        this.setDefaultCloseOperation(0);
        
        System.out.println("Tamaño de pantalla: " + d.width + "x" + d.height + ", definición: " + sr + " ppp");
        this.setSize(d.width, d.height);
        this.add(fondoprinc, BorderLayout.CENTER);

        this.pack();
        CagarGuias(b, g);
        InicializarTablaDetalleGuias();
        
    }

    private void CagarGuias(Boticas b, Grupos g) {
        //Boticas cDescargo;
        modelo = new DefaultTableModel();
        jGuiasBotica.setModel(modelo);
        modelo = new DefaultTableModel(null, getColumnasGuias()) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        txtBotica.setText(b.getCod_Descargo());
        txtGrupo.setText(String.valueOf(g.getId_Grupos()));
        txtBotica_Descripcion.setText(b.getDescripcion());
        txtGrupo_Descripcion.setText(g.getDescripcion());
        try {
            //cDescargo = DBBoticas.buscarBotica(txtBotica.getText());
            //ListaGuias = DBGuias.mostrarGuias(txtBotica.getText());

            List<Guias> ListaGrupos = DBGuias.mostrarGuias(txtBotica.getText());
            // Guias guiasx = new Guias();
            modelo.setNumRows(ListaGrupos.size());
            for (int i = 0; i < ListaGrupos.size(); i++) { // Recorriendo Los Datos que se Encuentran en el Arraylist
                Guias guiasx = ListaGrupos.get(i);
                modelo.setValueAt(guiasx.getTypmov(), i, 0);
                modelo.setValueAt(guiasx.getDocnum(), i, 1);
                modelo.setValueAt(guiasx.getDocdat(), i, 2);
                //System.out.println(String.valueOf(i)+"--"+guiasx.getTypmov()+"--"+guiasx.getDocnum());
            }
            this.jGuiasBotica.setModel(modelo);
            jGuiasBotica.getColumnModel().getColumn(0).setPreferredWidth(25);
            jGuiasBotica.getColumnModel().getColumn(1).setPreferredWidth(70);
            jGuiasBotica.getColumnModel().getColumn(2).setPreferredWidth(50);

        } catch (SQLException ex) {
            Logger.getLogger(FrmRevisionGuias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CagarDetalle(String Tipo, String Numero) {
        //Boticas cDescargo;
        modelo2 = new DefaultTableModel();
        jDetalleGuia.setModel(modelo2);
        modelo2 = new DefaultTableModel(null, getColumnasDetalle()) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if (columna > 9) {
                    return true;
                }
                return false;
            }
        };
        try {
            //cDescargo = DBBoticas.buscarBotica(txtBotica.getText());
            //ListaGuias = DBGuias.mostrarGuias(txtBotica.getText());

            List<Guias_Detalles> ListaDetalle = DBGuias_Detalle.mostrarGuiasDetalle(Tipo, Numero);
            // Guias guiasx = new Guias();
            modelo2.setNumRows(ListaDetalle.size());
            for (int i = 0; i < ListaDetalle.size(); i++) { // Recorriendo Los Datos que se Encuentran en el Arraylist
                Guias_Detalles guias_d = ListaDetalle.get(i);
                modelo2.setValueAt(guias_d.getCodpro(), i, 0);
                modelo2.setValueAt(guias_d.getProducto(), i, 1);
                modelo2.setValueAt(guias_d.getId_Laboratorio(), i, 2);
                modelo2.setValueAt(guias_d.getEmpaque(), i, 3);
                modelo2.setValueAt(guias_d.getCodbar(), i, 4);
                modelo2.setValueAt(guias_d.getStkprf(), i, 5);
                modelo2.setValueAt(0, i, 6);
                modelo2.setValueAt(guias_d.getEstado(), i, 7);
                //System.out.println(String.valueOf(i)+"--"+guiasx.getTypmov()+"--"+guiasx.getDocnum());
            }
            this.jDetalleGuia.setModel(modelo2);
            columnasGuiaDetalle();



        } catch (SQLException ex) {
            Logger.getLogger(FrmRevisionGuias.class.getName()).log(Level.SEVERE, null, ex);
        }
        InicializarTablaValidar();

    }

    private void CagarDetalle_His(String Tipo, String Numero) {
        //Boticas cDescargo;
        modelo2 = new DefaultTableModel();
        jDetalleGuia.setModel(modelo2);
        modelo2 = new DefaultTableModel(null, getColumnasDetalle()) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if (columna > 9) {
                    return true;
                }
                return false;
            }
        };

        try {
            //cDescargo = DBBoticas.buscarBotica(txtBotica.getText());
            //ListaGuias = DBGuias.mostrarGuias(txtBotica.getText());

            List<Guias_Detalles> ListaDetalle = DBGuias_Detalle_His.mostrarGuiasDetalle_His(Tipo, Numero);
            // Guias guiasx = new Guias();
            modelo2.setNumRows(ListaDetalle.size());
            for (int i = 0; i < ListaDetalle.size(); i++) { // Recorriendo Los Datos que se Encuentran en el Arraylist
                Guias_Detalles guias_h = ListaDetalle.get(i);
                modelo2.setValueAt(guias_h.getCodpro(), i, 0);
                modelo2.setValueAt(guias_h.getProducto(), i, 1);
                modelo2.setValueAt(guias_h.getId_Laboratorio(), i, 2);
                modelo2.setValueAt(guias_h.getEmpaque(), i, 3);
                modelo2.setValueAt(guias_h.getCodbar(), i, 4);
                modelo2.setValueAt(guias_h.getStkprf(), i, 5);
                modelo2.setValueAt(guias_h.getLeido(), i, 6);
                modelo2.setValueAt(guias_h.getEstado(), i, 7);

            }
            this.jDetalleGuia.setModel(modelo2);

           columnasGuiaDetalle();
           
        } catch (SQLException ex) {
            Logger.getLogger(FrmRevisionGuias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] getColumnasGuias() {
        String columna[] = new String[]{"Codigo", "Botica", "Fecha"};
        return columna;
    }

    private String[] getColumnasDetalle() {
        String columna[] = new String[]{"Codigo",
            "Producto",
            "Labora",
            "Empaque",
            "Cod.Barras",
            "Cantidad",
            "Leido",
            ""};
        return columna;
    }

    private String[] getColumnasValidar() {
        String columna[] = new String[]{"Codigo", "Producto"};
        return columna;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtHoraInicio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGrupo_Descripcion = new javax.swing.JTextField();
        txtBotica_Descripcion = new javax.swing.JTextField();
        txtGrupo = new javax.swing.JTextField();
        txtBotica = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jGuiasBotica = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDetalleGuia = new javax.swing.JTable();
        btnValidar = new javax.swing.JButton();
        btnTerminarBotica = new javax.swing.JButton();
        btnTerminarGuia = new javax.swing.JButton();
        btnVerGuia = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jValidar = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroDocumento = new javax.swing.JTextField();
        txtFechaDocumento = new javax.swing.JTextField();
        txtBuscaTipoMovimiento = new javax.swing.JTextField();
        txtBuscaNumero = new javax.swing.JTextField();
        btnBuscarGuiaRevisada = new javax.swing.JButton();
        txtOpcion = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        txtSuma = new javax.swing.JTextField();
        txtHoraGuia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Revision de Guias");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);

        txtHoraInicio.setBackground(new java.awt.Color(0, 0, 102));
        txtHoraInicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtHoraInicio.setForeground(new java.awt.Color(255, 255, 255));
        txtHoraInicio.setEnabled(false);

        jLabel1.setText("Grupo:");

        jLabel2.setText("Botica:");

        jLabel3.setText("Hora Inicio:");

        txtGrupo_Descripcion.setBackground(new java.awt.Color(255, 255, 204));
        txtGrupo_Descripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtGrupo_Descripcion.setForeground(new java.awt.Color(204, 0, 0));
        txtGrupo_Descripcion.setEnabled(false);

        txtBotica_Descripcion.setBackground(new java.awt.Color(255, 255, 204));
        txtBotica_Descripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtBotica_Descripcion.setForeground(new java.awt.Color(204, 0, 0));
        txtBotica_Descripcion.setEnabled(false);

        txtGrupo.setEditable(false);
        txtGrupo.setBackground(new java.awt.Color(255, 255, 204));
        txtGrupo.setForeground(new java.awt.Color(204, 0, 0));
        txtGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrupoActionPerformed(evt);
            }
        });

        txtBotica.setEditable(false);
        txtBotica.setBackground(new java.awt.Color(255, 255, 204));
        txtBotica.setForeground(new java.awt.Color(204, 0, 0));

        jGuiasBotica.setBackground(new java.awt.Color(255, 255, 204));
        jGuiasBotica.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jGuiasBotica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Botica", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jGuiasBotica.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jGuiasBotica);
        jGuiasBotica.getColumnModel().getColumn(0).setMinWidth(10);
        jGuiasBotica.getColumnModel().getColumn(1).setMinWidth(30);
        jGuiasBotica.getColumnModel().getColumn(2).setResizable(false);

        jDetalleGuia.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jDetalleGuia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion Producto", "Laboratorio", "Empaque", "Cantidad", "Revision", "OK", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jDetalleGuia);
        jDetalleGuia.getColumnModel().getColumn(5).setResizable(false);

        btnValidar.setText("Validar");
        btnValidar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        btnTerminarBotica.setText("Terminar Botica");
        btnTerminarBotica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarBoticaActionPerformed(evt);
            }
        });

        btnTerminarGuia.setText("Terminar Guia");
        btnTerminarGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarGuiaActionPerformed(evt);
            }
        });

        btnVerGuia.setText("Ver Guia");
        btnVerGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerGuiaActionPerformed(evt);
            }
        });

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        jLabel4.setText("Cod. de Barras o Cod. Producto");

        jValidar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jValidar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Producto"
            }
        ));
        jScrollPane4.setViewportView(jValidar);
        jValidar.getColumnModel().getColumn(0).setMinWidth(10);
        jValidar.getColumnModel().getColumn(1).setMinWidth(200);

        jLabel5.setText("Numero Doc.");

        jLabel6.setText("Fecha:");

        txtNumeroDocumento.setEditable(false);
        txtNumeroDocumento.setBackground(new java.awt.Color(255, 255, 204));
        txtNumeroDocumento.setForeground(new java.awt.Color(204, 0, 0));

        txtFechaDocumento.setEditable(false);
        txtFechaDocumento.setBackground(new java.awt.Color(255, 255, 204));
        txtFechaDocumento.setForeground(new java.awt.Color(204, 0, 0));

        txtBuscaTipoMovimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaTipoMovimientoKeyReleased(evt);
            }
        });

        txtBuscaNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaNumeroKeyReleased(evt);
            }
        });

        btnBuscarGuiaRevisada.setText("Buscar Guia Revisada");
        btnBuscarGuiaRevisada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarGuiaRevisadaActionPerformed(evt);
            }
        });

        txtOpcion.setEditable(false);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtSuma.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtSuma.setForeground(new java.awt.Color(51, 51, 255));

        txtHoraGuia.setEditable(false);
        txtHoraGuia.setBackground(new java.awt.Color(255, 255, 204));
        txtHoraGuia.setForeground(new java.awt.Color(204, 0, 0));

        jLabel7.setText("Hora Inicio Guia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtGrupo_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(txtBotica, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtBotica_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5)
                                .addGap(4, 4, 4)
                                .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txtFechaDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoraGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(txtSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel4)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBuscaTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtBuscaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(btnBuscarGuiaRevisada))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVerGuia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTerminarGuia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTerminarBotica, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrupo_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBotica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBotica_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtHoraGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))))
                            .addComponent(txtSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel4))
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscarGuiaRevisada)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBuscaTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBuscaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnValidar)
                                    .addComponent(btnVerGuia)
                                    .addComponent(btnTerminarGuia)
                                    .addComponent(btnTerminarBotica))
                                .addGap(6, 6, 6)
                                .addComponent(btnSalir))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrupoActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        ModeloValidar = new DefaultTableModel();
        jValidar.setModel(ModeloValidar);
        ModeloValidar = new DefaultTableModel(null, getColumnasValidar()) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if (columna > 9) {
                    return true;
                }
                return false;
            }
        };
        ModeloValidar.setNumRows(40);
        int fil, filaValidar = 0;
        String valorfijo, CantidadLeida;
        //Limpia selección de la tabla
        jDetalleGuia.clearSelection();
        for (fil = 0; fil < jDetalleGuia.getRowCount(); fil++) {
            //Selecciona celda si el texto es encontrado   
            CantidadLeida = jDetalleGuia.getValueAt(fil, 6).toString().trim();
            valorfijo = jDetalleGuia.getValueAt(fil, 5).toString().trim();
            if (valorfijo.equals(CantidadLeida)) {
                //JOptionPane.showMessageDialog(null, " [ El producto ya esta completo ]");
            } else {
                System.out.println(fil + "-----" + filaValidar);
                ModeloValidar.setValueAt(jDetalleGuia.getValueAt(fil, 0).toString(), filaValidar, 0);
                ModeloValidar.setValueAt(jDetalleGuia.getValueAt(fil, 1).toString(), filaValidar, 1);
                filaValidar = filaValidar + 1;
            }
        }
        
        jValidar.changeSelection(1, 1, false, false);
        jValidar.setModel(ModeloValidar);
        jValidar.getColumnModel().getColumn(0).setPreferredWidth(10);
        jValidar.getColumnModel().getColumn(1).setPreferredWidth(200);
    }//GEN-LAST:event_btnValidarActionPerformed

    private void btnVerGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerGuiaActionPerformed



        if (this.jDetalleGuia.getRowCount() == 0) {
            NuevaGuia();
            //InicializarTablaValidar();
            txtCodigo.requestFocusInWindow();
        } else {
            if (RevisarDetalle() == false) {
                int seleccion = JOptionPane.showOptionDialog(null,
                        "Hay una guia sin terminar.¿Cambiar guia de todas formas?",
                        "Selector de opciones",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Si", "No"}, "Si");
                //JOptionPane.showMessageDialog(null, seleccion);
                switch (seleccion) {
                    case 0:
                        NuevaGuia();
                        //InicializarTablaValidar();
                        txtCodigo.requestFocusInWindow();
                        break;
                    case 1:
                        break;
                }
            }
        }
        int SumaTodoGuia = SumarDetalle();
        txtSuma.setText(String.valueOf(SumaTodoGuia));
        txtSuma.repaint();
    }//GEN-LAST:event_btnVerGuiaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        int filtro = 0;
        if (txtCodigo.getText().trim().length() > 5) {
            filtro = 1;
        } else {
            filtro = 0;
        }
        BuscarProductoenGuia(filtro);
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnTerminarBoticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarBoticaActionPerformed

        if (RevisarDetalle() == false) {

            int seleccion = JOptionPane.showOptionDialog(null,
                    "La guia esta sin terminar.",
                    "Selector de opciones",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Continuar"}, "Continuar");

        } else {
            int seleccion = JOptionPane.showOptionDialog(null,
                    "Antes de cerrar la revision de la botica actual\n debera "
                  + "confirmar que las demas maquinas del grupo \n tambien han "
                  + "terminado. \n ¿Seguro de cerrar la revision de esta botica?",
                    "Selector de opciones",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Si", "No"}, "Si");
            if (seleccion == 0) {
                JDDatosCierreBotica jdCierreBotica = new JDDatosCierreBotica(new javax.swing.JDialog(), true, Integer.parseInt(txtGrupo.getText()));
                jdCierreBotica.txtBotica.setText(txtBotica.getText());
                jdCierreBotica.txtGrupo.setText(txtGrupo.getText());
                jdCierreBotica.txtDescripcionBotica.setText(txtBotica_Descripcion.getText());
                jdCierreBotica.txtDescripcionGrupo.setText(txtGrupo_Descripcion.getText());
                jdCierreBotica.txtHora_Inicio.setText(txtHoraInicio.getText());

                jdCierreBotica.setVisible(true);
                if (jdCierreBotica.Finalizar == 1) {
                    dispose();
                    FrmPedirBoticaGrupo FrmComp = new FrmPedirBoticaGrupo();
                    FrmComp.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_btnTerminarBoticaActionPerformed

    private void btnTerminarGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarGuiaActionPerformed

        if (RevisarDetalle() == false) {
            //JOptionPane.showMessageDialog(null, "La guia aun no esta terminada.DESEA GUARDARLA DE TODAS FORMAS?");
            int seleccion = JOptionPane.showOptionDialog(null,
                    "La guia aun no esta terminada.DESEA GUARDARLA DE TODAS FORMAS?",
                    "Selector de opciones",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Si", "No"}, "Si");
            //JOptionPane.showMessageDialog(null, seleccion);
            switch (seleccion) {
                case 0:

                    GuardarGuia(0);
                    InicializarTablaValidar();

                    break;
                case 1:
                    break;
            }
        } else {
            int seleccion = JOptionPane.showOptionDialog(null,
                    "Guadar guia revisada",
                    "Selector de opciones",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Si", "No"}, "Si");
            //JOptionPane.showMessageDialog(null, seleccion);
            switch (seleccion) {
                case 0:
                    int seleccion1 = JOptionPane.showOptionDialog(null,
                            "¿Seguro guardar la revision de esta guia?",
                            "Selector de opciones",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[]{"Si", "No"}, "Si");
                    if (seleccion1 == 0) {
                        JDDatosCierreGuia jdCierreGuia = new JDDatosCierreGuia(new javax.swing.JDialog(), true);
                        jdCierreGuia.txtBotica.setText(txtBotica.getText());
                        jdCierreGuia.txtGrupo.setText(txtGrupo.getText());
                        jdCierreGuia.txtDescripcionBotica.setText(txtBotica_Descripcion.getText());
                        jdCierreGuia.txtDescripcionGrupo.setText(txtGrupo_Descripcion.getText());
                        jdCierreGuia.txtHora_Inicio.setText(txtHoraGuia.getText());

                        jdCierreGuia.setVisible(true);
                        if (jdCierreGuia.UltimoId != 0) {
                            //   dispose();
                            //   FrmPedirBoticaGrupo FrmComp = new FrmPedirBoticaGrupo();
                            //   FrmComp.setVisible(true);
                            GuardarGuia(jdCierreGuia.UltimoId);
                            InicializarTablaValidar();
                        }
                    }

                    break;
                case 1:
                    break;
            }
        }

    }//GEN-LAST:event_btnTerminarGuiaActionPerformed

    private void btnBuscarGuiaRevisadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarGuiaRevisadaActionPerformed

        String strTipoMov = txtBuscaTipoMovimiento.getText().trim();
        String strTipoDoc = txtBuscaNumero.getText().trim();
        List<Guias> DatosGuiaRevisada;
        try {
            DatosGuiaRevisada = DBGuias_Detalle_His.buscarGuias_His(strTipoMov, strTipoDoc);
            for (int r = 0; r < DatosGuiaRevisada.size(); r++) {
                Guias dato_guia = DatosGuiaRevisada.get(r);
                txtNumeroDocumento.setText(strTipoDoc);
                txtFechaDocumento.setText(dato_guia.getDocdat());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmRevisionGuias.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtOpcion.setText("1");
        CagarDetalle_His(strTipoMov, strTipoDoc);
    }//GEN-LAST:event_btnBuscarGuiaRevisadaActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        txtCodigo.setText(txtCodigo.getText().toUpperCase());
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtBuscaTipoMovimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaTipoMovimientoKeyReleased
        txtBuscaTipoMovimiento.setText(txtBuscaTipoMovimiento.getText().toUpperCase());
    }//GEN-LAST:event_txtBuscaTipoMovimientoKeyReleased

    private void txtBuscaNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNumeroKeyReleased
        txtBuscaNumero.setText(txtBuscaNumero.getText().toUpperCase());
    }//GEN-LAST:event_txtBuscaNumeroKeyReleased

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (this.jDetalleGuia.getRowCount() == 0) {
            dispose();
        } else {
            if (RevisarDetalle() == false) {
                int seleccion = JOptionPane.showOptionDialog(null,
                        "Hay una guia sin terminar.¿Salir de todas formas?",
                        "Selector de opciones",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Si", "No"}, "Si");
                //JOptionPane.showMessageDialog(null, seleccion);
                switch (seleccion) {
                    case 0:
                        dispose();
                        break;
                    case 1:
                        break;
                }
                //JOptionPane.showMessageDialog(null, "Debe terminar de revisar la guias y guardar antes de salir");
            } else {
                int seleccion = JOptionPane.showOptionDialog(null,
                        "La guia ya esta terminada. ¿Salir de todas formas?",
                        "Selector de opciones",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Si", "No"}, "Si");
                //JOptionPane.showMessageDialog(null, seleccion);
                switch (seleccion) {
                    case 0:
                        dispose();
                        break;
                    case 1:
                        break;
                }
            }
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void BuscarProductoenGuia(int i) {
        String cod = txtCodigo.getText();
        boolean Encontrado = true;
        sonidoProductoIncorrecto.stop();
        if (i == 1) {
            Encontrado = BuscarporCodigoBarras(cod);
        } else {
            Encontrado = BuscarporCodigoProducto(cod);
        }
        txtCodigo.setText("");
        if (Encontrado == false) {
            sonidoProductoIncorrecto.play();
        }
    }

    private boolean BuscarporCodigoBarras(String cod) {
        int fil, col;
        boolean Encontro = true;
        int contar = 0;
        int CantidadLeida_Original, cantidad;
        String valorfijo, CantidadLeida, CantidadFinal, valorFinal;
        //Limpia selección de la tabla
        jDetalleGuia.clearSelection();
        for (fil = 0; fil < jDetalleGuia.getRowCount(); fil++) {
            //Obtiene dato contenido en una celda de la tabla
            String CantidadGuia = (String) jDetalleGuia.getValueAt(fil, 4);
            String CantidadRevisar = (String) jDetalleGuia.getValueAt(fil, 5);
            if (CantidadRevisar.toString().toUpperCase().substring(0, 1).equals("F")) {
                JOptionPane.showMessageDialog(null, " [ No se puede revisar producto en guia ]");
            } else {
                
                if (CantidadGuia.trim().equals(cod.trim())) {
                    //Selecciona celda si el texto es encontrado   
                    contar = contar + 1;
                    CantidadLeida = jDetalleGuia.getValueAt(fil, 6).toString().trim();
                    valorfijo = jDetalleGuia.getValueAt(fil, 5).toString().trim();
                    if (valorfijo.equals(CantidadLeida)) {
                        sonidoProductoCompleto.play();
                        JOptionPane.showMessageDialog(null, " [ El producto ya esta completo ]");

                    } else {

                        if (Integer.valueOf(valorfijo, 10) >= 50) {
                            CantidadLeida_Original = Integer.parseInt(valorfijo.trim(), 10);
                            CantidadLeida = JOptionPane.showInputDialog(null,
                                    "Ingrese la cantidad de productos :", valorfijo);
                            
                            cantidad = Integer.parseInt(CantidadLeida);
                        } else {
                            cantidad = Integer.parseInt(CantidadLeida) + 1;
                        }
                        
                        jDetalleGuia.changeSelection(fil, 6, false, false);
                        jDetalleGuia.setValueAt(cantidad, fil, 6);
                        jDetalleGuia.changeSelection(fil, 6, false, false);
                        jDetalleGuia.setValueAt("1", fil, 7);
                        CantidadFinal = jDetalleGuia.getValueAt(fil, 6).toString().trim();
                        valorFinal = jDetalleGuia.getValueAt(fil, 5).toString().trim();
                        if (valorFinal.equals(CantidadFinal)) {
                            jDetalleGuia.changeSelection(fil, 6, false, false);
                            jDetalleGuia.setValueAt("2", fil, 7);
                        }
                    }
                }
                
            }
        }
        System.out.println("CodigoBarras:"+contar);
        if (contar > 0) {
            Encontro = true;
            
        } else {
            Encontro = false;
            
        }
        contar=0;
        return Encontro;
    }

    private boolean BuscarporCodigoProducto(String cod) {
        int fil, col, contar = 0;
        boolean Encontro = true;

        String valorfijo, CantidadLeida, CantidadFinal, valorFinal;
        int CantidadLeida_Original = 0;
        //Limpia selección de la tabla
        jDetalleGuia.clearSelection();
        for (fil = 0; fil < jDetalleGuia.getRowCount(); fil++) {
            //Obtiene dato contenido en una celda de la tabla
            String CantidadGuia = (String) jDetalleGuia.getValueAt(fil, 0);
            String CantidadRevisar = (String) jDetalleGuia.getValueAt(fil, 5);
            if (CantidadRevisar.toString().toUpperCase().substring(0, 1).equals("F")) {
                JOptionPane.showMessageDialog(null, " [ No se puede revisar producto en guia ]");
            } else {
                if (CantidadGuia.equals(cod)) {
                    contar = contar + 1;
                    //Selecciona celda si el texto es encontrado   
                    CantidadLeida = jDetalleGuia.getValueAt(fil, 6).toString().trim();
                    valorfijo = jDetalleGuia.getValueAt(fil, 5).toString().trim();
                    if (valorfijo.equals(CantidadLeida)) {
                        sonidoProductoCompleto.play();
                        JOptionPane.showMessageDialog(null, " [ El producto ya esta completo ]");

                    } else {
                        CantidadLeida_Original = Integer.parseInt(valorfijo.trim(), 10);
                        CantidadLeida = JOptionPane.showInputDialog(null,
                                "Ingrese la cantidad de productos :", valorfijo);

                        if (CantidadLeida_Original!=Integer.parseInt(CantidadLeida))
                        {
                            sonidoErrorCantidad.play();
                            JOptionPane.showMessageDialog(null, " [ La cantidad del producto esta equivocado ]");
                        }else
                        {
                        
                        jDetalleGuia.changeSelection(fil, 6, false, false);
                        jDetalleGuia.setValueAt(CantidadLeida_Original, fil, 6);
                        jDetalleGuia.changeSelection(fil, 6, false, false);
                        jDetalleGuia.setValueAt("1", fil, 7);
                        CantidadFinal = jDetalleGuia.getValueAt(fil, 6).toString().trim();
                        valorFinal = jDetalleGuia.getValueAt(fil, 5).toString().trim();
                        if (valorFinal.equals(CantidadFinal)) {
                            jDetalleGuia.changeSelection(fil, 6, false, false);
                            jDetalleGuia.setValueAt("2", fil, 7);
                        }
                        }
                    }
                }
            }
        }
        System.out.println("CodigoProducto:"+contar);
        if (contar > 0) {
            Encontro = true;
        } else {
            Encontro = false;
        }
        contar=0;
        return Encontro;

    }

    private void InicializarTablaDetalleGuias() {

        modelo2 = new DefaultTableModel();
        jDetalleGuia.setModel(modelo2);
        modelo2 = new DefaultTableModel(null, getColumnasDetalle()) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if (columna > 9) {
                    return true;
                }
                return false;
            }
        };
        this.jDetalleGuia.setModel(modelo2);
        FormatoTabla ft = new FormatoTabla(7);
        jDetalleGuia.setDefaultRenderer(Object.class, ft);
    }

    public void InicializarTablaValidar() {
        ModeloValidar = new DefaultTableModel();
        jValidar.setModel(ModeloValidar);
        ModeloValidar = new DefaultTableModel(null, getColumnasValidar()) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                /*if (columna > 9) {
                 return true;
                 }*/
                return false;
            }
        };
        ModeloValidar.setNumRows(40);
        this.jValidar.setModel(ModeloValidar);
        //FormatoTabla ft = new FormatoTabla(7);
        //jValidar.setDefaultRenderer(Object.class, ft);
    }

    public boolean RevisarDetalle() {
        int fil, contar = 0;
        boolean Encontro = true;

        //Limpia selección de la tabla
        jDetalleGuia.clearSelection();
        for (fil = 0; fil < jDetalleGuia.getRowCount(); fil++) {
            //Obtiene dato contenido en una celda de la tabla
            String EstadoProducto = jDetalleGuia.getValueAt(fil, 7).toString().trim();
            System.out.println(EstadoProducto.compareTo("2"));
            if (EstadoProducto.compareTo("2") != 0) {
                contar++;
            }
        }
        if (contar > 0) {
            Encontro = false;
        } else {
            Encontro = true;
        }

        return Encontro;
    }

    public int SumarDetalle() {
        int fil;
        int SumaProducto = 0;
        String CantidadProducto;
        //Limpia selección de la tabla
        jDetalleGuia.clearSelection();
        for (fil = 0; fil < jDetalleGuia.getRowCount(); fil++) {
            //Obtiene dato contenido en una celda de la tabla
            CantidadProducto = jDetalleGuia.getValueAt(fil, 5).toString().trim();
            if (CantidadProducto.substring(0, 1).equals("F")) {
                CantidadProducto = "0";
            }

            SumaProducto = SumaProducto + Integer.parseInt(CantidadProducto);
            //System.out.println(EstadoProducto.compareTo("2"));
        }
        return SumaProducto;
    }

    public void NuevaGuia() {
        int registro = jGuiasBotica.getSelectedRow();
        String strTipoMov = modelo.getValueAt(registro, 0).toString();
        String strTipoDoc = modelo.getValueAt(registro, 1).toString();
        String strFechaDoc = modelo.getValueAt(registro, 2).toString();
        txtHoraGuia.setText(ActualizarHora());
        txtNumeroDocumento.setText(strTipoDoc);
        txtFechaDocumento.setText(strFechaDoc);
        CagarDetalle(strTipoMov, strTipoDoc);
        txtOpcion.setText("0");
        //sonidoBuscarGuia.play();
    }

    public void GuardarGuia(int uid) {
        int ResultadoIns = 0;
        boolean EliminoCorrectamente = true;
        //int jDatosGuias =jDetalleGuia.getSelectedRow();
        jDetalleGuia.getSelectionModel().setSelectionInterval(1, 1);
        if (this.jDetalleGuia.getRowCount() != 0 && this.jDetalleGuia.getSelectedRow() != -1) {
            //if (jDatosGuias != -1) {
            if (txtOpcion.getText().trim().compareTo("0") != 0) {
                try {
                    EliminoCorrectamente = DBGuias_Detalle_His.eliminarGuias_His(txtBotica.getText().trim(), txtNumeroDocumento.getText().trim());
                } catch (SQLException ex) {
                    Logger.getLogger(FrmRevisionGuias.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (EliminoCorrectamente == false) {
                JOptionPane.showMessageDialog(null, "Error en la actualizacion en la informacion.");
            } else {
                Guias_Detalles dg = new Guias_Detalles() {
                };
                try {
                    //if (ResultadoIns > 0) {
                    Guias cg = new Guias();
                    cg.setCodalm("A");
                    cg.setTypmov(txtBotica.getText().toString().trim());
                    cg.setCodprv("ZZZZ");
                    cg.setDocnum(txtNumeroDocumento.getText().trim());
                    cg.setDocdat(txtFechaDocumento.getText().trim());
                    cg.setDatreg(txtFechaDocumento.getText().trim());
                    cg.setId_Revision(uid);
                    DBGuias_Detalle_His.insertarGuias_His(cg);
                    for (int fil = 0; fil < jDetalleGuia.getRowCount(); fil++) {
                        try {
                            dg.setTypmov(txtBotica.getText().toString().trim());
                            dg.setDocnum(txtNumeroDocumento.getText().toString().trim());

                            //dg.setProducto(DBProductos.buscarProductos(jDetalleGuia.getValueAt(fil, 0).toString()));
                            dg.setProducto(jDetalleGuia.getValueAt(fil, 1).toString());
                            dg.setCodpro(jDetalleGuia.getValueAt(fil, 0).toString());
                            dg.setId_Laboratorio(jDetalleGuia.getValueAt(fil, 2).toString());
                            dg.setCodbar(jDetalleGuia.getValueAt(fil, 4).toString());
                            dg.setEmpaque(Integer.parseInt(jDetalleGuia.getValueAt(fil, 3).toString()));
                            dg.setStkprf(jDetalleGuia.getValueAt(fil, 5).toString());
                            dg.setLeido(jDetalleGuia.getValueAt(fil, 6).toString());
                            dg.setEstado(Integer.parseInt(jDetalleGuia.getValueAt(fil, 7).toString()));
                            dg.setId_Revision(uid);
                            ResultadoIns = DBGuias_Detalle_His.insertarGuias_Detalle_His(dg);

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error BD: " + ex.getMessage());
                        }
                    }
                    //} else {
                    //    JOptionPane.showMessageDialog(null, "Error BD: No se pudo agregar la guia");
                    //}
                    //JOptionPane.showMessageDialog(null, "Datos Agregados Correctamente");
                    InicializarTablaDetalleGuias();
                } catch (SQLException ex2) {
                    JOptionPane.showMessageDialog(null, "Error BD: " + ex2.getMessage());
                }

                //this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila del detalle de la guia... OK");
        }
    }

    private String ActualizarHora() {
        Date HoraActualGuia = new Date();
        String horaactual = Integer.toString(HoraActualGuia.getHours()) + ":" + Integer.toString(HoraActualGuia.getMinutes()) + ":" + Integer.toString(HoraActualGuia.getSeconds());
        return horaactual;
    }

    private void columnasGuiaDetalle() {
        jDetalleGuia.getColumnModel().getColumn(0).setPreferredWidth(10);
        jDetalleGuia.getColumnModel().getColumn(1).setPreferredWidth(200);
        jDetalleGuia.getColumnModel().getColumn(2).setPreferredWidth(10);
        jDetalleGuia.getColumnModel().getColumn(3).setPreferredWidth(10);
        jDetalleGuia.getColumnModel().getColumn(4).setPreferredWidth(80);
        jDetalleGuia.getColumnModel().getColumn(5).setPreferredWidth(20);
        jDetalleGuia.getColumnModel().getColumn(6).setPreferredWidth(20);
        jDetalleGuia.getColumnModel().getColumn(7).setPreferredWidth(0);
        jDetalleGuia.getColumnModel().getColumn(7).setMaxWidth(0);
        jDetalleGuia.getColumnModel().getColumn(7).setMinWidth(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarGuiaRevisada;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTerminarBotica;
    private javax.swing.JButton btnTerminarGuia;
    private javax.swing.JButton btnValidar;
    private javax.swing.JButton btnVerGuia;
    private javax.swing.JTable jDetalleGuia;
    private javax.swing.JTable jGuiasBotica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jValidar;
    public javax.swing.JTextField txtBotica;
    public javax.swing.JTextField txtBotica_Descripcion;
    private javax.swing.JTextField txtBuscaNumero;
    private javax.swing.JTextField txtBuscaTipoMovimiento;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFechaDocumento;
    public javax.swing.JTextField txtGrupo;
    public javax.swing.JTextField txtGrupo_Descripcion;
    private javax.swing.JTextField txtHoraGuia;
    public javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtNumeroDocumento;
    private javax.swing.JTextField txtOpcion;
    private javax.swing.JTextField txtSuma;
    // End of variables declaration//GEN-END:variables
}
