package org.example;

import java.util.Objects;

public class User {
    private final String userId;
    private final String firstName;
    private final String lastName;
    private String email;
    private String password;

    public User(String userId, String firstName, String lastName, String email, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    //public void changeCreditCard(CreditCard creditCard){this.creditCard = Objects.requireNonNull(creditCard);}

    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email);
    }

    public String getUserId() {
        return userId;
    }

    public void changePassword(String newPassword){
        this.password = Objects.requireNonNull(newPassword);
    }

    @Override
    public String toString(){
        return "User:{ " +
                "userId: " + this.userId + ", " +
                "firstName: " + this.firstName + ", " +
                "lastName: " + this.lastName + ", " +
                "email: " + this.email + ", " +
                "password: " + this.password + " " +
                "}";
    }

}
