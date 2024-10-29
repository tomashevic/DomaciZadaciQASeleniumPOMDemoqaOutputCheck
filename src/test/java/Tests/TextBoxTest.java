package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
        homepagePage.clickOnCard("Elements");
        sidebarPage.clickOnButton("Text Box");


    }

    @Test(priority = 10)
    public void personalEntryWithValidEmail() {
        String fullName = "Pera Peric";
        String validemail = "peraperic@mail.com";
        String currentAddresss = "Current Address12";
        String permanentAddresss = "Permanent Address13";

        textBoxPage.inputFullName(fullName);
        textBoxPage.inputEmail(validemail);
        textBoxPage.inputCurrentAddress(currentAddresss);
        textBoxPage.inputPermanentAddress(permanentAddresss);
        textBoxPage.clickOnSubmit();
        System.out.println(textBoxPage.getOutputCell().size());
        Assert.assertEquals(textBoxPage.getOutputCell().get(0).getText(), "Name:" + fullName);
        Assert.assertEquals(textBoxPage.getOutputCell().get(1).getText(), "Email:" + validemail);
        Assert.assertEquals(textBoxPage.getOutputCell().get(2).getText(), "Current Address :" + currentAddresss);
        Assert.assertEquals(textBoxPage.getOutputCell().get(3).getText(), "Permananet Address :" + permanentAddresss);


    }

    @Test(priority = 20)
    public void personalEntryWithInvalidEmail() {
        String fullName = "Pera Peric";
        String validemail = "peraperic@mail.com";
        String invalidEmail = "pera@example.com";
        String currentAddresss = "Current Address12";
        String permanentAddresss = "Permanent Address13";

        textBoxPage.inputFullName(fullName);
        textBoxPage.inputEmail(invalidEmail);
        textBoxPage.inputCurrentAddress(currentAddresss);
        textBoxPage.inputPermanentAddress(permanentAddresss);
        textBoxPage.clickOnSubmit();

        System.out.println(textBoxPage.getOutputCell().size());
        Assert.assertEquals(textBoxPage.getOutputCell().get(0).getText(), "Name:" + fullName);
        Assert.assertNotEquals(textBoxPage.getOutputCell().get(1).getText(), "Email:" + validemail);
        Assert.assertEquals(textBoxPage.getOutputCell().get(1).getText(), "Email:" + invalidEmail);
        Assert.assertEquals(textBoxPage.getOutputCell().get(2).getText(), "Current Address :" + currentAddresss);
        Assert.assertEquals(textBoxPage.getOutputCell().get(3).getText(), "Permananet Address :" + permanentAddresss);


    }


    @Test(priority = 30)
    public void personalEntryWithInvalidEmailFormat() {
        String fullName = "Pera Peric";
        String invalidEmailFormat = "pera!#@mail.co";
        String currentAddresss = "Current Address12";
        String permanentAddresss = "Permanent Address13";

        textBoxPage.inputFullName(fullName);
        textBoxPage.inputEmail(invalidEmailFormat);
        textBoxPage.inputCurrentAddress(currentAddresss);
        textBoxPage.inputPermanentAddress(permanentAddresss);
        textBoxPage.clickOnSubmit();
        System.out.println(textBoxPage.getOutputCell().size());
        Assert.assertTrue(textBoxPage.getInvalidEmailFormat().isDisplayed());

    }

}
