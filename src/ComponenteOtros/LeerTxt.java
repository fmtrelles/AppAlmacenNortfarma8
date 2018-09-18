/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteOtros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerTxt {

    String linea = "";
    //private String CadenaLinea;

    public String LeerTexto(String fichero, int nrolinea)
    {
        return null;
        
    }
            
    public static String LeerTexto(String fichero, int nrolinea, String CadenaLinea) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);

        String linea;
        int contarlinea = 0;
        try {
            while ((linea = br.readLine()) != null) {
                contarlinea = contarlinea + 1;
                if (contarlinea == nrolinea) {
                    CadenaLinea=linea;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(LeerTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
        fr.close();
        return CadenaLinea;
    }
}