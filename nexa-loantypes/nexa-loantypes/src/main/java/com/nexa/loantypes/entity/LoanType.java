package com.nexa.loantypes.entity;

import com.nexa.loantypes.enums.LoanStatus;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(
        name = "loan_types",
        schema = "loanschema",
        uniqueConstraints = @UniqueConstraint(name = "uk_loan_types_type", columnNames = "type")
)
public class LoanType {

    @Id
    @Column(name = "loan_type_id", nullable = false, updatable = false)
    private UUID loanTypeId;

    @Column(name = "type", nullable = false, length = 100)
    private String type;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 8)
    private LoanStatus status;

    public LoanType() {
        // JPA
    }

    public LoanType(UUID loanTypeId, String type, String description, LoanStatus status) {
        this.loanTypeId = loanTypeId;
        this.type = type;
        this.description = description;
        this.status = status;
    }

    @PrePersist
    void prePersist() {
        if (this.loanTypeId == null) this.loanTypeId = UUID.randomUUID();
        if (this.status == null) this.status = LoanStatus.active;
    }

    // ----- Getters / Setters -----
    public UUID getLoanTypeId() { return loanTypeId; }
    public void setLoanTypeId(UUID loanTypeId) { this.loanTypeId = loanTypeId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LoanStatus getStatus() { return status; }
    public void setStatus(LoanStatus status) { this.status = status; }

    // ----- Optional: builder pattern (manual) -----
    public static Builder builder() { return new Builder(); }
    public static final class Builder {
        private UUID loanTypeId;
        private String type;
        private String description;
        private LoanStatus status = LoanStatus.active;

        private Builder() {}
        public Builder loanTypeId(UUID id) { this.loanTypeId = id; return this; }
        public Builder type(String t) { this.type = t; return this; }
        public Builder description(String d) { this.description = d; return this; }
        public Builder status(LoanStatus s) { this.status = s; return this; }
        public LoanType build() { return new LoanType(loanTypeId, type, description, status); }
    }

    // ----- Optional: equals/hashCode/toString -----
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanType)) return false;
        LoanType that = (LoanType) o;
        return Objects.equals(loanTypeId, that.loanTypeId);
    }

    @Override
    public int hashCode() { return Objects.hash(loanTypeId); }

    @Override
    public String toString() {
        return "LoanType{" +
                "loanTypeId=" + loanTypeId +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
