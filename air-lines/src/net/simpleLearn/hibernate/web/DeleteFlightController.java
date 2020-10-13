package net.simpleLearn.hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.simpleLearn.hibernate.dao.FlightsDao;

/**
 * @author hazem.musallamau
 */

@WebServlet("/delete-flight")
public class DeleteFlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightsDao flightDao;

	public void init() {
		flightDao = new FlightsDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String place = req.getParameter("id");
		try {
			flightDao.delete(Integer.parseInt(place));
		} catch (Exception e) {
			req.getSession(false).setAttribute("error", "Used Flight");
		}
		resp.sendRedirect("flights");
	}

}
