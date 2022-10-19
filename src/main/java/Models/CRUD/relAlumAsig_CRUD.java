package Models.CRUD;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Models.DTOs.AlumnoDTO;
import Models.DTOs.AsignaturaDTO;
import Models.DTOs.RelAlumAsigDTO;

public class relAlumAsig_CRUD { ////////////// clase en revisión ////////////////
	
	// Create an EntityManagerFactory when you start the application
    private static final EntityManagerFactory ENTITY_MANAGER_REL_ALUM_ASIG = Persistence.createEntityManagerFactory("REL_ALUM_ASIG_PERSISTENCE");

	public static void addRelAlumAsig(AlumnoDTO alumno, AsignaturaDTO asignatura) { // he quitado el parámetro de entrada del id porque como es un sequence se debe poner sólo
        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = ENTITY_MANAGER_REL_ALUM_ASIG.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;
 
        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
 
            // Create and set values for new customer
            RelAlumAsigDTO relAlumAsig = new RelAlumAsigDTO();
            relAlumAsig.setAlumno(alumno);
            relAlumAsig.setAlumno_nombre(alumno.getAlumno_nombre());
            relAlumAsig.setAsignatura(asignatura);
            relAlumAsig.setAsignatura_nombre(asignatura.getAsignatura_nombre());
            
            // Save the customer object
            em.persist(relAlumAsig);
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
	
	public static void getRelAlumAsig(int relAlumAsig_id) {
    	EntityManager em = ENTITY_MANAGER_REL_ALUM_ASIG.createEntityManager();
    	
    	// the lowercase a refers to the object
    	// :relAlumAsigID is a parameterized query thats value is set below
    	String query = "SELECT r FROM RelAlumAsigDTO r WHERE r.id = :relAlumAsigID";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<RelAlumAsigDTO> tq = em.createQuery(query, RelAlumAsigDTO.class);
    	tq.setParameter("relAlumAsigID", relAlumAsig_id);
    	
    	RelAlumAsigDTO relAlumAsig = null;
    	try {
    		// Get matching customer object and output
    		relAlumAsig = tq.getSingleResult();
            System.out.println(relAlumAsig.getRelAlumAsig_id() + " " + relAlumAsig.getAlumno().getAlumno_id() + " " + relAlumAsig.getAlumno().getAlumno_nombre() + " " + relAlumAsig.getAsignatura().getAsignatura_id() + " " + relAlumAsig.getAsignatura().getAsignatura_nombre());
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
	
	public static RelAlumAsigDTO seleccionarRelAlumAsig(int relAlumAsig_id) {
    	EntityManager em = ENTITY_MANAGER_REL_ALUM_ASIG.createEntityManager();
    	
    	// the lowercase a refers to the object
    	// :relAlumAsigID is a parameterized query thats value is set below
    	String query = "SELECT r FROM RelAlumAsigDTO r WHERE r.id = :relAlumAsigID";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<RelAlumAsigDTO> tq = em.createQuery(query, RelAlumAsigDTO.class);
    	tq.setParameter("relAlumAsigID", relAlumAsig_id);
    	
    	RelAlumAsigDTO relAlumAsig = null;
    	try {
    		// Get matching customer object and output
    		relAlumAsig = tq.getSingleResult();
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
		return relAlumAsig;
    }
    
    public static void getListaRelAlumAsig() {
    	EntityManager em = ENTITY_MANAGER_REL_ALUM_ASIG.createEntityManager();
    	
    	// the lowercase c refers to the object
    	// :relAlumAsigID is a parameterized query thats value is set below
    	String strQuery = "SELECT a FROM RelAlumAsigDTO a WHERE a.id IS NOT NULL";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<RelAlumAsigDTO> tq = em.createQuery(strQuery, RelAlumAsigDTO.class);
    	List<RelAlumAsigDTO> listaRelAlumAsigs;
    	try {
    		// Get matching customer object and output
    		listaRelAlumAsigs = tq.getResultList();
    		
    		for(RelAlumAsigDTO relAlumAsig : listaRelAlumAsigs) {
    			System.out.println(relAlumAsig.getRelAlumAsig_id() + " " + relAlumAsig.getAlumno().getAlumno_id() + " " + relAlumAsig.getAlumno().getAlumno_nombre() + " " + relAlumAsig.getAsignatura().getAsignatura_id() + " " + relAlumAsig.getAsignatura().getAsignatura_nombre());
            }
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static void changeRelAlumAsig_alumno_nombre(int relAlumAsig_id, String alumno_nombre) {
        EntityManager em = ENTITY_MANAGER_REL_ALUM_ASIG.createEntityManager();
        EntityTransaction et = null;
        
    	RelAlumAsigDTO relAlumAsig = null;
 
        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
 
            // Find customer and make changes
            relAlumAsig = em.find(RelAlumAsigDTO.class, relAlumAsig_id);
            relAlumAsig.setAlumno_nombre(alumno_nombre);
 
            // Save the customer object
            em.persist(relAlumAsig);
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
    
    public static void changeRelAlumAsig_asignatura_nombre(int relAlumAsig_id, String asignatura_nombre) {
        EntityManager em = ENTITY_MANAGER_REL_ALUM_ASIG.createEntityManager();
        EntityTransaction et = null;
        
    	RelAlumAsigDTO relAlumAsig = null;
 
        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
 
            // Find customer and make changes
            relAlumAsig = em.find(RelAlumAsigDTO.class, relAlumAsig_id);
            relAlumAsig.setAsignatura_nombre(asignatura_nombre);
 
            // Save the customer object
            em.persist(relAlumAsig);
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
    
    public static void deleteRelAlumAsig(int relAlumAsig_id) {
    	EntityManager em = ENTITY_MANAGER_REL_ALUM_ASIG.createEntityManager();
        EntityTransaction et = null;
        RelAlumAsigDTO relAlumAsig = null;
 
        try {
            et = em.getTransaction();
            et.begin();
            
            relAlumAsig = em.find(RelAlumAsigDTO.class, relAlumAsig_id);
            em.remove(relAlumAsig);
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
