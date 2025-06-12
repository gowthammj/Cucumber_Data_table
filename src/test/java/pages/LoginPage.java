package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameField = By.xpath("//input[@name='login[username]']");
    By  passwordField= By.xpath("//input[@name='login[password]']"); // Replace with actual ID
    By loginButton = By.xpath("//button[@class='action login primary']//span[text()='Sign In']");   // Replace with actual ID

    public void enterUsername(String Email) {
        driver.findElement(usernameField).sendKeys(Email);
    }

    public void enterPassword(String Password) {
        driver.findElement(passwordField).sendKeys(Password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
