package com.epam.api.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
class BankAccount {
    private Integer id;
    private String name;
    private Double balance;
    private Map<String,Object> user;
    private Object[] operations;
    public BankAccount(BankAccountBuilder builder){
        this.id=builder.id;
        this.name= builder.name;
        this.balance=builder.balance;
        this.user=builder.user;
        this.operations= builder.operations;
    }
    static class BankAccountBuilder{
        private Integer id;
        private String name;
        private Double balance;
        private Map<String,Object> user;
        private Object[] operations;
        BankAccountBuilder withId(Integer id) {
            this.id = id;
            return this;
        }
        BankAccountBuilder withName(String name) {
            this.name = name;
            return this;
        }

        BankAccountBuilder withBalance(Double balance) {
            this.balance = balance;
            return this;
        }
        BankAccountBuilder withUser(Map<String,Object> user){
            this.user=user;
            return this;
        }
        BankAccountBuilder withOperations(Object[] operations){
            this.operations=operations;
            return this;
        }
        BankAccount build(){
            return new BankAccount(this);
        }
    }
}
