package CC1.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class CreditCard {

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

    public static CreditCard of(String cardNumber, Date expirationDate, String creditCardOwner, String cryptogram){
        return new CreditCard(cardNumber,expirationDate,creditCardOwner,cryptogram);
    }

    @Override
    public java.lang.String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-yy");
        return "CreditCard : { " +
                "cardNumber= '" + cardNumber +
                "', expirationDate= '" + formatter.format(this.expirationDate) +
                "', creditCardOwner= '" + creditCardOwner + '\'' +
                "', cryptogram= '" + cryptogram +
                "' }";
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getCreditCardOwner() {
        return creditCardOwner;
    }

    public String getCryptogram() {
        return cryptogram;
    }
}
