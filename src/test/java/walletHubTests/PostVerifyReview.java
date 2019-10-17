package walletHubTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wallethub.utility.Driver;
import com.wallethuby.pages.wallethub.WalletHubRating;

public class PostVerifyReview extends Driver {

	private WalletHubRating wb;
	private String reviewMessage = "WalletHub is the first-ever website to offer free credit scores and full credit reports that are updated on a daily basis. thankss";

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		wb = new WalletHubRating(driver);
	}

	@Test
	public void postAndVerifyReview() throws IOException {
		wb.writeReview(reviewMessage);

		String actualReview = wb.getMyreviewElement().getText();
		Assert.assertEquals(actualReview, reviewMessage, "Actual and expected reviews didnt match");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
