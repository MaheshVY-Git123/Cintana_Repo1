import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String baseUrl = 'https://qa-facultyportal.cintana.com/auth'
String loginEmail = 'anuragfaculty@test.com'
String encryptedPassword = '3JR9xufqD6UXZNPnOVht0Q=='
boolean browserOpened = false

TestObject continueToSignIn = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Cintana Faculty Portal/button_Continue to Sign In')
TestObject emailField = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Identity Hub/input_Email address_')
TestObject continueButton = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Identity Hub/button_Continue')
TestObject signInWithPassword = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Identity Hub/button_Sign in with Password')
TestObject usernameField = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Sign in to Identity Hub/input_Username or email')
TestObject passwordField = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Sign in to Identity Hub/input_Password')
TestObject submitLogin = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Sign in to Identity Hub/button_kc-login')
TestObject opportunitySearch = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Cintana Faculty Portal/input_Search by opportunity title')
TestObject openInterestButton = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Cintana Faculty Portal/button_Submit Interest')
TestObject submitInterestButton = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Cintana Faculty Portal/button_Submit Interest_1')
TestObject interestMessage = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Cintana Faculty Portal/textarea_I have taught this subject for six year')
TestObject cancelButton = new TestObject('Cancel button in Express Interest dialog')
cancelButton.addProperty('xpath', ConditionType.EQUALS,
    "//div[@role='dialog']//button[normalize-space(.)='Cancel']")
TestObject profileName = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Cintana Faculty Portal/p_Mahesh Faculty')
TestObject logoutButton = findTestObject('oppurtunity Marketplace/Verify Cancel button closes Express Interest modal/Page_Cintana Faculty Portal/div_Logout')
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

    WebUI.waitForElementVisible(opportunitySearch, 30)
    WebUI.setText(opportunitySearch, 'ai and ml')
    WebUI.waitForElementClickable(openInterestButton, 20)
    WebUI.click(openInterestButton)

    WebUI.waitForElementVisible(interestDialog, 15)
    WebUI.waitForElementVisible(interestMessage, 10)
    WebUI.setText(interestMessage, 'iam interested to learn')
    WebUI.waitForElementClickable(cancelButton, 10)
    WebUI.click(cancelButton)

    boolean modalClosed = WebUI.waitForElementNotPresent(interestDialog, 10, FailureHandling.OPTIONAL)
    if (!modalClosed) {
        KeywordUtil.markFailed('Cancel did not close the Express Interest modal.')
    }

    WebUI.verifyElementVisible(submitInterestButton, FailureHandling.STOP_ON_FAILURE)
} catch (Throwable t) {
    KeywordUtil.markFailed('Cancel button testcase encountered an error: ' +
        (t.getMessage() ?: t.toString()))
} finally {
    if (browserOpened) {
        try {
            if (WebUI.verifyElementVisible(profileName, FailureHandling.OPTIONAL)) {
                WebUI.click(profileName)
                WebUI.waitForElementClickable(logoutButton, 10, FailureHandling.OPTIONAL)
                if (WebUI.verifyElementClickable(logoutButton, FailureHandling.OPTIONAL)) {
                    WebUI.click(logoutButton)
                }
            }
        } catch (Throwable cleanupError) {
            KeywordUtil.logInfo('Logout cleanup could not be completed: ' +
                (cleanupError.getMessage() ?: cleanupError.toString()))
        }
        WebUI.closeBrowser()
    }
}