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

'memastikan textbox username terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Login Page/textbox_username'))

'melakukan input locked username'
WebUI.setText(findTestObject('Login Page/textbox_username'), findTestData('Data Login').getValue(1, 7))

'memastikan textbox password terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Login Page/textbox_password'))

'melakukan input password'
WebUI.setText(findTestObject('Login Page/textbox_password'), findTestData('Data Login').getValue(2, 7))

'memastikan button login dapat diclick'
WebUI.verifyElementClickable(findTestObject('Login Page/button_login'))

'melakukan click pada button login'
WebUI.click(findTestObject('Login Page/button_login'))

'get text message alert locked user'
def alert = WebUI.getText(findTestObject('Login Page/label_alertAkunNotMatch'))

'memastikan alert sudah sesuai dengan expected'
WebUI.verifyMatch(alert, 'Epic sadface: Sorry, this user has been locked out.', false)

'mengambil screenshot locked user'
WebUI.takeScreenshotAsCheckpoint('Locked out user')

