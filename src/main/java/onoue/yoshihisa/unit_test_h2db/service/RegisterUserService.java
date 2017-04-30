package onoue.yoshihisa.unit_test_h2db.service;

public interface RegisterUserService {
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;

	public int registerUser(long id, String name);
}
