package pojos.response;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardsResponse {

    private String id;
    private String name;

    public BoardsResponse() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BoardsResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
