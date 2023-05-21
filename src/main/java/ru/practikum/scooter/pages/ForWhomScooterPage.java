package ru.practikum.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ForWhomScooterPage {
    WebDriver driver;
    private final By fieldName = By.xpath("(.//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input)[1]");
    private final By fieldSurname = By.xpath("(.//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input)[2]");
    private final By fieldAddress = By.xpath("(.//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input)[3]");
    private final By fieldMetroStation = By.xpath(".//div[@class = 'Order_Form__17u6u']/div/div[@class = 'select-search']/div[@class = 'select-search__value']/input[@class = 'select-search__input']");
    private final By listOfdMetroStation = By.xpath(".//div[@class = 'Order_Form__17u6u']/div/div[@class = 'select-search has-focus']/div[@class = 'select-search__select']/ul[@class = 'select-search__options']/li");

    private final By fieldPhoneNumberForCourier = By.xpath("(.//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input)[4]");
    private final By ForWhomScooterButtonNext = By.xpath(".//div[@class = 'Order_NextButton__1_rCA']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public ForWhomScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillNameField (String name) {
        driver.findElement(fieldName).click();
        driver.findElement(fieldName).sendKeys(name);
    }

    public WebElement getNameField () {
        return driver.findElement(fieldName);
    }

    public void fillSurnameField (String surname) {
        driver.findElement(fieldSurname).click();
        driver.findElement(fieldSurname).sendKeys(surname);
    }

    public void fillAddressField (String address) {
        driver.findElement(fieldAddress).click();
        driver.findElement(fieldAddress).sendKeys(address);
    }
    public void chooseRandomMetroStation () {
        driver.findElement(fieldMetroStation).click();
        List<WebElement> listOfStation = driver.findElements(listOfdMetroStation);
        int index = (int) (Math.random() * 200);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", listOfStation.get(index));
        listOfStation.get(index).click();
    }
    public void fillPhoneNumberForCourier (String phoneNumber) {
        driver.findElement(fieldPhoneNumberForCourier).sendKeys(phoneNumber);
    }
    public void clickOnForWhomScooterButtonNext () {
        driver.findElement(ForWhomScooterButtonNext).click();
    }

}
