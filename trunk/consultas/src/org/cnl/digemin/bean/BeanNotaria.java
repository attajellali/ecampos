package org.cnl.digemin.bean;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * Bean que representa a cada Notaria del Colegio de Notarios de Lima y al mismo Colegio.</br>
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC</br>
 * Convenio DIGEMIN - CNL</br>
 * @author Elvis Ruben Campos Mori
 * @since MAYO 2009
 * @version 2.0
 */
public class BeanNotaria implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**Codigo de la Notar�a*/
    private Long ncodigo;
    /**Nombre de la Notar�a*/
    private String snombre;
    /**Direcci�n de la Notar�a*/
    private String sdireccion;
    /**Nombre del Notario due�o de la Notar�a*/
    private String nnotario;
    /**N�mero de tel�fono de la notar�a*/
    private String stelefono;
    /**N�mero de Fax de la Notar�a*/
    private String sfax;
    /**E-mail oficial de la Notar�a*/
    private String semail;
    /**Cantidad de usuarios que tiene la Notaria*/
    private Long nusuarios;
    /***Colegio asociado*/
    private BeanColegio colegio;
    /***codigo de colegio*/
    private Long ncolegio;
    
    public BeanColegio getColegio() {
		return colegio;
	}

	public void setColegio(BeanColegio colegio) {
		this.colegio = colegio;
	}

	public BeanNotaria(){
      
    }
    
    public BeanNotaria(Long ncodigo,String snombre){
        this.ncodigo=ncodigo;
        this.snombre=snombre;
    }
    
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }
    public String getSnombre() {
        return snombre;
    }
    public void setSdireccion(String sdireccion) {
        this.sdireccion = sdireccion;
    }
    public String getSdireccion() {
        return sdireccion;
    }
    public void setNnotario(String nnotario) {
        this.nnotario = nnotario;
    }
    public String getNnotario() {
        return nnotario;
    }
    public void setStelefono(String stelefono) {
        this.stelefono = stelefono;
    }
    public String getStelefono() {
        return stelefono;
    }
    public void setSfax(String sfax) {
        this.sfax = sfax;
    }
    public String getSfax() {
        return sfax;
    }
    public void setSemail(String semail) {
        this.semail = semail;
    }
    public String getSemail() {
        return semail;
    }
    public void setNcodigo(Long ncodigo) {
        this.ncodigo = ncodigo;
    }
    public Long getNcodigo() {
        return ncodigo;
    }
    public void setNusuarios(Long nusuarios) {
        this.nusuarios = nusuarios;
    }
    public Long getNusuarios() {
        return nusuarios;
    }
	public Long getNcolegio() {
		return ncolegio;
	}
	public void setNcolegio(Long ncolegio) {
		this.ncolegio = ncolegio;
	}
   
}
