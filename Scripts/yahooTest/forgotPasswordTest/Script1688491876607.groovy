import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
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