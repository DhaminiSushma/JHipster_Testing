package com.epam.api.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccManagement {
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
    private String[] authorities;
    private String password;
    public AccManagement(AccManagemnetBuilder builder){
        this.id= builder.id;
        this.login=builder.login;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.email=builder.email;
        this.imageUrl=builder.imageUrl;
        this.activated= builder.activated;
        this.langKey=builder.langKey;
        this.createdBy=builder.createdBy;
        this.createdDate=builder.createdDate;
        this.lastModifiedBy= builder.lastModifiedBy;
        this.lastModifiedDate= builder.lastModifiedDate;
        this.authorities= builder.authorities;
        this.password=builder.password;
    }
    static class AccManagemnetBuilder{
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
        private String[] authorities;
        private String password;

        AccManagemnetBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        AccManagemnetBuilder withLogin(String login) {
            this.login = login;
            return this;
        }

        AccManagemnetBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        AccManagemnetBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        AccManagemnetBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        AccManagemnetBuilder withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        AccManagemnetBuilder withActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        AccManagemnetBuilder withLangKey(String langKey) {
            this.langKey = langKey;
            return this;
        }

        AccManagemnetBuilder withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        AccManagemnetBuilder withCreatedDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        AccManagemnetBuilder withLastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return this;
        }

        AccManagemnetBuilder withLastModifiedDate(String lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        AccManagemnetBuilder withAuthorities(String[] authorities) {
            this.authorities = authorities;
            return this;
        }

        AccManagemnetBuilder withPassword(String password) {
            this.password = password;
            return this;
        }
        AccManagement build(){
            return new AccManagement(this);
        }
    }
}
