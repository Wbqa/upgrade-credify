package com.upgrade.automation.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BorrowerResumptionInfo {
    private String firstName;
    private String maskedEmail;
    private String ssnRequired;
    private String state;
    private String email;

    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMaskedEmail() {
		return maskedEmail;
	}
	public void setMaskedEmail(String maskedEmail) {
		this.maskedEmail = maskedEmail;
	}
	public String getSsnRequired() {
		return ssnRequired;
	}
	public void setSsnRequired(String ssnRequired) {
		this.ssnRequired = ssnRequired;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "BorrowerResumptionInfo [firstName=" + firstName + ", maskedEmail=" + maskedEmail + ", ssnRequired="
				+ ssnRequired + ", state=" + state + ", email=" + email + "]";
	}
}
