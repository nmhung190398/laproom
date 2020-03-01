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
}
