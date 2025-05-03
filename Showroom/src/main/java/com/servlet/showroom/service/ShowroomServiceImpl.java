package com.servlet.showroom.service;

import java.util.List;

import com.servlet.showroom.dto.ShowroomDto;
import com.servlet.showroom.repo.ShowroomRepo;
import com.servlet.showroom.repo.ShowroomRepoImpl;

public class ShowroomServiceImpl implements ShowroomService {

	private ShowroomRepo repo = new ShowroomRepoImpl();
	
	@Override
	public boolean save(ShowroomDto dto) {
		if(dto.getShowRoom().length() > 4) {
			if(dto.getType().length() > 2) {
				if(dto.getLocation().length() > 2) {
					return repo.save(dto);
				}
			}
		}
		return false;
	}

	@Override
	public List<ShowroomDto> readAll() {
		return repo.readAll();
	}

	@Override
	public List<ShowroomDto> readByName(String name) {
		if(name.length() > 4) {
			return repo.readByName(name);
		}
		return null;
	}

	@Override
	public boolean updateTypeByNameAndLocation(String type, String name, String location) {
		if(name.length() > 4) {
			if(type.length() > 2) {
				if(location.length() > 2) {
					return repo.updateTypeByNameAndLocation(type, name, location);
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteByNameAndType(String name, String type) {
		if(name.length() > 4) {
			if(type.length() > 2) {
				return repo.deleteByNameAndType(name, type);
			}
		}
		return false;
	}

}
