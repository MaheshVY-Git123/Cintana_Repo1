
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


// ============================================================
// TC_OM_022
// Verify Express Interest modal opens from details page
// ============================================================


// ============================================================
// 1. OPEN BROWSER
// ============================================================

WebUI.openBrowser(null)

WebUI.maximizeWindow()

WebUI.navigateToUrl(
    'https://qa-facultyportal.cintana.com/auth'
)


// ============================================================
// 2. CONTINUE TO SIGN IN
// ============================================================

TestObject continueToSignIn = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/button_Continue to Sign In'
)

WebUI.waitForElementVisible(
    continueToSignIn,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.click(continueToSignIn)


// ============================================================
// 3. ENTER EMAIL ADDRESS
// ============================================================

TestObject emailAddress = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Identity Hub/input_Email address_'
)

WebUI.waitForElementVisible(
    emailAddress,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.setText(
    emailAddress,
    'anuragfaculty@test.com'
)


// ============================================================
// 4. CLICK CONTINUE
// ============================================================

TestObject continueButton = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Identity Hub/button_Continue'
)

WebUI.waitForElementClickable(
    continueButton,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.click(continueButton)


// ============================================================
// 5. CLICK SIGN IN WITH PASSWORD
// ============================================================

TestObject signInWithPassword = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Identity Hub/button_Sign in with Password'
)

WebUI.waitForElementClickable(
    signInWithPassword,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.click(signInWithPassword)


// ============================================================
// 6. ENTER USERNAME / EMAIL
// ============================================================

TestObject username = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Sign in to Identity Hub/input_Username or email'
)

WebUI.waitForElementVisible(
    username,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.setText(
    username,
    'anuragfaculty@test.com'
)


// ============================================================
// 7. ENTER PASSWORD
// ============================================================

TestObject password = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Sign in to Identity Hub/input_Password'
)

WebUI.waitForElementVisible(
    password,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.setEncryptedText(
    password,
    '3JR9xufqD6UXZNPnOVht0Q=='
)


// ============================================================
// 8. CLICK LOGIN
// ============================================================

TestObject loginButton = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Sign in to Identity Hub/button_kc-login'
)

WebUI.waitForElementClickable(
    loginButton,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.click(loginButton)


// ============================================================
// 9. SEARCH OPPORTUNITY
// ============================================================

TestObject searchOpportunity = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/input_Search by opportunity title'
)

WebUI.waitForElementVisible(
    searchOpportunity,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.setText(
    searchOpportunity,
    'ai and ml'
)


// Wait for search results
WebUI.delay(5)


// ============================================================
// 10. CLICK VIEW DETAILS
// ============================================================

TestObject viewDetailsButton = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/button_View Details'
)

WebUI.waitForElementClickable(
    viewDetailsButton,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.click(viewDetailsButton)


// ============================================================
// 11. VERIFY OPPORTUNITY TITLE
// ============================================================

TestObject opportunityTitle = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/span_AI and ML'
)

WebUI.waitForElementVisible(
    opportunityTitle,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.verifyElementText(
    opportunityTitle,
    'AI and ML',
    FailureHandling.STOP_ON_FAILURE
)


// ============================================================
// 12. CLICK SUBMIT INTEREST
// ============================================================

TestObject submitInterest = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/button_Submit Interest'
)

WebUI.waitForElementClickable(
    submitInterest,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.click(submitInterest)


// ============================================================
// 13. VERIFY EXPRESS INTEREST MODAL TITLE
// ============================================================

TestObject expressInterestTitle = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/h2_radix-_r_5b'
)

WebUI.waitForElementVisible(
    expressInterestTitle,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.verifyElementText(
    expressInterestTitle,
    'Submit Interest',
    FailureHandling.STOP_ON_FAILURE
)


// ============================================================
// 14. VERIFY "WHY YOU'RE A FIT" LABEL
// ============================================================

TestObject whyFitLabel = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/label_Why youre a fit _(required)'
)

WebUI.waitForElementVisible(
    whyFitLabel,
    20,
    FailureHandling.STOP_ON_FAILURE
)


// Get actual text from the browser
String actualText = WebUI.getText(whyFitLabel)


// Expected text
// IMPORTANT:
// There is a SPACE between "*" and "(required)"
String expectedText = "Why you're a fit * (required)"


// ============================================================
// NORMALIZE WHITESPACE
// ============================================================

// Convert line breaks, tabs and multiple spaces into one space
actualText = actualText.replaceAll(/\s+/, ' ').trim()

expectedText = expectedText.replaceAll(/\s+/, ' ').trim()


// ============================================================
// PRINT VALUES TO KATALON LOG
// ============================================================

WebUI.comment(
    "Actual Label Text   : [" + actualText + "]"
)

WebUI.comment(
    "Expected Label Text : [" + expectedText + "]"
)


// ============================================================
// VERIFY LABEL TEXT
// ============================================================

WebUI.verifyMatch(
    actualText,
    expectedText,
    false,
    FailureHandling.STOP_ON_FAILURE
)


// ============================================================
// 15. VERIFY CANCEL BUTTON
// ============================================================

TestObject cancelButton = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/button_Cancel'
)

WebUI.waitForElementVisible(
    cancelButton,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.verifyElementVisible(
    cancelButton,
    FailureHandling.STOP_ON_FAILURE
)


// ============================================================
// 16. VERIFY SUBMIT INTEREST BUTTON IN MODAL
// ============================================================

TestObject submitInterestModalButton = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/button_Submit Interest_1'
)

WebUI.waitForElementVisible(
    submitInterestModalButton,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.verifyElementVisible(
    submitInterestModalButton,
    FailureHandling.STOP_ON_FAILURE
)


// ============================================================
// 17. CANCEL EXPRESS INTEREST MODAL
// ============================================================

WebUI.click(cancelButton)


// ============================================================
// 18. GO BACK TO OPPORTUNITY MARKETPLACE
// ============================================================

TestObject backToOpportunityMarketplace = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/a_Back to Opportunity Marketplace'
)

WebUI.waitForElementClickable(
    backToOpportunityMarketplace,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.click(backToOpportunityMarketplace)


// ============================================================
// 19. OPEN USER MENU
// ============================================================

TestObject maheshFaculty = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/p_Mahesh Faculty'
)

WebUI.waitForElementClickable(
    maheshFaculty,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.click(maheshFaculty)


// ============================================================
// 20. LOGOUT
// ============================================================

TestObject logout = findTestObject(
    'oppurtunity Marketplace/Verify Express Interest modal opens from details page/Page_Cintana Faculty Portal/div_Logout'
)

WebUI.waitForElementClickable(
    logout,
    20,
    FailureHandling.STOP_ON_FAILURE
)

WebUI.click(logout) 


// ============================================================
// 21. CLOSE BROWSER
// ============================================================

WebUI.closeBrowser()
