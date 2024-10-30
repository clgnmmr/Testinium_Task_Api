package tests;

import hooks.Hook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utilities.ApiUtils;
import utilities.ConfigurationReader;
import utilities.Log;

import java.util.ArrayList;
import java.util.List;

import static hooks.Hook.*;
import static utilities.ReusableMethods.*;

@ExtendWith(Hook.class)
public class TrelloApiTest {




    @Test
    public void test01() throws InterruptedException {
        Log.startTestCase("User creates a board on Trello and adds data to it");
        String name = faker.name().firstName();
        response = ApiUtils.postRequest(ConfigurationReader.getProperty("base_url") + ConfigurationReader.getProperty("board"), createMap(name));
        Log.info("User enters information to create a board and sends a POST request");

        Assertions.assertEquals(response.getStatusCode(), 200);
        Log.assertLog("User verifies the board was created");


        String idBoard = takeID(response);
        response = ApiUtils.postRequest(ConfigurationReader.getProperty("base_url") + ConfigurationReader.getProperty("list"), createMap(name, idBoard, "idBoard"));
        Log.info("User enters information to create a list and sends a POST request");

        Assertions.assertEquals(response.getStatusCode(), 200);
        Log.assertLog("User verifies the list was created");


        String idList = takeID(response);
        List<String> cardIDList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            response = ApiUtils.postRequest(ConfigurationReader.getProperty("base_url") + ConfigurationReader.getProperty("card"), createMap(name, idList, "idList"));
            cardIDList.add(takeID(response));
        }
        Log.info("User enters information to create cards and sends POST requests");

        Assertions.assertEquals(response.getStatusCode(), 200);
        Log.assertLog("User verifies the cards were created");


        int randomNumber = Hook.random.nextInt(0, cardIDList.size() - 1);
        name = faker.name().firstName();
        response = ApiUtils.putRequest(ConfigurationReader.getProperty("base_url") + ConfigurationReader.getProperty("card") + cardIDList.get(randomNumber), createMap(name));
        Log.info("User enters information to update a selected card and sends a PUT request");

        Assertions.assertEquals(response.getStatusCode(), 200);
        Log.assertLog("User verifies the card information was updated");


        for (String s : cardIDList) {
            response = ApiUtils.deleteRequest(ConfigurationReader.getProperty("base_url") + ConfigurationReader.getProperty("card") + s, deleteMap());
            Assertions.assertEquals(response.getStatusCode(), 200);
        }
        Log.info("User deletes the existing cards");

        response = ApiUtils.deleteRequest(ConfigurationReader.getProperty("base_url") + ConfigurationReader.getProperty("board") + idBoard, deleteMap());
        Assertions.assertEquals(response.getStatusCode(), 200);
        Log.assertLog("User verifies the board was deleted");

    }



}
