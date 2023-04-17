import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
//import com.my.keywords.android.EasyTap as EasyTap
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
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern


'Datafiles Testdata, sheet test_data'
Mobile.tap(findTestObject('Object Repository/Forget Password/Skip1stPage'), 0)

Mobile.tap(findTestObject('Object Repository/Forget Password/Continue1stPage'), 0)

Mobile.tap(findTestObject('Object Repository/Forget Password/LoginNowButton'), 0)

Mobile.tap(findTestObject('Object Repository/Forget Password/OnboardScreen'), 0)

Mobile.tap(findTestObject('Object Repository/Forget Password/ForgotPasswordEntry1'), 0)

'Adjustable in Variables'
Mobile.setText(findTestObject('Object Repository/Forget Password/Card Number'), findTestData('TestData').getValue(3, 24), 0)

'Adjustable in Variables'
Mobile.setText(findTestObject('Object Repository/Forget Password/6 digit PIN'), findTestData('TestData').getValue(11, 1), 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/Forget Password/Submit'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Forget Password/UsernameVerify'), 'Uat_test06')

Mobile.tap(findTestObject('Object Repository/Forget Password/Reset Password'), 0)

'Set new password'
Password=findTestData('TestData').getValue(3, 23)

'Adjustable in Variables'
Mobile.setText(findTestObject('Object Repository/Forget Password/1stPassword'), Password, 0)

Mobile.setText(findTestObject('Object Repository/Forget Password/ConfirmPassword'), Password, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/Forget Password/Continue2nd'), 0)

//EasyTap.TapOTP()

OTP = Mobile.getText(findTestObject('Forget Password/Your TAC no. is'), 0)

println(OTP)

Mobile.delay(6)

for (def i = 16; i <= 21; i++) {
    TapNo = (OTP[i])

    println(TapNo)

    Mobile.tap(findTestObject('Forget Password/PIN tap', [('TapNo') : TapNo]), 0)
}

Mobile.tap(findTestObject('Forget Password/TickTACButton'), 0)
Mobile.verifyElementText(findTestObject('Forget Password/Reset Password Successful'), 'Reset Password Successful')

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Main/mainDoneBtn'), 0)

