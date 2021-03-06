package tn.esprit.spring.Model.Charite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.Model.Charite.Events;

@Entity
@Table(name = "T_ENDROIT")
public class Endroit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String statu;
	private String emplacement;
	private int nbplace;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "eventss", referencedColumnName = "id") 
	private Events eventss;
	@Transient
	long event_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}
	
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public int getNbplace() {
		return nbplace;
	}
	public void setNbplace(int nbplace) {
		this.nbplace = nbplace;
	}
	public Events getEventss() {
		return eventss;
	}
	public void setEventss(Events eventss) {
		this.eventss = eventss;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	public Endroit() {
		super();

	}
	public Endroit(int nbplace,String emplacement,String statu,Events eventss) {
		super();
		this.nbplace=nbplace;
		this.emplacement=emplacement;
		this.statu=statu;
		this.eventss=eventss;

	}
	public Endroit(long id) {

		super();
		this.id=id;
		}

	

}
