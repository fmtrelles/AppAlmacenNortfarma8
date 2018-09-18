/**
 * 
 */
package AlmacenClases;

/**
 * @author miguel
 * 
 */
public class Productos {
	private String Id_Producto;
	private String Id_Laboratorio;
	private String Descripcion;
	private int Empaque;
        private double EmpaqueSubir;
	private String Codigo_Barras;
        private String Codigo_Barras2;
        private int EstadoProducto;
        private int Stktod;
        private int Stktod_m;
        private int Stkalm;
        private int Stkalm_m;
        private int Stkmos;
        private int Stkmos_m;
        
    public String getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(String Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public String getId_Laboratorio() {
        return Id_Laboratorio;
    }

    public void setId_Laboratorio(String Id_Laboratorio) {
        this.Id_Laboratorio = Id_Laboratorio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getEmpaque() {
        return Empaque;
    }

    public void setEmpaque(int Empaque) {
        this.Empaque = Empaque;
    }

    public String getCodigo_Barras() {
        return Codigo_Barras;
    }

    public void setCodigo_Barras(String Codigo_Barras) {
        this.Codigo_Barras = Codigo_Barras;
    }

    public String getCodigo_Barras2() {
        return Codigo_Barras2;
    }

    public void setCodigo_Barras2(String Codigo_Barras2) {
        this.Codigo_Barras2 = Codigo_Barras2;
    }

    public int getEstadoProducto() {
        return EstadoProducto;
    }

    public void setEstadoProducto(int EstadoProducto) {
        this.EstadoProducto = EstadoProducto;
    }

    public double getEmpaqueSubir() {
        return EmpaqueSubir;
    }

    public void setEmpaqueSubir(double EmpaqueSubir) {
        this.EmpaqueSubir = EmpaqueSubir;
    }

    /**
     * @return the Stktod
     */
    public int getStktod() {
        return Stktod;
    }

    /**
     * @param Stktod the Stktod to set
     */
    public void setStktod(int Stktod) {
        this.Stktod = Stktod;
    }

    /**
     * @return the Stktod_m
     */
    public int getStktod_m() {
        return Stktod_m;
    }

    /**
     * @param Stktod_m the Stktod_m to set
     */
    public void setStktod_m(int Stktod_m) {
        this.Stktod_m = Stktod_m;
    }

    /**
     * @return the Stkalm
     */
    public int getStkalm() {
        return Stkalm;
    }

    /**
     * @param Stkalm the Stkalm to set
     */
    public void setStkalm(int Stkalm) {
        this.Stkalm = Stkalm;
    }

    /**
     * @return the Stkalm_m
     */
    public int getStkalm_m() {
        return Stkalm_m;
    }

    /**
     * @param Stkalm_m the Stkalm_m to set
     */
    public void setStkalm_m(int Stkalm_m) {
        this.Stkalm_m = Stkalm_m;
    }

    /**
     * @return the Stkmos
     */
    public int getStkmos() {
        return Stkmos;
    }

    /**
     * @param Stkmos the Stkmos to set
     */
    public void setStkmos(int Stkmos) {
        this.Stkmos = Stkmos;
    }

    /**
     * @return the Stkmos_m
     */
    public int getStkmos_m() {
        return Stkmos_m;
    }

    /**
     * @param Stkmos_m the Stkmos_m to set
     */
    public void setStkmos_m(int Stkmos_m) {
        this.Stkmos_m = Stkmos_m;
    }
	

}
