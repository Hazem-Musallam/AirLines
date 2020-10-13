package net.simpleLearn.hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hazem.musallamau
 */

@WebServlet("/book-flight")
public class BookFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flightId = req.getParameter("id");
		req.getSession(false).setAttribute("flightId", flightId);
		resp.sendRedirect("UserDetails");
	}

}
