package net.simpleLearn.hibernate.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.simpleLearn.hibernate.dao.FlightsDao;
import net.simpleLearn.hibernate.model.Flights;

/**
 * @author hazem.musallamau
 */

@WebServlet("/search-flights")
public class SearchFlightsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FlightsDao flightDao;

	public void init() {

		flightDao = new FlightsDao();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Here we can make it dateTime Object

		String date = request.getParameter("date");
		String price = request.getParameter("price");
		String persons = request.getParameter("persons");
		Double priceD = null;
		Integer personsD = null;
		if (!price.isEmpty()) {
			priceD = Double.parseDouble(price);
		}
		if (!persons.isEmpty()) {
			personsD = Integer.parseInt(persons);
		}
		Timestamp timestamp = null;
		try {
			if (!date.isEmpty()) {
				long dateTimeStamp = makeDateFormatDDMMYYYY(date.replace("T", " "));
				timestamp = new Timestamp(dateTimeStamp);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Flights> searchFlights = flightDao.search(personsD, priceD, timestamp);
		request.getSession(false).setAttribute("searchFlights", searchFlights);
		response.sendRedirect("search.jsp");
	}

	private long makeDateFormatDDMMYYYY(String dateString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = formatter.parse(dateString);
		return date.getTime();
	}
}
