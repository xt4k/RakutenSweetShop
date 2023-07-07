package helsi.enums;

public enum SearchCategory {
    DOCTOR_SPEC("doctor_spec"),
    DOCTOR_NAME("doctor_name"),
    HOSPITAL("hospital_name"),
    DRUG("drug_name");
    final String value;
    SearchCategory(String value) {
        this.value = value;
    }

}
