package com.servlet.masala.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.servlet.masala.dto.MasalaDto;

public class MasalaRepo {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("masalaData");
	EntityManager em = emf.createEntityManager();

	public boolean save(MasalaDto dto) {
		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
		return true;
	}
	
	public List<MasalaDto> readAll(){
		Query q = em.createNamedQuery("readAll", MasalaDto.class);
		return q.getResultList();
	}
	
	public List<MasalaDto> findByType(String type){
		Query q = em.createNamedQuery("find", MasalaDto.class);
		q.setParameter(1, type);
		return q.getResultList();
	}
	
	public boolean updateQuantityByPrice(int quantity, int price) {
		em.getTransaction().begin();
		Query q = em.createNamedQuery("update", MasalaDto.class);
		q.setParameter(1, quantity);
		q.setParameter(2, price);
		q.executeUpdate();
		em.getTransaction().commit();
		return true;
	}
	
	public boolean deleteByBrand(String brand) {
		em.getTransaction().begin();
		Query q = em.createNamedQuery("delete", MasalaDto.class);
		q.setParameter(1, brand);
		q.executeUpdate();
		em.getTransaction().commit();
		return true;
	}
}
