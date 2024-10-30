package hooks;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Random;


public class Hook implements  AfterEachCallback,BeforeEachCallback {

    public static Response response;
    public static Faker faker=new Faker();
    public static Random random=new Random();


    @Override
    public void beforeEach(ExtensionContext context) throws InterruptedException {

    }
    @Override
    public void afterEach(ExtensionContext context) throws Exception {

    }


}
