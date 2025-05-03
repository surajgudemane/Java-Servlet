package com.servlet.showroom.service;

import java.util.List;

import com.servlet.showroom.dto.ShowroomDto;

public interface ShowroomService {

	public boolean save(ShowroomDto dto);
	
	public List<ShowroomDto> readAll();
	
	public List<ShowroomDto> readByName(String name);
	
	public boolean updateTypeByNameAndLocation(String type, String name, String location);
	
	public boolean deleteByNameAndType(String name, String type);
	
}
