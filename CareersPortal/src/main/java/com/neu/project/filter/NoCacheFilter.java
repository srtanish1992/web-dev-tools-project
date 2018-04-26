package com.neu.project.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class NoCacheFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, max-age=0, post-check=0, pre-check=0");
		res.setHeader("Pragma", "no-cache");
		res.setDateHeader("Expires", 0);
		res.setHeader("Last-Modified", new Date().toString());
		fc.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
