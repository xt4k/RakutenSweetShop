package helsi.config.locator;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:pagelocator/helsi.properties")
public interface MainPageConfig extends Config {

    @Key("mainpage.category.search")
    String mainPageCategorySearch();

    @Key("popup.category.doctor.type")
    String popupCategoryDoctorType();

    @Key("popup.category.doctor.name")
    String popupCategoryDoctorName();


    @Key("popup.category.drug")
    String popupCategoryDrug();

    @Key("popup.category.hospital")
    String popupCategoryHospital();

    @Key("search.field")
    String searchField();

    @Key("search.find")
    String searchFind();

    @Key("search.result.summary")
    String searchResultSummary();

    @Key("drug.find")
    String drugFind();

    @Key("search.doctor.name")
    String searchDoctorByName();
}