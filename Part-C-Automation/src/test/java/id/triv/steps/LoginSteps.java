package id.triv.steps;
import io.cucumber.java.en.Given;
import id.triv.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();
//Scenario: LOG-001 Open login screen
    @Given("I navigate to the login screen")
    public void NavigateToTheLoginScreen() {
        loginPage.navigateToLogin();
    }

    @Then("the login screen should be displayed")
    public void theLoginScreenShouldBeDisplayed() {
        Assert.assertTrue(
                "Login screen marker was not found.",
                loginPage.isLoginScreenDisplayed()
        );
    }
//Scenario: LOG-002  login with valid credentials
    @When("I login with valid email {string} and password {string}")
public void iLoginWithValidCredentials(String email, String password) {
    loginPage.loginWithValidCredentials(email, password);
}

     
    // Validasi instruksi OTP
    @Then("the OTP instruction should be displayed")
    public void theOtpInstructionShouldBeDisplayed() {
        Assert.assertTrue(
                "OTP instruction was not displayed.",
                loginPage.isOtpInstructionDisplayed()
        );
    }

    //Scenario: LOG-003  login with invalid credentials
@When("I login with invalid email {string} and password {string}")
public void iLoginWithInvalidCredentials(String email, String password) {
    loginPage.loginWithInvalidCredentials(email, password);
}

@Then("the invalid credentials popup should be displayed")
public void theInvalidCredentialsPopupShouldBeDisplayed() {
    Assert.assertTrue(
            "Popup 'Credentials Don't Match' tidak ditemukan.",
            loginPage.isInvalidCredentialsPopupDisplayed()
    );
}

}