
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

TestObject modalRoot = new TestObject('Express Interest dialog')
modalRoot.addProperty('xpath', ConditionType.EQUALS,
    "//div[@role='dialog' and @data-slot='dialog-content']")

try {

    // STEP 1: Open browser
    WebUI.openBrowser('')
    WebUI.maximizeWindow()

    // STEP 2: Navigate to Cintana Faculty Portal
    WebUI.navigateToUrl('https://qa-facultyportal.cintana.com/auth')

    // STEP 3: Continue to sign in
    WebUI.waitForElementVisible(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Cintana Faculty Portal/button_Continue to Sign In'),
        20
    )

    WebUI.click(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Cintana Faculty Portal/button_Continue to Sign In')
    )

    // STEP 4: Enter email address
    WebUI.waitForElementVisible(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Identity Hub/input_Email address_'),
        15
    )

    WebUI.setText(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Identity Hub/input_Email address_'),
        'anuragfaculty@test.com'
    )

    WebUI.click(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Identity Hub/button_Continue')
    )

    // STEP 5: Select sign in with password
    WebUI.waitForElementClickable(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Identity Hub/button_Sign in with Password'),
        15
    )

    WebUI.click(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Identity Hub/button_Sign in with Password')
    )

    // STEP 6: Enter login credentials
    WebUI.waitForElementVisible(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Sign in to Identity Hub/input_Username or email'),
        15
    )

    WebUI.setText(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Sign in to Identity Hub/input_Username or email'),
        'anuragfaculty@test.com'
    )

    WebUI.setEncryptedText(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Sign in to Identity Hub/input_Password'),
        '3JR9xufqD6UXZNPnOVht0Q=='
    )

    WebUI.click(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Sign in to Identity Hub/button_kc-login')
    )

    // STEP 7: Wait for Opportunity Marketplace
    WebUI.waitForPageLoad(20)

    WebUI.waitForElementVisible(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Cintana Faculty Portal/input_Search by opportunity title'),
        30
    )

    // STEP 8: Search for opportunity
    WebUI.setText(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Cintana Faculty Portal/input_Search by opportunity title'),
        'ai and ml'
    )

    WebUI.delay(5)

    // STEP 9: Click Submit Interest
    WebUI.waitForElementClickable(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Cintana Faculty Portal/button_Submit Interest'),
        15
    )

    WebUI.click(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Cintana Faculty Portal/button_Submit Interest')
    )

    // STEP 10: Verify the Express Interest modal and its heading
    WebUI.waitForElementVisible(modalRoot, 15)
    TestObject modalHeading = new TestObject('Express Interest dialog heading')
    modalHeading.addProperty('xpath', ConditionType.EQUALS,
        "//div[@role='dialog']//h2[@data-slot='dialog-title']")
    WebUI.waitForElementVisible(modalHeading, 10)
    String headingText = WebUI.getText(modalHeading).trim()
    if (!headingText.toLowerCase().contains('interest')) {
        throw new AssertionError('The dialog heading is not interest-related: ' + headingText)
    }
    KeywordUtil.logInfo('PASS: Interest modal heading is displayed: ' + headingText)

    // STEP 11: Verify the required fit label
    TestObject fitLabel = new TestObject('Required fit label')
    fitLabel.addProperty('xpath', ConditionType.EQUALS,
        "//div[@role='dialog']//label[@for = //div[@role='dialog']//textarea[@data-slot='textarea']/@id]")
    WebUI.waitForElementVisible(fitLabel, 10)
    String normalizedLabelText = WebUI.getText(fitLabel).replaceAll(/\s+/, ' ').trim()
    if (!normalizedLabelText.contains("Why you're a fit") ||
        !normalizedLabelText.toLowerCase().contains('required')) {
        throw new AssertionError('Required fit label was not displayed: ' + normalizedLabelText)
    }
    KeywordUtil.logInfo('PASS: Required fit label is displayed.')

    // STEP 12: Verify the message field
    TestObject fitTextarea = new TestObject('Express Interest message field')
    fitTextarea.addProperty('xpath', ConditionType.EQUALS,
        "//div[@role='dialog']//textarea[@data-slot='textarea' and @maxlength='500']")
    WebUI.verifyElementVisible(fitTextarea)
    KeywordUtil.logInfo('PASS: Express Interest message field is visible.')

    // STEP 13: Verify Cancel button
    TestObject cancelButton = new TestObject('Express Interest Cancel button')
    cancelButton.addProperty('xpath', ConditionType.EQUALS,
        "//div[@role='dialog']//button[normalize-space(.)='Cancel']")
    WebUI.verifyElementVisible(cancelButton)
    KeywordUtil.logInfo('PASS: Cancel button is visible.')

    // STEP 14: Verify Submit Interest button inside the modal
    TestObject submitButton = new TestObject('Express Interest modal submit button')
    submitButton.addProperty('xpath', ConditionType.EQUALS,
        "//div[@role='dialog']//button[normalize-space(.)='Submit Interest']")
    WebUI.verifyElementVisible(submitButton)
    KeywordUtil.logInfo('PASS: Modal Submit Interest button is visible.')

    // STEP 15: Close the modal
    TestObject closeButton = new TestObject('Express Interest modal close button')
    closeButton.addProperty('xpath', ConditionType.EQUALS,
        "//div[@role='dialog']//button[@type='button' and .//span[normalize-space(.)='Close']]")
    WebUI.waitForElementClickable(closeButton, 10)
    WebUI.click(closeButton)
    WebUI.waitForElementNotPresent(modalRoot, 10)

    // STEP 16: Logout
    WebUI.waitForElementClickable(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Cintana Faculty Portal/p_Mahesh Faculty'),
        10
    )

    WebUI.click(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Cintana Faculty Portal/p_Mahesh Faculty')
    )

    WebUI.waitForElementClickable(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Cintana Faculty Portal/div_Logout'),
        10
    )

    WebUI.click(
        findTestObject('oppurtunity Marketplace/Verify Express Interest modal opens from listing/Page_Cintana Faculty Portal/div_Logout')
    )

    KeywordUtil.logInfo('TEST PASSED: Express Interest modal verification completed.')

} catch (Exception e) {

    KeywordUtil.markFailed(
        'TEST FAILED: ' + e.getMessage()
    )

} finally {

    // Always close browser
    WebUI.closeBrowser()

}
