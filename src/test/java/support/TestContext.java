package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestContext {

    public static WebDriver driver;
    private static String timestamp;

    public static void setTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("+yyyy-mm-dd-h-mm-sss");
        timestamp = dateFormat.format(new Date());
    }

    public static String getTimestamp() {
        return timestamp;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Actions getActions() {
        return new Actions(driver);
    }

    public static WebDriverWait getWait() {
        return new WebDriverWait(driver, 5);
    }

    public static WebDriverWait getWait(int timeout) {
        return new WebDriverWait(driver, timeout);
    }

    public static JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static Map<String, String> getRfiForm(String filename) {
        Map<String, String> rfiInfo = getData(filename);
        String[] arr = rfiInfo.get("email").split("@");
        String newEmail = arr[0] + timestamp + "@" + arr[1];
        if (newEmail != null) {
            rfiInfo.put("email", newEmail);
        }
        return rfiInfo;
    }

    public static Map<String, String> getData(String fileName) {
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + ".yaml";
            File file = new File(path);
            InputStream stream = new FileInputStream(file);
            Yaml yaml = new Yaml();
            return yaml.load(stream);
        } catch (FileNotFoundException e) {
            return new HashMap<>();
        }
    }

    public static void initialize() {
        setTimestamp();
        initialize("chrome", "local", false);
    }

    public static void teardown() {
        driver.quit();
    }

    public static void initialize(String browser, String string, boolean isHeadless) {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> chromePreferences = new HashMap<>();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setExperimentalOption("prefs", chromePreferences);
        if (isHeadless) {
            chromeOptions.setHeadless(true);
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--disable-gpu");
        }
        driver = new ChromeDriver(chromeOptions);
    }
}
