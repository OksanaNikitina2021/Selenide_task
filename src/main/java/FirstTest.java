import org.junit.Test;

public class FirstTest extends BaseTest {

    private final static String BASE_URL = "https://www.bta.lv/";

    @Test
    public void PurchaseTravelPolicy() {
        MainPage mainPage = new MainPage(BASE_URL);
        TravelPolicyPage travelPolicyPage = new TravelPolicyPage();
        PolicyProgramPage policyProgramPage = new PolicyProgramPage();
        TravelerDataPage travelerDataPage = new TravelerDataPage();

        mainPage.clickTravelPolicyButton();

        travelPolicyPage.changeTravelDestinationTo("Indija");
        travelPolicyPage.verifyDestinationCountryChanged();
        travelPolicyPage.changeActivityTo("Sports");
        travelPolicyPage.verifyActivityChanged();
        travelPolicyPage.moveToSecondStep();

        policyProgramPage.chooseOptimalPlusPolicy();
        policyProgramPage.showWhatIsIncluded();
        policyProgramPage.verifyCoveredTravelPopupVisibility();
        policyProgramPage.moveToThirdStep();

        travelerDataPage.verifyTravelerFormIsEmpty();
    }
}