package CC1;



import CC1.domain.*;
import CC1.infrastructure.InMemoryUserRepository;
import CC1.infrastructure.VerificationCreditCard;

import java.util.Date;
import java.util.List;

public final class Main {

    public static void main(String[] args) {

        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);

        final UserId myUserId = userRepository.nextIdentity();
        final UserId myUserId2 = userRepository.nextIdentity();

        createUser(userService, myUserId, Address.of("79000","9","rue du bateau", "Paris","France"));
        createUser(userService, myUserId2, Address.of("75000","7","rue du chien", "Marseille","France"));

        changePassword(userService, myUserId2);
        changeAddress(userService,myUserId);
        printAllUsers(userService);

        CreditCard creditCard =  createCreditCard();
        payment(userService,myUserId,creditCard);
    }

    
    //4929573268781875	423	03/2022	Jesse Navarro
    //5474824997633960	552	04/2020	Sara Burton
    //5439433765809218	525	06/2023	Mary Hart
    private static CreditCard createCreditCard(){
        CreditCardVerification checker = new VerificationCreditCard();
        CreditCard creditCard = CreditCard.of("4929573268781875",new Date(),"Jesse Navarro","423");
        System.out.println(creditCard);
        return checker.IsValidCreditCard(creditCard) ? creditCard : null;
    }

    private static void payment(UserService userService,UserId userid, CreditCard creditcard){
        userService.payment(userid, creditcard);
    }
    private static void createUser(UserService userService, UserId myUserId, Address address) {
        User user = User.of(myUserId, "Jehanno", "lucas", "hehe", address);
        if(user.IsValid()){
            userService.create(user);
        }else{
            throw new UnsupportedOperationException("Invalid user.");
        }
    }

    private static void changePassword(UserService userService, UserId myUserId) {
        userService.changePassword(myUserId, "NEWPASSWORD");
    }

    private static void changeAddress(UserService userService, UserId userId){
        Address newAddress = Address.of("78000","8","rue du chat", "Lyon","France");
        userService.changeAddress(userId,newAddress);
    }

    private static void printAllUsers(UserService userService) {
        System.out.println("List all users");

        final List<User> users = userService.all();
        users.forEach(System.out::println);
    }
}
