package kdf;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {

//Adding changes to the code

	@Test
	public void verifyInvalidLoginTest() throws IOException {
		String[][] data = GenericMethods.getData("C:\\Users\\sanke\\Documents\\Selenium\\TestData.xlsx", "sheet2");
		for(int i=1;i<data.length;i++) {
			switch (data[i][3]) {
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxWindow":
				Methods.maximizeBrowserWindow();
				break;
			case "implicitWait":
				Methods.implWait();
				break;
			case "navigateToAUT":
				Methods.navigateApplication(data[i][6]);
				break;
			case "enterUsername":
				Methods.enterUsername(data[i][4], data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4], data[i][5], data[i][6]);
				break;
			case "clickSignIn":
				Methods.clickLoginButton(data[i][4], data[i][5]);
				break;
			case "verifyMessage":
				String actualMsg = Methods.verifyErrorMsg(data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeApplication":
				Methods.closeApplication();
				break;

			}

		}
	}



}


