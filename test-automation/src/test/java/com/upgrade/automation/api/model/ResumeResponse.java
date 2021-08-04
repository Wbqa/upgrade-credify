
package com.upgrade.automation.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResumeResponse {
    private LoanAppResumptionInfo loanAppResumptionInfo;
    String[] offers;
    private String selectedOffer;
    private String[] requiredAgreements;
    private String[] resetOptions;
    private String originalLoanApp;

    public LoanAppResumptionInfo getLoanAppResumptionInfo() {
		return loanAppResumptionInfo;
	}
	public void setLoanAppResumptionInfo(LoanAppResumptionInfo loanAppResumptionInfo) {
		this.loanAppResumptionInfo = loanAppResumptionInfo;
	}
	public String[] getOffers() {
		return offers;
	}
	public void setOffers(String[] offers) {
		this.offers = offers;
	}
	public String getSelectedOffer() {
		return selectedOffer;
	}
	public void setSelectedOffer(String selectedOffer) {
		this.selectedOffer = selectedOffer;
	}
	public String[] getRequiredAgreements() {
		return requiredAgreements;
	}
	public void setRequiredAgreements(String[] requiredAgreements) {
		this.requiredAgreements = requiredAgreements;
	}
	public String[] getResetOptions() {
		return resetOptions;
	}
	public void setResetOptions(String[] resetOptions) {
		this.resetOptions = resetOptions;
	}
	public String getOriginalLoanApp() {
		return originalLoanApp;
	}
	public void setOriginalLoanApp(String originalLoanApp) {
		this.originalLoanApp = originalLoanApp;
	}
    
    
}
