package onoue.yoshihisa.unit_test_h2db.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onoue.yoshihisa.unit_test_h2db.domain.repository.RegisterUserRepository;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

	@Autowired
	RegisterUserRepository repository;
	
	public int registerUser(String id, String name) {
		return 0;
	}

}
