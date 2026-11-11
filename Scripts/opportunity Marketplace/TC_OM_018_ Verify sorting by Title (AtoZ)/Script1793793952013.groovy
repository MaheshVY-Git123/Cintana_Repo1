import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import java.util.Locale

String baseUrl = 'https://qa-facultyportal.cintana.com/auth'
String loginEmail = 'anuragfaculty@test.com'
String encryptedPassword = '3JR9xufqD6UXZNPnOVht0Q=='
boolean browserOpened = false

TestObject continueToSignIn = findTestObject('oppurtunity Marketplace/Verify sorting by Title (AtoZ)/Page_Cintana Faculty Portal/button_Continue to Sign In')
TestObject emailField = findTestObject('oppurtunity Marketplace/Verify sorting by Title (AtoZ)/Page_Identity Hub/input_Email address_')
TestObject continueButton = findTestObject('oppurtunity Marketplace/Verify sorting by Title (AtoZ)/Page_Identity Hub/button_Continue')
TestObject signInWithPassword = findTestObject('oppurtunity Marketplace/Verify sorting by Title (AtoZ)/Page_Identity Hub/button_Sign in with Password')
TestObject usernameField = findTestObject('oppurtunity Marketplace/Verify sorting by Title (AtoZ)/Page_Sign in to Identity Hub/input_Username or email')
TestObject passwordField = findTestObject('oppurtunity Marketplace/Verify sorting by Title (AtoZ)/Page_Sign in to Identity Hub/input_Password')
TestObject submitLogin = findTestObject('oppurtunity Marketplace/Verify sorting by Title (AtoZ)/Page_Sign in to Identity Hub/button_kc-login')
TestObject sortButton = findTestObject('oppurtunity Marketplace/Verify sorting by Title (AtoZ)/Page_Cintana Faculty Portal/button_Sort')
TestObject profileName = findTestObject('oppurtunity Marketplace/Verify sorting by Title (AtoZ)/Page_Cintana Faculty Portal/p_Mahesh Faculty')
TestObject logoutButton = findTestObject('oppurtunity Marketplace/Verify sorting by Title (AtoZ)/Page_Cintana Faculty Portal/div_Logout')

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

    WebUI.waitForElementClickable(sortButton, 30)
    WebUI.click(sortButton)

    TestObject sortOptionsLocator = new TestObject('Available sort options')
    sortOptionsLocator.addProperty('xpath', ConditionType.EQUALS, "//*[@role='option']")
    WebUI.waitForElementVisible(sortOptionsLocator, 10)
    List<WebElement> sortOptions = WebUI.findWebElements(sortOptionsLocator, 10)

    WebElement titleAscendingOption = null
    List<String> availableSortLabels = []
    for (WebElement option : sortOptions) {
        String optionLabel = option.getText()?.trim()
        if (optionLabel) {
            availableSortLabels.add(optionLabel)
        }
        String normalizedLabel = optionLabel?.toLowerCase(Locale.ENGLISH)
            ?.replace('–', '-')?.replace('—', '-')?.replace('−', '-')?.replaceAll('\\s+', ' ')
        if (normalizedLabel != null && normalizedLabel.contains('title') &&
            (normalizedLabel.contains('a-z') || normalizedLabel.contains('a to z'))) {
            titleAscendingOption = option
            break
        }
    }

    if (titleAscendingOption == null) {
        throw new AssertionError('Could not find the Title A to Z sort option. Available options: ' +
            availableSortLabels.join(', '))
    }
    titleAscendingOption.click()

    String selectedSort = WebUI.getText(sortButton).trim()
    String normalizedSelectedSort = selectedSort.toLowerCase(Locale.ENGLISH)
        .replace('–', '-').replace('—', '-').replace('−', '-').replaceAll('\\s+', ' ')
    if (!normalizedSelectedSort.contains('title') ||
        !(normalizedSelectedSort.contains('a-z') || normalizedSelectedSort.contains('a to z'))) {
        throw new AssertionError('Expected Title A to Z sorting to be selected, but the sort control shows: ' +
            selectedSort)
    }

    WebUI.delay(1)
    TestObject opportunityRowsLocator = new TestObject('Opportunity rows with titles')
    opportunityRowsLocator.addProperty('xpath', ConditionType.EQUALS,
        "//tr[td[1]//a[contains(@href, '/opportunities/')]]")
    WebUI.waitForElementVisible(opportunityRowsLocator, 20)

    List<WebElement> opportunityRows = WebUI.findWebElements(opportunityRowsLocator, 20)
    if (opportunityRows == null || opportunityRows.size() < 3) {
        throw new AssertionError('Expected at least 3 opportunity rows with titles, but found ' +
            (opportunityRows == null ? 0 : opportunityRows.size()))
    }

    List<String> displayedTitles = []
    for (int index = 0; index < 3; index++) {
        List<WebElement> titleLinks = opportunityRows[index]
            .findElements(By.xpath("./td[1]//a[contains(@href, '/opportunities/')]"))
        if (titleLinks == null || titleLinks.isEmpty()) {
            throw new AssertionError('Could not find the title link in Row ' + (index + 1))
        }

        WebElement titleLink = titleLinks[0]
        String title = titleLink.getAttribute('title')?.trim()
        if (!title) {
            title = titleLink.getText()?.trim()
        }
        title = title?.replaceAll('\\s+', ' ')?.trim()
        if (!title) {
            throw new AssertionError('Could not read a title from Row ' + (index + 1))
        }
        displayedTitles.add(title)
    }

    boolean row1BeforeOrEqualRow2 = displayedTitles[0].compareToIgnoreCase(displayedTitles[1]) <= 0
    KeywordUtil.logInfo('Compare Row 1 with Row 2: "' + displayedTitles[0] +
        '" is alphabetically before or equal to "' + displayedTitles[1] + '" — ' +
        (row1BeforeOrEqualRow2 ? 'Pass' : 'Fail'))
    if (!row1BeforeOrEqualRow2) {
        KeywordUtil.markFailed('Title sorting failed: Row 1 "' + displayedTitles[0] +
            '" sorts after Row 2 "' + displayedTitles[1] + '".')
    }

    boolean row2BeforeOrEqualRow3 = displayedTitles[1].compareToIgnoreCase(displayedTitles[2]) <= 0
    KeywordUtil.logInfo('Compare Row 2 with Row 3: "' + displayedTitles[1] +
        '" is alphabetically before or equal to "' + displayedTitles[2] + '" — ' +
        (row2BeforeOrEqualRow3 ? 'Pass' : 'Fail'))
    if (!row2BeforeOrEqualRow3) {
        KeywordUtil.markFailed('Title sorting failed: Row 2 "' + displayedTitles[1] +
            '" sorts after Row 3 "' + displayedTitles[2] + '".')
    }
} catch (Throwable t) {
    KeywordUtil.markFailed('Title sorting testcase encountered an error: ' +
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