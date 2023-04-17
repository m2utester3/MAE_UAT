package com.my.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class tapPIN {
	static void tapPINno(String pinNO) {
		if (Mobile.verifyElementVisible(findTestObject('Main/mainEnterPINMessage'), 3, FailureHandling.OPTIONAL)) {
			def length = pinNO.length()

			for (def i = 0; i < length; i++) {

				def TapNo = pinNO[i]

				Mobile.tap(findTestObject('Text', [('Verify'): TapNo]),0)
			}
		}
		else {
			return
		}
		//		Mobile.delay(20)
	}
	static void enterAmount(String amount) {

		def length = amount.length()

		for (def i = 0; i < length; i++) {

			def TapNo = amount[i]

			Mobile.tap(findTestObject('Text', [('Verify'): TapNo]),0)
		}

		//Mobile.tap(findTestObject('Object Repository/Tabung/tabungAmountTickBtn'),0,FailureHandling.OPTIONAL)

		'Tick button'
		Mobile.tap(findTestObject('Object Repository/Dynamic Object/Tap Image Following',[('text'):'0']), 0)
	}

	static void enterPass(String password) {
		if (Mobile.verifyElementVisible(findTestObject('Tabung/tabungEnterPasswordTxt'), 10, FailureHandling.OPTIONAL)) {
			Mobile.setText(findTestObject('Tabung/tabungSignInInputPasswordField'), password,10)

			Mobile.hideKeyboard()

			Mobile.delay(2)

			Mobile.tap(findTestObject('Text',[('Verify'):'Continue']), 10)
		}
	}
	static void tapOTP() {

		//		Mobile.verifyElementExist(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Confirm']), 0)
		//
		//			Mobile.verifyElementExist(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Not Mine']), 0)
		//
		//			Mobile.tap(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Confirm']), 0)
		//
		/*
		 def OTP = Mobile.getText(findTestObject('Object Repository/Login Onboarding/Your OTP no. is 2'), 0)
		 def length = OTP.length()
		 for (def i = 16; i < length; i++) {
		 def TapNo = OTP[i]
		 Mobile.tap(findTestObject('Text', [('Verify'): TapNo]),0)
		 }
		 'Tick button'
		 Mobile.tap(findTestObject('Object Repository/Dynamic Object/Tap Image Following',[('text'):'0']), 0)
		 */
		Mobile.delay(20)
	}

	static void tapTAC() {
		def TAC = Mobile.getText(findTestObject('Forget Password/Your TAC no. is'), 0)

		'Tick button'
		Mobile.tap(findTestObject('Object Repository/Dynamic Object/Tap Image Following',[('text'):'0']), 0)

		Mobile.delay(10)

		for (def i = 16; i < 22; i++) {

			def TapNo = TAC[i]

			Mobile.tap(findTestObject('Text', [('Verify'): TapNo]),0)
		}

		'Tick button'
		Mobile.tap(findTestObject('Object Repository/Dynamic Object/Tap Image Following',[('text'):'0']), 0)
	}

	static void tapOtp() {
		def OTP = Mobile.getText(findTestObject('Login Onboarding/Your Otp no. is'), 0)

		for (def i = 16; i <= 21; i++) {
			def TapNo = OTP[i]

			Mobile.tap(findTestObject('Text', [('Verify'): TapNo]),0)
		}
		'Tick button'
		Mobile.tap(findTestObject('Object Repository/Dynamic Object/Tap Image Following',[('text'):'0']), 0)
	}

	static void tapS2U(String S2Uresult) {
		Mobile.delay(3)
		if (S2Uresult == 'Approve') {
			Mobile.tap(findTestObject('Main/mainS2UApproveBtn'), 0)
		} else if (S2Uresult == 'Reject') {
			Mobile.tap(findTestObject('Object Repository/Dynamic Object/VerifyText', [('text') : 'Reject']), 0)
		} else if (S2Uresult == 'Expired') {
			Mobile.delay(50)
		}
	}
}
