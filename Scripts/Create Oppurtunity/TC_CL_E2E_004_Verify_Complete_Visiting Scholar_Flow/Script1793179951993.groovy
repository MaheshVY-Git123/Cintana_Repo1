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

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/button_Continue to Sign In'))

WebUI.setText(findTestObject('Create oppurtunity/Visiting Scholar/Page_Identity Hub/input_Email address_'), 'anuragfaculty@test.com')

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Identity Hub/button_Continue'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Identity Hub/button_Sign in with Password'))

WebUI.setText(findTestObject('Create oppurtunity/Visiting Scholar/Page_Sign in to Identity Hub/input_Username or email'), 
    'anuragfaculty@test.com')

WebUI.setEncryptedText(findTestObject('Create oppurtunity/Visiting Scholar/Page_Sign in to Identity Hub/input_Password'), 
    '3JR9xufqD6UXZNPnOVht0Q==')

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Sign in to Identity Hub/button_kc-login'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/span_Create Opportunity'))

def visitingScholarCard = findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/button_Visiting Scholar')

WebUI.waitForElementClickable(visitingScholarCard, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.click(visitingScholarCard)

def opportunityNameField = findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/input_e.g. Visiting scholar in sustainable engin')

WebUI.waitForElementVisible(opportunityNameField, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(opportunityNameField, 'Data engineer')

WebUI.setText(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_Rich Text Editor, main'), 
    'Data engineering')

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_l-eh3sw75-term'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_choices-eh3sw75-term-item-choice-2'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_Select a modalityRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_choices-e3kg7pq-modality-item-choice-1'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_Select CountryRemove item'))

WebUI.setText(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/input_Search'), 'ind')

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_choices-eeqcwe-country-item-choice-99'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_Select CityRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_choices-ec15tre-city-item-choice-8'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/input_Select a date'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/span_October 7, 2026'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/input_Select a date_1'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/span_October 21, 2026'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_Select a languageRemove item'))

WebUI.setText(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/input_Search_1'), 'en')

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_choices-enjxh9-preferredLanguage-item-choice'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_Select a languageRemove item_1'))

WebUI.setText(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/input_Search_2'), 'tel')

WebUI.sendKeys(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/input_Search_2'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_l-e5y5gky-ka1KnowledgeArea'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_choices-e5y5gky-ka1KnowledgeArea-item-choice'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_l-e3qkqq5-ka1Subject'))

def subjectChoice = findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_choices_ka1Subject_choice_2')

WebUI.waitForElementClickable(subjectChoice, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.click(subjectChoice)

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/input_Select a date_2'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/span_October 7, 2026'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/input_Select a date_3'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/span_October 28, 2026'))

WebUI.setText(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/textarea_e.g. Two guest lectures, a research sem'), 
    'Data engineer')

WebUI.setText(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/textarea_Anything else about the visit'), 
    'Data engineering')

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/span_October 21, 2026_1'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/button_Acknowledgement'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/input_I acknowledge that the ACI is responsib'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/button_Create Opportunity button. Click to submi'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/button_Back'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/circle_circle'))

WebUI.click(findTestObject('Create oppurtunity/Visiting Scholar/Page_Cintana Faculty Portal/div_Logout'))

WebUI.closeBrowser()

