package tests;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.BaseRunner;

import java.time.Duration;
import java.util.List;
import java.util.Set;


import static org.junit.Assert.*;


/* Создано 01.04.18
   Автор: Сунгатуллин Р.И.

  SecondWebTests  - находит ссылку (https://www.tinkoff.ru/mobile-operator/tariffs/)
  в поиске и после переходит по ней и закрывает лишнюю вкладку.
 *  */

public class MobileOperatorTests extends BaseRunner {

    Logger logger = LoggerFactory.getLogger(MobileOperatorTests.class);

    @Test
    public void pageSwitcher() {
        String firstHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://google.ru/");
        driver.findElement(By.xpath("//input[contains(@aria-label,'Запрос')]"))
                .sendKeys("Тинькофф мобайл");
        driver.findElement(By.xpath("//input[contains(@aria-label,'Запрос')]"))
                .sendKeys(Keys.ENTER);
        By listItems = By.xpath("//li[contains(@class,'serp-item')]/div/h2//div[contains(@class,'organic__url-text')]");
        List<WebElement> items = driver.findElements(listItems);

        wait
                .ignoring(StaleElementReferenceException.class)
                .withMessage("что то пошло не так")
                .pollingEvery(Duration.ofMillis(500))
                .until(driver -> {
                    for (WebElement element : items) {
                        if (element.getText().contains("Тарифы")) {
                            element.click();
                            break;
                        }
                    }
                    Set<String> ids = driver.getWindowHandles();
                    ids.forEach(id -> {
                        if (!id.equals(driver.getWindowHandle())) {
                            driver.switchTo().window(id);
                            logger.info("Переключились к вкладке " + driver.getTitle());
                        }
                    });
                    String secondHandle = driver.getWindowHandle();
                    assertEquals("Тарифы Тинькофф Мобайла", driver.getTitle());
                    driver.switchTo().window(firstHandle);
                    driver.close();
                    driver.switchTo().window(secondHandle);
                    assertEquals("https://www.tinkoff.ru/mobile-operator/tariffs/", driver.getCurrentUrl());
                    driver.close();
                    return driver.getTitle().equals("Мобильный оператор");
                });
    }

}
