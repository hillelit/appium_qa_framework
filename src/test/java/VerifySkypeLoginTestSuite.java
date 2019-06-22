import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import native_frontend.CalculatorMainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ApplicationCapabilitiesFactory;
import utils.JavaAppiumServer;

public class VerifySkypeLoginTestSuite {

    private JavaAppiumServer javaAppiumServer;
    private AppiumDriver webDriver;

    @Before
    public void setUpConfig() {
        final DesiredCapabilities skypeCapabilities = ApplicationCapabilitiesFactory.getCapabilities("Skype");
        webDriver = new AndroidDriver(skypeCapabilities);
        javaAppiumServer = new JavaAppiumServer();
        javaAppiumServer.startServer(skypeCapabilities);
    }

    @Test
    public void verifyUserIsAbleToCalculateTheExpression() {

    }

    @After
    public void tearDownServer() {
        javaAppiumServer.stopServer();
    }
}
