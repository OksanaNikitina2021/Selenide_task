import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement cookieAccept = $x("//section[@id=\"module-284\"]/div[1]/div[2]/button[2]");
    private final SelenideElement travelPoliciesLink = $x("//section[@id=\"module-28\"]/div/div/div[3]/a[2]");

    public MainPage(String url) {
        Selenide.open(url);
        clickOnCookieBanner();
    }

    public void clickOnCookieBanner() {
        cookieAccept.click();
    }

    public void clickTravelPolicyButton() {
        travelPoliciesLink.click();
    }
}
