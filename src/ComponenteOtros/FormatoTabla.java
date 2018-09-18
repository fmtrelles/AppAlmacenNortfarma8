/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteOtros;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoTabla extends DefaultTableCellRenderer {

    private int columna_patron;
    //private int fila_patron;

    public FormatoTabla(int Colpatron) {
        this.columna_patron = Colpatron;
        //this.fila_patron = Rowpatron;
    
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        setBackground(Color.white);//color de fondo
        table.setForeground(Color.black);//color de texto
        //Si la celda corresponde a una fila con estado FALSE, se cambia el color de fondo a rojo
        
        //System.out.println("C:"+columna_patron+"   F:"+fila_patron+"--"+table.getValueAt(fila_patron, columna_patron).toString());
        if (table.getValueAt(row, columna_patron).equals("0")) {
            setBackground(Color.white);
        }
        if (table.getValueAt(row, columna_patron).equals("1")) {
            setBackground(Color.pink);
        }
        if (table.getValueAt(row, columna_patron).equals("2")) {
            setBackground(Color.yellow);
        }
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }
    
    /*public void PintarTabla(JTable table,int Rowpatron, int Colpatron)
     * {
     * System.out.println("C:"+Colpatron+"   F:"+Rowpatron+"--"+table.getValueAt(Rowpatron, Colpatron).toString());
     * if (table.getValueAt(Rowpatron, Colpatron).equals("1")) {
     * 
     * table.getSelectedRow();
     * setBackground(Color.pink);
     * }
     * 
     * }*/
}
