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

WebUI.verifyElementVisible(findTestObject('Login Page/textbox_username'))

WebUI.setText(findTestObject('Login Page/textbox_username'), findTestData('Data Login').getValue(1, 1))

WebUI.verifyElementVisible(findTestObject('Login Page/textbox_password'))

WebUI.setText(findTestObject('Login Page/textbox_password'), findTestData('Data Login').getValue(2, 1))

WebUI.verifyElementClickable(findTestObject('Login Page/button_login'))

WebUI.click(findTestObject('Login Page/button_login'))

WebUI.verifyElementVisible(findTestObject('Product Page/label_headerProduct'))

def headerProduct = WebUI.getText(findTestObject('Product Page/label_headerProduct'))

WebUI.verifyMatch(headerProduct, 'Products', false)

WebUI.takeScreenshotAsCheckpoint('Berhasil Login')

