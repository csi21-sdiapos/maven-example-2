package Models.DTOs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity defines which objects should be persisted in the database
@Entity
//Defines the name of the table created for the entity
@Table(name = "relAlumAsig")
public class RelAlumAsigDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/************************************ ATRIBUTOS *************************************/
	@Id
	@Column(name = "relAlumAsig_id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int relAlumAsig_id;
	@Column(name = "alumno_id")
	int alumno_id;
	@Column(name = "alumno_nombre", length = 100, nullable = true)
	String alumno_nombre;
	@Column(name = "asignatura_id")
	int asignatura_id;
	@Column(name = "asignatura_nombre", length = 100, nullable = true)
	String asignatura_nombre;
	
	/*************************************** CONSTRUCTORES *******************************************/
	
	// constructor lleno
	public RelAlumAsigDTO(int relAlumAsig_id, int alumno_id, String alumno_nombre, int asignatura_id, String asignatura_nombre) {
		super();
		this.relAlumAsig_id = relAlumAsig_id;
		this.alumno_id = alumno_id;
		this.alumno_nombre = alumno_nombre;
		this.asignatura_id = asignatura_id;
		this.asignatura_nombre = asignatura_nombre;
	}

	// constructor vacío
	public RelAlumAsigDTO() {
		super();
	}

	
	/****************************************** GETTERS Y SETTERS ***************************************/
	public int getRelAlumAsig_id() {
		return relAlumAsig_id;
	}

	public void setRelAlumAsig_id(int relAlumAsig_id) {
		this.relAlumAsig_id = relAlumAsig_id;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	/***************************************** MÉTODOS ***********************************/
	
	
	/*************************************** ToString ***************************************/
	@Override
	public String toString() {
	    return 
	    	"\t" + relAlumAsig_id +
	    	"\t" + alumno_id + 
	    	"\t" + alumno_nombre +
	    	"\t" + asignatura_id +
	    	"\t" + asignatura_nombre;
	}
	
}
