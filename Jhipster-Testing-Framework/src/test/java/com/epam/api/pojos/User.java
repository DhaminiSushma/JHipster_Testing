package com.epam.api.pojos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
class User {
    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String imageUrl;
    private boolean activated;
    private String langKey;
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private ArrayList<String> authorities;
    private String resetDate;
    public User(UserBuilder builder){
        this.id=builder.id;
        this.login=builder.login;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.email=builder.email;
        this.imageUrl=builder.imageUrl;
        this.activated= builder.activated;;
        this.langKey=builder.langKey;
        this.createdBy=builder.createdBy;
        this.createdDate=builder.createdDate;
        this.lastModifiedBy=builder.lastModifiedBy;
        this.lastModifiedDate=builder.lastModifiedDate;
        this.authorities=builder.authorities;
        this.resetDate=builder.resetDate;
    }
    static class UserBuilder{
        private Integer id;
        private String login;
        private String firstName;
        private String lastName;
        private String email;
        private String imageUrl;
        private boolean activated;
        private String langKey;
        private String createdBy;
        private String createdDate;
        private String lastModifiedBy;
        private String lastModifiedDate;
        private ArrayList<String> authorities;
        private String resetDate;
        UserBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        UserBuilder withLogin(String login) {
            this.login = login;
            return this;
        }

        UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        UserBuilder withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        UserBuilder withActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        UserBuilder withLangKey(String langKey) {
            this.langKey = langKey;
            return this;
        }

        UserBuilder withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        UserBuilder withCreatedDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        UserBuilder withLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        UserBuilder withLastModifiedDate(String lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        UserBuilder withAuthorities(ArrayList<String> authorities) {
            this.authorities = authorities;
            return this;
        }
        UserBuilder withResetDate(String resetDate){
            this.resetDate=resetDate;
            return this;
        }
        User build(){
            return new User(this);
        }
    }
}
