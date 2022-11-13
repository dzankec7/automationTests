import org.openqa.selenium.WebDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Optional
import web.factory.ChromeDriverManager

open class WebBaseTest {

    protected lateinit var driver: WebDriver

    @BeforeMethod(alwaysRun = true)
    fun setUp(
            @Optional("chrome") buildBrowser: String,
            @Optional("windows") buildPlatform: String?
    ) {
        browser = "chrome"
        driver = ChromeDriverManager().createDriver()
    }

    @AfterMethod(alwaysRun = true)
    fun tearDown() {
        driver.quit()
    }

    companion object {
        var browser: String = "chrome"
        var version: String = "91"
    }
}