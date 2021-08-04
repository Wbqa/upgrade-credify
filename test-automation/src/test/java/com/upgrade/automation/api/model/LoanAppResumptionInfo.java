package com.upgrade.automation.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanAppResumptionInfo {
    private String loanAppId;
    private String loanAppUuid;
    private String referrer;
    private String status;
    private  String productType;
    private String sourceSystem;

    //check if desired amount is a double
    private String desiredAmount;
    private BorrowerResumptionInfo borrowerResumptionInfo;
    private String coBorrowerResumptionInfo;
    private Boolean turnDown;
    private Boolean hasLogin;
    private String[] availableAppImprovements;
    private String cashOutAmount;
    private Boolean canAddCollateral;
    private String rewardProgramId;
    private String rewardProgramCode;
    private String addon;
    private String isMobileDiscountApplied;
    private Boolean checkingDiscountAvailable;

    public String getLoanAppId() {
		return loanAppId;
	}
	public void setLoanAppId(String loanAppId) {
		this.loanAppId = loanAppId;
	}
	public String getLoanAppUuid() {
		return loanAppUuid;
	}
	public void setLoanAppUuid(String loanAppUuid) {
		this.loanAppUuid = loanAppUuid;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getDesiredAmount() {
		return desiredAmount;
	}
	public void setDesiredAmount(String desiredAmount) {
		this.desiredAmount = desiredAmount;
	}
	public BorrowerResumptionInfo getBorrowerResumptionInfo() {
		return borrowerResumptionInfo;
	}
	public void setBorrowerResumptionInfo(BorrowerResumptionInfo borrowerResumptionInfo) {
		this.borrowerResumptionInfo = borrowerResumptionInfo;
	}
	public String getCoBorrowerResumptionInfo() {
		return coBorrowerResumptionInfo;
	}
	public void setCoBorrowerResumptionInfo(String coBorrowerResumptionInfo) {
		this.coBorrowerResumptionInfo = coBorrowerResumptionInfo;
	}
	public Boolean getTurnDown() {
		return turnDown;
	}
	public void setTurnDown(Boolean turnDown) {
		this.turnDown = turnDown;
	}
	public Boolean getHasLogin() {
		return hasLogin;
	}
	public void setHasLogin(Boolean hasLogin) {
		this.hasLogin = hasLogin;
	}
	public String[] getAvailableAppImprovements() {
		return availableAppImprovements;
	}
	public void setAvailableAppImprovements(String[] availableAppImprovements) {
		this.availableAppImprovements = availableAppImprovements;
	}
	public String getCashOutAmount() {
		return cashOutAmount;
	}
	public void setCashOutAmount(String cashOutAmount) {
		this.cashOutAmount = cashOutAmount;
	}
	public Boolean getCanAddCollateral() {
		return canAddCollateral;
	}
	public void setCanAddCollateral(Boolean canAddCollateral) {
		this.canAddCollateral = canAddCollateral;
	}
	public String getRewardProgramId() {
		return rewardProgramId;
	}
	public void setRewardProgramId(String rewardProgramId) {
		this.rewardProgramId = rewardProgramId;
	}
	public String getRewardProgramCode() {
		return rewardProgramCode;
	}
	public void setRewardProgramCode(String rewardProgramCode) {
		this.rewardProgramCode = rewardProgramCode;
	}
	public String getAddon() {
		return addon;
	}
	public void setAddon(String addon) {
		this.addon = addon;
	}
	public String getIsMobileDiscountApplied() {
		return isMobileDiscountApplied;
	}
	public void setIsMobileDiscountApplied(String isMobileDiscountApplied) {
		this.isMobileDiscountApplied = isMobileDiscountApplied;
	}
	public Boolean getCheckingDiscountAvailable() {
		return checkingDiscountAvailable;
	}
	public void setCheckingDiscountAvailable(Boolean checkingDiscountAvailable) {
		this.checkingDiscountAvailable = checkingDiscountAvailable;
	}

}
