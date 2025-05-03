package com.servlet.showroom.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.servlet.showroom.dto.ShowroomDto;

public class ShowroomRepoImpl implements ShowroomRepo {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("showroom");
	EntityManager e = emf.createEntityManager();

	@Override
	public boolean save(ShowroomDto dto) {
		e.getTransaction().begin();
		e.persist(dto);
		e.getTransaction().commit();
		return true;
	}

	@Override
	public List<ShowroomDto> readAll() {
		Query q = e.createNamedQuery("read", ShowroomDto.class);
		return q.getResultList();
	}

	@Override
	public List<ShowroomDto> readByName(String name) {
		Query q = e.createNamedQuery("readName", ShowroomDto.class);
		q.setParameter("showRoom", name);
		return q.getResultList();
	}

	@Override
	public boolean updateTypeByNameAndLocation(String type, String name, String location) {
		e.getTransaction().begin();
		Query q = e.createNamedQuery("update");
		q.setParameter("type", type);
		q.setParameter("showRoom", name);
		q.setParameter("location", location);
		if(q.executeUpdate() > 0) {
			e.getTransaction().commit();
			return true;
		}
		e.getTransaction().commit();
		return false;
	}

	@Override
	public boolean deleteByNameAndType(String name, String type) {
		e.getTransaction().begin();
		Query q = e.createNamedQuery("delete ");
		q.setParameter("type", type);
		q.setParameter("showRoom", name);
		if(q.executeUpdate() > 0) {
			e.getTransaction().commit();
			return true;
		}
		e.getTransaction().commit();
		return false;

	}

}
