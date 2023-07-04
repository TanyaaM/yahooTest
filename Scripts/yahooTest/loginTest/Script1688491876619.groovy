import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil
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
m.setText(username, 'tanyamahajan06@yahoo.com')
m.clickElement(nextBtn)
m.setText(password, 'M@gicworld06')
m.clickElement(nextPwdBtn)
String actualHomePageTitle =WebUI.getWindowTitle()
if(actualHomePageTitle.equals(expectedHomePageTitle)) {
	KeywordUtil.logInfo('User landed to expected home page'+actualHomePageTitle)
	m.clickElement(mailIcon)
}else {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('User is not landed to home page'+actualHomePageTitle)
}




