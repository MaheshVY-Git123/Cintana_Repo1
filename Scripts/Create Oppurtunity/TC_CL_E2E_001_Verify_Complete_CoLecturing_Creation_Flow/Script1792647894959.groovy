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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.time.Duration as Duration
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def clickWithOptionalTimeout = { def testObject ->
    WebUI.waitForElementClickable(testObject, 60)

    WebUI.click(testObject, FailureHandling.OPTIONAL)
}

WebUI.openBrowser(null)

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://qa-facultyportal.cintana.com/auth')

DriverFactory.getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120))

clickWithOptionalTimeout(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/button_Continue to sign in'))

WebUI.waitForElementVisible(findTestObject('Create oppurtunity/Co-lecturing/Page_Identity Hub/input_Email address_'), 120, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Create oppurtunity/Co-lecturing/Page_Identity Hub/input_Email address_'), 'anuragfaculty@test.com')

clickWithOptionalTimeout(findTestObject('Create oppurtunity/Co-lecturing/Page_Identity Hub/button_Continue'))

def passwordSignIn = findTestObject('Create oppurtunity/Co-lecturing/Page_Identity Hub/button_Sign in with Password')

clickWithOptionalTimeout(passwordSignIn)

def usernameField = findTestObject('Create oppurtunity/Co-lecturing/Page_Sign in to Identity Hub/input_Username or email')

WebUI.waitForElementVisible(usernameField, 120, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(usernameField, 'anuragfaculty@test.com')

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Sign in to Identity Hub/input_Username or email'))

WebUI.setEncryptedText(findTestObject('Create oppurtunity/Co-lecturing/Page_Sign in to Identity Hub/input_Password'), '3JR9xufqD6UXZNPnOVht0Q==')

clickWithOptionalTimeout(findTestObject('Create oppurtunity/Co-lecturing/Page_Sign in to Identity Hub/button_kc-login'))

WebUI.waitForElementVisible(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/span_Create Opportunity'), 
    120, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/span_Create Opportunity'))

def coLecturingCard = findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/button_Co-Lecturing')

WebUI.waitForElementClickable(coLecturingCard, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.click(coLecturingCard)

def opportunityNameField = findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/input_e.g. Co-teaching Introduction to Data Scie')

WebUI.waitForElementVisible(opportunityNameField, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(opportunityNameField, 'python selenium')

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/div_Select a termRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/div_choices-evequnk-term-item-choice-2'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/div_Select a modalityRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/div_choices-ekao4mf-modality-item-choice-2'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/input_Select a date'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/span_October 6, 2026'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/input_Select a date_1'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/span_October 21, 2026'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/div_Select a languageRemove item'))

WebUI.setText(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/input_Search'), 'en')

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/div_choices-eo44ywk-preferredLanguage-item-choic'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/div_Select a knowledge areaRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/div_choices-eb21tjs-ka1KnowledgeArea-item-choice'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.setText(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/input_Number of lectures'), '8')

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/div_Lecture Overview'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/input_I acknowledge that the ACI is responsib'))

def submitOpportunityButton = new TestObject('submitOpportunityButton')
submitOpportunityButton.addProperty('css', ConditionType.EQUALS, '.btn-wizard-nav-submit')
WebUI.waitForElementClickable(submitOpportunityButton, 30, FailureHandling.STOP_ON_FAILURE)
WebUI.click(submitOpportunityButton)

WebUI.rightClick(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/h2_Submitted for approval'))

WebUI.assertElementVisible(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/h2_Submitted for approval'), 
    0)

WebUI.rightClick(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/h2_Submitted for approval'))

WebUI.assertElementText(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/h2_Submitted for approval'), 
    'Submitted for approval', 0)

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/span_My Matches'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/span_Create Opportunity'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/p_Faculty'))

WebUI.click(findTestObject('Create oppurtunity/Co-lecturing/Page_Cintana Faculty Portal/div_Logout'))

WebUI.closeBrowser()

