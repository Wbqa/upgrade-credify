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
	
	/*
	 * Validate that for correct loanAppUuid provided in the payload below, the API
	 * response code is a 200 (OK). Parse each json value in the response payload
	 * individually. Then validate the productType attribute has value PERSONAL_LOAN
	 */
	@Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "user_data_dp")
	public void verifyLoanAppExistsTest(Hashtable<String, String> data) {
		logger.info("Running testcase to verify if Loan application exists...");
		
		//Request payload
		ResumeRequest resumeRequest = createResumeRequest(data);
		
		//Request headers
		Map<String,String> headers = new HashMap<>();		
		headers.put("x-cf-source-id", data.get("x-cf-source-id"));
		headers.put("x-cf-corr-id", data.get("x-cf-corr-id"));
		
		String contentType = "application/x-www-form-urlencoded; charset";

		//Making a POST call
		Response response = RestResourceUtil.post(ApiConstants.API_RESUME_URL, contentType, headers, resumeRequest);		
		
		//Parsing each json value in the response payload individually using pojo
		ResumeResponse resumeResponse = response.as(ResumeResponse.class);
		
		//Store productType and status code recieved from response for validations
		String productType = resumeResponse.getLoanAppResumptionInfo().getProductType();
		int statusCode = response.getStatusCode();

		logger.info("Response status code: " + statusCode);
		logger.debug("Response Json: \n" + response.body().toString());		

		logger.info("Product Type received from Api : " +  productType);
		logger.info("Expected product type : " +  data.get("expectedProductType"));
		
		//Validate productType and status code are matching with expected values
		Assert.assertEquals(productType, data.get("expectedProductType"));
		Assert.assertEquals(statusCode, (int)Double.valueOf(data.get("expectedStatusCode")).doubleValue());
	}
	
	/*
	 * Validate that in the initial POST request, if a different loanAppUuid is
	 * provided (that doesn't exist in our system) - the API response is a 404
	 * (NOT_FOUND)
	 */
	@Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "user_data_dp")
	public void verifyLoanAppNotExistsTest(Hashtable<String, String> data) {
		logger.info("Running testcase to verify if Loan application does not exist (passing wrong loan UUID)...");
		
		//request payload with non-existent uuid
		ResumeRequest resumeRequest = createResumeRequest(data);
		
		//request headers
		Map<String,String> headers = new HashMap<>();		
		headers.put("x-cf-source-id", data.get("x-cf-source-id"));
		headers.put("x-cf-corr-id", data.get("x-cf-corr-id"));
		
		String contentType = "application/x-www-form-urlencoded; charset";

		//making a post call
		Response response = RestResourceUtil.post(ApiConstants.API_RESUME_URL, contentType, headers, resumeRequest);				
		
		//storing the error code for validation
		int statusCode = response.getStatusCode();
		logger.info("Response status code: " + statusCode);
		logger.debug("Response Json: \n" + response.body().toString());
		
		//validate the error code
		Assert.assertEquals(statusCode, (int)Double.valueOf(data.get("expectedStatusCode")).doubleValue());
	}

	private ResumeRequest createResumeRequest(Hashtable<String, String> data){
		ResumeRequest resumeRequest = new ResumeRequest();
		resumeRequest.setLoanAppUuid(data.get("loanAppUuid"));
		resumeRequest.setSkipSideEffects(Boolean.parseBoolean(data.get("skipSideEffects")));
		return resumeRequest;
	}
	
}
