package recipes.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import recipes.model.Recipe;
import recipes.repository.RecipeRepository;
import recipes.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class RecipeService {

     private final RecipeRepository recipeRepository;
     private final UserRepository userRepository;

     @Autowired
     public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository) {
          this.recipeRepository = recipeRepository;
          this.userRepository = userRepository;
     }

     public Recipe addRecipe(Recipe recipe) {
          recipe.setDate(LocalDateTime.now().withNano(0));
         return recipeRepository.save(recipe);
     }

     public void removeRecipe(Long id) {
          recipeRepository
                  .findById(id)
                  .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

          recipeRepository.deleteById(id);
          throw new ResponseStatusException(HttpStatus.NO_CONTENT);
     }

     public Recipe findById(Long id) {
          return recipeRepository
                  .findById(id)
                  .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
     }

     public Recipe updateRecipe(Recipe newRecipe, Long id) {
          recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
          return recipeRepository.findById(id)
                  .map(recipe -> {
                       recipe.setName(newRecipe.getName());
                       recipe.setCategory(newRecipe.getCategory());
                       recipe.setIngredients(newRecipe.getIngredients());
                       recipe.setDate(LocalDateTime.now().withNano(0));
                       recipe.setDescription(newRecipe.getDescription());
                       recipe.setIngredients(newRecipe.getIngredients());
                       recipe.setDirections(newRecipe.getDirections());
                       return recipeRepository.save(recipe);
                  })
                  .orElseGet(() -> recipeRepository.save(newRecipe));

     }

     public List<Recipe> searchRecipesByCategory(String category) {
          List<Recipe> listOfRecipes = new ArrayList<>();
          List<Recipe> listOfFoundRecipesByCategory = new ArrayList<>();

          recipeRepository.findAll().forEach(listOfRecipes::add);

          for (Recipe r : listOfRecipes) {
               if (r.getCategory().equalsIgnoreCase(category)) {
                    listOfFoundRecipesByCategory.add(r);
               }
          }

          listOfFoundRecipesByCategory.sort(Comparator.comparing(Recipe::getDate));
          Collections.reverse(listOfFoundRecipesByCategory);

          return listOfFoundRecipesByCategory;
     }

     public List<Recipe> searchRecipesByName(String name) {
          List<Recipe> listOfRecipess = new ArrayList<>();
          List<Recipe> listOfFoundRecipesByName = new ArrayList<>();
          recipeRepository.findAll().forEach(listOfRecipess::add);

          for (Recipe r : listOfRecipess) {
               if (r.getName().toLowerCase().contains(name.toLowerCase())) {
                    listOfFoundRecipesByName.add(r);
               }
          }
          listOfFoundRecipesByName.sort(Comparator.comparing(Recipe::getDate));
          Collections.reverse(listOfFoundRecipesByName);

          return listOfFoundRecipesByName;
     }
}
