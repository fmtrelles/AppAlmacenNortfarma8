/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponenteDatos;

import ComponenteOtros.LeerTxt;
import ComponentePresentacion.FrmMenu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public abstract class BD {
     public static Connection getConnection() {
         String valor_url = null;
            String valor_use = null;
            String valor_pss = null;
            
        Connection cn = null;
        try {
            valor_url=LeerTxt.LeerTexto("configalma.txt",1,"");
            valor_use=LeerTxt.LeerTexto("configalma.txt",2,"");
            valor_pss=LeerTxt.LeerTexto("configalma.txt",3,"");
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se encontró el archivo: "+ex);
        } catch (IOException ex) {
            //Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar: "+ex);
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //String url = "jdbc:mysql://localhost:3306/bdsistema";
            //String url = "jdbc:mysql://10.10.1.11:3306/ALMACENNORTFARMA";
            String url = "jdbc:mysql://"+valor_url+":3306/almacennortfarma";
            String user = valor_use;
            String password = valor_pss;
            cn= DriverManager.getConnection(url, user, password);
            //System.out.println(valor_url);
            //System.out.println(valor_use);
            //System.out.println(valor_pss);
            //System.out.println(cn);
        } catch (ClassNotFoundException e) {
            cn=null;
            System.out.println("Error no se puede cargar el driver:" + e.getMessage());
        } catch (SQLException e) {
            cn=null;
            if(e.getErrorCode() == 0)
            {
                JOptionPane.showMessageDialog(null, "El servidor de base de datos no responde.\n"
                                                    + "Verifique que el servidor de base de datos este activo.\n"
                                                    + "También Verifique que exista la base de datos bdsistemas", 
                                                    "Error: Coneccion Fallida.", JOptionPane.ERROR_MESSAGE);
            }
        }
        return cn;
    }
}
