package web.factory

import WebBasePage.Companion.BASE_URL
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration

class ChromeDriverManager : DriverManager() {

    override fun createDriver(): WebDriver {
        WebDriverManager.chromedriver()
                .cachePath("drivers")
                .setup()
       val driver: WebDriver = ChromeDriver()
        driver.navigate().to("https://${BASE_URL}")
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30L))
        return driver
    }

}