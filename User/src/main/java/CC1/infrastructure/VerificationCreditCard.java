package CC1.infrastructure;

import CC1.domain.CreditCard;
import CC1.domain.CreditCardVerification;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationCreditCard implements CreditCardVerification {
    @Override
    public boolean IsValidCreditCard(CreditCard creditCard) {
        return IsValidCardNumber(creditCard.getCardNumber()) &&
                IsValidCreditCardOwner(creditCard.getCreditCardOwner()) &&
                IsValidCryptogram(creditCard.getCryptogram()) ;//&&
                //IsValidExpirationDate(creditCard.getExpirationDate());
    }

    @Override
    public boolean IsValidExpirationDate(Date expirationDate) {
        return !expirationDate.before(new Date());
    }

    @Override
    public boolean IsValidCryptogram(String cryptogram) {
        return IsValidFromRegex("^\\d{1,3}$",cryptogram);
    }

    @Override
    public boolean IsValidCardNumber(String cardNumber) {
        String creditCardRegex = "^(?:4[0-9]{12}(?:[0-9]" +
                "{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9]" +
                "[0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]" +
                "|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
        return IsValidFromRegex(creditCardRegex, cardNumber);
    }

    @Override
    public boolean IsValidCreditCardOwner(String cardOwner) {
        return !Objects.equals(cardOwner, "");
    }
    private boolean IsValidFromRegex(String patternRegex, String input){
        Pattern p = Pattern.compile(patternRegex);
        Matcher m = p.matcher(input);
        return m.matches();
    }
}
