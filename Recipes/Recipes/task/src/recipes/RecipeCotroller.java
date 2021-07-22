package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import recipes.model.Recipe;
import recipes.model.User;
import recipes.service.RecipeService;
import recipes.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api")
public class RecipeCotroller {

    private RecipeService recipeService;

    @Autowired
    public RecipeCotroller(RecipeService service, UserService userService) {
        this.recipeService = service;
    }

    @PostMapping(value = "/recipe/new",consumes = "application/json",produces = "application/json")
    public String createRecipe (@Valid @RequestBody Recipe recipe,@AuthenticationPrincipal UserDetails userDetails) {
        recipe.setCreator(userDetails.getUsername());
        recipeService.addRecipe(recipe);
       return recipe.idToJson();
    }


    @GetMapping(value = "/recipe/{id}")
    public Recipe getRecipesById (@PathVariable Long id) {
       return recipeService.findById(id);
    }


    @GetMapping(value = "/recipe/search", params = "category")
    public List<Recipe> searchRecipesByCategory (String category) {
       return recipeService.searchRecipesByCategory(category);
    }


    @GetMapping(value = "/recipe/search", params = "name")
    public List<Recipe> searchRecipesByName (String name) {
        return recipeService.searchRecipesByName(name);
    }


    @DeleteMapping(value = "/recipe/{id}")
    public void deleteRecipeById(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        if (recipeService.findById(id).getCreator().equalsIgnoreCase(userDetails.getUsername())) {
            recipeService.removeRecipe(id);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping(value = "/recipe/{id}")
    public void updateRecipe (@Valid @RequestBody Recipe recipe, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        if (recipeService.findById(id).getCreator().equalsIgnoreCase(userDetails.getUsername())) {
            recipeService.updateRecipe(recipe, id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

}
