package net.simpleLearn.hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.simpleLearn.hibernate.dao.AirLineDao;

/**
 * @author hazem.musallamau
 */

@WebServlet("/delete-airline")
public class DeleteAirLineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AirLineDao airLineDao;

	public void init() {
		airLineDao = new AirLineDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String place = req.getParameter("id");
		try {
			airLineDao.delete(Integer.parseInt(place));
		} catch (Exception e) {
			req.getSession(false).setAttribute("error", "Used Air Line");
		}
		resp.sendRedirect("air-lines");
	}

}
