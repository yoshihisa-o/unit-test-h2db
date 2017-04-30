package onoue.yoshihisa.unit_test_h2db.domain.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import onoue.yoshihisa.unit_test_h2db.domain.entity.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
 
	
    public UserDaoImpl() {
    }

    public UserDaoImpl(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }

	public User get(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, id);
	}

	public void save(User user) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		session.flush();
	}

	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		session.flush();
	}
}
