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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction

import internal.GlobalVariable

public class swiping {
	AppiumDriver driver;

	swiping() {
		this.driver = MobileDriverFactory.getDriver()
	}

	private scrollEntireList() {
		// very specific to android and the type of element that makes up your dropdowns
		ArrayList listElement = driver.findElementsByClassName("android.widget.TextView")
		TouchAction touchAction = new TouchAction(driver)
		def bottomElement = listElement[listElement.size() - 1]
		def topElement = listElement[0]
		// Press and scroll from the last element in the list all the way to the top
		touchAction.press(bottomElement).moveTo(topElement).release().perform();
	}

	@Keyword
	def boolean scrollListToElementWithText(String elementText) {
		boolean isElementFound = false;
		while (isElementFound == false) {
			// very specific to android and the type of element that makes up your dropdowns
			ArrayList listElement = driver.findElementsByClassName("android.widget.TextView")
			for (int i = 0; i<listElement.size(); i++) {
				String textItem = ((MobileElement)listElement[i]).getText()
				if (textItem == elementText) {
					isElementFound = true;
					return true;
				}
			}
			scrollEntireList()
		}
	}
}


