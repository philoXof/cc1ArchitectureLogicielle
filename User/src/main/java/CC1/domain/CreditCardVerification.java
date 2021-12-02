package CC1.domain;

import java.util.Date;

public interface CreditCardVerification {
    boolean IsValidCreditCard(CreditCard creditCard);

    boolean IsValidExpirationDate(Date date);

    boolean IsValidCryptogram(String cryptogram);

    boolean IsValidCardNumber(String cardNumber);

    boolean IsValidCreditCardOwner(String cardOwner);
}
