package tn.esprit.spring.Model.Charite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.Model.User;
import tn.esprit.spring.Model.Charite.Events;

@Entity
@Table(name = "T_CHARITE")
public class Charite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 
	 private String TypeCharite;
	 @ManyToOne
	 @JsonIgnore
	private User iduser;
	 @ManyToOne
	 @JsonIgnore
    private Events idevents ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeCharite() {
		return TypeCharite;
	}
	public void setTypeCharite(String typeCharite) {
		TypeCharite = typeCharite;
	}
	public User getIduser() {
		return iduser;
	}
	public void setIduser(User iduser) {
		this.iduser = iduser;
	}
	public Events getIdevents() {
		return idevents;
	}
	public void setIdevents(Events idevents) {
		this.idevents = idevents;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Charite() {
		super();

	}
	public Charite(String TypeCharite,User iduser,Events idevents ) {
		super();
		this.TypeCharite=TypeCharite;
		this.idevents=idevents;
		this.iduser=iduser;

	}
	 

}