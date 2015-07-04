package com.mycompany.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/AttributeServlet")
public class AttributeServlet extends HttpServlet {
	private static final long serialVersionUID = -4989547477543963163L;

	private String SEPARATOR_FORMAT = "%s:%s";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// example
		req.setAttribute("example", "I'm Servlet.");

		String params = Collections.list(req.getAttributeNames())
				.stream()
				.map(name -> String.format(SEPARATOR_FORMAT, name, req.getAttribute(name)))
				.collect(Collectors.joining(" , "));

		try (PrintWriter out = resp.getWriter()) {
			out.println(params);
		}
	}

}
