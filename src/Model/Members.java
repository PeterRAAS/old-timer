package Model;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 11/11/2018<br/>
 * Time: 17:04<br/>
 * To change this template use File | Settings | File Templates.
 */
public class Members {

    private int memberID;
    private String name;
    private String firstName;
    private String street;
    private int number;
    private int zipCode;
    private String city;
    private String country;
    private String phone;
    private String mobile;
    private String email;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public Members(int memberID,String name, String firstName, String street, int number, int zipCode, String city, String country, String phone, String mobile, String email) {
        this.memberID = memberID;
        this.name = name;
        this.firstName = firstName;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
    }

    public Members(){

    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (!name.isEmpty()) {

            this.name = name;
        }
        else{

            throw new IllegalArgumentException("Opslaan mislukt, geen naam ingevuld");

        }
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        if (!firstName.isEmpty()) {
            this.firstName = firstName;
        }
        else{

            throw new IllegalArgumentException("Opslaan mislukt, geen voornaam ingevuld");

        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {

        if (!street.isEmpty()) {

            this.street = street;
        }
        else {
            throw new IllegalArgumentException("Opslaan mislukt, geen straat ingevuld");
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {

        if (number != 0) {

            this.number = number;
        }
        else {
            throw new IllegalArgumentException("Opslaan mislukt, geen nummer ingevuld");
        }

    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {

        if (zipCode != 0) {

            this.zipCode = zipCode;
        }
        else {

            throw new IllegalArgumentException("Opslaan mislukt, geen zipcode ingevuld");
        }

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {

        if (!city.isEmpty()) {

            this.city = city;
        }
        else {
            throw new IllegalArgumentException("Opslaan mislukt, geen stad/dorp ingevuld");
        }

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {

        if (!country.isEmpty()) {

            this.country = country;
        }
        else {
            this.country = "0";
        }

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        if (!phone.isEmpty()) {

            this.phone = phone;
        }
        else {
            this.phone = "0";
        }

    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {

        if (!mobile.isEmpty()) {

            this.mobile = mobile;
        }
        else {
            this.mobile = "0";
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email.matches(EMAIL_PATTERN)) {

            this.email = email;
        }

        else {
            throw new IllegalArgumentException("Opslaan mislukt, geen geldig email adres");
        }

    }

    @Override
    public String toString() {
        return getName() +"," + getFirstName() ;

    }
}
