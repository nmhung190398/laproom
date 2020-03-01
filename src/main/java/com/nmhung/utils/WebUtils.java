package com.nmhung.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {
	public static void dispatcher(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}

	public static void sendRedirect(HttpServletResponse response, String url) throws IOException {
		response.sendRedirect(url);
	}



}
