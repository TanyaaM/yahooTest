import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import helperFunctions.Helper
import yahooPage.Mail

Mail m =new Mail()
Helper h =new Helper()

TestObject signIn = findTestObject('web/loginPage/signInLink')
TestObject createAccountLink =findTestObject('web/regesterationPage/createAccLnk')
TestObject lastNameField =findTestObject('web/regesterationPage/lastName')
TestObject firstNameField =findTestObject('web/regesterationPage/firstName')
TestObject emailField =findTestObject('web/regesterationPage/userId')
TestObject passwordField =findTestObject('web/regesterationPage/password')
TestObject monthList =findTestObject('web/regesterationPage/month')
TestObject dayField =findTestObject('web/regesterationPage/day')
TestObject yearField =findTestObject('web/regesterationPage/year')
TestObject continueButton =findTestObject('web/regesterationPage/continueBtn')
TestObject phoneField =findTestObject('web/regesterationPage/phoneNumber')
TestObject doneButton =findTestObject('web/regesterationPage/doneBtn')

m.openBrowser()
String userEmail =h.generateRandomUsername()
KeywordUtil.logInfo('New userid is '+userEmail)
m.clickElement(signIn)
m.clickElement(createAccountLink)
m.setText(firstNameField, 'test')
m.setText(lastNameField, 'bt')
m.setText(emailField, userEmail)
m.setText(passwordField, 'Automation@2023')
WebUI.selectOptionByIndex(monthList, 2)
m.setText(dayField,'1')
m.setText(yearField,'1990')
m.clickElement(continueButton)
//User have to pass a valid contact number
m.setText(phoneField,'7894561230')
m.clickElement(continueButton)
//keeping hard delay as manual intervention is needed as proof you are not robot/captcha validation is present that cant be automated   
Thread.sleep(30000)
m.clickElement(doneButton)
String actualLandingPageTitle =WebUI.getWindowTitle()
String expectedLandingPageTitle ="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"
if(actualLandingPageTitle.equals(expectedLandingPageTitle)) {
	KeywordUtil.logInfo('User landed to expected home page'+actualLandingPageTitle)
}else {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('User is not landed to home page'+actualLandingPageTitle)
}
m.closeBrowser()



