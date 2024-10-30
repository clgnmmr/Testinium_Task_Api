package pojos.requests;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import utilities.ConfigurationReader;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Boards {
    /*
    {
    "name":"test",
    "key":"",
    "token":""
}
     */
    private String name;
    private String key;
    private String token;

    public Boards() {
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Boards{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
