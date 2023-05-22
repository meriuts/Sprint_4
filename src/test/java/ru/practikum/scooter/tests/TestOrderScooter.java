package ru.practikum.scooter.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practikum.scooter.pages.MainPage;
import ru.practikum.scooter.steps.FillAboutRentPage;
import ru.practikum.scooter.steps.FillForWhomScooterPage;
import java.time.Duration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestOrderScooter extends BaseTest {
    private final String nameOfOrderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final int indexOfMetroStation;
    private final String phoneNumberForCourier;
    private final String deliveryDate;
    private final int rentalPeriod;
    private final String color;
    private final String comment;
    private final String textOfSuccessfulOrder;

    public TestOrderScooter (String nameOfOrderButton, String name, String surname, String address, int indexOfMetroStation, String phoneNumberForCourier, String deliveryDate, int rentalPeriod, String color, String comment, String textOfSuccessfulOrder) {
        this.nameOfOrderButton = nameOfOrderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.indexOfMetroStation = indexOfMetroStation;
        this.phoneNumberForCourier = phoneNumberForCourier;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
        this.textOfSuccessfulOrder = textOfSuccessfulOrder;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"headerOrderButton","Иван", "Иванов", "Ленина, 34", 15, "89991112233", "01.07.2023", 1, "black",  "Вход со двора", "Номер заказа"},
                {"headerOrderButton","Сергей", "Сергеев", "Новая, 2", 100,  "89991112244", "05.10.2023", 2, "grey", "Вход со двора и нет шлагбаума", "Заказ оформлен"},
                {"bodyOrderButton","Сергей", "Сергеев", "Новая, 2", 178,  "89991112244",  "05.10.2023", 3, "twoColors", "Вход со двора и нет шлагбаума", "Номер заказа"},
                {"bodyOrderButton","Петр", "Петрович", "Старая, 123", 34,  "89991112277", "29.12.2023", 4, "black", "Позвони как придешь", "Заказ оформлен"},
        };
    }    @Test
    public void checkOrderScooter () {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnAcceptCookieButton();
        mainPage.clickOnOrderButton(nameOfOrderButton);

        FillForWhomScooterPage fillForWhomScooterPage = new FillForWhomScooterPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(fillForWhomScooterPage.getNameField()));

        fillForWhomScooterPage.fillForWhomScooterPage(name, surname, address, indexOfMetroStation, phoneNumberForCourier);

        FillAboutRentPage fillAboutRentPage = new FillAboutRentPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(fillAboutRentPage.getDeliveryDateField()));

        fillAboutRentPage.fillAboutRentPage(deliveryDate, rentalPeriod, color, comment);
        fillAboutRentPage.clickOnOrderConfirmModalButtonYes();

        assertNotNull(fillAboutRentPage.getOrderConfirmModalElement());
        assertTrue(fillAboutRentPage.getModalElementOfSuccessfulOrder().getText().contains(textOfSuccessfulOrder));
    }
}
