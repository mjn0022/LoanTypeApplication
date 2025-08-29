package com.nexa.loantypes.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nexa.loantypes.enums.LoanStatus;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanTypeResponse {
    private UUID loanTypeId;
    private String type;
    private String description;
    private LoanStatus status;

    public LoanTypeResponse() {}

    public LoanTypeResponse(UUID loanTypeId, String type, String description, LoanStatus status) {
        this.loanTypeId = loanTypeId;
        this.type = type;
        this.description = description;
        this.status = status;
    }

    // Optional builder
    public static Builder builder() { return new Builder(); }
    public static final class Builder {
        private UUID loanTypeId;
        private String type;
        private String description;
        private LoanStatus status;
        private Builder() {}
        public Builder loanTypeId(UUID id) { this.loanTypeId = id; return this; }
        public Builder type(String t) { this.type = t; return this; }
        public Builder description(String d) { this.description = d; return this; }
        public Builder status(LoanStatus s) { this.status = s; return this; }
        public LoanTypeResponse build() { return new LoanTypeResponse(loanTypeId, type, description, status); }
    }

    public UUID getLoanTypeId() { return loanTypeId; }
    public void setLoanTypeId(UUID loanTypeId) { this.loanTypeId = loanTypeId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LoanStatus getStatus() { return status; }
    public void setStatus(LoanStatus status) { this.status = status; }
}
