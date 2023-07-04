package helsi.helpers;

import helsi.config.Configs;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class SauceLabs {

    public static String videoUrl(String sessionId) {
        String url = format("https://api-cloud.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(Configs.sauceLabs.login(), Configs.sauceLabs.password())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
