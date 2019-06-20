package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class JavaAppiumServer  {

    private AppiumDriverLocalService appiumDriverLocalService;
    private AppiumServiceBuilder serviceBuilder;

    public void startServer(final DesiredCapabilities appiumConfig) {

        serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.withIPAddress("127.0.0.1");
        serviceBuilder.usingPort(4723);
        serviceBuilder.usingDriverExecutable(new File("C:/Program Files/nodejs/node.exe"));
        serviceBuilder.withCapabilities(appiumConfig);

        appiumDriverLocalService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumDriverLocalService.start();
    }

    public void stopServer() {
        appiumDriverLocalService.stop();
    }
}
