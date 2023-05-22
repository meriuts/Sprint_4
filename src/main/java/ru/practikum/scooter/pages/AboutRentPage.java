package ru.practikum.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AboutRentPage {
    WebDriver driver;
    private final By deliveryDate = By.xpath(".//div[@class = 'react-datepicker__input-container']/input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private final By fieldRentalPeriod = By.xpath(".//div[@class = 'Dropdown-root']/div[@class = 'Dropdown-control']/div[@class = 'Dropdown-arrow-wrapper']/span[@class = 'Dropdown-arrow']");
    private final By listRentalPeriod = By.xpath(".//div[@class = 'Dropdown-menu']/div");
    private final By blackScooterColor = By.xpath(".//label[@class = 'Checkbox_Label__3wxSf']/input[@id = 'black']");
    private final By greyScooterColor = By.xpath(".//label[@class = 'Checkbox_Label__3wxSf']/input[@id = 'grey']");
    private final By commentForCourier = By.xpath(".//div[@class = 'Input_InputContainer__3NykH']/input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private final By orderButton = By.xpath(".//button[(@class = 'Button_Button__ra12g Button_Middle__1CSJM') and (text() = 'Заказать')]");
    private final By orderConfirmModalElement = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']");
    private final By orderConfirmModalButtonYes = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']/div[@class = 'Order_Buttons__1xGrp']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By modalElementOfSuccessfulOrder = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']/div[contains(text(),'Заказ оформлен')]");


    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDeliveryDateField () {
        return driver.findElement(deliveryDate);
    }

    public WebElement getOrderConfirmModalElement () {
        return driver.findElement(orderConfirmModalElement);
    }

    public WebElement getModalElementOfSuccessfulOrder () {
        return driver.findElement(modalElementOfSuccessfulOrder);
    }

    public void fillDeliveryDate (String date) {
        driver.findElement(deliveryDate).sendKeys(date);
    }

    public void clickOnRentalPeriod () {
        driver.findElement(fieldRentalPeriod).click();
    }
    public void chooseRentalPeriod (int rentalPeriod) {
        rentalPeriod--;
        List<WebElement> listPeriod = driver.findElements(listRentalPeriod);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", listPeriod.get(rentalPeriod));
        listPeriod.get(rentalPeriod).click();
    }

    public void chooseScooterColor (String color) {
        if(color.equals("black")) {
            driver.findElement(blackScooterColor).click();
        } else if (color.equals("grey")) {
            driver.findElement(greyScooterColor).click();
        }else if (color.equals("twoColors")){
            driver.findElement(blackScooterColor).click();
            driver.findElement(greyScooterColor).click();
        }
    }

    public void fillCommentForCourier (String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    public void clickOnOrderButton () {
        driver.findElement(orderButton).click();
    }

    public void clickOnOrderConfirmModalButtonYes () {
        driver.findElement(orderConfirmModalButtonYes).click();
    }

}
