package com.wisdom.demo.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.wisdom.demo.pojo.Conference;
import com.wisdom.demo.util.HibernateUtil;

public class ConferenceManager {

	public boolean saveConferenceData(Conference conference) {
		Session session = null;
		Transaction transaction = null;
		boolean saveState = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(conference);
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return saveState;
	}

	public List<Conference> loadConference() {
		Session session = null;
		List<Conference> resultList = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cf = session.createCriteria(Conference.class);
			resultList = cf.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;

	}

}
