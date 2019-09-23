package autoapp.automation.pages;

import autoapp.automation.utility.BrowserDriver;
import java.util.Random;

public class BasePage extends BrowserDriver{

	public BasePage(BrowserDriver driver){
		super(driver);
	}

	public static int generateRandomIntIntRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
