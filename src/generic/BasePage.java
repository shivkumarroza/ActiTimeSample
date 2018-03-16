package generic;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	public void verifyPageIsDisplayed(WebDriver driver, String eResult)
	{
		String sETO=AutoUtil.getProperty(IAutoConst.CONFIG_PATH, "ETO");
		long ETO=Long.parseLong(sETO);
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		try {
			wait.until(ExpectedConditions.titleIs(eResult));
			Reporter.log("Expected Page "+eResult+" is Displayed",true);
		}catch(TimeoutException e)
		{
			Reporter.log("Expected Page "+eResult+" NOT is Displayed",true);
		}
	}
	
	public void verifyText(WebElement element, String eText)
	{
		String aText=element.getText();
		Assert.assertEquals(aText, eText);
	}

}
