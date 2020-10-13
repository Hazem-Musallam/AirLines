package net.simpleLearn.hibernate.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.simpleLearn.hibernate.dao.BokingDao;
import net.simpleLearn.hibernate.model.UserBooking;

/**
 * @author hazem.musallamau
 */

@WebServlet("/pay")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BokingDao bookingDao;

	@Override
	public void init() throws ServletException {
		bookingDao = new BokingDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("paymentDetails.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paymentID = UUID.randomUUID().toString();
		request.getSession(false).setAttribute("paymentID", paymentID);
		UserBooking booking = (UserBooking) request.getSession(false).getAttribute("booking");
		booking.setPaymentId(paymentID);
		bookingDao.update(booking);
		request.getSession(false).setAttribute("booking", booking);
		response.sendRedirect("booking-done");

	}

}
