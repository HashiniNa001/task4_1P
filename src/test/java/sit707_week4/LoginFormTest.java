package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s223021831";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "N G H Madushani";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		System.out.println("[Empty username, Empty password] >> " + status);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	@Test
    public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "xyz");
        System.out.println("[Empty username, Wrong password] >> " + status);
        Assert.assertFalse(status.isLoginSuccess());
    }
	
	@Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        System.out.println("[Empty username, Correct password] >> " + status);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", null);
        System.out.println("[Wrong username, Empty password] >> " + status);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", "xyz");
        System.out.println("[Wrong username, Wrong password] >> " + status);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        System.out.println("[Wrong username, Correct password] >> " + status);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", null);
        System.out.println("[Correct username, Empty password] >> " + status);
        Assert.assertFalse(status.isLoginSuccess());
    }
    
    @Test
    public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", "xyz");
        System.out.println("[Correct username, Wrong password] >> " + status);
        Assert.assertFalse(status.isLoginSuccess());
    }
    
    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndEmptyValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        System.out.println("[Correct username, Correct password] >> " + status);
        Assert.assertTrue(status.isLoginSuccess());
    }

    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndWrongValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        System.out.println("[Correct username, Correct password] >> " + status);
        Assert.assertFalse(status.isLoginSuccess());
    }

    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndCorrectValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        System.out.println("[Correct username, Correct password] >> " + status);
        Assert.assertFalse(status.isLoginSuccess());
        if (status.isLoginSuccess()) {
            Assert.assertFalse(LoginForm.validateCode(null));
            Assert.assertFalse(LoginForm.validateCode("abcd"));
            Assert.assertTrue(LoginForm.validateCode("123456"));
        }
    }
}
