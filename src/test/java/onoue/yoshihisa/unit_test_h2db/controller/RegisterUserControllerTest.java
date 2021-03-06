package onoue.yoshihisa.unit_test_h2db.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

import onoue.yoshihisa.unit_test_h2db.client_if.request.RegisterUserRequest;
import onoue.yoshihisa.unit_test_h2db.client_if.response.RegisterUserResponse;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from "classpath:/test-application-config.xml
@ContextConfiguration(locations="/test-application-config.xml")
@TestExecutionListeners({
	DbUnitTestExecutionListener.class })
public class RegisterUserControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
	// Never use "new" to instantiate. Otherwise Autowired in the following class will not work.
	@Autowired
	RegisterUserController controller;

	@Test
	@ExpectedDatabase("/RegisterUserControllerTest_EXPECTED_PASS.xml")
	public void register_user_success() {
		RegisterUserRequest request = new RegisterUserRequest();
		request.setId(1);
		request.setName("Test User 1");
		RegisterUserResponse response = controller.registerUser(request);
		assertThat(response.getResult(), is(0));
	}
}