import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoField
import java.util.Locale

String baseUrl = 'https://qa-facultyportal.cintana.com/auth'
String loginEmail = 'anuragfaculty@test.com'
String encryptedPassword = '3JR9xufqD6UXZNPnOVht0Q=='
boolean browserOpened = false

TestObject continueToSignIn = findTestObject('Object Repository/oppurtunity Marketplace/Verify sorting by End date/Page_Cintana Faculty Portal/button_Continue to Sign In')
TestObject emailField = findTestObject('Object Repository/oppurtunity Marketplace/Verify sorting by End date/Page_Identity Hub/input_Email address_')
TestObject continueButton = findTestObject('Object Repository/oppurtunity Marketplace/Verify sorting by End date/Page_Identity Hub/button_Continue')
TestObject signInWithPassword = findTestObject('Object Repository/oppurtunity Marketplace/Verify sorting by End date/Page_Identity Hub/button_Sign in with Password')
TestObject usernameField = findTestObject('Object Repository/oppurtunity Marketplace/Verify sorting by End date/Page_Sign in to Identity Hub/input_Username or email')
TestObject passwordField = findTestObject('Object Repository/oppurtunity Marketplace/Verify sorting by End date/Page_Sign in to Identity Hub/input_Password')
TestObject submitLogin = findTestObject('Object Repository/oppurtunity Marketplace/Verify sorting by End date/Page_Sign in to Identity Hub/button_kc-login')
TestObject sortButton = findTestObject('Object Repository/oppurtunity Marketplace/Verify sorting by End date/Page_Cintana Faculty Portal/button_Sort')
TestObject profileName = findTestObject('Object Repository/oppurtunity Marketplace/Verify sorting by End date/Page_Cintana Faculty Portal/p_Mahesh Faculty')
TestObject logoutButton = findTestObject('Object Repository/oppurtunity Marketplace/Verify sorting by End date/Page_Cintana Faculty Portal/div_Logout')

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

    TestObject endDateOption = new TestObject('End date sort option')
    endDateOption.addProperty('xpath', ConditionType.EQUALS,
        "//*[@role='option' and contains(normalize-space(.), 'End date')]")
    WebUI.waitForElementClickable(endDateOption, 10)
    WebUI.click(endDateOption)

    String selectedSort = WebUI.getText(sortButton).trim()
    if (!selectedSort.toLowerCase(Locale.ENGLISH).contains('end date')) {
        throw new AssertionError('Expected End date sorting to be selected, but the sort control shows: ' + selectedSort)
    }

    TestObject opportunityRowLocator = new TestObject('Opportunity rows with End dates')
    opportunityRowLocator.addProperty('xpath', ConditionType.EQUALS,
        "//tr[.//span[starts-with(normalize-space(.), 'End:')]]")
    WebUI.waitForElementVisible(opportunityRowLocator, 20)

    List<WebElement> dateElements = WebUI.findWebElements(opportunityRowLocator, 20)
    if (dateElements == null || dateElements.size() < 3) {
        throw new AssertionError('Expected at least 3 opportunity rows with End dates, but found ' +
            (dateElements == null ? 0 : dateElements.size()))
    }

    List<String> displayedDates = []
    List<LocalDate> parsedDates = []
    List<DateTimeFormatter> formatsWithYear = [
        DateTimeFormatter.ofPattern('MMM d, uuuu', Locale.ENGLISH),
        DateTimeFormatter.ofPattern('d-MMM-uuuu', Locale.ENGLISH),
        DateTimeFormatter.ofPattern('d MMM uuuu', Locale.ENGLISH),
        DateTimeFormatter.ofPattern('M/d/uuuu', Locale.ENGLISH),
        DateTimeFormatter.ofPattern('MM/dd/uuuu', Locale.ENGLISH),
        DateTimeFormatter.ISO_LOCAL_DATE
    ]
    List<DateTimeFormatter> formatsWithoutYear = [
        new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern('d-MMM')
            .parseDefaulting(ChronoField.YEAR, 2000).toFormatter(Locale.ENGLISH),
        new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern('d MMM')
            .parseDefaulting(ChronoField.YEAR, 2000).toFormatter(Locale.ENGLISH),
        new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern('MMM d')
            .parseDefaulting(ChronoField.YEAR, 2000).toFormatter(Locale.ENGLISH)
    ]

    for (int index = 0; index < 3; index++) {
        String rowText = dateElements[index].getText()?.trim()
        String lowerRowText = rowText?.toLowerCase(Locale.ENGLISH)
        int endLabelIndex = lowerRowText == null ? -1 : lowerRowText.indexOf('end:')
        if (endLabelIndex < 0) {
            throw new AssertionError('Could not read an End date from row ' + (index + 1) + ': ' + rowText)
        }

        int dateStartIndex = endLabelIndex + 'end:'.length()
        String dateText = rowText.substring(dateStartIndex).trim()
        int nextLineIndex = dateText.indexOf('\n')
        if (nextLineIndex >= 0) {
            dateText = dateText.substring(0, nextLineIndex).trim()
        }
        LocalDate parsedDate = null
        for (DateTimeFormatter formatter : formatsWithYear) {
            try {
                parsedDate = LocalDate.parse(dateText, formatter)
                break
            } catch (DateTimeParseException ignored) {
                // Try the next supported display format.
            }
        }
        if (parsedDate == null) {
            for (DateTimeFormatter formatter : formatsWithoutYear) {
                try {
                    parsedDate = LocalDate.parse(dateText, formatter)
                    break
                } catch (DateTimeParseException ignored) {
                    // Try the next supported display format.
                }
            }
        }
        if (parsedDate == null) {
            throw new AssertionError('Unrecognized End date format in row ' + (index + 1) + ': ' + dateText)
        }

        displayedDates.add(dateText)
        parsedDates.add(parsedDate)
    }

    boolean row1BeforeRow2 = parsedDates[0].isBefore(parsedDates[1])
    KeywordUtil.logInfo('Compare Row 1 with Row 2: ' + displayedDates[0] + ' comes before ' +
        displayedDates[1] + ' — ' + (row1BeforeRow2 ? 'Pass' : 'Fail'))
    if (!row1BeforeRow2) {
        KeywordUtil.markFailed('End date sorting failed: Row 1 (' + displayedDates[0] +
            ') is not earlier than Row 2 (' + displayedDates[1] + ').')
    }

    boolean row2BeforeRow3 = parsedDates[1].isBefore(parsedDates[2])
    KeywordUtil.logInfo('Compare Row 2 with Row 3: ' + displayedDates[1] + ' comes before ' +
        displayedDates[2] + ' — ' + (row2BeforeRow3 ? 'Pass' : 'Fail'))
    if (!row2BeforeRow3) {
        KeywordUtil.markFailed('End date sorting failed: Row 2 (' + displayedDates[1] +
            ') is not earlier than Row 3 (' + displayedDates[2] + ').')
    }
} catch (Throwable t) {
    KeywordUtil.markFailed('End date sorting testcase encountered an error: ' +
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