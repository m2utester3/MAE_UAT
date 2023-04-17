import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver


//'Datafiles TestData, sheet test_data'
//Mobile.startExistingApplication(GlobalVariable.startAPP, FailureHandling.STOP_ON_FAILURE)

//Mobile.waitForElementPresent(findTestObject('Login Onboarding/onboardWelcomeSkipBtn'), 03)

if (Mobile.verifyElementVisible(findTestObject('Login Onboarding/onboardWelcomeSkipBtn'), 0, FailureHandling.OPTIONAL)) {
    Mobile.waitForElementPresent(findTestObject('Login Onboarding/onboardWelcomeSkipBtn'), 3000)

	Mobile.takeScreenshot()
	
    Mobile.tap(findTestObject('Login Onboarding/onboardWelcomeSkipBtn'), 0)

	Mobile.takeScreenshot()
	
    Mobile.tap(findTestObject('Login Onboarding/onboardTNCAgreeBtn'), 0)
	
}

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Dashboard/dashboardSetUpWalletIcon'), 0)


Mobile.takeScreenshot()

Mobile.tap(findTestObject('Login Onboarding/getStartedExistingUserBtn'), 0)

Mobile.setText(findTestObject('Login Onboarding/loginExistingUsernameInputField'), findTestData('test_data').getValue(3, 19), 0)

Mobile.hideKeyboard()

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)

Mobile.waitForElementPresent(findTestObject('Login Onboarding/loginExistingMineConfirmationBtn'), 50)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Login Onboarding/loginExistingMineConfirmationBtn'), 0)

Mobile.setText(findTestObject('Login Onboarding/loginPasswordInputField'), findTestData('test_data').getValue(3, 20), 0)

Mobile.hideKeyboard()

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)

Mobile.delay(5)

if (Mobile.verifyElementVisible(findTestObject('Login Onboarding/Proceed'), 3, FailureHandling.OPTIONAL)) {
	
	Mobile.takeScreenshot()
    Mobile.tap(findTestObject('Login Onboarding/Proceed'), 5)
} 

pinNO=findTestData('test_data').getValue(11, 1)

def length = pinNO.length()

for (def i = 0; i < length; i++) {

	def TapNo = pinNO[i]

	Mobile.tap(findTestObject('Text', [('Verify'): TapNo]),0)
}

Mobile.takeScreenshot()

'Tick button'
Mobile.tap(findTestObject('Object Repository/Dynamic Object/Tap Image Following 2',[('text'):'0']), 0)

Mobile.delay(2)

pinNO=findTestData('test_data').getValue(11, 1)

length = pinNO.length()

for (def i = 0; i < length; i++) {

	TapNo = pinNO[i]

	Mobile.tap(findTestObject('Text', [('Verify'): TapNo]),0)
}

Mobile.delay(2)

Mobile.takeScreenshot()

'Tick button'
Mobile.tap(findTestObject('Object Repository/Dynamic Object/Tap Image Following 2',[('text'):'0']), 0)

Mobile.delay(2)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Login Onboarding/loginTouchIDSetUpLaterBtn'), 0)

Mobile.delay(2)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Login Onboarding/loginVerifyNumberYesProceedBtn'), 0)

def OTP = Mobile.getText(findTestObject('Object Repository/Login Onboarding/Your OTP no. is 2'), 0)

Mobile.delay(2)

for (def i = 16; i <= 21; i++) {
	def TapNo = OTP[i]
	
	Mobile.tap(findTestObject('Text', [('Verify'): TapNo]),0)
}

Mobile.takeScreenshot()

Mobile.delay(3)

'Tick button'
Mobile.tap(findTestObject('Object Repository/Dynamic Object/Tap Image Following 2',[('text'):'0']), 0)

Mobile.waitForElementPresent(findTestObject('Login Onboarding/onboardNameInputField'), 0)

Mobile.setText(findTestObject('Login Onboarding/onboardNameInputField'), findTestData('test_data').getValue(3, 21), 0)

Mobile.hideKeyboard()

Mobile.delay(2)

Mobile.takeScreenshot()
Mobile.tap(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)

Mobile.delay(2)

//Mobile.verifyElementVisible(findTestObject('Object Repository/Transfer/onboardSelectWallet_AccountType',[('accType'):findTestData('test_data').getValue(5, 1)]), 0)
//
//Mobile.tap(findTestObject('Object Repository/Transfer/onboardSelectWallet_AccountType',[('accType'):findTestData('test_data').getValue(5, 1)]), 0)

if(Mobile.verifyElementExist(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Activate Now']), 0,FailureHandling.OPTIONAL)) {
	
	Mobile.verifyElementVisible(findTestObject('Object Repository/Transfer/onboardSelectWallet_AccountType'), 0)
	
	GlobalVariable.accType=Mobile.getText(findTestObject('Object Repository/Transfer/onboardSelectWallet_AccountType'), 10)
	
	Mobile.tap(findTestObject('Object Repository/Transfer/onboardSelectWallet_AccountType'), 0)
	
	Mobile.verifyElementExist(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)
	
	Mobile.tap(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)
	
	
}else {
	
	Mobile.verifyElementExist(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)
	
	Mobile.tap(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)
	
}

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Login Onboarding/onboardReferSkipBtn'), 0,FailureHandling.OPTIONAL)

Mobile.delay(2)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Main/mainDoneBtn'), 0)

Mobile.delay(5)

Mobile.takeScreenshot()

Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Hello,']), 0), 'Hello,')

Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Wallet']), 0), 'Wallet')

Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Quick Actions']), 0), 'Quick Actions')

Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Manage']), 0), 'Manage')

Mobile.takeScreenshot()

Mobile.swipe(550, 1500, 550, 800)

Mobile.scrollToText('Order Food & More')

Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Order Food & More']), 0), 'Order Food & More')

Mobile.takeScreenshot()

'Home button'
Mobile.tap(findTestObject('Object Repository/Dashboard/dashboard_homeButton'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Dashboard/mainBottomMenuMaybank2uBtn'), 0)

Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Kill Switch']), 0), 'Kill Switch')

body='You can now temporarily deactivate your M2U access in just a few quick taps in case of fraud.'

Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : body]), 0), body)

if(Mobile.verifyElementExist(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Got It']), 0,FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Got It']), 0)

}else if(Mobile.verifyElementExist(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Next Time']), 0,,FailureHandling.OPTIONAL)) {


	Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Next Time']), 0), 'Next Time')

	Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Explore Now']), 0), 'Explore Now')

	Mobile.tap(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Next Time']), 0)

}

Mobile.verifyEqual(Mobile.getText(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Maybank2u']), 0), 'Maybank2u')



