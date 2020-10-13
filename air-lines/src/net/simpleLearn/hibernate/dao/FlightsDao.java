package net.simpleLearn.hibernate.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.simpleLearn.hibernate.model.Flights;
import net.simpleLearn.hibernate.util.HibernateUtil;

public class FlightsDao {

	@SuppressWarnings("unchecked")
	public List<Flights> getFlights() {

		Transaction transaction = null;
		List<Flights> allAirLines = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			allAirLines = (List<Flights>) session.createQuery("FROM Flights ").getResultList();

			if (allAirLines != null) {
				return allAirLines;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return null;
	}

	public void save(Flights flight) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the PLace object
			session.save(flight);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void delete(Integer id) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.createQuery("DELETE FROM Flights p WHERE p.id = :id").setParameter("id", id).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public Flights getById(Integer flightId) {
		Transaction transaction = null;
		Flights airLines = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			airLines = (Flights) session.createQuery("FROM Flights where id=:id").setParameter("id", flightId)
					.uniqueResult();

			// commit transaction
			transaction.commit();
			return airLines;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return null;
	}

	public List<Flights> search(Integer personsD, Double priceD, Timestamp timestamp) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Flights> resultList = (List<Flights>) session.createQuery(
					" FROM Flights p WHERE p.ticketPrice = :priceD AND p.numberOfPersons=:numberOfPersons AND p.date=:date")
					.setParameter("priceD", priceD).setParameter("numberOfPersons", personsD)
					.setParameter("date", timestamp).getResultList();
			transaction.commit();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return new ArrayList<Flights>();
	}

}
