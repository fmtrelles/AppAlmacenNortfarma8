/**
 * 
 */
package AlmacenClases;

import java.sql.Date;



/**
 * @author miguel
 * 
 */
public class Guias {
	private String codalm;
	private String typmov;
	private String codprv;
	private String docnum;
	private String docdat;
	private String datreg;
        private int Id_Revision;
	

	public String getCodalm() {
		return codalm;
	}

	public void setCodalm(String codalm) {
		this.codalm = codalm;
	}

	public String getTypmov() {
		return typmov;
	}

	public void setTypmov(String typmov) {
		this.typmov = typmov;
	}

	public String getCodprv() {
		return codprv;
	}

	public void setCodprv(String codprv) {
		this.codprv = codprv;
	}

	public String getDocnum() {
		return docnum;
	}

	public void setDocnum(String docnum) {
		this.docnum = docnum;
	}

	public String getDocdat() {
		return docdat;
	}

	public void setDocdat(String docdat) {
		this.docdat = docdat;
	}

	public String getDatreg() {
		return datreg;
	}

	public void setDatreg(String datreg) {
		this.datreg = datreg;
	}
        
        public int getId_Revision() {
            return Id_Revision;
        }
        
        public void setId_Revision(int Id_Revision) {
            this.Id_Revision = Id_Revision;
        }

}
