import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.*;

public class PolicyProgramPage {
    private final SelenideElement optimalPlusPolicyButton = $x("//section[@id=\"form-travel-policy\"]//div[2]/button[1]");
    private final SelenideElement whatIsIncludedButton = $x("//section/div[2]/button[2]");
    private final SelenideElement coveredTravelPopup = $x("//aside[@class=\"single-popup covered-travel\"]");
    private final SelenideElement popupCloseButton = $x("//button[@class=\"popup-close close\"]");
    private final SelenideElement submitProgramButton = $x("//footer/div/button");

    public void chooseOptimalPlusPolicy() {
        optimalPlusPolicyButton.click();
    }

    public void showWhatIsIncluded() {
        whatIsIncludedButton.click(ClickOptions.usingJavaScript());
    }

    public void verifyCoveredTravelPopupVisibility() {
        Assert.assertTrue(coveredTravelPopup.isDisplayed());
    }

    public void moveToThirdStep() {
        popupCloseButton.click();
        submitProgramButton.click();
    }
}