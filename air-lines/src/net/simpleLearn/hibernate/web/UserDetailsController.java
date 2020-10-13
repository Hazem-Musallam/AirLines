package net.simpleLearn.hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.simpleLearn.hibernate.dao.BokingDao;
import net.simpleLearn.hibernate.dao.FlightsDao;
import net.simpleLearn.hibernate.model.Flights;
import net.simpleLearn.hibernate.model.UserBooking;

/**
 * @author hazem.musallamau
 */

@WebServlet("/UserDetails")
public class UserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BokingDao bookingDao;
	private FlightsDao flightDao;

	@Override
	public void init() throws ServletException {
		bookingDao = new BokingDao();
		flightDao = new FlightsDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("userDetails.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");

		String flightId = (String) request.getSession(false).getAttribute("flightId");
		Flights flight = flightDao.getById(Integer.parseInt(flightId));

		UserBooking booking = new UserBooking();
		booking.setFirstName(firstName);
		booking.setLastName(lastName);
		booking.setPhone(phone);
		booking.setFlight(flight);
		bookingDao.save(booking);
		request.getSession(false).setAttribute("booking", booking);
		response.sendRedirect("pay");
	}

}
