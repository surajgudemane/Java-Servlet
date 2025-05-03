package com.servlet.login.serveice;

import java.util.List;

import com.servlet.login.dto.LoginDto;

public interface LoginService {

	public boolean create(LoginDto dto);
	
	public List<LoginDto> readAll();

	public LoginDto findByName(String name);

	public boolean updatePasswordByName(String name, String pass);
	
	public boolean deleteByNameAndPassWord(String name, String pass);
	
}
