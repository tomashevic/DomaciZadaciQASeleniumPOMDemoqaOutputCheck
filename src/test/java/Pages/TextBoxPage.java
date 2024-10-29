package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextBoxPage {


    WebDriver driver;

    WebElement fullNameField;
    WebElement emailField;
    WebElement currentAddressField;
    WebElement permanentAddressField;
    WebElement submitButton;
    WebElement outputCell;
    WebElement invalidEmailFormat;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFullNameField() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddressField() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddressField() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public List<WebElement> getOutputCell() {
        return driver.findElements(By.className("mb-1"));
    }

    public WebElement getInvalidEmailFormat() {
        return driver.findElement(By.cssSelector(".mr-sm-2.field-error.form-control"));
    }

    public void inputFullName(String fullName) {
        getFullNameField().clear();
        getFullNameField().sendKeys(fullName);
    }

    public void inputEmail(String email) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    public void inputCurrentAddress(String addressC) {
        getCurrentAddressField().clear();
        getCurrentAddressField().sendKeys(addressC);
    }

    public void inputPermanentAddress(String addressP) {
        getPermanentAddressField().clear();
        getPermanentAddressField().sendKeys(addressP);
    }

    public void clickOnSubmit() {
        getSubmitButton().click();
    }
}
