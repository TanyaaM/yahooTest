import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import yahooPage.Mail
import helperFunctions.Helper
Mail m =new Mail()
Helper h =new Helper()

TestObject signIn = findTestObject('web/loginPage/signInLink')
TestObject nextBtn = findTestObject('web/loginPage/nextBtn')
TestObject username = findTestObject('web/loginPage/usernameField')
TestObject forgotPassword = findTestObject('web/loginPage/forgotPwd')
TestObject newPassword = findTestObject('web/loginPage/passwordField')
TestObject emailCodeBtn =findTestObject('web/forgotPasswordPage/emailCode')
TestObject recoveryMail =findTestObject('web/forgotPasswordPage/recoveryMailField')
TestObject sendButton =findTestObject('web/forgotPasswordPage/sendBtn')
TestObject verifyCode =findTestObject('web/forgotPasswordPage/verifyCodeBtn')
TestObject continueButton=findTestObject('web/forgotPasswordPage/continueBtn')
TestObject successMsg=findTestObject('web/forgotPasswordPage/successfullMsg')
TestObject looksGoodButton =findTestObject('web/forgotPasswordPage/looksGoodBtn')
TestObject continueAgainButton =findTestObject('web/forgotPasswordPage/continueAgainBtn')

m.openBrowser()
String newGeneratedPassword =h.generatePassword(12)
KeywordUtil.logInfo('New password generated is'+newGeneratedPassword)
m.clickElement(signIn)
m.setText(username, 'tabtest110@yahoo.com')
m.clickElement(nextBtn)
m.clickElement(forgotPassword)
m.clickElement(emailCodeBtn)
m.setText(recoveryMail, 'tanya123mahajan@gmail.com')
m.clickElement(sendButton)
//Passing hard delay to enter otp
Thread.sleep(30000)
m.clickElement(verifyCode)
m.setText(newPassword, newGeneratedPassword)
m.clickElement(continueButton)
if(WebUI.verifyElementPresent(successMsg, 10, FailureHandling.OPTIONAL)) {
	String actualSuccessMessage =WebUI.getText(successMsg)
	KeywordUtil.logInfo('Password is updated successfully'+actualSuccessMessage)
	WebUI.takeScreenshot()
	m.clickElement(continueAgainButton)
	m.clickElement(looksGoodButton)
	String actualLandingPageTitle =WebUI.getWindowTitle()
	String expectedLandingPageTitle ="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"
	if(actualLandingPageTitle.equals(expectedLandingPageTitle)) {
		KeywordUtil.markPassed('User landed to expected home page after changing the password'+actualLandingPageTitle)
	}else {
		WebUI.takeScreenshot()
		KeywordUtil.markFailed('User is not landed to expected home page after changing the password'+actualLandingPageTitle)
	}
} else {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('Password is not updated successfully')
}
m.closeBrowser()