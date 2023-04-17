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
import com.my.keywords.verifyEqual as verifyEqual
import com.my.keywords.tapPIN as tapPIN

payeeName = findTestData('Transfer').getValue(3, 204)

amount = findTestData('Transfer').getValue(3, 207)

values = findTestData('Transfer').getValue(3, 205)

AccountNo = findTestData('Transfer').getValue(3, 203)

'Today Transaction'
for (i = 0; i < GlobalVariable.count; i++) {
	
	if(Mobile.verifyElementExist(findTestObject('Text',[('Verify'):'Quick Actions']),4,FailureHandling.OPTIONAL)) {
		
		Mobile.tap(findTestObject('Text', [('Verify') : 'Pay Bills']), 0)
	
		tapPIN.enterPass(findTestData('Input').getValue(3, 2))
	}
	verifyEqual.text('BILLERS')
	
	Mobile.takeScreenshot()
	
    Mobile.tap(findTestObject('Paybill/payBillsIconSelect'), 0)

    verifyEqual.text('Pay Bills')

    Mobile.tap(findTestObject('Paybill/payBillSearchBillerInputField'), 0)

    Mobile.setText(findTestObject('Paybill/payBillBillerNameInputField'), payeeName, 0)

    Mobile.delay(3)

    Mobile.takeScreenshot()

    Mobile.tap(findTestObject('Paybill/payBillBillerSelect', [('payeeName') : payeeName]), 10)

    Mobile.tap(findTestObject('Paybill/payBillBillerSelect', [('payeeName') : payeeName]), 10)

    Mobile.delay(3)

    verifyEqual.text('Pay Bills')

    Mobile.setText(findTestObject('Paybill/PayBillAccountNumberInputField'), AccountNo, 0)

    Mobile.hideKeyboard()

    Mobile.takeScreenshot()

    Mobile.tap(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)

    verifyEqual.text('Enter amount')

    tapPIN.enterAmount(values)

    Mobile.takeScreenshot()

    verifyEqual.text('Confirmation')

    Mobile.takeScreenshot()

    verifyEqual.text(payeeName)

    Mobile.verifyEqual(Mobile.getText(findTestObject('FollowingText1', [('Verify') : payeeName]), 0).replaceAll(' ', ''), 
        AccountNo)

    verifyEqual.text(amount)

    Mobile.tap(findTestObject('Main/mainPayNowBtn'), 0)
	switch(i) {
		case 0:
			Approval(findTestData('Verify').getValue(4, 1))
			break
		case 1:
			if(findTestData('Verify').getValue(4,1)=='Approve') {
				Approval('Reject')
			}else {
				Approval('Approve')
			}
			break
		case 2:
			Mobile.delay(40)
			break	
	}
	
	Mobile.delay(5)
	
	'Transaction status verification'
	WebUI.callTestCase(findTestCase('Test Cases/Pages/Transaction Summary'), ['addFav':'N'], FailureHandling.CONTINUE_ON_FAILURE)
	
}

Mobile.delay(5)

'Future Transaction'
for (i = 0; i < GlobalVariable.count; i++) {
	
	if(Mobile.verifyElementExist(findTestObject('Text',[('Verify'):'Quick Actions']),4,FailureHandling.OPTIONAL)) {
		Mobile.tap(findTestObject('Text', [('Verify') : 'Pay Bills']), 0)
	
		tapPIN.enterPass(findTestData('Input').getValue(3, 2))
	}
	verifyEqual.text('BILLERS')
	
	Mobile.takeScreenshot()
	
	
	Mobile.tap(findTestObject('Paybill/payBillsIconSelect'), 0)

	verifyEqual.text('Pay Bills')

	Mobile.tap(findTestObject('Paybill/payBillSearchBillerInputField'), 0)

	Mobile.setText(findTestObject('Paybill/payBillBillerNameInputField'), payeeName, 0)

	Mobile.delay(3)

	Mobile.takeScreenshot()

	Mobile.tap(findTestObject('Paybill/payBillBillerSelect', [('payeeName') : payeeName]), 10)

	Mobile.tap(findTestObject('Paybill/payBillBillerSelect', [('payeeName') : payeeName]), 10)

	Mobile.delay(3)

	verifyEqual.text('Pay Bills')

	Mobile.setText(findTestObject('Paybill/PayBillAccountNumberInputField'), AccountNo, 0)

	Mobile.hideKeyboard()

	Mobile.takeScreenshot()

	Mobile.tap(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)

	verifyEqual.text('Enter amount')

	tapPIN.enterAmount(values)

	Mobile.takeScreenshot()

	verifyEqual.text('Confirmation')

	Mobile.takeScreenshot()

	verifyEqual.text(payeeName)

	Mobile.verifyEqual(Mobile.getText(findTestObject('FollowingText1', [('Verify') : payeeName]), 0).replaceAll(' ', ''),
		AccountNo)

	verifyEqual.text(amount)

	Mobile.tap(findTestObject('Text',[('Verify'):'Today']),0)

	Mobile.delay(3)
	
	'Go to next month date'
	Mobile.swipe(800, 1600,200, 1600)
	
	Mobile.tap(findTestObject('Text',[('Verify'):'Done']),0)
	
	Mobile.delay(3)
	
	Mobile.tap(findTestObject('Main/mainPayNowBtn'), 0)
	
	switch(i) {
		case 0:
			Approval(findTestData('Verify').getValue(4, 1))
			break
		case 1:
			if(findTestData('Verify').getValue(4,1)=='Approve') {
				Approval('Reject')
			}else {
				Approval('Approve')
			}
			break
		case 2:
			Mobile.delay(40)
			break
	}
	
	Mobile.delay(5)
	
	'Transaction status verification'
	WebUI.callTestCase(findTestCase('Test Cases/Pages/Transaction Summary'), ['addFav':'N'], FailureHandling.CONTINUE_ON_FAILURE)
	
}

Mobile.delay(5)

'Fav Transaction'
for (i = 0; i < 1; i++) {
	
	if(Mobile.verifyElementExist(findTestObject('Text',[('Verify'):'Quick Actions']),4,FailureHandling.OPTIONAL)) {
		
		Mobile.tap(findTestObject('Text', [('Verify') : 'Pay Bills']), 0)
	
		tapPIN.enterPass(findTestData('Input').getValue(3, 2))
	}
	verifyEqual.text('BILLERS')
	
	Mobile.takeScreenshot()
	
	FavName = Mobile.getText(findTestObject('Object Repository/FavList', [('No') : 1]), 0)

	FavAcc = Mobile.getText(findTestObject('Object Repository/FavList', [('No') : 2]), 0)
		
	Mobile.tap(findTestObject('Object Repository/FavList', [('No') : 1]), 0,FailureHandling.STOP_ON_FAILURE)
	
	Mobile.delay(3)
	
	tapPIN.enterAmount(values)

	if(Mobile.verifyElementExist(findTestObject('Text', [('Verify') : 'You are required to key in a TAC to complete your first-time favourite transfer.']), 5,FailureHandling.OPTIONAL)) {
		
		Mobile.delay(3)
		
		Mobile.takeScreenshot()
		
		verifyEqual.text('Confirmation')
		
		Mobile.takeScreenshot()
		
		verifyEqual.text(payeeName)			
		
		Mobile.verifyEqual(Mobile.getText(findTestObject('FollowingText1', [('Verify') : payeeName]), 0).replaceAll(' ', ''),
				AccountNo)
		
		verifyEqual.text(amount)
		
		Mobile.tap(findTestObject('Main/mainPayNowBtn'), 0)
		
		Approval('accept')
		
	}else {
		Mobile.delay(3)
		
		Mobile.takeScreenshot()
		
		verifyEqual.text('Confirmation')
		
		Mobile.takeScreenshot()
		
		verifyEqual.text(FavName)
		
		Mobile.verifyEqual(Mobile.getText(findTestObject('FollowingText1', [('Verify') : FavName]), 0).replaceAll(' ', ''),
				FavAcc)
		
		verifyEqual.text(amount)
		
		Mobile.tap(findTestObject('Main/mainPayNowBtn'), 0)
	}

	
	'Transaction status verification'
	WebUI.callTestCase(findTestCase('Test Cases/Pages/Transaction Summary'), ['addFav':'N'], FailureHandling.CONTINUE_ON_FAILURE)
	
}


def Approval(String choice) {
    if (GlobalVariable.startAPP == 'com.maybank2u.life.uat') {
        if (Mobile.verifyElementExist(findTestObject('Text', [('Verify') : 'Transaction Authorisation Code']), 10, FailureHandling.OPTIONAL)) {
            tapPIN.tapTAC()
        } else {
            verifyEqual.text('Pay Bills')

            Mobile.takeScreenshot()

            tapPIN.tapS2U(choice)
        }
    } else {
        verifyEqual.text('Pay Bills')

        Mobile.takeScreenshot()

        tapPIN.tapS2U(choice)
    }
}

