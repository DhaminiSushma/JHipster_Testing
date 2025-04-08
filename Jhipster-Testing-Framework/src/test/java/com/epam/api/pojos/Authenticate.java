package com.epam.api.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Authenticate {
    private String username;
    private String password;
    private Boolean rememberMe;
    public Authenticate(AuthenticateBuilder builder){
        this.username=builder.username;
        this.password=builder.password;
        this.rememberMe=builder.rememberMe;
    }
    public static class AuthenticateBuilder{
        private String username;
        private String password;
        private Boolean rememberMe;
        public AuthenticateBuilder withUsername(String username){
            this.username=username;
            return this;
        }
        public AuthenticateBuilder withPassword(String password){
            this.password=password;
            return this;
        }
        public AuthenticateBuilder withRememberMe(Boolean rememberMe){
            this.rememberMe=rememberMe;
            return this;
        }
        public Authenticate build(){
            return new Authenticate(this);
        }
    }
}
