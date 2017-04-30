package onoue.yoshihisa.unit_test_h2db.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import onoue.yoshihisa.unit_test_h2db.client_if.request.GetUserRequest;
import onoue.yoshihisa.unit_test_h2db.client_if.response.GetUserResponse;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-application-config.xml")
@TestExecutionListeners({
    DbUnitTestExecutionListener.class })
public class GetUserControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	GetUserController controller;

	@Test
	@DatabaseSetup("/GetUserControllerTest_INIT_PASS.xml")
	public void get_user_success() {
		GetUserRequest request = new GetUserRequest();
		request.setId(1);
		GetUserResponse response = controller.getUser(request);
		assertThat(response.getResult(), is(0));
		assertThat(response.getId(), is((long)1));
		assertThat(response.getName(), is("Test User 1"));
	}
}