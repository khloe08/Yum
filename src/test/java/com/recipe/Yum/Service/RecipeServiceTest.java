package com.recipe.Yum.Service;

import com.recipe.Yum.controller.RecipeForm;
import com.recipe.Yum.domain.*;
import com.recipe.Yum.repository.RecipeRepository;
import org.hibernate.dialect.IngresDialect;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class RecipeServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Test
    void saveRecipe() {
    //given
//        List<Ingredient> ingredients = new ArrayList<>();
//        Ingredient ingredient = new Ingredient();
//        ingredient.setName("재료1");
//        ingredient.setAmount("이만큼");
//        Ingredient ingredient2 = new Ingredient();
//        ingredient.setName("재료2");
//        ingredient.setAmount("저만큼");
//        ingredients.add(ingredient);
//        ingredients.add(ingredient2);
//
//        List<Make> makes = new ArrayList<>();
//        Make make = new Make();
//
//
//
//        RecipeForm form = new RecipeForm();
//        form.setTitle("칼국수");
//        form.setIngredient(ingredients);
//        form.setMake();

    }

    @Test
    void findRecipes() {
    }

    @Test
    void findOneRecipe() {
    }

//    private Recipe createReicpe(String title, List<Make> make, List<Ingredient>ingredients, List<Nutrient>nutrients, LocalDateTime time) {
//        Book book = new Book();
//        book.setName(name);
//        book.setPrice(price);
//        book.setStockQuantity(stockQuantity);
//        em.persist(book);
//        return book;
//    }

    private User createMember() {
        User user = new User();
        user.setName("회원1");
        em.persist(user);
        return user;
    }
}