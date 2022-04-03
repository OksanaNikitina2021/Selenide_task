import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class TravelerDataPage {
    private final List<SelenideElement> travelerFormFields = $$x("//input[@type=\"text\"]");

    public void verifyTravelerFormIsEmpty() {
        for (SelenideElement formField : travelerFormFields) {
            Assert.assertTrue(formField.getValue().isEmpty());
        }
    }
}