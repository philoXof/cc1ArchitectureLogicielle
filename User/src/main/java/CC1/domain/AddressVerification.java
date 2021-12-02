package CC1.domain;

public interface AddressVerification {
    boolean IsValidAddress(Address address);

    boolean IsValidPostalCode(String postalCode);

    boolean IsValidAddressNumber(String addressNumber);

    boolean IsValidAddressLine(String addressLine);

    boolean IsValidCity(String city);

    boolean IsValidCountry(String country);
}
