package web.factory

import org.openqa.selenium.WebDriver

abstract class DriverManager {

    protected val driverCachePath = "drivers"

    abstract fun createDriver() : WebDriver
}