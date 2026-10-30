package id.triv.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public final class DriverFactory {

    private static AppiumDriver driver;

    private DriverFactory() {
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void startDriver() {

        if (driver != null) {
            System.out.println("INFO: Sesi Appium sudah aktif.");
            return;
        }

        String serverUrl = System.getProperty(
                "appium.url", "http://127.0.0.1:4723/"
        );

        String deviceName = System.getProperty(
                "device.name", "R9RXB01MV5Z"
        );

        String appPackage = System.getProperty(
                "app.package", "id.co.triv"
        );

        String appActivity = System.getProperty(
                "app.activity", "id.co.triv.main.splash.SplashActivity"
        );

       
        UiAutomator2Options options = new UiAutomator2Options()
        .setDeviceName(deviceName)
        .setAutomationName("UiAutomator2")
        .setPlatformName("Android")
        .setAppPackage(appPackage)
        .setAppActivity(appActivity)
        .setNoReset(false)
        .setAutoGrantPermissions(true)
        .setNewCommandTimeout(Duration.ofSeconds(120));


        try {
            System.out.println("INFO: Membuat sesi Appium...");
            System.out.println("INFO: Package = " + appPackage);
            System.out.println("INFO: Activity = " + appActivity);

            driver = new AndroidDriver(new URL(serverUrl), options);

            driver.manage().timeouts().implicitlyWait(Duration.ZERO);

            System.out.println("SUCCESS: Sesi Appium berhasil dibuat.");

            // Jeda sementara untuk memeriksa splash screen
            System.out.println(
                    "INFO: Menunggu video pembuka selama 15 detik..."
            );

            Thread.sleep(15000);

            System.out.println(
        "CURRENT PACKAGE: "
                + ((AndroidDriver) driver).getCurrentPackage()
);

            System.out.println(
                    "CURRENT ACTIVITY: "
                            + ((AndroidDriver) driver).currentActivity()
            );

            System.out.println("PAGE SOURCE SETELAH 15 DETIK:");
            System.out.println(driver.getPageSource());

        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(
                    "Invalid Appium server URL: " + serverUrl, e
            );

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            throw new IllegalStateException(
                    "Penungguan splash screen terhenti.", e
            );
        }
    }

    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
