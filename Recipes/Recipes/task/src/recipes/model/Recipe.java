package recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    private LocalDateTime date;
    @NotBlank
    private String description;
    @NotNull
    @Size(min = 1)
    private String[] ingredients;
    @NotNull
    @Size(min = 1)
    private String[] directions;
    @JsonIgnore
    private String creator;

    public String idToJson() {
        return "{" +
                "\"id\":" + this.id +
                "}";
    }
}
