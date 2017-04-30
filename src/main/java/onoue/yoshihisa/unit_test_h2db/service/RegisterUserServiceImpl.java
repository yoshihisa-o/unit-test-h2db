package onoue.yoshihisa.unit_test_h2db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import onoue.yoshihisa.unit_test_h2db.dao.UserDao;
import onoue.yoshihisa.unit_test_h2db.entity.User;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	@Transactional
	public int registerUser(long id, String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		userDao.save(user);
		return SUCCESS;
	}
}
