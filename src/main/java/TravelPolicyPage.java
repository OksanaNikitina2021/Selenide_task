import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TravelPolicyPage {
    private final SelenideElement destinationCountry = $x("//button[@id=\"regionalSelectorRegion-open\"]");
    private final SelenideElement chooseCountry = $x("//div[@id=\"regionalSelectorCountry\"]");
    private final SelenideElement addCountry = $x("//button[@id=\"regionalSelectorCountry-addCountry\"]");
    private final List<SelenideElement> regionalSelectorItemList = $$x("//button[@id=\"regionalSelectorCountry-selectItem\"]");
    private final SelenideElement travelDestination = $x("//*[@id=\"regionalSelectorRegion-open\"]/span[1]");
    private final SelenideElement applyButton = $x("//button[@id=\"regionalSelectorCountry-applyButton\"]");
    private final SelenideElement activitySelector = $x("//button[@id=\"travelActivities-open\"]");
    private final List<SelenideElement> activityButtonLabels = $$x("//span[@class='label']");
    private final List<SelenideElement> activityButtons = $$x("//button[@class='item']");
    private final SelenideElement travelActivity = $x("//*[@id=\"travelActivities-open\"]/span[1]");
    private final SelenideElement submitPolicyButton = $x("//section[@id=\"form-travel-insurance\"]//div[@class=\"buttons\"]/button");

    private String travelDestinationBeforeChange;
    private String activityBeforeChange;

    public void changeTravelDestinationTo(String text) {
        travelDestinationBeforeChange = travelDestination.getText();
        destinationCountry.click();
        chooseCountry.click();
        addCountry.click();

        for (SelenideElement item : regionalSelectorItemList) {
            if (item.getAttribute("data-value").equals(text)) {
                item.click();
                break;
            }
        }
        applyButton.click();
    }

    public void verifyDestinationCountryChanged() {
        Assert.assertNotEquals(travelDestinationBeforeChange, travelDestination.getText());
    }

    public void changeActivityTo(String text) {
        activityBeforeChange = travelActivity.getText();
        activitySelector.click();
        int index = 0;
        for (SelenideElement item : activityButtonLabels) {
            if (item.getText().equals(text)) {
                activityButtons.get(index).click();
                break;
            }
            index++;
        }
    }

    public void verifyActivityChanged() {
        Assert.assertNotEquals(activityBeforeChange, travelActivity.getText());
    }

    public void moveToSecondStep() {
        submitPolicyButton.click();
    }
}