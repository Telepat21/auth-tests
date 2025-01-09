package api.payload;

import api.AuthRequests;
import api.data.DataGenerator;
import api.data.userData.UserCredentials;
import api.data.userData.UserData;
import io.restassured.response.Response;

import java.util.List;

public class AuthPayload {

    private final DataGenerator dataGenerator;
    private static final UserCredentials userCredentials;
    private static String token;

    static {
        DataGenerator dataGenerator = new DataGenerator();
        userCredentials = new UserCredentials(dataGenerator.randomUserName(), dataGenerator.randomPassword());
    }

    public AuthPayload() {
        this.dataGenerator = new DataGenerator();
    }

    public Response createUser() {
        return AuthRequests.registerUser(createUserPayload());
    }

    public Response login() {
        Response response = AuthRequests.loginUser(loginPayload());
        token = response.jsonPath().getString("token");
        return response;
    }

    public Response getInfo() {
        return AuthRequests.getInfo();
    }

    public static String getToken() {
        return token;
    }

    private UserData createUserPayload() {
        UserData createUserPayload = new UserData();

        createUserPayload.setUsername(userCredentials.getUsername());
        createUserPayload.setPassword(userCredentials.getPassword());
        createUserPayload.setFirstName(dataGenerator.randomFirstName());
        createUserPayload.setLastName(dataGenerator.randomLastName());

        return createUserPayload;
    }

    private UserData loginPayload() {
        UserData loginPayload = new UserData();

        loginPayload.setUsername(userCredentials.getUsername());
        loginPayload.setPassword(userCredentials.getPassword());

        return loginPayload;
    }
}
