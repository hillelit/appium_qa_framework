import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    private WebDriver webDriver;

    public GoogleMainPage(final WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public MobileGoogleSearchResultsPage searchFor(final String text) {
        searchInput.sendKeys(text, Keys.ENTER);
        return new MobileGoogleSearchResultsPage(webDriver);
    }
}
