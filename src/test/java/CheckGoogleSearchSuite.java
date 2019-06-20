import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.JavaAppiumServer;

public class CheckGoogleSearchSuite {

    private DesiredCapabilities capabilities;
    private JavaAppiumServer javaAppiumServer;
    private WebDriver webDriver;

    @Before
    public void setUpConfig() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "R58M36G55CR");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        webDriver = new AndroidDriver(capabilities);
        javaAppiumServer = new JavaAppiumServer();
        javaAppiumServer.startServer(capabilities);
    }

    @Test
    public void verifyGoogleTitle() {
        webDriver.get("https://www.google.com/");
        Assert.assertEquals("There is incorrect title!", webDriver.getTitle(), "Google");
    }

    @Test
    public void verifySearchPossibility() {
        webDriver.get("https://www.google.com/");
        final GoogleMainPage googleMainPage = new GoogleMainPage(webDriver);
        final MobileGoogleSearchResultsPage resultPage = googleMainPage.searchFor("ttt");
        Assert.assertEquals("There is incorrect first item text!", "ttt", resultPage.getFirstSearchResultTitleText());
    }

    @After
    public void stopServer() {
        javaAppiumServer.stopServer();
    }
}
