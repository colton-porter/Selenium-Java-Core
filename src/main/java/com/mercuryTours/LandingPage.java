package com.mercuryTours;

import java.util.ResourceBundle;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Textbox;
import com.orasi.core.interfaces.impl.internal.ElementFactory;
import com.orasi.utils.Constants;
import com.orasi.utils.OrasiDriver;

public class LandingPage {
	OrasiDriver driver = null;
	
	@FindBy(name="userName") private Textbox txtUsername;
	@FindBy(name="password") private Textbox txtPassword;
	@FindBy(name="login") private Button btnLogin;
	final ResourceBundle userCredentialRepo = ResourceBundle.getBundle(Constants.USER_CREDENTIALS_PATH);

	// *********************
	// ** Build page area **
	// *********************
	public LandingPage(OrasiDriver driver){
		this.driver = driver;		
		ElementFactory.initElements(driver, this);
	}

	public boolean pageLoaded(){
		driver.page().isDomComplete();
	    return btnLogin.syncEnabled();
	}
	
	// *****************************************
	// ***Page Interactions ***
	// *****************************************

	@Step("Login from the Landing Page")
	public void login() {
		String username = userCredentialRepo.getString("MERCURYTOURS_USER");		
		String password = userCredentialRepo.getString("MERCURYTOURS_PASSWORD");	
		loginWithDetails(username, password);
	}
	
	@Step("Login from the Landing Page with invalid credentials")
	public void loginNegative() {
		loginWithDetails("blah", "blah");
	}
	
	public boolean validateLoginStatus(){
		driver.page().isDomComplete();
		return driver.getCurrentUrl().contains("mercuryreservation");
	}
	
	private void loginWithDetails(String username, String password) {
		txtUsername.set(username);
		txtPassword.setSecure(password);
		btnLogin.click();
	}

}
