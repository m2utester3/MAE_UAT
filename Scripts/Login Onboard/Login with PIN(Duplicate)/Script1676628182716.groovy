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

'Datafiels TestData, sheet test_data'

Mobile.startExistingApplication('com.maybank2u.life.uat')

Mobile.tap(findTestObject('Main/mainMaybank2uBottomMenuBtn'), 0)

if (Mobile.verifyElementVisible(findTestObject('Main/mainEnterPINMessage'), 3, FailureHandling.OPTIONAL)) {
	
	Mobile.takeScreenshot()
	
	pinNO=findTestData('TestData').getValue(11, 1)
	
	def length = pinNO.length()

	for (def i = 0; i < length; i++) {

		def TapNo = pinNO[i]

		Mobile.tap(findTestObject('Text', [('Verify'): TapNo]),0)
	}
}


'Home button'
Mobile.tap(findTestObject('Object Repository/Dashboard/dashboard_homeButton'), 0)
