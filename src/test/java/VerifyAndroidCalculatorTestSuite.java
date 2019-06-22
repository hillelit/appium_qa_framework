import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import native_frontend.CalculatorMainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ApplicationCapabilitiesFactory;
import utils.JavaAppiumServer;

public class VerifyAndroidCalculatorTestSuite {

    private DesiredCapabilities capabilities;
    private JavaAppiumServer javaAppiumServer;
    private AppiumDriver webDriver;

    @Before
    public void setUpConfig() {
        final DesiredCapabilities androidCalculatorCapabilities = ApplicationCapabilitiesFactory.getCapabilities("Calculator");
        webDriver = new AndroidDriver(capabilities);
        javaAppiumServer = new JavaAppiumServer();
        javaAppiumServer.startServer(androidCalculatorCapabilities);
    }

    @Test
    public void verifyUserIsAbleToCalculateTheExpression() {
        final CalculatorMainPage mainPage = new CalculatorMainPage(webDriver);
        mainPage.typeExpression("2 + 2");
        mainPage.calculateExpression();
        Assert.assertEquals("There is incorrect result calculated!", "4", mainPage.getCalculationResult());
    }

    @After
    public void tearDownServer() {
        javaAppiumServer.stopServer();
    }
}
