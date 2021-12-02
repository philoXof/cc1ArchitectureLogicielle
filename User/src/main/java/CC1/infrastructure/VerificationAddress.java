package CC1.infrastructure;

import CC1.domain.Address;
import CC1.domain.AddressVerification;

import java.util.Objects;

public class VerificationAddress implements AddressVerification {
    @Override
    public boolean IsValidAddress(Address address) {
        return IsValidAddressLine(address.getAddressLine()) &&
                IsValidAddressNumber(address.getAddressNumber()) &&
                IsValidCity(address.getCity()) &&
                IsValidCountry(address.getCountry()) &&
                IsValidPostalCode(address.getPostalCode());
    }

    @Override
    public boolean IsValidPostalCode(String postalCode) {
        return !Objects.equals(postalCode, "");
    }

    @Override
    public boolean IsValidAddressNumber(String addressNumber) {
        return !Objects.equals(addressNumber,"");
    }

    @Override
    public boolean IsValidAddressLine(String addressLine) {
        return !Objects.equals(addressLine,"");
    }

    @Override
    public boolean IsValidCity(String city) {
        return !Objects.equals(city,"");
    }

    @Override
    public boolean IsValidCountry(String country) {
        return !Objects.equals(country,"");
    }
}
