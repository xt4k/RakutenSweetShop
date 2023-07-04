package helsi.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:helsi.properties")
public interface LocatorConfig extends Config {

    @Key("mainpage.category.search")
    String mainPageCategorySearch();

    @Key("mainpage.search")
    String mainpageSearch();

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


    @Key("search.doctor.summary")
    String searchDoctorsSummary();


    @Key("searchpage.search.field")
    String searchingField();

    @Key("drug.find")
    String drugFind();

    @Key("search.doctor.name")
    String searchDoctorByName();


}


