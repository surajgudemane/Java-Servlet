package com.servlet.login.serveice;

import java.util.List;

import com.servlet.login.dto.LoginDto;
import com.servlet.login.repo.LoginRepo;
import com.servlet.login.repo.LoginRepoImpl;

public class LoginServiceImpl implements LoginService {

	private static LoginRepo repo = new LoginRepoImpl();
	
	@Override
	public boolean create(LoginDto dto) {
		if(dto.getTxtName().length() > 2) {
			if(dto.getPass().length() > 7) {
				return repo.create(dto);
			}
		}
		return false;
	}

	@Override
	public List<LoginDto> readAll() {
		return repo.readAll();
	}

	@Override
	public LoginDto findByName(String name) {
		if(name.length() > 2) {
			return repo.findByName(name);
		}
		return null;
	}

	@Override
	public boolean updatePasswordByName(String name, String pass) {
		if(pass.length() > 7) {
			return repo.updatePasswordByName(name, pass);
		}
		return false;
	}

	@Override
	public boolean deleteByNameAndPassWord(String name, String pass) {
		if(name.length() > 2) {
			if(pass.length() > 7) {
				return repo.deleteByNameAndPassWord(name, pass);
			}
		}
		return false;
	}

}
