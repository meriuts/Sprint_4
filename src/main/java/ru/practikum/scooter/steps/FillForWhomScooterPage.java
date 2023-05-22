package ru.practikum.scooter.steps;

import org.openqa.selenium.WebDriver;
import ru.practikum.scooter.pages.ForWhomScooterPage;

public class FillForWhomScooterPage extends ForWhomScooterPage {
    public FillForWhomScooterPage (WebDriver driver) {
        super(driver);
    }
    public void fillForWhomScooterPage  (String name, String surname, String address, int indexOfMetroStation, String phoneNumberForCourier) {
        fillNameField(name);
        fillSurnameField(surname);
        fillAddressField(address);
        chooseMetroStation(indexOfMetroStation);
        fillPhoneNumberForCourier(phoneNumberForCourier);
        clickOnForWhomScooterButtonNext();

    }






}
