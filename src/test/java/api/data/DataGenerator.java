package api.data;


import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {

    private final Faker faker = new Faker();

    public String randomUserName() {
        return faker.name().username();
    }
    public String randomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return RandomStringUtils.random( 15, characters);
    }
    public  String randomFirstName() {
        return faker.name().firstName();
    }
    public  String randomLastName() {
        return faker.name().lastName();
    }
}
