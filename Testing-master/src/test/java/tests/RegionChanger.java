package tests;

import javafx.scene.control.CheckBox;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.BaseRunner;


import static org.junit.Assert.assertEquals;

/* Создано 01.04.18
   Автор: Сунгатуллин Р.И.

  RegionChanger  - запускает проверки по ссылке (https://www.tinkoff.ru/mobile-operator/tariffs/)
  Тест сравнивает цены.

 *  */

public class RegionChanger extends BaseRunner {

    @Test
    public void RegionChanger() {

        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        Assert.assertTrue(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::span[2]")).getText().matches("^Москва и Московская область[\\s\\S]$"));
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Москва и Московская область?'])[1]/following::span[1]")).click();
        Assert.assertEquals("Москва и Московская область", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).getText());
        Assert.assertEquals("Общая цена: 316 ₽", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::h3[1]")).getText());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[4]/following::div[6]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[2]/following::div[5]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[3]/following::div[4]")).click();
        Assert.assertEquals("Общая цена: 583 ₽", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::h3[1]")).getText());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите регион'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите регион'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите регион'])[1]/following::input[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите регион'])[1]/following::input[1]")).sendKeys("Крас");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='г Красноярск'])[1]/following::div[2]")).click();
        Assert.assertEquals("Краснодарский край", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Точки продаж'])[1]/following::div[13]")).getText());
        Assert.assertEquals("Общая цена: 296 ₽", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::h3[1]")).getText());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[4]/following::div[6]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[2]/following::div[5]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='?'])[3]/following::div[4]")).click();
        Assert.assertEquals("Общая цена: 563 ₽", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите пакеты услуг'])[1]/following::h3[1]")).getText());
    }
}
