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

public class RegisterPage {

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

    // Halaman Akun
    private final By registerNavigation =
            By.id("id.co.triv:id/btn_sign_up");

    // Halaman pemilihan metode registrasi
    private final By continueWithEmailButton =
            By.id("id.co.triv:id/btn_sign_up_email");

    // ==========================================
    // LOCATOR FORM REGISTER
    // ==========================================

    private final By firstNameField =
            By.id("id.co.triv:id/in_first_name");

    private final By lastNameField =
            By.id("id.co.triv:id/in_last_name");

    private final By emailField =
            By.id("id.co.triv:id/in_email");

    private final By passwordField =
            By.id("id.co.triv:id/in_password");

    private final By confirmPasswordField =
            By.id("id.co.triv:id/in_confirm_password");

    private final By occupationField =
             By.id("id.co.triv:id/spinner_occupation");

    private final By termsCheckbox =
            By.id("id.co.triv:id/cb_terms");

    private final By submitButton =
            By.id("id.co.triv:id/btn_register");

    private final By emailVerificationImage =
        By.id("id.co.triv:id/iv_verify");

    private final By emailVerificationMessage =
        AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"We've sent a welcome email\")"
        );        

    // ==========================================
    // LOCATOR POPUP
    // ==========================================

    private final By validationMessage =
            By.id("id.co.triv:id/tv_message");

    private final By popupOkButton =
            By.id("id.co.triv:id/btn_dismiss");

    // ==========================================
    // NAVIGASI KE HALAMAN REGISTER
    // ==========================================

    public void navigateToRegister() {

         WebDriverWait wait = getWait();

    // Jika form Register sudah terbuka, hentikan navigasi.
    if (!driver().findElements(emailField).isEmpty()
            && driver().findElements(emailField).get(0).isDisplayed()) {
        System.out.println("INFO: Form Register sudah terbuka.");
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

    // STEP 4: Klik Daftar.
    wait.until(d -> d.findElement(registerNavigation).isDisplayed());
    driver().findElement(registerNavigation).click();

    System.out.println("STEP 4: Tombol Daftar diklik.");

    // STEP 5: Pilih Continue with Email.
    wait.until(d ->
            d.findElement(continueWithEmailButton).isDisplayed()
    );

    driver().findElement(continueWithEmailButton).click();

    System.out.println("STEP 5: Continue with Email diklik.");

    // STEP 6: Pastikan form Register tampil.
    wait.until(d ->
            d.findElement(emailField).isDisplayed()
    );

    System.out.println("SUCCESS: Form Register berhasil dibuka.");
}

    // ==========================================
    // VALIDASI HALAMAN REGISTER
    // ==========================================

    public boolean isRegisterScreenDisplayed() {

       return driver().findElements(emailField).stream()
                .anyMatch(WebElement::isDisplayed)
            && driver().findElements(passwordField).stream()
                .anyMatch(WebElement::isDisplayed);
    }

    // ==========================================
    // TEST FORM KOSONG
    // ==========================================

    
public void submitEmptyForm() {

    // Tidak mengisi field apa pun.
    // Scroll hingga tombol Register ditemukan.
    scrollToRegisterButton();

    // Tunggu hingga tombol Register dapat diklik.
    WebElement registerButton = getWait().until(d -> {
        WebElement element = d.findElement(submitButton);

        return element.isDisplayed() && element.isEnabled()
                ? element : null;
    });

    registerButton.click();

    System.out.println(
            "INFO: Tombol Register diklik dengan form kosong."
    );
}


    //===========================================
    // VALIDASI FORM REGISTER
    //===========================================

    public void fillRegistrationFormWithValidData() {
    WebDriverWait wait = getWait();

    // 1. Isi First Name
    scrollToField("id.co.triv:id/in_first_name");

    WebElement firstName = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    firstNameField
            )
    );

    firstName.clear();
    firstName.sendKeys("User");

    // 2. Isi Last Name
    scrollToField("id.co.triv:id/in_last_name");

    WebElement lastName = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    lastNameField
            )
    );

    lastName.clear();
    lastName.sendKeys("Dummy");

    // 3. Isi Email
    scrollToField("id.co.triv:id/in_email");

    WebElement email = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    emailField
            )
    );

    email.clear();
    email.sendKeys("khabibfahrurrizal12100@gmail.com");

    // 4. Isi Password
    scrollToField("id.co.triv:id/in_password");

    WebElement password = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    passwordField
            )
    );

    password.clear();
    password.sendKeys("P@ssw0rdtesting123!");

    // 5. Isi Confirm Password
    scrollToField("id.co.triv:id/in_confirm_password");

    WebElement confirmPassword = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    confirmPasswordField
            )
    );

    confirmPassword.clear();
    confirmPassword.sendKeys("P@ssw0rdtesting123!");

    System.out.println(
            "INFO: Semua field registrasi telah diisi."
    );
}

public void selectOccupation(String occupation) {
    WebDriverWait wait = getWait();

    // Buka dropdown occupation.
    scrollToField("id.co.triv:id/spinner_occupation");

    WebElement dropdown = wait.until(
            ExpectedConditions.elementToBeClickable(
                    occupationField
            )
    );

    dropdown.click();

    // Cari opsi berdasarkan teks yang diberikan.
    By occupationOption = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"" + occupation + "\")"
    );

    WebElement option = wait.until(
            ExpectedConditions.elementToBeClickable(
                    occupationOption
            )
    );

    option.click();

    System.out.println(
            "INFO: Occupation dipilih: " + occupation
    );
}

public void acceptTermsAndConditions() {
    WebDriverWait wait = getWait();

    scrollToField("id.co.triv:id/cb_terms");

    WebElement checkbox = wait.until(
            ExpectedConditions.elementToBeClickable(
                    termsCheckbox
            )
    );

    if (!checkbox.isSelected()) {
        checkbox.click();
    }

    System.out.println(
            "INFO: Terms & Conditions disetujui."
    );
}

public void submitRegistrationForm() {
    WebDriverWait wait = getWait();

    scrollToField("id.co.triv:id/btn_register");

    WebElement button = wait.until(
            ExpectedConditions.elementToBeClickable(
                    submitButton
            )
    );

    button.click();

    System.out.println(
            "INFO: Tombol Selanjutnya diklik."
    );
}

public boolean isEmailVerificationScreenDisplayed() {
    WebDriverWait wait = getWait();

    try {
        WebElement verificationImage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("id.co.triv:id/iv_verify")
                )
        );

        System.out.println(
                "INFO: Halaman verifikasi email ditemukan."
        );

        System.out.println(
                "INFO: Gambar verifikasi tampil = "
                        + verificationImage.isDisplayed()
        );

        return verificationImage.isDisplayed();

    } catch (TimeoutException e) {
        System.out.println(
                "ERROR: Selector gambar verifikasi tidak ditemukan."
        );

        System.out.println("CURRENT PAGE SOURCE:");
        System.out.println(driver().getPageSource());

        return false;
    }
}
    // ==========================================
    // VALIDASI POPUP
    // ==========================================

    public boolean isValidationDisplayed() {

        WebDriverWait wait = getWait();

        try {
            WebElement message = getWait().until(d -> {
                for (WebElement element :
                        d.findElements(validationMessage)) {

                    if (element.isDisplayed()) {
                        return element;
                    }
                }

                return null;
            });

            return message != null;

        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    // ==========================================
    // KLIK OK PADA POPUP
    // ==========================================

    

public void dismissValidationPopup() {

    System.out.println("DEBUG: Menunggu tombol OK.");

    getWait().until(d ->
            d.findElement(popupOkButton).isDisplayed()
    );

    driver().findElement(popupOkButton).click();

    System.out.println("DEBUG: Tombol OK berhasil diklik.");

    getWait().until(d ->
            d.findElements(popupOkButton)
                    .stream()
                    .noneMatch(WebElement::isDisplayed)
    );

    System.out.println("DEBUG: Popup sudah tertutup.");
    System.out.println("DEBUG: PAGE SOURCE SETELAH POPUP:");

    System.out.println(driver().getPageSource());
}


    // ==========================================
    // VERIFIKASI KEMBALI KE FORM REGISTER
    // ==========================================

    
public boolean isRegisterFormDisplayedAfterPopup() {
    WebDriverWait wait = getWait();

    try {
        // Pastikan halaman registrasi masih terbuka.
        WebElement title = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .visibilityOfElementLocated(
                                By.id("id.co.triv:id/toolbar_title")
                        )
        );

        boolean correctTitle =
                "Register New Account".equals(title.getText());

        // Pastikan tombol submit form registrasi terlihat.
        WebElement registerButton = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .visibilityOfElementLocated(submitButton)
        );

        boolean formVisible =
                correctTitle && registerButton.isDisplayed();

        System.out.println("DEBUG: Judul halaman = " + title.getText());
        System.out.println(
                "DEBUG: Tombol Selanjutnya terlihat = "
                        + registerButton.isDisplayed()
        );
        System.out.println(
                "DEBUG: Form registrasi tampil = " + formVisible
        );

        return formVisible;

    } catch (org.openqa.selenium.TimeoutException e) {
        System.out.println(
                "ERROR: Halaman registrasi atau tombol submit tidak ditemukan."
        );
        System.out.println(driver().getPageSource());
        return false;
    }
}

    public boolean isRegisterFormDisplayed() {
    return isRegisterFormDisplayedAfterPopup();
}

public void scrollToRegisterButton() {
    driver().findElement(
            AppiumBy.androidUIAutomator(
                    "new UiScrollable("
                    + "new UiSelector().scrollable(true)"
                    + ").scrollIntoView("
                    + "new UiSelector().resourceId("
                    + "\"id.co.triv:id/btn_register\"))"
            )
    );

    System.out.println(
            "INFO: Tombol Register sudah ditemukan setelah scroll."
    );
}
private void scrollToField(String resourceId) {
    driver().findElement(
            AppiumBy.androidUIAutomator(
                    "new UiScrollable("
                    + "new UiSelector().scrollable(true)"
                    + ").scrollIntoView("
                    + "new UiSelector().resourceId(\""
                    + resourceId
                    + "\"))"
            )
    );
}

}
