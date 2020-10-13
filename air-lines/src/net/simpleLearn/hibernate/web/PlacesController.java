package net.simpleLearn.hibernate.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.simpleLearn.hibernate.dao.PlacesDao;
import net.simpleLearn.hibernate.model.Places;

/**
 * @author hazem.musallamau
 */

@WebServlet("/places")
public class PlacesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlacesDao placesDao;

	public void init() {
		placesDao = new PlacesDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Places> allPlaces = placesDao.getAllPlaces();
		request.getSession(false).setAttribute("palces", allPlaces);
		response.sendRedirect("places.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String placeFromName = request.getParameter("placeFromName");
		String placeToName = request.getParameter("placeToName");

		Places place = new Places();
		place.setPlaceFrom(placeFromName);
		place.setPlaceTo(placeToName);
		placesDao.save(place);

		response.sendRedirect("places");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String place = req.getParameter("id");

		placesDao.delete(Integer.parseInt(place));

		resp.sendRedirect("places");
	}

}
