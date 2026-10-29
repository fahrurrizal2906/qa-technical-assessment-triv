package id.triv.hooks;

import id.triv.config.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.util.Base64;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.startDriver();

        AppiumDriver driver = DriverFactory.getDriver();

        if (driver instanceof CanRecordScreen recorder) {
            recorder.startRecordingScreen();
            System.out.println("INFO: Video recording dimulai.");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        AppiumDriver driver = DriverFactory.getDriver();

        if (driver != null && driver instanceof CanRecordScreen recorder) {
            try {
                String videoBase64 = recorder.stopRecordingScreen();

                if (videoBase64 != null && !videoBase64.isEmpty()) {
                    byte[] videoBytes = Base64.getDecoder().decode(videoBase64);

                    Allure.addAttachment(
                        "Video Recording - " + scenario.getName(),
                        "video/mp4",
                        new ByteArrayInputStream(videoBytes),
                        ".mp4"
                    );

                    System.out.println(
                        "SUCCESS: Video dilampirkan ke Allure untuk: "
                            + scenario.getName()
                    );
                }
            } catch (Exception e) {
                System.err.println(
                    "WARNING: Gagal menyimpan video recording: "
                        + e.getMessage()
                );
            }
        }

        DriverFactory.stopDriver();
    }
}
