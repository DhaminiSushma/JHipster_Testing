package com.epam.api.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class Operation {
    private Integer id;
    private String date;
    private String description;
    private Double amount;
    private String bankAccount;
    private Object[] labels;
    public Operation(OperationBuilder builder){
        this.id=builder.id;
        this.date=builder.date;
        this.description=builder.description;
        this.amount=builder.amount;
        this.bankAccount=builder.bankAccount;
        this.labels=builder.labels;
    }
    static class OperationBuilder{
        private Integer id;
        private String date;
        private String description;
        private Double amount;
        private String bankAccount;
        private Object[] labels;
        OperationBuilder withID(int id){
            this.id=id;
            return this;
        }

        OperationBuilder withDate(String date) {
            this.date = date;
            return this;
        }

        OperationBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        OperationBuilder withAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        OperationBuilder withBankAccount(String bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        OperationBuilder withLabels(Object[] labels) {
            this.labels = labels;
            return this;
        }
        Operation build(){
            return new Operation(this);
        }
    }
}
