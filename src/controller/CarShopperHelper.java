package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarShopper;

public class CarShopperHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebCarDealerList");

	public void insertCarShopper(CarShopper li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<CarShopper> showAllCarShoppers() {
		EntityManager em = emfactory.createEntityManager();
		List<CarShopper> allCarShoppers = em.createQuery("SELECT s FROM CarShopper s").getResultList();
		return allCarShoppers;
	}

	public CarShopper findCarShopper(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarShopper> typedQuery = em.createQuery("select sh from CarShopper sh where sh.shopperName = :selectedName",
				CarShopper.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		CarShopper foundCarShopper;
		try {
			foundCarShopper = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundCarShopper = new CarShopper(nameToLookUp);
		}
		em.close();

		return foundCarShopper;
	}
}
