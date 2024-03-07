/**  
* @Author Shalom Lule - slule@dmacc.edu  
* CIS175 <Spring 2024>
* Mar 2, 2024 
*/ 
package helpers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.Query;


import model.Car;
import model.Garage;

public class GarageHelper {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("cars");
	public void persist(Garage model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(model);
		manager.getTransaction().commit();
		manager.close();

}
	
	public void delete(Garage model) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(Garage.class, model.getGarageId()));
		manager.getTransaction().commit();
		manager.close();
}
	
	@SuppressWarnings("unchecked")
	public List<Garage> showAllgarage() {
		EntityManager manager = factory.createEntityManager();
		manager.clear();
		Query r = manager.createQuery("SELECT i FROM Garage i");
		List<Garage> allItems = r.getResultList();
		manager.close();
		return allItems;
	}
	
	public void update(Garage model) {
		EntityManager manager = factory.createEntityManager();
		Garage dbEntity = manager.find(Garage.class, model.getGarageId());
		manager.getTransaction().begin();
		dbEntity.setName(model.getName());
		dbEntity.setCars(model.getCars());
		manager.getTransaction().commit();
		manager.close();
	}
	
	public Garage searchGarageByName(String name) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Garage> query = manager.createQuery("SELECT i FROM Garage AS i WHERE i.name = :name", Garage.class);
		query.setParameter("name", name);
		try {
			Garage dbEntity = query.getSingleResult();
			return dbEntity;
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}
		}
	}
	
	