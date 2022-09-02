package com.recipe.Yum.Service;


import com.recipe.Yum.controller.RecipeForm;
import com.recipe.Yum.domain.Recipe;
import com.recipe.Yum.domain.User;
import com.recipe.Yum.repository.RecipeRepository;
import com.recipe.Yum.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    //등록
    @Transactional
    public void saveRecipe(RecipeForm recipeform){
        Recipe recipe = recipeform.createRecipe();
        recipeRepository.save(recipe);
    }


    //조회
    public List<Recipe> findRecipes(){
        return recipeRepository.findAll();
    }


    //상세조회
    public Recipe findOneRecipe(Long recipeId){
        return recipeRepository.findOne(recipeId);
    }



}
