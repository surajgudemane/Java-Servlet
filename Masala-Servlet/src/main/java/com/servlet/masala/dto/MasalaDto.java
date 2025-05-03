package com.servlet.masala.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "masala_dto")
@NamedQuery(name = "readAll", query = "Select read from MasalaDto read")
public class MasalaDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String brand;
	private String type;
	private int quantity;
	private int price;
	
	public MasalaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MasalaDto(String brand, String type, int quantity, int price) {
		super();
		this.brand = brand;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "MasalaDto [id=" + id + ", brand=" + brand + ", type=" + type + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
}
