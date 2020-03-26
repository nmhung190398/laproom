package com.nmhung.filter;
import com.nmhung.constant.RoleConstant;
import com.nmhung.constant.WebConstant;
import com.nmhung.model.UserModel;
import com.nmhung.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet Filter implementation class AuthenticationFilter
 */

//
@WebFilter(urlPatterns= {"/admin/*"})
public class AuthorizationAdminFilter implements Filter {

	/**
	 * Default constructor.
	 */

	private ServletContext context;

	public AuthorizationAdminFilter() {
		// TODO Auto-generated constructor stub


	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("Go to AuthorizationFilter");
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		request.setCharacterEncoding("UTF-8");

		UserModel userLogin = (UserModel) SessionUtil.getInstance().getValue(servletRequest, WebConstant.USER_LOGIN);
		if (userLogin != null) {

			if (userLogin.getRole().getCode().equalsIgnoreCase(RoleConstant.ADMIN)) {
				chain.doFilter(request, response);
			} else {
				servletResponse.sendRedirect(servletRequest.getContextPath() + "/403");
			}

		} else {
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/login?msg=not-login&alert=danger");

		}

		// pass the request along the filter chain
		// chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub

		context = fConfig.getServletContext();

	}

}
