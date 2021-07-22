package recipes.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import recipes.model.User;
import recipes.service.UserService;

import javax.validation.Valid;



@RestController
@RequestMapping("/api")
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register",consumes = "application/json",produces = "application/json")
    public void createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h2>Welcome Admin!</h2>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h2>Welcome User!</h2>";
    }

    @GetMapping("/all")
    public String all() {
        return "<h2>Hello Everyone!</h2>";
    }
}
