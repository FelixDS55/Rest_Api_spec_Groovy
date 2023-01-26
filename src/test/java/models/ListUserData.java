package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListUserData {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
