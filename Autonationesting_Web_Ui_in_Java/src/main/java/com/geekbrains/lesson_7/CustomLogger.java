package com.geekbrains.lesson_7;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.ByteArrayInputStream;

public class CustomLogger implements WebDriverListener {
    public void beforeClick(WebElement element) {
        Allure.step("Кликаем на элемент с текстом: " + element.getText());
    }

    public void beforeQuit(WebDriver driver) {
        Allure.addAttachment("Скриншот страницы: ",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
