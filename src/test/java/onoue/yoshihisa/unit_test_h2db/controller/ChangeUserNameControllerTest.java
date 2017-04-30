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
import com.github.springtestdbunit.annotation.ExpectedDatabase;

import onoue.yoshihisa.unit_test_h2db.client_if.request.ChangeUserNameRequest;
import onoue.yoshihisa.unit_test_h2db.client_if.response.ChangeUserNameResponse;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from "classpath:/test-application-config.xml
@ContextConfiguration(locations="/test-application-config.xml")
// Need for @DatabaseSetup and @ExpectedDatabase to be executed
@TestExecutionListeners({DbUnitTestExecutionListener.class })
public class ChangeUserNameControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
	// Never use "new" to instantiate. Otherwise Autowired in the following class will not work.
	@Autowired
	ChangeUserNameController controller;

	@Test
	// Initialize DB with this data set. Put the file on somewhere in classpath.
	@DatabaseSetup("/ChangeUserNameControllerTest_INIT_PASS.xml")
	// Compare the contents of DB with this data set after finishing this test
	@ExpectedDatabase("/ChangeUserNameControllerTest_EXPECTED_PASS.xml")
	public void register_user_success() {
		ChangeUserNameRequest request = new ChangeUserNameRequest();
		request.setId(1);
		// Update the name of the user to "Test User 2"
		request.setName("Test User 2");
		// Call controller
		ChangeUserNameResponse response = controller.changeUserName(request);
		assertThat(response.getResult(), is(0));
	}
}