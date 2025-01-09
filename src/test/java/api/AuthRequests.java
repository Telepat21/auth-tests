package api;

import api.data.userData.UserData;
import api.payload.AuthPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthRequests {

    public static Response registerUser(UserData payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.REGISTER_URL);
    }

    public static Response loginUser(UserData payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.LOGIN_URL);
    }

    public static Response getInfo() {
        return given()
                .header("Authorization", "Bearer " + AuthPayload.getToken())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(Routes.INFO_URL);
    }
}
