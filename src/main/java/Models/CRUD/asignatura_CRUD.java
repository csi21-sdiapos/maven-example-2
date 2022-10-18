package Models.CRUD;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Models.DTOs.AsignaturaDTO;

public class asignatura_CRUD {
	
	// Create an EntityManagerFactory when you start the application
    private static final EntityManagerFactory ENTITY_MANAGER_ASIGNATURA = Persistence.createEntityManagerFactory("ASIGNATURA_PERSISTENCE");

	public static void addAsignatura(String nombre) { // he quitado el parámetro de entrada del id porque como es un sequence se debe poner sólo
        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = ENTITY_MANAGER_ASIGNATURA.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;
 
        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
 
            // Create and set values for new customer
            AsignaturaDTO asignatura = new AsignaturaDTO();
            // asignatura.setAsignatura_id(id);
            asignatura.setAsignatura_nombre(nombre);
 
            // Save the customer object
            em.persist(asignatura);
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
	
	public static void getAsignatura(int id) {
    	EntityManager em = ENTITY_MANAGER_ASIGNATURA.createEntityManager();
    	
    	// the lowercase a refers to the object
    	// :asignaturaID is a parameterized query thats value is set below
    	String query = "SELECT a FROM AsignaturaDTO a WHERE a.id = :asignaturaID";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<AsignaturaDTO> tq = em.createQuery(query, AsignaturaDTO.class);
    	tq.setParameter("asignaturaID", id);
    	
    	AsignaturaDTO asignatura = null;
    	try {
    		// Get matching customer object and output
    		asignatura = tq.getSingleResult();
    		System.out.println(asignatura.getAsignatura_id() + " " + asignatura.getAsignatura_nombre());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
	
	public static AsignaturaDTO seleccionarAsignatura(int id) {
    	EntityManager em = ENTITY_MANAGER_ASIGNATURA.createEntityManager();
    	
    	// the lowercase a refers to the object
    	// :asignaturaID is a parameterized query thats value is set below
    	String query = "SELECT a FROM AsignaturaDTO a WHERE a.id = :asignaturaID";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<AsignaturaDTO> tq = em.createQuery(query, AsignaturaDTO.class);
    	tq.setParameter("asignaturaID", id);
    	
    	AsignaturaDTO asignatura = null;
    	try {
    		// Get matching customer object and output
    		asignatura = tq.getSingleResult();
    		//System.out.println(asignatura.getAsignatura_id() + " " + asignatura.getAsignatura_nombre());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    	return asignatura;
    }
    
    public static void getAsignaturas() {
    	EntityManager em = ENTITY_MANAGER_ASIGNATURA.createEntityManager();
    	
    	// the lowercase c refers to the object
    	// :asignaturaID is a parameterized query thats value is set below
    	String strQuery = "SELECT a FROM AsignaturaDTO a WHERE a.id IS NOT NULL";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<AsignaturaDTO> tq = em.createQuery(strQuery, AsignaturaDTO.class);
    	List<AsignaturaDTO> listaAsignaturas;
    	try {
    		// Get matching customer object and output
    		listaAsignaturas = tq.getResultList();
    		
    		for(AsignaturaDTO asignatura : listaAsignaturas) {
    			System.out.println(asignatura.getAsignatura_id() + " " + asignatura.getAsignatura_nombre());
            }
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static void changeAsignatura_nombre(int id, String nombre) {
        EntityManager em = ENTITY_MANAGER_ASIGNATURA.createEntityManager();
        EntityTransaction et = null;
        
    	AsignaturaDTO asignatura = null;
 
        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
 
            // Find customer and make changes
            asignatura = em.find(AsignaturaDTO.class, id);
            asignatura.setAsignatura_nombre(nombre);
 
            // Save the customer object
            em.persist(asignatura);
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
    
    
    public static void deleteAsignatura(int id) {
    	EntityManager em = ENTITY_MANAGER_ASIGNATURA.createEntityManager();
        EntityTransaction et = null;
        AsignaturaDTO asignatura = null;
 
        try {
            et = em.getTransaction();
            et.begin();
            
            asignatura = em.find(AsignaturaDTO.class, id);
            em.remove(asignatura);
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
