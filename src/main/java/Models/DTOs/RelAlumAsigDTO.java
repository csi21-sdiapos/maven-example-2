package Models.DTOs;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "alumno_id")
	AlumnoDTO alumno;
	
	@ManyToOne
	@JoinColumn(name = "asignatura_id")
	AsignaturaDTO asignatura;
	
	@Column(name = "alumno_nombre", length = 100, nullable = true)
	String alumno_nombre;
	@Column(name = "asignatura_nombre", length = 100, nullable = true)
	String asignatura_nombre;
	
	/*************************************** CONSTRUCTORES *******************************************/
	
	// constructor lleno
	public RelAlumAsigDTO(int relAlumAsig_id, AlumnoDTO alumno, String alumno_nombre, AsignaturaDTO asignatura, String asignatura_nombre) {
        super();
        this.relAlumAsig_id = relAlumAsig_id;
        this.alumno = alumno;
        this.alumno_nombre = alumno_nombre;
        this.asignatura = asignatura;
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

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }

    public String getAlumno_nombre() {
        return alumno_nombre;
    }

    public void setAlumno_nombre(String alumno_nombre) {
        this.alumno_nombre = alumno_nombre;
    }

    public AsignaturaDTO getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(AsignaturaDTO asignatura) {
        this.asignatura = asignatura;
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
	    	"\t" + relAlumAsig_id;
	}

    
	
}
