package id.triv.steps;

import id.triv.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RegisterSteps {

    private final RegisterPage registerPage = new RegisterPage();

    @Given("I am on the registration screen")
    public void iAmOnTheRegistrationScreen() {
        registerPage.navigateToRegister();
        Assert.assertTrue(
            "Registration screen was not displayed.",
            registerPage.isRegisterScreenDisplayed()
        );
    }

    @Then("the registration screen should be displayed")
    public void theRegistrationScreenShouldBeDisplayed() {
        Assert.assertTrue(
            "Registration screen was not displayed.",
            registerPage.isRegisterScreenDisplayed()
        );
    }

    @When("I submit the registration form without required fields")
    public void iSubmitTheRegistrationFormWithoutRequiredFields() {
        registerPage.submitEmptyForm();
    }

    @Then("registration validation should be displayed")
    public void registrationValidationShouldBeDisplayed() {
        Assert.assertTrue(
            "Registration validation popup was not displayed.",
            registerPage.isValidationDisplayed()
        );
    }

    @When("I dismiss the registration validation popup")
    public void iDismissTheRegistrationValidationPopup() {
        registerPage.dismissValidationPopup();
    }

    @Then("the registration form should remain displayed")
    public void theRegistrationFormShouldRemainDisplayed() {
        Assert.assertTrue(
            "Registration form was not displayed after dismissing validation.",
            registerPage.isRegisterFormDisplayed()
        );
    }

    @When("I fill in the registration form with valid data")
public void fillRegistrationFormWithValidData() {
    registerPage.fillRegistrationFormWithValidData();
}

@When("I select occupation {string}")
public void selectOccupation(String occupation) {
    registerPage.selectOccupation(occupation);
}

@When("I accept the terms and conditions")
public void acceptTermsAndConditions() {
    registerPage.acceptTermsAndConditions();
}

@When("I submit the registration form")
public void submitRegistrationForm() {
    registerPage.submitRegistrationForm();
}

@Then("the email verification screen should be displayed")
public void isEmailVerificationScreenDisplayed() {
    Assert.assertTrue(
            "Halaman verifikasi email tidak ditampilkan setelah registrasi.",
            registerPage.isEmailVerificationScreenDisplayed()
    );
}
}