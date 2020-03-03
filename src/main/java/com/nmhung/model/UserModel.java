package com.nmhung.model;

import lombok.Data;

@Data
public class UserModel {
	private Integer id;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private RoleModel role;

	public UserModel() {
	}

	public UserModel(Integer id, String username, String password, String fullname, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
	}
}
