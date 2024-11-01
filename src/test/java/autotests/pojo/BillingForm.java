package autotests.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
@AllArgsConstructor
@Data
public class BillingForm {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String countryFirstLetter;

    private String cityFirstLetter;
    private String zip;
    private String nameOnCard;
    private String creditCardNumber;
    private String expiration;
    private String cvv;


    public BillingForm() {
        Faker faker = new Faker();

        firstName = faker.superhero().name();
        lastName = faker.hobbit().character();
        email = faker.internet().emailAddress();
        address = faker.address().fullAddress();
        countryFirstLetter = "u";

        cityFirstLetter = "b";
        zip = "12345";
        nameOnCard = faker.superhero().name() + faker.hobbit().character();
        creditCardNumber = "12345678901234";
        expiration = "12/34";
        cvv = "000";
    }


}