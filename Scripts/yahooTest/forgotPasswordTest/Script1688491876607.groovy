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
TestObject forgotPassword = findTestObject('web/loginPage/forgotPwd')
TestObject sendCodeButton = findTestObject('web/forgotPasswordPage/sendCodeBtn')
TestObject password = findTestObject('web/loginPage/passwordField')

m.openBrowser()
m.clickElement(signIn)
m.setText(username, 'tanyamahajan06@yahoo.com')
m.clickElement(nextBtn)
m.clickElement(forgotPassword)
m.clickElement(sendCodeButton)
//Passing harddelay because Manual intervention is needed to enter the otp
Thread.sleep(20000)
m.setText(password, 'Automation@2023')



//*[@name='verifyDigits']
//*[@name='sendCode']
//*[contains(text(),'Enter verification')]