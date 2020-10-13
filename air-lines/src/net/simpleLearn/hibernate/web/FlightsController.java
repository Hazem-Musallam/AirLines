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
import javax.servlet.http.HttpSession;

import net.simpleLearn.hibernate.dao.AirLineDao;
import net.simpleLearn.hibernate.dao.FlightsDao;
import net.simpleLearn.hibernate.dao.PlacesDao;
import net.simpleLearn.hibernate.model.AirLines;
import net.simpleLearn.hibernate.model.Flights;
import net.simpleLearn.hibernate.model.Places;

/**
 * @author hazem.musallamau
 */

@WebServlet("/flights")
public class FlightsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlacesDao placeDao;
	private AirLineDao airLineDao;
	private FlightsDao flightDao;

	public void init() {
		placeDao = new PlacesDao();
		airLineDao = new AirLineDao();
		flightDao = new FlightsDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Places> allPlaces = placeDao.getAllPlaces();
		HttpSession session = request.getSession(false);
		session.setAttribute("palces", allPlaces);

		List<AirLines> airLines = airLineDao.getAirLines();
		session.setAttribute("airLines", airLines);

		List<Flights> flights = flightDao.getFlights();
		session.setAttribute("flights", flights);

		response.sendRedirect("flights.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Here we can make it dateTime Object
		String date = request.getParameter("date");
		String price = request.getParameter("price");
		String persons = request.getParameter("persons");
		String airLineId = request.getParameter("airLine");
		String placeId = request.getParameter("place");

		AirLines airLine = airLineDao.getById(Integer.parseInt(airLineId));
		Places place = placeDao.getById(Integer.parseInt(placeId));

		Double priceD = Double.parseDouble(price);
		Integer personsD = Integer.parseInt(persons);
		Timestamp timestamp = null;
		try {
			long dateTimeStamp = makeDateFormatDDMMYYYY(date.replace("T", " "));
			timestamp = new Timestamp(dateTimeStamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Flights flight = new Flights();
		flight.setAirLines(airLine);
		flight.setPlace(place);
		flight.setNumberOfPersons(personsD);
		flight.setTicketPrice(priceD);
		flight.setDate(timestamp);
		flightDao.save(flight);

		response.sendRedirect("flights");
	}

	private long makeDateFormatDDMMYYYY(String dateString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = formatter.parse(dateString);
		return date.getTime();
	}
}
