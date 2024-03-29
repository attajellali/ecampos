/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t022accionista")
public class T022accionista implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ACCIONISTA")
    private Integer idAccionista;
    @Basic(optional = false)
    @Column(name = "COD_TIPDOC")
    private String codTipdoc;
    @Basic(optional = false)
    @Column(name = "NUM_DOCUM")
    private String numDocum;
    @Basic(optional = false)
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    //@Basic(optional = false)
    @Column(name = "IND_APORTE")
    private String indAporte;
    //@Basic(optional = false)
    @Column(name = "MTO_APORTE")
    private BigDecimal mtoAporte;
    //@Basic(optional = false)
    @Column(name = "COD_PARTICIPA")
    private String codParticipa;
    @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE")
    @ManyToOne(optional = false)
    private T020tramite t020tramite;

    @Transient
    private String descParticipa;
    @Transient
    private String descTipdoc;
    
    @Transient
    private T026perjur t026perjur;
    
    @Transient
    private T025pernat t025pernat;
    
    public T022accionista() {
    }

    public T022accionista(Integer idAccionista) {
        this.idAccionista = idAccionista;
    }

    public T022accionista(Integer idAccionista, String codTipdoc, String numDocum, Date fecRegistro, String indAporte, BigDecimal mtoAporte, String codParticipa) {
        this.idAccionista = idAccionista;
        this.codTipdoc = codTipdoc;
        this.numDocum = numDocum;
        this.fecRegistro = fecRegistro;
        this.indAporte = indAporte;
        this.mtoAporte = mtoAporte;
        this.codParticipa = codParticipa;
    }

    public Integer getIdAccionista() {
        return idAccionista;
    }

    public void setIdAccionista(Integer idAccionista) {
        this.idAccionista = idAccionista;
    }

    public String getCodTipdoc() {
        return codTipdoc;
    }

    public void setCodTipdoc(String codTipdoc) {
        this.codTipdoc = codTipdoc;
    }

    public String getNumDocum() {
        return numDocum;
    }

    public void setNumDocum(String numDocum) {
        this.numDocum = numDocum;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public String getIndAporte() {
        return indAporte;
    }

    public void setIndAporte(String indAporte) {
        this.indAporte = indAporte;
    }

    public BigDecimal getMtoAporte() {
        return mtoAporte;
    }

    public void setMtoAporte(BigDecimal mtoAporte) {
        this.mtoAporte = mtoAporte;
    }

    public String getCodParticipa() {
        return codParticipa;
    }

    public void setCodParticipa(String codParticipa) {
        this.codParticipa = codParticipa;
    }

    public T020tramite getT020tramite() {
        return t020tramite;
    }

    public void setT020tramite(T020tramite t020tramite) {
        this.t020tramite = t020tramite;
    }

    
    
    public T026perjur getT026perjur() {
		return t026perjur;
	}

	public void setT026perjur(T026perjur t026perjur) {
		this.t026perjur = t026perjur;
	}

	public T025pernat getT025pernat() {
		return t025pernat;
	}

	public void setT025pernat(T025pernat t025pernat) {
		this.t025pernat = t025pernat;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccionista != null ? idAccionista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T022accionista)) {
            return false;
        }
        T022accionista other = (T022accionista) object;
        if ((this.idAccionista == null && other.idAccionista != null) || (this.idAccionista != null && !this.idAccionista.equals(other.idAccionista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T022accionista[idAccionista=" + idAccionista + "]";
    }

	public String getDescParticipa() {
		return descParticipa;
	}

	public void setDescParticipa(String descParticipa) {
		this.descParticipa = descParticipa;
	}

	public String getDescTipdoc() {
		return descTipdoc;
	}

	public void setDescTipdoc(String descTipdoc) {
		this.descTipdoc = descTipdoc;
	}
	
	public String getNombreCompleto(){
		if( t025pernat != null ){ return t025pernat.getNombreCompleto() ; }
		if( t026perjur != null ){ return t026perjur.getNomRazsoc() ; }
		return "";
	}
    
}
