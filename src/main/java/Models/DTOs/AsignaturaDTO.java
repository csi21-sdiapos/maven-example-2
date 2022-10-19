package Models.DTOs;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Entity defines which objects should be persisted in the database
@Entity
//Defines the name of the table created for the entity
@Table(name = "asignaturas")
public class AsignaturaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/******************************* ATRIBUTOS *******************************/
	
	// All entities must define a primary key which you define with
	// the @Id annotation	
	// You can override the default column name 
	// Map id to the CustID field in the DB
	// You can have it auto generate
	// @GeneratedValue(strategy = GenerationType.AUTO)
	
	@Id
	@Column(name = "asignatura_id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int asignatura_id;
	@Column(name = "asignatura_nombre", length = 100, nullable = true)
	String asignatura_nombre;
	
	@OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
    Set<RelAlumAsigDTO> listaRelAlumAsig = new HashSet<>();

	/******************************* CONSTRUCTORES ***********************************/
	
	// constructor lleno
	public AsignaturaDTO(int asignatura_id, String asignatura_nombre) {
		super();
		this.asignatura_id = asignatura_id;
		this.asignatura_nombre = asignatura_nombre;
	}
	
	// constructor vacío
	public AsignaturaDTO() {
		super();
	}
		

	/******************************* GETTERS Y SETTERS **************************************/
	public int getAsignatura_id() {
		return asignatura_id;
	}
	public void setAsignatura_id(int asignatura_id) {
		this.asignatura_id = asignatura_id;
	}
	public String getAsignatura_nombre() {
		return asignatura_nombre;
	}
	public void setAsignatura_nombre(String asignatura_nombre) {
		this.asignatura_nombre = asignatura_nombre;
	}
		
		
	/*************************************** MÉTODOS *****************************************/
	
	public void addRelAlumAsig(RelAlumAsigDTO relAlumAsig) {
        this.listaRelAlumAsig.add(relAlumAsig);
    }
		
	/*************************************** ToString ***************************************/
	@Override
	public String toString() {
	    return 
	    	"\t" + asignatura_id + 
	    	"\t" + asignatura_nombre;
	}
}
