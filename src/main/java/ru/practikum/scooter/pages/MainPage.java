package ru.practikum.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static ru.practikum.scooter.config.AppConfig.APP_URL;

public class MainPage {
    WebDriver driver;
    private final By headerOrderButton = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
    private final By bodyOrderButton = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button[text() = 'Заказать']");
    private final By questionAboutImportant = By.xpath(".//div[@class = 'accordion__button']");
    private final By answerAboutImportant = By.xpath(".//div[@data-accordion-component = 'AccordionItemPanel']/p");
    private final By acceptCookieButton = By.xpath(".//button[@class = 'App_CookieButton__3cvqF']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get(APP_URL);
    }

    public void clickOnAcceptCookieButton () {
        driver.findElement(acceptCookieButton).click();
    }
    public void clickOnOrderButton (String button) {
        if(button.equals("headerOrderButton")) {
            driver.findElement(headerOrderButton).click();
        } else if (button.equals("bodyOrderButton")) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(bodyOrderButton));
            driver.findElement(bodyOrderButton).click();
        }
    }
    public List<WebElement> findAllQuestionsAboutImportant() {
        return driver.findElements(questionAboutImportant);
    }
    public List<WebElement> findAllAnswersAboutImportant() {
        return driver.findElements(answerAboutImportant);
    }

}
