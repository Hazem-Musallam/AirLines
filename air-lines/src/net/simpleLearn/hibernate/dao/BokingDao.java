package net.simpleLearn.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.simpleLearn.hibernate.model.Places;
import net.simpleLearn.hibernate.model.UserBooking;
import net.simpleLearn.hibernate.util.HibernateUtil;

public class BokingDao {

	public List<Places> getAllPlaces() {

		Transaction transaction = null;
		List<Places> allPlaces = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			allPlaces = (List<Places>) session.createQuery("FROM Places ").getResultList();

			if (allPlaces != null) {
				return allPlaces;
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

	public void save(UserBooking booking) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the PLace object
			session.save(booking);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void delete(Integer place) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.createQuery("DELETE FROM Places p WHERE p.id = :id").setParameter("id", place).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void update(UserBooking booking) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the PLace object
			session.update(booking);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
