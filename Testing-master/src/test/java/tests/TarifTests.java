package tests;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import utils.BaseRunner;

/* Создано 24.03.18
   Автор: Сунгатуллин Р.И.

  WebTests - Здесь расположены тесты записанные с помощью katalon recorder
  Ниже расположены 2 сценария тестирования.
 *  */

public class TarifTests extends BaseRunner {

    @Test
    public void testEmptyValue() {
        driver.get("https://www.tinkoff.ru/career/vacancies/");
        driver.findElement(By.xpath("//input[@name='name']")).click();
        driver.findElement(By.name("birthday")).click();
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text())and normalize-space(.)='условиями передачи информации'])[1]/following::button[1]")).click();
        assertEquals("Поле обязательное", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());
        assertEquals("Поле обязательное", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText());
        assertEquals("Поле обязательное", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Город проживания'])[1]/following::div[3]")).getText());
        assertEquals("Поле обязательное", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[2]")).getText());
        assertEquals("Поле обязательное", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText());
        assertEquals("Поле обязательное", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='загрузите резюме/портфолио'])[1]/following::div[1]")).getText());
        assertEquals("Поле обязательное", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условиями передачи информации'])[1]/following::div[1]")).getText());
    }

    @Test
    public void testInvalidValue() {
        driver.get("https://www.tinkoff.ru/career/vacancies/");
        driver.findElement(By.name("name")).sendKeys("Артас123");
        driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
        assertEquals("Допустимо использовать только буквы русского алфавита и дефис", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());

        driver.findElement(By.name("name")).sendKeys(Keys.CONTROL, "a", "\b");
        driver.findElement(By.name("name")).sendKeys("Ффффффффффффффффффффффффффффффффффффффффффффффффффффффффффффффффффффффффф" +
                                                                    "аааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааа");
        driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
        assertEquals("Максимальное количество символов – 133", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());

        driver.findElement(By.name("name")).sendKeys(Keys.CONTROL, "a", "\b");
        driver.findElement(By.name("name")).sendKeys("Артас");
        driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
        assertEquals("Необходимо ввести фамилию и имя через пробел",driver.findElement(
                  By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());

        driver.findElement(By.name("birthday")).sendKeys("00.49.4904");
        driver.findElement(By.name("email")).sendKeys("Привет");
        driver.findElement(By.name("phone")).sendKeys("+7(008) 555-35-35");
        driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
        assertEquals("Поле заполнено некорректно", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText());
        assertEquals("Введите корректный адрес эл. почты", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[2]")).getText());
        assertEquals("Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9", driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText());
    }
}



