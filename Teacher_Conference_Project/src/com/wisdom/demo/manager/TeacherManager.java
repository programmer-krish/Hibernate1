package com.wisdom.demo.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.wisdom.demo.pojo.Teacher;
import com.wisdom.demo.util.HibernateUtil;

public class TeacherManager {

	public boolean saveTeacherData(Teacher teacher) {
		Session session = null;
		Transaction transaction = null;
		boolean saveState = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(teacher);
			transaction.commit();
			saveState = true;
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return saveState;
	}

	public List<Teacher> loadTeacher() {
		Session session = null;
		List<Teacher> resultList = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(Teacher.class);
			resultList = cr.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

}
