package com.upgrade.automation.api.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.upgrade.automation.api.RestResourceUtil;
import com.upgrade.automation.api.constants.ApiConstants;
import com.upgrade.automation.api.model.ResumeRequest;
import com.upgrade.automation.api.model.ResumeResponse;
import com.upgrade.automation.common.BaseApiTest;
import com.upgrade.automation.common.test.dataprovider.ExcelDataProvider;

import io.restassured.response.Response;

public class CredifyLoanOfferApiTest extends BaseApiTest {

	private static final Logger logger = Logger.getLogger(CredifyLoanOfferApiTest.class);	
	
	@Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "user_data_dp")
	public void verifyLoanAppExistsTest(Hashtable<String, String> data) {
		logger.info("Running testcase to verify if Loan application exists...");
		ResumeRequest resumeRequest = createResumeRequest(data);
		
		Map<String,String> headers = new HashMap<>();		
		headers.put("x-cf-source-id", data.get("x-cf-source-id"));
		headers.put("x-cf-corr-id", data.get("x-cf-corr-id"));
		
		String contentType = "application/x-www-form-urlencoded; charset";

		Response response = RestResourceUtil.post(ApiConstants.API_RESUME_URL, contentType, headers, resumeRequest);		
		ResumeResponse resumeResponse = response.as(ResumeResponse.class);
		
		String productType = resumeResponse.getLoanAppResumptionInfo().getProductType();
		int statusCode = response.getStatusCode();

		logger.info("Response status code: " + statusCode);
		logger.debug("Response Json: \n" + response.body().toString());		

		logger.info("Product Type received from Api : " +  productType);
		logger.info("Expected product type : " +  data.get("expectedProductType"));

		Assert.assertEquals(productType, data.get("expectedProductType"));
		Assert.assertEquals(statusCode, (int)Double.valueOf(data.get("expectedStatusCode")).doubleValue());
	}

	@Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "user_data_dp")
	public void verifyLoanAppNotExistsTest(Hashtable<String, String> data) {
		logger.info("Running testcase to verify if Loan application does not exist (passing wrong loan UUID)...");
		
		ResumeRequest resumeRequest = createResumeRequest(data);
		
		Map<String,String> headers = new HashMap<>();		
		headers.put("x-cf-source-id", data.get("x-cf-source-id"));
		headers.put("x-cf-corr-id", data.get("x-cf-corr-id"));
		
		String contentType = "application/x-www-form-urlencoded; charset";

		Response response = RestResourceUtil.post(ApiConstants.API_RESUME_URL, contentType, headers, resumeRequest);				
		int statusCode = response.getStatusCode();
		logger.info("Response status code: " + statusCode);
		logger.debug("Response Json: \n" + response.body().toString());

		Assert.assertEquals(statusCode, (int)Double.valueOf(data.get("expectedStatusCode")).doubleValue());
	}

	private ResumeRequest createResumeRequest(Hashtable<String, String> data){
		ResumeRequest resumeRequest = new ResumeRequest();
		resumeRequest.setLoanAppUuid(data.get("loanAppUuid"));
		resumeRequest.setSkipSideEffects(Boolean.parseBoolean(data.get("skipSideEffects")));
		return resumeRequest;
	}
	
}
