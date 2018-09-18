/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenPresentacion;

import ComponenteOtros.LeerDBF;
import ComponenteOtros.LeerTxt;
import ComponenteOtros.MailClient;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import jxl.common.Logger;

/**
 *
 * @author jsarango
 */
public class ActualizarInformacion{

    static final Logger log = Logger.getLogger(ActualizarInformacion.class);
    
    public ActualizarInformacion() {
        //initComponents();
         try {
            ActualizarTodo();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(ActualizarInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ActualizarInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.exit(0);
    }

    
    public static void ActualizarTodo() throws FileNotFoundException, IOException
    {
        boolean resultado = false;
        String NombreTablaProductos = LeerTxt.LeerTexto("configalma.txt", 12, null);
        String NombreTablaCabecera = LeerTxt.LeerTexto("configalma.txt", 13, null);
        String NombreTablaDetalle = LeerTxt.LeerTexto("configalma.txt", 14, null);
        String NombreTablaProductosAlmacen = LeerTxt.LeerTexto("configalma.txt", 15, null);

        try {
           if (LeerDBF.LeerDBFProductos(NombreTablaProductos) == true) {
              log.info("PRODUCTOS ACTALIZADOS");
              } else {
              log.info("ERROR EN ACTUALIZAR PRODUCTOS");
              }
              if (LeerDBF.LeerDBFCabeceras(NombreTablaCabecera) == true) {
              log.info("CABECERA DE GUIAS ACTUALIZADAS");
              } else {
              log.info("ERROR GENERAR CABECERA DE GUIAS");
              }
            if (LeerDBF.LeerDBFDetalle(NombreTablaDetalle)) {
                resultado = true;
                log.info("DETALLE DE GUIAS ACTUALIZADAS");
            } else {
                log.info("ERROR AL GENERAR DETALLE DE GUIAS");
            }
            if (LeerDBF.LeerDBFProductosAlmacen(NombreTablaProductosAlmacen)) {
                resultado = true;
                log.info("PRODUCTOS ALMACEN ACTUALIZADO");
            } else {
                log.info("ERROR AL GENERAR PRODUCTOS ALMACEN");
            }
            log.info("PROCESO TERMINADO");
            if (resultado) {
                String correo = "informatica@nortfarma.com.pe";
                MailClient objmail = new MailClient();
                objmail.sendMail(correo, " INFORMACION DE ALMACEN ",
                        " GUIAS ENVIADAS CORRECTAMENTE ");
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            System.out.println(e.getMessage());
       }
    }
   
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ActualizarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ActualizarInformacion frame = new ActualizarInformacion();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   
}
