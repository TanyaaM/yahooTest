import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import yahooPage.Mail

Mail m =new Mail()

TestObject signIn = findTestObject('web/loginPage/signInLink')
TestObject nextBtn = findTestObject('web/loginPage/nextBtn')
TestObject username = findTestObject('web/loginPage/usernameField')
TestObject password = findTestObject('web/loginPage/passwordField')
TestObject nextPwdBtn = findTestObject('web/loginPage/nextPasswordBtn')
TestObject mailIcon = findTestObject('web/loginPage/mailIcon')

String expectedHomePageTitle ="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"
m.openBrowser()
m.clickElement(signIn)
m.setText(username, 'androidmweb49@yahoo.com')
m.clickElement(nextBtn)
m.setText(password, 'Automation@2023')
m.clickElement(nextPwdBtn)
String actualHomePageTitle =WebUI.getWindowTitle()
if(actualHomePageTitle.equals(expectedHomePageTitle)) {
	KeywordUtil.markPassed('User landed to expected home page'+actualHomePageTitle)
	m.clickElement(mailIcon)
}else {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('User is not landed to home page'+actualHomePageTitle)
}
m.closeBrowser()




