import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import ch.qos.logback.core.util.Duration
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import java.time.Duration

WebUI.openBrowser(null)

WebUI.maximizeWindow()

// Get WebDriver
WebDriver driver = DriverFactory.getWebDriver()

// Global implicit wait - 30 seconds
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30))

WebUI.navigateToUrl('https://qa-facultyportal.cintana.com/auth')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/button_Continue to Sign In'))

WebUI.setText(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Identity Hub/input_Email address_'), 
    'anuragfaculty@test.com')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Identity Hub/button_Continue'))

WebUI.click(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Identity Hub/button_Sign in with Password'))

WebUI.setText(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Sign in to Identity Hub/input_Username or email'), 
    'anuragfaculty@test.com')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Sign in to Identity Hub/input_Username or email'))

WebUI.setEncryptedText(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Sign in to Identity Hub/input_Password'), 
    '3JR9xufqD6UXZNPnOVht0Q==')

WebUI.click(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Sign in to Identity Hub/button_kc-login'))

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/h1_Opportunity Marketplace'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/h1_Opportunity Marketplace'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/h1_Opportunity Marketplace'))

WebUI.assertElementText(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/h1_Opportunity Marketplace'), 
    'Opportunity Marketplace', 0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/input_Search by opportunity title'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/input_Search by opportunity title'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/button_Filters'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/button_Filters'), 
    0)

WebUI.rightClick(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/button_Sort'))

WebUI.assertElementVisible(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/button_Sort'), 
    0)

WebUI.click(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/svg_lucide lucide-ellipsis-vertical app-sidebar_'))

WebUI.click(findTestObject('oppurtunity Marketplace/Verify Opportunity Marketplace page loads successfully/Page_Cintana Faculty Portal/div_Logout'))

WebUI.closeBrowser()

