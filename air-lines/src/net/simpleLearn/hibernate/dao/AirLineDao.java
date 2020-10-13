package net.simpleLearn.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.simpleLearn.hibernate.model.AirLines;
import net.simpleLearn.hibernate.model.User;
import net.simpleLearn.hibernate.util.HibernateUtil;

public class AirLineDao {

	public List<AirLines> getAirLines() {

		Transaction transaction = null;
		List<AirLines> allAirLines = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			allAirLines = (List<AirLines>) session.createQuery("FROM AirLines ").getResultList();

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

	public void save(AirLines place) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the PLace object
			session.save(place);
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
			session.createQuery("DELETE FROM AirLines p WHERE p.id = :id").setParameter("id", id).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public AirLines getById(Integer airLineId) {
		Transaction transaction = null;
		AirLines airLines = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			airLines = (AirLines) session.createQuery("FROM AirLines where id=:id").setParameter("id", airLineId)
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

}
