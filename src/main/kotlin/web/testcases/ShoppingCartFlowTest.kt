package web.testcases

import WebBaseTest
import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import web.pages.CellPhonePage
import web.pages.LoginPage
import web.pages.ShoppingCartPage

class ShoppingCartFlowTest : WebBaseTest() {

    @Test
    fun shoppingCartFlowTest() {
        val loginPage = LoginPage(driver)
        loginPage.doLogin(EMAIL_ADDRESS, PASSWORD)
        val cellPhonePage = CellPhonePage(driver)
        cellPhonePage.clickOnHtcOneMiniBlueItem()
        cellPhonePage.clickOnAddToCartButton()
        val shoppingCartPage = ShoppingCartPage(driver)
        shoppingCartPage.clickOnCheckbox()
        shoppingCartPage.clickOnCheckoutButton()
        shoppingCartPage.fillAllRequiredFieldsForShippingAddress()
        shoppingCartPage.chooseShippingMethod()
        Thread.sleep(3000)
        shoppingCartPage.choosePaymentMethod()
        shoppingCartPage.fillCreditCardDetails(cardHolderName = CARD_HOLDER_NAME, cardNumber = CARD_NUMBER, cardCode = CVC)
        shoppingCartPage.confirmOrder()
        assertTrue(shoppingCartPage.isDetailsLinkDisplayed)
    }

    private companion object {
        const val EMAIL_ADDRESS: String = "test123@gmail.com"
        const val PASSWORD: String = "apokalipsa"
        const val CARD_HOLDER_NAME: String = "Test Credit Card"
        const val CARD_NUMBER: String = "4242424242424242"
        const val CVC: String = "123"
    }
}