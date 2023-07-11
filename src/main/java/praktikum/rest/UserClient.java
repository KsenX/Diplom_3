package praktikum.rest;

import io.restassured.response.ValidatableResponse;
import praktikum.pojo.User;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseClient {
    public ValidatableResponse register(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post("/api/auth/register")
                .then();

    }

    public ValidatableResponse delete(String token) {
        return given()
                .spec(getSpec())
                .auth().oauth2(token.replace("Bearer ", ""))
                .when()
                .delete("/api/auth/user")
                .then();

    }

}
