import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory

open class WebBasePage constructor(driver: WebDriver, url: String = "") {

    protected var driver: WebDriver = driver
    var pageUrl: String = "https://$BASE_URL$url"

    init {
        PageFactory.initElements(AjaxElementLocatorFactory(driver, 10), this)
    }

    fun clickOnElement(webElement: WebElement?) {
        webElement!!.click()
    }

    fun isElementDisplayed(element: WebElement?) : Boolean {
        return try {
            element!!.isDisplayed
        } catch(exception: Throwable) {
            false
        }
    }

    companion object {
        const val BASE_URL = "demo.nopcommerce.com"
    }
}
