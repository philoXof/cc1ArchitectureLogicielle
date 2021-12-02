package CC1.domain;



import java.util.Objects;

public final class User {

    private final UserId userId;
    private final String lastname;
    private final String firstname;
    private String password;
    private Address address;

    private User(UserId userId, String lastname, String firstname, String password, Address address) {
        this.userId = userId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
        this.address = address;
    }

    public static User of(UserId userId, String lastname, String firstname, String password, Address address) {
        return new User(userId, lastname, firstname, password, address);
    }

    /*
     public void RegisterCreditCard(CreditCard creditCard){
         this.creditCard = Objects.requireNonNull(creditCard);
     }
    */

    public UserId getUserId() {
        return userId;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    public void changeAddress(Address address){
        this.address = Objects.requireNonNull(address);
    }

    public boolean IsValid(){
        return this.address != null &&
                !Objects.equals(this.firstname, "") &&
                !Objects.equals(this.lastname, "") &&
                !Objects.equals(this.password, "");
    }

    @Override
    public String toString() {
        return "User :{" +
                "userId= '" + userId + '\'' +
                ", lastname= '" + lastname + '\'' +
                ", firstname= '" + firstname + '\'' +
                ", password= '" + password + '\'' +
                ", address= '"+ address.toString() +'\'' +
                '}';
    }
}
