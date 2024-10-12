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

'melakukan input username yang salah data diambil dari excel kolom ke 1 baris ke 3'
WebUI.setText(findTestObject('Login Page/textbox_username'), findTestData('Data Login').getValue(1, 3))

'memastikan textbox passwoord terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Login Page/textbox_password'))

'melakukan input password dengan data excel pada kolom ke 2 baris ke 3'
WebUI.setText(findTestObject('Login Page/textbox_password'), findTestData('Data Login').getValue(2, 3))

'memastikan button login dapat diclick'
WebUI.verifyElementClickable(findTestObject('Login Page/button_login'))

'melakukan click pada button login'
WebUI.click(findTestObject('Login Page/button_login'))

'memastikan label alert gagal login terlihat pada layar'
WebUI.verifyElementVisible(findTestObject('Login Page/label_alertAkunNotMatch'))

'get text alert gagal login'
def alert = WebUI.getText(findTestObject('Login Page/label_alertAkunNotMatch'))

'memastikan alert sudah sesuai dengan expected'
WebUI.verifyMatch(alert, 'Epic sadface: Username and password do not match any user in this service', false)

'mengambil screenshot login dengan password yang salah'
WebUI.takeScreenshotAsCheckpoint('Login with wrong username')

