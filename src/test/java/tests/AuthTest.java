package tests;

import api.data.userData.UserCredentials;
import api.payload.AuthPayload;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthTest {

    Response response;

    @Test
    public void test1_registerUserTest() {
        AuthPayload payload = new AuthPayload();
        response = payload.createUser();
        response.then().log().all();

        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void test2_loginTest() {
        AuthPayload payload = new AuthPayload();
        response = payload.login();
        response.then().log().all();

        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void test3_getInfoTest() {
        AuthPayload payload = new AuthPayload();
        response = payload.getInfo();
        response.then().log().all();

        Assert.assertEquals(200, response.statusCode());
    }
}
