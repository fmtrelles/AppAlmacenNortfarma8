/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteClase;

/**
 *
 * @author Richard
 */
public abstract class Empleado {

    private String dni;
    private String nombre;
    private String Apellido;
    

    /**
     * @return the nroEmpleado
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the email
     */
 
}
