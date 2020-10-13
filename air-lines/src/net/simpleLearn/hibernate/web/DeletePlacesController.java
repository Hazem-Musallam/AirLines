package net.simpleLearn.hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.simpleLearn.hibernate.dao.PlacesDao;

/**
 * @author hazem.musallamau
 */

@WebServlet("/deleteplaces")
public class DeletePlacesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlacesDao placesDao;

	public void init() {
		placesDao = new PlacesDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String place = req.getParameter("id");
		try {
			placesDao.delete(Integer.parseInt(place));
		} catch (Exception e) {
			req.getSession(false).setAttribute("error", "Used Place");
		}
		resp.sendRedirect("places");
	}

}
