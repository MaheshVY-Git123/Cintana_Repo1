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

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://qa-facultyportal.cintana.com/auth')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/button_Continue to Sign In'))

WebUI.setText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Identity Hub/input_Email address_'), 
    'anuragfaculty@test.com')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Identity Hub/button_Continue'))

WebUI.click(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Identity Hub/button_Sign in with Password'))

WebUI.setText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Sign in to Identity Hub/input_Username or email'), 
    'anuragfaculty@test.com')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Sign in to Identity Hub/input_Username or email'))

WebUI.setEncryptedText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Sign in to Identity Hub/input_Password'), 
    '3JR9xufqD6UXZNPnOVht0Q==')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Sign in to Identity Hub/button_kc-login'))

WebUI.setText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/input_Search by opportunity title'), 
    'ai and ml')
WebUI.delay(5)

WebUI.click(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/button_View Details'))

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Primary informationTermTerm Spring 2026-1Opp'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Primary informationTermTerm Spring 2026-1Opp'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Primary information'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Primary information'), 
    'Primary information', 0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Other informationEarliest date to beginOct 7'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Other informationEarliest date to beginOct 7'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Other information'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Other information'), 
    'Other information', 0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Knowledge areasPriority 1Knowledge areaSusta'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Knowledge areasPriority 1Knowledge areaSusta'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Knowledge areas'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Knowledge areas'), 
    'Knowledge areas', 0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Lecture overviewNumber of lectures2Expected'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Lecture overviewNumber of lectures2Expected'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Lecture overview'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Lecture overview'), 
    'Lecture overview', 0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Opportunity at a glanceAccepting interestTer'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Opportunity at a glanceAccepting interestTer'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Opportunity at a glance'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Opportunity at a glance'), 
    'Opportunity at a glance', 0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Contact person1-1.com'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Contact person1-1.com'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Contact person'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Contact person'), 
    'Contact person', 0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_FacultyVijay'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_FacultyVijay'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Faculty'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/h2_Faculty'), 
    'Faculty', 0)

WebUI.click(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/p_Mahesh Faculty'))

WebUI.click(findTestObject('oppurtunity Marketplace/Verify opportunity details information sections/Page_Cintana Faculty Portal/div_Logout'))

WebUI.closeBrowser()

