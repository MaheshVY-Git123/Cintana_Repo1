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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.util.Locale as Locale

WebUI.openBrowser(null)

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://qa-facultyportal.cintana.com/auth')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/button_Continue to Sign In'))

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Identity Hub/input_Email address_'), 'anuragfaculty@test.com')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Identity Hub/button_Continue'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Identity Hub/button_Sign in with Password'))

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Sign in to Identity Hub/input_Username or email'), 
    'anuragfaculty@test.com')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Sign in to Identity Hub/input_Username or email'))

WebUI.setEncryptedText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Sign in to Identity Hub/input_Password'), 
    '3JR9xufqD6UXZNPnOVht0Q==')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Sign in to Identity Hub/button_kc-login'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/button_Create Opportunity'))

def guestLecturingCard = findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/button_Guest Lecturing')

WebUI.waitForElementClickable(guestLecturingCard, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.click(guestLecturingCard)

def opportunityNameField = findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_e.g. Guest lecture on AI in healthcare')

WebUI.waitForElementVisible(opportunityNameField, 60, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(opportunityNameField, 'Dot net developer')

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Rich Text Editor, main'), 
    'dot net developer')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Select a termRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-ed4u84v-term-item-choice-2'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Select a modalityRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-ekhfyga-modality-item-choice-2'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Select CountryRemove item'))

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_Search'), 'indi')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-eamucg8-country-item-choice-99'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Select CityRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-efq5cgar-city-item-choice-8'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

def dateFormatter = DateTimeFormatter.ofPattern('MMMM d, yyyy', Locale.ENGLISH)

def earliestDate = LocalDate.now().plusDays(1)

def latestDate = earliestDate.plusDays(1)

def calendarDateObject = { LocalDate date ->
    def dateLabel = dateFormatter.format(date)

    def dateObject = new TestObject('calendarDate_' + dateLabel.replace(' ', '_').replace(',', ''))

    dateObject.addProperty('css', ConditionType.EQUALS, ('.flatpickr-calendar.open .flatpickr-day[aria-label=\'' + dateLabel) + 
        '\']')

    return dateObject
}

def earliestDateInput = findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_Select a date')

def earliestDateObject = calendarDateObject(earliestDate)

WebUI.waitForElementClickable(earliestDateInput, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(earliestDateInput)

WebUI.waitForElementClickable(earliestDateObject, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(earliestDateObject)

def latestDateInput = findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_Select a date_1')

def latestDateObject = calendarDateObject(latestDate)

WebUI.waitForElementClickable(latestDateInput, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(latestDateInput)

WebUI.waitForElementClickable(latestDateObject, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(latestDateObject)

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_From'), '4')

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_To'), '6')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_UnitRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-eo5g1l-durationType-item-choice-2'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Select a languageRemove item'))

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_Search_1'), 'eng')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-e6rp18k-preferredLanguage-item-choic'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Select a languageRemove item_1'))

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_Search_2'), 'tel')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-eogwef-secondaryLanguage-item-choice'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Select a knowledge areaRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-e3zbzzv-ka1KnowledgeArea-item-choice'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Select a subjectRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-ebvuebb-ka1Subject-item-choice-7'))

def courseObjectivesEditor = new TestObject('courseObjectivesEditor')

courseObjectivesEditor.addProperty('css', ConditionType.EQUALS, '.formio-component-ka1LocalCourseObjectives [aria-label=\'Rich Text Editor, main\']')

WebUI.waitForElementVisible(courseObjectivesEditor, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(courseObjectivesEditor, 'Dot net dveloper')

def commentsEditor = new TestObject('commentsEditor')

commentsEditor.addProperty('css', ConditionType.EQUALS, '.formio-component-ka1Comments [aria-label=\'Rich Text Editor, main\']')

WebUI.waitForElementVisible(commentsEditor, 10, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(commentsEditor, 'Dot net developer')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_Number of lectures'), 
    '20')

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_Length of each lecture'), 
    '45')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Select a time of dayRemove item'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-e7zmknl-timeOfLecture-item-choice-1'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Select a time zoneRemove item'))

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_Search_3'), 'indi')

WebUI.sendKeys(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_Search_3'), Keys.chord(
        Keys.ENTER))

def lecturingPlatformPlaceholder = new TestObject('lecturingPlatformPlaceholder')

lecturingPlatformPlaceholder.addProperty('css', ConditionType.EQUALS, '.formio-component-lecturingPlatform .choices__item.choices__placeholder')

WebUI.click(lecturingPlatformPlaceholder)

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_choices-emh1nk9-lecturingPlatform-item-choic'))

WebUI.setText(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Rich Text Editor, main'), 
    'Dot net developer')

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/button_Next button. Click to go to the next tab'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/input_I acknowledge that the ACI is responsib'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/button_Create Opportunity button. Click to submi'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/button_Back'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/svg_lucide lucide-ellipsis-vertical app-sidebar_'))

WebUI.click(findTestObject('Create oppurtunity/Guest Lecturing/Page_Cintana Faculty Portal/div_Logout'))

WebUI.closeBrowser()

