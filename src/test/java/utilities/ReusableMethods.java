package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.geom.RectangularShape;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReusableMethods {

    public static String getFirstCellData(String filePath,Integer rowNumber,Integer cellNumber) {
        String cellData = null;
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // İlk sayfayı seç
            Row row = sheet.getRow(rowNumber);            // İlk satırı seç (index 0)
            Cell cell = row.getCell(cellNumber);           // İlk hücreyi seç (index 0)
            cellData = cell.toString();           // Hücre verisini al

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return cellData;
    }


    public static String takeID(Response response){
        JsonPath jsonPath = response.jsonPath();

       return jsonPath.getString("id");
    }

    public  static Map<String,String> createMap(String name){
        Map<String,String> boards=new HashMap<>();
        boards.put("name",name);
        boards.put("key",ConfigurationReader.getProperty("apiKey"));
        boards.put("token",ConfigurationReader.getProperty("apiToken"));

        return boards;
    }
    public static Map<String, String> createMap(String name, String id, String idKeyName) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("name", name);
        resultMap.put(idKeyName, id); // "idBoard" veya "idList" anahtarını dinamik olarak ekle
        resultMap.put("key", ConfigurationReader.getProperty("apiKey"));
        resultMap.put("token", ConfigurationReader.getProperty("apiToken"));

        return resultMap;
    }

    public  static Map<String,String> deleteMap(){
        Map<String,String> delete=new HashMap<>();
        delete.put("key",ConfigurationReader.getProperty("apiKey"));
        delete.put("token",ConfigurationReader.getProperty("apiToken"));

        return delete;
    }
}
