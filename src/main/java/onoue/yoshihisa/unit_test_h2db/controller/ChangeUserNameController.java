package onoue.yoshihisa.unit_test_h2db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import onoue.yoshihisa.unit_test_h2db.client_if.request.ChangeUserNameRequest;
import onoue.yoshihisa.unit_test_h2db.client_if.response.ChangeUserNameResponse;
import onoue.yoshihisa.unit_test_h2db.service.ChangeUserNameService;

@Controller
public class ChangeUserNameController {
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;

	@Autowired
	private ChangeUserNameService service;

	@RequestMapping("/changeUserName")
	public ChangeUserNameResponse changeUserName(ChangeUserNameRequest request) {
		ChangeUserNameResponse res = new ChangeUserNameResponse();
		if (service.changeUserName(request.getId(), request.getName()) == ChangeUserNameService.SUCCESS) {
			res.setResult(SUCCESS);
		} else {
			res.setResult(FAIL);
		}
		return res;
	}
}
