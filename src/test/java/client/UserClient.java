package client;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import model.User;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;

public class UserClient {

    private static final String API_URL = "https://qa-stellarburgers.education-services.ru/api";

    public UserClient() {
        RestAssured.baseURI = API_URL;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Step("Создать пользователя через API")
    public void create(User user) {
        String accessToken = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("/auth/register")
                .then()
                .statusCode(SC_OK)
                .extract()
                .path("accessToken");

        user.setAccessToken(accessToken);
    }

    @Step("Удалить пользователя через API")
    public void delete(User user) {
        if (user.getAccessToken() == null) {
            return;
        }

        RestAssured.given()
                .header("Authorization", user.getAccessToken())
                .when()
                .delete("/auth/user")
                .then()
                .statusCode(SC_ACCEPTED);
    }
}
