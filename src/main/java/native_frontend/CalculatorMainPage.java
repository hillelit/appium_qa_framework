package native_frontend;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CalculatorMainPage {

    @AndroidFindBy(id = "com.sec.android.app.popupcalculator:id/calc_edt")
    private MobileElement resultField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Равно']/android.widget.ImageView")
    private MobileElement calculateButton;

    private AppiumDriver appiumDriver;

    public CalculatorMainPage(final AppiumDriver driver) {
        this.appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void typeExpression(final String expressionToCalculate) {
        resultField.sendKeys(expressionToCalculate);
    }

    public void calculateExpression() {
        calculateButton.click();
    }

    public String getCalculationResult() {
        return resultField.getText();
    }
}
