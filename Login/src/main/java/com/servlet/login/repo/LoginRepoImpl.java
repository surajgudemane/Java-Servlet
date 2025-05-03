package com.servlet.login.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.servlet.login.dto.LoginDto;

public class LoginRepoImpl implements LoginRepo {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("loginData");
	EntityManager e = emf.createEntityManager();

	@Override
	public boolean create(LoginDto dto) {
		e.getTransaction().begin();
		e.persist(dto);
		e.getTransaction().commit();
		return true;
	}

	@Override
	public List<LoginDto> readAll() {
		Query q = e.createNamedQuery("read", LoginDto.class);
		
		List<LoginDto> list = new ArrayList<LoginDto>(q.getResultList());
		System.out.println("alsdkjfnlsdjdf");
		if (list.isEmpty()) {
			return null;
		} else {
			System.out.println("REadAll");
			return list;
		}
	}

	@Override
	public LoginDto findByName(String name) {
		Query q = e.createNamedQuery("readName", LoginDto.class);
		q.setParameter("txtName", name);
		
		try {
			LoginDto d1 = (LoginDto) q.getSingleResult();
			return d1;
		} catch (Exception e) {
			System.out.println("798451254612546");
			return null;
		}
		
	}

	@Override
	public boolean updatePasswordByName(String name, String pass) {
		e.getTransaction().begin();
		Query q = e.createNamedQuery("update");
		q.setParameter("pass", pass);
		q.setParameter("txtName", name);
		
		if (q.executeUpdate() >= 1) {
			e.getTransaction().commit();
			return true;
		}
		e.getTransaction().commit();
		return false;
	}

	@Override
	public boolean deleteByNameAndPassWord(String name, String pass) {
		e.getTransaction().begin();
		Query q = e.createNamedQuery("delete");
		q.setParameter("txtName", name);
		q.setParameter("pass", pass);
		
		if (q.executeUpdate() >= 1) {
			e.getTransaction().commit();
			return true;
		}
		e.getTransaction().commit();
		return false;
	}

}
