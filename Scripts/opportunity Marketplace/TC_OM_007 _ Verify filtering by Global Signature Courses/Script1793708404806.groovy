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

WebUI.openBrowser(null)

WebUI.navigateToUrl('https://qa-facultyportal.cintana.com/auth')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/button_Continue to Sign In'))

WebUI.setText(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Identity Hub/input_Email address_'), 
    'anuragfaculty@test.com')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Identity Hub/button_Continue'))

WebUI.click(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Identity Hub/button_Sign in with Password'))

WebUI.setText(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Sign in to Identity Hub/input_Username or email'), 
    'anuragfaculty@test.com')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Sign in to Identity Hub/input_Username or email'))

WebUI.setEncryptedText(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Sign in to Identity Hub/input_Password'), 
    '3JR9xufqD6UXZNPnOVht0Q==')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Sign in to Identity Hub/button_kc-login'))

WebUI.click(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/button_Filters'))

WebUI.click(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/button_Opportunity type_ All types'))

WebUI.click(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses'))

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_1'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_1'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_2'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_2'), 
    'Global Signature Courses', 0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_3'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_3'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_3'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_3'), 
    'Global Signature Courses', 0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_4'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_4'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_4'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/span_Global Signature Courses_4'), 
    'Global Signature Courses', 0)

WebUI.click(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/p_Mahesh Faculty'))

WebUI.click(findTestObject('oppurtunity Marketplace/Verify filtering by Global Signature Courses/Page_Cintana Faculty Portal/div_Logout'))

WebUI.closeBrowser()

