package onoue.yoshihisa.unit_test_h2db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import onoue.yoshihisa.unit_test_h2db.client_if.request.RegisterUserRequest;
import onoue.yoshihisa.unit_test_h2db.client_if.response.RegisterUserResponse;
import onoue.yoshihisa.unit_test_h2db.domain.service.RegisterUserService;

@Controller
public class RegisterUserController {
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;

	@Autowired
	private RegisterUserService service;

	@RequestMapping("/registerUser")
	public RegisterUserResponse registerUser(RegisterUserRequest request) {
		RegisterUserResponse res = new RegisterUserResponse();
		if (service.registerUser(request.getId(), request.getName()) == RegisterUserService.SUCCESS) {
			res.setResult(SUCCESS);
		} else {
			res.setResult(FAIL);
		}
		return res;
	}
}
