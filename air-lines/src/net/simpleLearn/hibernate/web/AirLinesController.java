package net.simpleLearn.hibernate.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.simpleLearn.hibernate.dao.AirLineDao;
import net.simpleLearn.hibernate.model.AirLines;

/**
 * @author hazem.musallamau
 */

@WebServlet("/air-lines")
public class AirLinesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AirLineDao airLineDao;

	public void init() {
		airLineDao = new AirLineDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<AirLines> airLines = airLineDao.getAirLines();
		request.getSession(false).setAttribute("airLines", airLines);
		response.sendRedirect("air-lines.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String airLineName = request.getParameter("airLineName");

		AirLines airLine = new AirLines();
		airLine.setAirLineName(airLineName);
		airLineDao.save(airLine);

		response.sendRedirect("air-lines");
	}

}
