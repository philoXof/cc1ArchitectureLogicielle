package CC1.domain;

import CC1.infrastructure.VerificationCreditCard;

import java.util.List;

public final class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        this.userRepository.save(user);
    }

    public void changePassword(UserId userId, String newPassword) {
        var user = this.userRepository.byId(userId);
        user.changePassword(newPassword);
        this.userRepository.save(user);
    }

    public void changeAddress(UserId userId, Address newAddress){
        var user = this.userRepository.byId(userId);
        user.changeAddress(newAddress);
        this.userRepository.save(user);
    }

    public void payment(UserId userId, CreditCard creditCard){
        var user = this.userRepository.byId(userId);
        VerificationCreditCard checker = new VerificationCreditCard();
        if(this.userRepository.isValidUser(userId)){
            if(checker.IsValidCreditCard(creditCard)){
                System.out.println( user.toString() + ": payement in progress...");
            }else {
                throw new UnsupportedOperationException("Invalid credit card.");
            }
        }else {
            throw new UnsupportedOperationException("Invalid user.");
        }
    }

    public List<User> all() {
        return this.userRepository.findAll();
    }
}
