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
    private final String phoneNumberForCourier;
    private final String deliveryDate;
    private final String comment;
    private final String textOfSuccessfulOrder;

    public TestOrderScooter (String nameOfOrderButton, String name, String surname, String address, String phoneNumberForCourier, String deliveryDate, String comment, String textOfSuccessfulOrder) {
        this.nameOfOrderButton = nameOfOrderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumberForCourier = phoneNumberForCourier;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.textOfSuccessfulOrder = textOfSuccessfulOrder;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"headerOrderButton","Иван", "Иванов", "Ленина, 34", "89991112233", "01.07.2023", "Вход со двора", "Номер заказа"},
                {"headerOrderButton","Сергей", "Сергеев", "Новая, 2", "89991112244", "05.10.2023", "Вход со двора и нет шлагбаума", "Заказ оформлен"},
                {"bodyOrderButton","Сергей", "Сергеев", "Новая, 2", "89991112244", "05.10.2023", "Вход со двора и нет шлагбаума", "Номер заказа"},
                {"bodyOrderButton","Петр", "Петрович", "Старая, 123", "89991112277", "29.12.2023", "Позвони как придешь", "Заказ оформлен"},
        };
    }
    @Test
    public void checkOrderScooter () {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnAcceptCookieButton();
        mainPage.clickOnOrderButton(nameOfOrderButton);

        FillForWhomScooterPage fillForWhomScooterPage = new FillForWhomScooterPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(fillForWhomScooterPage.getNameField()));

        fillForWhomScooterPage.fillForWhomScooterPage(name, surname, address, phoneNumberForCourier);

        FillAboutRentPage fillAboutRentPage = new FillAboutRentPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(fillAboutRentPage.getDeliveryDateField()));

        fillAboutRentPage.fillAboutRentPage(deliveryDate,comment);
        fillAboutRentPage.clickOnOrderConfirmModalButtonYes();

        assertNotNull(fillAboutRentPage.getOrderConfirmModalElement());
        assertTrue(fillAboutRentPage.getModalElementOfSuccessfulOrder().getText().contains(textOfSuccessfulOrder));
    }
}
