package web.pages

import WebBasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ShoppingCartPage(driver: WebDriver) : WebBasePage(driver) {

    init {
        pageUrl = "https://$BASE_URL/cart"
        driver.navigate().to(pageUrl)
    }

    @FindBy(id = "termsofservice")
    private val termsCheckbox: WebElement? = null

    @FindBy(xpath = "//button[@id='checkout']")
    private val checkoutButton: WebElement? = null

    @FindBy(xpath = "//input[@id='BillingNewAddress_City']")
    private val cityField: WebElement? = null

    @FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
    private val addressField: WebElement? = null

    @FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
    private val zipCodeField: WebElement? = null

    @FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
    private val phoneNumberFiled: WebElement? = null

    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
    private val countryDropdown: WebElement? = null

    @FindBy(xpath = "//option[@value='212']")
    private val albaniaOption: WebElement? = null

    @FindBy(xpath = "//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']")
    private val nextDayAirOption: WebElement? = null

    @FindBy(xpath = "//button[@name='save']")
    private val continueButton: WebElement? = null

    @FindBy(xpath = "//input[@id='paymentmethod_1']")
    private val creditCardPaymentMethod: WebElement? = null

    @FindBy(xpath = "//input[@id='CardholderName']")
    private val cardHolderNameField: WebElement? = null

    @FindBy(xpath = "//input[@id='CardNumber']")
    private val cardNumberField: WebElement? = null

    @FindBy(id = "ExpireYear")
    private val expireYearDropdown: WebElement? = null

    @FindBy(xpath = "//option[@value='2023']")
    private val dropdownSelection: WebElement? = null

    @FindBy(xpath = "//input[@id='CardCode']")
    private val cardCodeField: WebElement? = null

    @FindBy(xpath = "//button[@onclick='ConfirmOrder.save()']")
    private val confirmButton: WebElement? = null

    @FindBy(xpath = "//div[@class='details-link']")
    private val detailsLink: WebElement? = null

    @FindBy(xpath = "//input[@id='ShipToSameAddress']")
    private val shipTheSameAddressCheckbox: WebElement? = null

    @FindBy(xpath = "//button[@onclick='ShippingMethod.save()']")
    private val shippmentContinueButton: WebElement? = null

    @FindBy(xpath = "PaymentMethod.save()")
    private val paymentContinueButton: WebElement? = null

    val isDetailsLinkDisplayed: Boolean get() = isElementDisplayed(detailsLink)
    val isShipTheSameAddressCheckboxDisplayed: Boolean get() = isElementDisplayed(shipTheSameAddressCheckbox)

    fun clickOnCheckbox() {
        clickOnElement(termsCheckbox)
    }

    fun clickOnCheckoutButton() {
        clickOnElement(checkoutButton)
    }

    fun chooseShippingMethod() {
        clickOnElement(nextDayAirOption)
        clickOnElement(shippmentContinueButton)
    }

    fun clickOnContinue() {
        clickOnElement(continueButton)
    }

    fun confirmOrder() {
        clickOnElement(confirmButton)
    }

    fun fillAllRequiredFieldsForShippingAddress() {
        if (isShipTheSameAddressCheckboxDisplayed) {
            clickOnContinue()
        } else {
            clickOnElement(countryDropdown)
            clickOnElement(albaniaOption)
            cityField!!.sendKeys("Tirana")
            addressField!!.sendKeys("Test123")
            zipCodeField!!.sendKeys("456")
            phoneNumberFiled!!.sendKeys("3456789")
            clickOnContinue()
        }
    }

    fun choosePaymentMethod() {
        clickOnElement(creditCardPaymentMethod)
        clickOnElement(paymentContinueButton)
    }

    fun fillCreditCardDetails(cardHolderName: String, cardNumber: String, cardCode: String) {
        cardHolderNameField!!.sendKeys(cardHolderName)
        cardNumberField!!.sendKeys(cardNumber)
        clickOnElement(expireYearDropdown)
        clickOnElement(dropdownSelection)
        cardCodeField!!.sendKeys(cardCode)
        clickOnContinue()
    }


}