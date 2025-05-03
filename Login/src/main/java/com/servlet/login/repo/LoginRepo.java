package com.servlet.login.repo;

import java.util.List;

import com.servlet.login.dto.LoginDto;

public interface LoginRepo {

	public boolean create(LoginDto dto);

	public List<LoginDto> readAll();

	public LoginDto findByName(String name);

	boolean updatePasswordByName(String name, String pass);

	public boolean deleteByNameAndPassWord(String name, String pass);
	
}
