import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords
import com.my.keywords.tapPIN

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
//
//Mobile.tap(findTestObject('Dashboard/mainBottomMenuMaybank2uBtn'), 0)
//
//tapPIN.tapPINno(findTestData('TestData').getValue(5, 1))
//
//GlobalVariable.accType=Mobile.getText(findTestObject('Object Repository/Dynamic Object/Account Detail', [('index') : 1]), 10)
payeeName=findTestData('Transfer').getValue(3, 209)
AccountNo=findTestData('Transfer').getValue(3, 210)
accNo=findTestData('Transfer').getValue(4, 210)
//GlobalVariable.accNoFrom=Mobile.getText(findTestObject('Object Repository/Dynamic Object/Account Detail', [('index') : 2]), 10)
trxDate=findTestData('Transfer').getValue(3, 206)
amount=findTestData('Transfer').getValue(3, 207)
values=findTestData('Transfer').getValue(3, 205)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Banking/m2uAccountPayBillsIconSelect'), 0)

tapPIN.enterPass(findTestData('Transfer').getValue(4, 1))

Mobile.verifyElementExist(findTestObject('Paybill/payBillsIconSelect'), 0)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Transfer/transferFavListAccNameTxt', [('accName') : payeeName]), 0,FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3)

tapPIN.enterAmount(values)

text='You are required to key in a TAC to complete your first-time favourite transfer.'

def tacON='N'

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Main/mainAmountTickBtn'), 0)

if(Mobile.verifyElementExist(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : text]), 0,FailureHandling.OPTIONAL)) {
	tacON ='Y'
	
	Mobile.delay(3)
}

Mobile.verifyElementText(findTestObject('Paybill/payBillsConfirmPayeeNameTxt', [('payeeName') : payeeName]), payeeName)

Mobile.verifyElementText(findTestObject('Paybill/payBillsConfirmPayeeAccountNoTxt', [('accNo') : accNo]), accNo)

Mobile.verifyElementText(findTestObject('Paybill/payBillsConfirmAmountTxt', [('amount') : amount]), amount)

Mobile.verifyElementExist(findTestObject('Paybill/payBillsConfirmDateTitleTxt'), 0)

Mobile.verifyElementText(findTestObject('Paybill/payBillsConfirmDateTxt', [('trxDate') : trxDate]), trxDate)

Mobile.verifyElementExist(findTestObject('Paybill/payBillsConfirmPayFromTxt'), 0)

Mobile.verifyElementText(findTestObject('Transfer/transferConfirmationFromAccTypeTxt', [('accType') : GlobalVariable.accType]), GlobalVariable.accType)

Mobile.verifyElementText(findTestObject('Transfer/transferConfirmationFromAccNoTxt', [('accNoFrom') : GlobalVariable.accNoFrom]), GlobalVariable.accNoFrom)

Mobile.verifyElementExist(findTestObject('Transfer/transferConfirmationFromAccBalanceTxt'), 0)

Mobile.waitForElementPresent(findTestObject('Main/mainPayNowBtn'), 5)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Main/mainPayNowBtn'), 0)

if(tacON =='Y') {
	def TAC = Mobile.getText(findTestObject('Forget Password/Your TAC no. is'), 0)
	
	Mobile.delay(3)
	
	for (def i = 16; i < 22; i++) {
		
			def TapNo = TAC[i]
			
			Mobile.tap(findTestObject('Text', [('Verify'): TapNo]),0)
	}
	
	Mobile.delay(10)
	
	'Tick button'
	Mobile.tap(findTestObject('Object Repository/Dynamic Object/Tap Image Following',[('text'):'0']), 0)
	
}

Mobile.delay(5)

def Page = Mobile.getText(findTestObject('Festive Season/returnAngpaoStatusMessageTxt'), 10)

switch (Page) {
	case 'Secure2u authorisation':
		tapPIN.tapS2U(findTestData('Verify').getValue(4, 1))
		
		
		break
	case 'One Time Password':
		Mobile.verifyElementExist(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Confirm']), 0)
	
		Mobile.verifyElementExist(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Not Mine']), 0)
	
		Mobile.tap(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Confirm']), 0)
	
		tapPIN.tapOTP()
		
		Mobile.takeScreenshot()
			
		break
	

}

Mobile.delay(5)

'Transaction status verification'
WebUI.callTestCase(findTestCase('Test Cases/Pages/Transaction Summary'), ['addFav':'N'], FailureHandling.CONTINUE_ON_FAILURE)


