import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.my.keywords.tapPIN
import com.my.keywords.verifyEqual
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import internal.GlobalVariable
import com.kms.katalon.core.testcase.TestCase as TestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Mobile.startExistingApplication(GlobalVariable.startAPP, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Dashboard/mainBottomMenuMaybank2uBtn'), 0)

tapPIN.tapPINno(findTestData('Transfer').getValue(5, 1))

GlobalVariable.accType=Mobile.getText(findTestObject('Object Repository/Dynamic Object/Account Detail', [('index') : 1]), 10)
payeeName=findTestData('Transfer').getValue(3, 204)
AccountNo=findTestData('Transfer').getValue(3, 203)
accNo=findTestData('Transfer').getValue(3, 202)
GlobalVariable.accNoFrom=Mobile.getText(findTestObject('Object Repository/Dynamic Object/Account Detail', [('index') : 2]), 10)
trxDate=findTestData('Transfer').getValue(3, 206)
amount=findTestData('Transfer').getValue(3, 207)
values=findTestData('Transfer').getValue(3, 205)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Banking/m2uAccountTypeSelection', [('text') : GlobalVariable.accType]), 10)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Banking/m2uAccountPayBillsIconSelect'), 0)

tapPIN.enterPass(findTestData('Transfer').getValue(4, 1))

Mobile.verifyElementExist(findTestObject('Paybill/payBillsIconSelect'), 40)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Paybill/payBillsIconSelect'), 0)

Mobile.tap(findTestObject('Paybill/payBillSearchBillerInputField'), 0)

Mobile.setText(findTestObject('Paybill/payBillBillerNameInputField'), payeeName, 0)

Mobile.delay(3)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Paybill/payBillBillerSelect', [('payeeName') : payeeName]), 10)

Mobile.tap(findTestObject('Paybill/payBillBillerSelect', [('payeeName') : payeeName]), 10)

Mobile.delay(3)

Verify=findTestData('Verify').getValue(2, 14)
if(Verify=='Y') {
	
	Mobile.verifyElementText(findTestObject('Paybill/payBillsAccountPayeeNameTxt', [('payee') : payeeName]), payeeName)
	
	//Mobile.verifyElementExist(findTestObject('Paybill/payBillsAccountNumberTitleTxt'), 0)
	
	Mobile.setText(findTestObject('Paybill/PayBillAccountNumberInputField'), AccountNo, 0)
	
	Mobile.hideKeyboard()
	
	Mobile.verifyElementText(findTestObject('Paybill/payBillsAccountNumberInputtedTxt', [('AccountNo') : AccountNo]), AccountNo)
	
	Mobile.takeScreenshot()
	
	Mobile.tap(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)
	
	Mobile.delay(3)
	
	Mobile.verifyElementText(findTestObject('Paybill/payBillsAmountPayeeNameTxt', [('payee') : payeeName]), payeeName)
	
	Mobile.verifyElementText(findTestObject('Paybill/payBillsAmountPayeeAccountNoTxt', [('accNo') : accNo]), accNo)
	
	Mobile.verifyElementExist(findTestObject('Paybill/payBillsAmountInitialTxt'), 0)
	
	Mobile.verifyElementExist(findTestObject('Paybill/payBillsAmountCurrencyTxt'), 0)
	
	Mobile.verifyElementExist(findTestObject('Paybill/payBillsAmountEnterTitleTxt'), 0)
	
}else if(Verify=='N') {
	
	Mobile.setText(findTestObject('Paybill/PayBillAccountNumberInputField'), AccountNo, 0)
	
	Mobile.hideKeyboard()
	
	Mobile.takeScreenshot()
	
	Mobile.tap(findTestObject('Login Onboarding/loginExistingContinueBtn'), 0)
	
}



tapPIN.enterAmount(values)


Mobile.delay(3)

Mobile.takeScreenshot()

if(Verify=='Y') {
	
	Mobile.verifyElementText(findTestObject('Paybill/payBillsConfirmPayeeNameTxt', [('payeeName') : payeeName]), payeeName)
	
	Mobile.verifyElementText(findTestObject('Paybill/payBillsConfirmPayeeAccountNoTxt', [('accNo') : accNo]), accNo)
	
	Mobile.verifyElementText(findTestObject('Paybill/payBillsConfirmAmountTxt', [('amount') : amount]), amount)
	
	Mobile.verifyElementExist(findTestObject('Paybill/payBillsConfirmDateTitleTxt'), 0)
	
	Mobile.verifyElementText(findTestObject('Paybill/payBillsConfirmDateTxt', [('trxDate') : trxDate]), trxDate)
	
	Mobile.verifyElementExist(findTestObject('Paybill/payBillsConfirmPayFromTxt'), 0)
	
	Mobile.verifyElementText(findTestObject('Transfer/transferConfirmationFromAccTypeTxt', [('accType') : GlobalVariable.accType]), GlobalVariable.accType)
	
	Mobile.verifyElementText(findTestObject('Transfer/transferConfirmationFromAccNoTxt', [('accNoFrom') : GlobalVariable.accNoFrom]), GlobalVariable.accNoFrom)
	
	Mobile.verifyElementExist(findTestObject('Transfer/transferConfirmationFromAccBalanceTxt'), 0)
	
	accountBalance = Mobile.getText(findTestObject('Transfer/transferConfirmationFromAccBalanceTxt'), 0)
	
	println(accountBalance)
	
	Mobile.waitForElementPresent(findTestObject('Main/mainPayNowBtn'), 5)
	
	Mobile.takeScreenshot()
	
	Mobile.delay(5)
	
	Mobile.tap(findTestObject('Main/mainPayNowBtn'), 0)

}else if(Verify=='N') {
	
	Mobile.waitForElementPresent(findTestObject('Main/mainPayNowBtn'), 5)
	
	Mobile.takeScreenshot()
	
	Mobile.delay(5)
	
	Mobile.tap(findTestObject('Main/mainPayNowBtn'), 0)

}

Mobile.delay(5)
if (GlobalVariable.startAPP == 'com.maybank2u.life.uat') {
	if (Mobile.verifyElementExist(findTestObject('Text', [('Verify') : 'Transaction Authorisation Code']), 10, FailureHandling.OPTIONAL)) {
		tapPIN.tapTAC()
	} else {
		verifyEqual.text('Pay Bills')

		Mobile.takeScreenshot()

		tapPIN.tapS2U(findTestData('Verify').getValue(4, 1))
	}
} else {
	verifyEqual.text('Pay Bills')

	Mobile.takeScreenshot()

	tapPIN.tapS2U(findTestData('Verify').getValue(4, 1))
}
Mobile.delay(5)

'Transaction status verification'
WebUI.callTestCase(findTestCase('Test Cases/Pages/Transaction Summary'), ['addFav':'N'], FailureHandling.CONTINUE_ON_FAILURE)




