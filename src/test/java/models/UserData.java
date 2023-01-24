package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserData {
    String firstNameRequest = "Janet";
    String lastNameRequest = "Weaver";
    String emailRequest = "janet.weaver@reqres.in";
    Integer idRequest = 2;
    @JsonProperty("data")
    private User data;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
