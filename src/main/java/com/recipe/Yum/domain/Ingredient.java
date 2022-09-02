package com.recipe.Yum.domain;

import com.recipe.Yum.controller.RecipeForm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String amount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Ingredient createIngredient (String name, String amount) {
        Ingredient ingredient = new Ingredient();
        this.setName(name);
        this.setAmount(amount);
        return ingredient;
    }
}
