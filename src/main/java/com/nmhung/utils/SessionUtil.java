package com.nmhung.utils;

import com.nmhung.constant.RoleConstant;
import com.nmhung.constant.WebConstant;
import com.nmhung.model.UserModel;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {


	private static SessionUtil sessionUtil = null;

	public static SessionUtil getInstance() {
		if(sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}

		return sessionUtil;
	}
	public UserModel getUserLogin(HttpServletRequest request){
		return (UserModel) SessionUtil.getInstance().getValue(request, WebConstant.USER_LOGIN);
	}
	public boolean isLogin(HttpServletRequest request){
		return getUserLogin(request) != null;
	}
	public boolean isAdmin(HttpServletRequest request){
		UserModel userModel = getUserLogin(request);
		return userModel.getRole().getCode().equalsIgnoreCase(RoleConstant.ADMIN);
	}


	public void put(HttpServletRequest request, String key, Object object) {
		request.getSession().setAttribute(key, object);
	}

	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}


	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}

}
