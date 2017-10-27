package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import bean.CityBean;
import bean.UserBean;

public class UserDAO {
	private Configuration configuration;
	private SessionFactory sessionFactory;
	private Session session;

	public boolean addUser(String name, int userId) {

		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			UserBean userBean = new UserBean();
			userBean.setUserName(name);
			CityBean bean = new CityBean();
			bean.setCityId(userId);
			userBean.setCity(bean);
			session.save(userBean);
			session.getTransaction().commit();
			System.out.println("\n\n Details Added \n");
			return true;
		} catch (HibernateException e) {
			System.out.println("Exception");
			return false;
		}

	}

	public List<UserBean> listUser() {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query<UserBean> query = session.createQuery("from UserBean");
			List<UserBean> User = query.getResultList();
			session.getTransaction().commit();
			return User;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception");
		}
		return null;
	}

	public UserBean getBYPK(int userId) {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query<UserBean> query = session.createQuery("from UserBean where userId=" + userId);
			UserBean bean = query.getSingleResult();
			return bean;
		} catch (HibernateException e) {
			System.out.println();
			return null;
		}

	}

	public boolean updateUser(int userId, String userName, int cityId) {

		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			UserBean bean = session.get(UserBean.class, userId);
			bean.setUserName(userName);

			CityBean cityBean = new CityBean();
			cityBean.setCityId(cityId);
			bean.setCity(cityBean);

			session.update(bean);
			session.getTransaction().commit();

			return true;
		} catch (HibernateException e) {
			return false;
		}

	}

	public boolean deleteUser(int userId) {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			UserBean bean = session.get(UserBean.class, userId);
			session.delete(bean);
			session.getTransaction().commit();

			return true;
		} catch (HibernateException e) {
			return false;
		}

	}

}
