package com.upgrade.automation.ui.test;

import java.util.Hashtable;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.upgrade.automation.common.BaseUITest;
import com.upgrade.automation.common.test.dataprovider.ExcelDataProvider;
import com.upgrade.automation.ui.constants.PageConstants;
import com.upgrade.automation.ui.pages.GetStartedPage;
import com.upgrade.automation.ui.pages.LoginPage;
import com.upgrade.automation.ui.pages.MainPage;
import com.upgrade.automation.ui.pages.OfferPage;

public class CredifyLoanOfferUITest extends BaseUITest{

    @Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "user_data_dp")
    public void loanOfferTest(Hashtable<String,String> userData) throws InterruptedException {

        MainPage mp = getPage(MainPage.class);

        //Navigate to https://www.credify.tech/phone/nonDMFunnel
        //Enter loan amount as 2,000 and select any purpose
        //Click "Check your Rate"
        GetStartedPage gsp = mp.doCheckYourRate("2000","Other");

        //In the "Let's get started with some basic information" page
        //Enter all the details and click on "Check Your Rate" button
        OfferPage op = gsp.submitIndividualForm(userData);

        //From the /offer-page, store the Loan Amount, Monthly Payment, Term, Interest Rate and APR
        // from the default offer on top of the page.
        Map<String,String> offerDetailsExpected = op.saveOffer();

        //Click on "Sign Out" from the Menu option in the top right corner
        op.signOut();

        //Now navigate to https://www.credify.tech/portal/login
        mp.navigateTo(getAppProperty("site.login.url"));
        LoginPage lp = getPage(LoginPage.class);

        //Enter the previously entered email and password
        //Click "Sign In to your account"
        op = lp.doLogin(userData.get(PageConstants.EMAIL_ADDRESS), userData.get(PageConstants.PASSWORD));


        //Make sure you are on /offer-page
        Assert.assertTrue(op.isOfferPage());
        Map<String,String> offerDetailsActual = op.saveOffer();

        //Validate that Loan Amount, APR, Loan Term and Monthly Payment matches with the info submitted previously
        Assert.assertEquals(offerDetailsActual.get("loan_amount"), offerDetailsExpected.get("loan_amount"));
        Assert.assertEquals(offerDetailsActual.get("monthly_payment"), offerDetailsExpected.get("monthly_payment"));
        Assert.assertEquals(offerDetailsActual.get("term"), offerDetailsExpected.get("term"));
        Assert.assertEquals(offerDetailsActual.get("interest_rate"), offerDetailsExpected.get("interest_rate"));
        Assert.assertEquals(offerDetailsActual.get("apr"), offerDetailsExpected.get("apr"));
    }

}
