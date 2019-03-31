import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/* Создано 24.03.18
   Автор: Сунгатуллин Р.И.

   Base Runner - Вызывает методы, которые открывают тестируемую страницу в браузере ( FireFox / Chrome )
 *  */

public class BaseRunner {

    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp(){
        driver = BrowsersFactory.chrome.create();
        driver.manage().window().maximize();
        baseUrl = "https://www.tinkoff.ru/career/vacancies/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
