package testcases;
import java.io.IOException;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Login;
import reusable.Baseclass;

public class Logintestcases extends Baseclass {
	Login login;
	@Test(enabled = true)
	public void loginTestPositive() throws InterruptedException, IOException {
		Login login = new Login(driver);
		try {
			// verify institute email id radio button is enabled by default
			Assert.assertTrue(login.instituteemailidradiobutton.isSelected(), "Not enabled by default");
			// click personal email id radio button
			login.personalemailidradiobutton1.click();
			// verify personal email id radio button is selected or not
			Assert.assertTrue(login.personalemailidradiobutton.isSelected(), "Not enabled after click");
			// enter personal email id in email id text field
			login.personalemailidtextfield.sendKeys("praveenkumarpothamshety@gmail.com");
			// click on send OTP 
			login.sendotpbutton.click();
			Thread.sleep(2000);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter OTP ");
			String otp = sc.nextLine();
			// wait for 10 seconds to enter OTP
			Thread.sleep(10000);
			// enter OTP in verify otp field
			login.verifyotpfield.sendKeys(otp);
			// click verify OTP button on login page
			login.verifyotpbutton.click();
			// wait 
			Thread.sleep(5000);
			// navigated to registration form then enter student name
			login.registerpagestudentnamefield.sendKeys("praveenkumar");
			// enter institute name
			login.registerpageinstituenamefield.sendKeys("JNTUH");
			// select 'upload institute document' option
			login.registerpageuploadstudentdocumentradiobutton.click();
			// click choose student document file
			login.registerpagestudentdocchoosefile.sendKeys("C:\\Users\\Shreyaksha\\Downloads\\doc.jpg");
			// click submit button
			login.registerpagesubmitbutton.click();
		} catch (Exception e) {
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void loginTestwithInvalidEmail() throws IOException {
		login = new Login(driver);
		try {
			// verify institute email id radio button is enabled by default
			Assert.assertTrue(login.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
			// click personal email id radio button
			login.personalemailidradiobutton1.click();
			// verify personal email id radio button is selected or not
			Assert.assertTrue(login.personalemailidradiobutton.isSelected(), "It is not enabled after click");
			// enter personal email id in email id text field
			login.personalemailidtextfield.sendKeys("praveenkumar");
			// click send OTP button
			login.sendotpbutton.click();
			// verify error message just below the email text field
			Assert.assertEquals(login.invalidemailerror.getText(),
					"Please enter a valid email address (Ex: johndoe@domain.com).");
		} catch (Exception e) {
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void loginTestwithnilldata() throws IOException {
		login = new Login(driver);
		try {
			// verify institute email id radio button is enabled by default
			Assert.assertTrue(login.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
			// click personal email id radio button
			login.personalemailidradiobutton1.click();
			// verify personal email id radio button is selected or not
			Assert.assertTrue(login.personalemailidradiobutton.isSelected(), "It is not enabled after click");
			// enter personal email id in email id text field
			login.personalemailidtextfield.sendKeys("");
			// click send otp button
			login.sendotpbutton.click();
			// verify error message just below the email text field
			Assert.assertEquals(login.invalidemailerror.getText(), "This is a required field.");
		} catch (Exception e) {
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void loginTestVerifyOTPWithInvalidOTP() throws InterruptedException, IOException {
		login = new Login(driver);
		try {
			// verify institute email id radio button is enabled by default
			Assert.assertTrue(login.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
			// click personal email id radio button
			login.personalemailidradiobutton1.click();
			// verify personal email id radio button is selected or not
			Assert.assertTrue(login.personalemailidradiobutton.isSelected(), "It is not enabled after click");
			// enter personal email id in email id text field
			login.personalemailidtextfield.sendKeys("praveenkumarpothamshetty@gmail.com");
			// click send otp button
			login.sendotpbutton.click();
			// enter wrong otp in verify otp field
			login.verifyotpfield.sendKeys("123456");
			// wait for 10 seconds to enter otp
			Thread.sleep(3000);
			// click verify otp button on login page
			login.verifyotpbutton.click();
			// verify error message just below verify otp text field as "OTP expired.Please
			// " Resend OTP"
			Assert.assertEquals(login.verifyfielderrormesg.getText(), "Wrong OTP, Please Enter the Correct OTP");
		} catch (Exception e) {
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void loginTestVerifyOTPWithExpiredOTP() throws InterruptedException, IOException {
		login = new Login(driver);
		try {
			// verify institute email id radio button is enabled by default
			Assert.assertTrue(login.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
			// click personal email id radio button
			login.personalemailidradiobutton1.click();
			// verify personal email id radio button is selected or not
			Assert.assertTrue(login.personalemailidradiobutton.isSelected(), "It is not enabled after click");
			// enter personal email id in email id text field
			login.personalemailidtextfield.sendKeys("praveenkumarpothamshetty@gmail.com");
			// click send otp button
			login.sendotpbutton.click();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter expired OTP on personal mail");
			String otp = sc.nextLine();
			// wait for 10 seconds to enter otp
			Thread.sleep(130000);
			// enter otp in verify otp field
			login.verifyotpfield.sendKeys(otp);
			// click verify otp button on login page
			login.verifyotpbutton.click();
			// verify error message just below verify otp text field as "OTP expired.Please
			// try Resend OTP"
			Assert.assertEquals(login.verifyfielderrormesg.getText(), "OTP expired.Please try Resend OTP");
		} catch (Exception e) {
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void loginTestVerifyOTPWithNulldataOTP() throws InterruptedException, IOException {
		login = new Login(driver);
		try {
			// verify institute email id radio button is enabled by default
			Assert.assertTrue(login.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
			// click personal email id radio button
			login.personalemailidradiobutton1.click();
			// verify personal email id radio button is selected or not
			Assert.assertTrue(login.personalemailidradiobutton.isSelected(), "It is not enabled after click");
			// enter personal email id in email id text field
			login.personalemailidtextfield.sendKeys("");
			// click send otp button
			login.sendotpbutton.click();
			// click verify otp button on login page
			login.verifyotpbutton.click();
		} catch (Exception e) {
			captureScreenshot();
		}

	}

	@Test(enabled = false)
	public void mobileNumOTPFieldValidData() throws IOException, InterruptedException {
		login = new Login(driver);
		try {
			// verify institute email id radio button is enabled by default
			Assert.assertTrue(login.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
			// click mobile number option on login page
			login.mobileNumradioOption.click();
			// verify mobile number radio button is selected or not
			Assert.assertTrue(login.mobileNumradiobutton.isSelected(), "It is not enabled after click");
			// enter mobile number in mobile number text field
			login.mobileNumtextfield.sendKeys("9347746181");
			// click send otp button
			login.mobilenumsendOTPbutton.click();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter OTP received on submitted mobile number");
			String otp = sc.nextLine();
			// wait for 10 seconds to enter otp
			Thread.sleep(10000);
			// enter otp received on submitted mobile number
			login.mobilenumverifyOTPfield.sendKeys(otp);
			// click verify otp button
			login.mobilenumverifyOTPbutton.click();
			// wait for 3 seconds
			Thread.sleep(3000);
			// capture screenshot
			// captureScreenshot();
			 
			// enter institute email address(invalid)
			login.instituteemailaddressfield.sendKeys("praveen@gmail.com");
			// click 'send OTP' button
			login.instituteemailaddressfieldsendOTPbutton.click();
			// verify error message on institute email address field
			Assert.assertEquals(login.instituteemailaddressfielderrormsg.getText(), "Please enter institute Email Id");
		} catch (Exception e) {
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void mobileNumOTPFieldInvalidData() throws IOException, InterruptedException {
		login = new Login(driver);
		try {
			// verify institute email id radio button is enabled by default
			Assert.assertTrue(login.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
			// click mobile number option on login page
			login.mobileNumradioOption.click();
			// verify mobile number radio button is selected or not
			Assert.assertTrue(login.mobileNumradiobutton.isSelected(), "It is not enabled after click");
			// enter mobile number in mobile number text field
			login.mobileNumtextfield.sendKeys("888887456");
			// click send otp button
			login.mobilenumsendOTPbutton.click();
			// verify error message
			Assert.assertEquals(login.invalidmobilefielderrormsg.getText(),
					"Please enter a valid 10-digit mobile number.");
			// wait for 3 seconds
			Thread.sleep(3000);
		} catch (Exception e) {
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void mobileNumOTPFieldNullData() throws IOException, InterruptedException {
		login = new Login(driver);
		try {
			// verify institute email id radio button is enabled by default
			Assert.assertTrue(login.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
			// click mobile number option on login page
			login.mobileNumradioOption.click();
			// verify mobile number radio button is selected or not
			Assert.assertTrue(login.mobileNumradiobutton.isSelected(), "It is not enabled after click");
			// enter personal mobile number in mobile number text field
			login.mobileNumtextfield.sendKeys("");
			// click send otp button
			login.mobilenumsendOTPbutton.click();
			// verify error message
			Assert.assertEquals(login.invalidmobilefielderrormsg.getText(),
					"Please enter a valid 10-digit mobile number.");
			// wait for 3 seconds
			Thread.sleep(3000);
		} catch (Exception e) {
			captureScreenshot();
		}
	}

	@Test(enabled = false)
	public void mobileVerifyOTPWithExpiredOTP() throws InterruptedException, IOException {
		login = new Login(driver);
		try {
			// verify institute email id radio button is enabled by default
			Assert.assertTrue(login.instituteemailidradiobutton.isSelected(), "It is not enabled by default");
			// click mobile number option on login page
			login.mobileNumradioOption.click();
			// verify mobile number radio button is selected or not
			Assert.assertTrue(login.mobileNumradiobutton.isSelected(), "It is not enabled after click");
			// enter valid mobile number in mobile number text field
			login.mobileNumtextfield.sendKeys("9347746181");
			// click send otp button
			login.sendotpbutton.click();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter expired OTP on submitted mobile number");
			String otp = sc.nextLine();
			// wait for 10 seconds to enter otp
			Thread.sleep(130000);
			// enter otp in verify otp field
			login.mobilenumverifyOTPfield.sendKeys(otp);
			// click verify otp button on login page
			login.mobilenumverifyOTPbutton.click();
			// verify error message just below verify otp text field as "OTP expired.Please
			// try Resend OTP"
			Assert.assertEquals(login.mobilenumverifyOTPfielderrormsg.getText(), "OTP expired.Please try Resend OTP");
		} catch (Exception e) {
			captureScreenshot();
		}
	}
}
