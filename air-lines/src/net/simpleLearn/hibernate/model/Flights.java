package net.simpleLearn.hibernate.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flights implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "ticket_price")
	private double ticketPrice;

	@Column(name = "flight_date")
	private Timestamp date;

	@Column(name = "number_of_personse")
	private int numberOfPersons;
	@ManyToOne
	@JoinColumn(name = "place_id")
	private Places place;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "airLines_id")
	private AirLines airLines;

	@OneToOne(mappedBy = "flight")
	private UserBooking booking;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Places getPlace() {
		return place;
	}

	public void setPlace(Places place) {
		this.place = place;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public AirLines getAirLines() {
		return airLines;
	}

	public void setAirLines(AirLines airLines) {
		this.airLines = airLines;
	}

	public UserBooking getBooking() {
		return booking;
	}

	public void setBooking(UserBooking booking) {
		this.booking = booking;
	}

}
