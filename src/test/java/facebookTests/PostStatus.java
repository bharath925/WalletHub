package facebookTests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wallethub.pages.FB.LoginPage;
import com.wallethub.utility.Driver;

public class PostStatus extends Driver {
	private LoginPage landPage;
	private String postMessage="Hello World";

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		landPage = new LoginPage(driver);
	}

	@Test
	public void postStatusFaceBook() throws IOException {
		landPage.loginToFaceBook();
		landPage.postNewStatus(postMessage);
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}
