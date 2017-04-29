package onoue.yoshihisa.unit_test_h2db.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import onoue.yoshihisa.unit_test_h2db.controller.RegisterUserController;
import onoue.yoshihisa.unit_test_h2db.client_if.request.RegisterUserRequest;
import onoue.yoshihisa.unit_test_h2db.client_if.response.RegisterUserResponse;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from "classpath:/test-application-config.xml
@ContextConfiguration(locations="/test-application-config.xml")
public class RegisterUserControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
	// Never use "new" to instantiate. Otherwise Autowired in the following class will not work.
	@Autowired
	RegisterUserController controller;

	@Test
	public void register_user_success() {
		RegisterUserRequest request = new RegisterUserRequest();
		request.setId(1);
		request.setName("Test User");
		RegisterUserResponse response = controller.registerUser(request);
		assertThat(response.getResult(), is(0));
	}
}