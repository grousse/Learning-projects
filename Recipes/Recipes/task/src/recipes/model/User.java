package recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = ".{1,16}\\@.{1,16}\\..{1,16}")
    @NotBlank
    private String email;
    @Pattern(regexp = ".{8,}")
    @NotBlank
    private String password;
    private boolean active;
    private String roles = "admin";

}
