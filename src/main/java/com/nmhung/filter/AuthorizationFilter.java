package com.nmhung.filter;

import com.nmhung.constant.WebConstant;
import com.nmhung.model.UserModel;
import com.nmhung.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns= {"/teacher/*"})
public class AuthorizationFilter  implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Go to AuthorizationFilter");
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		UserModel userLogin = (UserModel) SessionUtil.getInstance().getValue(servletRequest, WebConstant.USER_LOGIN);
		request.setCharacterEncoding("UTF-8");
		if (userLogin != null) {
			chain.doFilter(request, response);
		} else {
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/login?msg=not-login&alert=danger");
		}


	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
