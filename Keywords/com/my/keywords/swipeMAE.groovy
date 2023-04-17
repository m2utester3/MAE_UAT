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

public class swipeMAE {

	static void itemNo(int No) {

		int Y1 = Mobile.getDeviceHeight()/2
		int X1 = Mobile.getDeviceWidth()*0.9
		int X2 = Mobile.getDeviceWidth()*0.1

		int i
		for(i=0;i<No;i++) {
			Mobile.delay(5)

			Mobile.swipe(X1,Y1,X2,Y1)
		}
	}
	static void down(int No) {
		
				int X1 = Mobile.getDeviceWidth()/2
				int Y1 = Mobile.getDeviceHeight()*0.9
				int Y2 = Mobile.getDeviceHeight()*0.1
		
				for (int i=0;i<No;i++) {
					Mobile.swipe(X1,Y1,X1,Y2)
		
					Mobile.delay(2)
				}
			}
		
			static void above(int No) {
		
				int X1 = Mobile.getDeviceWidth()/2
				int Y1 = Mobile.getDeviceHeight()*0.9
				int Y2 = Mobile.getDeviceHeight()*0.1
		
				for (int i=0;i<No;i++) {
					Mobile.swipe(X1,Y2,X1,Y1)
		
					Mobile.delay(2)
				}
			}
			static void right(int No) {
				
						int X1 = Mobile.getDeviceWidth()*0.9
						int Y = Mobile.getDeviceHeight()*0.5
						int X2 = Mobile.getDeviceWidth()*0.1
				
						for (int i=0;i<No;i++) {
							Mobile.swipe(X1,Y,X2,Y)
				
							Mobile.delay(2)
						}
					}
			
}
