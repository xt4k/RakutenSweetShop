package helsi.config.locator;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:pagelocator/search-page.properties")
public interface SearchPageConfig extends Config {

    @Key("search.page.first")
    String searchPageFirst();

    @Key("search.page.second")
    String searchPageSecond();

    @Key("search.page.third")
    String searchPageThird();

}


