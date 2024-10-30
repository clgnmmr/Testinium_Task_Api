package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.impl.io.ContentLengthInputStream;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response getRequest(String endpoint) {


        return given().header(
                "Accept", ContentType.JSON
        ).when().get(endpoint);

    }


    public static Response postRequest(String endpoint, Map<String, String> query) {


        return given().headers(
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON
                ).queryParams(query)
                .when().post(endpoint);

    }

    public static Response putRequest(String endpoint, Map<String, String> query) {


        return given().headers(
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON
                ).queryParams(query)
                .when().put(endpoint);

    }
    public static Response deleteRequest(String endpoint, Map<String, String> query) {


        return given().headers(
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON
                ).queryParams(query)
                .when().delete(endpoint);

    }



}