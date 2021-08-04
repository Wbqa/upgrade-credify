
package com.upgrade.automation.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResumeRequest {
    @JsonProperty("loanAppUuid")
    private String loanAppUuid;
    @JsonProperty("skipSideEffects")
    private Boolean skipSideEffects;

    public String getLoanAppUuid() {
        return loanAppUuid;
    }

    public void setLoanAppUuid(String loanAppUuid) {
        this.loanAppUuid = loanAppUuid;
    }

    public Boolean getSkipSideEffects() {
        return skipSideEffects;
    }

    public void setSkipSideEffects(Boolean skipSideEffects) {
        this.skipSideEffects = skipSideEffects;
    }
}
