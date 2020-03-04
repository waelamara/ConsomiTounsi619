package tn.esprit.spring.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PUB")
public class Pub implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Nom;
	@Temporal (TemporalType.DATE)
	private Date DateDebut;
	@Temporal (TemporalType.DATE)
	private Date DateFin;
	private String Image;
	@OneToOne(mappedBy="publicite") 
	private Events events;

}
