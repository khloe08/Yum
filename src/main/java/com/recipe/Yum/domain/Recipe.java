package com.recipe.Yum.domain;

import com.recipe.Yum.controller.RecipeForm;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Recipe {

    @Id
    @GeneratedValue
    @Column(name="recipe_id")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Make> makes = new ArrayList<>();

    @Column(name = "calorie")
    private Integer calorie;

    @Column(name = "carbon")
    private Integer carbon;

    @Column(name = "protein")
    private Integer protein;

    @Column(name = "salt")
    private Integer salt;

    private LocalDateTime recipeDate;

    public Recipe createRecipe(RecipeForm form){
        Recipe recipe = new Recipe();
        recipe.setId(form.getId());
        recipe.setTitle(form.getTitle());
        recipe.setIngredients(form.getIngredient());
        recipe.setMakes(form.getMake());
        recipe.setCalorie(form.getCalorie());
        recipe.setCarbon(form.getCarbon());
        recipe.setProtein(form.getProtein());
        recipe.setSalt(form.getSalt());
        recipe.setRecipeDate(form.getTime());
        return recipe;
    }


}
