package onoue.yoshihisa.unit_test_h2db.dao;

import onoue.yoshihisa.unit_test_h2db.entity.User;

public interface UserDao {
	public User get(long id);
	public void save(User user);
	public void update(User user);
}
