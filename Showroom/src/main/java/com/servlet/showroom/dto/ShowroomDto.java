package com.servlet.showroom.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "showrooom_info")
@NamedQuery(name = "read", query = "Select read from ShowroomDto read")
@NamedQuery(name = "readName", query = "Select read from ShowroomDto read where read.showRoom =: showRoom")
@NamedQuery(name = "update", query = "Update ShowroomDto up set up.type =: type where up.showRoom =: showRoom and up.location =: location")
//@NamedQuery(name = "delete", query = "delete from ShowroomDto up where read.showRoom =: showRoom and up.type =: type")
public class ShowroomDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String showRoom;
	private String location;
	private String type;
	public ShowroomDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowroomDto(String showRoom, String location, String type) {
		super();
		this.showRoom = showRoom;
		this.location = location;
		this.type = type;
	}
	public int getId() {
		return id;
	}

	public String getShowRoom() {
		return showRoom;
	}
	public void setShowRoom(String showRoom) {
		this.showRoom = showRoom;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ShowroomDto [id=" + id + ", showRoom=" + showRoom + ", location=" + location + ", type=" + type + "]";
	}
	
	
	
}
