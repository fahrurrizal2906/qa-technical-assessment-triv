package id.triv.pages;

import id.triv.config.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {

    private AppiumDriver driver() {
        return DriverFactory.getDriver();
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(driver(), Duration.ofSeconds(15));
    }

    // ==========================================
    // LOCATOR NAVIGASI
    // ==========================================

    // Welcome Page
    private final By continueButton =
            By.id("id.co.triv:id/btn_next");

    // Dashboard
    private final By profileButton =
            By.id("id.co.triv:id/img_profile");

    // pilih button login
    private final By loginNavigation =
            By.id("id.co.triv:id/btn_sign_in");

    
    // Locator elemen halaman login
    private final By emailField = By.id("id.co.triv:id/in_email");
    private final By passwordField = By.id("id.co.triv:id/in_password");
    private final By submitButton = By.id("id.co.triv:id/btn_login");
    private final By validationMessage = By.id("id.co.triv:id/tv_subtitle");
    private final By invalidCredentialsTitle =By.id("id.co.triv:id/tv_title");
    //private final By verificationCode = By.id("id.co.triv:id/validation_popup");

     // ==========================================
    // NAVIGASI KE HALAMAN Login
    // ==========================================

    public void navigateToLogin() {

         WebDriverWait wait = getWait();

    // Jika form Login sudah terbuka, hentikan navigasi.
    if (!driver().findElements(emailField).isEmpty()
            && driver().findElements(emailField).get(0).isDisplayed()) {
        System.out.println("INFO: Form Login sudah terbuka.");
        return;
    }

    // STEP 1: Welcome Page
    if (!driver().findElements(continueButton).isEmpty()) {

        System.out.println("STEP 1: Welcome Page ditemukan.");

        WebElement lanjut = wait.until(d -> {
            WebElement element = d.findElement(continueButton);
            return element.isDisplayed() && element.isEnabled()
                    ? element : null;
        });

        lanjut.click();

        System.out.println("STEP 1: Tombol Lanjut diklik.");

        // Pastikan Dashboard benar-benar terbuka.
        wait.until(d ->
                !d.findElements(profileButton).isEmpty()
                && d.findElements(profileButton).get(0).isDisplayed()
        );

        System.out.println("STEP 2: Dashboard berhasil terbuka.");

    } else if (!driver().findElements(profileButton).isEmpty()
            && driver().findElements(profileButton).get(0).isDisplayed()) {

        System.out.println("INFO: Dashboard sudah terbuka.");

    } else {

        throw new IllegalStateException(
                "Aplikasi tidak berada di Welcome Page atau Dashboard."
        );
    }

    // STEP 3: Klik ikon profil.
    wait.until(d -> d.findElement(profileButton).isDisplayed());
    driver().findElement(profileButton).click();

    System.out.println("STEP 3: Ikon profil diklik.");

    // STEP 4: Klik Login.
    WebElement loginButton = wait.until(
        ExpectedConditions.elementToBeClickable(loginNavigation)
);

    loginButton.click();

System.out.println("STEP 4: Tombol Login diklik.");

    System.out.println("SUCCESS: Form Login berhasil dibuka.");
        
    }

    // ==========================================
    // VALIDASI HALAMAN LOGIN
    // ==========================================

    public boolean isLoginScreenDisplayed() {

       try {
        WebDriverWait wait = getWait();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField)
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(submitButton)
        );

        return true;

    } catch (org.openqa.selenium.TimeoutException e) {
        System.out.println("ERROR: Halaman login tidak ditemukan.");
        System.out.println(driver().getPageSource());
        return false;
    }
    }


     // ==========================================
    // INPUT FORM LOGIN
    // ==========================================
   

    public void loginWithValidCredentials(String email, String password) {
    WebDriverWait wait = getWait();

    // STEP 1: Pastikan halaman Login sudah terbuka.
    WebElement emailInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(emailField)
    );

    System.out.println("STEP 1: Field email ditemukan.");

    // STEP 2: Input email.
    emailInput.clear();
    emailInput.sendKeys(email);

    System.out.println("STEP 2: Email berhasil diinput.");

    // STEP 3: Input password.
    WebElement passwordInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordField)
    );

    passwordInput.clear();
    passwordInput.sendKeys(password);

    System.out.println("STEP 3: Password berhasil diinput.");

    // STEP 4: Klik tombol Login.
    WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
    );

    loginButton.click();

    System.out.println("STEP 4: Tombol Login diklik.");
}

    public boolean isOtpInstructionDisplayed() {
    try {
        WebElement message = getWait().until(
                ExpectedConditions.visibilityOfElementLocated(validationMessage)
        );

        return message.getText().contains(
                "Enter the 6-digit code"
        );

    } catch (TimeoutException e) {
        return false;
    }
}


public void loginWithInvalidCredentials(String email, String password) {
    WebDriverWait wait = getWait();

    // STEP 1: Tunggu field email tampil.
    WebElement emailInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(emailField)
    );

    emailInput.clear();
    emailInput.sendKeys(email);

    System.out.println("Email invalid berhasil diinput.");

    // STEP 2: Tunggu field password tampil.
    WebElement passwordInput = wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordField)
    );

    passwordInput.clear();
    passwordInput.sendKeys(password);

    System.out.println("Password berhasil diinput.");

    // STEP 3: Klik tombol Login.
    WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
    );

    loginButton.click();

    System.out.println("Tombol Login diklik.");

    // STEP 4: Beri waktu aplikasi memproses login.
    wait.until(driver ->
            !driver.findElements(invalidCredentialsTitle).isEmpty()
    );

    System.out.println("Popup invalid credentials terdeteksi.");
}

 
public boolean isInvalidCredentialsPopupDisplayed() {
    try {
        WebElement title = getWait().until(
                ExpectedConditions.visibilityOfElementLocated(
                        invalidCredentialsTitle
                )
        );

        String actualTitle = title.getText().trim();

        System.out.println("Popup title: " + actualTitle);

        return actualTitle.equals("Credentials Don't Match");

    } catch (TimeoutException e) {
        System.out.println("Popup invalid credentials tidak ditemukan.");
        System.out.println(driver().getPageSource());
        return false;
    }
}




}
