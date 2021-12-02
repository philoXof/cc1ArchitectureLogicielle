package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCard {

    private final String cardNumber;
    private final Date expirationDate;
    private final String creditCardOwner;
    private final String cryptogram;

    public CreditCard(String cardNumber, Date expirationDate, String creditCardOwner, String cryptogram) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.creditCardOwner = creditCardOwner;
        this.cryptogram = cryptogram;
    }

    @Override
    public java.lang.String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-yy");
        return "CreditCard{" +
                "cardNumber=" + cardNumber +
                ", expirationDate=" + formatter.format(this.expirationDate) +
                ", creditCardOwner='" + creditCardOwner + '\'' +
                ", cryptogram=" + cryptogram +
                '}';
    }

    public static CreditCard of(String cardNumber, Date expirationDate, String creditCardOwner, String cryptogram){
        return new CreditCard(cardNumber,expirationDate,creditCardOwner,cryptogram);
    }

    public boolean IsValidCreditCard(){
        return IsValidCardNumber() && IsValidCreditCardOwner() && IsValidCryptogram() && IsValidExpirationDate();
    }

    private boolean IsValidExpirationDate() {
        return !this.expirationDate.before(new Date());
    }

    private boolean IsValidCryptogram(){
        return Regex("",this.cryptogram);
    }
    private boolean IsValidCardNumber(){
        String creditCardRegex = "^(?:4[0-9]{12}(?:[0-9]" +
                "{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9]" +
                "[0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]" +
                "|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
        return Regex(creditCardRegex, this.cardNumber);
    }
    private boolean IsValidCreditCardOwner(){
        return !Objects.equals(this.creditCardOwner, "");
    }

    private boolean Regex(String patternRegex, String input){
        Pattern p = Pattern.compile(patternRegex);
        Matcher m = p.matcher(input);
        return m.matches();
    }
    //date valid

}
