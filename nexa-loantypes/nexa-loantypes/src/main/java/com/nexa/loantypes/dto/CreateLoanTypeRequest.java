package com.nexa.loantypes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateLoanTypeRequest {

    @NotBlank(message = "loan type is required")
    @Size(max = 100)
    private String type;

    @NotBlank(message = "loan description can not be empty")
    @Size(max = 255)
    private String description;

    public CreateLoanTypeRequest() {}

    public CreateLoanTypeRequest(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
