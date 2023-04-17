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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import com.my.keywords.tapPIN as tapPIN

'Datafiles TestData, sheet test_data'
//Mobile.startExistingApplication(GlobalVariable.startAPP, FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5)

Mobile.takeScreenshot()

Mobile.verifyElementExist(findTestObject('Object Repository/Dashboard/dashboard_moreButton'), 0)

Mobile.tap(findTestObject('Object Repository/Dashboard/dashboard_moreButton'), 0)

Mobile.verifyElementExist(findTestObject('Login Onboarding/moreLoginBtn'), 0)
Mobile.takeScreenshot()
Mobile.tap(findTestObject('Login Onboarding/moreLoginBtn'), 0)

Mobile.delay(3)

tapPIN.tapPINno(findTestData('test_data').getValue(11, 1))

Mobile.waitForElementPresent(findTestObject('Login Onboarding/moreLogoutBtn'), 0)
Mobile.takeScreenshot()
Mobile.tap(findTestObject('Login Onboarding/moreLogoutBtn'), 0)

Mobile.takeScreenshot()

Mobile.verifyElementText(findTestObject('Login Onboarding/logoutSuccessTxt'), 'You’ve successfully logged out. Come back again soon!')

Mobile.delay(5)

Mobile.takeScreenshot()

Mobile.verifyElementExist(findTestObject('Dashboard/dashboardWalletTopSelect'), 0)

