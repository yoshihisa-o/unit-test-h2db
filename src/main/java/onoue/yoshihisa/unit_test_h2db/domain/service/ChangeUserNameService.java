package onoue.yoshihisa.unit_test_h2db.domain.service;

public interface ChangeUserNameService {
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;

	public int changeUserName(long id, String name);
}
