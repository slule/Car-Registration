/**  
* @Author Shalom Lule - slule@dmacc.edu  
* CIS175 <Spring 2024>
* Feb 20, 2024 
*/ 
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;


public class CarsHelper {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("cars");
	
	public void persist(Car model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(model);
		manager.getTransaction().commit();
		manager.close();
		
		
	}
	
	public void delete(Car model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(Car.class, model.getRowId()));
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	public List<Car> showAllCars() {
		EntityManager manager = factory.createEntityManager();
		List<Car> carList = manager.createQuery("SELECT i FROM cars i").getResultList();
		manager.close();
		return carList;
	}

	public void update(Car model) {
		EntityManager manager = factory.createEntityManager();
		Car dbEntity = manager.find(Car.class, model.getRowId());
		manager.getTransaction().begin();
		dbEntity.setCarMake(model.getCarMake());
		dbEntity.setCarModel(model.getCarModel());
		dbEntity.setCarYear(model.getCarYear());
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	public Car searchCarByMake(String oldMake) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Car> query = manager.createQuery("SELECT i FROM cars AS i WHERE i.carModel = :carModel", Car.class);
		query.setParameter("carModel", oldMake);
	try {
		Car dbEntity = query.getSingleResult();
		return dbEntity;
	} catch (NoResultException e) {
		e.printStackTrace();
		return null;
	} finally {
		manager.close();
	}
	}
}
	
	

	


