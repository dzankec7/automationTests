package web.pages

import WebBasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LoginPage(driver: WebDriver) : WebBasePage(driver) {

    init {
        pageUrl = "https://$BASE_URL/login"
        driver.navigate().to(pageUrl)
    }

    @FindBy(xpath = "//input[@id='Email']")
    private val emailAddressField: WebElement? = null

    @FindBy(xpath = "//input[@id='Password']")
    private val passwordField: WebElement? = null

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    private val loginButton: WebElement? = null

    fun doLogin(emailAddress: String, password: String) {
        emailAddressField!!.sendKeys(emailAddress)
        passwordField!!.sendKeys(password)
        clickOnElement(loginButton)
    }
}