package Models.DTOs;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//Entity defines which objects should be persisted in the database
@Entity
//Defines the name of the table created for the entity
@Table(name = "alumnos")
public class AlumnoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/******************************* ATRIBUTOS *******************************/
	
	// All entities must define a primary key which you define with
	// the @Id annotation	
	// You can override the default column name 
	// Map id to the CustID field in the DB
	// You can have it auto generate
	// @GeneratedValue(strategy = GenerationType.AUTO)
	
	@Id
	@Column(name = "alumno_id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int alumno_id;
	@Column(name = "alumno_nombre", length = 100, nullable = true)
	String alumno_nombre;
	@Column(name = "alumno_apellidos", length = 100, nullable = true)
	String alumno_apellidos;
	@Column(name = "alumno_email", length = 100, nullable = true)
	String alumno_email;
	
	//////////////////////////// para hacer la relación necesitamos esto //////////////////////////
	@ManyToMany(
		fetch = FetchType.LAZY,	
		cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
    @JoinTable(name = "relAlumAsig", 
            joinColumns = { @JoinColumn(name = "alumno_id", nullable = false, updatable = false) }, 
            inverseJoinColumns = { @JoinColumn(name = "asignatura_id", nullable = false, updatable = false) })
    private Set<AsignaturaDTO> asignaturas = new HashSet<AsignaturaDTO>();

	public Set<AsignaturaDTO> getAsignaturas() {
		return asignaturas;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////

	/******************************* CONSTRUCTORES ***********************************/
	
	// constructor lleno
	public AlumnoDTO(int alumno_id, String alumno_nombre, String alumno_apellidos, String alumno_email) {
		super();
		this.alumno_id = alumno_id;
		this.alumno_nombre = alumno_nombre;
		this.alumno_apellidos = alumno_apellidos;
		this.alumno_email = alumno_email;
	}
	
	// constructor vacío
	public AlumnoDTO() {
		super();
	}
		

	/******************************* GETTERS Y SETTERS **************************************/
	public int getAlumno_id() {
		return alumno_id;
	}
	public void setAlumno_id(int alumno_id) {
		this.alumno_id = alumno_id;
	}
	public String getAlumno_nombre() {
		return alumno_nombre;
	}
	public void setAlumno_nombre(String alumno_nombre) {
		this.alumno_nombre = alumno_nombre;
	}
	public String getAlumno_apellidos() {
		return alumno_apellidos;
	}
	public void setAlumno_apellidos(String alumno_apellidos) {
		this.alumno_apellidos = alumno_apellidos;
	}
	public String getAlumno_email() {
		return alumno_email;
	}
	public void setAlumno_email(String alumno_email) {
		this.alumno_email = alumno_email;
	}
		
		
	/*************************************** MÉTODOS *****************************************/
		
	public void addAsignatura(AsignaturaDTO asignatura) { // para hacer la relación
        this.asignaturas.add(asignatura);
        asignatura.getAlumnos().add(this);
    }
/*
    // Error: Lambda expressions are allowed only at source level 1.8 or above
	public void removeAsignatura(int asignatura_id) { // para hacer la relación
	    AsignaturaDTO asignatura = this.asignaturas.stream().filter(a -> a.getAsignatura_id() == asignatura_id).findFirst().orElse(null);
	    if (asignatura != null) {
	      this.asignaturas.remove(asignatura);
	      asignatura.getAlumnos().remove(this);
	    }
	  }
*/	
	/*************************************** ToString ***************************************/
	@Override
	public String toString() {
	    return 
	    	"\t" + alumno_id + 
	    	"\t" + alumno_nombre +
	    	"\t" + alumno_apellidos +
	    	"\t" + alumno_email;
	}
}
