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

clickWithOptionalTimeout(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/button_Continue to sign in'))

def emailField = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Identity Hub/input_Email address_')

WebUI.waitForElementVisible(emailField, 120, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(emailField, 'anuragfaculty@test.com')

clickWithOptionalTimeout(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Identity Hub/button_Continue'))

clickWithOptionalTimeout(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Identity Hub/button_Sign in with Password'))

def usernameField = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Sign in to Identity Hub/input_Username or email')

WebUI.waitForElementVisible(usernameField, 120, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(usernameField, 'anuragfaculty@test.com')

WebUI.click(usernameField)

def passwordField = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Sign in to Identity Hub/input_Password')

WebUI.waitForElementVisible(passwordField, 120, FailureHandling.STOP_ON_FAILURE)

WebUI.setEncryptedText(passwordField, '3JR9xufqD6UXZNPnOVht0Q==')

clickWithOptionalTimeout(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Sign in to Identity Hub/button_kc-login'))

def createOpportunityNav = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/button_Create Opportunity')

WebUI.waitForElementClickable(createOpportunityNav, 120, FailureHandling.STOP_ON_FAILURE)

WebUI.click(createOpportunityNav)

def globalSignatureCard = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/button_Global Signature Courses')

WebUI.waitForElementClickable(globalSignatureCard, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.click(globalSignatureCard)

def opportunityNameField = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/input_e.g. Global Signature Course in Sustainabl')

WebUI.waitForElementVisible(opportunityNameField, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(opportunityNameField, 'Global Ethics')

def termDropdown = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_l-ee5ai3j-term')

WebUI.waitForElementClickable(termDropdown, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(termDropdown)

def termOption = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_choices-ee5ai3j-term-item-choice-3')

WebUI.waitForElementClickable(termOption, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(termOption)

def modalityDropdown = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_l-e8g6gcq-modality')

WebUI.waitForElementClickable(modalityDropdown, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(modalityDropdown)

def modalityOption = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_choices-modality-item-choice-3')

WebUI.waitForElementClickable(modalityOption, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(modalityOption)

def nextButton = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab')

WebUI.waitForElementClickable(nextButton, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.click(nextButton)

def startDateField = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/input_Select a date')

WebUI.waitForElementClickable(startDateField, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(startDateField)

def startDateOption = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/span_October 9, 2026')

WebUI.waitForElementClickable(startDateOption, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(startDateOption)

def endDateField = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/input_Select a date_1')

WebUI.waitForElementClickable(endDateField, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(endDateField)

def endDateOption = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/span_October 15, 2026')

WebUI.waitForElementClickable(endDateOption, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(endDateOption)

def knowledgeAreaDropdown = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_l-e6nvyj6-topic')

WebUI.waitForElementClickable(knowledgeAreaDropdown, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(knowledgeAreaDropdown)

def knowledgeAreaOption = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_choices-e6nvyj6-topic-item-choice-2')

WebUI.waitForElementClickable(knowledgeAreaOption, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(knowledgeAreaOption)

def subjectDropdown = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_l-eocc41w-course')

WebUI.waitForElementClickable(subjectDropdown, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.click(subjectDropdown)

def subjectOption = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_choices-eocc41w-course-item-choice-9')

WebUI.waitForElementClickable(subjectOption, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.click(subjectOption)

def languageDropdown = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_l-e20l8kf-language')

WebUI.waitForElementClickable(languageDropdown, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(languageDropdown)

def languageOption = findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_choices-e20l8kf-language-item-choice-11')

WebUI.waitForElementClickable(languageOption, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(languageOption)

def submitOpportunityButton = new TestObject('submitOpportunityButton')
submitOpportunityButton.addProperty('css', ConditionType.EQUALS, '.btn-wizard-nav-submit')
WebUI.waitForElementClickable(submitOpportunityButton, 30, FailureHandling.STOP_ON_FAILURE)
WebUI.click(submitOpportunityButton)

WebUI.rightClick(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/h2_Submitted for approval'))

WebUI.assertElementVisible(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/h2_Submitted for approval'), 
    0)

WebUI.click(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/main_main-content'))

WebUI.rightClick(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/button_Create another'))

WebUI.click(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_Submitted for approvalYour Global Signature'))

WebUI.rightClick(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/h2_Submitted for approval'))

WebUI.assertElementText(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/h2_Submitted for approval'), 
    'Submitted for approval', 0)

WebUI.click(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/button_Back'))

WebUI.click(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/svg_lucide lucide-ellipsis-vertical app-sidebar_'))

WebUI.click(findTestObject('Create oppurtunity/Global_Signature_courses/Page_Cintana Faculty Portal/div_Logout'))

WebUI.closeBrowser()

