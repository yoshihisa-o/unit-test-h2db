package onoue.yoshihisa.unit_test_h2db.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import onoue.yoshihisa.unit_test_h2db.request.RegisterUserRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="application-config.xml")
public class RegisterUserControllerTest {
	// Never use "new" to instantiate. Otherwise Autowire in the following class will not work.
	@Autowired
	RegisterUserController controller;
	
	@Before
	public void setup() {
	}

	@Test
	public void register_user_success() {
		RegisterUserRequest request = new RegisterUserRequest();
		request.setId("test_user_id");
		request.setName("Test User");
		boolean result = controller.registerUser(request);
		assertThat(result, is(true));
	}
}
