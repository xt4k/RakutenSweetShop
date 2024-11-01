package autotests.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
@AllArgsConstructor
@Data
@Builder
public class BasketOrder {

    private final String currency = "GBP";
    private Sweet chocolateCup;
    private Sweet sherbertDisc;
    private Sweet sherbertStraw;
    private Sweet bonBon;

    public BasketOrder() {
        this.sherbertDisc = new Sweet("Sherbert Discs", 0, 0.95, "UFO's Sherbert Filled Flying Saucers.");
        this.chocolateCup = new Sweet("Chocolate Cups", 0, 1.00, "Candy Chocolate Cups.");
        this.sherbertStraw = new Sweet("Sherbert Straws", 0, 0.75, "Rainbow Dust Straws - Choose your colour.");
        this.bonBon = new Sweet("Bon Bons", 0, 1.00, "Pink Strawberry Bonbons - sugar dusted, strawberry flavoured chewy sweets.");
    }

    public BasketOrder setSherbertDisc(int number) {
        sherbertDisc = Sweet.builder()
                .name("Sherbert Discs")
                .number(number)
                .price(0.95)
                .description("UFO's Sherbert Filled Flying Saucers.")
                .build();
        return this;
    }

    public BasketOrder setChocolateCup(int number) {
        chocolateCup = Sweet.builder()
                .name("Chocolate Cups")
                .number(number)
                .price(1.00)
                .description("Candy Chocolate Cups.")
                .build();
        return this;
    }

    public void setSherbertStraw(int number) {
        sherbertStraw = Sweet.builder()
                .name("Sherbert Straws")
                .number(number)
                .price(0.75)
                .description("Rainbow Dust Straws - Choose your colour.")
                .build();
    }

    public BasketOrder setBonBon(int number) {
        bonBon = Sweet.builder()
                .name("Bon Bons")
                .number(number)
                .price(1.00)
                .description("Pink Strawberry Bonbons - sugar dusted, strawberry flavoured chewy sweets.")
                .build();
        return this;
    }


    public Double getTotalSum() {
        return sherbertDisc.getNumber() * sherbertDisc.getPrice() +
                chocolateCup.getNumber() * chocolateCup.getPrice() +
                sherbertStraw.getNumber() * sherbertStraw.getPrice() +
                bonBon.getNumber() * bonBon.getPrice();


    }
}