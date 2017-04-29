package onoue.yoshihisa.unit_test_h2db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import onoue.yoshihisa.unit_test_h2db.client_if.request.GetUserRequest;
import onoue.yoshihisa.unit_test_h2db.client_if.response.GetUserResponse;
import onoue.yoshihisa.unit_test_h2db.domain.service.GetUserService;

@Controller
@RequestMapping("/getUser")
public class GetUserController {
	@Autowired
	private GetUserService service;

	public GetUserResponse registerUser(GetUserRequest request) {
		return null;
	}
}
