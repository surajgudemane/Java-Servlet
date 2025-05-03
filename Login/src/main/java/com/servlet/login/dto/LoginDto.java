package com.servlet.login.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "login_info")
@NamedQuery(name = "read", query = "Select read from LoginDto read")
@NamedQuery(name = "readName", query = "Select read from LoginDto read where read.txtName =: txtName")
@NamedQuery(name = "update", query = "update LoginDto up set up.pass =: pass where up.txtName = : txtName")
@NamedQuery(name = "delete", query = "delete from LoginDto up where up.txtName = : txtName and up.pass =: pass ")
public class LoginDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String txtName;
	private String pass;
	
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginDto(String txtName, String pass) {
		super();
		this.txtName = txtName;
		this.pass = pass;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTxtName() {
		return txtName;
	}
	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "LoginDto [id=" + id + ", txtName=" + txtName + ", pass=" + pass + "]";
	}
}
