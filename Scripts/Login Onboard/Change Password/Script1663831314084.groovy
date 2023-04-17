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
import org.openqa.selenium.Keys

import com.my.keywords.application
import com.my.keywords.tapPIN as tapPIN



//application.startApp()

Mobile.tap(findTestObject('Change Password/More_Button'), 0)

Mobile.tap(findTestObject('Change Password/Settings Button'), 0)

Mobile.tap(findTestObject('Change Password/Maybank2u Option'), 0)

Password=findTestData('test_data').getValue(3, 20)
newPassword=findTestData('test_data').getValue(3, 22)

if (Mobile.verifyElementVisible(findTestObject('Change Password/Password Verify'), 0, FailureHandling.OPTIONAL)) {
    Mobile.setText(findTestObject('Change Password/Password Login'), Password, 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Change Password/Continue'), 0)
}

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Change Password/Change Password'), 0)

'adjust in Variable, must change to New Password once run first time'
Mobile.setText(findTestObject('Change Password/Enter Current Passwrod'), Password, 0)

'adjust in variable'
Mobile.setText(findTestObject('Change Password/Enter New Password'), newPassword, 0)

Mobile.setText(findTestObject('Change Password/Confirm New Password'), newPassword, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Change Password/Continue'), 0)

Mobile.delay(5)

def Page = Mobile.getText(findTestObject('Festive Season/returnAngpaoStatusMessageTxt'), 10)

switch (Page) {
	case 'Secure2u authorisation':
		tapPIN.tapS2U(findTestData('Verify').getValue(4, 2))
		
		if(findTestData('Verify').getValue(4, 2)=='Approve'){
			
			Mobile.takeScreenshot()
			Mobile.verifyElementText(findTestObject('Object Repository/others/PIN/settingsPINSuccessTxt'), findTestData('Setting').getValue(
						4, 44))
		
		}else {
		'Transaction status verification'
		WebUI.callTestCase(findTestCase('Test Cases/Pages/Transaction Summary'), ['addFav':'N'], FailureHandling.CONTINUE_ON_FAILURE)
	
		}

		
		break
	case 'Transaction Authorisation Code':
		
		tapPIN.tapTAC()
		
		break


}

Mobile.takeScreenshot()
