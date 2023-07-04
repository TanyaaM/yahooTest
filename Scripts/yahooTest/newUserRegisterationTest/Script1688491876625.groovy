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
import helperFunctions.Helper

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

m.openBrowser()
String userEmail =h.generateRandomUsername()
KeywordUtil.logInfo('............'+userEmail)
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
m.setText(phoneField,'9888128618')
m.clickElement(continueButton)
//keeping hard delay as manual intervention is needed as proof you are not robot/captcha validation is present that cant be automated   
Thread.sleep(30000)



