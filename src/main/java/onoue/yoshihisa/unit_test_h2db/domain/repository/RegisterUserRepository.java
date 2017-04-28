package onoue.yoshihisa.unit_test_h2db.domain.repository;

import onoue.yoshihisa.unit_test_h2db.domain.entity.User;

public interface RegisterUserRepository {
	public int registerUser(User user);
}
