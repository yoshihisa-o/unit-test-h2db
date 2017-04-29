package onoue.yoshihisa.unit_test_h2db.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import onoue.yoshihisa.unit_test_h2db.domain.dao.UserDao;
import onoue.yoshihisa.unit_test_h2db.domain.entity.User;

@Service
public class GetUserServiceImpl implements GetUserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	@Transactional
	public User getUser(long id) {
		return userDao.get(id);
	}
}
