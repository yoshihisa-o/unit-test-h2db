package onoue.yoshihisa.unit_test_h2db.domain.dao;

import onoue.yoshihisa.unit_test_h2db.domain.entity.User;

public interface UserDao {
	public User get(long id);
	public void save(User user);
	public void update(User user);
}
