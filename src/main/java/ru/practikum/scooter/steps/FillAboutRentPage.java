package ru.practikum.scooter.steps;

import org.openqa.selenium.WebDriver;
import ru.practikum.scooter.pages.AboutRentPage;

public class FillAboutRentPage extends AboutRentPage {

    public FillAboutRentPage(WebDriver driver) {
        super(driver);
    }

    public void fillAboutRentPage (String deliveryDate, int rentalPeriod, String color, String comment) {
        fillDeliveryDate(deliveryDate);
        clickOnRentalPeriod();
        chooseRentalPeriod(rentalPeriod);
        chooseScooterColor(color);
        fillCommentForCourier(comment);
        clickOnOrderButton();
    }
}
