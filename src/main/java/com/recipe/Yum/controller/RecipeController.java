package com.recipe.Yum.controller;


import com.recipe.Yum.Service.RecipeService;
import com.recipe.Yum.domain.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/recipe/new")
    public String createForm(Model model){
        model.addAttribute("form", new RecipeForm());
        return "createRecipe";
    }

    @PostMapping("/recipe/new")
    public String create(@Valid RecipeForm recipeForm, BindingResult bindingResult, Model model){
        recipeService.saveRecipe(recipeForm);
        return "redirect:/";
    }

    @GetMapping("/recipes")
    public String list(Model model){
        List<Recipe> recipes = recipeService.findRecipes();
        model.addAttribute("recipes",recipes);
        return "recipeList";
    }


}
