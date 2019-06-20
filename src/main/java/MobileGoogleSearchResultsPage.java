import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileGoogleSearchResultsPage {

    @FindBy(xpath = "(//*[@role='heading'])[1]")
    private WebElement firstSearchResultItem;

    private WebDriver webDriver;

    public MobileGoogleSearchResultsPage(final WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstSearchResultTitleText() {
        return firstSearchResultItem.getText();
    }
}
