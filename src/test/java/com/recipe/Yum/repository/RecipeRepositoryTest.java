package com.recipe.Yum.repository;

import com.recipe.Yum.domain.Ingredient;
import com.recipe.Yum.domain.Make;
import com.recipe.Yum.domain.Recipe;
import com.recipe.Yum.domain.User;
import groovy.transform.AutoClone;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class RecipeRepositoryTest {


    @Autowired
    RecipeRepository recipeRepository;

    @Test
    @Transactional
    @Rollback(false)
    void saveRecipe() {

        Recipe recipe = new Recipe();
        User user = new User();
        user.setName("kimin");
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredient = new Ingredient();
        ingredient.setName("재료");
        ingredient.setAmount("많이");
        ingredients.add(0,ingredient);
        Ingredient ingredient2 = new Ingredient();
        ingredient.setName("재료2");
        ingredient.setAmount("많이");
        ingredients.add(1,ingredient2);

        List<Make> manual = new ArrayList<>();
        Make make = new Make();
        make.setNum(1);
        make.setDescription("볶기");
        manual.add(0,make);
        Make make1 = new Make();
        make.setNum(2);
        make.setDescription("섞기");
        manual.add(1,make1);

        recipe.setUser(user);
        recipe.setIngredients(ingredients);
        recipe.setMakes(manual);
        recipe.setTitle("제목");
        recipe.setProtein(10);
        recipe.setSalt(20);
        recipe.setCarbon(39);
        recipe.setCalorie(33);


        //when
        recipeRepository.save(recipe);

        Recipe findRecipe = recipeRepository.findOne(recipe.getId());

        Assertions.assertThat(findRecipe).isEqualTo(recipe);


    }
}