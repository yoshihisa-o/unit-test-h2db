package onoue.yoshihisa.unit_test_h2db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import onoue.yoshihisa.unit_test_h2db.client_if.request.GetUserRequest;
import onoue.yoshihisa.unit_test_h2db.client_if.response.GetUserResponse;
import onoue.yoshihisa.unit_test_h2db.domain.entity.User;
import onoue.yoshihisa.unit_test_h2db.domain.service.GetUserService;

@Controller
public class GetUserController {
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;

	@Autowired
	private GetUserService service;

	@RequestMapping("/getUser")
	public GetUserResponse getUser(GetUserRequest request) {
		GetUserResponse res = new GetUserResponse();
		User user = service.getUser(request.getId());
		if(user != null) {
			res.setResult(SUCCESS);
			res.setId(user.getId());
			res.setName(user.getName());
		} else {
			res.setResult(FAIL);
		}
		return res;
	}
}
