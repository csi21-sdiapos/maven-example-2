package Models.CRUD;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Models.DTOs.AlumnoDTO;

public class alumno_CRUD {
	
	// Create an EntityManagerFactory when you start the application
    private static final EntityManagerFactory ENTITY_MANAGER_ALUMNO = Persistence.createEntityManagerFactory("ALUMNO_PERSISTENCE");

	public static void addAlumno(String nombre, String apellidos, String email) { // he quitado el parámetro de entrada del id porque como es un sequence se debe poner sólo
        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = ENTITY_MANAGER_ALUMNO.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;
 
        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
 
            // Create and set values for new customer
            AlumnoDTO alumno = new AlumnoDTO();
            // alumno.setAlumno_id(id);
            alumno.setAlumno_nombre(nombre);
            alumno.setAlumno_apellidos(apellidos);
            alumno.setAlumno_email(email);
 
            // Save the customer object
            em.persist(alumno);
            et.commit();
            
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            
            ex.printStackTrace();
        
        } finally {
            // Close EntityManager
            em.close();
        }
    }
	
	public static void getAlumno(int id) {
    	EntityManager em = ENTITY_MANAGER_ALUMNO.createEntityManager();
    	
    	// the lowercase a refers to the object
    	// :alumnoID is a parameterized query thats value is set below
    	String query = "SELECT a FROM AlumnoDTO a WHERE a.id = :alumnoID";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<AlumnoDTO> tq = em.createQuery(query, AlumnoDTO.class);
    	tq.setParameter("alumnoID", id);
    	
    	AlumnoDTO alumno = null;
    	try {
    		// Get matching customer object and output
    		alumno = tq.getSingleResult();
    		System.out.println(alumno.getAlumno_id() + " " + alumno.getAlumno_nombre() + " " + alumno.getAlumno_apellidos() + " " + alumno.getAlumno_email());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
	
	public static AlumnoDTO seleccionarAlumno(int id) {
    	EntityManager em = ENTITY_MANAGER_ALUMNO.createEntityManager();
    	
    	// the lowercase a refers to the object
    	// :alumnoID is a parameterized query thats value is set below
    	String query = "SELECT a FROM AlumnoDTO a WHERE a.id = :alumnoID";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<AlumnoDTO> tq = em.createQuery(query, AlumnoDTO.class);
    	tq.setParameter("alumnoID", id);
    	
    	AlumnoDTO alumno = null;
    	try {
    		// Get matching customer object and output
    		alumno = tq.getSingleResult();
    		//System.out.println(alumno.getAlumno_id() + " " + alumno.getAlumno_nombre() + " " + alumno.getAlumno_apellidos() + " " + alumno.getAlumno_email());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
		return alumno;
    }
    
    public static void getAlumnos() {
    	EntityManager em = ENTITY_MANAGER_ALUMNO.createEntityManager();
    	
    	// the lowercase c refers to the object
    	// :alumnoID is a parameterized query thats value is set below
    	String strQuery = "SELECT a FROM AlumnoDTO a WHERE a.id IS NOT NULL";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<AlumnoDTO> tq = em.createQuery(strQuery, AlumnoDTO.class);
    	List<AlumnoDTO> listaAlumnos;
    	try {
    		// Get matching customer object and output
    		listaAlumnos = tq.getResultList();
    		
    		for(AlumnoDTO alumno : listaAlumnos) {
    			System.out.println(alumno.getAlumno_id() + " " + alumno.getAlumno_nombre() + " " + alumno.getAlumno_apellidos() + " " + alumno.getAlumno_email());
            }
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static void changeAlumno_nombre(int id, String nombre) {
        EntityManager em = ENTITY_MANAGER_ALUMNO.createEntityManager();
        EntityTransaction et = null;
        
    	AlumnoDTO alumno = null;
 
        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
 
            // Find customer and make changes
            alumno = em.find(AlumnoDTO.class, id);
            alumno.setAlumno_nombre(nombre);
 
            // Save the customer object
            em.persist(alumno);
            et.commit();
            
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            
            ex.printStackTrace();
        
        } finally {
            // Close EntityManager
            em.close();
        }
    }
    
    
    public static void deleteAlumno(int id) {
    	EntityManager em = ENTITY_MANAGER_ALUMNO.createEntityManager();
        EntityTransaction et = null;
        AlumnoDTO alumno = null;
 
        try {
            et = em.getTransaction();
            et.begin();
            
            alumno = em.find(AlumnoDTO.class, id);
            em.remove(alumno);
            et.commit();
        
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            
            ex.printStackTrace();
        
        } finally {
            // Close EntityManager
            em.close();
        }
    }
    
}
