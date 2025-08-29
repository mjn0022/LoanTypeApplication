package com.nexa.loantypes.dto;

import com.nexa.loantypes.enums.LoanStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class UpdateLoanTypeRequest {

    @NotNull
    private UUID loanTypeId;

    @Size(max = 255) // optional; if provided, validated for length
    private String description;

    // optional; enum restricts allowed values if present
    private LoanStatus status;

    public UpdateLoanTypeRequest() {}

    public UpdateLoanTypeRequest(UUID loanTypeId, String description, LoanStatus status) {
        this.loanTypeId = loanTypeId;
        this.description = description;
        this.status = status;
    }

    public UUID getLoanTypeId() { return loanTypeId; }
    public void setLoanTypeId(UUID loanTypeId) { this.loanTypeId = loanTypeId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LoanStatus getStatus() { return status; }
    public void setStatus(LoanStatus status) { this.status = status; }
}
