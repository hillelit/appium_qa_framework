package utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ApplicationCapabilitiesFactory {

    private ApplicationCapabilitiesFactory() {
    }

    public static DesiredCapabilities getCapabilities(final String applicationName) {
        switch (applicationName) {

            case "Skype":
                final DesiredCapabilities skypeCapabilities = new DesiredCapabilities();
                skypeCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "R58M36G55CR");
                skypeCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                skypeCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
                skypeCapabilities.setCapability("appPackage", "com.skype.raider");
                skypeCapabilities.setCapability("appActivity", "net.hockeyapp.android.LoginActivity");
                return skypeCapabilities;

            case "Google":
                final DesiredCapabilities googleCapabilities = new DesiredCapabilities();
                googleCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "R58M36G55CR");
                googleCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                googleCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
                googleCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                return googleCapabilities;

            case "Calculator":
                final DesiredCapabilities androidCalculator = new DesiredCapabilities();
                androidCalculator.setCapability(MobileCapabilityType.DEVICE_NAME, "R58M36G55CR");
                androidCalculator.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                androidCalculator.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
                androidCalculator.setCapability("appPackage", "com.sec.android.app.popupcalculator");
                androidCalculator.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
                return androidCalculator;

            default:
                throw new IllegalStateException("There is no such application name!");
        }
    }
}
