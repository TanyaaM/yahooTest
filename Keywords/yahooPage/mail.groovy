package yahooPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable



class Mail {
	/**
	 * open browser and maximize the window
	 */
	@Keyword
	def openBrowser() {
		if(GlobalVariable.platform=='web') {
			WebUI.openBrowser('https://www.yahoo.com/')
			WebUI.maximizeWindow()
		} else {
			Mobile.startExistingApplication('com.yahoo.mobile.client.android.mail')
		}
	}
	/*
	 * This function will close the browser
	 */
	@Keyword
	def closeBrowser() {
		if(GlobalVariable.platform=='web') {
			WebUI.closeBrowser()
		} else {
			Mobile.closeApplication()
		}
	}
	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	@Keyword
	def setText(TestObject to, String text) {
		try {
			WebUI.sendKeys(to, text)
			KeywordUtil.markPassed("Successfully text is entered in textbox")
		}catch (Exception e) {
			KeywordUtil.markFailed("Fail to set text in textfield")
		}
	}
	
}