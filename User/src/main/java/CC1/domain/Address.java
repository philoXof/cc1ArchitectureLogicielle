package CC1.domain;

public class Address {
    private String postalCode;
    private String addressNumber;
    private String addressLine;
    private String city;
    private String country;

    public Address(String postalCode, String addressNumber, String addressLine, String city, String country) {

        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.addressLine = addressLine;
        this.city = city;
        this.country = country;
    }

    public static Address of(String postalCode, String addressNumber, String addressLine, String city, String country){
        return new Address(postalCode, addressNumber, addressLine, city, country);
    }
    @Override
    public String toString() {
        return "Address :{" +
                "postalCode= '" + postalCode + '\'' +
                ", addressNumber= '" + addressNumber + '\'' +
                ", addressLine= '" + addressLine + '\'' +
                ", city= '" + city + '\'' +
                ", country= '"+ country +'\'' +
                '}';
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
