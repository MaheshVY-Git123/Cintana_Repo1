import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String baseUrl = 'https://qa-facultyportal.cintana.com/auth'
String loginEmail = 'anuragfaculty@test.com'
String encryptedPassword = '3JR9xufqD6UXZNPnOVht0Q=='
String reasonText = 'I am interested in learning more about this opportunity.'
boolean browserOpened = false

TestObject continueToSignIn = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Cintana Faculty Portal/button_Continue to Sign In')
TestObject emailField = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Identity Hub/input_Email address_')
TestObject continueButton = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Identity Hub/button_Continue')
TestObject signInWithPassword = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Identity Hub/button_Sign in with Password')
TestObject usernameField = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Sign in to Identity Hub/input_Username or email')
TestObject passwordField = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Sign in to Identity Hub/input_Password')
TestObject submitLogin = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Sign in to Identity Hub/button_kc-login')
TestObject opportunitySearch = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Cintana Faculty Portal/input_Search by opportunity title')
TestObject openInterestButton = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Cintana Faculty Portal/button_Submit Interest')
TestObject reasonField = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Cintana Faculty Portal/textarea_I have taught this subject for six year')
TestObject submitModalButton = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Cintana Faculty Portal/button_Submit Interest_1')
TestObject submittedConfirmation = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Cintana Faculty Portal/span_Interest Submitted')
TestObject profileName = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Cintana Faculty Portal/p_Mahesh Faculty')
TestObject logoutButton = findTestObject('oppurtunity Marketplace/Verify Express Interest accepts valid reason/Page_Cintana Faculty Portal/div_Logout')

TestObject interestDialog = new TestObject('Express Interest dialog')
interestDialog.addProperty('xpath', ConditionType.EQUALS,
    "//div[@role='dialog' and @data-slot='dialog-content']")

try {
    WebUI.openBrowser('')
    browserOpened = true
    WebUI.maximizeWindow()
    WebUI.navigateToUrl(baseUrl)

    WebUI.waitForElementClickable(continueToSignIn, 20)
    WebUI.click(continueToSignIn)
    WebUI.waitForElementVisible(emailField, 20)
    WebUI.setText(emailField, loginEmail)
    WebUI.click(continueButton)

    WebUI.waitForElementClickable(signInWithPassword, 20)
    WebUI.click(signInWithPassword)
    WebUI.waitForElementVisible(usernameField, 20)
    WebUI.setText(usernameField, loginEmail)
    WebUI.setEncryptedText(passwordField, encryptedPassword)
    WebUI.click(submitLogin)

    WebUI.waitForPageLoad(20)
    WebUI.waitForElementVisible(opportunitySearch, 30)
    WebUI.setText(opportunitySearch, 'ai and ml')
    WebUI.delay(3)
    WebUI.waitForElementClickable(openInterestButton, 20)
    WebUI.click(openInterestButton)

    WebUI.waitForElementVisible(interestDialog, 15)
    WebUI.waitForElementVisible(reasonField, 10)
    WebUI.setText(reasonField, reasonText)
    WebUI.waitForElementClickable(submitModalButton, 10)
    WebUI.click(submitModalButton)

    WebUI.waitForElementVisible(submittedConfirmation, 20)
    String confirmationText = WebUI.getText(submittedConfirmation).trim()
    if (!confirmationText.equalsIgnoreCase('Interest Submitted')) {
        throw new AssertionError('Unexpected interest submission confirmation: ' + confirmationText)
    }
    KeywordUtil.logInfo('PASS: A valid reason was accepted and the listing shows Interest Submitted.')

    WebUI.waitForElementClickable(profileName, 10)
    WebUI.click(profileName)
    WebUI.waitForElementClickable(logoutButton, 10)
    WebUI.click(logoutButton)
} catch (Throwable t) {
    KeywordUtil.markFailed('Valid Express Interest reason testcase encountered an error: ' +
        (t.getMessage() ?: t.toString()))
} finally {
    if (browserOpened) {
        WebUI.closeBrowser()
    }
}