package ru.practikum.scooter.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.practikum.scooter.DriverFactory;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    @Before
    public void setupDriver() {
        driver = DriverFactory.startUpDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }

}
