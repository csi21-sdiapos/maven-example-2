package Main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Models.CRUD.alumno_CRUD;
import Models.CRUD.asignatura_CRUD;
import Models.DTOs.AlumnoDTO;
import Models.DTOs.AsignaturaDTO;
import Models.DTOs.RelAlumAsigDTO;

public class Main {
	
	final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		// con los objetos registry y factory, activamos el archivo hibernate.cfg.xml para crear automaáticamente las tablas en la BBDD cuando ejecutamos el proyecto
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		/************************************* Creamos un par de alumnos y los mostramos ****************************************************/
		
		System.out.println("\n\tVamos a crear 2 alumnos");
		
		System.out.print("\nIntroduzca el nombre del alumno 1:\t");
		String nombre = sc.nextLine();
		System.out.print("\nIntroduzca los apellidos del alumno 1:\t");
		String apellidos = sc.nextLine();
		System.out.print("\nIntroduzca el email del alumno 1:\t");
		String email = sc.nextLine();
		
		alumno_CRUD.addAlumno(nombre, apellidos, email);
		System.out.println("Alumno 1 creado correctamente... vamos ahora a crear el alumno 2...");
		
		System.out.print("\nIntroduzca el nombre del alumno 2:\t");
		nombre = sc.nextLine();
		System.out.print("\nIntroduzca los apellidos del alumno 2:\t");
		apellidos = sc.nextLine();
		System.out.print("\nIntroduzca el email del alumno 2:\t");
		email = sc.nextLine();
		
		alumno_CRUD.addAlumno(nombre, apellidos, email);
		System.out.println("Alumno 2 creado correctamente... vamos a mostrar los alumnos...\n");
		
		alumno_CRUD.getAlumnos();
		
		/********************************* Creamos un par de asignaturas y las mostramos **********************************************/
		
		System.out.println("\nVamos a crear dos asignaturas");
		
		System.out.print("\nIntroduzca el nombre de la asignatura 1:\t");
		nombre = sc.nextLine();
		
		asignatura_CRUD.addAsignatura(nombre);
		
		System.out.println("Asignatura 1 creada correctamente... vamos a crear la asignatura 2...\n");
		
		System.out.print("\nIntroduzca el nombre de la asignatura 2:\t");
		nombre = sc.nextLine();
		
		asignatura_CRUD.addAsignatura(nombre);
		
		System.out.println("Asignatura 2 creada correctamente... vamos a mostrar las asignaturas...\n");
		
		asignatura_CRUD.getAsignaturas();
		
		System.out.println("\n");
		
		/********* vamos a crear un tercer alumno y una tercera asignatura y creamos un nuevo objeto relacional con ellos **************/

		Session session = factory.openSession();
		
		System.out.print("\nIntroduzca el nombre del alumno 3:\t");
        nombre = sc.nextLine();
        System.out.print("\nIntroduzca los apellidos del alumno 3:\t");
        apellidos = sc.nextLine();
        System.out.print("\nIntroduzca el email del alumno 3:\t");
        email = sc.nextLine();
		
		AlumnoDTO alumno = new AlumnoDTO();
		alumno.setAlumno_nombre(nombre);
        alumno.setAlumno_apellidos(nombre);
        alumno.setAlumno_email(email);
		
        System.out.print("\nIntroduzca el nombre de la asignatura 3:\t");
        nombre = sc.nextLine();
        
		AsignaturaDTO asignatura = new AsignaturaDTO();
		asignatura.setAsignatura_nombre(nombre);
		
		RelAlumAsigDTO relAlumAsig = new RelAlumAsigDTO();
		relAlumAsig.setAlumno(alumno);
		relAlumAsig.setAsignatura(asignatura);
		relAlumAsig.setAlumno_nombre(alumno.getAlumno_nombre());
		relAlumAsig.setAsignatura_nombre(asignatura.getAsignatura_nombre());
		
		asignatura.addRelAlumAsig(relAlumAsig);
		
		session.save(asignatura);
		session.close();

		/***********************************************************************************************************************/
		factory.close(); // hay que cerrar el factory con el que se autocrean las tablas en la BBDD
	}
	
}
