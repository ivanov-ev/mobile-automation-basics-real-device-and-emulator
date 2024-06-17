package helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Attach {

    //Todo: Make the screenshotAs method work with both base64 and non-base64 files.
    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        String base64 = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BASE64);
        base64 = base64.replaceAll("[\n\r]", "");
        return Base64.getDecoder().decode(base64);
    }
    //When screenshots are not base64, use the following code:
    /*
        public static byte[] screenshotAs(String attachName) {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }
     */

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo(String sessionId) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + Browserstack.videoUrl(sessionId)
                + "' type='video/mp4'></video></body></html>";
    }
}