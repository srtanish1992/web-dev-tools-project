package com.neu.project.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		request.getSession(false);
		System.out.println(request.getServletPath());
		Enumeration<String> names = request.getSession().getAttributeNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			request.getSession().removeAttribute(name);
		}
		response.sendRedirect(request.getContextPath() + "/");
	}
}
