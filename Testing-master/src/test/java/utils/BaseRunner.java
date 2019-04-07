package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/* Создано 24.03.18
   Автор: Сунгатуллин Р.И.

   Base Runner - Вызывает методы, которые открывают тестируемую страницу в браузере ( FireFox / Chrome )
 *  */

public class BaseRunner {
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;
    public final String browserName = "chrome";


    @Before
    public void start() {
        threadLocal = new ThreadLocal<>();
        driver = new EventFiringWebDriver(getDriver());
        ((EventFiringWebDriver) driver).register(new BrowsersFactory.MyListener());
        threadLocal.set(driver);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

    private WebDriver getDriver() {
        return BrowsersFactory.buildDriver(browserName);
    }
}