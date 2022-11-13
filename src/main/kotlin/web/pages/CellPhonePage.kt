package web.pages

import WebBasePage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CellPhonePage(driver: WebDriver) : WebBasePage(driver) {

    init {
        pageUrl = "https://$BASE_URL/cell-phones"
        driver.navigate().to(pageUrl)
    }

    @FindBy(xpath = "//div[@data-productid='19']")
    private val htcOneMiniBlue: WebElement? = null

    @FindBy(id = "add-to-cart-button-19")
    private val addToCartButton: WebElement? = null

    fun clickOnHtcOneMiniBlueItem() {
        clickOnElement(htcOneMiniBlue)
    }

    fun clickOnAddToCartButton() {
        clickOnElement(addToCartButton)
    }
}
