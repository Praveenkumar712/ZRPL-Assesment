package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseObject.BaseObjects;


public class Login extends BaseObjects{
	
	
	public Login(WebDriver driver) {

		super(driver);
		
		}


	@FindBy(xpath="//input[@class='dont_have active']")
	 public WebElement instituteemailidradiobutton;
	@FindBy(xpath="//input[@class='dont_have active']")
	 public WebElement personalemailidradiobutton;
	@FindBy(xpath="(//p[@class='ptext'])[3]") 			
	public WebElement personalemailidradiobutton1;
	
	@FindBy(xpath="(//p[@class='ptext'])[2]") 			
	public WebElement mobileNumradioOption;
	@FindBy(xpath="//input[@class='dont_have active']")
	public WebElement mobileNumradiobutton;
	@FindBy(xpath="//input[@id='mobile_number']") 		
	 public WebElement mobileNumtextfield;
	@FindBy(xpath="//button[@id='send_mobile_login_link']")
	public WebElement mobilenumsendOTPbutton;
	@FindBy(xpath="//input[@id='otpVerify']")			
	public WebElement mobilenumverifyOTPfield;
	@FindBy(xpath="//button[@id='submitOTP']")			
	public WebElement mobilenumverifyOTPbutton;
	@FindBy(xpath="//div[@class='mage-error']")			
	public WebElement invalidmobilefielderrormsg;
	@FindBy(xpath="//p[@class='otp-error']")			
	public WebElement mobilenumverifyOTPfielderrormsg;
	@FindBy(xpath="//input[@id='popup_email_address']")	
	public WebElement instituteemailaddressfield;
	@FindBy(xpath="//button[@id='submitEmail']")		
	public WebElement instituteemailaddressfieldsendOTPbutton;
	@FindBy(xpath="//p[@class='enter_email_error']")	
	public WebElement instituteemailaddressfielderrormsg;//Please enter institute Email Id
	
	@FindBy(xpath="//input[@id='home_email']") 			
	public WebElement personalemailidtextfield;
	@FindBy(xpath="//button[text()='Send OTP']") 		
	public WebElement sendotpbutton;
	@FindBy(xpath="//input[@class='custom_input']") 
	public WebElement verifyotpfield;
	@FindBy(xpath="//button[@id='submitOTP']") 			
	public WebElement verifyotpbutton;
	@FindBy(xpath="//div[@id='home_email-error']") 	
	public WebElement invalidemailerror;
	@FindBy(xpath="//p[@class='otp-error']")			
	public WebElement verifyfielderrormesg;
	@FindBy(xpath="//a[text()='Resend OTP']")			
	public WebElement sendotptext;
	
//	Registration form
	
	@FindBy(xpath="//input[@id='emp_name']")			
	public WebElement registerpagestudentnamefield;
	@FindBy(xpath="//input[@id='institute_name']")		
	public WebElement registerpageinstituenamefield;
	@FindBy(xpath="//div[@id='emp_name-error']")		
	public WebElement registerpagestudentnamefielderrormsg;
	@FindBy(xpath="//div[@id='institute_name-error']")	
	public WebElement registerpageinstituenamefielderrormsg;
	@FindBy(xpath="//input[@value='student_id']")		
	public WebElement registerpageuploadstudentidradiobutton;
	@FindBy(xpath="//input[@value='student_document']")	
	public WebElement registerpageuploadstudentdocumentradiobutton;
	@FindBy(xpath="//input[@id='document_image']")		
	public WebElement registerpagestudentdocchoosefile;
	@FindBy(xpath="//input[@id='front_image']")			
	public WebElement registerpagestudentidchoosefilefront;
	@FindBy(xpath="//input[@id='back_image']")			
	public WebElement registerpagestudentidchosefileback;
	@FindBy(xpath="//button[@id='submitInsDetails']")	
	public WebElement registerpagesubmitbutton;
}
